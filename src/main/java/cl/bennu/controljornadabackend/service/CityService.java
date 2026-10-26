package cl.bennu.controljornadabackend.service;


import cl.bennu.controljornadabackend.mapper.CityMapper;
import cl.bennu.controljornadabackend.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CityService {

    private @Autowired CityMapper cityMapper;

    public List<City> getAll() {
        return cityMapper.getAll();
    }

    @Transactional
    public void insert(City city) {
        cityMapper.insert(city);
    }

    @Transactional
    public void update(City city) {
        cityMapper.update(city);
    }

    public City getById(Long cityId) {
        return cityMapper.get(cityId);
    }

    public void delete(Long cityId) {
        cityMapper.delete(cityId);
    }

}
