package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.model.entities.Proyek;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Long> {
}
