package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.dao.UserRepo;
import by.martysiuk.sanatoriumApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User showUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }



    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> showUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(String username) {
        userRepo.deleteByUsername(username);
    }

    @Override
    public void addAdmin(String username) {

    }

    @Override
    public void unblockUser(User user) {

    }

    @Override
    public void blockUser(String username) {

    }
}
