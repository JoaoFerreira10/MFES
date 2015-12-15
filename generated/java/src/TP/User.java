package TP;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class User {
    private String name;

    public User(final String un) {
        cg_init_User_1(un);
    }

    public User() {
    }

    public void cg_init_User_1(final String un) {
        name = un;

        return;
    }

    public String getUserName() {
        return name;
    }

    public String toString() {
        return "User{" + "name := " + Utils.toString(name) + "}";
    }
}
