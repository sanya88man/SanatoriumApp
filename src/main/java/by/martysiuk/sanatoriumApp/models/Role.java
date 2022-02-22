package by.martysiuk.sanatoriumApp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String role;

    @ManyToMany(mappedBy = "roleSet", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<User> userSet = new HashSet<>();

    public Role() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role1 = (Role) o;
        return getId() == role1.getId() && Objects.equals(getRole(), role1.getRole()) && Objects.equals(getUserSet(), role1.getUserSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRole(), getUserSet());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userList) {
        this.userSet = userList;
    }

    public Role(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
