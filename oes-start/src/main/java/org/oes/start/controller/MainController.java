package org.oes.start.controller;

import org.oes.start.config.Config;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MainController {

    @Resource
    Config config;

    @GetMapping("/config")
    public String getConfig() {
        System.out.println(config.getEnv());
        return config.getEnv();
    }
}
