package ru.vsu.lab.store.stream;

import org.junit.Test;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PeopleStreamsTest {

    private PeopleStreams peopleStreams = new PeopleStreams();

    @Test
    public void getDepartments() {
        Map<IDivision, Integer> map=peopleStreams.getDepartments();
        map.forEach((k,v)->System.out.println(k.toString()+" "+v.toString()));
    }

    @Test
    public void getEmployees() {
        List<IPerson> list=peopleStreams.getEmployees();
        list.forEach(System.out::println);
    }

    @Test
    public void getEmployeesWithAA() {
        List<IPerson> list=peopleStreams.getEmployeesWithAA();
        list.forEach(System.out::println);
    }

    @Test
    public void getMapByBirthdate() {
        Map<LocalDate, Long> map=peopleStreams.getMapByBirthdate();
        map.forEach((k,v)->System.out.println(k.toString()+" "+v.toString()));
    }
}