package com.example.javersdemo.repository;

import com.example.javersdemo.model.Store;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@JaversSpringDataAuditable
public interface StoreRepository extends CrudRepository<Store, Integer> {
}