package com.springcloud.demo.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 控制层访问
 *
 * @author FLY
 * @date 2020-04-20 13:55
 */
@RestController
@RequestMapping("/client")
public class TestConfigController {

    @Value("${user.name}")
    private String userName;

    @GetMapping("/getName")
    public String getUserName(){
        return userName;
    }

    @PostMapping("/postName")
    public String postName(@RequestBody Map<String,String> param){
        return param.get("name");
    }
}
