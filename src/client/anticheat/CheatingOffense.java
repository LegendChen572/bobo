/*
 * Decompiled with CFR 0.150.
 */
package client.anticheat;

import handling.world.CharacterIdChannelPair;
import server.characterCards.MapleCharacterCards;

public final class CheatingOffense
extends Enum<CheatingOffense> {
    private final /* synthetic */ int k;
    public static final /* synthetic */ /* enum */ CheatingOffense USING_UNAVAILABLE_ITEM;
    public static final /* synthetic */ /* enum */ CheatingOffense \u5feb\u901f\u56deMP;
    public static final /* synthetic */ /* enum */ CheatingOffense \u5feb\u901f\u653b\u64ca;
    public static final /* synthetic */ /* enum */ CheatingOffense FASTATTACK;
    public static final /* synthetic */ /* enum */ CheatingOffense PET_ITEMVAC_CLIENT;
    public static final /* synthetic */ /* enum */ CheatingOffense ATTACKMOB_ENERGY_HACK;
    public static final /* synthetic */ /* enum */ CheatingOffense \u7121MP\u4f7f\u7528\u6280\u80fd;
    public static final /* synthetic */ /* enum */ CheatingOffense \u7570\u5e38\u4f7f\u7528\u4e8c\u6bb5\u8df3;
    public static final /* synthetic */ /* enum */ CheatingOffense \u63a7\u602a_\u65b0;
    public static final /* synthetic */ /* enum */ CheatingOffense \u7fa4\u9ad4\u6cbb\u7652\u653b\u64ca\u4e0d\u6b7b\u7cfb\u602a\u7269;
    public static final /* synthetic */ /* enum */ CheatingOffense \u5feb\u901f\u4f7f\u7528\u4e8c\u6bb5\u8df3;
    public static final /* synthetic */ /* enum */ CheatingOffense ATTACK_FARAWAY_MONSTER;
    public static final /* synthetic */ /* enum */ CheatingOffense HIGH_DAMAGE_2;
    private final /* synthetic */ long K;
    public static final /* synthetic */ /* enum */ CheatingOffense HIGH_DAMAGE_MAGIC;
    public static final /* synthetic */ /* enum */ CheatingOffense HIGH_DAMAGE;
    public static final /* synthetic */ /* enum */ CheatingOffense \u63a7\u602a;
    public static final /* synthetic */ /* enum */ CheatingOffense \u9ed1\u983b\u8907\u88fd;
    public static final /* synthetic */ /* enum */ CheatingOffense \u5438\u602a_\u65b0;
    public static final /* synthetic */ /* enum */ CheatingOffense MOVE_MONSTERS;
    public static final /* synthetic */ /* enum */ CheatingOffense HIGH_AVOID;
    public static final /* synthetic */ /* enum */ CheatingOffense \u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38;
    public static final /* synthetic */ /* enum */ CheatingOffense \u7121\u7bad\u77e2\u767c\u5c04\u5f13\u7bad;
    public static final /* synthetic */ /* enum */ CheatingOffense ETC_EXPLOSION;
    public static final /* synthetic */ /* enum */ CheatingOffense REGEN_HIGH_MP;
    public static final /* synthetic */ /* enum */ CheatingOffense ARAN_COMBO_HACK;
    public static final /* synthetic */ /* enum */ CheatingOffense PET_ITEMVAC_SERVER;
    public static final /* synthetic */ /* enum */ CheatingOffense \u53ec\u559a\u7378\u7121\u5ef6\u9072;
    public static final /* synthetic */ /* enum */ CheatingOffense TAKE_SAME_DAMAGE;
    public static final /* synthetic */ /* enum */ CheatingOffense AST_TAKE_DAMAG;
    public static final /* synthetic */ /* enum */ CheatingOffense REGEN_HIGH_HP;
    public static final /* synthetic */ /* enum */ CheatingOffense \u5438\u602a;
    public static final /* synthetic */ /* enum */ CheatingOffense \u7121\u9b25\u6c23\u4f7f\u7528\u9b25\u6c23\u6280\u80fd;
    public static final /* synthetic */ /* enum */ CheatingOffense \u653b\u64ca\u52d5\u756b\u5c01\u5305\u7570\u5e38;
    public static final /* synthetic */ /* enum */ CheatingOffense MISMATCHING_BULLETCOUNT;
    public static final /* synthetic */ /* enum */ CheatingOffense ATTACKING_WHILE_DEAD;
    public static final /* synthetic */ /* enum */ CheatingOffense \u6280\u80fd\u653b\u64ca\u6b21\u6578\u7570\u5e38;
    public static final /* synthetic */ /* enum */ CheatingOffense MULUNG_HACK;
    public static final /* synthetic */ /* enum */ CheatingOffense FAST_HP_MP_REGEN;
    public static final /* synthetic */ /* enum */ CheatingOffense \u7121\u5ef6\u9072\u653b\u64ca;
    public static final /* synthetic */ /* enum */ CheatingOffense ATTACK_TYPE_ERROR;
    public static final /* synthetic */ /* enum */ CheatingOffense EXCEED_DAMAGE_CAP;
    public static final /* synthetic */ /* enum */ CheatingOffense ATTACK_WITHOUT_GETTING_HIT;
    public static final /* synthetic */ /* enum */ CheatingOffense \u7d42\u6975\u653b\u64ca\u767e\u5206\u767e;
    public static final /* synthetic */ /* enum */ CheatingOffense FAST_TAKE_DAMAGE;
    public static final /* synthetic */ /* enum */ CheatingOffense ATTACK_FARAWAY_MONSTER_BAN;
    public static final /* synthetic */ /* enum */ CheatingOffense \u5438\u602a_\u98db;
    public static final /* synthetic */ /* enum */ CheatingOffense \u5feb\u901f\u56deHP;
    public static final /* synthetic */ /* enum */ CheatingOffense ITEMVAC_CLIENT;
    public static final /* synthetic */ /* enum */ CheatingOffense \u53ec\u559a\u7378\u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38;
    public static final /* synthetic */ /* enum */ CheatingOffense \u672a\u77e5\u5c01\u5305;
    public static final /* synthetic */ /* enum */ CheatingOffense \u5438\u602a_y;
    public static final /* synthetic */ /* enum */ CheatingOffense HIGH_DAMAGE_MAGIC_2;
    private final /* synthetic */ int a;
    public static final /* synthetic */ /* enum */ CheatingOffense \u4fee\u6539\u5c01\u5305_\u4e1f\u51fa\u4e0a\u9396\u9053\u5177;
    public static final /* synthetic */ /* enum */ CheatingOffense SAME_DAMAGE;
    private /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ CheatingOffense \u4fee\u6539\u5c01\u5305_\u4e1f\u51fa\u9ede\u88dd;
    public static final /* synthetic */ /* enum */ CheatingOffense MOB_VAC_X;
    public static final /* synthetic */ /* enum */ CheatingOffense \u7570\u5e38\u4f7f\u7528\u77ac\u9593\u79fb\u52d5;
    public static final /* synthetic */ /* enum */ CheatingOffense EXPLODING_NONEXISTANT;
    public static final /* synthetic */ /* enum */ CheatingOffense USING_FARAWAY_PORTAL;
    public static final /* synthetic */ /* enum */ CheatingOffense ITEMVAC_SERVER;
    public static final /* synthetic */ /* enum */ CheatingOffense \u53ec\u559a\u7378\u5168\u5716\u6253;
    private static final /* synthetic */ CheatingOffense[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ CheatingOffense \u79fb\u52d5\u7121\u5ef6\u9072;

    public final /* synthetic */ boolean isEnabled() {
        CheatingOffense a2;
        return a2.d >= 1;
    }

    public final /* synthetic */ int getPoints() {
        CheatingOffense a2;
        return a2.k;
    }

    public final /* synthetic */ int getBanType() {
        CheatingOffense a2;
        return a2.d;
    }

    public static /* synthetic */ CheatingOffense[] values() {
        return (CheatingOffense[])ALLATORIxDEMO.clone();
    }

    public final /* synthetic */ void setEnabled(boolean a2) {
        a.d = a2 ? 1 : 0;
    }

    public final /* synthetic */ boolean shouldAutoban(int a2) {
        CheatingOffense a3;
        if (a3.a == -1) {
            return false;
        }
        return a2 >= a3.a;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ CheatingOffense(int n22, long n22, int a2) {
        a5((String)var1_-1, (int)var2_-1, (int)a4, a2, (int)a3, 1);
        void a3;
        void a4;
        void var2_-1;
        void var1_-1;
        CheatingOffense a5;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ CheatingOffense(int n22, long n22) {
        a4((String)var1_-1, (int)var2_-1, (int)a3, (long)a2, -1, 1);
        void a2;
        void a3;
        void var2_-1;
        void var1_-1;
        CheatingOffense a4;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ CheatingOffense(int n22, long n22, int a2, int n3) {
        void a3;
        void a4;
        void a5;
        void var2_-1;
        void var1_-1;
        CheatingOffense a6;
        CheatingOffense cheatingOffense = a6;
        CheatingOffense cheatingOffense2 = a6;
        a6.d = 0;
        cheatingOffense2.k = a5;
        cheatingOffense2.K = a2;
        cheatingOffense.a = a4;
        cheatingOffense.d = a3;
    }

    public final /* synthetic */ long getValidityDuration() {
        CheatingOffense a2;
        return a2.K;
    }

    public static /* synthetic */ CheatingOffense valueOf(String a2) {
        return Enum.valueOf(CheatingOffense.class, a2);
    }

    public static /* synthetic */ {
        FASTATTACK = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u0012M\u0007X\u0015X\u0000M\u0017G"), 0, 5, 6000L, 200, 2);
        \u53ec\u559a\u7378\u7121\u5ef6\u9072 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u53b6\u55eb\u7322\u7150\u5eac\u9003"), 1, 5, 6000L, 50, 3);
        MOVE_MONSTERS = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("A\u001bZ\u0011S\u0019C\u001a_\u0000I\u0006_"), 2, 1, 30000L);
        FAST_HP_MP_REGEN = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u001c0\t%\u00059\n.\u0017!\u0005#\u001f6\u001f?"), 3, 5, 20000L, 10, 2);
        SAME_DAMAGE = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("_\u0015A\u0011S\u0010M\u0019M\u0013I"), 4, 2, 30000L, 150);
        ATTACK_WITHOUT_GETTING_HIT = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u001b%\u000e0\u0019:\u0005&\u0013%\u0012>\u000f%\u00056\u001f%\u000e8\u00146\u00059\u0013%"), 5, 1, 30000L, 1200, 0);
        HIGH_DAMAGE_MAGIC = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("D\u001dK\u001cS\u0010M\u0019M\u0013I\u000bA\u0015K\u001dO"), 6, 5, 30000L, -1, 0);
        HIGH_DAMAGE_MAGIC_2 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("9\u00136\u0012.\u001e0\u00170\u001d4\u0005<\u001b6\u00132\u0005C"), 7, 10, 30000L, -1, 0);
        HIGH_DAMAGE = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("D\u001dK\u001cS\u0010M\u0019M\u0013I"), 8, 5, 30000L, -1, 0);
        HIGH_DAMAGE_2 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("9\u00136\u0012.\u001e0\u00170\u001d4\u0005C"), 9, 10, 30000L, -1, 0);
        EXCEED_DAMAGE_CAP = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("I\fO\u0011I\u0010S\u0010M\u0019M\u0013I\u000bO\u0015\\"), 10, 5, 60000L, 800, 0);
        ATTACK_FARAWAY_MONSTER = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u001b%\u000e0\u0019:\u00057\u001b#\u001b&\u001b(\u0005<\u0015?\t%\u001f#"), 11, 5, 60000L, 500, 1);
        ATTACK_FARAWAY_MONSTER_BAN = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u0015X\u0000M\u0017G\u000bJ\u0015^\u0015[\u0015U\u000bA\u001bB\u0007X\u0011^\u000bN\u0015B"), 12, 3, 60000L, 60, 3);
        REGEN_HIGH_HP = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("#\u001f6\u001f?\u00059\u00136\u0012.\u0012!"), 13, 100, 30000L, 1000, 2);
        REGEN_HIGH_MP = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("^\u0011K\u0011B\u000bD\u001dK\u001cS\u0019\\"), 14, 100, 30000L, 1000, 2);
        ITEMVAC_CLIENT = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u0013%\u001f<\f0\u0019.\u0019=\u00134\u0014%"), 15, 5, 5000L, 10);
        ITEMVAC_SERVER = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u001dX\u0011A\u0002M\u0017S\u0007I\u0006Z\u0011^"), 16, 1, 10000L, 50, 2);
        PET_ITEMVAC_CLIENT = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\n4\u000e.\u0013%\u001f<\f0\u0019.\u0019=\u00134\u0014%"), 17, 5, 20000L, 20, 2);
        PET_ITEMVAC_SERVER = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u0004I\u0000S\u001dX\u0011A\u0002M\u0017S\u0007I\u0006Z\u0011^"), 18, 3, 10000L, 150, 2);
        USING_FARAWAY_PORTAL = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u000f\"\u0013?\u001d.\u001c0\b0\r0\u0003.\n>\b%\u001b="), 19, 1, 60000L, 100, 0);
        AST_TAKE_DAMAG = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u0015_\u0000S\u0000M\u001fI\u000bH\u0015A\u0015K"), 20, 1, 60000L, 100);
        HIGH_AVOID = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u00128\u001d9\u00050\f>\u00135"), 21, 20, 180000L, 100);
        MISMATCHING_BULLETCOUNT = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("A\u001d_\u0019M\u0000O\u001cE\u001aK\u000bN\u0001@\u0018I\u0000O\u001bY\u001aX"), 22, 1, 300000L);
        ETC_EXPLOSION = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("4\u000e2\u00054\u0002!\u0016>\t8\u0015?"), 23, 1, 300000L);
        ATTACKING_WHILE_DEAD = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u0015X\u0000M\u0017G\u001dB\u0013S\u0003D\u001d@\u0011S\u0010I\u0015H"), 24, 1, 300000L, -1, 0);
        USING_UNAVAILABLE_ITEM = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u000f\"\u0013?\u001d.\u000f?\u001b'\u001b8\u00160\u0018=\u001f.\u0013%\u001f<"), 25, 1, 300000L);
        EXPLODING_NONEXISTANT = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("I\f\\\u0018C\u0010E\u001aK\u000bB\u001bB\u0011T\u001d_\u0000M\u001aX"), 26, 1, 300000L);
        \u5feb\u901f\u56deHP = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u5f9a\u9045\u56af\u0012!"), 27, 1, 15000L, 150, 1);
        \u5feb\u901f\u56deMP = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u5fe7\u904b\u56d2\u0019\\"), 28, 1, 15000L, 150, 1);
        \u5feb\u901f\u653b\u64ca = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u5fb1\u906e\u6561\u64bb"), 29, 10, 60000L, 50, 2);
        \u7121\u5ef6\u9072\u653b\u64ca = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u712d\u5ea2\u907e\u656f\u64c6"), 30, 5, 10000L, 20, 3);
        MOB_VAC_X = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("<\u00153\u0005'\u001b2\u0005)"), 31, 1, 10000L, 20, 3);
        \u5438\u602a = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u546c\u6026"), 32, 1, 7000L, 5, 3);
        \u5438\u602a_y = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u5462\u605b\u0005\b"), 33, 1, 7000L, 5, 1);
        \u5438\u602a_\u98db = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u546c\u6026\u000b\u98d7"), 34, 1, 7000L, 5, 2);
        \u5438\u602a_\u65b0 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u5462\u605b\u0005\u65c1"), 35, 1, 20000L, 3, 3);
        \u63a7\u602a_\u65b0 = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u63f3\u6026\u000b\u65bc"), 36, 1, 20000L, 3, 3);
        ARAN_COMBO_HACK = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("0\b0\u0014.\u0019>\u00173\u0015.\u00120\u0019:"), 37, 1, 60000L, 20, 2);
        \u53ec\u559a\u7378\u5168\u5716\u6253 = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u53b8\u5596\u732c\u5164\u5742\u625f"), 38, 5, 180000L, 20, 2);
        \u53ec\u559a\u7378\u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u539d\u55c0\u7309\u6561\u64bb\u6070\u7218\u6522\u91be\u752a\u5e49"), 39, 1, 600000L, 7, 3);
        \u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38 = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u656f\u64c6\u607e\u7265\u652c\u91c3\u7524\u5e34"), 40, 1, 600000L, 7, 3);
        \u6280\u80fd\u653b\u64ca\u6b21\u6578\u7570\u5e38 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u62da\u808c\u6561\u64bb\u6b7b\u6509\u752a\u5e49"), 41, 1, 600000L, 7, 3);
        \u7fa4\u9ad4\u6cbb\u7652\u653b\u64ca\u4e0d\u6b7b\u7cfb\u602a\u7269 = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u7fa8\u9a80\u6cb7\u7606\u6537\u649e\u4e01\u6b2f\u7cf7\u607e\u7265"), 42, 1, 600000L, 7, 3);
        \u7121MP\u4f7f\u7528\u6280\u80fd = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u7150\u0017!\u4f25\u7559\u62da\u808c"), 43, 1, 60000L, 100, 3);
        \u7121\u7bad\u77e2\u767c\u5c04\u5f13\u7bad = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u712d\u7bf9\u77ee\u7628\u5c08\u5f47\u7ba1"), 44, 1, 60000L, 20, 3);
        \u7121\u9b25\u6c23\u4f7f\u7528\u9b25\u6c23\u6280\u80fd = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u7150\u9b7f\u6c52\u4f25\u7559\u9b7f\u6c52\u62da\u808c"), 45, 1, 60000L, 20, 3);
        \u63a7\u602a = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u63f3\u6026"), 46, 1, 60000L, -1, 2);
        \u79fb\u52d5\u7121\u5ef6\u9072 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u798a\u528f\u7150\u5eac\u9003"), 47, 1, 10000L, 20, 2);
        ATTACK_TYPE_ERROR = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("M\u0000X\u0015O\u001fS\u0000U\u0004I\u000bI\u0006^\u001b^"), 48, 5, 60000L, 30, 2);
        \u4fee\u6539\u5c01\u5305_\u4e1f\u51fa\u9ede\u88dd = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u4f9f\u6563\u5c70\u535f.\u4e45\u518b\u9e84\u88ac"), 49, 1, 600000L, 1, 1);
        \u4fee\u6539\u5c01\u5305_\u4e1f\u51fa\u4e0a\u9396\u9053\u5177 = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u4fe2\u656d\u5c0d\u5351S\u4e4b\u51f6\u4e5e\u939a\u9007\u517b"), 50, 1, 600000L, 1, 1);
        \u7570\u5e38\u4f7f\u7528\u4e8c\u6bb5\u8df3 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u7501\u5e62\u4f0e\u7572\u4efd\u6bef\u8d82"), 51, 1, 600000L, 7, 1);
        \u5feb\u901f\u4f7f\u7528\u4e8c\u6bb5\u8df3 = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u5fe7\u904b\u4f73\u757c\u4e80\u6be1\u8dff"), 52, 1, 60000L, 20, 2);
        \u7570\u5e38\u4f7f\u7528\u77ac\u9593\u79fb\u52d5 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u752a\u5e49\u4f25\u7559\u77f6\u95e2\u79a1\u52a4"), 53, 1, 60000L, 20, 2);
        \u7d42\u6975\u653b\u64ca\u767e\u5206\u767e = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u7d4e\u6921\u6537\u649e\u7672\u5252\u7672"), 54, 3, 20000L, 1, 2);
        MULUNG_HACK = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("<\u000f=\u000f?\u001d.\u00120\u0019:"), 55, 1, 60000L, 5, 1);
        TAKE_SAME_DAMAGE = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u0000M\u001fI\u000b_\u0015A\u0011S\u0010M\u0019M\u0013I"), 56, 1, 10000L, 3, 2);
        FAST_TAKE_DAMAGE = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u001c0\t%\u0005%\u001b:\u001f.\u001e0\u00170\u001d4"), 57, 1, 60000L, 20, 2);
        ATTACKMOB_ENERGY_HACK = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("M\u0000X\u0015O\u001fA\u001bN\u000bI\u001aI\u0006K\rS\u001cM\u0017G"), 58, 1, 60000L, 20, 0);
        \u9ed1\u983b\u8907\u88fd = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u9e8b\u984a\u895d\u888c"), 59, 1, 600000L, 1, 1);
        \u653b\u64ca\u52d5\u756b\u5c01\u5305\u7570\u5e38 = new CheatingOffense(MapleCharacterCards.ALLATORIxDEMO("\u656f\u64c6\u5281\u7567\u5c55\u5309\u7524\u5e34"), 60, 1, 600000L, 1, 1);
        \u672a\u77e5\u5c01\u5305 = new CheatingOffense(CharacterIdChannelPair.ALLATORIxDEMO("\u6770\u7794\u5c5b\u5374"), 61, 1, 100000L, 1, 2);
        CheatingOffense[] arrcheatingOffense = new CheatingOffense[62];
        arrcheatingOffense[0] = FASTATTACK;
        arrcheatingOffense[1] = \u53ec\u559a\u7378\u7121\u5ef6\u9072;
        arrcheatingOffense[2] = MOVE_MONSTERS;
        arrcheatingOffense[3] = FAST_HP_MP_REGEN;
        arrcheatingOffense[4] = SAME_DAMAGE;
        arrcheatingOffense[5] = ATTACK_WITHOUT_GETTING_HIT;
        arrcheatingOffense[6] = HIGH_DAMAGE_MAGIC;
        arrcheatingOffense[7] = HIGH_DAMAGE_MAGIC_2;
        arrcheatingOffense[8] = HIGH_DAMAGE;
        arrcheatingOffense[9] = HIGH_DAMAGE_2;
        arrcheatingOffense[10] = EXCEED_DAMAGE_CAP;
        arrcheatingOffense[11] = ATTACK_FARAWAY_MONSTER;
        arrcheatingOffense[12] = ATTACK_FARAWAY_MONSTER_BAN;
        arrcheatingOffense[13] = REGEN_HIGH_HP;
        arrcheatingOffense[14] = REGEN_HIGH_MP;
        arrcheatingOffense[15] = ITEMVAC_CLIENT;
        arrcheatingOffense[16] = ITEMVAC_SERVER;
        arrcheatingOffense[17] = PET_ITEMVAC_CLIENT;
        arrcheatingOffense[18] = PET_ITEMVAC_SERVER;
        arrcheatingOffense[19] = USING_FARAWAY_PORTAL;
        arrcheatingOffense[20] = AST_TAKE_DAMAG;
        arrcheatingOffense[21] = HIGH_AVOID;
        arrcheatingOffense[22] = MISMATCHING_BULLETCOUNT;
        arrcheatingOffense[23] = ETC_EXPLOSION;
        arrcheatingOffense[24] = ATTACKING_WHILE_DEAD;
        arrcheatingOffense[25] = USING_UNAVAILABLE_ITEM;
        arrcheatingOffense[26] = EXPLODING_NONEXISTANT;
        arrcheatingOffense[27] = \u5feb\u901f\u56deHP;
        arrcheatingOffense[28] = \u5feb\u901f\u56deMP;
        arrcheatingOffense[29] = \u5feb\u901f\u653b\u64ca;
        arrcheatingOffense[30] = \u7121\u5ef6\u9072\u653b\u64ca;
        arrcheatingOffense[31] = MOB_VAC_X;
        arrcheatingOffense[32] = \u5438\u602a;
        arrcheatingOffense[33] = \u5438\u602a_y;
        arrcheatingOffense[34] = \u5438\u602a_\u98db;
        arrcheatingOffense[35] = \u5438\u602a_\u65b0;
        arrcheatingOffense[36] = \u63a7\u602a_\u65b0;
        arrcheatingOffense[37] = ARAN_COMBO_HACK;
        arrcheatingOffense[38] = \u53ec\u559a\u7378\u5168\u5716\u6253;
        arrcheatingOffense[39] = \u53ec\u559a\u7378\u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38;
        arrcheatingOffense[40] = \u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38;
        arrcheatingOffense[41] = \u6280\u80fd\u653b\u64ca\u6b21\u6578\u7570\u5e38;
        arrcheatingOffense[42] = \u7fa4\u9ad4\u6cbb\u7652\u653b\u64ca\u4e0d\u6b7b\u7cfb\u602a\u7269;
        arrcheatingOffense[43] = \u7121MP\u4f7f\u7528\u6280\u80fd;
        arrcheatingOffense[44] = \u7121\u7bad\u77e2\u767c\u5c04\u5f13\u7bad;
        arrcheatingOffense[45] = \u7121\u9b25\u6c23\u4f7f\u7528\u9b25\u6c23\u6280\u80fd;
        arrcheatingOffense[46] = \u63a7\u602a;
        arrcheatingOffense[47] = \u79fb\u52d5\u7121\u5ef6\u9072;
        arrcheatingOffense[48] = ATTACK_TYPE_ERROR;
        arrcheatingOffense[49] = \u4fee\u6539\u5c01\u5305_\u4e1f\u51fa\u9ede\u88dd;
        arrcheatingOffense[50] = \u4fee\u6539\u5c01\u5305_\u4e1f\u51fa\u4e0a\u9396\u9053\u5177;
        arrcheatingOffense[51] = \u7570\u5e38\u4f7f\u7528\u4e8c\u6bb5\u8df3;
        arrcheatingOffense[52] = \u5feb\u901f\u4f7f\u7528\u4e8c\u6bb5\u8df3;
        arrcheatingOffense[53] = \u7570\u5e38\u4f7f\u7528\u77ac\u9593\u79fb\u52d5;
        arrcheatingOffense[54] = \u7d42\u6975\u653b\u64ca\u767e\u5206\u767e;
        arrcheatingOffense[55] = MULUNG_HACK;
        arrcheatingOffense[56] = TAKE_SAME_DAMAGE;
        arrcheatingOffense[57] = FAST_TAKE_DAMAGE;
        arrcheatingOffense[58] = ATTACKMOB_ENERGY_HACK;
        arrcheatingOffense[59] = \u9ed1\u983b\u8907\u88fd;
        arrcheatingOffense[60] = \u653b\u64ca\u52d5\u756b\u5c01\u5305\u7570\u5e38;
        arrcheatingOffense[61] = \u672a\u77e5\u5c01\u5305;
        ALLATORIxDEMO = arrcheatingOffense;
    }
}

