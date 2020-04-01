package ru.vsu.lab.store.injection;

import ru.vsu.lab.store.anotation.LabInject;
import ru.vsu.lab.store.exceptions.InjectionFailedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Class that can inject smth
 */
public class Injector {

    /**Function for injection some instance
     * @param obj object to be injected into
     * @param <T> class of object to be injected into
     * @return object with applying injection
     * @throws InjectionFailedException injection exception
     */
    public static <T> T inject(T obj) throws InjectionFailedException {
        Properties properties=GetPropertiesFromPropertyFile("src/main/resources/inject.properties");
        for(Field field:obj.getClass().getDeclaredFields())
        {
            field.setAccessible(true);
            if (field.isAnnotationPresent(LabInject.class))
            {
                Class classs=field.getType();
                String className=classs.getName();
                String cls=properties.getProperty(className);
                Class clazz= null;
                try {
                    clazz = Class.forName(cls);
                    Object injectionObject= null;
                    injectionObject = clazz.newInstance();
                    field.set(obj, injectionObject);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    throw new InjectionFailedException(e);
                }
            }
        }
        return obj;
    }

    /**
     * @param filename filepath
     * @return properties from file
     */
    private static Properties GetPropertiesFromPropertyFile(String filename) throws InjectionFailedException {
        FileInputStream fileInputStream;
        Properties properties=new Properties();
        try {
            fileInputStream=new FileInputStream(filename);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new InjectionFailedException(e);
        }
        return properties;
    }
}
