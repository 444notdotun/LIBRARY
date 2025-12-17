package data.respositories;

import data.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getUserList();
    long getCount();

    User save(User user);

    User findById(int Id);

    boolean existsById(int Id);

    void delete(User element);

    void deleteById(int Id);

    void deleteAll();
}
