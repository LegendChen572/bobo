/*
 * Decompiled with CFR 0.150.
 */
package client.status;

import constants.GameSetConstants;
import handling.opcodes.MapleBuffStat;
import tools.MaplePacketOperation;
import tools.packet.BeansPacket;

public final class MonsterStatus
extends Enum<MonsterStatus> {
    private final /* synthetic */ int K;
    public static final /* synthetic */ /* enum */ MonsterStatus MAGIC_IMMUNITY;
    public static final /* synthetic */ /* enum */ MonsterStatus NEUTRALISE;
    public static final /* synthetic */ /* enum */ MonsterStatus DOOM;
    public static final /* synthetic */ /* enum */ MonsterStatus MONSTER_BOMB;
    public static final /* synthetic */ /* enum */ MonsterStatus MAGIC_CRASH;
    private final /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ MonsterStatus MDEF;
    public static final /* synthetic */ /* enum */ MonsterStatus AVOID;
    public static final /* synthetic */ /* enum */ MonsterStatus MBS_32;
    public static final /* synthetic */ /* enum */ MonsterStatus WEAPON_IMMUNITY;
    public static final /* synthetic */ /* enum */ MonsterStatus EXCHANGE_ATTACK;
    public static final /* synthetic */ /* enum */ MonsterStatus MBUFF_44;
    public static final /* synthetic */ /* enum */ MonsterStatus HYPNOTIZE;
    public static final /* synthetic */ /* enum */ MonsterStatus NINJA_AMBUSH;
    public static final /* synthetic */ /* enum */ MonsterStatus SEAL_SKILL;
    public static final /* synthetic */ /* enum */ MonsterStatus FREEZE;
    public static final /* synthetic */ /* enum */ MonsterStatus WDEF;
    public static final /* synthetic */ /* enum */ MonsterStatus MBUFF_48;
    public static final /* synthetic */ /* enum */ MonsterStatus MAGIC_DAMAGE_REFLECT;
    public static final /* synthetic */ /* enum */ MonsterStatus DAMAGE_IMMUNITY;
    public static final /* synthetic */ /* enum */ MonsterStatus VENOMOUS_WEAPON;
    public static final /* synthetic */ /* enum */ MonsterStatus WEAPON_DEFENSE_UP;
    public static final /* synthetic */ /* enum */ MonsterStatus INVINCIBLE;
    private static final /* synthetic */ MonsterStatus[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MonsterStatus MAGIC_DEFENSE_UP;
    public static final /* synthetic */ /* enum */ MonsterStatus SPEED;
    public static final /* synthetic */ /* enum */ MonsterStatus DANAGED_ELEM_ATTR;
    public static final /* synthetic */ /* enum */ MonsterStatus MBUFF_45;
    public static final /* synthetic */ /* enum */ MonsterStatus MBUFF_40;
    public static final /* synthetic */ /* enum */ MonsterStatus WATK;
    public static final /* synthetic */ /* enum */ MonsterStatus POISON;
    public static final /* synthetic */ /* enum */ MonsterStatus MATK;
    public static final /* synthetic */ /* enum */ MonsterStatus SHADOW_WEB;
    public static final /* synthetic */ /* enum */ MonsterStatus SHOWDOWN;
    public static final /* synthetic */ /* enum */ MonsterStatus MAGIC_ATTACK_UP;
    public static final /* synthetic */ /* enum */ MonsterStatus WEAPON_DAMAGE_REFLECT;
    public static final /* synthetic */ /* enum */ MonsterStatus MBUFF_42;
    public static final /* synthetic */ /* enum */ MonsterStatus DARKNESS;
    public static final /* synthetic */ /* enum */ MonsterStatus SUDDEN_RAID;
    public static final /* synthetic */ /* enum */ MonsterStatus MBUFF_39;
    private final /* synthetic */ int a;
    public static final /* synthetic */ /* enum */ MonsterStatus WEAPON_ATTACK_UP;
    public static final /* synthetic */ /* enum */ MonsterStatus MBUFF_41;
    public static final /* synthetic */ /* enum */ MonsterStatus BLIND;
    public static final /* synthetic */ /* enum */ MonsterStatus ACC;
    public static final /* synthetic */ /* enum */ MonsterStatus SEAL;
    public static final /* synthetic */ /* enum */ MonsterStatus FATALITY;
    public static final /* synthetic */ /* enum */ MonsterStatus STUN;
    public static final /* synthetic */ /* enum */ MonsterStatus EXPLOSION;
    public static final /* synthetic */ /* enum */ MonsterStatus IMPRINT;
    public static final /* synthetic */ /* enum */ MonsterStatus MBUFF_43;
    public static final /* synthetic */ /* enum */ MonsterStatus EMPTY;
    public static final /* synthetic */ /* enum */ MonsterStatus SUMMON;

    public /* synthetic */ int getValue() {
        MonsterStatus a2;
        return a2.K;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ MapleBuffStat getLinkedDisease(MonsterStatus a2) {
        switch (1.ALLATORIxDEMO[a2.ordinal()]) {
            case 2: 
            case 3: {
                return MapleBuffStat.STUN;
            }
            case 4: 
            case 5: {
                return MapleBuffStat.POISON;
            }
            case 6: 
            case 7: {
                return MapleBuffStat.SEAL;
            }
            case 8: {
                return MapleBuffStat.FREEZE;
            }
            case 9: {
                return MapleBuffStat.DARKNESS;
            }
            case 10: {
                return MapleBuffStat.SLOW;
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isDefaultStatus(MonsterStatus a2) {
        switch (a2) {
            case EMPTY: {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ int getPosition() {
        MonsterStatus a2;
        return a2.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ MonsterStatus getBySkill_Pokemon(int a2) {
        switch (a2) {
            case 120: {
                return SEAL;
            }
            case 121: {
                return DARKNESS;
            }
            case 123: {
                return STUN;
            }
            case 125: {
                return POISON;
            }
            case 126: {
                return SPEED;
            }
            case 137: {
                return FREEZE;
            }
        }
        return null;
    }

    public static /* synthetic */ MonsterStatus[] values() {
        return (MonsterStatus[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        WATK = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u0015d\u0016n"), 0, 0);
        WDEF = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("w\u0001e\u0003"), 1, 1);
        MATK = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u000fd\u0016n"), 2, 2);
        MDEF = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("m\u0001e\u0003"), 3, 3);
        ACC = new MonsterStatus(BeansPacket.ALLATORIxDEMO("d\u0001f"), 4, 4);
        AVOID = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0004v\ni\u0001"), 5, 5);
        SPEED = new MonsterStatus(BeansPacket.ALLATORIxDEMO("v\u0012`\u0007a"), 6, 6);
        STUN = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("s\u0011u\u000b"), 7, 7);
        FREEZE = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u0004w\u0007`\u0018`"), 8, 8);
        POISON = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("p\ni\u0016o\u000b"), 9, 9);
        SEAL = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u0011`\u0003i"), 10, 10);
        DARKNESS = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("d\u0004r\u000en\u0000s\u0016"), 11, 11);
        WEAPON_ATTACK_UP = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u0015`\u0003u\rk\u001dd\u0016q\u0003f\tz\u0017u"), 12, 12);
        WEAPON_DEFENSE_UP = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0012e\u0004p\nn\u001ad\u0000f\u0000n\u0016e\u001au\u0015"), 13, 13);
        MAGIC_ATTACK_UP = new MonsterStatus(BeansPacket.ALLATORIxDEMO("h\u0003b\u000bf\u001dd\u0016q\u0003f\tz\u0017u"), 14, 14);
        MAGIC_DEFENSE_UP = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("m\u0004g\fc\u001ad\u0000f\u0000n\u0016e\u001au\u0015"), 15, 15);
        DOOM = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u0006j\rh"), 16, 16);
        SHADOW_WEB = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("s\ra\u0001o\u0012\u007f\u0012e\u0007"), 17, 17);
        WEAPON_IMMUNITY = new MonsterStatus(BeansPacket.ALLATORIxDEMO("r\u0007d\u0012j\fz\u000bh\u000fp\fl\u0016|"), 18, 18);
        MAGIC_IMMUNITY = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("m\u0004g\fc\u001ai\bm\u0010n\ft\u001c"), 19, 19);
        SHOWDOWN = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u0011m\rr\u0006j\u0015k"), 20, 20);
        DAMAGE_IMMUNITY = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0001a\ba\u0002e\u001ai\bm\u0010n\ft\u001c"), 21, 21);
        NINJA_AMBUSH = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\fl\fo\u0003z\u0003h\u0000p\u0011m"), 22, 22);
        DANAGED_ELEM_ATTR = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0001a\u000ba\u0002e\u0001\u007f\u0000l\u0000m\u001aa\u0011t\u0017"), 23, 23);
        VENOMOUS_WEAPON = new MonsterStatus(BeansPacket.ALLATORIxDEMO("s\u0007k\rh\rp\u0011z\u0015`\u0003u\rk"), 24, 24);
        BLIND = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0007l\fn\u0001"), 25, 25);
        SEAL_SKILL = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u0011`\u0003i\u001dv\tl\u000ei"), 26, 26);
        EMPTY = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0000m\u0015t\u001c"), 27, 27);
        HYPNOTIZE = new MonsterStatus(BeansPacket.ALLATORIxDEMO("m\u001bu\fj\u0016l\u0018`"), 28, 28);
        WEAPON_DAMAGE_REFLECT = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0012e\u0004p\nn\u001ad\u0004m\u0004g\u0000\u007f\u0017e\u0003l\u0000c\u0011"), 29, 29);
        MAGIC_DAMAGE_REFLECT = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u000fd\u0005l\u0001z\u0006d\u000fd\u0005`\u001dw\u0007c\u000e`\u0001q"), 30, 30);
        SUMMON = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("s\u0010m\bo\u000b"), 31, 31);
        MBS_32 = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u000fg\u0011zq\u0017"), 32, 32);
        NEUTRALISE = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("n\u0000u\u0011r\u0004l\fs\u0000"), 33, 33);
        IMPRINT = new MonsterStatus(BeansPacket.ALLATORIxDEMO("l\u000fu\u0010l\fq"), 34, 34);
        MONSTER_BOMB = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("m\nn\u0016t\u0000r\u001ab\nm\u0007"), 35, 35);
        MAGIC_CRASH = new MonsterStatus(BeansPacket.ALLATORIxDEMO("h\u0003b\u000bf\u001df\u0010d\u0011m"), 36, 36);
        EXCHANGE_ATTACK = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0000x\u0006h\u0004n\u0002e\u001aa\u0011t\u0004c\u000e"), 37, 37);
        INVINCIBLE = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u000bk\u0014l\ff\u000bg\u000e`"), 38, 38);
        MBUFF_39 = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("m\u0007u\u0003f\u001a\u0013|"), 39, 39);
        MBUFF_40 = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u000fg\u0017c\u0004zv\u0015"), 40, 40);
        MBUFF_41 = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("m\u0007u\u0003f\u001a\u0014t"), 41, 41);
        MBUFF_42 = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u000fg\u0017c\u0004zv\u0017"), 42, 42);
        MBUFF_43 = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("m\u0007u\u0003f\u001a\u0014v"), 43, 43);
        MBUFF_44 = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u000fg\u0017c\u0004zv\u0011"), 44, 44);
        MBUFF_45 = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("m\u0007u\u0003f\u001a\u0014p"), 45, 45);
        FATALITY = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u0004d\u0016d\u000el\u0016|"), 46, 46);
        EXPLOSION = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0000x\u0015l\ns\fo\u000b"), 47, 47);
        MBUFF_48 = new MonsterStatus(BeansPacket.ALLATORIxDEMO("\u000fg\u0017c\u0004zv\u001d"), 48, 48);
        SUDDEN_RAID = new MonsterStatus(MaplePacketOperation.ALLATORIxDEMO("\u0016u\u0001d\u0000n\u001ar\u0004i\u0001"), 49, 42);
        MonsterStatus[] arrmonsterStatus = new MonsterStatus[50];
        arrmonsterStatus[0] = WATK;
        arrmonsterStatus[1] = WDEF;
        arrmonsterStatus[2] = MATK;
        arrmonsterStatus[3] = MDEF;
        arrmonsterStatus[4] = ACC;
        arrmonsterStatus[5] = AVOID;
        arrmonsterStatus[6] = SPEED;
        arrmonsterStatus[7] = STUN;
        arrmonsterStatus[8] = FREEZE;
        arrmonsterStatus[9] = POISON;
        arrmonsterStatus[10] = SEAL;
        arrmonsterStatus[11] = DARKNESS;
        arrmonsterStatus[12] = WEAPON_ATTACK_UP;
        arrmonsterStatus[13] = WEAPON_DEFENSE_UP;
        arrmonsterStatus[14] = MAGIC_ATTACK_UP;
        arrmonsterStatus[15] = MAGIC_DEFENSE_UP;
        arrmonsterStatus[16] = DOOM;
        arrmonsterStatus[17] = SHADOW_WEB;
        arrmonsterStatus[18] = WEAPON_IMMUNITY;
        arrmonsterStatus[19] = MAGIC_IMMUNITY;
        arrmonsterStatus[20] = SHOWDOWN;
        arrmonsterStatus[21] = DAMAGE_IMMUNITY;
        arrmonsterStatus[22] = NINJA_AMBUSH;
        arrmonsterStatus[23] = DANAGED_ELEM_ATTR;
        arrmonsterStatus[24] = VENOMOUS_WEAPON;
        arrmonsterStatus[25] = BLIND;
        arrmonsterStatus[26] = SEAL_SKILL;
        arrmonsterStatus[27] = EMPTY;
        arrmonsterStatus[28] = HYPNOTIZE;
        arrmonsterStatus[29] = WEAPON_DAMAGE_REFLECT;
        arrmonsterStatus[30] = MAGIC_DAMAGE_REFLECT;
        arrmonsterStatus[31] = SUMMON;
        arrmonsterStatus[32] = MBS_32;
        arrmonsterStatus[33] = NEUTRALISE;
        arrmonsterStatus[34] = IMPRINT;
        arrmonsterStatus[35] = MONSTER_BOMB;
        arrmonsterStatus[36] = MAGIC_CRASH;
        arrmonsterStatus[37] = EXCHANGE_ATTACK;
        arrmonsterStatus[38] = INVINCIBLE;
        arrmonsterStatus[39] = MBUFF_39;
        arrmonsterStatus[40] = MBUFF_40;
        arrmonsterStatus[41] = MBUFF_41;
        arrmonsterStatus[42] = MBUFF_42;
        arrmonsterStatus[43] = MBUFF_43;
        arrmonsterStatus[44] = MBUFF_44;
        arrmonsterStatus[45] = MBUFF_45;
        arrmonsterStatus[46] = FATALITY;
        arrmonsterStatus[47] = EXPLOSION;
        arrmonsterStatus[48] = MBUFF_48;
        arrmonsterStatus[49] = SUDDEN_RAID;
        ALLATORIxDEMO = arrmonsterStatus;
    }

    public static /* synthetic */ MonsterStatus valueOf(String a2) {
        return Enum.valueOf(MonsterStatus.class, a2);
    }

    public /* synthetic */ int getIDAvalue() {
        MonsterStatus a2;
        return a2.d;
    }

    /*
     * WARNING - Possible parameter corruption
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ MonsterStatus(int varnull) {
        super((String)var1_-1, (int)var2_-1);
        if (a != 11 || GameSetConstants.MAPLE_VERSION <= 113) ** GOTO lbl8
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a = 25;
            v0 = a;
        } else {
            a = 12;
lbl8:
            // 2 sources

            v0 = a;
        }
        v0.K = 1 << a % 32;
        v1 = a;
        v1.a = GameSetConstants.MAX_BUFFSTAT_MASK - 1 - (int)Math.floor(a / 32);
        v1.d = a;
    }
}

