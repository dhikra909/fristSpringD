package com.example.firstSpringDemo.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackClient {

        public String sendMessage(String text) {
            return "done";
//            return WebClient.create().post()
//                    .uri("https://hooks.slack.com/services/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")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .bodyValue(new SlackPayload(text))
//                    .retrieve()
//                    .bodyToMono(String.class)
//                    .block();


    }
}
