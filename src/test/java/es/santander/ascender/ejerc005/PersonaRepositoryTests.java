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
        // Verificar que la lista no sea nula
        List<Persona> lista = personaRepository.findAll();
        assertNotNull(lista, "La lista de personas no debería ser nula");

        // Verificar que la lista esté vacía antes de insertar datos
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
        // Crear una provincia y guardarla
        Provincia provincia = new Provincia(null, "Madrid", null);
        provinciaRepository.save(provincia);

        // Crear una persona y asociarla a la provincia
        Persona persona = new Persona(null, "Pepe", "Rojas", provincia);
        persona.setProvincia(provincia); // Relacionar la persona con la provincia
        personaRepository.save(persona);

        // Asegurarse de que se haya generado un ID para la persona
        assertNotNull(persona.getId(), "El ID de la persona debería ser generado automáticamente");

        // Buscar la persona por ID
        Optional<Persona> resultado = personaRepository.findById(persona.getId());
        assertTrue(resultado.isPresent(), "La persona debería ser recuperada correctamente por su ID");

        // Verificar que la provincia esté correctamente asociada
        assertNotNull(resultado.get().getProvincia(), "La provincia asociada no debería ser nula");
    
    }

}