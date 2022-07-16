package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    public  AddressEntity (String city, String street, String zip) {
        this.address = new Address(city,street, zip);
    }

    @Id
    @GeneratedValue
    private Long id;

    private Address address;

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
