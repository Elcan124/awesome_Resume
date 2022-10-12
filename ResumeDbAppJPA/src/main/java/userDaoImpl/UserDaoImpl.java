/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDaoImpl;

import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;
import entity.User;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {


    @Override
    public List<User> getAll() {
        EntityManager em = em();
        Query q = em.createQuery("select u from User u", User.class);
        return q.getResultList();
    }

    @Override
    public List<User> getAllbyNameSurnameAndNationality(String name, String surname, Integer nationalityID) {
        EntityManager em = em();
        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name =:name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname =:surname";
        }
        if (nationalityID != null) {
            jpql += " and u.nationalityId =:nID";
        }
        Query q = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if (nationalityID != null) {
            q.setParameter("nID", nationalityID);
        }

        return q.getResultList();

    }

    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();

        em.getTransaction().begin();//
        em.merge(u);
        em.getTransaction().commit();

        em.close();
        return true;

    }

    @Override
    public boolean removeUser(int id) {

        EntityManager em = em();
        Query q = em.createQuery("delete from User u where u.id =:uID", User.class);
                q.setParameter("uID" , id);
                em.getTransaction().begin();

                q.executeUpdate();
                em.getTransaction().commit();
                em.close();
        return true;


    }

    @Override
    public User getById(int userID) {
        EntityManager em = em();

        User u = em.find(User.class, userID);

        em.close();
        return u;

    }

    @Override
    public boolean addUser(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(u);

        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public User findByEmailandPassword(String email, String password) {
        EntityManager em = em();
        Query q = em.createQuery("select u  from User  u where u.email= :e and  u.password =:p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);
        List<User> uList = q.getResultList();
        if (uList.size() == 1) {
            return uList.get(0);
        }
        return null;

    }

    @Override
    public User findByEmail(String email) {
        EntityManager em = em();
        Query q = em.createQuery("select u  from User  u where u.email= :e ", User.class);
        q.setParameter("e", email);

        List<User> uList = q.getResultList();
        if (uList.size() == 1) {
            return uList.get(0);
        }
        return null;
    }

}
