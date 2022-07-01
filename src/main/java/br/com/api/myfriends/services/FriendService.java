package br.com.api.myfriends.services;

import br.com.api.myfriends.dtos.FriendDTO;
import br.com.api.myfriends.models.Address;
import br.com.api.myfriends.models.Friend;
import br.com.api.myfriends.repositories.FriendRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private ModelMapper modelMapper;

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

    public Integer saveFriend(FriendDTO friend) {
        Friend entity = modelMapper.map(friend, Friend.class);
        friendRepository.saveAndFlush(entity);
        return entity.getId();
    }

    public void updateFriend(Integer id, FriendDTO friend) {
        Friend entity = findOneFriend(id);
        if(entity != null) {
            entity = modelMapper.map(friend, Friend.class);
            entity.setId(id);
            friendRepository.save(entity);
        }
    }

    public void updateAddress(Integer id, Address address) {
        Friend entity = findOneFriend(id);
        if(entity != null) {
            entity.setAddress(address);
            friendRepository.save(entity);
        }
    }

}
