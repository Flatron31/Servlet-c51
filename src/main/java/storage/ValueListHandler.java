package storage;

import entity.User;

import java.util.List;
import java.util.ListIterator;

public class ValueListHandler implements ValueListIterator<User> {
    InMemoryDBRepository inMemoryDBRepository = new InMemoryDBRepository();
    private ListIterator<User> userListIterator;
    private List<User> users;

    public ValueListHandler() {
       users = inMemoryDBRepository.getUsers();
       userListIterator = users.listIterator();
    }

    @Override
    public int getSize() throws IteratorException {
        return users.size();//количество элементов в базе
    }

    @Override
    public List<User> getPreviousElements(int count) throws IteratorException {
        while(userListIterator.hasPrevious() && (count != 0) ){
            users.add(userListIterator.next());
            count--;
        }
        return users;
    }

    @Override
    public List<User> getNextElements(int count) throws IteratorException {
        while(userListIterator.hasNext() && (count != 0) ){
            users.add(userListIterator.next());
            count--;
        }
        return users;
    }

    @Override
    public void resetIndex() throws IteratorException {
        userListIterator = users.listIterator();
    }



}
