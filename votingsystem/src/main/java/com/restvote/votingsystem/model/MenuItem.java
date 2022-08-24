package com.restvote.votingsystem.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menu_items", uniqueConstraints = {@UniqueConstraint(columnNames = {"Meal_id", "restaurant_id", "added"}, name = "meal_item_unique_Meal_restaurant_added_idx")})
public class MenuItem extends AbstractBaseEntity {

    @Column(name = "added", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate added;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Meal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Meal Meal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public MenuItem() {}

    public MenuItem(Meal Meal, Restaurant restaurant, LocalDate added) {
        this(null, Meal, restaurant, added);
    }

    public MenuItem(Integer id, Meal Meal, Restaurant restaurant, LocalDate added) {
        super(id);
        this.Meal = Meal;
        this.restaurant = restaurant;
        this.added = added;
    }

    public Meal getMeal() {
        return Meal;
    }

    public void setMeal(Meal Meal) {
        this.Meal = Meal;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getAdded() {
        return added;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + super.getId() + '\'' +
                ", Meal=" + Meal +
                ", restaurant=" + restaurant +
                ", added=" + added +
                '}';
    }
}
