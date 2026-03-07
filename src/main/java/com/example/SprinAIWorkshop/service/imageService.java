package com.example.SprinAIWorkshop.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class imageService {

    OpenAiImageModel imageModel;
    public imageService( OpenAiImageModel imageModel){
        this.imageModel = imageModel;
    }

    public String generateImage(String prompt){
        OpenAiImageOptions imageOptions = OpenAiImageOptions.builder()
                .quality("hd")
                .N(1)
                .height(1024)
                .width(1024)
                .build();

        ImageResponse response = imageModel.call(new ImagePrompt(prompt, imageOptions));
        return response.getResult().getOutput().getUrl();

    }

}
