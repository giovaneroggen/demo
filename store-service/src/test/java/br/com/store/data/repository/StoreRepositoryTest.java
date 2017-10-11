package br.com.store.data.repository;

import br.com.store.data.Store;
import br.com.tests.SpringApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

/**
 * Created by giovane.silva on 10/10/2017.
 */
public class StoreRepositoryTest extends SpringApplicationTests {


    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void test_save_store(){


        Store store = new Store();

        store.setName("LALA ");
        store.setStartDate(LocalDateTime.now());

        this.storeRepository.save(store);

        assertNotNull(store);

        assertNotNull(store.getId());

    }

}