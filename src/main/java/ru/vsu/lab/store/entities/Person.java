package ru.vsu.lab.store.entities;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Класс человека со свойствами id, name, surname, birthday, sex
 * @author Елфимова Екатерина
 */

public class Person implements IPerson {

    /** Field ID*/
    private Integer id;
    /** Field name*/
    private String firstName;
    /** Field surname*/
    private String lastName;
    /** Field gender*/
    private Gender gender;
    /** Field birthdate*/
    private LocalDate birthdate;
    /** Field division*/
    private IDivision division;
    /** Field salary*/
    private BigDecimal salary;

    /**
     *Constructor
     * @param id идентификатор
     * @param firstName имя
     * @param lastName фамилия
     * @param birthdate дата рождения
     * @param gender пол
     */
    public Person(Integer id, String firstName, String lastName, Gender gender, LocalDate birthdate, IDivision division, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.division = division;
        this.salary = salary;
    }


    /**
     * Empty constructor
     */
    public Person() {
    }

    /**
     * Function for get id { @link Person#id }
     * @return id
     */
    @XmlAttribute
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Function for set id {@link Person#id}
     * @param id identification
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Function for get {@link Person#firstName}
     * @return {@link Person#firstName}
     */
    @XmlElement
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * Function for set {@link Person#firstName}
     * @param firstName people
     */
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Function for get {@link Person#lastName}
     * @return {@link Person#lastName}
     */
    @XmlElement
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * Function for set {@link Person#lastName}
     * @param lastName people
     */
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Function for get {@link Person#birthdate}
     * @return {@link Person#birthdate}
     */
    @XmlElement
    @Override
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Function for set {@link Person#birthdate}
     * @param birthdate people
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Function for get {@link Person#gender}
     * @return {@link Person#gender}
     */
    @XmlElement
    @Override
    public Gender getGender() {
        return gender;
    }

    /**
     * Function for set {@link Person#gender}
     * @param gender people
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Function for get {@link Person#salary}
     * @return person's salary
     */
    @XmlElement
    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Function for set {@link Person#salary}
     * @param salary person's salary
     */
    @Override
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * Function for get {@link Person#division}
     * @return person's division
     */
    @XmlElements({
            @XmlElement(type = Division.class, nillable = true)
    })
    @Override
    public IDivision getDivision() {
        return division;
    }

    /**
     * Function for set division
     * @param division person's division
     */
    @Override
    public void setDivision(IDivision division) {
        this.division = division;
    }

    /**
     * Function for get person's age
     * @return age
     */
    @XmlElement
    @Override
    public Integer getAge() {
        return (int)ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    /**
     * Function for convert {@link Person} to string
     * @return person's string
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
