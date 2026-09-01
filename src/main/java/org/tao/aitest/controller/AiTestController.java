package org.tao.aitest.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tao.aitest.app.AiApp;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/AIChat")
public class AiTestController {

    @Resource
    private AiApp aiApp;

    @PostMapping("/getAiTestResult")
    public  String getAiTestResult(String input){
        return "hello world";
    }

    @PostMapping("/chat/sync")
    public  String chat(String input,String chatId){
        return aiApp.doChat(input,chatId);
    }
    @PostMapping("/chat/stream")
    public Flux<String> chatStream(String input, String chatId){
        return aiApp.doChatScream(input,chatId);
    }
}
