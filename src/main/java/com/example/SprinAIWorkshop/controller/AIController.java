package com.example.SprinAIWorkshop.controller;

import com.example.SprinAIWorkshop.service.AudioService;
import com.example.SprinAIWorkshop.service.ChatService;
import com.example.SprinAIWorkshop.service.imageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

    @Autowired
    ChatService service;

    @Autowired
    imageService imgService;

    @Autowired
    AudioService audioService;

   @GetMapping("/ask-ai")
   public String askAI(@RequestParam String prompt){
       return service.askAI(prompt);
   }

    @GetMapping("/generate-image")
    public String generateImage(@RequestParam String prompt){
        return imgService.generateImage(prompt);
    }

    @GetMapping("/generate-audio")
    public String generateAudio(@RequestParam String prompt){
        return audioService.generateAudio(prompt);
    }

}
