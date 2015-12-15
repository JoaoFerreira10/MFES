package TP;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Card {
    private Number id;

    public Card(final Number idCard) {
        cg_init_Card_1(idCard);
    }

    public Card() {
    }

    public void cg_init_Card_1(final Number idCard) {
        id = idCard;

        return;
    }

    public Number getCardId() {
        return this.id;
    }

    public String toString() {
        return "Card{" + "id := " + Utils.toString(id) + "}";
    }
}
