package com.voider.socialapi.controller;

import com.voider.socialapi.dto.ConversationDTO;
import com.voider.socialapi.model.Conversation;
import com.voider.socialapi.service.ConversationServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    @Autowired
    ConversationServiceImpl _conversationService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

}
