package data.respositories;


import data.models.User;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserRepositoryImplTest{

    UserRepository userRepositoryImplementation;
    @Before
    public void startWith() {
        userRepositoryImplementation = new userRepositoryImplementation();
    }

    @Test
    public void repositoryIsEmptyUponCreation(){
        assertEquals(0L, userRepositoryImplementation.getCount());
    }

    @Test
    public void saveUserCountIncreases(){
        User user = new User();
        userRepositoryImplementation.save(user);
        assertEquals(1L, userRepositoryImplementation.getCount());
    }

    @Test
    public void saveUserIsReturned(){
        User user = new User();
        assertEquals(user, userRepositoryImplementation.save(user));
    }

    @Test
    public void saveUserIdIsSet(){
        User user = new User();
        userRepositoryImplementation.save(user);
        assertEquals(1, user.getUserId());
    }

    @Test
    public void findByIdUserIsReturned(){
        User user = new User();
        userRepositoryImplementation.save(user);
        assertEquals(user, userRepositoryImplementation.findById(1));
    }

    @Test
    public void findByIdWithNumberGreaterThanCountReturnNull(){
        assertNull(userRepositoryImplementation.findById(1));
    }

    @Test
    public void findByIdWithNumberEqualTo0OrLessThan0ReturnNull(){
        assertNull(userRepositoryImplementation.findById(0));
        assertNull(userRepositoryImplementation.findById(-1));
    }

    @Test
    public void existsByIdTest(){
        User user = new User();
        userRepositoryImplementation.save(user);
       assertTrue(userRepositoryImplementation.existsById(1));
    }

    @Test
    public void existsByIdWithInvalidIdTest(){
        assertFalse(userRepositoryImplementation.existsById(1)) ;
        assertFalse(userRepositoryImplementation.existsById(-1));
        assertFalse(userRepositoryImplementation.existsById(0));
    }

    @Test
    public void deleteByIdUserIsDeletedCountDecreases(){
        User user = new User();
        userRepositoryImplementation.save(user);
        userRepositoryImplementation.deleteById(1);
        assertEquals(0L, userRepositoryImplementation.getCount());
    }

    @Test
    public void deleteAll_CountIs0(){
        User user = new User();
        userRepositoryImplementation.save(user);
        userRepositoryImplementation.deleteAll();
        assertEquals(0L, userRepositoryImplementation.getCount());
    }

    @Test
    public void saveUserWithSameId(){
        User user = new User();
        userRepositoryImplementation.save(user);
        User user2 = new User();
        user2.setUserId(1);
        userRepositoryImplementation.save(user2);
        assertEquals(1L, userRepositoryImplementation.getCount());
    }


}
