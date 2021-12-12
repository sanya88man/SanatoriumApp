package by.martysiuk.sanatoriumApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "person_amount")
    private int personAmount;

    @Column(name = "arrive_date")
    private String arriveDate;

    @Column(name = "days_amount")
    private int daysAmount;

    /*@Column(name = "leave_date")
    private String leaveDate;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id"/*, insertable = false, updatable = false*/)
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username"/*, insertable = false, updatable = false*/)
    private User user;

    public Order() {}

    public Order(int id, int personAmount, String arriveDate, int daysAmount, Room room, User user) {
        this.id = id;
        this.personAmount = personAmount;
        this.arriveDate = arriveDate;
        this.daysAmount = daysAmount;
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
