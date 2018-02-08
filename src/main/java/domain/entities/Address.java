package domain.entities;
//
//import javax.persistence.*;
//
//@Entity
public class Address {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Address(String state, String city, String zipCode, String street){
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.streetAddress1 = street;
    }

//    @Column(length=100)
    private String streetAddress1;

//    @Column(length=100)
    private String streetAddress2;

//    @Column(length=100)
    private String city;

//    @Column(length=3)
    private String state;

//    @Column(length=15)
    private String zipCode;

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
