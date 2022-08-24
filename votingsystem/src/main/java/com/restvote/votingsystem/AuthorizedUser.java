package com.restvote.votingsystem;

import com.restvote.votingsystem.model.AbstractBaseEntity;
import com.restvote.votingsystem.model.Role;

/*
    From simple logging page can be chosen user
*/
public class AuthorizedUser {

    private static int id = AbstractBaseEntity.START_SEQ;

    private static Role role = Role.ADMIN;


    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

    public static Role getRole() {
        return role;
    }

    public static void setRole(Role role) {
        AuthorizedUser.role = role;
    }

    public static void setAdmin() {
        role = Role.ADMIN;
        id = AbstractBaseEntity.START_SEQ;
    }

    public static void setUser() {
        role = Role.USER;
        id = AbstractBaseEntity.START_SEQ + 2;
    }
}
