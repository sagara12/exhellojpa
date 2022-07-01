package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
           /* *//*

            Member member  = new Member();
            member.setId(2L);
            member.setName("HelloB");*//*

            *//*Member member = em.find(Member.class, 1l);
            member.setName("HelloJPA");

            em.persist(member);*//*

           *//* List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for (Member member: result) {
                System.out.println("member.getName() = " + member.getName());
            }
            *//*

           *//* Member member = em.find(Member.class, 150l);
            member.setName("Update");
            *//*

            *//*Member member = new Member(200l, "member200");
            em.persist(member);*//*

           *//* //영속
            Member member = new Member(150l, "member200");
            member.setName("AAAAAAA");
*//*
            *//*비영속
            em.detach(member);
            em.clear();
            em.close();

            em.flush();
            System.out.println("==================================================" );*//*
            Member member = new Member();
            member.setUsername("C");

            em.persist(member);*/

            //저장
            Team team = new Team();
            team.setName("TeamA");
            //team.getMembers().add(member); 연관관계 주인에다 넣어야됨
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            //team.getMembers().add(member); Member에 세팅!

            em.flush();
            em.clear();

            /*Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();
            
            for (Member m : members) {
                System.out.println("m = " + m.getName());
            }

            //
            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);
*/
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
