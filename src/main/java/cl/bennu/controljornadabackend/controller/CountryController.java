package cl.bennu.controljornadabackend.controller;

import cl.bennu.controljornadabackend.model.Country;
import cl.bennu.controljornadabackend.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> listar() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Country> insert(@Valid @RequestBody Country country) {
        countryService.insert(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(country);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id,
                                           @Valid @RequestBody Country country) {
        country.setId(id);
        countryService.update(country);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        countryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


