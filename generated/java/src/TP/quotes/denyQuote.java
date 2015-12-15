package TP.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class denyQuote {
    private static int hc = 0;
    private static denyQuote instance = null;

    public denyQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static denyQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new denyQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof denyQuote;
    }

    public String toString() {
        return "<deny>";
    }
}
