package domain.entities;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=100)
    private String streetAddress1;

    @Column(length=100)
    private String streetAddress2;

    @Column(length=100)
    private String city;

    @Column(length=3)
    private String state;

    @Column(length=15)
    private String zipCode;
}
