package TP.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class allowQuote {
    private static int hc = 0;
    private static allowQuote instance = null;

    public allowQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static allowQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new allowQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof allowQuote;
    }

    public String toString() {
        return "<allow>";
    }
}
