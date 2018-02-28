package com.company.taskwayrest.services;

import com.company.fieldClasses.ConverterOfDataField;
import com.company.reader.FieldDataInput;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//import java.util.Objects;
//
@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class TableOfFields {
    public TableOfFields(int id,FieldDataInput input) {
        this.id = id;
        this.field=new ConverterOfDataField().convertToString(input.getField());
    }

    @Id
    private int id;

    private String field;

}
