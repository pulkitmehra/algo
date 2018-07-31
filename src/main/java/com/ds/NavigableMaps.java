package com.ds;

import org.junit.Test;

import java.util.*;
import java.util.Collections;

/**
 * Returns the greatest element in this set strictly less than the
 * given element, or {@code null} if there is no such element.
 */
//E lower(E e);

/**
 * Returns the greatest element in this set less than or equal to
 * the given element, or {@code null} if there is no such element.
 *
 */
//E floor(E e);

/**
 * Returns the least element in this set greater than or equal to
 * the given element, or {@code null} if there is no such element.
 */
//E ceiling(E e);

/**
 * Returns the least element in this set strictly greater than the
 * given element, or {@code null} if there is no such element.
 */
//E higher(E e);

/**
 * Retrieves and removes the first (lowest) element,
 * or returns {@code null} if this set is empty.
 */
//E pollFirst();

/**
 * Retrieves and removes the last (highest) element,
 * or returns {@code null} if this set is empty.
 */
//E pollLast();

/**
 * Returns an iterator over the elements in this set, in ascending order.
 */
//Iterator<E> iterator();

/**
 * Returns a reverse order view of the elements contained in this set.
 * The descending set is backed by this set, so changes to the set are
 * reflected in the descending set, and vice-versa.  If either set is
 * modified while an iteration over either set is in progress (except
 * through the iterator's own {@code remove} operation), the results of
 * the iteration are undefined.
 */
//NavigableSet<E> descendingSet();

/**
 * Returns an iterator over the elements in this set, in descending order.
 * Equivalent in effect to {@code descendingSet().iterator()}.
 */
//Iterator<E> descendingIterator();

/**
 * Returns a view of the portion of this set whose elements range from
 * {@code fromElement} to {@code toElement}.  If {@code fromElement} and
 * {@code toElement} are equal, the returned set is empty unless {@code
 * fromInclusive} and {@code toInclusive} are both true.  The returned set
 * is backed by this set, so changes in the returned set are reflected in
 * this set, and vice-versa.  The returned set supports all optional set
 * operations that this set supports.
 */
//NavigableSet<E> subSet(E fromElement, boolean fromInclusive,E toElement, boolean toInclusive);

/**
 * Returns a view of the portion of this set whose elements are less than
 * (or equal to, if {@code inclusive} is true) {@code toElement}.  The
 * returned set is backed by this set, so changes in the returned set are
 * reflected in this set, and vice-versa.  The returned set supports all
 * optional set operations that this set supports.
 */
//NavigableSet<E> headSet(E toElement, boolean inclusive);

/**
 * Returns a view of the portion of this set whose elements are greater
 * than (or equal to, if {@code inclusive} is true) {@code fromElement}.
 * The returned set is backed by this set, so changes in the returned set
 * are reflected in this set, and vice-versa.  The returned set supports
 * all optional set operations that this set supports.
 *
 */
//NavigableSet<E> tailSet(E fromElement, boolean inclusive);

/**
 * <p>Equivalent to {@code subSet(fromElement, true, toElement, false)}.
 @throws IllegalArgumentException {@inheritDoc}
 */
//SortedSet<E> subSet(E fromElement, E toElement);

/**
 * <p>Equivalent to {@code headSet(toElement, false)}.
 */
//SortedSet<E> headSet(E toElement);

/**
 * {@inheritDoc}
 *
 * <p>Equivalent to {@code tailSet(fromElement, true)}.
 */
//SortedSet<E> tailSet(E fromElement);
public class NavigableMaps {

    int arr[] = {2, 3, 4, 5, 6, 11, 9};


    @Test
    public void navigableSets() {
        NavigableSet<Integer> sets = new TreeSet<>();
        for (int i : arr) {
            sets.add(i);
        }

        SortedSet<Integer> head = sets.headSet(5);
        System.out.println(head);

        SortedSet<Integer> tail = sets.tailSet(6);
        System.out.println(tail);

        System.out.println(sets.higher(6));
        System.out.println(sets.ceiling(6));

        System.out.println(sets.subSet(3,false,11, false));

    }


}
