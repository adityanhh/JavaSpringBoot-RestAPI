package com.domain.model.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Proyek_Lokasi {
    @ManyToOne
    @JoinColumn(name = "proyek_id", nullable = false)
    private Proyek proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id", nullable = false)
    private Lokasi lokasi;
}
