package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.controller.base.RecursoNoEncontradoException;
import cl.bennu.controljornadabackend.mapper.CountryMapper;
import cl.bennu.controljornadabackend.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;

    public Country findById(Integer id) {
        Country country = countryMapper.findById(id);
        if(country == null) {
            throw new RecursoNoEncontradoException("Country with id " + id + " not found");
        }
        return country;
    }

    @Override
    public Integer insert(Country country) {
        countryMapper.findById(country.getId());
        return countryMapper.insert(country);
    }

    @Override
    public List<Country> findAll() {
        return countryMapper.findAll();
    }

    @Override
    public void update(Country country) {
        countryMapper.findById(country.getId());
        countryMapper.update(country);
    }

    @Override
    public int deleteById(Integer id) {
        countryMapper.findById(id);
        return countryMapper.deleteById(id);
    }
}
