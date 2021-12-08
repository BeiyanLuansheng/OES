package org.oes.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainGateController {

    @GetMapping("/gate")
    public String log() {
        return "gate";
    }
}
