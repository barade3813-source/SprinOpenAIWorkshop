package com.example.SprinAIWorkshop.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    ChatModel chatModel;
    public ChatService(ChatModel chatModel){
        this.chatModel = chatModel;
    }

    public String askAI(String prompt){

        ChatResponse response = chatModel.call(
                new Prompt(prompt,
                        OpenAiChatOptions.builder()
                                .model("gpt-5.1")
                                .maxCompletionTokens(150)
                                .temperature(0.7)
                                .build()

                ));
        System.out.println(response);
        return response.getResult().getOutput().getText();
    }
}
