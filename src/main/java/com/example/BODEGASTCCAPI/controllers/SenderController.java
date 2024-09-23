package com.example.BODEGASTCCAPI.controllers;

import com.example.BODEGASTCCAPI.models.Sender;
import com.example.BODEGASTCCAPI.services.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/soluciontcc/v1/senders")
public class SenderController {

    @Autowired
    private SenderService senderService;

    @PostMapping
    public ResponseEntity<Sender> storeSender(@RequestBody Sender senderData) {
        Sender savedSender = senderService.storeSender(senderData);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSender);
    }

    @GetMapping
    public ResponseEntity<List<Sender>> findAllSenders() {
        List<Sender> senders = senderService.findAllSenders();
        return ResponseEntity.status(HttpStatus.OK).body(senders);
    }

    @GetMapping("/{senderId}")
    public ResponseEntity<Sender> findSenderById(@PathVariable Long senderId) {
        Sender sender = senderService.findSenderById(senderId);
        return ResponseEntity.status(HttpStatus.OK).body(sender);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<Sender> findSenderByFirstName(@PathVariable String firstName) {
        Sender sender = senderService.findSenderByFirstName(firstName).isPresent() ?
                senderService.findSenderByFirstName(firstName).get() : null;
        return ResponseEntity.status(HttpStatus.OK).body(sender);
    }

    @PutMapping("/{senderId}")
    public ResponseEntity<Sender> updateSender(@PathVariable Long senderId, @RequestBody Sender senderData) {
        Sender updatedSender = senderService.updateSender(senderId, senderData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSender);
    }

    @DeleteMapping("/{senderId}")
    public ResponseEntity<?> deleteSender(@PathVariable Long senderId) {
        senderService.deleteSender(senderId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
