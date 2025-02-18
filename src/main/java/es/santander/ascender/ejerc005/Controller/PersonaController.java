package es.santander.ascender.ejerc005.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc005.model.Persona;
import es.santander.ascender.ejerc005.repository.PersonaRepository;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository personaService;

    @PostMapping
    public Persona create(@RequestBody Persona persona) {
        return personaService.create(persona);
    }

    @GetMapping("/{id}")
    public Persona read(@PathVariable("id") Long id) {
        return personaService.read(id);
    }

    @GetMapping
    public List<Persona> list() {
        return personaService.read();
    }

    @PutMapping
    public Persona update(@RequestBody Persona persona) {
        return personaService.update(persona);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personaService.delete(id);
    }
}