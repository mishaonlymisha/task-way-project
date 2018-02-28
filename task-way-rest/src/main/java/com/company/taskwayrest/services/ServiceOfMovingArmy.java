package com.company.taskwayrest.services;

import com.company.army.SimpleArmy;
import com.company.fieldClasses.ConverterOfDataField;
import com.company.reader.FieldDataInput;
import com.company.writer.FieldDataOutput;

import java.util.List;

public class ServiceOfMovingArmy {
    public FieldDataOutput moveTillFinish(List<String> field) {
        SimpleArmy simpleArmy = new SimpleArmy(new ConverterOfDataField().convert(field));
        simpleArmy.moveTillFinish();
        return new FieldDataOutput(field,
                simpleArmy.location().getPathForSave(),
                simpleArmy.location().getMovingStateForSave());
    }
    public FieldDataOutput moveFewSteps(List<String> fieldDataInput,int numberOfSteps) {
        SimpleArmy simpleArmy = new SimpleArmy(new ConverterOfDataField().convert(fieldDataInput));
        simpleArmy.move(numberOfSteps);
        return new FieldDataOutput(fieldDataInput,
                simpleArmy.location().getPathForSave(),
                simpleArmy.location().getMovingStateForSave());
    }
}
