package ru.itsjava.repository;

import ru.itsjava.domain.Pet;

public interface PetRepository {
    Pet getById(long id);

    void insert(Pet pet);

    void update(Pet pet);

    void deleteById(long id);
}
