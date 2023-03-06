package com.example.javersdemo.business;


import com.example.javersdemo.repository.StoreRepository;
import org.springframework.stereotype.Component;

@Component
public class StoreComponent {

    private final StoreRepository storeRepository;


    public StoreComponent(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    public void changeStoreName(String name, Integer storeId) {
        storeRepository.findById(storeId).orElseThrow().setName(name);
    }


}
