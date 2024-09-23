package com.example.BODEGASTCCAPI.repositories;

import com.example.BODEGASTCCAPI.models.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMerchRepository extends JpaRepository<Merchandise,Long> {

}
