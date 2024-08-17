package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.model.entities.Lokasi;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Long> {

    
}
