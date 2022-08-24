package com.restvote.votingsystem.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Meal.ALL_SORTED, query = "SELECT d FROM Meal d ORDER BY d.id"),
})
@Entity
@Table(name = "Meales")
public class Meal extends AbstractBaseEntity {

    public static final String ALL_SORTED = "Meal.getAllSorted";

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 1, max = 10000)
    private int price;

    public Meal() {}

    public Meal(int id, String description, int price) {
        super(id);
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id='" + super.getId() + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
