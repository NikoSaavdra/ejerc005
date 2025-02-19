package es.santander.ascender.ejerc005.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejerc005.model.Continente;

public interface ContinenteRepository extends JpaRepository<Continente, Long> {
    
}
