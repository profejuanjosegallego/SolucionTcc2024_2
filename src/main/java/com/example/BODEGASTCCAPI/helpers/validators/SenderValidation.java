package com.example.BODEGASTCCAPI.helpers.validators;

import org.springframework.stereotype.Component;

@Component
public class SenderValidation {

    public boolean validateFirstNames(String firstNames) {
        if (firstNames == null || firstNames.trim().isEmpty()) {
            return false;
        }
        if (firstNames.length() > 50) {
            return false;
        }
        return firstNames.matches("^[a-zA-Z\\s]+$");
    }

    public boolean validateDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            return false;
        }
        return department.length() <= 50;
    }

    public boolean validateCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            return false;
        }
        return city.length() <= 50;
    }

    public boolean validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            return false;
        }
        return address.length() <= 100;
    }

    public boolean validatePaymentMethod(String paymentMethod) {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            return false;
        }
        String[] validMethods = {"credit_card", "bank_transfer", "cash"};
        for (String method : validMethods) {
            if (paymentMethod.equalsIgnoreCase(method)) {
                return true;
            }
        }
        return false;
    }
}
