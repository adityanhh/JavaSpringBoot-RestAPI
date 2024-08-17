package com.domain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.entities.Lokasi;
import com.domain.repository.LokasiRepository;


@RestController
@RequestMapping("/lokasi")
public class LokasiController {
    
    @Autowired
    private LokasiRepository lokasirepository;

    @PostMapping
    public Lokasi PostLokasi(@RequestBody Lokasi lokasi) {
        return lokasirepository.save(lokasi);
    }

    @GetMapping
    public List<Lokasi> GetLokasi() {
        return lokasirepository.findAll();
    }

    @PutMapping("/{id}")
    public Lokasi updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasiDetails) {
        Optional<Lokasi> lokasioOptional = lokasirepository.findById(id);

        if (lokasioOptional.isPresent()) {
            Lokasi lokasi = lokasioOptional.get();
            lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
            lokasi.setNegara(lokasiDetails.getNegara());
            lokasi.setProvinsi(lokasiDetails.getProvinsi());
            lokasi.setKota(lokasiDetails.getKota());
            return lokasirepository.save(lokasi);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLokasi(@PathVariable Long id) {
        if (lokasirepository.existsById(id)) {
            lokasirepository.deleteById(id);
            return new ResponseEntity<>("Lokasi Berhasil Dihapus", HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}
