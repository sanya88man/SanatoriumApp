package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.dao.RoleRepo;
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
    public void addAdmin(User user) {
        Set<Role> roleSet = user.getRoleSet();
        Role userRole = roleRepo.findByRole("ROLE_ADMIN");
        //Role userRole = roleRepo.getById(1);
        roleSet.add(userRole);
        user.setRoleSet(roleSet);

        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        userRole.setUserSet(userSet);
        //roleRepo.updateRole(userRole.getRole(), userRole.getId());
        roleRepo.save(userRole);
    }
}
