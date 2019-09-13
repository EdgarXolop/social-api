package com.voider.socialapi.service;

import com.voider.socialapi.model.Conversation;
import com.voider.socialapi.model.User;
import com.voider.socialapi.repository.ConversationRepositoryImpl;
import com.voider.socialapi.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private UserRepositoryImpl _userRepository;
    @Autowired
    private ConversationRepositoryImpl _conversationRepositoryImpl;

    @Override
    public Conversation createRequestConversation(Conversation conversation,String user_name) {

        User user = _userRepository.getUserByEmail(user_name);

        if(conversation.getId_user_invited().equals(user.getId_user())){}

        _conversationRepositoryImpl.createConversationRequest(conversation);

        return null;
    }

    @Override
    public void acceptRequestConversation(Long id) {
        _conversationRepositoryImpl.updateConversationRequest(id,true);
    }

    @Override
    public void blockRequestConversation(Long id) {
        _conversationRepositoryImpl.updateConversationRequest(id,false);
    }

    @Override
    public void updateLastMessage(Long id,String message) {
        _conversationRepositoryImpl.updateLastMessage(id,message);
    }
}
