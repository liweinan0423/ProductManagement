package com.meritit.productmanagement.application;

import com.meritit.productmanagement.domain.Department;
import com.meritit.productmanagement.domain.LoginException;
import com.meritit.productmanagement.domain.LoginService;
import com.meritit.productmanagement.domain.Person;
import com.meritit.productmanagement.domain.PersonRepository;
import com.meritit.productmanagement.domain.Product;
import com.meritit.productmanagement.domain.ProductRepository;
import com.meritit.productmanagement.domain.Project;
import com.meritit.productmanagement.infastructure.PersistenceHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductManagementApplicationFacade {

    private ProductRepository productRepository;
    private PersonRepository personRepository;
    private LoginService loginService;

    public ProductManagementApplicationFacade() {
        productRepository = new ProductRepository();
        personRepository = new PersonRepository();
        loginService = new LoginService(personRepository);
    }


    public List<ProductDTO> listProduct(int start, int limit) {
        List<Product> productList = productRepository.list(start, limit);
        List<ProductDTO> result = new ArrayList<ProductDTO>();

        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setCost(product.getCost());
            productDTO.setArchitecture(product.getArchitecture());
            productDTO.setSuitableProject(product.getSuitableProject());
            productDTO.setId(product.getId());
            result.add(productDTO);
        }

        return result;
    }

    public int countProducts() {
        return productRepository.totalCount();
    }


    public void saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCost(productDTO.getCost());
        product.setArchitecture(productDTO.getArchitecture());
        product.setSuitableProject(productDTO.getSuitableProject());
        productRepository.save(product);
    }

    public void deletePersonById(String id) {
        personRepository.delete(id);
    }

    public ProductDTO findProductById(String id) {
        Product product = productRepository.findById(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCost(product.getCost());
        productDTO.setArchitecture(product.getArchitecture());
        productDTO.setSuitableProject(product.getSuitableProject());
        return productDTO;
    }

    public void updateProduct(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCost(productDTO.getCost());
        product.setArchitecture(productDTO.getArchitecture());
        product.setSuitableProject(productDTO.getSuitableProject());
        productRepository.update(product);
    }

    public PersonDTO findPersonById(String id) {
        PersonDTO result = new PersonDTO();
        Person person = personRepository.findById(id);
        result.setId(person.getId());
        result.setName(person.getName());
        result.setLogin(person.getLogin());
        result.setDepartment(person.getDepartment());
        result.setProject(person.getProject());
        result.setRole(person.getRole());
        return result;
    }

    public List<PersonDTO> listPerson(int start, int limit) {
        EntityManager em = PersistenceHelper.getEntityManger();
        Query query = em.createQuery("select person from Person as person");
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public void updatePerson(PersonDTO personDTO) {

        Person person = personRepository.findById(personDTO.getId());
        person.setName(personDTO.getName());
        person.setDepartment(personDTO.getDepartment());
        person.setProject(personDTO.getProject());
        person.setLogin(personDTO.getLogin());
        person.setRole(personDTO.getRole());

        personRepository.update(person);
    }

    public void savePerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setDepartment(personDTO.getDepartment());
        person.setLogin(personDTO.getLogin());
        person.setPassword(personDTO.getPassword());
        person.setProject(personDTO.getProject());
        person.setRole(personDTO.getRole());
        personRepository.save(person);
    }

    public List<Project> allProjects() {

        List<Project> result = new ArrayList<Project>();

        result.add(new Project("项目1"));
        result.add(new Project("项目2"));
        result.add(new Project("项目3"));

        return result;
    }

    public List<Department> allDepartments() {
        List<Department> result = new ArrayList<Department>();
        result.add(new Department("部门1"));
        result.add(new Department("部门２"));
        result.add(new Department("部门3"));

        return result;
    }

    public int countPersons() {
        return personRepository.totalCount();
    }

    public PersonDTO login(String username, String password) throws LoginException {
        PersonDTO personDTO = new PersonDTO();

        Person person = loginService.login(username, password);

        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setLogin(person.getLogin());
        personDTO.setDepartment(person.getDepartment());
        personDTO.setRole(person.getRole());
        personDTO.setProject(person.getProject());

        return personDTO;
    }
}
