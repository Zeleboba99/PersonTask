package ru.vsu.lab.store.stream;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.store.loaders.CSVLoader;
import ru.vsu.lab.store.repository.GenericRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PeopleStreams {
    private GenericRepository<IPerson> genericRepository = new GenericRepository<>();
    private CSVLoader csvLoader = new CSVLoader();

    public PeopleStreams() {
        csvLoader.loadCSVFile("./src/main/resources/persons.csv", genericRepository);
    }

    public Map<IDivision, Integer> getDepartments() {
        List<IPerson> people = genericRepository.toList();
        return people.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(IPerson::getDivision, Collectors.summingInt(IPerson::getAge)));
    }

    public List<IPerson> getEmployees() {
        List<IPerson> people = genericRepository.toList();
        return people.stream().filter(Objects::nonNull).filter(p -> p.getAge() > 30 && p.getSalary().intValue() < 3000 && p.getFirstName().toLowerCase().contains("a")).collect(Collectors.toList());
    }

    public List<IPerson> getEmployeesWithAA() {
        List<IPerson> people = genericRepository.toList();
        List<IPerson> personList = people.stream().filter(Objects::nonNull).filter((p) -> p.getFirstName().toLowerCase().contains("aa")).collect(Collectors.toList());
        return personList;
        //personList.forEach(System.out::println);
    }

    public Map<LocalDate, Long> getMapByBirthdate() {
        List<IPerson> people = genericRepository.toList();
        return people.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(IPerson::getBirthdate, Collectors.counting()));
    }

}
