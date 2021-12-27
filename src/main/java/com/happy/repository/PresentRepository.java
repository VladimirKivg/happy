package com.happy.repository;

import com.happy.model.Present;
import org.springframework.data.repository.CrudRepository;

public interface PresentRepository extends CrudRepository<Present, Long> {

        Present findById(int id);
    }
