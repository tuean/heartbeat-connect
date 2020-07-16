package com.tuean.platform.web;


import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {


    @RequestMapping(value = "/heart_beat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public JsonObject run(@RequestBody JsonObject jsonObject) {
        if (jsonObject == null) return null;
    }



}
