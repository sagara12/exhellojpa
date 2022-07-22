package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member =  new Member();
            member.setName("member1");
            em.persist(member);

            //flush -> commit, query

            String query = "select t From Team t ";

            List<Team> result = em.createQuery(query, Team.class)
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .getResultList();

            System.out.println("result = " + result.size());
            //em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME form MEMBER").getResultList();


          /*   List<Member> result = em.createQuery(
                    "select m From Member m where m.name like '%kim%'", Member.class
            ).getResultList();

            for (Member member : result) {
                System.out.println("member = " + member);
            }*/

            //Criteria 는 쿼리가 너무 복잡에서 실무에서 사용 X
            /*CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);
            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("name"), "kim" ));
            List<Member> resultList = em.createQuery(cq).getResultList();*/

            tx.commit();

          /*  Member member1 = new Member();
            member1.setName("member1");
            em.persist(member1);

            *//*Member member2 = new Member();
            member2.setName("member2");
            em.persist(member2);*//*

            Team team = new Team();
            team.setName("teamA");
            member1.setTeam(team);
            em.persist(team);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
           *//* Member m2 = em.getReference(Member.class, member1.getId());*//*

            System.out.println("m1 == m2 " + (m1 instanceof Member));
            System.out.println("m1.getClass() = " + m1.getClass());

             Member reference = em.getReference(Member.class, m1.getId());
            System.out.println("reference = " + reference.getClass());
           *//* System.out.println("m1 == m2 " + (m2 instanceof Member));*//*

            System.out.println("a == a " +  (m1 == reference));

//            Member findmember = em.find(Member.class, member.getId());
            Member findMemeber = em.find(Member.class, member1.getId());
            //프록시 인스턴스 초기화 여부 확인
            System.out.println("emf.getPersistenceUnitUtil().isLoaded(findMemeber) = " + emf.getPersistenceUnitUtil().isLoaded(findMemeber));
            //프록시 강제 초기화
            Hibernate.initialize(findMemeber);

            System.out.println("findMemeber.getClass() = " + findMemeber.getClass());
            System.out.println("findmember.getId() = " + findMemeber.getId());
            System.out.println("findmember = " + findMemeber.getName());*/

            /*Child child1 = new Child();
            Child child2 = new Child();

            Parent parent  = new Parent();
            parent.adChild(child1);
            parent.adChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();


            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);
            tx.commit();*/

            /*Member member = new Member();
            member.setName("KKD");
            member.setHomeAddress(new Address("city1", "street1","0"));
            member.setWorkPeriod(new Period());

            em.persist(member);
            tx.commit();*/

            /*Member member = new Member();
            member.setName("member1");
            member.setHomeAddress(new Address("Homecity1", "street1","zipcode1"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new AddressEntity("old2", "street1","zipcode1"));
            member.getAddressHistory().add(new AddressEntity("old1", "street1","zipcode1"));
            em.persist(member);

            em.flush();
            em.clear();*/
/*
            System.out.println("=======================start ==================================== ");
            Member findMember = em.find(Member.class, member.getId());*/
           /*
            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address.getCity() = " + address.getCity());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }*/
           /* Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("new City", a.getStreet(), a.getZipcode()));
            //치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddressHistory().remove(new AddressEntity("old1", "street1","zipcode1"));
            findMember.getAddressHistory().remove(new AddressEntity("newCity1", "street1","zipcode1"));*/


        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
    
    private static void printMember(Member member) {
        System.out.println("member.getName() = " + member.getName());
    }
    
    private static void printMemberAndTeam(Member member) {
        String username = member.getName();
        System.out.println("member.getName() = " + username);

        Team team = member.getTeam();
        System.out.println("team.getName() = " + team.getName());
    }
}
