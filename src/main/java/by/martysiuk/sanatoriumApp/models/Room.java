package by.martysiuk.sanatoriumApp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Название номера не может быть пустым!")
    @Size(min = 4, max = 30, message = "Название номера должно содержать 4-30 символов!")
    private String name;

    @Min(value = 50, message = "Цена должна быть в пределах (50-999)!")
    @Max(value = 999, message = "Цена должна быть в пределах (50-999)!")
    private double price;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public Room() {}

    public Room(int id, String name, double price, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getId() == room.getId() && Double.compare(room.getPrice(), getPrice()) == 0 && Objects.equals(getName(), room.getName()) && Objects.equals(getOrders(), room.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getOrders());
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
