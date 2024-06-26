package dev.cb.zoo;

import dev.cb.zoo.ihm.Ihm;
import dev.cb.zoo.persistence.AnimalRepository;
import dev.cb.zoo.persistence.PostgresEntityManager;

public class Main {

    public static void main(String[] args) {

        AnimalRepository animalRepository = new AnimalRepository(PostgresEntityManager.getEntityManager());
        Ihm ihm = new Ihm(animalRepository);

        ihm.run();
    }
}
