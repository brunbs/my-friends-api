package br.com.api.myfriends.repositories;

import br.com.api.myfriends.models.Friend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Integer> {

    Page<Friend> findByNameContaining(String name, Pageable pageable);

}
