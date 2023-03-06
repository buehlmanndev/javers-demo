package com.example.javersdemo.configuration;

import com.example.javersdemo.model.Address;
import com.example.javersdemo.model.Product;
import com.example.javersdemo.model.Store;
import com.example.javersdemo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class initialConfiguration {

    private final StoreRepository storeRepository;

    public initialConfiguration(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        Store store = new Store("Baeldung store", new Address("Some street", 22222));
        for (int i = 1; i < 3; i++) {
            Product product = new Product("Product #" + i, 100 * i);
            store.addProduct(product);
        }
        storeRepository.save(store);
    }
}
