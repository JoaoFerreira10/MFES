package TP;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Sistema {
    public static Object out;
	private String system;
    private VDMSet users = SetUtil.set();
    private VDMSet sectors = SetUtil.set();
    private VDMMap group_users = MapUtil.map();
    private VDMMap group_sectors = MapUtil.map();
    private VDMMap accessPointRules = MapUtil.map();
    private VDMSet cards = SetUtil.set();
    private VDMMap cardUser = MapUtil.map();
    private Number cardId = 0L;
    private Number accessPointId = 0L;

    public Sistema(final String sys) {
        cg_init_System_1(sys);
    }

    public Sistema() {
    }

    public String getSystem() {
        return system;
    }

    public void cg_init_System_1(final String sys) {
        system = sys;

        return;
    }

    public Card createCard() {
        cardId = cardId.longValue() + 1L;

        {
            Card c = new Card(cardId);
            cards = SetUtil.union(Utils.copy(cards), SetUtil.set(c));

            return c;
        }
    }

    public User createUser(final String name) {
        {
            User u = new User(name);
            users = SetUtil.union(Utils.copy(users), SetUtil.set(u));
            group_users = MapUtil.munion(Utils.copy(group_users),
                    MapUtil.map(new Maplet(name, SetUtil.set(u))));

            return u;
        }
    }

    public void cardToUser(final Card c, final User user) {
        cardUser = MapUtil.munion(Utils.copy(cardUser),
                MapUtil.map(new Maplet(c, user)));
    }

    public String createGroup_User(final String name) {
        {
            String gr = name;
            group_users = MapUtil.munion(Utils.copy(group_users),
                    MapUtil.map(new Maplet(name, SetUtil.set())));

            return gr;
        }
    }

    public void userToGroupUser(final String gr, final User user) {
        Utils.mapSeqUpdate(group_users, gr,
            SetUtil.union(Utils.copy(((VDMSet) Utils.get(group_users, gr))),
                SetUtil.set(user)));
    }

    public Sector createSector(final String name) {
        {
            Sector s = new Sector(name);
            sectors = SetUtil.union(Utils.copy(sectors), SetUtil.set(s));
            group_sectors = MapUtil.munion(Utils.copy(group_sectors),
                    MapUtil.map(new Maplet(name, SetUtil.set(s))));

            return s;
        }
    }

    public String createGroup_Sector(final String name) {
        {
            String sc = name;
            group_sectors = MapUtil.munion(Utils.copy(group_sectors),
                    MapUtil.map(new Maplet(name, SetUtil.set())));

            return sc;
        }
    }

    public void sectorToGroupSector(final String grsec, final Sector sector) {
        Utils.mapSeqUpdate(group_sectors, grsec,
            SetUtil.union(Utils.copy(((VDMSet) Utils.get(group_sectors, grsec))),
                SetUtil.set(sector)));
    }

    public AccessPoint createAccessPoint(final Sector sector) {
        accessPointId = accessPointId.longValue() + 1L;

        {
            AccessPoint ap = new AccessPoint(accessPointId, sector);
            accessPointRules = MapUtil.munion(Utils.copy(accessPointRules),
                    MapUtil.map(new Maplet(ap, SeqUtil.seq())));

            return ap;
        }
    }

    public void accessRuleToAccessPoint(final AccessPoint ap, final Rules ar) {
        Utils.mapSeqUpdate(accessPointRules, ap,
            SeqUtil.conc(Utils.copy(((VDMSeq) Utils.get(accessPointRules, ap))),
                SeqUtil.seq(ar)));
    }

    public Tuple accessRequest(final Card crd, final AccessPoint acP) {
        if (!(SetUtil.inSet(crd, MapUtil.dom(Utils.copy(cardUser))))) {
            return Tuple.mk_(false, "Utilizador inexistente",
                "cartÃ£o nao associado ao utilizador");
        }

        {
            User user = ((User) Utils.get(cardUser, crd));

            VDMSeq rules = Utils.copy(((VDMSeq) Utils.get(accessPointRules, acP)));

            VDMSet setCompResult_1 = SetUtil.set();
            VDMSet set_1 = SeqUtil.inds(rules);

            for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext();) {
                Number i = ((Number) iterator_1.next());
                Boolean andResult_7 = false;

                if (SetUtil.inSet(user,
                            ((VDMSet) Utils.get(group_users,
                                ((Rules) Utils.get(rules, i)).getGroup_User())))) {
                    if (SetUtil.inSet(acP.getSector(),
                                ((VDMSet) Utils.get(group_sectors,
                                    ((Rules) Utils.get(rules, i)).getGroup_Sector())))) {
                        andResult_7 = true;
                    }
                }

                if (andResult_7) {
                    setCompResult_1 = SetUtil.union(Utils.copy(setCompResult_1),
                            SetUtil.set(i));
                }
            }

            VDMSet index = Utils.copy(setCompResult_1);

            {
                Boolean orResult_1 = false;

                if (Utils.equals(index.size(), 0L)) {
                    orResult_1 = true;
                } else {
                    orResult_1 = Utils.equals(((Rules) Utils.get(rules,
                                Rules.maxIndex(Utils.copy(index)))).getRequest(),
                            TP.quotes.denyQuote.getInstance());
                }

                if (orResult_1) {
                    return Tuple.mk_(false, user.getUserName(),
                        "utilizador nao autorizado");
                } else {
                    return Tuple.mk_(true, user.getUserName(),
                        "utilizador autorizado");
                }
            }
        }
    }

    public String toString() {
        return "System{" + "system := " + Utils.toString(system) +
        ", users := " + Utils.toString(users) + ", sectors := " +
        Utils.toString(sectors) + ", group_users := " +
        Utils.toString(group_users) + ", group_sectors := " +
        Utils.toString(group_sectors) + ", accessPointRules := " +
        Utils.toString(accessPointRules) + ", cards := " +
        Utils.toString(cards) + ", cardUser := " + Utils.toString(cardUser) +
        ", cardId := " + Utils.toString(cardId) + ", accessPointId := " +
        Utils.toString(accessPointId) + "}";
    }
}
