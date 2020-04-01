package ru.vsu.lab.store.repository;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;
import ru.vsu.lab.store.anotation.LabInject;
import ru.vsu.lab.store.entities.Person;
import ru.vsu.lab.store.sorters.ISorter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/**
 * Class for store objects
 */
@XmlRootElement
public class GenericRepository<T> implements IRepository<T> {

    /**Num of array resize */
    private final static int numOfResize = 5;
    /**Stored objects*/
    @XmlElements({
            @XmlElement(type = Person.class, nillable = true)
    })
    private T[] objects;

    /**
     * Sorter for repository
     */
    @LabInject
    private ISorter<T> sorter;


    /**
     * Empty constructor
     */
    public GenericRepository() {
        objects = (T[]) Array.newInstance(Object.class,1);
    }

    /**
     * Constructor with params
     * @param objects stored objects
     */
    public GenericRepository(T[] objects) {
        this.objects = objects;
    }


    /**
     * Function for adding object in repository
     * @param obj object
     */
    @Override
    public void add(T obj) {
        if (tryAdd(obj))
            return;
        objects = Arrays.copyOf(objects, objects.length + numOfResize);
        tryAdd(obj);
    }

    /**
     * Function for removing by index in repository
     * @param index index in repo
     * @return Removing object
     */
    @Override
    public T delete(int index) {
        try {
            if (index>=getLastIndexOfNotNull()+1 || index<0)
                    throw new Exception();
            T person= objects[index];
            System.arraycopy(objects, index+1, objects, index, objects.length-index-1);
            objects[objects.length-1]=null;
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function for receiving from repository
     * @param index index in repo
     * @return Getting person
     */
    @Override
    public T get(int index) {
        try {
            if (index >= getLastIndexOfNotNull() + 1 || index < 0)
                throw new Exception();
            return objects[index];
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function for set object in repo
     * @param index index in repo
     * @param obj settable object
     * @return settable object
     */
    @Override
    public T set(int index, T obj) {
        try {
            if (index >= getLastIndexOfNotNull() + 1 || index < 0)
                throw new Exception();
            objects[index] = obj;
            return obj;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function for adding object in repository
     * @param index index in repo
     * @param obj settable object
     */
    @Override
    public void add(int index, T obj) {
        if (index>getLastIndexOfNotNull()+1 || index<0)
            return;
        T[] newArr =(T[])new Objects[objects.length+1];
        System.arraycopy(objects, 0, newArr, 0,objects.length-1);
        newArr[index]=obj;
        System.arraycopy(objects, index, newArr, index+1, objects.length-index);
        objects = Arrays.copyOf(newArr,newArr.length);
    }

    /**Function to convert repo to lost
     * @return list of repo objects
     */
    @Override
    public List<T> toList() {
        return Arrays.asList(objects);
    }

    /**
     * Function for sort objects in repo
     * @param comparator comparator for objects
     */
    @Override
    public void sortBy(Comparator<T> comparator) {
        sorter.sort(comparator, objects);
    }

    /**
     * Function for searching in repo
     * @param condition condition for searching
     * @return new repo
     */
    @Override
    public IRepository<T> searchBy(Predicate<T> condition) {
        IRepository<T> newRepository=new GenericRepository();
        for (T person : objects) {
            if (Optional.ofNullable(person).isPresent() && condition.test(person)) {
                newRepository.add(person);
            }
        }
        return newRepository;
    }


    /**
     * Function checked possibility adding and add if it's possible
     * @param obj object
     * @return is object was added
     */
    private boolean tryAdd(T obj) {
        for (int i = 0; i< objects.length; i++) {
            if (!Optional.ofNullable(objects[i]).isPresent()) {
                objects[i]=obj;
                return true;
            }
        }
        return false;
    }


    /**Function to get last index of null value in repo
     * @return last index of null
     */
    private int getLastIndexOfNotNull(){
        for(int i = objects.length-1; i<=0; i--){
            if (objects[i]!=null)
                return i;
        }
        return 0;
    }


}
