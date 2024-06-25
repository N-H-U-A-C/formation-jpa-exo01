package dev.cb.zoo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private Diet diet;
    @Column(nullable = false)
    private LocalDate arrivalDate;

    public Animal() {
    }

    public Animal(String name, int age, Diet diet, LocalDate arrivalDate) {
        this.name = name;
        this.age = age;
        this.diet = diet;
        this.arrivalDate = arrivalDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diet=" + diet +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
