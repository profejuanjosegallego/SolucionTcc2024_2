package com.example.BODEGASTCCAPI.services;

import com.example.BODEGASTCCAPI.helpers.exceptions.ResourceNotFoundException;
import com.example.BODEGASTCCAPI.helpers.validators.SenderValidation;
import com.example.BODEGASTCCAPI.models.Sender;
import com.example.BODEGASTCCAPI.repositories.ISenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SenderService {

    @Autowired
    private ISenderRepository repository;

    @Autowired
    private SenderValidation senderValidation;

    // Store sender
    public Sender storeSender(Sender senderData) {
        validateSender(senderData);
        return repository.save(senderData);
    }

    public List<Sender> findAllSenders() {
        return repository.findAll();
    }

    public Sender findSenderById(Long senderId) {
        return repository.findById(senderId)
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found with ID " + senderId));
    }

    public Optional<Sender> findSenderByFirstName(String firstName) {
        Optional<Sender> sender = repository.findByFirstNames(firstName);
        if (sender.isEmpty()) {
            throw new ResourceNotFoundException("Sender with first name " + firstName + " not found");
        }
        return sender;
    }

    public Sender updateSender(Long senderId, Sender senderData) {
        Sender existingSender = findSenderById(senderId);
        validateSender(senderData);

        existingSender.setFirstNames(senderData.getFirstNames());
        existingSender.setDepartment(senderData.getDepartment());
        existingSender.setCity(senderData.getCity());
        existingSender.setAddress(senderData.getAddress());
        existingSender.setPaymentMethod(senderData.getPaymentMethod());

        return repository.save(existingSender);
    }

    public void deleteSender(Long senderId) {
        Sender sender = findSenderById(senderId);
        repository.delete(sender);
    }

    private void validateSender(Sender sender) {
        if (!this.senderValidation.validateFirstNames(sender.getFirstNames())) {
            throw new IllegalArgumentException("Invalid first names");
        }
        if (!this.senderValidation.validateDepartment(sender.getDepartment())) {
            throw new IllegalArgumentException("Invalid department");
        }
        if (!this.senderValidation.validateCity(sender.getCity())) {
            throw new IllegalArgumentException("Invalid city");
        }
        if (!this.senderValidation.validateAddress(sender.getAddress())) {
            throw new IllegalArgumentException("Invalid address");
        }
        if (!this.senderValidation.validatePaymentMethod(sender.getPaymentMethod())) {
            throw new IllegalArgumentException("Invalid payment method");
        }
    }
}
