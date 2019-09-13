package com.voider.socialapi.repository;

import com.voider.socialapi.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository
        extends JpaRepository<Conversation, Long> {


    @Modifying
    @Query("UPDATE Conversation c SET c.accepted = :accepted , c.standby_mode = false WHERE c.id_conversation = :id_conversation")
    int updateConversationRequest(@Param("id_conversation") Long id_conversation, @Param("accepted") boolean accepted);

    @Modifying
    @Query("UPDATE Conversation c SET c.last_message = :last_message WHERE c.id_conversation = :id_conversation")
    int setLastMessage(@Param("id_conversation") Long id_conversation, @Param("last_message") String last_message);

}
