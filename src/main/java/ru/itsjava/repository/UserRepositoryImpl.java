package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private final EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager
                .createQuery("select distinct u from users u join fetch u.pet", User.class).getResultList();
    }
}
