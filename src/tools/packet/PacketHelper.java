/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import FuckingHackerToby.Rb;
import client.ISkill;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleCoolDownValueHolder;
import client.MapleCoreAura;
import client.MapleJob;
import client.MaplePartTimeJob;
import client.MapleQuestStatus;
import client.MapleTrait;
import client.SkillEntry;
import client.innerSkills.InnerSkillValueHolder;
import client.inventory.Equip;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.MapleRing;
import client.inventory.MapleWeaponType;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.JobConstants;
import constants.SkillConstants;
import handling.Buffstat;
import handling.opcodes.MapleBuffStat;
import handling.world.PlayerBuffValueHolder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;
import server.Framework.MapleExtendedSlots;
import server.MapleDueyActions;
import server.MapleStatEffect;
import server.Randomizer;
import server.movement.LifeMovementFragment;
import server.quest.MapleQuest;
import server.shops.AbstractPlayerStore;
import server.shops.IMaplePlayerShop;
import tools.FileTime;
import tools.KoreanDateUtil;
import tools.Pair;
import tools.StringUtil;
import tools.Triple;
import tools.data.MaplePacketLittleEndianWriter;

/*
 * Exception performing whole class analysis ignored.
 */
public class PacketHelper {
    private static final /* synthetic */ long ALLATORIxDEMO = 116444592000000000L;
    public static final /* synthetic */ byte[] unk2;
    public static final /* synthetic */ byte[] unk1;
    public static final /* synthetic */ long PERMANENT = 150841440000000000L;
    public static final /* synthetic */ long MAX_TIME = 150842304000000000L;
    public static final /* synthetic */ long ZERO_TIME = 94354848000000000L;

    public static /* synthetic */ void writeBuffMask(MaplePacketLittleEndianWriter a2, Map<MapleBuffStat, Integer> a3, boolean a42) {
        int[] a42 = new int[GameSetConstants.MAX_BUFFSTAT];
        Object object = a3 = a3.keySet().iterator();
        while (object.hasNext()) {
            MapleBuffStat mapleBuffStat = (MapleBuffStat)a3.next();
            if (mapleBuffStat.getIDAValue() <= -1) {
                object = a3;
                continue;
            }
            int n2 = mapleBuffStat.getPosition(false);
            object = a3;
            a42[n2] = (int)((long)a42[n2] | mapleBuffStat.getValue());
        }
        int n3 = a3 = 0;
        while (n3 < a42.length) {
            a2.writeInt(a42[a3++]);
            n3 = a3;
        }
    }

    public static /* synthetic */ void addLuckyDayInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        int n2 = a3 = 0;
        a2.writeInt(n2);
        int n3 = a3 = n2;
        while (n3 > 0) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeLong(0L);
            maplePacketLittleEndianWriter.writeLong(0L);
            n3 = --a3;
        }
    }

    public static final /* synthetic */ void addCharLook(MaplePacketLittleEndianWriter a2, MapleCharacter a3, boolean a4) {
        PacketHelper.addCharLook(a2, a3, a4, false);
    }

    public static final /* synthetic */ void serializeMovementList(MaplePacketLittleEndianWriter a2, List<LifeMovementFragment> a3) {
        List<LifeMovementFragment> list = a3;
        a2.write(list.size());
        Object object = a3 = list.iterator();
        while (object.hasNext()) {
            ((LifeMovementFragment)a3.next()).serialize(a2);
            object = a3;
        }
    }

    public static /* synthetic */ void addHonorInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        maplePacketLittleEndianWriter.writeInt(a3.getHonorLevel());
        maplePacketLittleEndianWriter.writeInt(a3.getHonourExp());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void addItemInfo(MaplePacketLittleEndianWriter a, IItem a, MapleCharacter a) {
        var3_3 = a.getPet() != null && a.getPet().getUniqueId() > -1;
        a.write(a.getPet() != null ? 3 : (byte)a.getType());
        v0 = a;
        a.writeInt(v0.getItemId());
        var4_4 = v0.getUniqueId() > 0 && GameConstants.isMarrigeRing(a.getItemId()) == false && a.getItemId() / 10000 != 166 && a.isCash() != false;
        a.write(var4_4 != false ? 1 : 0);
        if (!var4_4) ** GOTO lbl19
        if (var3_3) {
            v1 = a;
            v2 = v1;
            a.writeLong(v1.getPet().getUniqueId());
        } else if (a.getRing() != null && a.getRing().getRingId() > -1) {
            v3 = a;
            v2 = v3;
            a.writeLong(v3.getRing().getRingId());
        } else {
            a.writeLong(a.getUniqueId());
lbl19:
            // 2 sources

            v2 = a;
        }
        v4 = a;
        if (v2.getPet() != null) {
            v5 = a;
            PacketHelper.addPetItemInfo(v4, v5, v5.getPet(), true);
            return;
        }
        PacketHelper.addExpirationTime(v4, a.getExpiration());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a.writeInt(a == null ? -1 : a.getExtendedSlotsIndexByUniqueid(a.getUniqueId()));
        }
        if (GameSetConstants.MAPLE_VERSION == 116 || GameSetConstants.MAPLE_VERSION == 118 || GameSetConstants.MAPLE_VERSION == 119) {
            PacketHelper.addItemBeforeBigBang_116(a, a, var4_4, a);
            return;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            PacketHelper.addItemAfterBigBang(a, a, var4_4, a);
            return;
        }
        PacketHelper.addItemBeforeBigBang(a, a, var4_4, a);
    }

    public static /* synthetic */ void addOXSystemInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a32) {
        int n2;
        int a32 = 0;
        a2.writeShort(a32);
        int n3 = n2 = 0;
        while (n3 < a32) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
            a2.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeMapleAsciiString("");
            maplePacketLittleEndianWriter4.write(0);
            maplePacketLittleEndianWriter4.writeLong(0L);
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter3.writeMapleAsciiString("");
            maplePacketLittleEndianWriter2.write(0);
            maplePacketLittleEndianWriter2.write(0);
            maplePacketLittleEndianWriter.writeLong(0L);
            maplePacketLittleEndianWriter.writeMapleAsciiString("");
            n3 = ++n2;
        }
    }

    public static /* synthetic */ void addForeignBuffStatus(MaplePacketLittleEndianWriter a2, Map<MapleBuffStat, Integer> a3, MapleCharacter a4, MapleStatEffect a5) {
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            PacketHelper.addBuffStat_135(a2, a4, a3);
            return;
        }
        PacketHelper.H(a2, a4, a3);
    }

    public static /* synthetic */ void addDefaultBuffStat_BeforeBB(MaplePacketLittleEndianWriter a2, MapleCharacter a3, Map<MapleBuffStat, Integer> a4) {
        int n2 = Randomizer.nextInt();
        if (a4.containsKey(MapleBuffStat.ENERGY_CHARGE)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                a2.write(1);
            }
            a2.writeInt(n2);
            a2.writeShort(0);
        }
        if (a4.containsKey(MapleBuffStat.DASH_SPEED)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                a2.write(1);
            }
            a2.writeInt(n2);
            a2.writeShort(0);
        }
        if (a4.containsKey(MapleBuffStat.DASH_JUMP)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                a2.write(1);
            }
            a2.writeInt(n2);
            a2.writeShort(0);
        }
        if (a4.containsKey(MapleBuffStat.MONSTER_RIDING)) {
            int n3 = a3.getBuffSource(MapleBuffStat.MONSTER_RIDING);
            if (n3 > 0) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
                MapleCharacter mapleCharacter = a3;
                IItem iItem = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-118);
                IItem iItem2 = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-18);
                if (mapleCharacter.getMountId() > 0) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter2.writeInt(a3.getMountId());
                } else if (GameConstants.getMountItem(n3, a3) == 0 && iItem != null && a3.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-119) != null) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                    maplePacketLittleEndianWriter3.writeInt(iItem.getItemId());
                } else if (GameConstants.getMountItem(n3, a3) == 0 && iItem2 != null && a3.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-19) != null) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                    maplePacketLittleEndianWriter4.writeInt(iItem2.getItemId());
                } else {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
                    maplePacketLittleEndianWriter5.writeInt(GameConstants.getMountItem(n3, a3));
                }
                maplePacketLittleEndianWriter.writeInt(n3);
            } else {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                if (a3.getFlyChairId() > 0) {
                    maplePacketLittleEndianWriter.writeInt(a3.getFlyChairId());
                    a2.writeInt(0);
                } else {
                    maplePacketLittleEndianWriter.writeInt(0);
                    a2.writeInt(0);
                }
            }
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                a2.write(0);
            }
            a2.writeInt(n2);
        }
        if (a4.containsKey(MapleBuffStat.SPEED_INFUSION)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
                a2.write(0);
                maplePacketLittleEndianWriter6.writeInt(n2);
                maplePacketLittleEndianWriter6.write(0);
            }
            a2.writeInt(n2);
            a2.writeShort(0);
        }
        if (a4.containsKey(MapleBuffStat.HOMING_BEACON)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                a2.write(0);
            }
            a2.writeInt(n2);
            a2.writeInt(0);
        }
        if (a4.containsKey(MapleBuffStat.DEFAULT_BUFFSTAT)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a2;
            a2.writeInt(0);
            maplePacketLittleEndianWriter7.writeInt(0);
            maplePacketLittleEndianWriter7.write(0);
            maplePacketLittleEndianWriter.writeInt(n2);
            maplePacketLittleEndianWriter.writeShort(0);
        }
        if (a4.containsKey(MapleBuffStat.DEFAULT_BUFFSTAT2)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = a2;
            maplePacketLittleEndianWriter8.writeInt(0);
            maplePacketLittleEndianWriter8.writeInt(0);
            maplePacketLittleEndianWriter.write(1);
            maplePacketLittleEndianWriter.writeInt(n2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void handleSpecialBuffStat(MaplePacketLittleEndianWriter a2, MapleCharacter a3, List<Pair<MapleBuffStat, Integer>> a42, MapleStatEffect a5, int a6) {
        HashMap<MapleBuffStat, Integer> hashMap;
        Object object;
        HashMap<MapleBuffStat, Integer> hashMap2 = new HashMap<MapleBuffStat, Integer>();
        Object object2 = object = a42.iterator();
        while (object2.hasNext()) {
            Pair<MapleBuffStat, Integer> pair = object.next();
            hashMap2.put(pair.getLeft(), pair.getRight());
            object2 = object;
        }
        if (hashMap2.containsKey(MapleBuffStat.CRITICAL_RATE_BUFF)) {
            hashMap = hashMap2;
            a2.write(0);
        } else if (hashMap2.containsKey(MapleBuffStat.MP_BUFF)) {
            hashMap = hashMap2;
            a2.write(0);
        } else if (hashMap2.containsKey(MapleBuffStat.DAMAGE_TAKEN_BUFF)) {
            hashMap = hashMap2;
            a2.write(0);
        } else {
            if (hashMap2.containsKey(MapleBuffStat.DODGE_CHANGE_BUFF)) {
                a2.write(0);
            }
            hashMap = hashMap2;
        }
        if (hashMap.containsKey(MapleBuffStat.DICE_ROLL)) {
            int n2 = 22;
            do {
                a2.writeInt(0);
            } while (--n2 != 1);
        }
        if (hashMap2.containsKey(MapleBuffStat.DIVINE_SHIELD)) {
            a2.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            if (hashMap2.containsKey(MapleBuffStat.DARK_AURA)) {
                a2.write(0);
            }
            if (hashMap2.containsKey(MapleBuffStat.BLUE_AURA)) {
                a2.write(0);
            }
            if (hashMap2.containsKey(MapleBuffStat.YELLOW_AURA)) {
                a2.write(0);
            }
            if (hashMap2.containsKey(MapleBuffStat.KILLING_POINT)) {
                a2.write(a3.getKillCount());
            }
            if (hashMap2.containsKey(MapleBuffStat.BODY_BOOST)) {
                a2.writeInt(1);
            }
            if (GameSetConstants.MAPLE_VERSION >= 147) {
                if (hashMap2.containsKey(MapleBuffStat.JUDGMENT_DRAW)) {
                    a2.writeInt(SkillConstants.getJudgmentStat(a6, (Integer)hashMap2.get(MapleBuffStat.JUDGMENT_DRAW)));
                }
                if (hashMap2.containsKey(MapleBuffStat.SUMMON) || hashMap2.containsKey(MapleBuffStat.COMBO)) {
                    a2.write(1);
                }
            }
            if (GameSetConstants.MAPLE_VERSION >= 151) {
                if (hashMap2.containsKey(MapleBuffStat.DARK_CRESCENDO)) {
                    a2.write((Integer)hashMap2.values().stream().findFirst().get());
                }
                if (hashMap2.containsKey(MapleBuffStat.TRINITY)) {
                    a2.write((Integer)hashMap2.values().stream().findFirst().get());
                }
                if (a5 != null && hashMap2.containsKey(MapleBuffStat.LUNAR_TIDE)) {
                    MapleCharacter mapleCharacter = a3;
                    double d2 = a3.getStat().getCurrentMaxHp() / mapleCharacter.getStat().getHp();
                    double d3 = mapleCharacter.getStat().getCurrentMaxMp() / a3.getStat().getMp();
                    MapleStatEffect mapleStatEffect = a5;
                    int a42 = d2 >= d3 ? mapleStatEffect.getX() : mapleStatEffect.getProb();
                    a2.writeInt(a42);
                }
                if (hashMap2.containsKey(MapleBuffStat.PRESSURE_VOID)) {
                    a2.write(0);
                }
                if (hashMap2.containsKey(MapleBuffStat.KAISER_COMBO)) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
                    int n3 = 0;
                    int n4 = (Integer)hashMap2.values().stream().findFirst().get();
                    if (n4 >= 100) {
                        n3 = 1;
                        maplePacketLittleEndianWriter = a2;
                    } else {
                        if (n4 >= 300) {
                            n3 = 2;
                        }
                        maplePacketLittleEndianWriter = a2;
                    }
                    maplePacketLittleEndianWriter.writeInt(n3);
                }
                if (hashMap2.containsKey(MapleBuffStat.ABNORMAL_BUFF_RESISTANCES)) {
                    int n5 = (Integer)hashMap2.get(MapleBuffStat.ABNORMAL_BUFF_RESISTANCES);
                    a2.write(a6 == 27111004 ? 0 : n5);
                }
                if (hashMap2.containsKey(MapleBuffStat.LUMINOUS_GAUGE)) {
                    int n6;
                    int n7 = (int)System.currentTimeMillis();
                    int[] arrn = null;
                    switch (a6) {
                        case 20040216: {
                            int[] arrn2 = new int[2];
                            arrn2[0] = 20040216;
                            arrn2[1] = 0;
                            arrn = arrn2;
                            break;
                        }
                        case 20040217: {
                            int[] arrn3 = new int[2];
                            arrn3[0] = 20040217;
                            arrn3[1] = 0;
                            arrn = arrn3;
                            break;
                        }
                        case 20040219: {
                            int[] arrn4 = new int[2];
                            arrn4[0] = 20040216;
                            arrn4[1] = 20040217;
                            arrn = arrn4;
                            break;
                        }
                        case 20040220: {
                            int[] arrn5 = new int[2];
                            arrn5[0] = 20040217;
                            arrn5[1] = 20040216;
                            arrn = arrn5;
                            break;
                        }
                        default: {
                            int[] arrn6 = new int[2];
                            arrn6[0] = 0;
                            arrn6[1] = 0;
                            arrn = arrn6;
                        }
                    }
                    int n8 = n6 = 0;
                    while (n8 < 2) {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                        maplePacketLittleEndianWriter.writeInt(arrn[n6++]);
                        maplePacketLittleEndianWriter.writeInt(n7);
                        n8 = n6;
                    }
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    MapleCharacter mapleCharacter = a3;
                    maplePacketLittleEndianWriter.writeInt(mapleCharacter.getDarkGauge());
                    maplePacketLittleEndianWriter.writeInt(mapleCharacter.getLightGauge());
                }
                if (a5 != null && hashMap2.containsKey(MapleBuffStat.TEMPEST_BLADES)) {
                    int a42;
                    MapleStatEffect mapleStatEffect;
                    object = new ArrayList();
                    int n9 = 1;
                    switch (a5.getSourceId()) {
                        case 61101002: {
                            n9 = 1;
                            mapleStatEffect = a5;
                            break;
                        }
                        case 61120007: {
                            n9 = 2;
                            mapleStatEffect = a5;
                            break;
                        }
                        case 61111008: {
                            n9 = 3;
                            mapleStatEffect = a5;
                            break;
                        }
                        case 61120008: 
                        case 61121217: {
                            n9 = 4;
                        }
                        default: {
                            mapleStatEffect = a5;
                        }
                    }
                    int n10 = mapleStatEffect.getSourceId() == 61101002 ? 3 : 5;
                    int n11 = 0;
                    if (a3.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11) != null) {
                        n11 = a3.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11).getItemId();
                    }
                    int n12 = a42 = 0;
                    while (n12 < n10) {
                        object.add(0);
                        n12 = ++a42;
                    }
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    a2.writeInt(n9);
                    maplePacketLittleEndianWriter.writeInt(n10);
                    maplePacketLittleEndianWriter.writeInt(n11);
                    a2.writeInt(object.size());
                    int n13 = a42 = 0;
                    while (n13 < object.size()) {
                        Object e2 = object.get(a42);
                        a2.writeInt((Integer)e2);
                        n13 = ++a42;
                    }
                }
            }
        }
    }

    public static /* synthetic */ {
        byte[] arrby = new byte[4];
        arrby[0] = 0;
        arrby[1] = 64;
        arrby[2] = -32;
        arrby[3] = -3;
        unk1 = arrby;
        byte[] arrby2 = new byte[4];
        arrby2[0] = 59;
        arrby2[1] = 55;
        arrby2[2] = 79;
        arrby2[3] = 1;
        unk2 = arrby2;
    }

    public static final /* synthetic */ void addItemAfterBigBang(MaplePacketLittleEndianWriter a2, IItem a3, boolean a4, MapleCharacter a5) {
        block13: {
            block9: {
                boolean bl;
                block12: {
                    block11: {
                        block10: {
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
                            if (a3.getType() != 1) break block9;
                            a5 = (Equip)a3;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
                            Serializable serializable = a5;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
                            Serializable serializable2 = a5;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
                            Serializable serializable3 = a5;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
                            Serializable serializable4 = a5;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
                            Serializable serializable5 = a5;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a2;
                            Serializable serializable6 = a5;
                            a2.write(((Equip)serializable6).getUpgradeSlots());
                            maplePacketLittleEndianWriter7.write(((Equip)serializable6).getLevel());
                            maplePacketLittleEndianWriter7.writeShort(((Equip)a5).getStr());
                            a2.writeShort(((Equip)serializable5).getDex());
                            maplePacketLittleEndianWriter6.writeShort(((Equip)serializable5).getInt());
                            maplePacketLittleEndianWriter6.writeShort(((Equip)a5).getLuk());
                            a2.writeShort(((Equip)serializable4).getHp());
                            maplePacketLittleEndianWriter5.writeShort(((Equip)serializable4).getMp());
                            maplePacketLittleEndianWriter5.writeShort(((Equip)a5).getWatk());
                            a2.writeShort(((Equip)serializable3).getMatk());
                            maplePacketLittleEndianWriter4.writeShort(((Equip)serializable3).getWdef());
                            maplePacketLittleEndianWriter4.writeShort(((Equip)a5).getMdef());
                            a2.writeShort(((Equip)serializable2).getAcc());
                            maplePacketLittleEndianWriter3.writeShort(((Equip)serializable2).getAvoid());
                            maplePacketLittleEndianWriter3.writeShort(((Equip)a5).getHands());
                            a2.writeShort(((Equip)serializable).getSpeed());
                            maplePacketLittleEndianWriter2.writeShort(((Equip)serializable).getJump());
                            maplePacketLittleEndianWriter2.writeMapleAsciiString(((Item)a5).getOwner());
                            if (GameSetConstants.MAPLE_VERSION > 143) {
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = a2;
                                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter8;
                                maplePacketLittleEndianWriter8.writeInt(((Item)a5).getFlag());
                            } else {
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = a2;
                                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter9;
                                maplePacketLittleEndianWriter9.writeShort((short)((Item)a5).getFlag());
                            }
                            maplePacketLittleEndianWriter.write(((Equip)a5).getIncSkill() > 0 ? 1 : 0);
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = a2;
                            Serializable serializable7 = a5;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = a2;
                            maplePacketLittleEndianWriter11.write(Math.max(((Equip)a5).getBaseLevel(), ((Equip)a5).getEquipLevel()));
                            maplePacketLittleEndianWriter11.writeInt(((Equip)a5).getExpPercentage() * 100000);
                            a2.writeInt(((Equip)serializable7).getDurability());
                            maplePacketLittleEndianWriter10.writeInt(((Equip)serializable7).getViciousHammer());
                            maplePacketLittleEndianWriter10.writeShort(((Equip)a5).getPVPDamage());
                            if (GameSetConstants.MAPLE_VERSION >= 152) {
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = a2;
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = a2;
                                maplePacketLittleEndianWriter13.writeShort(0);
                                maplePacketLittleEndianWriter13.writeInt(((Equip)a5).getDurability());
                                maplePacketLittleEndianWriter12.write(0);
                                maplePacketLittleEndianWriter12.write(0);
                            }
                            a2.write(((Equip)a5).getState() == 21 ? (byte)20 : (byte)((Equip)a5).getState());
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter14 = a2;
                            Serializable serializable8 = a5;
                            a2.write(((Equip)a5).getEnhance());
                            a2.writeShort(((Equip)serializable8).getPotential1());
                            maplePacketLittleEndianWriter14.writeShort(((Equip)serializable8).getPotential2());
                            maplePacketLittleEndianWriter14.writeShort(((Equip)a5).getPotential3());
                            if (GameSetConstants.MAPLE_VERSION < 139) break block10;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter15 = a2;
                            maplePacketLittleEndianWriter15.writeShort(((Equip)a5).getPotential4());
                            maplePacketLittleEndianWriter15.writeShort(((Equip)a5).getPotential5());
                            if (GameSetConstants.MAPLE_VERSION >= 152) {
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter16 = a2;
                                maplePacketLittleEndianWriter16.writeShort(((Equip)a5).getPotential6());
                                maplePacketLittleEndianWriter16.writeShort(((Equip)a5).getFusionAnvil() % 10000);
                            }
                            if (GameSetConstants.MAPLE_VERSION <= 143) break block11;
                            a2.writeShort(((Equip)a5).getSocketState());
                            if (GameSetConstants.MAPLE_VERSION < 147) break block11;
                            bl = a4;
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter17 = a2;
                            Serializable serializable9 = a5;
                            a2.writeShort(((Equip)serializable9).getSocket(1) % 10000);
                            maplePacketLittleEndianWriter17.writeShort(((Equip)serializable9).getSocket(2) % 10000);
                            maplePacketLittleEndianWriter17.writeShort(((Equip)a5).getSocket(3) % 10000);
                            break block12;
                        }
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                        Serializable serializable = a5;
                        maplePacketLittleEndianWriter.writeShort(((Equip)serializable).getHpR());
                        maplePacketLittleEndianWriter.writeShort(((Equip)serializable).getMpR());
                    }
                    bl = a4;
                }
                if (!bl) {
                    a2.writeLong(((Item)a5).getInventoryitemId() <= 0L ? -1L : ((Item)a5).getInventoryitemId());
                }
                a2.writeLong(PacketHelper.getTime(-2L));
                a2.writeInt(-1);
                if (GameSetConstants.MAPLE_VERSION >= 148) {
                    a2.writeShort(((Equip)a5).getSoulName());
                }
                if (GameSetConstants.MAPLE_VERSION >= 151) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    maplePacketLittleEndianWriter.writeShort(((Equip)a5).getSoulEnchanter());
                    maplePacketLittleEndianWriter.writeShort(((Equip)a5).getSoulPotential());
                    return;
                }
                break block13;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            IItem iItem = a3;
            a2.writeShort(a3.getQuantity());
            maplePacketLittleEndianWriter.writeMapleAsciiString(iItem.getOwner());
            maplePacketLittleEndianWriter.writeShort(iItem.getFlag());
            if (ItemConstants.isExpChair(a3.getItemId())) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter18 = a2;
                maplePacketLittleEndianWriter18.writeInt(a3.getUniqueId());
                maplePacketLittleEndianWriter18.writeInt(0);
            }
            if (GameConstants.isThrowingStar(a3.getItemId()) || GameConstants.isBullet(a3.getItemId()) || a3.getItemId() / 10000 == 287) {
                a2.writeLong(a3.getInventoryitemId() <= 0L ? -1L : a3.getInventoryitemId());
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ void addInventoryInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3, boolean a4) {
        MapleCharacter mapleCharacter;
        List<IItem> list;
        Object object2 = a3.getInventory(MapleInventoryType.EQUIPPED);
        List<IItem> list2 = ((MapleInventory)object2).newList();
        Collections.sort(list2);
        for (IItem object3 : list2) {
            if (object3.getPosition() >= 0 || object3.getPosition() <= -100) continue;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            PacketHelper.addItemPosition(maplePacketLittleEndianWriter, object3, false, false);
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, object3);
        }
        if (GameSetConstants.MAPLE_VERSION > 113) {
            list = list2;
            a2.writeShort(0);
        } else {
            a2.write(0);
            list = list2;
        }
        for (IItem iItem : list) {
            if (iItem.getPosition() > -100 || iItem.getPosition() <= -1000) continue;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            PacketHelper.addItemPosition(maplePacketLittleEndianWriter, iItem, false, false);
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
        }
        if (GameSetConstants.MAPLE_VERSION > 113) {
            mapleCharacter = a3;
            a2.writeShort(0);
        } else {
            a2.write(0);
            mapleCharacter = a3;
        }
        object2 = mapleCharacter.getInventory(MapleInventoryType.EQUIP);
        Iterator<IItem> iterator = ((MapleInventory)object2).list().iterator();
        Iterator<IItem> iterator2 = iterator;
        while (iterator2.hasNext()) {
            IItem iItem = iterator.next();
            iterator2 = iterator;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            PacketHelper.addItemPosition(maplePacketLittleEndianWriter, iItem, false, false);
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
        }
        if (GameSetConstants.MAPLE_VERSION > 113) {
            a2.writeShort(0);
        } else {
            a2.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION > 113) {
            for (IItem iItem : list2) {
                if (iItem.getPosition() > -1000 || iItem.getPosition() <= -1100) continue;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                PacketHelper.addItemPosition(maplePacketLittleEndianWriter, iItem, false, false);
                PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
            }
            a2.writeShort(0);
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                for (IItem iItem : list2) {
                    if (iItem.getPosition() > -1100 || iItem.getPosition() <= -1200) continue;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    PacketHelper.addItemPosition(maplePacketLittleEndianWriter, iItem, false, false);
                    PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
                }
                a2.writeShort(0);
                for (IItem iItem : list2) {
                    if (iItem.getPosition() > -1200 || iItem.getPosition() <= -1300) continue;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    PacketHelper.addItemPosition(maplePacketLittleEndianWriter, iItem, false, false);
                    PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
                }
                a2.writeShort(0);
            }
            if (GameSetConstants.MAPLE_VERSION >= 143) {
                for (IItem iItem : list2) {
                    if (iItem.getPosition() > -5000 || iItem.getPosition() <= -5003) continue;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    PacketHelper.addItemPosition(maplePacketLittleEndianWriter, iItem, false, false);
                    PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem, a3);
                }
                a2.writeShort(0);
            }
            if (GameSetConstants.MAPLE_VERSION >= 152) {
                for (IItem iItem : list2) {
                    if (iItem.getPosition() > -1300 || iItem.getPosition() <= -1310) continue;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    PacketHelper.addItemPosition(maplePacketLittleEndianWriter, iItem, false, false);
                    PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem, a3);
                }
                a2.writeShort(0);
            }
        }
        int n2 = 2;
        block8: do {
            IItem iItem;
            Iterator<Object> iterator3;
            MapleInventoryType[] arrmapleInventoryType = new MapleInventoryType[6];
            arrmapleInventoryType[0] = MapleInventoryType.UNDEFINED;
            arrmapleInventoryType[1] = MapleInventoryType.EQUIP;
            arrmapleInventoryType[2] = MapleInventoryType.USE;
            arrmapleInventoryType[3] = MapleInventoryType.SETUP;
            arrmapleInventoryType[4] = MapleInventoryType.ETC;
            arrmapleInventoryType[5] = MapleInventoryType.CASH;
            MapleInventoryType[] arrmapleInventoryType2 = arrmapleInventoryType;
            object2 = a3.getInventory(arrmapleInventoryType2[n2]).newList();
            list2 = new LinkedList<IItem>();
            if (arrmapleInventoryType2[n2] == MapleInventoryType.ETC) {
                iterator3 = object2.iterator();
                while (iterator3.hasNext()) {
                    iItem = (IItem)iterator3.next();
                    if (iItem.getPosition() <= 100) continue;
                    list2.add(iItem);
                }
            }
            object2.removeAll(list2);
            iterator3 = object2.iterator();
            Iterator iterator4 = iterator3;
            while (true) {
                IItem iItem2 = iItem = iterator4.hasNext() ? (Item)iterator3.next() : null;
                a2.write(PacketHelper.getItemPosition((Item)iItem2, false, false));
                if (iItem2 == null) continue block8;
                iterator4 = iterator3;
                PacketHelper.addItemInfo(a2, iItem, a3);
            }
        } while (++n2 <= 5);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (!a4) {
                int n3;
                int n4 = n3 = 0;
                while (n4 < a3.getExtendedSlots().size()) {
                    void var6_26;
                    object2 = a3.getExtendedSlotByIndex((int)var6_26);
                    int n5 = ((MapleExtendedSlots)object2).getUniqueid();
                    MapleCharacter mapleCharacter2 = a3;
                    void v16 = var6_26;
                    a2.writeInt((int)v16);
                    a2.writeInt(mapleCharacter2.getExtendedSlot((int)v16));
                    for (IItem iItem : mapleCharacter2.getInventory(MapleInventoryType.ETC).list()) {
                        if (iItem.getUniqueId() != n5 || iItem.getItemId() == ((MapleExtendedSlots)object2).getItemId() || iItem.getPosition() < 100) continue;
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                        PacketHelper.addItemPosition(maplePacketLittleEndianWriter, iItem, false, true);
                        PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
                    }
                    a2.writeInt(-1);
                    n4 = ++var6_26;
                }
            }
            a2.writeInt(-1);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, MapleCharacter a3, Map<MapleBuffStat, Integer> a42) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        PacketHelper.writeBuffMask(a2, a42);
        a42 = new ArrayList();
        long l2 = 0xFFFC00L;
        if (a3.getBuffedValue(MapleBuffStat.FINAL_CUT) != null) {
            a42.add(new Pair<Integer, Integer>(a3.getBuffedValue(MapleBuffStat.FINAL_CUT), 2));
        }
        if (a3.getBuffedValue(MapleBuffStat.OWL_SPIRIT) != null) {
            a42.add(new Pair<Integer, Integer>(a3.getBuffedValue(MapleBuffStat.OWL_SPIRIT), 2));
        }
        if (a3.getBuffedValue(MapleBuffStat.PYRAMID_PQ) != null) {
            a42.add(new Pair<Integer, Integer>(a3.getBuffedValue(MapleBuffStat.PYRAMID_PQ), 0));
        }
        if (a3.getBuffedValue(MapleBuffStat.MAGIC_SHIELD) != null) {
            a42.add(new Pair<Integer, Integer>(a3.getBuffedValue(MapleBuffStat.MAGIC_SHIELD), 0));
        }
        if (a3.getBuffedValue(MapleBuffStat.COMBO) != null) {
            a42.add(new Pair<Integer, Integer>(a3.getBuffedValue(MapleBuffStat.COMBO), 0));
        }
        if (a3.getBuffedValue(MapleBuffStat.DIVINE_BODY) != null) {
            a42.add(new Pair<Integer, Integer>(a3.getBuffedValue(MapleBuffStat.DIVINE_BODY), 2));
        }
        if (a3.getBuffedValue(MapleBuffStat.MORPH) != null) {
            a42.add(new Pair<Integer, Integer>(a3.getBuffedValue(MapleBuffStat.MORPH), 1));
        }
        a42 = a42.iterator();
        block5: while (true) {
            Iterator<Pair<Integer, Integer>> iterator = a42;
            block6: while (iterator.hasNext()) {
                Pair pair = (Pair)a42.next();
                switch ((Integer)pair.right) {
                    case 0: {
                        a2.write((Integer)pair.left);
                        iterator = a42;
                        continue block6;
                    }
                    case 1: {
                        a2.writeShort((Integer)pair.left);
                        iterator = a42;
                        continue block6;
                    }
                    case 2: {
                        a2.writeInt((Integer)pair.left);
                        iterator = a42;
                        continue block6;
                    }
                }
                continue block5;
            }
            break;
        }
        int a42 = Randomizer.nextInt();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a2;
        a2.writeShort(0);
        maplePacketLittleEndianWriter7.writeLong(0L);
        maplePacketLittleEndianWriter7.write(1);
        maplePacketLittleEndianWriter6.writeInt(a42);
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter5.writeLong(0L);
        maplePacketLittleEndianWriter5.write(1);
        maplePacketLittleEndianWriter4.writeInt(a42);
        maplePacketLittleEndianWriter4.writeShort(0);
        maplePacketLittleEndianWriter3.writeLong(0L);
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeInt(a42);
        maplePacketLittleEndianWriter2.writeShort(0);
        int n2 = a3.getBuffSource(MapleBuffStat.MONSTER_RIDING);
        if (n2 > 0) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8;
            MapleCharacter mapleCharacter = a3;
            IItem iItem = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-118);
            IItem iItem2 = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-18);
            if (GameConstants.getMountItem(n2, a3) == 0 && iItem != null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = a2;
                maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter9;
                maplePacketLittleEndianWriter9.writeInt(iItem.getItemId());
            } else if (GameConstants.getMountItem(n2, a3) == 0 && iItem2 != null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = a2;
                maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter10;
                maplePacketLittleEndianWriter10.writeInt(iItem2.getItemId());
            } else {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = a2;
                maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter11;
                maplePacketLittleEndianWriter11.writeInt(GameConstants.getMountItem(n2, a3));
            }
            maplePacketLittleEndianWriter8.writeInt(n2);
            maplePacketLittleEndianWriter = a2;
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = a2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter12;
            maplePacketLittleEndianWriter12.writeLong(0L);
        }
        maplePacketLittleEndianWriter.write(1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter14 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter15 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter16 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter17 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter18 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter19 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter20 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter21 = a2;
        maplePacketLittleEndianWriter21.writeInt(a42);
        maplePacketLittleEndianWriter21.writeLong(0L);
        maplePacketLittleEndianWriter20.write(1);
        maplePacketLittleEndianWriter20.writeInt(a42);
        maplePacketLittleEndianWriter19.writeInt(1);
        maplePacketLittleEndianWriter19.writeLong(0L);
        maplePacketLittleEndianWriter18.write(0);
        maplePacketLittleEndianWriter18.writeShort(0);
        maplePacketLittleEndianWriter17.write(1);
        maplePacketLittleEndianWriter17.writeInt(a42);
        maplePacketLittleEndianWriter16.writeInt(0);
        maplePacketLittleEndianWriter16.writeLong(0L);
        maplePacketLittleEndianWriter15.write(1);
        maplePacketLittleEndianWriter15.writeInt(a42);
        maplePacketLittleEndianWriter14.writeShort(0);
        maplePacketLittleEndianWriter14.writeLong(0L);
        maplePacketLittleEndianWriter13.write(1);
        maplePacketLittleEndianWriter13.writeInt(a42);
    }

    public static /* synthetic */ void addStartedQuestInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        a3 = ((MapleCharacter)((Object)a3)).getStartedQuests();
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            a2.write(1);
        }
        a2.writeShort(a3.size());
        a3 = a3.iterator();
        while (a3.hasNext()) {
            MapleQuestStatus mapleQuestStatus;
            MapleQuestStatus mapleQuestStatus2 = mapleQuestStatus = (MapleQuestStatus)a3.next();
            a2.writeShort(mapleQuestStatus2.getQuest().getId());
            if (mapleQuestStatus2.hasMobKills()) {
                StringBuilder stringBuilder = new StringBuilder();
                Iterator<Integer> iterator = mapleQuestStatus.getMobKills().values().iterator();
                while (iterator.hasNext()) {
                    Iterator<Integer> iterator2;
                    int n2 = iterator2.next();
                    iterator = iterator2;
                    stringBuilder.append(StringUtil.getLeftPaddedStr(String.valueOf(n2), '0', 3));
                }
                a2.writeMapleAsciiString(stringBuilder.toString());
                continue;
            }
            a2.writeMapleAsciiString(mapleQuestStatus.getCustomData() == null ? "" : mapleQuestStatus.getCustomData());
        }
        if (GameSetConstants.MAPLE_VERSION == 143) {
            a2.writeLong(0L);
        }
    }

    private static /* synthetic */ void H(MaplePacketLittleEndianWriter a2, MapleCharacter a3, Map<MapleBuffStat, Integer> a4) {
        Map<MapleBuffStat, Integer> map;
        Map<MapleBuffStat, Integer> map2;
        Map<MapleBuffStat, Integer> map3 = a4;
        PacketHelper.writeBuffMask(a2, map3);
        if (map3.containsKey(MapleBuffStat.SPEED)) {
            a2.write(a4.get(MapleBuffStat.SPEED).byteValue());
        }
        if (a4.containsKey(MapleBuffStat.SUMMON)) {
            a2.write(a4.get(MapleBuffStat.SUMMON).byteValue());
            map2 = a4;
        } else {
            if (a4.containsKey(MapleBuffStat.COMBO)) {
                a2.write(a4.get(MapleBuffStat.COMBO).byteValue());
            }
            map2 = a4;
        }
        if (map2.containsKey(MapleBuffStat.WK_CHARGE)) {
            a2.writeInt(a4.get(MapleBuffStat.WK_CHARGE));
        }
        if (a4.containsKey(MapleBuffStat.STUN)) {
            a2.writeInt(a4.get(MapleBuffStat.STUN));
        }
        if (a4.containsKey(MapleBuffStat.DARKNESS)) {
            a2.writeInt(a4.get(MapleBuffStat.DARKNESS));
        }
        if (a4.containsKey(MapleBuffStat.SEAL)) {
            a2.writeInt(a4.get(MapleBuffStat.SEAL));
        }
        if (a4.containsKey(MapleBuffStat.WEAKEN)) {
            a2.writeInt(a4.get(MapleBuffStat.WEAKEN));
        }
        if (a4.containsKey(MapleBuffStat.CURSE)) {
            a2.writeInt(a4.get(MapleBuffStat.CURSE));
        }
        if (a4.containsKey(MapleBuffStat.POISON)) {
            a2.writeShort(a4.get(MapleBuffStat.POISON).shortValue());
        }
        if (a4.containsKey(MapleBuffStat.POISON)) {
            a2.writeInt(a4.get(MapleBuffStat.POISON));
        }
        if (a4.containsKey(MapleBuffStat.MORPH)) {
            a2.writeShort(a4.get(MapleBuffStat.MORPH).shortValue());
        }
        if (a4.containsKey(MapleBuffStat.GHOST_MORPH)) {
            a2.writeShort(a4.get(MapleBuffStat.GHOST_MORPH).shortValue());
        }
        if (a4.containsKey(MapleBuffStat.SEDUCE)) {
            a2.writeInt(a4.get(MapleBuffStat.SEDUCE));
        }
        if (a4.containsKey(MapleBuffStat.SPIRIT_CLAW)) {
            a2.writeInt(a4.get(MapleBuffStat.SPIRIT_CLAW));
        }
        if (a4.containsKey(MapleBuffStat.ZOMBIFY)) {
            a2.writeInt(a4.get(MapleBuffStat.ZOMBIFY));
        }
        if (a4.containsKey(MapleBuffStat.ARIANT_COSS_IMU)) {
            a2.writeInt(a4.get(MapleBuffStat.ARIANT_COSS_IMU));
        }
        if (a4.containsKey(MapleBuffStat.DIVINE_BODY)) {
            a2.writeInt(a4.get(MapleBuffStat.DIVINE_BODY));
        }
        if (a4.containsKey(MapleBuffStat.REVERSE_DIRECTION)) {
            a2.writeInt(a4.get(MapleBuffStat.REVERSE_DIRECTION));
        }
        if (a4.containsKey(MapleBuffStat.MESO_RATE)) {
            a2.writeInt(a4.get(MapleBuffStat.MESO_RATE));
        }
        if (a4.containsKey(MapleBuffStat.EXPRATE)) {
            a2.writeInt(a4.get(MapleBuffStat.EXPRATE));
            map = a4;
        } else {
            if (a4.containsKey(MapleBuffStat.EXPRATE_ADD)) {
                a2.writeInt(a4.get(MapleBuffStat.EXPRATE_ADD));
            }
            map = a4;
        }
        if (map.containsKey(MapleBuffStat.ACASH_RATE)) {
            a2.writeInt(a4.get(MapleBuffStat.ACASH_RATE));
        }
        if (a4.containsKey(MapleBuffStat.GM_HIDE)) {
            a2.writeInt(a4.get(MapleBuffStat.GM_HIDE));
        }
        if (a4.containsKey(MapleBuffStat.SOARING)) {
            // empty if block
        }
        if (a4.containsKey(MapleBuffStat.BERSERK_FURY)) {
            // empty if block
        }
        if (a4.containsKey(MapleBuffStat.ILLUSION)) {
            // empty if block
        }
        if (a4.containsKey(MapleBuffStat.WIND_WALK)) {
            // empty if block
        }
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            if (a4.containsKey(MapleBuffStat.PYRAMID_PQ)) {
                a2.writeInt(a4.get(MapleBuffStat.PYRAMID_PQ));
            }
            if (a4.containsKey(MapleBuffStat.POTION)) {
                a2.writeInt(a4.get(MapleBuffStat.POTION));
            }
            if (a4.containsKey(MapleBuffStat.SHADOW)) {
                a2.writeInt(a4.get(MapleBuffStat.SHADOW));
            }
            if (a4.containsKey(MapleBuffStat.MAGIC_SHIELD)) {
                a2.writeInt(a4.get(MapleBuffStat.MAGIC_SHIELD));
            }
            if (a4.containsKey(MapleBuffStat.FREEZE)) {
                a2.writeInt(a4.get(MapleBuffStat.FREEZE));
            }
            if (a4.containsKey(MapleBuffStat.OWL_SPIRIT)) {
                a2.writeInt(a4.get(MapleBuffStat.OWL_SPIRIT));
            }
            if (a4.containsKey(MapleBuffStat.FINAL_CUT)) {
                a2.writeInt(a4.get(MapleBuffStat.FINAL_CUT));
            }
            if (a4.containsKey(MapleBuffStat.TORNADO)) {
                a2.write(a4.get(MapleBuffStat.TORNADO).byteValue());
            }
            if (a4.containsKey(MapleBuffStat.MECH_CHANGE)) {
                a2.writeInt(a4.get(MapleBuffStat.MECH_CHANGE));
            }
            if (a4.containsKey(MapleBuffStat.DARK_AURA)) {
                a2.writeInt(a4.get(MapleBuffStat.DARK_AURA));
            }
            if (a4.containsKey(MapleBuffStat.BLUE_AURA)) {
                a2.writeInt(a4.get(MapleBuffStat.BLUE_AURA));
            }
            if (a4.containsKey(MapleBuffStat.YELLOW_AURA)) {
                a2.writeInt(a4.get(MapleBuffStat.YELLOW_AURA));
            }
            if (a4.containsKey(MapleBuffStat.DIVINE_SHIELD)) {
                a2.writeInt(a4.get(MapleBuffStat.DIVINE_SHIELD));
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter.write(0);
        PacketHelper.addDefaultBuffStat_BeforeBB(a2, a3, a4);
    }

    public static /* synthetic */ void addExpirationTime(MaplePacketLittleEndianWriter a2, long a3) {
        if (GameSetConstants.MAPLE_VERSION == 75) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.write(0);
            maplePacketLittleEndianWriter.writeShort(1408);
            if (a3 != -1L) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
                maplePacketLittleEndianWriter2.writeInt(KoreanDateUtil.getItemTimestamp(a3));
                maplePacketLittleEndianWriter2.write(1);
                return;
            }
            a2.writeInt(400967355);
            a2.write(2);
            return;
        }
        a2.writeLong(PacketHelper.getTime(a3));
    }

    public static /* synthetic */ void addItemPosition(MaplePacketLittleEndianWriter a2, IItem a3, boolean a4, boolean a5) {
        if (a3 == null) {
            a2.write(0);
            return;
        }
        short s2 = a3.getPosition();
        if (s2 <= -1 && (s2 = (short)(s2 * -1)) > 100 && s2 < 1000) {
            s2 = (short)(s2 - 100);
        }
        if (a5) {
            a2.writeInt(s2 % 100 - 1);
            return;
        }
        if (!a4 && a3.getType() == 1) {
            if (GameSetConstants.MAPLE_VERSION > 113) {
                a2.writeShort(s2);
                return;
            }
            a2.write(s2);
            return;
        }
        a2.write(s2);
    }

    public static /* synthetic */ void addQuestInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        Object object = ((MapleCharacter)a3).getStartedQuests();
        List<MapleQuestStatus> list = object;
        a2.writeShort(list.size());
        Object object2 = object = list.iterator();
        while (object2.hasNext()) {
            MapleQuestStatus mapleQuestStatus = (MapleQuestStatus)object.next();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeShort(mapleQuestStatus.getQuest().getId());
            maplePacketLittleEndianWriter.writeMapleAsciiString(mapleQuestStatus.getCustomData() != null ? mapleQuestStatus.getCustomData() : "");
            object2 = object;
        }
        object = ((MapleCharacter)a3).getCompletedQuests();
        List<MapleQuestStatus> list2 = object;
        a2.writeShort(list2.size());
        Object object3 = a3 = list2.iterator();
        while (object3.hasNext()) {
            object = (MapleQuestStatus)a3.next();
            object3 = a3;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeShort(((MapleQuestStatus)object).getQuest().getId());
            int n2 = KoreanDateUtil.getQuestTimestamp(((MapleQuestStatus)object).getCompletionTime());
            maplePacketLittleEndianWriter.writeInt(n2);
            maplePacketLittleEndianWriter.writeInt(n2);
        }
    }

    public static final /* synthetic */ void addPetItemInfo(MaplePacketLittleEndianWriter a2, IItem a3, MaplePet a4, boolean a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        PacketHelper.addExpirationTime(a2, a3 != null ? a3.getExpiration() : -1L);
        String string = a4.getName();
        if (string == null) {
            string = "";
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.writeInt(-1);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MaplePet maplePet = a4;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        maplePacketLittleEndianWriter3.writeAsciiString(string, 13);
        maplePacketLittleEndianWriter3.write(a4.getLevel());
        maplePacketLittleEndianWriter2.writeShort(maplePet.getCloseness());
        maplePacketLittleEndianWriter2.write(maplePet.getFullness());
        if (a3 == null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeLong(PacketHelper.getKoreanTimestamp((long)((double)System.currentTimeMillis() * 1.5)));
        } else {
            PacketHelper.addExpirationTime(a2, a3.getExpiration() <= System.currentTimeMillis() ? -1L : a3.getExpiration());
            maplePacketLittleEndianWriter = a2;
        }
        maplePacketLittleEndianWriter.writeShort(a4.getSpeed() > 0 ? 1 : 0);
        a2.writeShort(a4.getFlags());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.writeInt(a4.getPetItemId() == 5000054 && a4.getSecondsLeft() > 0 ? a4.getSecondsLeft() : 0);
        }
        if (GameSetConstants.MAPLE_VERSION != 75) {
            if (GameSetConstants.MAPLE_VERSION >= 120) {
                a2.writeShort(a4.isCanPickup() == 0 ? 0 : 2);
                a2.write(a5 ? (a4.getSummoned() ? a4.getSummonedValue() : (byte)0) : (byte)0);
            } else if (GameSetConstants.MAPLE_VERSION > 113) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
                maplePacketLittleEndianWriter5.write(0);
                maplePacketLittleEndianWriter5.write(a5 ? (a4.getSummoned() ? a4.getSummonedValue() : (byte)0) : (byte)0);
            } else {
                a2.writeShort(0);
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.writeInt(a5 ? a4.getBuffSkill() : 0);
        } else if (GameSetConstants.MAPLE_VERSION != 75) {
            int n2 = a3 = 0;
            while (n2 < 4) {
                a2.write(0);
                n2 = ++a3;
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
            a2.writeInt(a4.getSkill());
            maplePacketLittleEndianWriter6.writeInt(0);
            maplePacketLittleEndianWriter6.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            a2.writeInt(a4.getColor());
        }
    }

    public static final /* synthetic */ long getKoreanTimestamp(long a2) {
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (a2 == -1L) {
                return 150842304000000000L;
            }
            if (a2 == -2L) {
                return 94354848000000000L;
            }
            if (a2 == -3L) {
                return 150841440000000000L;
            }
        } else if (a2 == -1L) {
            return 150842304000000000L;
        }
        return a2 / 1000L / 60L * 600000000L + 116444592000000000L;
    }

    public static /* synthetic */ void addRedLeafInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        int n2;
        int[] arrn = new int[4];
        arrn[0] = 9410165;
        arrn[1] = 9410166;
        arrn[2] = 9410167;
        arrn[3] = 9410168;
        int[] arrn2 = arrn;
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            int[] arrn3 = new int[5];
            arrn3[0] = 9410165;
            arrn3[1] = 9410166;
            arrn3[2] = 9410167;
            arrn3[3] = 9410168;
            arrn3[4] = 9410198;
            arrn2 = arrn3;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MapleCharacter mapleCharacter = a3;
        maplePacketLittleEndianWriter.writeInt(mapleCharacter.getClient().getAccID());
        maplePacketLittleEndianWriter.writeInt(mapleCharacter.getId());
        int n3 = arrn2.length;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        maplePacketLittleEndianWriter2.writeInt(n3);
        maplePacketLittleEndianWriter2.writeInt(0);
        int n4 = n2 = 0;
        while (n4 < n3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            maplePacketLittleEndianWriter3.writeInt(arrn2[n2]);
            maplePacketLittleEndianWriter3.writeInt(a3.getFriendShipPoints()[n2++]);
            n4 = n2;
        }
    }

    public /* synthetic */ PacketHelper() {
        PacketHelper a2;
    }

    public static final /* synthetic */ void addCoolDownInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        Iterator iterator = a3 = ((MapleCharacter)((Object)a3)).getCooldowns();
        a2.writeShort(iterator.size());
        a3 = iterator.iterator();
        while (a3.hasNext()) {
            MapleCoolDownValueHolder mapleCoolDownValueHolder = (MapleCoolDownValueHolder)a3.next();
            a2.writeInt(mapleCoolDownValueHolder.skillId);
            if (GameSetConstants.MAPLE_VERSION >= 147) {
                a2.writeInt((int)(mapleCoolDownValueHolder.length + mapleCoolDownValueHolder.startTime - System.currentTimeMillis()) / 1000);
                continue;
            }
            a2.writeShort((int)(mapleCoolDownValueHolder.length + mapleCoolDownValueHolder.startTime - System.currentTimeMillis()) / 1000);
        }
    }

    public static /* synthetic */ void addCoreAura(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        if (a3.getCoreAura() == null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeZeroBytes(84);
            maplePacketLittleEndianWriter.write(0);
            return;
        }
        MapleCoreAura mapleCoreAura = a3.getCoreAura();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
        MapleCoreAura mapleCoreAura2 = mapleCoreAura;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
        MapleCoreAura mapleCoreAura3 = mapleCoreAura;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = a2;
        MapleCoreAura mapleCoreAura4 = mapleCoreAura;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = a2;
        maplePacketLittleEndianWriter9.writeInt(mapleCoreAura.getId());
        maplePacketLittleEndianWriter9.writeInt(a3.getId());
        a2.writeInt(mapleCoreAura4.getLevel());
        maplePacketLittleEndianWriter8.writeInt(mapleCoreAura4.getCoreAuraLevel());
        maplePacketLittleEndianWriter8.writeInt(0);
        maplePacketLittleEndianWriter7.writeInt(0);
        maplePacketLittleEndianWriter7.writeInt(0);
        maplePacketLittleEndianWriter6.writeInt(0);
        maplePacketLittleEndianWriter6.writeInt(mapleCoreAura.getWatk());
        a2.writeInt(mapleCoreAura3.getDex());
        maplePacketLittleEndianWriter5.writeInt(mapleCoreAura3.getLuk());
        maplePacketLittleEndianWriter5.writeInt(mapleCoreAura.getMagic());
        a2.writeInt(mapleCoreAura2.getInt());
        maplePacketLittleEndianWriter4.writeInt(mapleCoreAura2.getStr());
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter3.writeInt(ItemConstants.getCoreMaxByLevel(mapleCoreAura.getCoreLevel()));
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter2.writeLong(PacketHelper.getTime(mapleCoreAura.getExpiration()));
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.write(JobConstants.is\u84bc\u9f8d\u4fe0\u5ba2(a3.getJob()) ? 1 : 0);
    }

    public static /* synthetic */ int getItemPosition(Item a2, boolean a3, boolean a4) {
        if (a2 == null) {
            return 0;
        }
        short s2 = a2.getPosition();
        if (s2 <= -1 && (s2 = (short)(s2 * -1)) > 100 && s2 < 1000) {
            s2 = (short)(s2 - 100);
        }
        if (a4) {
            return s2 % 100 - 1;
        }
        if (!a3 && a2.getType() == 1) {
            return s2;
        }
        return s2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void addCharacterInfo(MaplePacketLittleEndianWriter a, MapleCharacter a, boolean a) {
        block78: {
            block77: {
                block76: {
                    var3_3 = -1L;
                    a.writeLong(var3_3);
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        v0 = var3_3;
                        a.writeZeroBytes(7);
                    } else {
                        if (GameSetConstants.MAPLE_VERSION != 75) {
                            a.write(0);
                        }
                        v0 = var3_3;
                    }
                    if ((v0 & 1L) != 0L) {
                        v1 = a;
                        PacketHelper.addCharStats(v1, a);
                        v1.write(a.getBuddylist().getCapacity());
                        if (GameSetConstants.MAPLE_VERSION != 75) {
                            a.write(a.getBlessOfFairyOrigin() != null);
                            if (a.getBlessOfFairyOrigin() != null) {
                                a.writeMapleAsciiString(a.getBlessOfFairyOrigin());
                            }
                        }
                        if (GameSetConstants.MAPLE_VERSION >= 134) {
                            a.write(a.getBlessOfEmpressOrigin() != null);
                            if (a.getBlessOfEmpressOrigin() != null) {
                                a.writeMapleAsciiString(a.getBlessOfEmpressOrigin());
                            }
                            a.write((var5_4 = a.getQuestNoAdd(MapleQuest.getInstance(111111))) != null && var5_4.getCustomData() != null);
                            if (var5_4 != null && var5_4.getCustomData() != null) {
                                a.writeMapleAsciiString(var5_4.getCustomData());
                            }
                        }
                        a.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
                    }
                    if ((var3_3 & 2L) != 0L) {
                        v2 = a;
                        v3 = a;
                        a.writeInt(a.getMeso());
                        a.writeInt(v3.getId());
                        v2.writeInt(v3.getBeans());
                        v2.writeInt(a.getCSPoints(2));
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 139 && ((var3_3 & 8L) != 0L || (var3_3 & 8L | 0x2000000L & var3_3) != 0L)) {
                        var5_5 = 0;
                        a.writeInt(var5_5);
                        v4 = var6_12 = 0;
                        while (v4 < var5_5) {
                            v5 = a;
                            v6 = a;
                            v6.writeInt(0);
                            v6.writeInt(0);
                            v5.writeInt(0);
                            v5.writeInt(0);
                            v4 = ++var6_12;
                        }
                    }
                    if ((var3_3 & 128L) != 0L) {
                        v7 = a;
                        v8 = a;
                        v9 = a;
                        v9.write(a.getInventory(MapleInventoryType.EQUIP).getSlotLimit());
                        v9.write(a.getInventory(MapleInventoryType.USE).getSlotLimit());
                        a.write(v8.getInventory(MapleInventoryType.SETUP).getSlotLimit());
                        v7.write(v8.getInventory(MapleInventoryType.ETC).getSlotLimit());
                        v7.write(a.getInventory(MapleInventoryType.CASH).getSlotLimit());
                    }
                    if (GameSetConstants.MAPLE_VERSION != 75 && (var3_3 & 0x100000L) != 0L) {
                        if (GameSetConstants.MAPLE_VERSION >= 134) {
                            var5_4 = a.getQuestNoAdd(MapleQuest.getInstance(122700));
                            if (var5_4 != null && var5_4.getCustomData() != null && Long.parseLong(var5_4.getCustomData()) > System.currentTimeMillis()) {
                                a.writeLong(PacketHelper.getTime(Long.parseLong(var5_4.getCustomData())));
                            } else {
                                a.writeLong(PacketHelper.getTime(-2L));
                            }
                        } else {
                            a.writeLong(PacketHelper.getTime(-2L));
                        }
                    }
                    if ((var3_3 & 4L) != 0L) {
                        PacketHelper.addInventoryInfo(a, a, (boolean)a);
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        if ((var3_3 & 0x1000000L) != 0L) {
                            PacketHelper.addSenseExpInfo(a, a);
                        }
                        if (GameSetConstants.MAPLE_VERSION > 143 && (var3_3 & 0x40000000L) != 0L) {
                            PacketHelper.addLuckyDayInfo(a, a);
                        }
                        if ((var3_3 & 0x800000L) != 0L) {
                            PacketHelper.addPotInfo(a, a);
                        }
                    }
                    if (a != 0) break block76;
                    if ((var3_3 & 256L) != 0L) {
                        PacketHelper.addSkillInfo(a, a);
                    }
                    if ((var3_3 & 32768L) != 0L) {
                        PacketHelper.addCoolDownInfo(a, a);
                    }
                    if ((var3_3 & 512L) != 0L) {
                        PacketHelper.addStartedQuestInfo(a, a);
                    }
                    if ((var3_3 & 16384L) == 0L) break block77;
                    v10 = var3_3;
                    PacketHelper.addCompletedQuestInfo(a, a);
                    break block78;
                }
                if (GameSetConstants.MAPLE_VERSION >= 143) {
                    a.write(1);
                }
                a.writeShort(0);
                a.writeShort(0);
                if (GameSetConstants.MAPLE_VERSION >= 139) {
                    a.write(1);
                }
                a.writeShort(0);
                if (GameSetConstants.MAPLE_VERSION == 143) {
                    a.writeLong(0L);
                }
                if (GameSetConstants.MAPLE_VERSION >= 143) {
                    a.write(1);
                }
                a.writeShort(0);
            }
            v10 = var3_3;
        }
        if ((v10 & 1024L) != 0L) {
            PacketHelper.addMiniGameInfo(a, a);
        }
        if ((var3_3 & 2048L) != 0L) {
            PacketHelper.addRingInfo(a, a);
        }
        if ((var3_3 & 4096L) != 0L) {
            PacketHelper.addRocksInfo(a, a);
        }
        if (GameSetConstants.MAPLE_VERSION == 75) {
            return;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) ** GOTO lbl118
        v11 = a;
        if (a == 0) {
            PacketHelper.addMonsterBookInfo(v11, a);
            v12 = a;
        } else {
            v11.writeInt(0);
            v13 = a;
            v13.write(0);
            v13.writeShort(0);
lbl118:
            // 2 sources

            v12 = a;
        }
        if (v12 == 0) {
            if ((var3_3 & 262144L) != 0L) {
                a.QuestInfoPacket(a);
            }
        } else {
            a.writeShort(0);
        }
        if (GameSetConstants.MAPLE_VERSION < 134) {
            if ((var3_3 & 524288L) != 0L) {
                a.writeShort(0);
            }
            if ((var3_3 & 0x200000L) != 0L) {
                a.writeShort(0);
            }
            if ((var3_3 & 0x400000L) == 0L) return;
            a.writeShort(0);
            return;
        }
        if ((var3_3 & 0x200000L) != 0L && MapleJob.is\u72c2\u8c79\u7375\u4eba(a.getJob())) {
            PacketHelper.addJaguarInfo(a, a);
        }
        if (GameSetConstants.MAPLE_VERSION == 145) {
            v14 = a;
            v15 = a;
            v16 = a;
            a.writeShort(0);
            v16.writeShort(0);
            v16.writeZeroBytes(72);
            v15.write(1);
            v15.writeShort(0);
            v14.writeShort(0);
            v14.writeShort(0);
            return;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134 && GameSetConstants.MAPLE_VERSION <= 143) {
            if ((var3_3 & 0x400000L) != 0L) {
                a.writeShort(0);
            }
            if ((var3_3 & 0x1000000L) != 0L) {
                a.writeShort(0);
            }
            if ((var3_3 & 0x2000000L) != 0L) {
                a.writeShort(0);
            }
            if ((var3_3 & 0x4000000L) == 0L) return;
            a.writeShort(0);
            return;
        }
        if ((var3_3 & 0x400000L) != 0L) {
            var5_6 = 0;
            a.writeShort(var5_6);
            v17 = var6_12 = 0;
            while (v17 < var5_6) {
                v18 = a;
                v18.writeShort(0);
                v18.writeLong(0L);
                v17 = ++var6_12;
            }
        }
        if ((var3_3 & 0x4000000L) != 0L) {
            var5_7 = 0;
            a.writeShort(var5_7);
            v19 = var6_12 = 0;
            while (v19 < var5_7) {
                a = 0;
                var7_13 = 0;
                v20 = a;
                v20.writeShort(a);
                v20.writeInt(var7_13);
                if (a != 0 && var7_13 != 0) {
                    v21 = var8_14 = 0;
                    while (v21 < a) {
                        v22 = a;
                        v23 = a;
                        v23.writeInt(var7_13);
                        v23.write(0);
                        v22.writeInt(0);
                        v22.writeShort(0);
                        v21 = ++var8_14;
                    }
                }
                v19 = ++var6_12;
            }
        }
        if (GameSetConstants.MAPLE_VERSION > 143) {
            if ((var3_3 & 0x20000000L) != 0L) {
                v24 = var5_8 = 1;
                while (v24 <= 4) {
                    PacketHelper.addStolenSkills(a, a, var5_8++, false);
                    v24 = var5_8;
                }
            }
            if (GameSetConstants.MAPLE_VERSION <= 145) {
                if ((var3_3 & 0x10000000L) != 0L) {
                    v25 = a;
                    v25.write(1);
                    var5_9 = 0;
                    v25.writeShort(0);
                    v26 = var6_12 = 0;
                    while (v26 < var5_9) {
                        a.writeInt(0);
                        v26 = ++var6_12;
                    }
                }
                if ((var3_3 & -2147483648L) != 0L) {
                    PacketHelper.addOXSystemInfo(a, a);
                }
                if ((var3_3 & 1L) == 0L) return;
                var5_10 = 0;
                a.writeShort(var5_10);
                v27 = var6_12 = 0;
                while (v27 < var5_10) {
                    v28 = a;
                    v29 = a;
                    a.writeInt(0);
                    v29.writeInt(0);
                    v29.writeInt(0);
                    v28.writeInt(0);
                    v28.writeInt(0);
                    v27 = ++var6_12;
                }
                return;
            }
            if ((var3_3 & 0x10000000L) != 0L) {
                PacketHelper.addChosenSkills(a, a);
            }
            if (var3_3 < 0L) {
                PacketHelper.addAbilityInfo(a, a);
            }
            if ((var3_3 & 0x100000000L) != 0L) {
                PacketHelper.addHonorInfo(a, a);
            }
            if ((var3_3 & 0x200000000L) != 0L) {
                PacketHelper.addCoreAura(a, a);
            }
            if (var3_3 < 0L) {
                a.writeShort(0);
            }
            if ((var3_3 & 0x100000000L) != 0L) {
                a.writeShort(0);
            }
            if ((var3_3 & 0x400000000L) != 0L) {
                PacketHelper.addRedLeafInfo(a, a);
            }
            if (GameSetConstants.MAPLE_VERSION < 152) return;
            if ((var3_3 & 0x200000000L) != 0L) {
                var5_11 = true;
                v30 = a;
                v30.write(true);
                var6_12 = 0;
                v30.writeShort(0);
                if (var6_12 > 0) {
                    do {
                        v31 = a;
                        v31.writeShort(0);
                        v31.writeInt(0);
                        a.writeInt(0);
                    } while (--var6_12 > 0);
                }
            }
            if ((var3_3 & 0x400000000L) != 0L) {
                a.write(0);
            }
            if ((var3_3 & 0x800000000L) != 0L) {
                PacketHelper.addDressUpInfo(a, a);
            }
            if ((var3_3 & 0x2000000000L) == 0L) return;
            v32 = a;
            a.writeInt(0);
            v32.writeInt(0);
            v32.writeLong(KoreanDateUtil.getFileTimestamp(-2L, false));
            return;
        }
        if ((var3_3 & 0x10000000L) != 0L) {
            a.writeShort(0);
        }
        if ((var3_3 & 0x20000000L) != 0L) {
            a.writeShort(0);
        }
        if ((var3_3 & 0x40000000L) == 0L) return;
        a.writeShort(0);
    }

    public static /* synthetic */ <E extends Buffstat> void writeMask(MaplePacketLittleEndianWriter a2, Collection<E> a3) {
        PacketHelper.writeMask(a2, a3, GameSetConstants.MAX_BUFFSTAT);
    }

    public static final /* synthetic */ void addCharStats(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MapleCharacter mapleCharacter = a3;
        a2.writeInt(mapleCharacter.getId());
        maplePacketLittleEndianWriter2.writeAsciiString(mapleCharacter.getName(), GameSetConstants.WRITE_STRING_LENGTH);
        maplePacketLittleEndianWriter2.write(a3.getGender());
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            a2.write(2);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        MapleCharacter mapleCharacter2 = a3;
        a2.write(a3.getSkinColor());
        maplePacketLittleEndianWriter3.writeInt(mapleCharacter2.getFace());
        maplePacketLittleEndianWriter3.writeInt(mapleCharacter2.getHair());
        if (GameSetConstants.MAPLE_VERSION < 134) {
            a2.writeZeroBytes(24);
        }
        MapleCharacter mapleCharacter3 = a3;
        a2.write(a3.getLevel());
        a2.writeShort(mapleCharacter3.getJob());
        mapleCharacter3.getStat().connectData(a2);
        a2.writeShort(mapleCharacter3.getRemainingAp());
        if (JobConstants.isSeparatedSp(a3.getJob())) {
            int n3 = a3.getRemainingSpSize();
            a2.write(n3);
            int n4 = n2 = 0;
            while (n4 < a3.getRemainingSps().length) {
                if (a3.getRemainingSp(n2) > 0) {
                    a2.write(n2 + 1);
                    if (GameSetConstants.MAPLE_VERSION >= 152) {
                        a2.writeInt(a3.getRemainingSp(n2));
                    } else {
                        a2.write(a3.getRemainingSp(n2));
                    }
                }
                n4 = ++n2;
            }
        } else {
            a2.writeShort(a3.getRemainingSp());
        }
        a2.writeInt(a3.getExp());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt(a3.getFame());
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.writeShort(a3.getFame());
        }
        maplePacketLittleEndianWriter.writeInt(a3.getGachExp());
        if (GameSetConstants.MAPLE_VERSION != 75) {
            a2.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
        MapleCharacter mapleCharacter4 = a3;
        maplePacketLittleEndianWriter6.writeInt(mapleCharacter4.getMapId());
        maplePacketLittleEndianWriter6.write(mapleCharacter4.getInitialSpawnpoint());
        if (GameSetConstants.MAPLE_VERSION >= 116) {
            a2.writeShort(a3.getSubcategory());
            if (GameSetConstants.MAPLE_VERSION >= 139 && a3.hasFaceMarking()) {
                a2.writeInt(a3.getFaceMarking());
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MapleTrait.MapleTraitType mapleTraitType;
            int n5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a2;
            maplePacketLittleEndianWriter7.write(a3.getFatigue());
            maplePacketLittleEndianWriter7.writeInt(GameConstants.getCurrentDate());
            MapleTrait.MapleTraitType[] arrmapleTraitType = MapleTrait.MapleTraitType.values();
            n2 = arrmapleTraitType.length;
            int n6 = n5 = 0;
            while (n6 < n2) {
                mapleTraitType = arrmapleTraitType[n5];
                a2.writeInt(a3.getTrait(mapleTraitType).getLocalTotalExp());
                n6 = ++n5;
            }
            arrmapleTraitType = MapleTrait.MapleTraitType.values();
            n2 = arrmapleTraitType.length;
            int n7 = n5 = 0;
            while (n7 < n2) {
                mapleTraitType = arrmapleTraitType[n5];
                a2.writeShort(0);
                n7 = ++n5;
            }
            if (GameSetConstants.MAPLE_VERSION >= 148) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = a2;
                maplePacketLittleEndianWriter8.write(0);
                maplePacketLittleEndianWriter8.writeLong(PacketHelper.getTime(-2L));
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = a2;
            MapleCharacter mapleCharacter5 = a3;
            a2.writeInt(mapleCharacter5.getStat().pvpExp);
            maplePacketLittleEndianWriter9.write(mapleCharacter5.getStat().pvpRank);
            maplePacketLittleEndianWriter9.writeInt(a3.getBattlePoints());
            a2.write(5);
            if (GameSetConstants.MAPLE_VERSION >= 151) {
                a2.write(6);
            }
            if (GameSetConstants.MAPLE_VERSION >= 139) {
                a2.writeInt(a3.getGreenSaver());
            }
            if (GameSetConstants.MAPLE_VERSION >= 147) {
                MapleCharacter mapleCharacter6 = a3;
                PacketHelper.addPartTimeJob(a2, MapleCharacterUtil.getPartTime(mapleCharacter6.getId()));
                mapleCharacter6.getCharacterCard().connectData(a2);
            }
            if (GameSetConstants.MAPLE_VERSION >= 143) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = a2;
                maplePacketLittleEndianWriter10.writeInt(0);
                maplePacketLittleEndianWriter10.writeInt(0);
            }
        }
        a2.writeZeroBytes(30);
    }

    public static final /* synthetic */ void addItemBeforeBigBang_116(MaplePacketLittleEndianWriter a2, IItem a3, boolean a4, MapleCharacter a5) {
        if (a3.getType() == 1) {
            a5 = (IEquip)a3;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            Object object = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            Object object2 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            Object object3 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
            Object object4 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
            Object object5 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a2;
            Object object6 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = a2;
            Object object7 = a5;
            a2.write(object7.getUpgradeSlots());
            maplePacketLittleEndianWriter9.write(object7.getLevel());
            maplePacketLittleEndianWriter9.write(0);
            maplePacketLittleEndianWriter8.writeShort(a5.getStr());
            maplePacketLittleEndianWriter8.writeShort(a5.getDex());
            a2.writeShort(object6.getInt());
            maplePacketLittleEndianWriter7.writeShort(object6.getLuk());
            maplePacketLittleEndianWriter7.writeShort(a5.getHp());
            a2.writeShort(object5.getMp());
            maplePacketLittleEndianWriter6.writeShort(object5.getWatk());
            maplePacketLittleEndianWriter6.writeShort(a5.getMatk());
            a2.writeShort(object4.getWdef());
            maplePacketLittleEndianWriter5.writeShort(object4.getMdef());
            maplePacketLittleEndianWriter5.writeShort(a5.getAcc());
            a2.writeShort(object3.getAvoid());
            maplePacketLittleEndianWriter4.writeShort(object3.getHands());
            maplePacketLittleEndianWriter4.writeShort(a5.getSpeed());
            a2.writeShort(object2.getJump());
            maplePacketLittleEndianWriter3.writeMapleAsciiString(object2.getOwner());
            maplePacketLittleEndianWriter3.writeShort(a5.getFlag());
            maplePacketLittleEndianWriter2.write(0);
            maplePacketLittleEndianWriter2.write(Math.max(a5.getBaseLevel(), a5.getEquipLevel()));
            a2.writeInt(object.getExpPercentage() * 4);
            maplePacketLittleEndianWriter.writeInt(object.getDurability());
            maplePacketLittleEndianWriter.write(a5.getState() == 21 ? (byte)20 : (byte)a5.getState());
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = a2;
            Object object8 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = a2;
            Object object9 = a5;
            a2.writeShort(object9.getPotential1());
            maplePacketLittleEndianWriter11.writeShort(object9.getPotential2());
            maplePacketLittleEndianWriter11.writeShort(a5.getPotential3());
            a2.writeShort(object8.getHpR());
            maplePacketLittleEndianWriter10.writeShort(object8.getMpR());
            maplePacketLittleEndianWriter10.writeInt(a5.getViciousHammer());
            if (!a4) {
                a2.writeLong(a5.getInventoryitemId() <= 0L ? -1L : a5.getInventoryitemId());
            }
            a2.writeLong(PacketHelper.getTime(-2L));
            a2.writeInt(-1);
            return;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        IItem iItem = a3;
        a2.writeShort(a3.getQuantity());
        maplePacketLittleEndianWriter.writeMapleAsciiString(iItem.getOwner());
        maplePacketLittleEndianWriter.writeShort(iItem.getFlag());
        if (ItemConstants.isExpChair(a3.getItemId())) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = a2;
            maplePacketLittleEndianWriter12.writeInt(a3.getUniqueId());
            maplePacketLittleEndianWriter12.writeInt(0);
        }
        if (GameConstants.isRechargable(a3.getItemId())) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter14 = a2;
            maplePacketLittleEndianWriter14.writeInt(2);
            maplePacketLittleEndianWriter14.writeShort(84);
            maplePacketLittleEndianWriter13.write(0);
            maplePacketLittleEndianWriter13.write(52);
        }
    }

    public static /* synthetic */ void writeBuffMask(MaplePacketLittleEndianWriter a2, Map<MapleBuffStat, Integer> a3) {
        PacketHelper.writeBuffMask(a2, a3, false);
    }

    public static final /* synthetic */ void addMonsterBookInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        maplePacketLittleEndianWriter.writeInt(a3.getMonsterBookCover());
        maplePacketLittleEndianWriter.write(0);
        a3.getMonsterBook().addCardPacket(a2);
    }

    public static /* synthetic */ void addChosenSkills(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        int n2;
        int n3 = n2 = 1;
        while (n3 <= 4) {
            boolean bl;
            boolean bl2 = false;
            if (a3.getStolenSkills() != null) {
                for (Pair<Integer, Boolean> pair : a3.getStolenSkills()) {
                    if (MapleJob.getJobGrade((Integer)pair.left / 10000) != n2 || !((Boolean)pair.right).booleanValue()) continue;
                    a2.writeInt((Integer)pair.left);
                    bl = bl2 = true;
                    break;
                }
            } else {
                bl = bl2;
            }
            if (!bl) {
                a2.writeInt(0);
            }
            n3 = ++n2;
        }
    }

    public static /* synthetic */ void addStolenSkills(MaplePacketLittleEndianWriter a2, MapleCharacter a3, int a4, boolean a5) {
        int n2;
        if (a5 != 0) {
            a2.writeInt(a4);
        }
        a5 = 0;
        if (((MapleCharacter)((Object)a3)).getStolenSkills() != null) {
            for (Pair<Integer, Boolean> pair : ((MapleCharacter)((Object)a3)).getStolenSkills()) {
                if (MapleJob.getJobGrade((Integer)pair.left / 10000) != a4) continue;
                a2.writeInt((Integer)pair.left);
                if (++a5 < GameConstants.getNumSteal(a4)) continue;
                n2 = a5;
                break;
            }
        } else {
            n2 = a5;
        }
        while (n2 < GameConstants.getNumSteal(a4)) {
            a2.writeInt(0);
            n2 = ++a5;
        }
    }

    public static final /* synthetic */ void addRingInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        Object object;
        Object object2 = a3.getRingsTriple(true);
        Object object3 = ((Triple)object2).getLeft();
        List<MapleRing> list = object3;
        a2.writeShort(list.size());
        Object object4 = object3 = list.iterator();
        while (object4.hasNext()) {
            object = (MapleRing)object3.next();
            object4 = object3;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MapleRing mapleRing = object;
            a2.writeInt(((MapleRing)object).getPartnerChrId());
            a2.writeAsciiString(mapleRing.getPartnerName(), GameSetConstants.WRITE_STRING_LENGTH);
            maplePacketLittleEndianWriter.writeLong(mapleRing.getRingId());
            maplePacketLittleEndianWriter.writeLong(((MapleRing)object).getPartnerRingId());
        }
        object3 = ((Triple)object2).getMid();
        List<MapleRing> list2 = object3;
        a2.writeShort(list2.size());
        Object object5 = object = list2.iterator();
        while (object5.hasNext()) {
            object3 = (MapleRing)object.next();
            object5 = object;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            Object object6 = object3;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            maplePacketLittleEndianWriter2.writeInt(((MapleRing)object3).getPartnerChrId());
            maplePacketLittleEndianWriter2.writeAsciiString(((MapleRing)object3).getPartnerName(), GameSetConstants.WRITE_STRING_LENGTH);
            a2.writeLong(((MapleRing)object6).getRingId());
            maplePacketLittleEndianWriter.writeLong(((MapleRing)object6).getPartnerRingId());
            maplePacketLittleEndianWriter.writeInt(((MapleRing)object3).getItemId());
        }
        object = ((Triple)object2).getRight();
        List<MapleRing> list3 = object;
        a2.writeShort(list3.size());
        int n2 = 30000;
        Object object7 = object2 = list3.iterator();
        while (object7.hasNext()) {
            object = (MapleRing)object2.next();
            object7 = object2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
            maplePacketLittleEndianWriter5.writeInt(n2);
            maplePacketLittleEndianWriter5.writeInt(a3.getId());
            maplePacketLittleEndianWriter4.writeInt(((MapleRing)object).getPartnerChrId());
            maplePacketLittleEndianWriter4.writeShort(3);
            maplePacketLittleEndianWriter3.writeInt(((MapleRing)object).getRingId());
            maplePacketLittleEndianWriter3.writeInt(((MapleRing)object).getPartnerChrId());
            maplePacketLittleEndianWriter.writeAsciiString(a3.getName(), GameSetConstants.WRITE_STRING_LENGTH);
            maplePacketLittleEndianWriter.writeAsciiString(((MapleRing)object).getPartnerName(), GameSetConstants.WRITE_STRING_LENGTH);
        }
    }

    public static final /* synthetic */ void addItemInfo(MaplePacketLittleEndianWriter a2, IItem a3) {
        PacketHelper.addItemInfo(a2, a3, null);
    }

    public static final /* synthetic */ void addItemBeforeBigBang(MaplePacketLittleEndianWriter a2, IItem a3, boolean a4, MapleCharacter a5) {
        if (a3.getType() == 1) {
            a5 = (IEquip)a3;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            Object object = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            Object object2 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            Object object3 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            Object object4 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
            Object object5 = a5;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
            Object object6 = a5;
            a2.write(a5.getUpgradeSlots());
            a2.write(object6.getLevel());
            maplePacketLittleEndianWriter6.writeShort(object6.getStr());
            maplePacketLittleEndianWriter6.writeShort(a5.getDex());
            a2.writeShort(object5.getInt());
            maplePacketLittleEndianWriter5.writeShort(object5.getLuk());
            maplePacketLittleEndianWriter5.writeShort(a5.getHp());
            a2.writeShort(object4.getMp());
            maplePacketLittleEndianWriter4.writeShort(object4.getWatk());
            maplePacketLittleEndianWriter4.writeShort(a5.getMatk());
            a2.writeShort(object3.getWdef());
            maplePacketLittleEndianWriter3.writeShort(object3.getMdef());
            maplePacketLittleEndianWriter3.writeShort(a5.getAcc());
            a2.writeShort(object2.getAvoid());
            maplePacketLittleEndianWriter2.writeShort(object2.getHands());
            maplePacketLittleEndianWriter2.writeShort(a5.getSpeed());
            a2.writeShort(object.getJump());
            maplePacketLittleEndianWriter.writeMapleAsciiString(object.getOwner());
            maplePacketLittleEndianWriter.writeShort(a5.getFlag());
            if (GameSetConstants.MAPLE_VERSION != 75) {
                a2.write(a5.getIncSkill() > 0 ? 1 : 0);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a2;
                maplePacketLittleEndianWriter7.write(Math.max(a5.getBaseLevel(), a5.getEquipLevel()));
                maplePacketLittleEndianWriter7.writeInt(a5.getExpPercentage() * 100000);
            }
            if (!a4) {
                a2.writeLong(a3.getUniqueId());
            }
            if (GameSetConstants.MAPLE_VERSION != 75) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = a2;
                maplePacketLittleEndianWriter8.writeLong(PacketHelper.getTime(-2L));
                maplePacketLittleEndianWriter8.writeInt(-1);
                return;
            }
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            IItem iItem = a3;
            a2.writeShort(a3.getQuantity());
            maplePacketLittleEndianWriter.writeMapleAsciiString(iItem.getOwner());
            maplePacketLittleEndianWriter.writeShort(iItem.getFlag());
            if (GameSetConstants.MAPLE_VERSION != 75 && ItemConstants.isExpChair(a3.getItemId())) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = a2;
                maplePacketLittleEndianWriter9.writeInt(a3.getUniqueId());
                maplePacketLittleEndianWriter9.writeInt(0);
            }
            if (GameConstants.isRechargable(a3.getItemId())) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = a2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = a2;
                maplePacketLittleEndianWriter11.writeInt(2);
                maplePacketLittleEndianWriter11.writeShort(84);
                maplePacketLittleEndianWriter10.write(0);
                maplePacketLittleEndianWriter10.write(52);
            }
        }
    }

    public static /* synthetic */ void addAbilityInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        int n2;
        a3 = ((MapleCharacter)a3).getInnerSkills();
        a2.writeShort(a3.size());
        int n3 = n2 = 0;
        while (n3 < a3.size()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.write(n2 + 1);
            maplePacketLittleEndianWriter.writeInt(((InnerSkillValueHolder)a3.get(n2)).getSkillId());
            a2.write(((InnerSkillValueHolder)a3.get(n2)).getSkillLevel());
            Object e2 = a3.get(n2);
            a2.write(((InnerSkillValueHolder)e2).getRank());
            n3 = ++n2;
        }
    }

    public static final /* synthetic */ long getTime(long a2) {
        if (a2 == -1L) {
            return 150842304000000000L;
        }
        if (a2 == -2L) {
            return 94354848000000000L;
        }
        if (a2 == -3L) {
            return 150841440000000000L;
        }
        return (a2 + 43200000L) * 10000L + 116444592000000000L;
    }

    public static final /* synthetic */ void addJaguarInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        int n2;
        String[] arrstring;
        a2.write(a3.getIntNoRecord(111112));
        Object object = new String[5];
        if (a3.getQuestNAdd(MapleQuest.getInstance(111113)).getCustomData() != null && a3.getQuestNAdd(MapleQuest.getInstance(111113)).getCustomData().length() > 0) {
            arrstring = a3.getQuestNAdd(MapleQuest.getInstance(111113)).getCustomData().split(Rb.ALLATORIxDEMO("\u000f"));
            int n3 = n2 = 0;
            while (n3 < arrstring.length) {
                int n4 = n2++;
                object[n4] = arrstring[n4].replace(" ", "");
                n3 = n2;
            }
        }
        arrstring = object;
        n2 = ((String[])object).length;
        int n5 = a3 = 0;
        while (n5 < n2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            object = arrstring[a3];
            int n6 = 0;
            try {
                n6 = Integer.parseInt((String)object);
                maplePacketLittleEndianWriter = a2;
            }
            catch (Exception exception) {
                maplePacketLittleEndianWriter = a2;
            }
            maplePacketLittleEndianWriter.writeInt(n6);
            n5 = ++a3;
        }
    }

    public static /* synthetic */ void addSpawnPlayerBuffStatus(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        MapleBuffStat mapleBuffStat;
        LinkedHashMap<MapleBuffStat, Integer> linkedHashMap = new LinkedHashMap<MapleBuffStat, Integer>();
        for (PlayerBuffValueHolder object2 : a3.getAllBuffs()) {
            Iterator<Pair<MapleBuffStat, Integer>> iterator = object2.statup.iterator();
            while (iterator.hasNext()) {
                Pair<MapleBuffStat, Integer> pair = mapleBuffStat.next();
                linkedHashMap.put(pair.getLeft(), pair.getRight());
                iterator = mapleBuffStat;
            }
        }
        ArrayList<MapleBuffStat> arrayList = new ArrayList<MapleBuffStat>();
        arrayList.add(MapleBuffStat.ENERGY_CHARGE);
        arrayList.add(MapleBuffStat.DASH_SPEED);
        arrayList.add(MapleBuffStat.DASH_JUMP);
        arrayList.add(MapleBuffStat.MONSTER_RIDING);
        arrayList.add(MapleBuffStat.SPEED_INFUSION);
        arrayList.add(MapleBuffStat.HOMING_BEACON);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            arrayList.add(MapleBuffStat.DEFAULT_BUFFSTAT);
            arrayList.add(MapleBuffStat.DEFAULT_BUFFSTAT2);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            mapleBuffStat = (MapleBuffStat)iterator.next();
            if (linkedHashMap.containsKey(mapleBuffStat) || mapleBuffStat.getIDAValue() < 0) continue;
            linkedHashMap.put(mapleBuffStat, 0);
        }
        PacketHelper.addForeignBuffStatus(a2, linkedHashMap, a3, null);
    }

    public static /* synthetic */ long getFileTimestamp(long a2, boolean a3) {
        long l2;
        long l3;
        if (SimpleTimeZone.getDefault().inDaylightTime(new Date())) {
            a2 -= 3600000L;
        }
        return (a3 ? (l3 = a2 / 1000L / 60L * 600000000L) : (l2 = a2 * 10000L)) + 116444592000000000L;
    }

    public static /* synthetic */ void addForeignBuffStatus(MaplePacketLittleEndianWriter a2, List<Pair<MapleBuffStat, Integer>> a3, MapleCharacter a4, MapleStatEffect a5) {
        HashMap<MapleBuffStat, Integer> hashMap = new HashMap<MapleBuffStat, Integer>();
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            Pair pair = (Pair)a3.next();
            hashMap.put((MapleBuffStat)pair.getLeft(), (Integer)pair.getRight());
            object = a3;
        }
        PacketHelper.addForeignBuffStatus(a2, hashMap, a4, a5);
    }

    public static /* synthetic */ void addDressUpInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        boolean bl = JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(a3.getJob());
        if (bl && a3.getCharacterSet(MapleDueyActions.ALLATORIxDEMO("z8X0U8W#")) == 0L) {
            a3.setCharacterSet(Rb.ALLATORIxDEMO("(L\nD\u0007L\u0005W"), 1051291L);
        }
        a2.writeInt(bl ? a3.getSecondFace() : 0);
        a2.writeInt(bl ? a3.getSecondHair() : 0);
        a2.writeInt(bl ? (int)a3.getCharacterSet(MapleDueyActions.ALLATORIxDEMO("z8X0U8W#")) : 0);
        a2.write(bl ? a3.getSecondSkinColor() : (byte)0);
    }

    public static /* synthetic */ <E extends Buffstat> void writeSingleMask(MaplePacketLittleEndianWriter a2, E a3) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < GameSetConstants.MAX_BUFFSTAT) {
            a2.writeInt(n2 == a3.getPosition() ? (int)a3.getValue() : 0);
            n3 = ++n2;
        }
    }

    public static final /* synthetic */ void addInteraction(MaplePacketLittleEndianWriter a2, IMaplePlayerShop a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        maplePacketLittleEndianWriter.write(a3.getGameType());
        maplePacketLittleEndianWriter.writeInt(((AbstractPlayerStore)a3).getObjectId());
        IMaplePlayerShop iMaplePlayerShop = a3;
        a2.writeMapleAsciiString(iMaplePlayerShop.getDescription());
        if (iMaplePlayerShop.getShopType() != 1) {
            a2.write(a3.getPassword().length() > 0 ? 1 : 0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        IMaplePlayerShop iMaplePlayerShop2 = a3;
        a2.write(a3.getItemId() % 10);
        maplePacketLittleEndianWriter2.write(iMaplePlayerShop2.getSize());
        maplePacketLittleEndianWriter2.write(iMaplePlayerShop2.getMaxSize());
        if (a3.getShopType() != 1) {
            a2.write(a3.isOpen() ? 0 : 1);
        }
    }

    public static /* synthetic */ void writeBuffMask(MaplePacketLittleEndianWriter a2, List<Pair<MapleBuffStat, Integer>> a3) {
        int[] arrn = new int[GameSetConstants.MAX_BUFFSTAT];
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            Pair pair = (Pair)a3.next();
            int n2 = ((MapleBuffStat)pair.getLeft()).getPosition();
            n2 = n2 < 0 ? 0 : n2;
            int[] arrn2 = arrn;
            int n3 = n2;
            arrn2[n3] = arrn2[n3] | (int)((MapleBuffStat)pair.getLeft()).getValue();
            object = a3;
        }
        int n4 = a3 = 0;
        while (n4 < arrn.length) {
            a2.writeInt(arrn[a3++]);
            n4 = a3;
        }
    }

    public static /* synthetic */ void addCompletedQuestInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        a3 = ((MapleCharacter)((Object)a3)).getCompletedQuests();
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            a2.write(1);
        }
        a2.writeShort(a3.size());
        Iterator iterator = a3 = a3.iterator();
        while (iterator.hasNext()) {
            MapleQuestStatus mapleQuestStatus = (MapleQuestStatus)a3.next();
            a2.writeShort(mapleQuestStatus.getQuest().getId());
            if (GameSetConstants.MAPLE_VERSION >= 134 && GameSetConstants.MAPLE_VERSION < 139) {
                a2.writeShort(0);
            }
            a2.writeLong(PacketHelper.getTime(mapleQuestStatus.getCompletionTime()));
            iterator = a3;
        }
    }

    public static final /* synthetic */ void addRocksInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        int n2;
        int n3;
        int[] arrn = a3.getRegRocks();
        int n4 = n3 = 0;
        while (n4 < 5) {
            a2.writeInt(arrn[n3++]);
            n4 = n3;
        }
        int[] arrn2 = a3.getRocks();
        int n5 = n2 = 0;
        while (n5 < 10) {
            a2.writeInt(arrn2[n2++]);
            n5 = n2;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            int[] arrn3 = a3.getHyperRocks();
            int n6 = a3 = 0;
            while (n6 < 13) {
                a2.writeInt(arrn3[a3++]);
                n6 = a3;
            }
        }
    }

    public static /* synthetic */ void addStealSkills(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        int n2;
        int n3 = n2 = 1;
        while (n3 <= 4) {
            PacketHelper.addStolenSkills(a2, a3, n2++, false);
            n3 = n2;
        }
        PacketHelper.addChosenSkills(a2, a3);
    }

    public static final /* synthetic */ void addCharLook(MaplePacketLittleEndianWriter a2, MapleCharacter a3, boolean a42, boolean a5) {
        int n2;
        int n3;
        Map.Entry<Byte, Integer> entry;
        if (a3.isDressingUp()) {
            a5 = true;
        }
        a2.write(a5 ? a3.getSecondGender() : a3.getGender());
        a2.write(a5 ? a3.getSecondSkinColor() : a3.getSkinColor());
        MapleCharacter mapleCharacter = a3;
        a2.writeInt(a5 ? mapleCharacter.getSecondFace() : mapleCharacter.getFace());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.writeInt(a3.getJob());
        }
        a2.write(a42 ? 0 : 1);
        MapleCharacter mapleCharacter2 = a3;
        a2.writeInt(a5 ? mapleCharacter2.getSecondHair() : mapleCharacter2.getHair());
        LinkedHashMap<Byte, Integer> a42 = new LinkedHashMap<Byte, Integer>();
        LinkedHashMap<Byte, Integer> linkedHashMap = new LinkedHashMap<Byte, Integer>();
        Map<Byte, Integer> map = a3.getTotems();
        MapleCharacter mapleCharacter3 = a3;
        Map<Byte, Integer> map2 = a5 ? mapleCharacter3.getSecondEquips(true) : mapleCharacter3.getEquips(true);
        Object object = map2.entrySet().iterator();
        block0: while (true) {
            Object object2 = object;
            while (object2.hasNext()) {
                entry = object.next();
                if (entry.getKey() < -127) continue block0;
                if (entry.getKey() > 0) {
                    object2 = object;
                    continue;
                }
                byte by = (byte)(entry.getKey() * -1);
                n3 = by;
                if (by < 100 && a42.get((byte)n3) == null) {
                    a42.put((byte)n3, entry.getValue());
                    continue block0;
                }
                if (n3 > 100 && n3 != 111) {
                    if (a42.get((byte)(n3 = (byte)(n3 - 100))) != null) {
                        linkedHashMap.put((byte)n3, (Integer)a42.get((byte)n3));
                    }
                    a42.put((byte)n3, entry.getValue());
                    continue block0;
                }
                if (a42.get((byte)n3) == null) {
                    object2 = object;
                    continue;
                }
                linkedHashMap.put((byte)n3, entry.getValue());
                continue block0;
            }
            break;
        }
        Object object3 = object = a42.entrySet().iterator();
        while (object3.hasNext()) {
            entry = object.next();
            n3 = entry.getValue();
            if (GameConstants.getWeaponType(n3) == (a5 ? MapleWeaponType.\u7483 : MapleWeaponType.\u7409)) {
                object3 = object;
                continue;
            }
            a2.write(entry.getKey());
            a2.writeInt(entry.getValue());
            object3 = object;
        }
        a2.write(255);
        Object object4 = object = linkedHashMap.entrySet().iterator();
        while (object4.hasNext()) {
            entry = object.next();
            a2.write(entry.getKey());
            a2.writeInt(entry.getValue());
            object4 = object;
        }
        a2.write(255);
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            Object object5 = object = map.entrySet().iterator();
            while (object5.hasNext()) {
                entry = object.next();
                a2.write(entry.getKey());
                a2.writeInt(entry.getValue());
                object5 = object;
            }
            a2.write(255);
        }
        a2.writeInt((object = map2.getOrDefault((byte)-111, 0)) != null ? (Integer)object : 0);
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            entry = map2.getOrDefault(-11, 0);
            Integer n4 = map2.getOrDefault(-10, 0);
            a2.writeInt(entry != null ? (Integer)((Object)entry) : 0);
            a2.writeInt(n4 != null ? n4 : 0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            a2.write(a3.isElfEar());
        }
        int n5 = n2 = 0;
        while (n5 < 3) {
            a2.writeInt(a3.getSummonedPet(n2) != null ? a3.getSummonedPet(n2).getPetItemId() : 0);
            n5 = ++n2;
        }
        if (GameSetConstants.MAPLE_VERSION >= 139 && a3.hasFaceMarking()) {
            a2.writeInt(a3.getFaceMarking());
        }
    }

    public static /* synthetic */ void addSenseExpInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        int n2 = a3 = 0;
        a2.writeInt(n2);
        int n3 = a3 = n2;
        while (n3 > 0) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.writeLong(0L);
            n3 = --a3;
        }
    }

    public static /* synthetic */ void addInventoryInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        PacketHelper.addInventoryInfo(a2, a3, false);
    }

    public static /* synthetic */ void addPotInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        while (true) {
            int n2 = a3 = 0;
            a2.write(n2);
            if (n2 == 0) {
                return;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
            maplePacketLittleEndianWriter6.writeInt(0);
            maplePacketLittleEndianWriter6.write(0);
            maplePacketLittleEndianWriter5.write(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter3.write(0);
            maplePacketLittleEndianWriter2.writeInt(0);
            maplePacketLittleEndianWriter2.writeLong(0L);
            maplePacketLittleEndianWriter.writeLong(0L);
            maplePacketLittleEndianWriter.writeLong(0L);
            a2.writeLong(0L);
        }
    }

    public static final /* synthetic */ void addSkillInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        Map<ISkill, SkillEntry> map = a3.getSkills();
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            a2.write(1);
        }
        a2.writeShort(map.size());
        for (Map.Entry entry : map.entrySet()) {
            a2.writeInt(((ISkill)entry.getKey()).getId());
            if (((ISkill)entry.getKey()).isLinkSkills()) {
                a2.writeInt(((SkillEntry)entry.getValue()).teachId);
            } else if (((ISkill)entry.getKey()).isTeachSkills()) {
                a2.writeInt(((SkillEntry)entry.getValue()).teachId > 0 ? ((SkillEntry)entry.getValue()).teachId : a3.getId());
            } else {
                a2.writeInt(((SkillEntry)entry.getValue()).skillevel);
            }
            if (GameSetConstants.MAPLE_VERSION > 113) {
                PacketHelper.addExpirationTime(a2, ((SkillEntry)entry.getValue()).expiration);
            }
            if (!((ISkill)entry.getKey()).isSkillNeedMasterLevel()) continue;
            a2.writeInt(((SkillEntry)entry.getValue()).masterlevel);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void addBuffStat_135(MaplePacketLittleEndianWriter a, MapleCharacter a, Map<MapleBuffStat, Integer> a) {
        v0 = a;
        a.remove(MapleBuffStat.SPIRIT_LINK);
        PacketHelper.writeBuffMask(a, v0, true);
        var3_3 = new ArrayList<Integer>();
        if (v0.containsKey(MapleBuffStat.SPEED)) {
            a.write(a.get(MapleBuffStat.SPEED));
        }
        if (a.containsKey(MapleBuffStat.SUMMON)) {
            a.write(a.get(MapleBuffStat.SUMMON).byteValue());
            v1 = a;
        } else {
            if (a.containsKey(MapleBuffStat.COMBO)) {
                a.write(a.get(MapleBuffStat.COMBO).byteValue());
            }
            v1 = a;
        }
        if (v1.containsKey(MapleBuffStat.TORNADO)) {
            a.write(a.get(MapleBuffStat.TORNADO));
        }
        if (a.containsKey(MapleBuffStat.WK_CHARGE)) {
            v2 = a;
            v2.writeShort(a.getBuffedValue(MapleBuffStat.WK_CHARGE));
            v2.writeInt(a.getTrueBuffSource(MapleBuffStat.WK_CHARGE));
        }
        if (a.containsKey(MapleBuffStat.STUN)) {
            v3 = a;
            v3.writeShort(a.getBuffedValue(MapleBuffStat.STUN));
            v3.writeInt(a.getTrueBuffSource(MapleBuffStat.STUN));
        }
        if (a.containsKey(MapleBuffStat.BUFF_156)) {
            v4 = a;
            v4.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_156));
            v4.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_156));
        }
        if (a.containsKey(MapleBuffStat.DARKNESS)) {
            v5 = a;
            v5.writeShort(a.getBuffedValue(MapleBuffStat.DARKNESS));
            v5.writeInt(a.getTrueBuffSource(MapleBuffStat.DARKNESS));
        }
        if (a.containsKey(MapleBuffStat.SEAL)) {
            v6 = a;
            v6.writeShort(a.getBuffedValue(MapleBuffStat.SEAL));
            v6.writeInt(a.getTrueBuffSource(MapleBuffStat.SEAL));
        }
        if (a.containsKey(MapleBuffStat.WEAKEN)) {
            v7 = a;
            v7.writeShort(a.getBuffedValue(MapleBuffStat.WEAKEN));
            v7.writeInt(a.getTrueBuffSource(MapleBuffStat.WEAKEN));
        }
        if (a.containsKey(MapleBuffStat.INVINCIBILITY)) {
            v8 = a;
            v8.writeShort(a.getBuffedValue(MapleBuffStat.INVINCIBILITY));
            v8.writeInt(a.getTrueBuffSource(MapleBuffStat.INVINCIBILITY));
        }
        if (a.containsKey(MapleBuffStat.CURSE)) {
            v9 = a;
            v9.writeShort(a.getBuffedValue(MapleBuffStat.CURSE));
            v9.writeInt(a.getTrueBuffSource(MapleBuffStat.CURSE));
        }
        if (a.containsKey(MapleBuffStat.SLOW)) {
            v10 = a;
            v10.writeShort(a.getBuffedValue(MapleBuffStat.SLOW));
            v10.writeInt(a.getTrueBuffSource(MapleBuffStat.SLOW));
        }
        if (a.containsKey(MapleBuffStat.PVP_ATTACK)) {
            v11 = a;
            v11.writeShort(a.getBuffedValue(MapleBuffStat.PVP_ATTACK));
            v11.writeInt(a.getTrueBuffSource(MapleBuffStat.PVP_ATTACK));
        }
        if (a.containsKey(MapleBuffStat.FROZEN)) {
            v12 = a;
            v12.writeShort(a.getBuffedValue(MapleBuffStat.FROZEN));
            v12.writeInt(a.getTrueBuffSource(MapleBuffStat.FROZEN));
        }
        if (GameSetConstants.MAPLE_VERSION == 145 && a.containsKey(MapleBuffStat.BLESS)) {
            v13 = a;
            v13.writeShort(a.getBuffedValue(MapleBuffStat.BLESS));
            v13.writeInt(a.getTrueBuffSource(MapleBuffStat.BLESS));
        }
        if (a.containsKey(MapleBuffStat.THREATEN_PVP)) {
            v14 = a;
            v14.writeShort(a.getBuffedValue(MapleBuffStat.THREATEN_PVP));
            v14.writeInt(a.getTrueBuffSource(MapleBuffStat.THREATEN_PVP));
        }
        if (a.containsKey(MapleBuffStat.BUFF_127)) {
            v15 = a;
            v15.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_127));
            v15.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_127));
        }
        if (a.containsKey(MapleBuffStat.BUFF_128)) {
            v16 = a;
            v16.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_128));
            v16.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_128));
        }
        if (a.containsKey(MapleBuffStat.POISON)) {
            a.writeShort(a.getBuffedValue(MapleBuffStat.POISON));
        }
        if (a.containsKey(MapleBuffStat.POISON)) {
            v17 = a;
            v17.writeShort(a.getBuffedValue(MapleBuffStat.POISON));
            v17.writeInt(a.getTrueBuffSource(MapleBuffStat.POISON));
        }
        if (a.containsKey(MapleBuffStat.SHADOWPARTNER)) {
            v18 = a;
            v18.writeShort(a.getBuffedValue(MapleBuffStat.SHADOWPARTNER));
            v18.writeInt(a.getTrueBuffSource(MapleBuffStat.SHADOWPARTNER));
        }
        if (a.containsKey(MapleBuffStat.MORPH)) {
            v19 = a;
            v19.writeShort(a.getBuffedValue(MapleBuffStat.MORPH));
            v19.writeInt(a.getTrueBuffSource(MapleBuffStat.MORPH));
        }
        if (a.containsKey(MapleBuffStat.DARK_METAMORPHOSIS)) {
            v20 = a;
            v20.writeShort(a.getBuffedValue(MapleBuffStat.DARK_METAMORPHOSIS));
            v20.writeInt(a.getTrueBuffSource(MapleBuffStat.DARK_METAMORPHOSIS));
        }
        if (a.containsKey(MapleBuffStat.OWL_SPIRIT)) {
            v21 = a;
            v21.writeShort(a.getBuffedValue(MapleBuffStat.OWL_SPIRIT));
            v21.writeInt(a.getTrueBuffSource(MapleBuffStat.OWL_SPIRIT));
        }
        if (a.containsKey(MapleBuffStat.GHOST_MORPH)) {
            a.writeShort(a.getBuffedValue(MapleBuffStat.GHOST_MORPH));
        }
        if (a.containsKey(MapleBuffStat.SEDUCE)) {
            v22 = a;
            v22.writeShort(a.getBuffedValue(MapleBuffStat.SEDUCE));
            v22.writeInt(a.getTrueBuffSource(MapleBuffStat.SEDUCE));
        }
        if (a.containsKey(MapleBuffStat.SPIRIT_CLAW)) {
            a.writeInt(a.get(MapleBuffStat.SPIRIT_CLAW));
        }
        if (a.containsKey(MapleBuffStat.ZOMBIFY)) {
            v23 = a;
            v23.writeShort(a.getBuffedValue(MapleBuffStat.ZOMBIFY));
            v23.writeInt(a.getTrueBuffSource(MapleBuffStat.ZOMBIFY));
        }
        if (a.containsKey(MapleBuffStat.SPIRIT_LINK)) {
            a.writeShort(a.get(MapleBuffStat.SPIRIT_LINK));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.SPIRIT_LINK));
        }
        if (a.containsKey(MapleBuffStat.ARIANT_COSS_IMU)) {
            v24 = a;
            v24.writeShort(a.getBuffedValue(MapleBuffStat.ARIANT_COSS_IMU));
            v24.writeInt(a.getTrueBuffSource(MapleBuffStat.ARIANT_COSS_IMU));
        }
        if (a.containsKey(MapleBuffStat.DIVINE_BODY)) {
            v25 = a;
            v25.writeShort(a.getBuffedValue(MapleBuffStat.DIVINE_BODY));
            v25.writeInt(a.getTrueBuffSource(MapleBuffStat.DIVINE_BODY));
        }
        if (a.containsKey(MapleBuffStat.REVERSE_DIRECTION)) {
            v26 = a;
            v26.writeShort(a.getBuffedValue(MapleBuffStat.REVERSE_DIRECTION));
            v26.writeInt(a.getTrueBuffSource(MapleBuffStat.REVERSE_DIRECTION));
        }
        if (a.containsKey(MapleBuffStat.MESO_RATE)) {
            a.writeInt(a.get(MapleBuffStat.MESO_RATE));
        }
        if (a.containsKey(MapleBuffStat.EXPRATE)) {
            a.writeInt(a.get(MapleBuffStat.EXPRATE));
            v27 = a;
        } else {
            if (a.containsKey(MapleBuffStat.EXPRATE_ADD)) {
                a.writeInt(a.get(MapleBuffStat.EXPRATE_ADD));
            }
            v27 = a;
        }
        if (v27.containsKey(MapleBuffStat.ACASH_RATE)) {
            a.writeInt(a.get(MapleBuffStat.ACASH_RATE));
        }
        if (a.containsKey(MapleBuffStat.GM_HIDE)) {
            a.writeInt(a.get(MapleBuffStat.GM_HIDE));
        }
        if (a.containsKey(MapleBuffStat.BERSERK_FURY)) {
            v28 = a;
            v28.writeShort(a.getBuffedValue(MapleBuffStat.BERSERK_FURY));
            v28.writeInt(a.getTrueBuffSource(MapleBuffStat.BERSERK_FURY));
        }
        if (a.containsKey(MapleBuffStat.ILLUSION)) {
            // empty if block
        }
        if (GameSetConstants.MAPLE_VERSION >= 139 && a.containsKey(MapleBuffStat.WIND_WALK)) {
            v29 = a;
            v29.writeShort(a.getBuffedValue(MapleBuffStat.WIND_WALK));
            v29.writeInt(a.getTrueBuffSource(MapleBuffStat.WIND_WALK));
        }
        if (a.containsKey(MapleBuffStat.PYRAMID_PQ)) {
            v30 = a;
            v30.writeShort(a.getBuffedValue(MapleBuffStat.PYRAMID_PQ));
            v30.writeInt(a.getTrueBuffSource(MapleBuffStat.PYRAMID_PQ));
        }
        if (a.containsKey(MapleBuffStat.POTION)) {
            v31 = a;
            v31.writeShort(a.getBuffedValue(MapleBuffStat.POTION));
            v31.writeInt(a.getTrueBuffSource(MapleBuffStat.POTION));
        }
        if (a.containsKey(MapleBuffStat.SHADOW)) {
            v32 = a;
            v32.writeShort(a.getBuffedValue(MapleBuffStat.SHADOW));
            v32.writeInt(a.getTrueBuffSource(MapleBuffStat.SHADOW));
        }
        if (a.containsKey(MapleBuffStat.BUFF_75)) {
            v33 = a;
            v33.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_75));
            v33.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_75));
        }
        if (a.containsKey(MapleBuffStat.MAGIC_SHIELD)) {
            a.writeInt(a.get(MapleBuffStat.MAGIC_SHIELD));
        }
        if (a.containsKey(MapleBuffStat.SOARING)) {
            // empty if block
        }
        if (a.containsKey(MapleBuffStat.BUFF_81)) {
            v34 = a;
            v34.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_81));
            v34.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_81));
        }
        if (a.containsKey(MapleBuffStat.HIDDEN_POTENTIAL)) {
            v35 = a;
            v35.writeShort(a.getBuffedValue(MapleBuffStat.HIDDEN_POTENTIAL));
            v35.writeInt(a.getTrueBuffSource(MapleBuffStat.HIDDEN_POTENTIAL));
        }
        if (a.containsKey(MapleBuffStat.BUFF_84)) {
            v36 = a;
            v36.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_84));
            v36.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_84));
        }
        if (a.containsKey(MapleBuffStat.FINAL_CUT)) {
            v37 = a;
            v37.writeShort(a.getBuffedValue(MapleBuffStat.FINAL_CUT));
            v37.writeInt(a.getTrueBuffSource(MapleBuffStat.FINAL_CUT));
        }
        if (a.containsKey(MapleBuffStat.REAPER)) {
            // empty if block
        }
        if (a.containsKey(MapleBuffStat.DAMAGE_BUFF)) {
            // empty if block
        }
        if (a.containsKey(MapleBuffStat.MECH_CHANGE)) {
            v38 = a;
            v38.writeShort(a.getBuffedValue(MapleBuffStat.MECH_CHANGE));
            v38.writeInt(a.getTrueBuffSource(MapleBuffStat.MECH_CHANGE));
        }
        if (a.containsKey(MapleBuffStat.DARK_AURA)) {
            var3_4 = a.getTrueBuffSource(MapleBuffStat.DARK_AURA);
            if (GameSetConstants.MAPLE_VERSION < 143 && var3_4 == 32111005) {
                var3_4 = 32120000;
            }
            a.writeShort(a.get(MapleBuffStat.DARK_AURA));
            a.writeInt(var3_4);
        }
        if (a.containsKey(MapleBuffStat.BLUE_AURA)) {
            var3_5 = a.getTrueBuffSource(MapleBuffStat.BLUE_AURA);
            if (GameSetConstants.MAPLE_VERSION < 143 && var3_5 == 32111005) {
                var3_5 = 32110000;
            }
            a.writeShort(a.get(MapleBuffStat.BLUE_AURA));
            a.writeInt(var3_5);
        }
        if (a.containsKey(MapleBuffStat.YELLOW_AURA)) {
            var3_6 = a.getTrueBuffSource(MapleBuffStat.YELLOW_AURA);
            if (GameSetConstants.MAPLE_VERSION < 143 && var3_6 == 32111005) {
                var3_6 = 32120001;
            }
            a.writeShort(a.get(MapleBuffStat.YELLOW_AURA));
            a.writeInt(var3_6);
        }
        if (a.containsKey(MapleBuffStat.GIANT_POTION)) {
            a.writeShort(a.get(MapleBuffStat.GIANT_POTION));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.GIANT_POTION));
        }
        if (a.containsKey(MapleBuffStat.DICE_ROLL)) {
            // empty if block
        }
        if (a.containsKey(MapleBuffStat.BUFF_121)) {
            v39 = a;
            v39.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_121));
            v39.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_121));
        }
        if (a.containsKey(MapleBuffStat.ICE_KNIGHT)) {
            v40 = a;
            v40.writeShort(a.getBuffedValue(MapleBuffStat.ICE_KNIGHT));
            v40.writeInt(a.getTrueBuffSource(MapleBuffStat.ICE_KNIGHT));
        }
        if (a.containsKey(MapleBuffStat.BUFF_137)) {
            v41 = a;
            v41.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_137));
            v41.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_137));
        }
        if (a.containsKey(MapleBuffStat.SNATCH)) {
            v42 = a;
            v42.writeShort(a.getBuffedValue(MapleBuffStat.SNATCH));
            v42.writeInt(a.getTrueBuffSource(MapleBuffStat.SNATCH));
        }
        if (a.containsKey(MapleBuffStat.BUFF_160)) {
            // empty if block
        }
        if (a.containsKey(MapleBuffStat.ARCANE_AIM)) {
            // empty if block
        }
        if (a.containsKey(MapleBuffStat.BUFF_172)) {
            v43 = a;
            v43.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_172));
            v43.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_172));
        }
        if (a.containsKey(MapleBuffStat.BUFF_184)) {
            v44 = a;
            v44.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_184));
            v44.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_184));
        }
        if (a.containsKey(MapleBuffStat.BUFF_191)) {
            v45 = a;
            v45.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_191));
            v45.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_191));
        }
        if (a.containsKey(MapleBuffStat.BUFF_193)) {
            v46 = a;
            v46.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_193));
            v46.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_193));
        }
        if (a.containsKey(MapleBuffStat.BUFF_194)) {
            v47 = a;
            v47.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_194));
            v47.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_194));
        }
        if (a.containsKey(MapleBuffStat.BUFF_207)) {
            a.writeInt(a.getBuffedValue(MapleBuffStat.BUFF_207));
        }
        if (a.containsKey(MapleBuffStat.BUFF_209)) {
            a.write(a.getBuffedValue(MapleBuffStat.BUFF_209));
        }
        if (a.containsKey(MapleBuffStat.BUFF_217)) {
            v48 = a;
            v48.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_217));
            v48.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_217));
        }
        if (a.containsKey(MapleBuffStat.BUFF_224)) {
            v49 = a;
            v49.writeShort(a.getBuffedValue(MapleBuffStat.BUFF_224));
            v49.writeInt(a.getTrueBuffSource(MapleBuffStat.BUFF_224));
        }
        if (a.containsKey(MapleBuffStat.JUDGMENT_DRAW)) {
            a.writeShort(a.get(MapleBuffStat.JUDGMENT_DRAW));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.JUDGMENT_DRAW));
        }
        if (a.containsKey(MapleBuffStat.DARK_CRESCENDO)) {
            a.writeShort(a.get(MapleBuffStat.DARK_CRESCENDO));
        }
        if (a.containsKey(MapleBuffStat.BLACK_BLESSING)) {
            a.writeInt(a.get(MapleBuffStat.BLACK_BLESSING));
        }
        if (a.containsKey(MapleBuffStat.PRESSURE_VOID)) {
            a.writeShort(a.get(MapleBuffStat.PRESSURE_VOID));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.PRESSURE_VOID));
        }
        if (a.containsKey(MapleBuffStat.LUMINOUS_GAUGE)) {
            a.writeShort(a.get(MapleBuffStat.LUMINOUS_GAUGE));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.LUMINOUS_GAUGE));
        }
        if (a.containsKey(MapleBuffStat.KAISER_MODE_CHANGE)) {
            a.writeShort(a.get(MapleBuffStat.KAISER_MODE_CHANGE));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.KAISER_MODE_CHANGE));
        }
        if (a.containsKey(MapleBuffStat.TEMPEST_BLADES)) {
            a.writeShort(a.get(MapleBuffStat.TEMPEST_BLADES));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.TEMPEST_BLADES));
        }
        if (a.containsKey(MapleBuffStat.DAMAGE_ABSORBED)) {
            a.writeShort(a.get(MapleBuffStat.DAMAGE_ABSORBED));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.DAMAGE_ABSORBED));
        }
        if (a.containsKey(MapleBuffStat.SOUL_EXALT)) {
            a.writeShort(a.get(MapleBuffStat.SOUL_EXALT));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.SOUL_EXALT));
        }
        if (GameSetConstants.MAPLE_VERSION >= 152 && a.containsKey(MapleBuffStat.WEIRD_FLAME)) {
            a.writeShort(a.get(MapleBuffStat.WEIRD_FLAME));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.WEIRD_FLAME));
        }
        if (a.containsKey(MapleBuffStat.KAISER_COMBO)) {
            a.writeShort(a.get(MapleBuffStat.KAISER_COMBO));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.KAISER_COMBO));
        }
        if (a.containsKey(MapleBuffStat.COMBO_UNLIMITED)) {
            a.writeShort(a.get(MapleBuffStat.COMBO_UNLIMITED));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.COMBO_UNLIMITED));
        }
        if (a.containsKey(MapleBuffStat.IGNORE_ALL_COUNTER)) {
            a.writeShort(a.get(MapleBuffStat.IGNORE_ALL_COUNTER));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.IGNORE_ALL_COUNTER));
        }
        if (a.containsKey(MapleBuffStat.IGNORE_ALL_IMMUNE)) {
            a.writeShort(a.get(MapleBuffStat.IGNORE_ALL_IMMUNE));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.IGNORE_ALL_IMMUNE));
        }
        if (a.containsKey(MapleBuffStat.MAGNET_AREA)) {
            a.writeShort(a.get(MapleBuffStat.MAGNET_AREA));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.MAGNET_AREA));
        }
        if (a.containsKey(MapleBuffStat.RETURN_TELEPORT)) {
            v50 = a;
            v50.write(1);
            v50.writeInt(a.getTrueBuffSource(MapleBuffStat.RETURN_TELEPORT));
        }
        if (a.containsKey(MapleBuffStat.KILLING_POINT)) {
            a.write(a.getKillCount());
        }
        if (a.containsKey(MapleBuffStat.IGNORE_DEF)) {
            a.writeShort(a.get(MapleBuffStat.IGNORE_DEF));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.IGNORE_DEF));
        }
        if (a.containsKey(MapleBuffStat.SHROUD_WALK)) {
            a.writeShort(a.get(MapleBuffStat.SHROUD_WALK));
            a.writeInt(a.getTrueBuffSource(MapleBuffStat.SHROUD_WALK));
        }
        v51 = a;
        v51.write(0);
        v51.write(0);
        a.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            var3_3 = new ArrayList<E>();
            var4_8 = 1;
            var5_9 = a.getStatForBuff(MapleBuffStat.TEMPEST_BLADES);
            if (var5_9 == null) {
                v52 = a;
                v53 = a;
                v53.writeInt(0);
                v53.writeInt(0);
                v52.writeInt(0);
                v52.writeInt(0);
            } else {
                switch (var5_9.getSourceId()) {
                    case 61101002: {
                        var4_8 = 1;
                        v54 = var5_9;
                        break;
                    }
                    case 61120007: {
                        var4_8 = 2;
                        v54 = var5_9;
                        break;
                    }
                    case 61111008: {
                        var4_8 = 3;
                        v54 = var5_9;
                        break;
                    }
                    case 61120008: 
                    case 61121217: {
                        var4_8 = 4;
                    }
                    default: {
                        v54 = var5_9;
                    }
                }
                var6_10 = v54.getSourceId() == 61101002 ? 3 : 5;
                var7_12 = 0;
                if (a.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11) != null) {
                    var7_12 = a.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11).getItemId();
                }
                v55 = var8_13 = 0;
                while (v55 < var6_10) {
                    var3_3.add(0);
                    v55 = ++var8_13;
                }
                v56 = a;
                a.writeInt(var4_8);
                v56.writeInt(var6_10);
                v56.writeInt(var7_12);
                a.writeInt(var3_3.size());
                v57 = var8_13 = 0;
                while (v57 < var3_3.size()) {
                    v58 = var3_3.get(var8_13);
                    a.writeInt((Integer)v58);
                    v57 = ++var8_13;
                }
            }
        }
        var3_7 = Randomizer.nextInt();
        if (a.containsKey(MapleBuffStat.ENERGY_CHARGE)) {
            v59 = a;
            v60 = a;
            a.writeInt(0);
            v60.writeInt(0);
            v60.write(0);
            v59.writeInt(var3_7);
            v59.writeShort(0);
        }
        if (a.containsKey(MapleBuffStat.DASH_SPEED)) {
            v61 = a;
            v62 = a;
            a.writeInt(0);
            v62.writeInt(0);
            v62.write(0);
            v61.writeInt(var3_7);
            v61.writeShort(0);
        }
        if (a.containsKey(MapleBuffStat.DASH_JUMP)) {
            v63 = a;
            v64 = a;
            a.writeInt(0);
            v64.writeInt(0);
            v64.write(0);
            v63.writeInt(var3_7);
            v63.writeShort(0);
        }
        if (!a.containsKey(MapleBuffStat.MONSTER_RIDING)) ** GOTO lbl434
        var4_8 = a.getBuffSource(MapleBuffStat.MONSTER_RIDING);
        if (var4_8 > 0) {
            v65 = a;
            var5_9 = v65.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-118);
            var6_11 = v65.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-18);
            if (GameConstants.getMountItem(var4_8, a) == 0 && var5_9 != null && a.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-119) != null) {
                v66 = a;
                v67 = v66;
                v66.writeInt(var5_9.getItemId());
            } else if (GameConstants.getMountItem(var4_8, a) == 0 && var6_11 != null && a.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-19) != null) {
                v68 = a;
                v67 = v68;
                v68.writeInt(var6_11.getItemId());
            } else {
                v69 = a;
                v67 = v69;
                v69.writeInt(GameConstants.getMountItem(var4_8, a));
            }
            v67.writeInt(var4_8);
            v70 = a;
        } else {
            v71 = a;
            if (a.getFlyChairId() > 0) {
                v71.writeInt(a.getFlyChairId());
                v72 = a;
                v70 = v72;
                v72.writeInt(0);
            } else {
                v71.writeInt(0);
                a.writeInt(0);
lbl434:
                // 2 sources

                v70 = a;
            }
        }
        v70.write(0);
        a.writeInt(var3_7);
        if (a.containsKey(MapleBuffStat.SPEED_INFUSION)) {
            v73 = a;
            v74 = a;
            v75 = a;
            a.writeInt(0);
            v75.writeInt(0);
            v75.write(0);
            v74.writeInt(var3_7);
            v74.write(0);
            v73.writeInt(var3_7);
            v73.writeShort(0);
        }
        if (a.containsKey(MapleBuffStat.HOMING_BEACON)) {
            v76 = a;
            v77 = a;
            v78 = a;
            v78.writeInt(0);
            v78.writeInt(0);
            v77.write(0);
            v77.writeInt(var3_7);
            v76.writeInt(0);
            v76.writeInt(0);
        }
        if (a.containsKey(MapleBuffStat.DEFAULT_BUFFSTAT)) {
            v79 = a;
            v80 = a;
            a.writeInt(0);
            v80.write(0);
            v80.writeInt(var3_7);
            v79.writeInt(0);
            v79.writeShort(0);
        }
        if (a.containsKey(MapleBuffStat.DEFAULT_BUFFSTAT2) == false) return;
        v81 = a;
        v82 = a;
        v82.writeInt(0);
        v82.writeInt(0);
        v81.write(0);
        v81.writeInt(var3_7);
    }

    public static final /* synthetic */ void addAnnounceBox(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        if (a3.getPlayerShop() != null && a3.getPlayerShop().isOwner(a3) && a3.getPlayerShop().getShopType() != 1 && a3.getPlayerShop().isAvailable()) {
            PacketHelper.addInteraction(a2, a3.getPlayerShop());
            return;
        }
        a2.write(0);
    }

    public static /* synthetic */ void addMiniGameInfo(MaplePacketLittleEndianWriter a2, MapleCharacter a32) {
        int n2;
        int a32 = 0;
        a2.writeShort(a32);
        int n3 = n2 = 0;
        while (n3 < a32) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter2.writeInt(0);
            maplePacketLittleEndianWriter2.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.write(0);
            n3 = ++n2;
        }
    }

    public static /* synthetic */ <E extends Buffstat> void writeMask(MaplePacketLittleEndianWriter a2, Collection<E> a3, int a42) {
        int[] a42 = new int[a42];
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            Buffstat buffstat = (Buffstat)a3.next();
            object = a3;
            int n2 = buffstat.getPosition();
            a42[n2] = (int)((long)a42[n2] | buffstat.getValue());
        }
        int n3 = a3 = 0;
        while (n3 < a42.length) {
            a2.writeInt(a42[a3++]);
            n3 = a3;
        }
    }

    public static /* synthetic */ void addPartTimeJob(MaplePacketLittleEndianWriter a2, MaplePartTimeJob a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePartTimeJob maplePartTimeJob = a3;
        a2.write(maplePartTimeJob.getJob());
        if (maplePartTimeJob.getJob() > 0 && a3.getJob() <= 5) {
            FileTime fileTime = new FileTime(FileTime.getTime(1587544000L));
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.writeReversedLong(a3.getTime());
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeReversedLong(0L);
        }
        maplePacketLittleEndianWriter.writeInt(a3.getReward());
        a2.write(a3.getReward() > 0);
    }

    public static /* synthetic */ void writeBuffState(MaplePacketLittleEndianWriter a2, MapleBuffStat a3) {
        int[] arrn;
        int[] arrn2 = arrn = new int[GameSetConstants.MAX_BUFFSTAT];
        int n2 = a3.getPosition();
        arrn[n2] = (int)((long)arrn[n2] | a3.getValue());
        int n3 = a3 = 0;
        while (n3 < arrn2.length) {
            a2.writeInt(arrn2[a3++]);
            n3 = a3;
        }
    }
}

