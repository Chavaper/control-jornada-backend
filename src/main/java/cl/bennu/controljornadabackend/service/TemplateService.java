package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.ExampleMapper;
import cl.bennu.controljornadabackend.model.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TemplateService {

    private @Autowired ExampleMapper exampleMapper;

    public List<Example> getAllExamples() {
        return exampleMapper.getAll();
    }

    @Transactional
    public void saveExample(Example example) {
        if (null == example.getId()) {
            exampleMapper.insert(example);
        } else {
            exampleMapper.update(example);
        }
    }

    public Example getExampleById(Long templateId) {
        return exampleMapper.get(templateId);
    }

    public void deleteExample(Long templateId) {
        exampleMapper.delete(templateId);
    }

}
