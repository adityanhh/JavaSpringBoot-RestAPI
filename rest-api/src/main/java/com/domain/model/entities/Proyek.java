package com.domain.model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nama_proyek", nullable = false)
    private String namaProyek;

    @Column(name = "client", nullable = false)
    private String client;

    @Column(name = "tgl_mulai", nullable = false)
    private LocalDateTime tglMulai;

    @Column(name = "tgl_selesai", nullable = false)
    private LocalDateTime tglSelesai;

    @Column(name = "pimpinan_proyek", nullable = false)
    private String pimpinan;

    @Lob
    @Column(name = "keterangan", nullable = false)
    private String keterangan;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
