package br.com.api.myfriends.services;

import br.com.api.myfriends.models.Address;
import br.com.api.myfriends.models.Friend;
import br.com.api.myfriends.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    public List<Friend> findAll() {
        return friendRepository.findAll();
    }

    public Friend findOneFriend(Integer id) {
        Friend friend = friendRepository.findById(id).orElse(null);
        if(friend == null) {
            System.out.println("Friend not found - Implement custom Exception");
        }
        return friend;
    }

    public Address findAddress(Integer id) {
        return findOneFriend(id).getAddress();
    }

}
