package com.example.BODEGASTCCAPI.services;

import com.example.BODEGASTCCAPI.helpers.exceptions.ResourceNotFoundException;
import com.example.BODEGASTCCAPI.helpers.validators.WarehouseZoneValidation;
import com.example.BODEGASTCCAPI.models.WarehouseZone;
import com.example.BODEGASTCCAPI.repositories.IWarehouseZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseZoneService {

    @Autowired
    private IWarehouseZoneRepository repository;

    @Autowired
    private WarehouseZoneValidation validation;

    public WarehouseZone storeWarehouseZone(WarehouseZone warehouseZone) {
        validateWarehouseZone(warehouseZone);
        return this.repository.save(warehouseZone);
    }

    public List<WarehouseZone> findAllWarehouseZones() {
        return this.repository.findAll();
    }

    public WarehouseZone findWarehouseZoneById(Long zoneId) {
        return this.repository.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse zone not found with ID " + zoneId));
    }

    public WarehouseZone updateWarehouseZone(Long zoneId, WarehouseZone warehouseZoneData) {
        WarehouseZone existingWarehouseZone = findWarehouseZoneById(zoneId);
        validateWarehouseZone(warehouseZoneData);

        existingWarehouseZone.setZoneName(warehouseZoneData.getZoneName());
        existingWarehouseZone.setMaxVolumeCapacity(warehouseZoneData.getMaxVolumeCapacity());
        existingWarehouseZone.setMaxWeightCapacity(warehouseZoneData.getMaxWeightCapacity());
        existingWarehouseZone.setOccupiedVolumeCapacity(warehouseZoneData.getOccupiedVolumeCapacity());
        existingWarehouseZone.setOccupiedWeightCapacity(warehouseZoneData.getOccupiedWeightCapacity());

        return this.repository.save(existingWarehouseZone);
    }

    public void deleteWarehouseZone(Long zoneId) {
        WarehouseZone warehouseZone = findWarehouseZoneById(zoneId);
        this.repository.delete(warehouseZone);
    }

    private void validateWarehouseZone(WarehouseZone warehouseZone) {
        if (!validation.validateZoneName(warehouseZone.getZoneName())) {
            throw new IllegalArgumentException("Invalid zone name");
        }
        if (!validation.validateMaxVolumeCapacity(warehouseZone.getMaxVolumeCapacity())) {
            throw new IllegalArgumentException("Invalid max volume capacity");
        }
        if (!validation.validateMaxWeightCapacity(warehouseZone.getMaxWeightCapacity())) {
            throw new IllegalArgumentException("Invalid max weight capacity");
        }
        if (!validation.validateOccupiedVolumeCapacity(warehouseZone.getOccupiedVolumeCapacity(), warehouseZone.getMaxVolumeCapacity())) {
            throw new IllegalArgumentException("Invalid occupied volume capacity");
        }
        if (!validation.validateOccupiedWeightCapacity(warehouseZone.getOccupiedWeightCapacity(), warehouseZone.getMaxWeightCapacity())) {
            throw new IllegalArgumentException("Invalid occupied weight capacity");
        }
    }
}
