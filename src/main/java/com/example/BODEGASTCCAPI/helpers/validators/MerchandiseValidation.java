package com.example.BODEGASTCCAPI.helpers.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MerchandiseValidation {

    public boolean validateVolume(Double volume) {
        return volume > 0;
    }

    public boolean validateWeight(Double weight) {
        return weight > 0;
    }

    public boolean validateName(String name) {
        if (name.length() > 50) {
            return false;
        }
        return name.matches("^[a-zA-Z\\s]+$");
    }

    public boolean validateDates(LocalDate entryDate, LocalDate exitDate) {
        return entryDate.isBefore(exitDate);
    }
}
