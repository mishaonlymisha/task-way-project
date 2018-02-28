package com.company.taskwayrest.repository;

import com.company.taskwayrest.services.TableOfFields;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FieldsRepository extends CrudRepository <TableOfFields,Integer> {
    List<TableOfFields> findAll();
}
