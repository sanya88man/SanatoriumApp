package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.repositories.RoleRepo;
import by.martysiuk.sanatoriumApp.models.Role;
import by.martysiuk.sanatoriumApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void addAdminRole(User user) {
        Role userRole = roleRepo.findByRole("ROLE_ADMIN");
        setRole(userRole, user);
    }

    @Override
    public void addUserRole(User user) {
        Role userRole = roleRepo.findByRole("ROLE_USER");
        setRole(userRole, user);
    }

    public void setRole(Role userRole, User user) {
        Set<Role> roleSet = user.getRoleSet();
        roleSet.add(userRole);
        user.setRoleSet(roleSet);
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        userRole.setUserSet(userSet);
        roleRepo.save(userRole);
    }
}
