package es.santander.ascender.ejerc005.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejerc005.model.Provincia;
import es.santander.ascender.ejerc005.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public List<Provincia> listarProvincias() {
        return provinciaRepository.findAll();
    }

    public Optional<Provincia> buscarProvincia(Long id) {
        return provinciaRepository.findById(id);
    }

    public Provincia guardarProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    public void eliminarProvincia(Long id) {
        provinciaRepository.deleteById(id);
    }
}
