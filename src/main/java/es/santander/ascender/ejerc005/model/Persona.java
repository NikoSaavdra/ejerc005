package es.santander.ascender.ejerc005.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "persona")
public class Persona {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_provincia", nullable = false)

    private Provincia provincia;

    public Persona() {

    }

    public Persona(Long id, String nombre, String apellido, Provincia provincia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.provincia = provincia;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProvincia() {
        return nombre;
    }

    public void setProvincia(Provincia nombre) {  
    }


}
