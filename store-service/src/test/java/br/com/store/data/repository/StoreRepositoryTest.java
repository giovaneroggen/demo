package br.com.store.data.repository;

import br.com.entity.BaseOrganizationId;
import br.com.store.data.Store;
import br.com.tests.SpringApplicationTests;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by giovane.silva on 10/10/2017.
 */
public class StoreRepositoryTest extends SpringApplicationTests {

    @Autowired
    private StoreRepository storeRepository;
    private final String ORGANIZATION_1 = "1";
    private final String ORGANIZATION_2 = "2";

    @Test
    public void test_save_store() throws Exception {
        Store store1Org1 = new Store();
        store1Org1.setName("STORE 1");
        store1Org1.setStartDate(LocalDateTime.now());
        store1Org1.setId(new BaseOrganizationId(ORGANIZATION_1));
        this.storeRepository.save(store1Org1);

        Store store1Org2 = new Store();
        store1Org2.setName("STORE 1");
        store1Org2.setStartDate(LocalDateTime.now());
        store1Org2.setId(new BaseOrganizationId(ORGANIZATION_2));
        this.storeRepository.save(store1Org2);

        super.mockMvc.perform(get("/stores/search/findByOrganization?organizationId={organizationId}", ORGANIZATION_1))
                .andExpect(jsonPath("_embedded.stores", hasSize(1)))
                .andExpect(jsonPath("_embedded.stores[0].id.organizationId", is(store1Org1.getId().getOrganizationId())))
                .andExpect(jsonPath("_embedded.stores[0].id.id", is(store1Org1.getId().getId())));

        super.mockMvc.perform(get("/stores/search/findByOrganization?organizationId={organizationId}", ORGANIZATION_2))
                .andExpect(jsonPath("_embedded.stores", hasSize(1)))
                .andExpect(jsonPath("_embedded.stores[0].id.organizationId", is(store1Org2.getId().getOrganizationId())))
                .andExpect(jsonPath("_embedded.stores[0].id.id", is(store1Org2.getId().getId())));
    }

}