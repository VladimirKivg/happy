package com.happy.repository;

import com.happy.model.Prethent;
import org.springframework.data.repository.CrudRepository;

public interface PrethentRepository extends CrudRepository<Prethent, Long> {

        Prethent findById(int id);
    }
