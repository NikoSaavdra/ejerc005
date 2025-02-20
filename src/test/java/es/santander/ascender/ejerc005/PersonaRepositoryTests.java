package es.santander.ascender.ejerc005;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc005.model.Persona;
import es.santander.ascender.ejerc005.model.Provincia;
import es.santander.ascender.ejerc005.repository.PersonaRepository;
import es.santander.ascender.ejerc005.repository.ProvinciaRepository;

@SpringBootTest
class PersonaRepositoryTests {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @BeforeEach
    public void setUp() {
        personaRepository.deleteAll();
        provinciaRepository.deleteAll();
    }

    @Test
    public void testListarPersonas() {
    
        List<Persona> lista = personaRepository.findAll();
        assertNotNull(lista, "La lista de personas no debería ser nula");

    
        assertTrue(lista.isEmpty(), "La lista de personas debería estar vacía al principio");
    }

    @Test
    public void testBuscarPersonaNoExistente() {
        // Probar con un ID inexistente
        Optional<Persona> resultado = personaRepository.findById(45L);
        assertTrue(resultado.isEmpty(), "La persona con ID 45 no debería existir en la base de datos");
    }

    @Test
    public void testCrearYLeerPersonaConProvincia() {
    
        Provincia provincia = new Provincia(null, "Madrid", null);
        provinciaRepository.save(provincia);

        Persona persona = new Persona(null, "Pepe", "Rojas", provincia);
        persona.setProvincia(provincia); 
        personaRepository.save(persona);

        assertNotNull(persona.getId(), "El ID de la persona debería ser generado automáticamente");

        
        Optional<Persona> resultado = personaRepository.findById(persona.getId());
        assertTrue(resultado.isPresent(), "La persona debería ser recuperada correctamente por su ID");

        
        assertNotNull(resultado.get().getProvincia(), "La provincia asociada no debería ser nula");
    
    }

}