package org.tao.aitest.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class AiApp {

    private final ChatClient chatClient;

    public AiApp(ChatModel dashboardChatModel) {
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .maxMessages(10)
                .build();
        chatClient = ChatClient.builder(dashboardChatModel)
                .defaultSystem("")
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                )
                .build();
    }


    public String doChat(String message, String chatId) {
        ChatResponse chatResponse= chatClient
                .prompt()
                .user(message)
                .advisors()
                .call().chatResponse();
        return extractContent(chatResponse);
    }

    public Flux<String> doChatScream(String message, String chatId) {

        return chatClient
                .prompt()
                .user(message)
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,chatId))
                .stream()
                .content();
    }
    public String extractContent(ChatResponse chatResponse){
    return chatResponse.getResult().getOutput().getText();
    }
}
