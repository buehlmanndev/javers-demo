package com.example.javersdemo.controller;

import com.example.javersdemo.model.Store;
import com.example.javersdemo.repository.StoreRepository;
import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class ReadController {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/stores/{id}")
    public Store getStores(@PathVariable("id") Integer storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
    }


}
