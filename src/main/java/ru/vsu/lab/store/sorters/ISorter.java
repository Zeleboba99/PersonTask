package ru.vsu.lab.store.sorters;

import ru.vsu.lab.repository.IRepository;

import java.util.Comparator;

public interface ISorter<T> {
    void sort(Comparator<T> comparator, T[] people);
}
