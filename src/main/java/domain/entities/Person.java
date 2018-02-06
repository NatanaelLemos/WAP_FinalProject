package domain.entities;

//import javax.persistence.*;
import java.util.Date;

public abstract class Person {

//    @Column(length=255)
    private String name;

//    @Column(length=255)
    private String email;

//    @Column(length=20)
    private String phone;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "address_id")
    private Address address;

    private Date birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
