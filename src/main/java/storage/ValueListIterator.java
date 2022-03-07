package storage;

import java.util.List;

public interface ValueListIterator<T> {

    int getSize()
            throws IteratorException;


    List<T> getPreviousElements(int count)
            throws IteratorException;

    List<T> getNextElements(int count)
            throws IteratorException;

    void resetIndex()
            throws IteratorException;
}
