package com.restvote.votingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity {

    @Column(name = "role", nullable = false)
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Role role;

    protected User() {}

    public User(int id, String name, Role role) {
        super(id, name);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", role=" + role +
                '}';
    }
}
