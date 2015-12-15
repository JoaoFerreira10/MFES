package TP;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Rules {
    private Object requestBool;
    public String group_User;
    public String group_Sector;

    public Rules(final Object req, final String gr, final String gs) {
        cg_init_Rules_1(((Object) req), gr, gs);
    }

    public Rules() {
    }

    public void cg_init_Rules_1(final Object req, final String gr,
        final String gs) {
        requestBool = req;
        group_User = gr;
        group_Sector = gs;

        return;
    }

    public String getGroup_User() {
        return this.group_User;
    }

    public String getGroup_Sector() {
        return this.group_Sector;
    }

    public Object getRequest() {
        return this.requestBool;
    }

    public static Number maxIndex(final VDMSet s) {
        Number maxElem = 1L;

        for (Iterator iterator_2 = s.iterator(); iterator_2.hasNext();) {
            Number elem = (Number) iterator_2.next();

            if (maxElem.longValue() < elem.longValue()) {
                maxElem = elem;
            }
        }

        return maxElem;
    }

    public String toString() {
        return "Rules{" + "requestBool := " + Utils.toString(requestBool) +
        ", group_User := " + Utils.toString(group_User) + ", group_Sector := " +
        Utils.toString(group_Sector) + "}";
    }
}
