package ru.itsjava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@Import(UserRepositoryImpl.class)
public class UserRepositoryImplTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldHaveCorrectFindAllUsers() {
        var expectedUsers = entityManager
                .createQuery("select distinct u from users u join fetch u.pet", User.class).getResultList();
        var actualUsers = userRepository.findAll();

        Assertions.assertEquals(expectedUsers, actualUsers);
    }

}
