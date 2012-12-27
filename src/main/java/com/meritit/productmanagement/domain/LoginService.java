package com.meritit.productmanagement.domain;


public class LoginService {

    private PersonRepository personRepository;

    public LoginService(PersonRepository personRepository) {

        this.personRepository = personRepository;

    }

    public Person login(String login, String password) throws LoginException {
        Person person = personRepository.findByLoginAndPassword(login, password);
        return person;
    }
}
