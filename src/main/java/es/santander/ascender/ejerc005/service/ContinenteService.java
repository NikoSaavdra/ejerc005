package es.santander.ascender.ejerc005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc005.model.Continente;
import es.santander.ascender.ejerc005.repository.ContinenteRepository;


@Service
@Transactional
public class ContinenteService {
    @Autowired
    private ContinenteRepository repository;

    public Continente create(Continente continente) {
        if (continente.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro columna utilizando la creación",
                    CRUDOperation.CREATE,
                    continente.getId());
        }
        return repository.save(continente);
    }
    
    @Transactional(readOnly = true)
    public Continente read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Continente> read() {
        return repository.findAll();
    }

    public Continente update(Continente continente) {
        if (continente.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro columna utilizando la modifición",
                    CRUDOperation.UPDATE,
                    null);

        }
        return repository.save(continente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }
}
