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

import es.santander.ascender.ejerc002.model.Boligrafo;
import es.santander.ascender.ejerc002.service.BoligrafoService;

@RestController
@RequestMapping("/api/persona")
public class BoligrafoController {

    @Autowired
    private BoligrafoService boligrafoService;

    @PostMapping
    public Boligrafo create(@RequestBody Boligrafo columnaBoligrafo) {
        return boligrafoService.create(columnaBoligrafo);
    }

    @GetMapping("/{id}")
    public Boligrafo read(@PathVariable("id") Long id) {
        return boligrafoService.read(id);
    }

    @GetMapping
    public List<Boligrafo> list() {
        return boligrafoService.read();
    }

    @PutMapping
    public Boligrafo update(@RequestBody Boligrafo columnaBoligrafo) {
        return boligrafoService.update(columnaBoligrafo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        boligrafoService.delete(id);
    }
}