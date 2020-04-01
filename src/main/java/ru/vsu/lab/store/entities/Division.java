package ru.vsu.lab.store.entities;

import ru.vsu.lab.entities.IDivision;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class Division implements IDivision {


    /**Field id*/
    private Integer id;
    /**Field name*/
    private String name;

    /**Empty constructor*/
    public Division() { }


    /**
     * Constructor with params
     * @param id division's id
     * @param name division's name
     */
    public Division(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Function for get {@link Division#id}
     * @return division's id
     */
    @Override
    @XmlAttribute
    public Integer getId() {
        return id;
    }

    /**
     * Function for set {@link Division#id}
     * @param id division's id
     */
    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    /**Function for get {@link Division#name}
     * @return division's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**Function for set {@link Division#name}
     * @param name division's name
     */
    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals(name, division.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
