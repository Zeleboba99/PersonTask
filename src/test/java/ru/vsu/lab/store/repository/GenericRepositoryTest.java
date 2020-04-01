package ru.vsu.lab.store.repository;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;
import ru.vsu.lab.store.entities.Person;
import ru.vsu.lab.store.factory.LabFactory;
import ru.vsu.lab.store.loaders.CSVLoader;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GenericRepositoryTest {

    private IPerson[] people;
    private GenericRepository genericRepository;
    private static final String filePathCSV="./src/main/resources/persons.csv";

    @Before
    public void setUpPeopleData(){
        genericRepository =new GenericRepository();
        CSVLoader csvLoader=new CSVLoader();
        csvLoader.loadCSVFile(filePathCSV, genericRepository);
    }

    @Test
    public void add() {
        IPerson person=new Person(1, "John", "Lock", Gender.MALE, LocalDate.of(2019, Month.OCTOBER, 10), null, null);
        //person=null;
        genericRepository.add(person);
    }

    @Test
    public void delete() {
        IPerson person = (IPerson) genericRepository.get(0);
        IPerson deleted= (IPerson) genericRepository.delete(0);
        assertThat(person.getId(), is(deleted.getId()));
    }

    @Test
    public void get() {
        assertThat(genericRepository.get(0), Matchers.notNullValue());
    }
//
    @Test
    public void set() {
        IPerson person=new Person(1, "John", "Lock", Gender.MALE, LocalDate.of(2019, Month.OCTOBER, 10), null, null);
        genericRepository.set(0, person);
        assertThat(genericRepository.get(0), equalTo(person));
    }

    @Test
    public void toList() {
        List people=genericRepository.toList();
    }

    @Test
    public void sortBy() {
        genericRepository.sortBy(new Comparator<IPerson>() {
            @Override
            public int compare(IPerson o1, IPerson o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        assert(true);
    }

    @Test
    public void searchBy() {
        IRepository newRepo=genericRepository.searchBy(new Predicate<IPerson>() {
            @Override
            public boolean test(IPerson iPerson) {
                return iPerson.getId() == 28281;
            }
        });
        assertThat(newRepo.getClass(), equalTo(genericRepository.getClass()));
    }

    @Test
    public void createFactory()
    {
        Class<IPerson> personClass=IPerson.class;
        LabFactory labFactory=new LabFactory();
        GenericRepository<IPerson> genericRepository = (GenericRepository<IPerson>) labFactory.createRepository(personClass);
    }
}