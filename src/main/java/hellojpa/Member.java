package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "MBR") 테이블이름이 다를 때
public class Member {

    public Member() {

    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    @Id
    private Long id;
    private String name;
    private int go;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
