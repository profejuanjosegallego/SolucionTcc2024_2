package com.example.BODEGASTCCAPI.repositories;

import com.example.BODEGASTCCAPI.models.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISenderRepository extends JpaRepository<Sender,Long> {

    Optional<Sender> findByFirstNames(String firstName);
}

