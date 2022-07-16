package hellojpa;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    public  AddressEntity (String city, String street, String zip) {
        this.address = new Address(city,street, zip);
    }

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public AddressEntity() {
    }

    public AddressEntity(Address address) {
        this.address = address;
    }
}
