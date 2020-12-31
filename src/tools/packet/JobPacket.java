/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import client.ISkill;
import client.MapleCharacter;
import constants.GameSetConstants;
import constants.SkillConstants;
import handling.SendPacketOpcode;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.SpecialEffect;
import java.util.ArrayList;
import java.util.Iterator;
import server.Randomizer;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.PacketHelper;

public class JobPacket {
    public /* synthetic */ JobPacket() {
        JobPacket a2;
    }

    public static class LuminousPacket {
        public /* synthetic */ LuminousPacket() {
            LuminousPacket a2;
        }

        public static /* synthetic */ byte[] updateLuminousGauge(int a2, int a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.LUMINOUS_COMBO.getValue());
            maplePacketLittleEndianWriter2.writeInt(a2);
            maplePacketLittleEndianWriter2.write(a3);
            return maplePacketLittleEndianWriter2.getPacket();
        }
    }

    public static class ShadowerPacket {
        public static /* synthetic */ byte[] giveKilling(int a2, int a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
            maplePacketLittleEndianWriter3.writeInt(a2);
            PacketHelper.writeBuffState(maplePacketLittleEndianWriter3, MapleBuffStat.KILLING_POINT);
            maplePacketLittleEndianWriter2.write(a3);
            maplePacketLittleEndianWriter2.writeZeroBytes(30);
            return maplePacketLittleEndianWriter2.getPacket();
        }

        public /* synthetic */ ShadowerPacket() {
            ShadowerPacket a2;
        }

        public static /* synthetic */ byte[] giveKilling(int a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
            PacketHelper.writeBuffState(maplePacketLittleEndianWriter4, MapleBuffStat.KILLING_POINT);
            maplePacketLittleEndianWriter3.writeShort(0);
            maplePacketLittleEndianWriter3.write(0);
            maplePacketLittleEndianWriter2.writeInt(a2);
            maplePacketLittleEndianWriter2.writeZeroBytes(20);
            return maplePacketLittleEndianWriter2.getPacket();
        }
    }

    public static class AngelicPacket {
        public static /* synthetic */ byte[] unlockSkill() {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UNLOCK_CHARGE_SKILL.getValue());
            return maplePacketLittleEndianWriter.getPacket();
        }

        public static /* synthetic */ byte[] showRechargeEffect() {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
            maplePacketLittleEndianWriter.write(SpecialEffect.RECHARGE_STATE.getValue());
            return maplePacketLittleEndianWriter.getPacket();
        }

        public static /* synthetic */ byte[] updateDress(int a2, MapleCharacter a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ANGELIC_CHANGE.getValue());
            maplePacketLittleEndianWriter2.writeInt(a3.getId());
            maplePacketLittleEndianWriter2.writeInt(a2);
            return maplePacketLittleEndianWriter2.getPacket();
        }

        public static /* synthetic */ byte[] DressUpTime(byte a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
            maplePacketLittleEndianWriter3.write(a2);
            maplePacketLittleEndianWriter2.writeShort(7707);
            maplePacketLittleEndianWriter.write(2);
            maplePacketLittleEndianWriter2.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
            return maplePacketLittleEndianWriter.getPacket();
        }

        public /* synthetic */ AngelicPacket() {
            AngelicPacket a2;
        }

        public static /* synthetic */ byte[] lockSkill(int a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.LOCK_CHARGE_SKILL.getValue());
            maplePacketLittleEndianWriter2.writeInt(a2);
            return maplePacketLittleEndianWriter2.getPacket();
        }
    }

    public static class PhantomPacket {
        public /* synthetic */ PhantomPacket() {
            PhantomPacket a2;
        }

        public static /* synthetic */ byte[] viewSkills(MapleCharacter a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.TARGET_SKILL.getValue());
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            Iterator<ISkill> iterator = a2.getSkills().keySet().iterator();
            while (iterator.hasNext()) {
                ISkill iSkill;
                ISkill iSkill2 = iSkill = iterator.next();
                int n2 = iSkill2.getId();
                if (!iSkill2.canBeLearnedBy(a2.getJob()) || !SkillConstants.canSteal(iSkill) || arrayList.contains(n2) || a2.getSkillLevel(n2) <= 0) continue;
                arrayList.add(n2);
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter2.write(1);
            maplePacketLittleEndianWriter2.writeInt(a2.getId());
            maplePacketLittleEndianWriter.writeInt(arrayList.isEmpty() ? 2 : 4);
            ArrayList<Integer> arrayList2 = arrayList;
            maplePacketLittleEndianWriter.writeInt(a2.getJob());
            maplePacketLittleEndianWriter.writeInt(arrayList2.size());
            iterator = arrayList2.iterator();
            Iterator<Object> iterator2 = iterator;
            while (iterator2.hasNext()) {
                int n3 = (Integer)((Object)iterator.next());
                iterator2 = iterator;
                maplePacketLittleEndianWriter.writeInt(n3);
            }
            return maplePacketLittleEndianWriter.getPacket();
        }

        public static /* synthetic */ byte[] removeStolenSkill(int a2, int a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.UPDATE_STOLEN_SKILLS.getValue());
            maplePacketLittleEndianWriter4.write(1);
            maplePacketLittleEndianWriter3.write(3);
            maplePacketLittleEndianWriter3.writeInt(a2);
            maplePacketLittleEndianWriter2.writeInt(a3);
            maplePacketLittleEndianWriter2.write(0);
            return maplePacketLittleEndianWriter2.getPacket();
        }

        public static /* synthetic */ byte[] addStolenSkill(int a2, int a3, int a4, int a5) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_STOLEN_SKILLS.getValue());
            maplePacketLittleEndianWriter5.write(1);
            maplePacketLittleEndianWriter5.write(0);
            maplePacketLittleEndianWriter4.writeInt(a2);
            maplePacketLittleEndianWriter4.writeInt(a3);
            maplePacketLittleEndianWriter3.writeInt(a4);
            maplePacketLittleEndianWriter3.writeInt(a5);
            maplePacketLittleEndianWriter2.writeInt(0);
            maplePacketLittleEndianWriter2.write(0);
            return maplePacketLittleEndianWriter2.getPacket();
        }

        public static /* synthetic */ byte[] replaceStolenSkill(int a2, int a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REPLACE_SKILLS.getValue());
            maplePacketLittleEndianWriter2.write(1);
            maplePacketLittleEndianWriter2.write(a3 > 0 ? 1 : 0);
            maplePacketLittleEndianWriter.writeInt(a2);
            if (a3 > 0) {
                maplePacketLittleEndianWriter.writeInt(a3);
            }
            return maplePacketLittleEndianWriter.getPacket();
        }

        public static /* synthetic */ byte[] updateCardStack(int a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PHANTOM_CARD.getValue());
            maplePacketLittleEndianWriter2.write(a2);
            return maplePacketLittleEndianWriter2.getPacket();
        }

        public static /* synthetic */ byte[] gainCardStack(int a2, int a3, int a4, int a5, int a6, int a7) {
            int n2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            if (GameSetConstants.MAPLE_VERSION >= 151) {
                int n3;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GAIN_FORCE.getValue());
                maplePacketLittleEndianWriter4.write(0);
                maplePacketLittleEndianWriter4.writeInt(a2);
                maplePacketLittleEndianWriter3.writeInt(1);
                maplePacketLittleEndianWriter3.write(1);
                maplePacketLittleEndianWriter2.writeInt(a2);
                maplePacketLittleEndianWriter2.writeInt(a5);
                int n4 = n3 = 0;
                while (n4 < a7) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter5.write(1);
                    maplePacketLittleEndianWriter5.writeInt(a6 == 0 ? a3 + n3 : a3);
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter.writeInt(a4);
                    maplePacketLittleEndianWriter7.writeInt(Randomizer.rand(15, 29));
                    maplePacketLittleEndianWriter7.writeInt(Randomizer.rand(7, 11));
                    maplePacketLittleEndianWriter6.writeInt(Randomizer.rand(0, 9));
                    maplePacketLittleEndianWriter6.writeInt(0);
                    n4 = ++n3;
                }
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter8.write(0);
                maplePacketLittleEndianWriter8.writeZeroBytes(20);
                return maplePacketLittleEndianWriter.getPacket();
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GAIN_FORCE.getValue());
            maplePacketLittleEndianWriter10.write(0);
            maplePacketLittleEndianWriter10.writeInt(a2);
            maplePacketLittleEndianWriter9.writeInt(1);
            maplePacketLittleEndianWriter9.writeInt(a6);
            maplePacketLittleEndianWriter.writeInt(a5);
            int n5 = n2 = 0;
            while (n5 < a7) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter11.write(1);
                maplePacketLittleEndianWriter11.writeInt(a6 == 0 ? a3 + n2 : a3);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter13.writeInt(a4);
                maplePacketLittleEndianWriter13.writeInt(Randomizer.rand(15, 29));
                maplePacketLittleEndianWriter12.writeInt(Randomizer.rand(7, 11));
                maplePacketLittleEndianWriter12.writeInt(Randomizer.rand(0, 9));
                n5 = ++n2;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter14 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter14.write(0);
            maplePacketLittleEndianWriter14.writeZeroBytes(20);
            return maplePacketLittleEndianWriter.getPacket();
        }
    }
}

