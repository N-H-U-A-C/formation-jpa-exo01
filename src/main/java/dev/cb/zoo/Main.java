package dev.cb.zoo;

import dev.cb.zoo.entity.Animal;
import dev.cb.zoo.entity.Diet;
import dev.cb.zoo.persistence.AnimalRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AnimalRepository animalRepository = new AnimalRepository(entityManager);

        Animal animal = new Animal("Girafe", 5, Diet.HERBIVORE, LocalDate.parse("2020-05-05"));
//        animalRepository.addAnimal(animal);

        Optional<Animal> optionalAnimal = animalRepository.find(1);
        optionalAnimal.ifPresent(System.out::println);

    }
}
