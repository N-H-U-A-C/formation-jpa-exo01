package dev.cb.zoo;

import dev.cb.zoo.entity.Animal;
import dev.cb.zoo.entity.Diet;
import dev.cb.zoo.persistence.AnimalRepository;
import dev.cb.zoo.persistence.PostgresEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        AnimalRepository animalRepository = new AnimalRepository(PostgresEntityManager.getEntityManager());

        Animal animal1 = new Animal("Girafe", 5, Diet.HERBIVORE, LocalDate.parse("2020-05-05"));
        Animal animal2 = new Animal("Lion", 6, Diet.CARNIVORE, LocalDate.parse("2021-10-05"));
//        animalRepository.addAnimal(animal2);

//        Optional<Animal> optionalAnimal = animalRepository.find(1);
//        optionalAnimal.ifPresent(System.out::println);

//        List<Animal> animals = animalRepository.findByName("Lion");
//        System.out.println(animals);

        List<Animal> animals = animalRepository.findByDiet(Diet.CARNIVORE);
        System.out.println(animals);
    }
}
