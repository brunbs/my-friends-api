package br.com.api.myfriends.repositories;

import br.com.api.myfriends.models.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
}
