package com.voider.socialapi.controller;

import com.voider.socialapi.dto.ConversationDTO;
import com.voider.socialapi.model.Conversation;
import com.voider.socialapi.service.ConversationServiceImpl;
import com.voider.socialapi.util.Constants;
import com.voider.socialapi.util.ObjectMapperUtils;
import org.apache.tomcat.util.bcel.Const;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    @Autowired
    ConversationServiceImpl _conversationService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HashMap<String,Object>> getConversations(@Nullable @RequestParam("page") Integer page, @Nullable @RequestParam Integer page_size, Authentication authentication){

        HashMap<String,Object> response = new HashMap<>();

        int paramPageSize = (page_size == null) ? Constants.PAGE_SIZE : page_size.intValue();
        int paramPage = (page == null) ? Constants.PAGE : page.intValue();
        List<Conversation> results = _conversationService.findMyConversations(authentication.getName(),paramPageSize,paramPage );
        List<ConversationDTO> page_results = ObjectMapperUtils.mapAll(results, ConversationDTO.class);

        response.put("page",paramPage);
        response.put("data",results);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ConversationDTO> createConversation(@Valid @RequestBody Conversation conversation, Authentication authentication){

        conversation = _conversationService.createRequestConversation(conversation, authentication.getName());

        ModelMapper modelMapper = new ModelMapper();

        ConversationDTO conversationDTO = modelMapper.map(conversation,ConversationDTO.class);

        return  new ResponseEntity<>(conversationDTO, HttpStatus.ACCEPTED);

    }


    @PostMapping("/{id}/accept")
    public ResponseEntity<String> acceptConversation(@PathVariable Long id, Authentication authentication){

        _conversationService.acceptRequestConversation(id, authentication.getName());

        return  new ResponseEntity<>("", HttpStatus.ACCEPTED);

    }

    @PostMapping("/{id}/preview")
    public ResponseEntity<String> updateLastMessage(@PathVariable Long id, @PathParam("last_message") String last_message, Authentication authentication){

        _conversationService.updateLastMessage(id,last_message, authentication.getName());

        return  new ResponseEntity<>("", HttpStatus.ACCEPTED);

    }

    @PostMapping("/{id}/uuid")
    public ResponseEntity<String> setConversationUUID(@PathVariable Long id, @PathParam("uuid") String uuid, Authentication authentication){

        _conversationService.setConversationUUID(id, uuid, authentication.getName());

        return  new ResponseEntity<>("", HttpStatus.ACCEPTED);

    }

}
