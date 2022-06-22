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
            /*

            Member member  = new Member();
            member.setId(2L);
            member.setName("HelloB");*/

            /*Member member = em.find(Member.class, 1l);
            member.setName("HelloJPA");

            em.persist(member);*/

           /* List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for (Member member: result) {
                System.out.println("member.getName() = " + member.getName());
            }
            */

           /* Member member = em.find(Member.class, 150l);
            member.setName("Update");
            */

            /*Member member = new Member(200l, "member200");
            em.persist(member);*/

            //영속
            Member member = new Member(150l, "member200");
            member.setName("AAAAAAA");

            //비영속
            //em.detach(member);
            em.clear();
            em.close();

            em.flush();
            System.out.println("==================================================" );
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
