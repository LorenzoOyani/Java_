package org.example.List_stacks;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected static int size = 0;

    protected MyAbstractList() {
    }

    // create a list from an arrays of Objects
    // don't use super(objects).
    protected MyAbstractList(E[] objects) {
        for (E n : objects) {
            add(n);
        }
    }

    @Override
    public void add(E e) {
        add(size, e);

    }

    public void add(int size, E e) {
        this.size = size;
        this.add(e);
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E e) {
        boolean isobject = false;
        for (int i = 0; i < size; i++) {
            if (e.equals(i)) {
                remove(i);
                isobject = true;
            }
        }
        return isobject;
    }

    @Override
    public int size() {
        return size;
    }
}
