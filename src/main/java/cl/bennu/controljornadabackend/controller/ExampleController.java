package cl.bennu.controljornadabackend.controller;

import cl.bennu.controljornadabackend.constants.Constants;
import cl.bennu.controljornadabackend.controller.base.BaseController;
import cl.bennu.controljornadabackend.model.Example;
import cl.bennu.controljornadabackend.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constants.BASE_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class ExampleController extends BaseController {

    private static final String ENDPOINT = "/example";

    private @Autowired TemplateService templateService;

    @GetMapping(ENDPOINT)
    public ResponseEntity<?> getAll() {
        List<Example> examples = templateService.getAllExamples();
        return ok(examples);
    }

    @PostMapping(ENDPOINT)
    public ResponseEntity<?> save(@RequestBody Example example) {
        templateService.saveExample(example);
        return ok(example);
    }

    @GetMapping(ENDPOINT + "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Example example = templateService.getExampleById(id);
        return ok(example);
    }

    @DeleteMapping(ENDPOINT + "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        templateService.deleteExample(id);
        return ok();
    }

}