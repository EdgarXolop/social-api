package com.voider.socialapi.controller;

import com.voider.socialapi.dto.PostDTO;
import com.voider.socialapi.model.Post;
import com.voider.socialapi.service.PostServiceImpl;
import com.voider.socialapi.util.Constants;
import com.voider.socialapi.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostServiceImpl _posPostService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HashMap<String,Object>> getPosts(@Nullable @RequestParam("page") Integer page, @Nullable @RequestParam Integer page_size){

        HashMap<String,Object> response = new HashMap<>();

        int paramPageSize = (page_size == null) ? Constants.PAGE_SIZE : page_size.intValue();
        int paramPage = (page == null) ? Constants.PAGE : page.intValue();
        List<Post> results = _posPostService.getPosts(paramPageSize,paramPage );
        List<PostDTO> page_results = ObjectMapperUtils.mapAll(results, PostDTO.class);

        response.put("page",paramPage);
        response.put("data",page_results);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PostDTO> getPost(@PathVariable Long id, Authentication authentication){

        Post post = _posPostService.getPostById(id);

        ModelMapper modelMapper = new ModelMapper();

        PostDTO postDTO = modelMapper.map(post,PostDTO.class);

        return  new ResponseEntity<>(postDTO, HttpStatus.ACCEPTED);

    }

    @GetMapping(value =  "/own",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HashMap<String,Object>> getMyPosts(@Nullable @RequestParam("page") Integer page, @Nullable @RequestParam Integer page_size, Authentication authentication){

        HashMap<String,Object> response = new HashMap<>();

        int paramPageSize = (page_size == null) ? Constants.PAGE_SIZE : page_size.intValue();
        int paramPage = (page == null) ? Constants.PAGE : page.intValue();
        List<Post> results = _posPostService.getMyPosts(authentication.getName(),paramPageSize,paramPage );
        List<PostDTO> page_results = ObjectMapperUtils.mapAll(results, PostDTO.class);

        response.put("page",paramPage);
        response.put("data",page_results);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody Post post, Authentication authentication){

        post = _posPostService.createPost(post, authentication.getName());

        ModelMapper modelMapper = new ModelMapper();

        PostDTO postDTO = modelMapper.map(post,PostDTO.class);

        return  new ResponseEntity<>(postDTO, HttpStatus.ACCEPTED);

    }

    @PutMapping( produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody Post post, Authentication authentication){

        post = _posPostService.updatePost(post, authentication.getName());

        ModelMapper modelMapper = new ModelMapper();

        PostDTO postDTO = modelMapper.map(post,PostDTO.class);

        return  new ResponseEntity<>(postDTO, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id, Authentication authentication){

        Post post = _posPostService.getPostById(id);

        _posPostService.deletePost(post,authentication.getName());

        ModelMapper modelMapper = new ModelMapper();

        PostDTO postDTO = modelMapper.map(post,PostDTO.class);

        return  new ResponseEntity<>(postDTO, HttpStatus.ACCEPTED);

    }

}
