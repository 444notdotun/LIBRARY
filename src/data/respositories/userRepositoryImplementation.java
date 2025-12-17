package data.respositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class userRepositoryImplementation implements UserRepository {
    int count;
    private static List<User> userList= new ArrayList<>();
    @Override
    public long getCount() {
        return userList.size();
    }

    @Override
    public User save(User user){
        if(user == null) return null;
        if(isNew(user)){ saveNewBook(user);return user;}
        update(user);return user;
    }

private boolean isNew(User user){return user.getUserId() == 0;}

private void saveNewBook(User user) {count++; userList.add(user); userList.get(count - 1).setUserId(count);}

private void update (User user){deleteById((user.getUserId()));userList.add(user);}

    @Override
    public User findById(int Id) {
        if(Id <1||Id > userList.size()) return null;
        return userList.get(Id-1);

    }

    @Override
    public boolean existsById(int Id) {
        return Id > 0 && Id <= count;
    }

    @Override
    public void delete(User element) {
        userList.remove(element);
    }

    @Override
    public void deleteById(int Id) {
        userList.remove(findById(Id));
    }

    @Override
    public void deleteAll() {
        userList.clear();
    }


    public List<User> getUserList() {
        return userList;
    }
}
