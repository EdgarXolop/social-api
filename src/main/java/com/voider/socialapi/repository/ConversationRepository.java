package com.voider.socialapi.repository;

import com.voider.socialapi.model.Conversation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationRepository
        extends JpaRepository<Conversation, Long> {


    @Modifying
    @Query("UPDATE Conversation c SET c.accepted = :accepted , c.standby_mode = false WHERE c.id_conversation = :id_conversation")
    int updateConversationRequest(@Param("id_conversation") Long id_conversation, @Param("accepted") boolean accepted);

    @Modifying
    @Query("UPDATE Conversation c SET c.last_message = :last_message WHERE c.id_conversation = :id_conversation")
    int setLastMessage(@Param("id_conversation") Long id_conversation, @Param("last_message") String last_message);

    @Modifying
    @Query("UPDATE Conversation c SET c.uuid = :uuid WHERE c.id_conversation = :id_conversation")
    int setConversationUUID(@Param("id_conversation") Long id_conversation, @Param("uuid") String uuid);


    @Query("FROM Conversation WHERE (id_user_creator = :id_user_creator AND id_user_invited = :id_user_invited ) OR (id_user_creator = :id_user_invited AND id_user_invited = :id_user_creator )")
    Optional<Conversation> getConversation(Long id_user_creator, Long id_user_invited);


    @Query("FROM Conversation WHERE (id_user_creator = :id_user OR id_user_invited = :id_user ) AND id_conversation = :id_conversation")
    Optional<Conversation> getValidConversation(Long id_conversation, Long id_user);

    @Query("FROM Conversation WHERE id_user_creator = :id_user OR id_user_invited = :id_user ORDER BY updated_at")
    List<Conversation> findMyConversations(Long id_user, Pageable pageable);
}
