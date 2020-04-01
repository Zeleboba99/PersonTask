package ru.vsu.lab.store.sorters;


import java.util.Comparator;
import java.util.Optional;

/**Class for bubble sort
 * @param <T> type of sortable objects
 */
public class BubbleSorter<T> implements ISorter<T>{

    /**Function for sort array
     * @param comparator comparator for objects
     * @param people array for sort
     */
    public void sort(Comparator<T> comparator, T[] people) {
        int i, j;
        T x;
        for( i=0; i < people.length; i++) {
            for( j = people.length-1; j > i; j-- ) {
                if ( Optional.ofNullable(people[j]).isPresent() && comparator.compare(people[j-1], people[j])>0 ) {
                    x=people[j-1]; people[j-1]=people[j]; people[j]=x;
                }
            }
        }
    }
}
