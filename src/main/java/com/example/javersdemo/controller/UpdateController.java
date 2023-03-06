package com.example.javersdemo.controller;

import com.example.javersdemo.business.StoreComponent;
import com.example.javersdemo.model.Store;
import com.example.javersdemo.repository.StoreRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@Slf4j
@Transactional
public class UpdateController {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreComponent storeComponent;

    @PutMapping("/stores/{id}/")
    public void updateStores(@PathVariable("id") Integer storeId, @RequestBody String name) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
        store.setName(name);
        log.info("updated store {}", store);
//        storeRepository.save(store);
    }

    @PutMapping("/stores/implicit/{id}/")
    public void updateStoresImplicit(@PathVariable("id") Integer storeId, @RequestBody String name) {
        storeComponent.changeStoreName(name, storeId);
        log.info("updated store {} via Store Component", storeId);
    }


}
