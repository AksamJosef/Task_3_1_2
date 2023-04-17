package study.nigmat.boot.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import study.nigmat.boot.springboot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
        System.out.println("added");
    }

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("SELECT u from User u", User.class)
                .getResultList();
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(getById(id));
        System.out.println("deleted");
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "select u from User u where u.id = :id", User.class
        );
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findAny().orElse(null);
    }
}
