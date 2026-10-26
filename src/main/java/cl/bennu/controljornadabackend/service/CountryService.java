package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.model.Country;

import java.util.List;

public interface CountryService {
    Country findById(Integer id);
    Integer insert(Country country);
    List<Country> findAll();
    void update(Country country);
    int deleteById(Integer id);
}
