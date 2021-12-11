package by.martysiuk.sanatoriumApp.models;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "person_amount")
    private int personAmount;

    @Column(name = "arrive_date")
    private String arriveDate;

    @Column(name = "leave_date")
    private String leaveDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username"/*, insertable = false, updatable = false*/)
    private User user;

}
