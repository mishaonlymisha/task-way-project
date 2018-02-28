package com.company.taskwayrest.controllers;

import com.company.fieldClasses.ConverterOfDataField;
import com.company.reader.FieldDataInput;
import com.company.taskwayrest.repository.FieldsRepository;
import com.company.taskwayrest.services.ServiceOfMovingArmy;
import com.company.taskwayrest.services.TableOfFields;
import com.company.writer.FieldDataOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/1.0/way")
public class RequestsController {

    @Autowired
    private final FieldsRepository fieldsRepository;

    public RequestsController(FieldsRepository fieldsRepository) {
        this.fieldsRepository = fieldsRepository;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void put(@PathVariable int id, @RequestBody FieldDataInput fieldDataInput) {
        fieldsRepository.save(new TableOfFields(id, fieldDataInput));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public TableOfFields get(@PathVariable int id) {
        return fieldsRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<TableOfFields> getAll() {
        return fieldsRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable int id) {
        fieldsRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/all")
    public void deleteAll() {
        fieldsRepository.deleteAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/findway")
    public FieldDataOutput findWayById(@PathVariable int id) {
        return new ServiceOfMovingArmy().moveTillFinish(new ConverterOfDataField().convertToList(fieldsRepository.findOne(id).getField()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public FieldDataOutput findWay(@RequestBody FieldDataInput field) {
        return new ServiceOfMovingArmy().moveTillFinish(field.getField());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}/findway/steps/{steps}")
    public FieldDataOutput findWayByIdWithSteps(@PathVariable int id,@PathVariable int steps){
        return new ServiceOfMovingArmy().moveFewSteps(new ConverterOfDataField().convertToList(fieldsRepository.findOne(id).getField()),steps);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/steps/{numberOfSteps}")
    public FieldDataOutput findWayWithSteps(@PathVariable int numberOfSteps, @RequestBody FieldDataInput field) {
        return new ServiceOfMovingArmy().moveFewSteps(field.getField(), numberOfSteps);
    }

}


