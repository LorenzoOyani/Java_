package org.example.threads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * CurrentModificationException is thrown for non-deterministic behavior if a collection
 * is being modified by another thread.
 * */

public class Synchronization {
    public void sync(Object o) {
        Set<String> hashset = Collections.synchronizedSet(new HashSet<>());
        synchronized (hashset) {
            Iterator<String> iterator = hashset.iterator();
            while ((iterator.hasNext())) {
                System.out.println(iterator.next());
            }

        }
    }


}
