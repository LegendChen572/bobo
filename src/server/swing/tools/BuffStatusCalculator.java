/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import handling.cashshop.handler.CashShopOperation;
import handling.world.MaplePartyCharacter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import server.MobSkillData;
import tools.HexTool;
import tools.JsonMapConverter;

public class BuffStatusCalculator
extends JFrame {
    private /* synthetic */ JLabel e;
    private /* synthetic */ JTextField k;
    private /* synthetic */ JLabel M;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JButton D;
    private /* synthetic */ JTextField B;
    private /* synthetic */ JLabel H;
    private /* synthetic */ JLabel J;
    private /* synthetic */ JLabel I;
    private /* synthetic */ JButton i;
    private /* synthetic */ JLabel E;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton j;
    private /* synthetic */ JLabel F;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JTextField g;
    private /* synthetic */ JTextField K;
    private /* synthetic */ JButton L;
    private /* synthetic */ JLabel C;

    private /* synthetic */ void ALLATORIxDEMO() {
        BuffStatusCalculator a2;
        BuffStatusCalculator buffStatusCalculator = a2;
        BuffStatusCalculator buffStatusCalculator2 = a2;
        BuffStatusCalculator buffStatusCalculator3 = a2;
        BuffStatusCalculator buffStatusCalculator4 = a2;
        buffStatusCalculator3.g = new JTextField();
        buffStatusCalculator4.B = new JTextField();
        buffStatusCalculator3.k = new JTextField();
        buffStatusCalculator3.J = new JLabel();
        buffStatusCalculator3.M = new JLabel();
        buffStatusCalculator3.I = new JLabel();
        buffStatusCalculator3.D = new JButton();
        buffStatusCalculator3.L = new JButton();
        buffStatusCalculator3.F = new JLabel();
        buffStatusCalculator3.K = new JTextField();
        buffStatusCalculator3.j = new JButton();
        buffStatusCalculator3.C = new JLabel();
        buffStatusCalculator3.H = new JLabel();
        buffStatusCalculator3.a = new JTextField();
        buffStatusCalculator3.d = new JTextField();
        buffStatusCalculator3.e = new JLabel();
        buffStatusCalculator3.E = new JLabel();
        a2.i = new JButton();
        a2.ALLATORIxDEMO = new JTextField();
        a2.setDefaultCloseOperation(3);
        buffStatusCalculator2.setTitle(MobSkillData.ALLATORIxDEMO("\u57f7\u5720\u8a05\u7bf7\u5665"));
        buffStatusCalculator.setResizable(false);
        buffStatusCalculator2.J.setText(JsonMapConverter.ALLATORIxDEMO("\u57fe\u5735"));
        buffStatusCalculator.M.setText(MobSkillData.ALLATORIxDEMO("-L3F"));
        buffStatusCalculator.I.setText(JsonMapConverter.ALLATORIxDEMO("\u7dec\u78c9"));
        buffStatusCalculator.D.setText(MobSkillData.ALLATORIxDEMO("\u579a\u574d^3\u7d88\u78b1"));
        buffStatusCalculator.D.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.BuffStatusCalculator.this.D(a2);
            }
        });
        buffStatusCalculator.L.setText(JsonMapConverter.ALLATORIxDEMO("\u57fe\u57358I\u7dec\u78c9"));
        buffStatusCalculator.L.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.BuffStatusCalculator.this.l(a2);
            }
            {
                2 a3;
            }
        });
        buffStatusCalculator.F.setText(MobSkillData.ALLATORIxDEMO("\u6518\u64d7"));
        buffStatusCalculator.j.setText(JsonMapConverter.ALLATORIxDEMO("\u6e01\u7a0f"));
        buffStatusCalculator.j.addActionListener(new ActionListener(){
            {
                3 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                3 a3;
                a3.BuffStatusCalculator.this.H(a2);
            }
        });
        buffStatusCalculator.C.setForeground(new Color(255, 0, 0));
        buffStatusCalculator.C.setText(MobSkillData.ALLATORIxDEMO("\u57f7\u5720\u8f44\u63bb\u5665"));
        buffStatusCalculator.H.setText(JsonMapConverter.ALLATORIxDEMO("F B3"));
        buffStatusCalculator.e.setText(MobSkillData.ALLATORIxDEMO("\u5031"));
        buffStatusCalculator.E.setForeground(new Color(255, 0, 0));
        buffStatusCalculator.E.setText(JsonMapConverter.ALLATORIxDEMO("8e\u0005h\u0010F\u0000b\u0013W\u0001e\u0001$\u8f3c\u63df\u561d"));
        buffStatusCalculator.i.setText(MobSkillData.ALLATORIxDEMO("\u8f29\u63d6\u505c-^3"));
        buffStatusCalculator.i.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                4 a3;
                a3.BuffStatusCalculator.this.ALLATORIxDEMO(a2);
            }
            {
                4 a3;
            }
        });
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        buffStatusCalculator.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.j, -2, 247, -2).addGroup(groupLayout.createSequentialGroup().addComponent(a2.D, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.L, -2, 120, -2)).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(a2.J).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.g, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.M).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.B)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(a2.F).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.K, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.I).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.k, -2, 90, -2)))).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.H).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.a).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.e)).addComponent(a2.C).addComponent(a2.E)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.d, -2, 36, -2)))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.i).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.ALLATORIxDEMO))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(a2.C).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g, -2, -1, -2).addComponent(a2.M).addComponent(a2.B, -2, -1, -2).addComponent(a2.J)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.F).addComponent(a2.K, -2, -1, -2).addComponent(a2.I).addComponent(a2.k, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.D).addComponent(a2.L)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.j).addGap(11, 11, 11).addComponent(a2.E).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.a, -2, -1, -2).addComponent(a2.H).addComponent(a2.e).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.i).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addGap(10, 10, 10)));
        buffStatusCalculator.pack();
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a22) {
        BuffStatusCalculator a3;
        if (a3.a.getText().isEmpty() || a3.d.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, JsonMapConverter.ALLATORIxDEMO("\u672e\u8f4d\u5161T"));
        } else {
            int n2;
            BuffStatusCalculator buffStatusCalculator = a3;
            int a22 = Integer.decode(buffStatusCalculator.a.getText());
            int n3 = Integer.parseInt(buffStatusCalculator.d.getText());
            int n4 = n2 = 0;
            while (n4 < 31) {
                if ((long)(1 << (int)((long)n2 % 32L)) == (long)a22) {
                    int n5 = (n3 - 1) * 32 + n2;
                    a3.ALLATORIxDEMO.setText(Integer.toString(n5));
                    System.out.println(n5);
                }
                n4 = ++n2;
            }
        }
        MapleBuffStat.ACASH_RATE.getValue();
    }

    public /* synthetic */ BuffStatusCalculator() {
        BuffStatusCalculator a2;
        BuffStatusCalculator buffStatusCalculator = a2;
        buffStatusCalculator.ALLATORIxDEMO();
    }

    private /* synthetic */ void l(ActionEvent a22) {
        BuffStatusCalculator a3;
        a22 = a3.k.getText();
        if (((String)a22).isEmpty()) {
            return;
        }
        int a22 = Integer.parseInt((String)a22);
        long l2 = 1 << 31 - a22 % 32;
        if (l2 > 0x80000000L) {
            return;
        }
        a22 = (int)Math.floor(a22 / 32);
        byte[] arrby = new byte[4];
        String string = Long.toHexString(l2);
        if (string.length() > 8) {
            String string2 = string;
            string = string2.substring(string.length() - 8, string2.length());
        }
        BuffStatusCalculator buffStatusCalculator = a3;
        buffStatusCalculator.g.setText(string);
        buffStatusCalculator.B.setText(String.valueOf(a22));
        byte[] arrby2 = arrby;
        arrby[0] = (byte)(l2 & 0xFFL);
        arrby2[1] = (byte)(l2 >>> 8 & 0xFFL);
        arrby[2] = (byte)(l2 >>> 16 & 0xFFL);
        arrby2[3] = (byte)(l2 >>> 24 & 0xFFL);
        a3.K.setText(HexTool.toString(arrby));
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        BuffStatusCalculator a3;
        if (a2) {
            BuffStatusCalculator buffStatusCalculator = a3;
            buffStatusCalculator.init();
            buffStatusCalculator.setLocationRelativeTo(null);
        }
        super.setVisible(a2);
    }

    private /* synthetic */ void H(ActionEvent a2) {
        BuffStatusCalculator a3;
        a3.init();
    }

    private /* synthetic */ void D(ActionEvent a2) {
        long l2;
        long l3;
        BuffStatusCalculator a3;
        BuffStatusCalculator buffStatusCalculator = a3;
        a2 = buffStatusCalculator.g.getText();
        String string = buffStatusCalculator.B.getText();
        String string2 = buffStatusCalculator.K.getText();
        if (((String)a2).isEmpty() && string2.isEmpty() || string.isEmpty()) {
            return;
        }
        byte[] arrby = new byte[4];
        if (!((String)a2).isEmpty()) {
            if (((String)a2).startsWith(JsonMapConverter.ALLATORIxDEMO("4\r"))) {
                a2 = ((String)a2).replaceAll(MobSkillData.ALLATORIxDEMO("Pu"), "");
            }
            l2 = l3 = Long.parseLong((String)a2, 16);
            arrby[0] = (byte)(l3 & 0xFFL);
            arrby[1] = (byte)(l3 >>> 8 & 0xFFL);
            arrby[2] = (byte)(l3 >>> 16 & 0xFFL);
            arrby[3] = (byte)(l3 >>> 24 & 0xFFL);
            a3.K.setText(HexTool.toString(arrby));
        } else {
            arrby = HexTool.getByteArrayFromHexString(string2);
            if (arrby.length != 4) {
                return;
            }
            l3 = 0L;
            long l4 = arrby[0] & 0xFF;
            long l5 = arrby[1] & 0xFF;
            long l6 = arrby[2] & 0xFF;
            l2 = l3 = ((long)(arrby[3] & 0xFF) << 24) + (l6 << 16) + (l5 << 8) + l4;
        }
        if (l2 > 0x80000000L) {
            return;
        }
        a2 = Long.toHexString(l3);
        if (((String)a2).length() > 8) {
            Object object = a2;
            a2 = ((String)object).substring(((String)a2).length() - 8, ((String)object).length());
        }
        a3.g.setText((String)a2);
        int n2 = 0;
        long l7 = l3;
        while (l7 > 1L) {
            ++n2;
            l7 = l3 /= 2L;
        }
        n2 = 31 - n2;
        int n3 = Integer.parseInt(string);
        a3.k.setText(String.valueOf(n2 += n3 * 32));
    }

    public /* synthetic */ void init() {
        BuffStatusCalculator a2;
        BuffStatusCalculator buffStatusCalculator = a2;
        buffStatusCalculator.g.setText("");
        buffStatusCalculator.B.setText("");
        buffStatusCalculator.k.setText("");
        buffStatusCalculator.K.setText("");
    }

    public static final class MapleBuffStat
    extends Enum<MapleBuffStat> {
        public static final /* synthetic */ /* enum */ MapleBuffStat MAGIC_SHIELD;
        public static final /* synthetic */ /* enum */ MapleBuffStat ELEMENT_WEAKEN;
        public static final /* synthetic */ /* enum */ MapleBuffStat SATELLITESAFE_ABSORB;
        public static final /* synthetic */ /* enum */ MapleBuffStat OWL_SPIRIT;
        public static final /* synthetic */ /* enum */ MapleBuffStat DEFAULT_BUFFSTAT2;
        public static final /* synthetic */ /* enum */ MapleBuffStat DASH_SPEED;
        public static final /* synthetic */ /* enum */ MapleBuffStat ONYX_SHROUD;
        public static final /* synthetic */ /* enum */ MapleBuffStat ACC;
        public static final /* synthetic */ /* enum */ MapleBuffStat ARIANT_COSS_IMU;
        public static final /* synthetic */ /* enum */ MapleBuffStat RECOVERY;
        public static final /* synthetic */ /* enum */ MapleBuffStat DEFENCE_BOOST_R;
        public static final /* synthetic */ /* enum */ MapleBuffStat MAGIC_RESISTANCE;
        public static final /* synthetic */ /* enum */ MapleBuffStat BEHOLDER;
        public static final /* synthetic */ /* enum */ MapleBuffStat SATELLITESAFE_PROC;
        public static final /* synthetic */ /* enum */ MapleBuffStat ENHANCED_MAXHP;
        private final /* synthetic */ int a;
        public static final /* synthetic */ /* enum */ MapleBuffStat ACASH_RATE;
        public static final /* synthetic */ /* enum */ MapleBuffStat WATER_SHIELD;
        public static final /* synthetic */ /* enum */ MapleBuffStat HP_BOOST_PERCENT;
        public static final /* synthetic */ /* enum */ MapleBuffStat HOLY_SYMBOL;
        public static final /* synthetic */ /* enum */ MapleBuffStat SLOW;
        public static final /* synthetic */ /* enum */ MapleBuffStat PVP_ATTACK;
        public static final /* synthetic */ /* enum */ MapleBuffStat SIDEKICK_PASSIVE;
        public static final /* synthetic */ /* enum */ MapleBuffStat CONVERSION;
        public static final /* synthetic */ /* enum */ MapleBuffStat VIRTUE_EFFECT;
        public static final /* synthetic */ /* enum */ MapleBuffStat PUPPET;
        public static final /* synthetic */ /* enum */ MapleBuffStat MESO_RATE;
        public static final /* synthetic */ /* enum */ MapleBuffStat MP_BUFF;
        public static final /* synthetic */ /* enum */ MapleBuffStat DASH_JUMP;
        public static final /* synthetic */ /* enum */ MapleBuffStat BLESS;
        public static final /* synthetic */ /* enum */ MapleBuffStat MONSTER_RIDING;
        public static final /* synthetic */ /* enum */ MapleBuffStat DEFAULT_BUFFSTAT;
        public static final /* synthetic */ /* enum */ MapleBuffStat PERFECT_ARMOR;
        public static final /* synthetic */ /* enum */ MapleBuffStat COMBO;
        public static final /* synthetic */ /* enum */ MapleBuffStat CURSE;
        public static final /* synthetic */ /* enum */ MapleBuffStat RAINING_MINES;
        public static final /* synthetic */ /* enum */ MapleBuffStat TORNADO;
        public static final /* synthetic */ /* enum */ MapleBuffStat COMBO_DRAIN;
        public static final /* synthetic */ /* enum */ MapleBuffStat ELEMENTAL_STATUS_R;
        public static final /* synthetic */ /* enum */ MapleBuffStat FAMILIAR_SHADOW;
        public static final /* synthetic */ /* enum */ MapleBuffStat LUK;
        public static final /* synthetic */ /* enum */ MapleBuffStat ENHANCED_MAXMP;
        public static final /* synthetic */ /* enum */ MapleBuffStat AURA;
        public static final /* synthetic */ /* enum */ MapleBuffStat GIANT_POTION;
        public static final /* synthetic */ /* enum */ MapleBuffStat WK_CHARGE;
        public static final /* synthetic */ /* enum */ MapleBuffStat REAPER;
        public static final /* synthetic */ /* enum */ MapleBuffStat ICE_KNIGHT;
        public static final /* synthetic */ /* enum */ MapleBuffStat MESOGUARD;
        public static final /* synthetic */ /* enum */ MapleBuffStat TELEPORT_MASTERY;
        public static final /* synthetic */ /* enum */ MapleBuffStat HOLY_SHIELD;
        public static final /* synthetic */ /* enum */ MapleBuffStat MECH_CHANGE;
        public static final /* synthetic */ /* enum */ MapleBuffStat BERSERK_FURY;
        private static final /* synthetic */ MapleBuffStat[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ MapleBuffStat MDEF;
        public static final /* synthetic */ /* enum */ MapleBuffStat BODY_PRESSURE;
        public static final /* synthetic */ /* enum */ MapleBuffStat DIVINE_BODY;
        public static final /* synthetic */ /* enum */ MapleBuffStat SHARP_EYES;
        public static final /* synthetic */ /* enum */ MapleBuffStat INVINCIBILITY;
        public static final /* synthetic */ /* enum */ MapleBuffStat GHOST_MORPH;
        public static final /* synthetic */ /* enum */ MapleBuffStat ARIANT_COSS_IMU2;
        public static final /* synthetic */ /* enum */ MapleBuffStat ANGEL_AVOID;
        public static final /* synthetic */ /* enum */ MapleBuffStat ENHANCED_MATK;
        public static final /* synthetic */ /* enum */ MapleBuffStat DAMAGE_PERCENT;
        public static final /* synthetic */ /* enum */ MapleBuffStat MATK;
        public static final /* synthetic */ /* enum */ MapleBuffStat EXPRATE;
        public static final /* synthetic */ /* enum */ MapleBuffStat SUMMON;
        public static final /* synthetic */ /* enum */ MapleBuffStat MAGIC_GUARD;
        public static final /* synthetic */ /* enum */ MapleBuffStat FELINE_BERSERK;
        public static final /* synthetic */ /* enum */ MapleBuffStat ENRAGE;
        public static final /* synthetic */ /* enum */ MapleBuffStat SPEED_INFUSION;
        public static final /* synthetic */ /* enum */ MapleBuffStat INVINCIBLE;
        public static final /* synthetic */ /* enum */ MapleBuffStat ENHANCED_WDEF;
        private /* synthetic */ boolean d;
        public static final /* synthetic */ /* enum */ MapleBuffStat MP_BOOST;
        public static final /* synthetic */ /* enum */ MapleBuffStat ANGEL_ATK;
        public static final /* synthetic */ /* enum */ MapleBuffStat MESOUP;
        public static final /* synthetic */ /* enum */ MapleBuffStat FROZEN;
        public static final /* synthetic */ /* enum */ MapleBuffStat CRITICAL_RATE_BUFF;
        public static final /* synthetic */ /* enum */ MapleBuffStat MP_BOOST_PERCENT;
        public static final /* synthetic */ /* enum */ MapleBuffStat BLUE_AURA;
        public static final /* synthetic */ /* enum */ MapleBuffStat ELEMENT_RESET;
        public static final /* synthetic */ /* enum */ MapleBuffStat CONCENTRATE;
        public static final /* synthetic */ /* enum */ MapleBuffStat COMBAT_ORDERS;
        public static final /* synthetic */ /* enum */ MapleBuffStat MAPLE_WARRIOR;
        public static final /* synthetic */ /* enum */ MapleBuffStat POWERGUARD;
        public static final /* synthetic */ /* enum */ MapleBuffStat INT;
        public static final /* synthetic */ /* enum */ MapleBuffStat SOULARROW;
        public static final /* synthetic */ /* enum */ MapleBuffStat DARK_AURA;
        public static final /* synthetic */ /* enum */ MapleBuffStat LIGHTNING_CHARGE;
        public static final /* synthetic */ /* enum */ MapleBuffStat WATK;
        public static final /* synthetic */ /* enum */ MapleBuffStat PVP_DAMAGE;
        public static final /* synthetic */ /* enum */ MapleBuffStat SEAL;
        public static final /* synthetic */ /* enum */ MapleBuffStat DRAGONBLOOD;
        public static final /* synthetic */ /* enum */ MapleBuffStat ATTACK_BUFF;
        public static final /* synthetic */ /* enum */ MapleBuffStat ANGEL_SPEED;
        public static final /* synthetic */ /* enum */ MapleBuffStat HIDDEN_POTENTIAL;
        public static final /* synthetic */ /* enum */ MapleBuffStat STUN;
        public static final /* synthetic */ /* enum */ MapleBuffStat MANA_REFLECTION;
        public static final /* synthetic */ /* enum */ MapleBuffStat ABNORMAL_STATUS_R;
        public static final /* synthetic */ /* enum */ MapleBuffStat WDEF;
        public static final /* synthetic */ /* enum */ MapleBuffStat FINALATTACK;
        public static final /* synthetic */ /* enum */ MapleBuffStat ECHO_OF_HERO;
        public static final /* synthetic */ /* enum */ MapleBuffStat DAMAGE_BUFF;
        public static final /* synthetic */ /* enum */ MapleBuffStat DAMAGE_TAKEN_BUFF;
        public static final /* synthetic */ /* enum */ MapleBuffStat WIND_WALK;
        public static final /* synthetic */ /* enum */ MapleBuffStat HAMSTRING;
        public static final /* synthetic */ /* enum */ MapleBuffStat DODGE_CHANGE_BUFF;
        public static final /* synthetic */ /* enum */ MapleBuffStat SMART_KNOCKBACK;
        public static final /* synthetic */ /* enum */ MapleBuffStat DEX;
        public static final /* synthetic */ /* enum */ MapleBuffStat BUFF_MASTERY;
        public static final /* synthetic */ /* enum */ MapleBuffStat PYRAMID_PQ;
        public static final /* synthetic */ /* enum */ MapleBuffStat WEAKEN;
        public static final /* synthetic */ /* enum */ MapleBuffStat ANGEL_JUMP;
        public static final /* synthetic */ /* enum */ MapleBuffStat ILLUSION;
        public static final /* synthetic */ /* enum */ MapleBuffStat BLIND;
        public static final /* synthetic */ /* enum */ MapleBuffStat FINAL_CUT;
        public static final /* synthetic */ /* enum */ MapleBuffStat ONYX_WILL;
        public static final /* synthetic */ /* enum */ MapleBuffStat AVOID;
        public static final /* synthetic */ /* enum */ MapleBuffStat STANCE;
        public static final /* synthetic */ /* enum */ MapleBuffStat SPIRIT_CLAW;
        public static final /* synthetic */ /* enum */ MapleBuffStat HP_LOSS_GUARD;
        public static final /* synthetic */ /* enum */ MapleBuffStat ENERGY_CHARGE;
        public static final /* synthetic */ /* enum */ MapleBuffStat ANGEL_ACC;
        public static final /* synthetic */ /* enum */ MapleBuffStat ICE_SKILL;
        public static final /* synthetic */ /* enum */ MapleBuffStat DARK_METAMORPHOSIS;
        public static final /* synthetic */ /* enum */ MapleBuffStat NO_SLIP;
        public static final /* synthetic */ /* enum */ MapleBuffStat ANGEL_STAT;
        public static final /* synthetic */ /* enum */ MapleBuffStat SPEED;
        public static final /* synthetic */ /* enum */ MapleBuffStat ENHANCED_MDEF;
        public static final /* synthetic */ /* enum */ MapleBuffStat SPIRIT_LINK;
        public static final /* synthetic */ /* enum */ MapleBuffStat BOOSTER;
        public static final /* synthetic */ /* enum */ MapleBuffStat HP_BOOST;
        public static final /* synthetic */ /* enum */ MapleBuffStat DROP_RATE;
        public static final /* synthetic */ /* enum */ MapleBuffStat PICKPOCKET;
        public static final /* synthetic */ /* enum */ MapleBuffStat DARKSIGHT;
        public static final /* synthetic */ /* enum */ MapleBuffStat HOLY_MAGIC_SHELL;
        public static final /* synthetic */ /* enum */ MapleBuffStat JUMP;
        public static final /* synthetic */ /* enum */ MapleBuffStat MORPH;
        public static final /* synthetic */ /* enum */ MapleBuffStat SOUL_STONE;
        public static final /* synthetic */ /* enum */ MapleBuffStat HANDS;
        public static final /* synthetic */ /* enum */ MapleBuffStat HOMING_BEACON;
        public static final /* synthetic */ /* enum */ MapleBuffStat BODY_BOOST;
        public static final /* synthetic */ /* enum */ MapleBuffStat BOUNDLESS_RAGE;
        public static final /* synthetic */ /* enum */ MapleBuffStat STR;
        public static final /* synthetic */ /* enum */ MapleBuffStat SNATCH;
        public static final /* synthetic */ /* enum */ MapleBuffStat MAXHP;
        public static final /* synthetic */ /* enum */ MapleBuffStat ARCANE_AIM;
        public static final /* synthetic */ /* enum */ MapleBuffStat SHADOWPARTNER;
        public static final /* synthetic */ /* enum */ MapleBuffStat DICE_ROLL;
        public static final /* synthetic */ /* enum */ MapleBuffStat DIVINE_SHIELD;
        public static final /* synthetic */ /* enum */ MapleBuffStat ANGEL_MATK;
        public static final /* synthetic */ /* enum */ MapleBuffStat ARAN_COMBO;
        public static final /* synthetic */ /* enum */ MapleBuffStat THREATEN_PVP;
        private final /* synthetic */ int K;
        public static final /* synthetic */ /* enum */ MapleBuffStat MAXMP;
        public static final /* synthetic */ /* enum */ MapleBuffStat SPARK;
        private static final /* synthetic */ long k = 0L;
        public static final /* synthetic */ /* enum */ MapleBuffStat DARKNESS;
        public static final /* synthetic */ /* enum */ MapleBuffStat YELLOW_AURA;
        public static final /* synthetic */ /* enum */ MapleBuffStat COMBO_BARRIER;
        public static final /* synthetic */ /* enum */ MapleBuffStat INFINITY;
        public static final /* synthetic */ /* enum */ MapleBuffStat INFILTRATE;
        public static final /* synthetic */ /* enum */ MapleBuffStat SPIRIT_SURGE;
        public static final /* synthetic */ /* enum */ MapleBuffStat POISON;
        public static final /* synthetic */ /* enum */ MapleBuffStat SOARING;
        public static final /* synthetic */ /* enum */ MapleBuffStat ENHANCED_WATK;

        public static /* synthetic */ MapleBuffStat valueOf(String a2) {
            return Enum.valueOf(MapleBuffStat.class, a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ MapleBuffStat(int n222, int n222, boolean a2) {
            void a3;
            int n3;
            void a4;
            void var2_-1;
            void var1_-1;
            MapleBuffStat a5;
            a5.d = false;
            int n4 = a2;
            void var6_5 = a4;
            int n2 = n3 = 0;
            while (n2 < 31) {
                if ((long)(1 << (int)((long)n3 % 32L)) == (long)n4) {
                    void var8_7 = (var6_5 - true) * 32 + n3;
                    System.out.println(a5.name() + " = " + (int)var8_7);
                }
                n2 = ++n3;
            }
            MapleBuffStat mapleBuffStat = a5;
            mapleBuffStat.K = a2 ? 1 : 0;
            mapleBuffStat.a = a4;
            a5.d = a3;
        }

        public static /* synthetic */ {
            WATK = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("a'b-"), 0, 1, 1);
            WDEF = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("iB{@"), 1, 2, 1);
            MATK = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("{'b-"), 2, 4, 1);
            MDEF = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("sB{@"), 3, 8, 1);
            ACC = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("'u%"), 4, 16, 1);
            AVOID = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("GhIwB"), 5, 32, 1);
            HANDS = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO(".w(r5"), 6, 64, 1);
            SPEED = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("UnC{B"), 7, 128, 1);
            JUMP = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("|3{6"), 8, 256, 1);
            MAGIC_GUARD = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("K\u007fAwEaAkGlB"), 9, 512, 1);
            DARKSIGHT = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\"w4}5\u007f!~2"), 10, 1024, 1);
            BOOSTER = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("DqImR{T"), 11, 2048, 1);
            POWERGUARD = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("f)a#d!c'd\""), 12, 4096, 1);
            MAXHP = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("K\u007f^vV"), 13, 8192, 1);
            MAXMP = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("+w>{6"), 14, 16384, 1);
            INVINCIBLE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("wHhOpEwDrC"), 15, 32768, 1);
            SOULARROW = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("5y3z'd4y1"), 16, 65536, 1);
            STUN = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("mRkH"), 17, 131072, 1);
            POISON = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("f)\u007f5y("), 18, 262144, 1);
            SEAL = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("mC\u007fJ"), 19, 524288, 1);
            DARKNESS = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("r'd-x#e5"), 20, 0x100000, 1);
            COMBO = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("EqK|I"), 21, 0x200000, 1);
            SUMMON = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("e3{+y("), 22, 0x200000, 1);
            WK_CHARGE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("QuY}N\u007fTyC"), 23, 0x400000, 1);
            DRAGONBLOOD = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\"d'q)x$z)y\""), 24, 0x800000, 1);
            HOLY_SYMBOL = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("NqJgYm_sDqJ"), 25, 0x1000000, 1);
            MESOUP = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("{#e)c6"), 26, 0x2000000, 1);
            SHADOWPARTNER = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("UvGzIiV\u007fTjH{T"), 27, 0x4000000, 1);
            PICKPOCKET = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("f/u-f)u-s2"), 28, 0x8000000, 1);
            PUPPET = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("nSnV{R"), 29, 0x8000000, 1);
            MESOGUARD = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("+s5y!c'd\""), 30, 0x10000000, 1);
            HP_LOSS_GUARD = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("NnYrImUaAkGlB"), 31, 0x20000000, 1);
            WEAKEN = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("a#w-s("), 32, 0x40000000, 1);
            CURSE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("EkTmC"), 33, Integer.MIN_VALUE, 1);
            MORPH = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("+y4f."), 34, 2, 2);
            RECOVERY = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("lC}IhCl_"), 35, 4, 2);
            MAPLE_WARRIOR = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("+w6z#i1w4d/y4"), 36, 8, 2);
            STANCE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("mR\u007fH}C"), 37, 16, 2);
            SHARP_EYES = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("e.w4f9s?s5"), 38, 32, 2);
            MANA_REFLECTION = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("K\u007fH\u007fYlCxJ{EjOqH"), 39, 64, 2);
            SPIRIT_CLAW = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("5f/d/b9u*w1"), 40, 256, 2);
            INFINITY = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("wHxOpOj_"), 41, 512, 2);
            HOLY_SHIELD = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO(".y*o9e.\u007f#z\""), 42, 1024, 2);
            HAMSTRING = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("N\u007fKmRlOpA"), 43, 2048, 2);
            BLIND = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("$z/x\""), 44, 4096, 2);
            CONCENTRATE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("EqH}CpRlGjC"), 45, 8192, 2);
            ECHO_OF_HERO = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("s%~)i)p9~#d)"), 46, 32768, 2);
            BOUNDLESS_RAGE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("|IkHzJ{UmYlGyC"), 47, Integer.MIN_VALUE, 5);
            MESO_RATE = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("+s5y9d'b#"), 48, 65536, 2);
            GHOST_MORPH = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("AvImRaKqTnN"), 49, 131072, 2);
            ARIANT_COSS_IMU = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("'d/w(b9u)e5i/{3"), 50, 262144, 2);
            DROP_RATE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("BlInYlGjC"), 51, 0x100000, 2);
            EXPRATE = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("#n6d'b#"), 52, 0x400000, 2);
            ACASH_RATE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("\u007fE\u007fUvYlGjC"), 53, 0x800000, 2);
            ILLUSION = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\u007f*z3e/y("), 54, 0x1000000, 2);
            BERSERK_FURY = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("|ClU{TuYxSl_"), 55, 0x2000000, 2);
            DIVINE_BODY = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\"\u007f0\u007f(s9t)r?"), 56, 0x4000000, 2);
            SPARK = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("UnGlM"), 57, 0x8000000, 2);
            ARIANT_COSS_IMU2 = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("w4\u007f'x2i%y5e9\u007f+cT"), 58, 0x10000000, 2);
            FINALATTACK = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("@wH\u007fJ\u007fRjG}M"), 59, 0x20000000, 2);
            ELEMENT_RESET = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("#z#{#x2i4s5s2"), 60, Integer.MIN_VALUE, 2);
            WIND_WALK = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("QwHzYiGrM"), 61, 1, 3);
            ARAN_COMBO = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("w4w(i%y+t)"), 62, 4, 3);
            COMBO_DRAIN = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("EqK|IaBlGwH"), 63, 8, 3);
            COMBO_BARRIER = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("%y+t)i$w4d/s4"), 64, 16, 3);
            BODY_PRESSURE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("DqBgYnT{UmSlC"), 65, 32, 3);
            SMART_KNOCKBACK = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("5{'d2i-x)u-t'u-"), 66, 64, 3);
            PYRAMID_PQ = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("n_lGsOzYnW"), 67, 128, 3);
            SLOW = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("e*y1"), 68, 4096, 3);
            MAGIC_SHIELD = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("sGyO}YmNwCrB"), 69, 8192, 3);
            MAGIC_RESISTANCE = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("{'q/u9d#e/e2w(u#"), 70, 16384, 3);
            SOUL_STONE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("mIkJaUjIpC"), 71, 32768, 3);
            SOARING = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("5y'd/x!"), 72, 65536, 3);
            LIGHTNING_CHARGE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("rOyNjHwHyY}N\u007fTyC"), 73, 262144, 3);
            ENRAGE = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("s(d'q#"), 74, 524288, 3);
            OWL_SPIRIT = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("qQrYmVwTwR"), 75, 0x100000, 3);
            FINAL_CUT = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO(" \u007f(w*i%c2"), 76, 0x400000, 3);
            DAMAGE_BUFF = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("B\u007fK\u007fA{Y|Sx@"), 77, 0x800000, 3);
            ATTACK_BUFF = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("'b2w%}9t3p "), 78, 0x1000000, 3);
            RAINING_MINES = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("T\u007fOpOpAaKwH{U"), 79, 0x2000000, 3);
            ENHANCED_MAXHP = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("s(~'x%s\"i+w>~6"), 80, 0x4000000, 3);
            ENHANCED_MAXMP = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("{HvGpE{BaK\u007f^sV"), 81, 0x8000000, 3);
            ENHANCED_WATK = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("#x.w(u#r9a'b-"), 82, 0x10000000, 3);
            ENHANCED_MATK = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("CpN\u007fH}CzYsGjM"), 83, 0x20000000, 3);
            ENHANCED_WDEF = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("#x.w(u#r9a\"s "), 84, 0x40000000, 3);
            ENHANCED_MDEF = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("CpN\u007fH}CzYsB{@"), 85, Integer.MIN_VALUE, 3);
            PERFECT_ARMOR = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("6s4p#u2i'd+y4"), 86, 1, 4);
            SATELLITESAFE_PROC = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("mGjCrJwR{U\u007f@{YnTqE"), 87, 2, 4);
            SATELLITESAFE_ABSORB = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("e'b#z*\u007f2s5w s9w$e)d$"), 88, 4, 4);
            TORNADO = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("RqTpGzI"), 89, 8, 4);
            CRITICAL_RATE_BUFF = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("u4\u007f2\u007f%w*i4w2s9t3p "), 90, 16, 4);
            MP_BUFF = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("KnY|Sx@"), 91, 32, 4);
            DAMAGE_TAKEN_BUFF = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\"w+w!s9b'}#x9t3p "), 92, 64, 4);
            DODGE_CHANGE_BUFF = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("BqByCaEvGpA{Y|Sx@"), 93, 128, 4);
            CONVERSION = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("u)x0s4e/y("), 94, 256, 4);
            REAPER = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("lC\u007fV{T"), 95, 512, 4);
            INFILTRATE = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\u007f(p/z2d'b#"), 96, 1024, 4);
            MECH_CHANGE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("K{EvY}N\u007fHyC"), 97, 2048, 4);
            AURA = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("w3d'"), 98, 4096, 4);
            DARK_AURA = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("B\u007fTuY\u007fSlG"), 99, 8192, 4);
            BLUE_AURA = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("$z3s9w3d'"), 100, 16384, 4);
            YELLOW_AURA = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("_{JrIiY\u007fSlG"), 101, 32768, 4);
            BODY_BOOST = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("t)r?i$y)e2"), 102, 65536, 4);
            FELINE_BERSERK = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("xCrOpCaD{TmClM"), 103, 131072, 4);
            DICE_ROLL = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\"\u007f%s9d)z*"), 104, 262144, 4);
            DIVINE_SHIELD = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("BwPwH{YmNwCrB"), 105, 524288, 4);
            DAMAGE_PERCENT = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("r'{'q#i6s4u#x2"), 106, 0x100000, 4);
            TELEPORT_MASTERY = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("jCrCnIlRaK\u007fUjCl_"), 107, 0x200000, 4);
            COMBAT_ORDERS = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("%y+t'b9y4r#d5"), 108, 0x400000, 4);
            BEHOLDER = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("|CvIrB{T"), 109, 0x800000, 4);
            GIANT_POTION = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("q/w(b9f)b/y("), 110, 0x2000000, 4);
            ONYX_SHROUD = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("Ip_fYmNlIkB"), 111, 0x4000000, 4);
            ONYX_WILL = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO(")x?n9a/z*"), 112, 0x8000000, 4);
            BLESS = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("DrCmU"), 113, 0x20000000, 4);
            THREATEN_PVP = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("b.d#w2s(i6`6"), 114, 1, 5);
            ICE_KNIGHT = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("wE{YuHwAvR"), 115, 2, 5);
            STR = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("5b4"), 116, 8, 5);
            DEX = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("B{^"), 117, 16, 5);
            INT = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("/x2"), 118, 32, 5);
            LUK = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("JkM"), 119, 64, 5);
            ANGEL_ATK = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("'x!s*i'b-"), 120, 1024, 5, true);
            ANGEL_MATK = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("\u007fHyCrYsGjM"), 121, 2048, 5, true);
            HP_BOOST = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("~6i$y)e2"), 122, 4096, 5, true);
            MP_BOOST = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("sVaDqImR"), 123, 8192, 5, true);
            ANGEL_ACC = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("'x!s*i'u%"), 124, 16384, 5, true);
            ANGEL_AVOID = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("GpA{JaGhIwB"), 125, 32768, 5, true);
            ANGEL_JUMP = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("w(q#z9|3{6"), 126, 65536, 5, true);
            ANGEL_SPEED = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("GpA{JaUnC{B"), 127, 131072, 5, true);
            ANGEL_STAT = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("w(q#z9e2w2"), 128, 262144, 5, true);
            PVP_DAMAGE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("nPnYzGsGyC"), 129, 16384, 5);
            PVP_ATTACK = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("f0f9w2b'u-"), 130, 32768, 5);
            INVINCIBILITY = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("OpPwH}O|OrOj_"), 131, 65536, 5);
            HIDDEN_POTENTIAL = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("~/r\"s(i6y2s(b/w*"), 132, 131072, 5);
            ELEMENT_WEAKEN = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("{J{K{HjYiC\u007fM{H"), 133, 262144, 5);
            SNATCH = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("e(w2u."), 134, 524288, 5);
            FROZEN = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("xTq\\{H"), 135, 0x100000, 5);
            ICE_SKILL = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("/u#i5}/z*"), 136, 0x400000, 5);
            HOLY_MAGIC_SHELL = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("vIr_aK\u007fAwEaUvCrJ"), 137, 1, 6);
            ARCANE_AIM = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("w4u'x#i'\u007f+"), 138, 4, 6, true);
            ABNORMAL_STATUS_R = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("G|HqTsGrYmR\u007fRkUaT"), 139, 16, 6);
            ELEMENTAL_STATUS_R = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("s*s+s(b'z9e2w2c5i4"), 140, 32, 6);
            BUFF_MASTERY = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("|Sx@aK\u007fUjCl_"), 141, 32, 6);
            WATER_SHIELD = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("a'b#d9e.\u007f#z\""), 142, 256, 6);
            SPIRIT_SURGE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("mVwTwRaUkTyC"), 143, 512, 6);
            DARK_METAMORPHOSIS = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("r'd-i+s2w+y4f.y5\u007f5"), 144, 128, 6);
            SPIRIT_LINK = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("UnOlOjYrOpM"), 145, 4096, 6);
            VIRTUE_EFFECT = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("0\u007f4b3s9s p#u2"), 146, 16384, 6);
            NO_SLIP = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("HqYmJwV"), 147, 262144, 6);
            FAMILIAR_SHADOW = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO(" w+\u007f*\u007f'd9e.w\"y1"), 148, 524288, 6);
            SIDEKICK_PASSIVE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("mOzCuO}MaV\u007fUmOhC"), 149, 0x100000, 6);
            DEFENCE_BOOST_R = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\"s s(u#i$y)e2i4"), 150, 0x4000000, 6);
            HP_BOOST_PERCENT = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("vVaDqImRaV{T}CpR"), 151, 512, 7, true);
            MP_BOOST_PERCENT = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("{6i$y)e2i6s4u#x2"), 152, 1024, 7, true);
            ENERGY_CHARGE = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("CpClAgY}N\u007fTyC"), 153, 0x1000000, 8);
            DASH_SPEED = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("r'e.i5f#s\""), 154, 0x2000000, 8);
            DASH_JUMP = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("B\u007fUvYtSsV"), 155, 0x4000000, 8);
            MONSTER_RIDING = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("{)x5b#d9d/r/x!"), 156, 0x8000000, 8);
            SPEED_INFUSION = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("mV{CzYwHxSmOqH"), 157, 0x10000000, 8);
            HOMING_BEACON = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO(".y+\u007f(q9t#w%y("), 158, 0x20000000, 8);
            DEFAULT_BUFFSTAT = new MapleBuffStat(MaplePartyCharacter.ALLATORIxDEMO("zCxGkJjY|Sx@mR\u007fR"), 159, 0x40000000, 8);
            DEFAULT_BUFFSTAT2 = new MapleBuffStat(CashShopOperation.ALLATORIxDEMO("\"s w3z2i$c p5b'bT"), 160, Integer.MIN_VALUE, 8);
            MapleBuffStat[] arrmapleBuffStat = new MapleBuffStat[161];
            arrmapleBuffStat[0] = WATK;
            arrmapleBuffStat[1] = WDEF;
            arrmapleBuffStat[2] = MATK;
            arrmapleBuffStat[3] = MDEF;
            arrmapleBuffStat[4] = ACC;
            arrmapleBuffStat[5] = AVOID;
            arrmapleBuffStat[6] = HANDS;
            arrmapleBuffStat[7] = SPEED;
            arrmapleBuffStat[8] = JUMP;
            arrmapleBuffStat[9] = MAGIC_GUARD;
            arrmapleBuffStat[10] = DARKSIGHT;
            arrmapleBuffStat[11] = BOOSTER;
            arrmapleBuffStat[12] = POWERGUARD;
            arrmapleBuffStat[13] = MAXHP;
            arrmapleBuffStat[14] = MAXMP;
            arrmapleBuffStat[15] = INVINCIBLE;
            arrmapleBuffStat[16] = SOULARROW;
            arrmapleBuffStat[17] = STUN;
            arrmapleBuffStat[18] = POISON;
            arrmapleBuffStat[19] = SEAL;
            arrmapleBuffStat[20] = DARKNESS;
            arrmapleBuffStat[21] = COMBO;
            arrmapleBuffStat[22] = SUMMON;
            arrmapleBuffStat[23] = WK_CHARGE;
            arrmapleBuffStat[24] = DRAGONBLOOD;
            arrmapleBuffStat[25] = HOLY_SYMBOL;
            arrmapleBuffStat[26] = MESOUP;
            arrmapleBuffStat[27] = SHADOWPARTNER;
            arrmapleBuffStat[28] = PICKPOCKET;
            arrmapleBuffStat[29] = PUPPET;
            arrmapleBuffStat[30] = MESOGUARD;
            arrmapleBuffStat[31] = HP_LOSS_GUARD;
            arrmapleBuffStat[32] = WEAKEN;
            arrmapleBuffStat[33] = CURSE;
            arrmapleBuffStat[34] = MORPH;
            arrmapleBuffStat[35] = RECOVERY;
            arrmapleBuffStat[36] = MAPLE_WARRIOR;
            arrmapleBuffStat[37] = STANCE;
            arrmapleBuffStat[38] = SHARP_EYES;
            arrmapleBuffStat[39] = MANA_REFLECTION;
            arrmapleBuffStat[40] = SPIRIT_CLAW;
            arrmapleBuffStat[41] = INFINITY;
            arrmapleBuffStat[42] = HOLY_SHIELD;
            arrmapleBuffStat[43] = HAMSTRING;
            arrmapleBuffStat[44] = BLIND;
            arrmapleBuffStat[45] = CONCENTRATE;
            arrmapleBuffStat[46] = ECHO_OF_HERO;
            arrmapleBuffStat[47] = BOUNDLESS_RAGE;
            arrmapleBuffStat[48] = MESO_RATE;
            arrmapleBuffStat[49] = GHOST_MORPH;
            arrmapleBuffStat[50] = ARIANT_COSS_IMU;
            arrmapleBuffStat[51] = DROP_RATE;
            arrmapleBuffStat[52] = EXPRATE;
            arrmapleBuffStat[53] = ACASH_RATE;
            arrmapleBuffStat[54] = ILLUSION;
            arrmapleBuffStat[55] = BERSERK_FURY;
            arrmapleBuffStat[56] = DIVINE_BODY;
            arrmapleBuffStat[57] = SPARK;
            arrmapleBuffStat[58] = ARIANT_COSS_IMU2;
            arrmapleBuffStat[59] = FINALATTACK;
            arrmapleBuffStat[60] = ELEMENT_RESET;
            arrmapleBuffStat[61] = WIND_WALK;
            arrmapleBuffStat[62] = ARAN_COMBO;
            arrmapleBuffStat[63] = COMBO_DRAIN;
            arrmapleBuffStat[64] = COMBO_BARRIER;
            arrmapleBuffStat[65] = BODY_PRESSURE;
            arrmapleBuffStat[66] = SMART_KNOCKBACK;
            arrmapleBuffStat[67] = PYRAMID_PQ;
            arrmapleBuffStat[68] = SLOW;
            arrmapleBuffStat[69] = MAGIC_SHIELD;
            arrmapleBuffStat[70] = MAGIC_RESISTANCE;
            arrmapleBuffStat[71] = SOUL_STONE;
            arrmapleBuffStat[72] = SOARING;
            arrmapleBuffStat[73] = LIGHTNING_CHARGE;
            arrmapleBuffStat[74] = ENRAGE;
            arrmapleBuffStat[75] = OWL_SPIRIT;
            arrmapleBuffStat[76] = FINAL_CUT;
            arrmapleBuffStat[77] = DAMAGE_BUFF;
            arrmapleBuffStat[78] = ATTACK_BUFF;
            arrmapleBuffStat[79] = RAINING_MINES;
            arrmapleBuffStat[80] = ENHANCED_MAXHP;
            arrmapleBuffStat[81] = ENHANCED_MAXMP;
            arrmapleBuffStat[82] = ENHANCED_WATK;
            arrmapleBuffStat[83] = ENHANCED_MATK;
            arrmapleBuffStat[84] = ENHANCED_WDEF;
            arrmapleBuffStat[85] = ENHANCED_MDEF;
            arrmapleBuffStat[86] = PERFECT_ARMOR;
            arrmapleBuffStat[87] = SATELLITESAFE_PROC;
            arrmapleBuffStat[88] = SATELLITESAFE_ABSORB;
            arrmapleBuffStat[89] = TORNADO;
            arrmapleBuffStat[90] = CRITICAL_RATE_BUFF;
            arrmapleBuffStat[91] = MP_BUFF;
            arrmapleBuffStat[92] = DAMAGE_TAKEN_BUFF;
            arrmapleBuffStat[93] = DODGE_CHANGE_BUFF;
            arrmapleBuffStat[94] = CONVERSION;
            arrmapleBuffStat[95] = REAPER;
            arrmapleBuffStat[96] = INFILTRATE;
            arrmapleBuffStat[97] = MECH_CHANGE;
            arrmapleBuffStat[98] = AURA;
            arrmapleBuffStat[99] = DARK_AURA;
            arrmapleBuffStat[100] = BLUE_AURA;
            arrmapleBuffStat[101] = YELLOW_AURA;
            arrmapleBuffStat[102] = BODY_BOOST;
            arrmapleBuffStat[103] = FELINE_BERSERK;
            arrmapleBuffStat[104] = DICE_ROLL;
            arrmapleBuffStat[105] = DIVINE_SHIELD;
            arrmapleBuffStat[106] = DAMAGE_PERCENT;
            arrmapleBuffStat[107] = TELEPORT_MASTERY;
            arrmapleBuffStat[108] = COMBAT_ORDERS;
            arrmapleBuffStat[109] = BEHOLDER;
            arrmapleBuffStat[110] = GIANT_POTION;
            arrmapleBuffStat[111] = ONYX_SHROUD;
            arrmapleBuffStat[112] = ONYX_WILL;
            arrmapleBuffStat[113] = BLESS;
            arrmapleBuffStat[114] = THREATEN_PVP;
            arrmapleBuffStat[115] = ICE_KNIGHT;
            arrmapleBuffStat[116] = STR;
            arrmapleBuffStat[117] = DEX;
            arrmapleBuffStat[118] = INT;
            arrmapleBuffStat[119] = LUK;
            arrmapleBuffStat[120] = ANGEL_ATK;
            arrmapleBuffStat[121] = ANGEL_MATK;
            arrmapleBuffStat[122] = HP_BOOST;
            arrmapleBuffStat[123] = MP_BOOST;
            arrmapleBuffStat[124] = ANGEL_ACC;
            arrmapleBuffStat[125] = ANGEL_AVOID;
            arrmapleBuffStat[126] = ANGEL_JUMP;
            arrmapleBuffStat[127] = ANGEL_SPEED;
            arrmapleBuffStat[128] = ANGEL_STAT;
            arrmapleBuffStat[129] = PVP_DAMAGE;
            arrmapleBuffStat[130] = PVP_ATTACK;
            arrmapleBuffStat[131] = INVINCIBILITY;
            arrmapleBuffStat[132] = HIDDEN_POTENTIAL;
            arrmapleBuffStat[133] = ELEMENT_WEAKEN;
            arrmapleBuffStat[134] = SNATCH;
            arrmapleBuffStat[135] = FROZEN;
            arrmapleBuffStat[136] = ICE_SKILL;
            arrmapleBuffStat[137] = HOLY_MAGIC_SHELL;
            arrmapleBuffStat[138] = ARCANE_AIM;
            arrmapleBuffStat[139] = ABNORMAL_STATUS_R;
            arrmapleBuffStat[140] = ELEMENTAL_STATUS_R;
            arrmapleBuffStat[141] = BUFF_MASTERY;
            arrmapleBuffStat[142] = WATER_SHIELD;
            arrmapleBuffStat[143] = SPIRIT_SURGE;
            arrmapleBuffStat[144] = DARK_METAMORPHOSIS;
            arrmapleBuffStat[145] = SPIRIT_LINK;
            arrmapleBuffStat[146] = VIRTUE_EFFECT;
            arrmapleBuffStat[147] = NO_SLIP;
            arrmapleBuffStat[148] = FAMILIAR_SHADOW;
            arrmapleBuffStat[149] = SIDEKICK_PASSIVE;
            arrmapleBuffStat[150] = DEFENCE_BOOST_R;
            arrmapleBuffStat[151] = HP_BOOST_PERCENT;
            arrmapleBuffStat[152] = MP_BOOST_PERCENT;
            arrmapleBuffStat[153] = ENERGY_CHARGE;
            arrmapleBuffStat[154] = DASH_SPEED;
            arrmapleBuffStat[155] = DASH_JUMP;
            arrmapleBuffStat[156] = MONSTER_RIDING;
            arrmapleBuffStat[157] = SPEED_INFUSION;
            arrmapleBuffStat[158] = HOMING_BEACON;
            arrmapleBuffStat[159] = DEFAULT_BUFFSTAT;
            arrmapleBuffStat[160] = DEFAULT_BUFFSTAT2;
            ALLATORIxDEMO = arrmapleBuffStat;
        }

        public static /* synthetic */ MapleBuffStat[] values() {
            return (MapleBuffStat[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ MapleBuffStat(int n22, int n22) {
            int n3;
            void a2;
            void a3;
            void var2_-1;
            void var1_-1;
            MapleBuffStat a4;
            a4.d = false;
            void var2_3 = a3;
            void var5_4 = a2;
            int n4 = n3 = 0;
            while (n4 < 31) {
                if ((long)(1 << (int)((long)n3 % 32L)) == (long)var2_3) {
                    void var7_6 = (var5_4 - true) * 32 + n3;
                    System.out.println(a4.name() + " = " + (int)var7_6);
                }
                n4 = ++n3;
            }
            a4.K = a3;
            a4.a = a2;
        }

        public final /* synthetic */ int getValue() {
            MapleBuffStat a2;
            return a2.K;
        }
    }
}

