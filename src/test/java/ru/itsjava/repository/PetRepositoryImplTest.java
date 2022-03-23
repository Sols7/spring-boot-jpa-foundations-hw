package ru.itsjava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@Import(PetRepositoryImpl.class)
public class PetRepositoryImplTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PetRepository petRepository;

    @Test
    public void shouldHaveCorrectGetById() {
        var expectedPet = entityManager.find(Pet.class, 1L);
        var actualPet = petRepository.getById(1L);

        Assertions.assertEquals(expectedPet, actualPet);
    }

    @Test
    public void shouldHaveCorrectInsert() {
        var insertPet = new Pet(4l, "insertPet");
        petRepository.insert(insertPet);
        var actualPet = petRepository.getById(4L);

        Assertions.assertEquals(insertPet, actualPet);
    }

    @Test
    public void shouldHaveCorrectUpdate() {
        var updatePet = petRepository.getById(1L);
        updatePet.setSpecies("updatePet");
        petRepository.update(updatePet);
        var actualPet = petRepository.getById(1L);

        Assertions.assertEquals("updatePet", actualPet.getSpecies());
    }

    @Test
    public void shouldHaveCorrectDeleteById() {
        petRepository.deleteById(3L);
        var deletedPet = petRepository.getById(3L);

        Assertions.assertNull(deletedPet);
    }
}
