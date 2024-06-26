package dev.cb.zoo;

import dev.cb.zoo.entity.Animal;
import dev.cb.zoo.entity.Diet;
import dev.cb.zoo.ihm.Ihm;
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
        Ihm ihm = new Ihm(animalRepository);

        ihm.run();
    }
}
