
public class MyVector<E> extends MyAbstractList<E> {

    private int capacity = 10;
    private int increment = 5;
    E[] myList;
    E[] myNewList;

    @SuppressWarnings("unchecked")
    public MyVector() {
        size = 0;
        myList = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity) {
        size = 0;
        this.capacity = capacity;
        myList = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity, int increment) {
        size = 0;
        this.capacity = capacity;
        this.increment = increment;
        myList = (E[]) new Object[capacity];
    }


    @Override @SuppressWarnings("unchecked")
    public boolean add(E data) {
        if (size == capacity) {
            myNewList = (E[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                myNewList[i] = myList[i];
            }
            myList = (E[]) new Object[capacity + increment];
            for (int i = 0; i < capacity; i++) {
                myList[i] = myNewList[i];
            }

        }
        myList[size] = data;
        size++;

        return true;

    }

    @Override @SuppressWarnings("unchecked")
    public boolean add (int index, E data) {

        if(size == capacity) {
            myNewList = (E[]) new Object[capacity];
            for(int i = 0; i < capacity; i++) {
                myNewList[i] = myList[i];
            }
            myList = (E[]) new Object[capacity + increment];
            for(int i = 0; i < capacity; i++) {
                myList[i] = myNewList[i];
            }

        }
        myNewList = (E[]) new Object[size + 1];

            for (int i = 0; i < index; i++) {
                myNewList[i] = myList[i];
            }
            for (int i = index + 1; i < size + 1; i++) {
                myNewList[i] = myList[i - 1];
            }
            myNewList[index] = data;

            myList = (E[]) new Object[myNewList.length];
            for (int i = 0; i < myNewList.length; i++) {
                myList[i] = myNewList[i];
            }

        size++;
        return true;
    }

    @Override @SuppressWarnings("unchecked")
    public void clear() {

        int x = getCapacity();
        myList = (E[]) new Object[x];
        size = 0;

    }

    @Override
    public E get(int index) {

        return myList[index];

    }

    @Override @SuppressWarnings("unchecked")
    public E remove(int index) {

        myNewList = (E[]) new Object[size - 1];
        for (int i = 0; i < index; i++) {
            myNewList[i] = myList[i];
        }
        for (int i = index; i < size - 1; i++) {
            myNewList[i] = myList[i + 1];
        }
        myList = (E[]) new Object[myNewList.length];
        for (int i = 0; i < myNewList.length; i++) {
            myList[i] = myNewList[i];
        }
        size--;
        return myList[index];

    }

    @Override @SuppressWarnings("unchecked")
    public void trimToSize() {

        if (size < getCapacity() ) {

            for(int i = 0; i < myList.length; i++) {
                myNewList[i] = myList[i];
            }
            myList = (E[]) new Object[size];
            for(int i = 0; i < size; i++) {
                myList[i] = myNewList[i];
            }

        }

    }

    @Override
    public String toString(){
        String message = "[";
        for(int i = 0; i < size; i++){
            if(i == size -1) {
                message += myList[i] + "]";
            }
            else {
                message += myList[i] + ", ";
            }
        }
        return message;
    }


    public int getCapacity() {
        return capacity;
    }

    public int getIncrement() {
        return increment;
    }
}
