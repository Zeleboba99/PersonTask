package ru.vsu.lab.store.factory;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;
import ru.vsu.lab.store.entities.Division;
import ru.vsu.lab.store.entities.Person;
import ru.vsu.lab.store.exceptions.InjectionFailedException;
import ru.vsu.lab.store.injection.Injector;
import ru.vsu.lab.store.repository.GenericRepository;
import java.lang.reflect.Array;


/**
 * Class factory
 */
public class LabFactory implements ILabFactory {
    /**Function for create {@link IPerson}
     * @return {@link IPerson}
     */
    @Override
    public IPerson createPerson() {
        return new Person();
    }

    /**Function for create {@link IDivision}
     * @return {@link IDivision}
     */
    @Override
    public IDivision createDivision() {
        return new Division();
    }

    /**Function for create {@link IRepository}
     * @param clazz class of elements, contains repository
     * @param <T> class of elements, contains repository
     * @return repository of T
     */
    @Override
    public <T> IRepository<T> createRepository(Class<T> clazz) {
        T[] arr= (T[]) Array.newInstance(clazz,1);
        try {
            return Injector.inject(new GenericRepository<T>(arr));
        } catch (InjectionFailedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IPersonRepository createPersonRepository() {
        return null;
    }
}
