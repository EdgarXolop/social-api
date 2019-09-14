package com.voider.socialapi.service;

import com.voider.socialapi.model.Conversation;

public interface ConversationService {

    Conversation createRequestConversation(Conversation conversation,String user_name);
    void acceptRequestConversation(Long id,String user_name);
    void blockRequestConversation(Long id,String user_name);
    void setConversationUUID(Long id,String uuid,String user_name);
    void updateLastMessage(Long id, String message,String user_name);

}
