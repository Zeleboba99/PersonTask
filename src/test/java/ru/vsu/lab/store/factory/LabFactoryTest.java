package ru.vsu.lab.store.factory;

import org.junit.Test;
import ru.vsu.lab.repository.IRepository;
import ru.vsu.lab.store.entities.Person;

public class LabFactoryTest {

    private LabFactory labFactory=new LabFactory();
    @Test
    public void createRepository() {
        IRepository<Person> repo=labFactory.createRepository(Person.class);
    }
}