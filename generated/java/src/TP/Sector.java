package TP;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Sector {
    private String sector_name;

    public Sector(final String sn) {
        cg_init_Sector_1(sn);
    }

    public Sector() {
    }

    public void cg_init_Sector_1(final String sn) {
        sector_name = sn;

        return;
    }

    public String getSectorName() {
        return sector_name;
    }

    public String toString() {
        return "Sector{" + "sector_name := " + Utils.toString(sector_name) +
        "}";
    }
}
