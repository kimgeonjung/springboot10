package edu.du.sb1023;

import edu.du.sb1023.entity.Member;
import edu.du.sb1023.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@SpringBootTest
class Sb1023ApplicationTests {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void test_save(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Team team = new Team("team1", "1팀");
        em.persist(team);

        Member member1 = new Member("hong", "홍길동", team);
        em.persist(member1);
        Member member2 = new Member("kim", "김씨");
        member2.setTeam(team);
        em.persist(member2);

        em.getTransaction().commit();

        System.out.println(team);
        System.out.println(member1);
        System.out.println(member2);
    }

    @Test
    void test_find(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String jpql = "select m from Member m join m.team t where t.name =:teamName";
        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "1팀")
                .getResultList();
        for (Member member : resultList) {
            System.out.println(member);
        }

        em.getTransaction().commit();
    }

    @Test
    void test_find2(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Member member = em.find(Member.class, "hong");
        System.out.println(member);
        System.out.println(member.getTeam());

        em.getTransaction().commit();
    }

    @Test
    void test_update(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Team team2 = new Team("team2", "2팀");
        em.persist(team2);
        em.find(Member.class, "hong").setTeam(team2);

        em.getTransaction().commit();
    }

    @Test
    void test_연관관계제거(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Member member = em.find(Member.class, "hong");
        member.setTeam(null);

        em.getTransaction().commit();
    }

    @Test
    void test_연관된_엔티티삭제(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Member memberKim = em.find(Member.class, "kim");
        memberKim.setTeam(null);

        Team team = em.find(Team.class, "team2");
        em.remove(team);

//        Team team2 = em.find(Team.class, "team1");
//        em.remove(team2);

        em.getTransaction().commit();
    }

    @Test
    void test_양방향탐색(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Team team = em.find(Team.class, "team1");
//        team.getMembers().forEach(t -> System.out.println("member.username=" + t.getUsername()));
        for (Member member : team.getMembers()) {
            System.out.println(member);
        }

        em.getTransaction().commit();
    }


    @Test
    void test_순수객체() {
        Member member = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");
        Team team = new Team("team1", "팀1");

        member.setTeam(team);
        member2.setTeam(team);
        System.out.println(member);
        System.out.println(member2);
    }
}
