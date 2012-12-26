package com.meritit.productmanagement.domain;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class ProductTest {

    @Test
    public void test_product_name_not_blank() {
        Product product = new Product();
        try {
            product.setName("");

            fail("Product::name::NOT_BLANK not pass");
        } catch (ValidationException e) {
            assertEquals("name", e.getProperty());
            assertEquals(ValidationException.NOT_BLANK, e.getType());
        }
    }

    @Test
    public void test_product_name_length() {
        Product product = new Product();


        String name_101 = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";
        try {
            product.setName(name_101);

            fail("Product::name::TOO_LONG not pass");
        } catch (ValidationException e) {
            assertEquals("name", e.getProperty());
            assertEquals(ValidationException.TOO_LONG, e.getType());
        }
    }

    @Test
    public void test_product_cost_not_null() {
        Product product = new Product();
        try {
            product.setCost(null);

            fail("Product::cost::NOT_NULL not pass");
        } catch (ValidationException e) {
            assertEquals("cost", e.getProperty());
            assertEquals(ValidationException.NOT_NULL, e.getType());
        }
    }

    @Test
    public void test_product_cost_length() {
        Product product = new Product();
        try {
            product.setCost(12345678);

            fail("Product::cost::TOO_LONG not pass");
        } catch (ValidationException e) {
            assertEquals("cost", e.getProperty());
            assertEquals(ValidationException.TOO_LONG, e.getType());
        }
    }

    @Test
    public void test_product_architecture_not_blank() {
        Product product = new Product();
        try {
            product.setArchitecture("");

            fail("Product::architecture::NOT_BLANK not pass");
        } catch (ValidationException e) {
            assertEquals("architecture", e.getProperty());
            assertEquals(ValidationException.NOT_BLANK, e.getType());
        }
    }

    @Test
    public void test_product_architecture_length() {
        Product product = new Product();
        try {
            String architecture_21 = "123456789012345678901";
            product.setArchitecture(architecture_21);

            fail("Product::architecture::TOO_LONG not pass");
        } catch (ValidationException e) {
            assertEquals("architecture", e.getProperty());
            assertEquals(ValidationException.TOO_LONG, e.getType());
        }
    }

    @Test
    public void test_product_architecture_value_enum() {
        Product product = new Product();

        String[] possibleValues = {"J2EE", "Java桌面", ".Net", "Domino", "Android"};

        for (String value : possibleValues) {
            product.setArchitecture(value);
        }

        try {
            product.setArchitecture("Other");
            fail("Product::architecture::value_enum not pass");
        } catch (ValidationException e) {
            assertEquals("architecture", e.getProperty());
            assertEquals(ValidationException.INCORRECT_VALUE, e.getType());
        }

    }

    @Test
    public void test_product_suitable_project_not_blank() {
        Product product = new Product();
        try {
            product.setSuitableProject("");
            fail("Product::suitableProject::NOT_BLANK not pass");
        } catch (ValidationException e) {
            assertEquals("suitableProject", e.getProperty());
            assertEquals(ValidationException.NOT_BLANK, e.getType());
        }
    }

    @Test
    public void test_product_suitable_project() {
        Product product = new Product();

        String[] possibleValues = {"企业应用", "移动应用", "企业集成", "数据分析"};

        for (String value : possibleValues) {
            product.setSuitableProject(value);
        }

        try {
            product.setSuitableProject("Other");
            fail("Product::suitableProject::value_enum not pass");
        } catch (ValidationException e) {
            assertEquals("suitableProject", e.getProperty());
            assertEquals(ValidationException.INCORRECT_VALUE, e.getType());
        }
    }
}
