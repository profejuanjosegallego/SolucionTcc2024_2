package com.example.BODEGASTCCAPI.models;

import jakarta.persistence.*;

@Entity
@Table(name = "warehouse_zones")
public class WarehouseZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name = "zone_name", nullable = false)
    private String zoneName;

    @Column(name = "max_volume_capacity", nullable = false)
    private Double maxVolumeCapacity;

    @Column(name = "max_weight_capacity", nullable = false)
    private Double maxWeightCapacity;

    @Column(name = "occupied_volume_capacity", nullable = false)
    private Double occupiedVolumeCapacity;

    @Column(name = "occupied_weight_capacity", nullable = false)
    private Double occupiedWeightCapacity;

    public WarehouseZone() {
    }

    public WarehouseZone(Long zoneId, String zoneName, Double maxVolumeCapacity, Double maxWeightCapacity, Double occupiedVolumeCapacity, Double occupiedWeightCapacity) {
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.maxVolumeCapacity = maxVolumeCapacity;
        this.maxWeightCapacity = maxWeightCapacity;
        this.occupiedVolumeCapacity = occupiedVolumeCapacity;
        this.occupiedWeightCapacity = occupiedWeightCapacity;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Double getMaxVolumeCapacity() {
        return maxVolumeCapacity;
    }

    public void setMaxVolumeCapacity(Double maxVolumeCapacity) {
        this.maxVolumeCapacity = maxVolumeCapacity;
    }

    public Double getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public void setMaxWeightCapacity(Double maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public Double getOccupiedVolumeCapacity() {
        return occupiedVolumeCapacity;
    }

    public void setOccupiedVolumeCapacity(Double occupiedVolumeCapacity) {
        this.occupiedVolumeCapacity = occupiedVolumeCapacity;
    }

    public Double getOccupiedWeightCapacity() {
        return occupiedWeightCapacity;
    }

    public void setOccupiedWeightCapacity(Double occupiedWeightCapacity) {
        this.occupiedWeightCapacity = occupiedWeightCapacity;
    }
}
