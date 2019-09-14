package com.voider.socialapi.service;

import com.voider.socialapi.http.exception.ConversationMatchException;
import com.voider.socialapi.model.Conversation;
import com.voider.socialapi.model.User;
import com.voider.socialapi.repository.ConversationRepositoryImpl;
import com.voider.socialapi.repository.UserRepositoryImpl;
import com.voider.socialapi.util.ErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private UserRepositoryImpl _userRepository;
    @Autowired
    private ConversationRepositoryImpl _conversationRepositoryImpl;

    @Override
    public Conversation createRequestConversation(Conversation conversation,String user_name) {

        User user = _userRepository.getUserByEmail(user_name);

        conversation.setId_user_creator(user.getId_user());

        Conversation tmpConversation = _conversationRepositoryImpl.getConversation(conversation.getId_user_creator(),conversation.getId_user_invited());

        if(conversation.getId_user_invited().equals(user.getId_user())) throw new ConversationMatchException(ErrorUtil.CONVERSATION_WITH_YOURSELF);

        if(tmpConversation != null)  return tmpConversation;

        _conversationRepositoryImpl.createConversationRequest(conversation);

        return conversation;
    }

    @Override
    public void acceptRequestConversation(Long id,String user_name) {

        if(isValidConversation(id,user_name)) throw new ConversationMatchException(ErrorUtil.CONVERSATION_ACCESS_DENIED);

        _conversationRepositoryImpl.updateConversationRequest(id,true);
    }

    @Override
    public void setConversationUUID(Long id,String uuid,String user_name) {

        if(isValidConversation(id,user_name)) throw new ConversationMatchException(ErrorUtil.CONVERSATION_ACCESS_DENIED);

        _conversationRepositoryImpl.setConversationUUID(id,uuid);
    }

    @Override
    public void blockRequestConversation(Long id,String user_name) {

        if(isValidConversation(id,user_name)) throw new ConversationMatchException(ErrorUtil.CONVERSATION_ACCESS_DENIED);

        _conversationRepositoryImpl.updateConversationRequest(id,false);
    }

    @Override
    public void updateLastMessage(Long id,String message,String user_name) {

        if(isValidConversation(id,user_name)) throw new ConversationMatchException(ErrorUtil.CONVERSATION_ACCESS_DENIED);

        _conversationRepositoryImpl.updateLastMessage(id,message);
    }

    private Boolean isValidConversation(Long id,String user_name){
        User user = _userRepository.getUserByEmail(user_name);

        return _conversationRepositoryImpl.getValidConversation(id,user.getId_user()) == null;
    }
}
