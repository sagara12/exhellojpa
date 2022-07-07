package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

   /* @Column(name = "TEAM_ID")
    private Long teamId;*/

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    //@JoinColumn(name = "TEAM_ID",insertable = false, updatable = false) 일대다를 양방향으로 만들때 사용 -> 읽기 전용으로 만듬
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
