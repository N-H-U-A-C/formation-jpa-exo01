package dev.cb.zoo.persistence;

import dev.cb.zoo.entity.Animal;

import javax.persistence.EntityManager;
import java.util.Optional;

public class AnimalRepository {

    private final EntityManager entityManager;

    public AnimalRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addAnimal(Animal animal) {
        entityManager.getTransaction().begin();

        entityManager.persist(animal);

        entityManager.getTransaction().commit();
    }

    public Optional<Animal> find(int id) {
        entityManager.getTransaction().begin();

        Optional<Animal> optionalAnimal = Optional.ofNullable(entityManager.find(Animal.class, id));

        entityManager.getTransaction().commit();

        return optionalAnimal;
    }
}
