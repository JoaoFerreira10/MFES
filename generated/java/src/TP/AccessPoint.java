package TP;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class AccessPoint {
    private Number id;
    public Sector sector;

    public AccessPoint(final Number idAccess, final Sector sec) {
        cg_init_AccessPoint_1(idAccess, sec);
    }

    public AccessPoint() {
    }

    public void cg_init_AccessPoint_1(final Number idAccess, final Sector sec) {
        id = idAccess;
        sector = sec;

        return;
    }

    public Sector getSector() {
        return this.sector;
    }

    public String toString() {
        return "AccessPoint{" + "id := " + Utils.toString(id) + ", sector := " +
        Utils.toString(sector) + "}";
    }
}
