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

    // Endpoint to store sender
    @PostMapping
    public ResponseEntity<?> storeSender(@RequestBody Sender senderData) {
        Sender savedSender = senderService.storeSender(senderData);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSender);
    }

    // Endpoint to retrieve all senders
    @GetMapping
    public ResponseEntity<List<Sender>> findAllSenders() {
        List<Sender> senders = senderService.findAllSenders();
        return ResponseEntity.status(HttpStatus.OK).body(senders);
    }

    // Endpoint to retrieve sender by ID
    @GetMapping("/{senderId}")
    public ResponseEntity<?> findSenderById(@PathVariable Long senderId) {
        Sender sender = senderService.findSenderById(senderId);
        return ResponseEntity.status(HttpStatus.OK).body(sender);
    }

    // Endpoint to update sender by ID
    @PutMapping("/{senderId}")
    public ResponseEntity<?> updateSender(@PathVariable Long senderId, @RequestBody Sender senderData) {
        Sender updatedSender = senderService.updateSender(senderId, senderData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSender);
    }

    // Endpoint to delete sender by ID
    @DeleteMapping("/{senderId}")
    public ResponseEntity<?> deleteSender(@PathVariable Long senderId) {
        senderService.deleteSender(senderId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
