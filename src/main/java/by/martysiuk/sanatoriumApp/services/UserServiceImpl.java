package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.dao.UserRepo;
import by.martysiuk.sanatoriumApp.models.Role;
import by.martysiuk.sanatoriumApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    //FIX ME
    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        Role userRole = new Role();
        userRole.setRole("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(userRole);

        user.setRoleSet(roleSet);
        user.setPassword(encodedPassword);
        user.setEnabled(true);
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

    /*@Override
    public void updateUser(User user) {
        userRepo.save(user);
        //userRepo.updateUser(user.getUsername(), user.isEnabled(), user.getRoleSet(), user.getId());
    }*/

    @Override
    public void unblockUser(User user) {
        user.setEnabled(true);
        //updateUser(user);
        userRepo.save(user);
    }

    @Override
    public void blockUser(User user) {
        user.setEnabled(false);
        //updateUser(user);
        userRepo.save(user);
    }
}
