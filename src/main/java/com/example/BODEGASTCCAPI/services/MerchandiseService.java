package com.example.BODEGASTCCAPI.services;

import com.example.BODEGASTCCAPI.helpers.exceptions.ResourceNotFoundException;
import com.example.BODEGASTCCAPI.helpers.messages.Message;
import com.example.BODEGASTCCAPI.helpers.validators.MerchandiseValidation;
import com.example.BODEGASTCCAPI.models.Merchandise;
import com.example.BODEGASTCCAPI.repositories.IMerchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseService {

    @Autowired
    private IMerchRepository repository;

    @Autowired
    private MerchandiseValidation validation;

    public Merchandise storeMerchandise(Merchandise merchandiseData) {
        validateMerchandise(merchandiseData);
        return this.repository.save(merchandiseData);
    }

    public List<Merchandise> findAllMerchandise() {
        return this.repository.findAll();
    }

    public Merchandise findMerchandiseById(Long merchandiseId) {
        return repository.findById(merchandiseId)
                .orElseThrow(() -> new ResourceNotFoundException("Merchandise not found with ID " + merchandiseId));
    }

    public Optional<Merchandise> findMerchandiseByName(String merchandiseName) {
        Optional<Merchandise> merchandise = this.repository.findByName(merchandiseName);
        if (merchandise.isEmpty()) {
            throw new ResourceNotFoundException("Merchandise with name " + merchandiseName + " not found");
        }
        return merchandise;
    }

    public Merchandise updateMerchandise(Long merchandiseId, Merchandise merchandiseData) {
        Merchandise existingMerchandise = findMerchandiseById(merchandiseId);
        validateMerchandise(merchandiseData);

        existingMerchandise.setWeight(merchandiseData.getWeight());
        existingMerchandise.setVolume(merchandiseData.getVolume());
        existingMerchandise.setName(merchandiseData.getName());
        existingMerchandise.setRecipientType(merchandiseData.getRecipientType());
        existingMerchandise.setRecipientName(merchandiseData.getRecipientName());
        existingMerchandise.setDepartment(merchandiseData.getDepartment());
        existingMerchandise.setCity(merchandiseData.getCity());
        existingMerchandise.setAddress(merchandiseData.getAddress());
        existingMerchandise.setEntryDate(merchandiseData.getEntryDate());
        existingMerchandise.setExitDate(merchandiseData.getExitDate());

        return this.repository.save(existingMerchandise);
    }

    public void deleteMerchandise(Long merchandiseId) {
        Merchandise merchandise = findMerchandiseById(merchandiseId);
        this.repository.delete(merchandise);
    }

    private void validateMerchandise(Merchandise merchandise) {
        if (!this.validation.validateWeight(merchandise.getWeight())) {
            throw new IllegalArgumentException(Message.NEGATIVE_WEIGHT.getMessage());
        }

        if (!this.validation.validateVolume(merchandise.getVolume())) {
            throw new IllegalArgumentException(Message.NEGATIVE_VOLUME.getMessage());
        }

        if (!this.validation.validateDates(merchandise.getEntryDate(), merchandise.getExitDate())) {
            throw new IllegalArgumentException(Message.INVALID_DATE.getMessage());
        }
    }
}
