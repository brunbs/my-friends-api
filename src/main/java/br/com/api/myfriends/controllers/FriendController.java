package br.com.api.myfriends.controllers;

import br.com.api.myfriends.models.Friend;
import br.com.api.myfriends.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping
    public ResponseEntity<List<Friend>> getAllFriends() {
        return new ResponseEntity<>(friendService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Friend> getOneFriend(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(friendService.findOneFriend(id));
    }

    @GetMapping("/{id}/address")
    public ResponseEntity getAddress(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(friendService.findAddress(id));
    }
}