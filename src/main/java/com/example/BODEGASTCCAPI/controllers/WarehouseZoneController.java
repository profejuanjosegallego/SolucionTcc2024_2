package com.example.BODEGASTCCAPI.controllers;

import com.example.BODEGASTCCAPI.models.WarehouseZone;
import com.example.BODEGASTCCAPI.services.WarehouseZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soluciontcc/v1/warehouse-zones")
public class WarehouseZoneController {

    @Autowired
    private WarehouseZoneService warehouseZoneService;

    // Endpoint to create a new warehouse zone
    @PostMapping
    public ResponseEntity<WarehouseZone> storeWarehouseZone(@RequestBody WarehouseZone warehouseZone) {
        WarehouseZone savedZone = warehouseZoneService.storeWarehouseZone(warehouseZone);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedZone);
    }

    // Endpoint to retrieve all warehouse zones
    @GetMapping
    public ResponseEntity<List<WarehouseZone>> findAllWarehouseZones() {
        List<WarehouseZone> zones = warehouseZoneService.findAllWarehouseZones();
        return ResponseEntity.status(HttpStatus.OK).body(zones);
    }

    // Endpoint to retrieve warehouse zone by ID
    @GetMapping("/{zoneId}")
    public ResponseEntity<WarehouseZone> findWarehouseZoneById(@PathVariable Long zoneId) {
        WarehouseZone zone = warehouseZoneService.findWarehouseZoneById(zoneId);
        return ResponseEntity.status(HttpStatus.OK).body(zone);
    }

    // Endpoint to update an existing warehouse zone by ID
    @PutMapping("/{zoneId}")
    public ResponseEntity<WarehouseZone> updateWarehouseZone(@PathVariable Long zoneId, @RequestBody WarehouseZone warehouseZone) {
        WarehouseZone updatedZone = warehouseZoneService.updateWarehouseZone(zoneId, warehouseZone);
        return ResponseEntity.status(HttpStatus.OK).body(updatedZone);
    }

    // Endpoint to delete a warehouse zone by ID
    @DeleteMapping("/{zoneId}")
    public ResponseEntity<Void> deleteWarehouseZone(@PathVariable Long zoneId) {
        warehouseZoneService.deleteWarehouseZone(zoneId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
