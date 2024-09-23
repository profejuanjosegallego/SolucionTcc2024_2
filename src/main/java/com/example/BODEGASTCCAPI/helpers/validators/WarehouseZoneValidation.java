package com.example.BODEGASTCCAPI.helpers.validators;

import org.springframework.stereotype.Component;

@Component
public class WarehouseZoneValidation {

    public boolean validateMaxVolumeCapacity(Double maxVolumeCapacity) {
        return maxVolumeCapacity != null && maxVolumeCapacity > 0;
    }

    public boolean validateMaxWeightCapacity(Double maxWeightCapacity) {
        return maxWeightCapacity != null && maxWeightCapacity > 0;
    }

    public boolean validateOccupiedVolumeCapacity(Double occupiedVolumeCapacity, Double maxVolumeCapacity) {
        return occupiedVolumeCapacity != null && occupiedVolumeCapacity >= 0 && occupiedVolumeCapacity <= maxVolumeCapacity;
    }

    public boolean validateOccupiedWeightCapacity(Double occupiedWeightCapacity, Double maxWeightCapacity) {
        return occupiedWeightCapacity != null && occupiedWeightCapacity >= 0 && occupiedWeightCapacity <= maxWeightCapacity;
    }

    public boolean validateZoneName(String zoneName) {
        return zoneName != null && !zoneName.trim().isEmpty() && zoneName.length() <= 50;
    }
}
