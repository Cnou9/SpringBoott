package com.example.demostreamapi;

import com.example.demostreamapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoStreamApiApplicationTests {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void test() {
        personRepository.printListPeople(personRepository.inAgeRange(20,30));
    }

}
