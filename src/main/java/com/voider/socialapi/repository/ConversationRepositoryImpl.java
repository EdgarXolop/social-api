package com.voider.socialapi.repository;

import com.voider.socialapi.model.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConversationRepositoryImpl {

    @Autowired
    ConversationRepository _conversationRepository;

    public Conversation createConversationRequest(Conversation conversation){

        _conversationRepository.save(conversation);

        return conversation;
    }

    public void updateConversationRequest(Long id, boolean accepted){

        _conversationRepository.updateConversationRequest(id,accepted);

    }

    public void updateLastMessage(Long id, String message){

        _conversationRepository.setLastMessage(id,message);

    }

}
