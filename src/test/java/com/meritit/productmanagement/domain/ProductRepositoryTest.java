package com.meritit.productmanagement.domain;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ProductRepositoryTest {

    @Test
    public void test_save_and_find_product() {
        ProductRepository repository = new ProductRepository();

        Product product = new Product();

        product.setName("产品平台");
        product.setArchitecture("J2EE");
        product.setCost(100000);
        product.setSuitableProject("企业应用");

        repository.save(product);

        Product productFromDB = repository.findById(product.getId());

        assertEquals(productFromDB.getId(), product.getId());
        assertEquals(productFromDB.getName(), product.getName());
        assertEquals(productFromDB.getArchitecture(), product.getArchitecture());
        assertEquals(productFromDB.getCost(), product.getCost());
        assertEquals(productFromDB.getSuitableProject(), product.getSuitableProject());

    }

}
