package com.voider.socialapi.repository;

import com.voider.socialapi.model.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class ConversationRepositoryImpl {

    @Autowired
    ConversationRepository _conversationRepository;

    public Conversation createConversationRequest(Conversation conversation){

        _conversationRepository.save(conversation);

        return conversation;
    }

    @Transactional
    public void updateConversationRequest(Long id, boolean accepted){

        _conversationRepository.updateConversationRequest(id,accepted);

    }

    @Transactional
    public void updateLastMessage(Long id, String message){

        _conversationRepository.setLastMessage(id,message);

    }

    @Transactional
    public void setConversationUUID(Long id, String uuid){

        _conversationRepository.setConversationUUID(id,uuid);

    }

    public Conversation getConversation(Long id_user_creator, Long id_user_invited){

        Optional<Conversation> conversation = _conversationRepository.getConversation(id_user_creator,id_user_invited);

        if(!conversation.isPresent()) return null;

        return conversation.get() ;
    }

    public Conversation getValidConversation(Long id_conversation,Long id_user){

        Optional<Conversation> conversation = _conversationRepository.getValidConversation(id_conversation,id_user);

        if(!conversation.isPresent()) return null;

        return conversation.get();
    }

    public List<Conversation> findMyConversations(Long id_user, int page_size, int page){

        Pageable pageable = PageRequest.of(page-1, page_size);

        return  _conversationRepository.findMyConversations(id_user,pageable);
    }

}
