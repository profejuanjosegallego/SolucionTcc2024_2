package com.example.BODEGASTCCAPI.repositories;

import com.example.BODEGASTCCAPI.models.WarehouseZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWarehouseZoneRepository extends JpaRepository<WarehouseZone, Long> {
}
