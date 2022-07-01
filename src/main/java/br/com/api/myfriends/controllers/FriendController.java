package br.com.api.myfriends.controllers;

import br.com.api.myfriends.dtos.FriendDTO;
import br.com.api.myfriends.models.Address;
import br.com.api.myfriends.models.Friend;
import br.com.api.myfriends.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping
    public ResponseEntity postFriend(@RequestBody FriendDTO friend) {
        return new ResponseEntity<>(friendService.saveFriend(friend), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFriend(@PathVariable("id") Integer id, @RequestBody FriendDTO friend) {
        friendService.updateFriend(id, friend);
        return ResponseEntity.ok().body(null);
    }

    @PatchMapping("/{id}/address")
    public ResponseEntity updateFriendAddress(@PathVariable("id") Integer id, @RequestBody Address address) {
        friendService.updateAddress(id, address);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFriend(@PathVariable("id") Integer id) {
        friendService.deleteFriend(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String,Object>> searchFriendsByName(@RequestParam(required = false) String name,
                                                                  @RequestParam(defaultValue = "0") Integer page,
                                                                  @RequestParam(defaultValue = "3") Integer size) {
        Page<Friend> pageFriend =  friendService.pagination(name, page, size);
        Map<String, Object> response = new HashMap<>();
        response.put("friends", pageFriend.getContent());
        response.put("currentPage", pageFriend.getNumber());
        response.put("totalItems", pageFriend.getTotalElements());
        response.put("totalPages", pageFriend.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
