package com.voider.socialapi.service;

import com.voider.socialapi.model.Conversation;

public interface ConversationService {

    Conversation createRequestConversation(Conversation conversation,String user_name);
    void acceptRequestConversation(Long id);
    void blockRequestConversation(Long id);
    void updateLastMessage(Long id, String message);

}
