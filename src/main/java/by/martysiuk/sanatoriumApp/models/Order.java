package by.martysiuk.sanatoriumApp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 1, message = "Кол-во человек должно быть в пределах (1-6)!")
    @Max(value = 6, message = "Кол-во человек должно быть в пределах (1-6)!")
    @Column(name = "person_amount")
    private int personAmount;

    @NotEmpty(message = "Название номера не может быть пустым!")
    @Size(min = 4, max = 30, message = "Название номера должно содержать 4-30 символов!")
    @Column(name = "arrive_date")
    private String arriveDate;

    @Min(value = 7, message = "Кол-во дней должно быть в пределах (7-21)!")
    @Max(value = 21, message = "Кол-во дней должно быть в пределах (7-21)!")
    @Column(name = "days_amount")
    private int daysAmount;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "room_id")
    private int roomId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Order() {}

    public Order(int id, int personAmount, String arriveDate, int daysAmount, int userId, int roomId, Room room, User user) {
        this.id = id;
        this.personAmount = personAmount;
        this.arriveDate = arriveDate;
        this.daysAmount = daysAmount;
        this.userId = userId;
        this.roomId = roomId;
        this.room = room;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id && personAmount == order.personAmount && daysAmount == order.daysAmount && Objects.equals(arriveDate, order.arriveDate) && Objects.equals(room, order.room) && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personAmount, arriveDate, daysAmount, room, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", personAmount=" + personAmount +
                ", arriveDate='" + arriveDate + '\'' +
                ", daysAmount=" + daysAmount +
                ", room=" + room +
                ", user=" + user +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public int getPersonAmount() {
        return personAmount;
    }

    public void setPersonAmount(int personAmount) {
        this.personAmount = personAmount;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public int getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(int daysAmount) {
        this.daysAmount = daysAmount;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
