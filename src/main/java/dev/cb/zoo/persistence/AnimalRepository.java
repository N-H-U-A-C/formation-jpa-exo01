package dev.cb.zoo.persistence;

import dev.cb.zoo.entity.Animal;
import dev.cb.zoo.entity.Diet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
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

    public List<Animal> findByName(String name) {
        entityManager.getTransaction().begin();

        TypedQuery<Animal> query = entityManager.createQuery("SELECT a FROM Animal a WHERE a.name = :name", Animal.class);
        query.setParameter("name", name);
        List<Animal> animals = query.getResultList();

        entityManager.getTransaction().commit();

        return animals;
    }

    public List<Animal> findByDiet(Diet diet) {
        entityManager.getTransaction().begin();

        TypedQuery<Animal> query = entityManager.createQuery("SELECT a FROM Animal a WHERE a.diet = :diet", Animal.class);
        query.setParameter("diet", diet);
        List<Animal> animals = query.getResultList();

        entityManager.getTransaction().commit();

        return animals;
    }
}
