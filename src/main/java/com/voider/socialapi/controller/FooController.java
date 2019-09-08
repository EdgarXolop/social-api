package com.voider.socialapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class FooController {

    @GetMapping(value = "/foos/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public  HashMap<String,Long> findById(@PathVariable long id) {
        HashMap<String,Long> foo_data = new HashMap<>();

        foo_data.put("foo_id",id);

        return foo_data;
    }
}