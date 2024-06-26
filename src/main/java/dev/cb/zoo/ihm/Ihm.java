package dev.cb.zoo.ihm;

import dev.cb.zoo.entity.Animal;
import dev.cb.zoo.entity.Diet;
import dev.cb.zoo.persistence.AnimalRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Ihm {

    private final Scanner scanner;
    private final AnimalRepository animalRepository;
    private boolean hasQuit;
    // text blocks
    private final String MENU_TEXT;
    private final String CHOICE_TEXT;
    private final String ANIMAL_TEXT;
    private final String WELCOME_TEXT;
    private final String GOODBYE_TEXT;

    public Ihm(AnimalRepository animalRepository) {
        this.scanner = new Scanner(System.in);
        this.animalRepository = animalRepository;
        this.hasQuit = false;
        this.MENU_TEXT = """
                \n=== Main Menu ===
                                
                1. Add an animal
                2. Get an animal by id
                3. Get an animal by name
                4. Get an animal by arrival date
                0. Exit
                """;
        this.CHOICE_TEXT = """
                Please enter a choice:\s
                """;
        this.ANIMAL_TEXT = """
                \nPlease enter the animal\s""";
        this.WELCOME_TEXT = """
                \nWelcome to the zoo app!""";
        this.GOODBYE_TEXT = """
                \nGoodbye!""";
    }

    public void run() {
        this.sayWelcome();
        do {
            this.displayMenu();
            this.makeChoice();
        } while (!hasQuit);
        this.sayGoodbye();
    }

    private void displayMenu() {
        System.out.println(this.MENU_TEXT);
        System.out.print(this.CHOICE_TEXT);
    }

    private void makeChoice() {
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1" -> addAnimal();
            case "2" -> getAnimal();
            case "3" -> getAllAnimalsByName();
            case "4" -> getAllAnimalsByDiet();
            case "0" -> hasQuit = true;
        }
    }

    private void addAnimal() {
        System.out.print(ANIMAL_TEXT + "name:\s");
        String name = scanner.nextLine();
        System.out.print(ANIMAL_TEXT + "age:\s");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print(ANIMAL_TEXT + "diet:\s");
        Diet diet = Diet.valueOf(scanner.nextLine().toUpperCase());
        System.out.print(ANIMAL_TEXT + "arrival date (yyyy-mm-dd):\s");
        String dateString = scanner.nextLine();
        LocalDate arrivalDate = LocalDate.parse(dateString);

        Animal animal = new Animal(name, age, diet, arrivalDate);
        animalRepository.add(animal);
    }

    private void getAnimal() {
        System.out.print(ANIMAL_TEXT + "id:\s");
        int id = Integer.parseInt(scanner.nextLine());

        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        optionalAnimal.ifPresentOrElse(System.out::println, () -> System.out.println("Animal not found"));
    }

    private void getAllAnimalsByName() {
        System.out.print(ANIMAL_TEXT + "name:\s");
        String name = scanner.nextLine();

        System.out.println(this.animalRepository.findAllByName(name));
    }

    private void getAllAnimalsByDiet() {
        System.out.print(ANIMAL_TEXT + "diet:\s");
        Diet diet = Diet.valueOf(scanner.nextLine().toUpperCase());

        System.out.println(this.animalRepository.findAllByDiet(diet));
    }

    private void sayWelcome() {
        System.out.println(WELCOME_TEXT);
    }

    private void sayGoodbye() {
        System.out.println(GOODBYE_TEXT);
    }
}
