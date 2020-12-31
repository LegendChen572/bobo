/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import client.MapleCharacter;
import constants.GameSetConstants;
import handling.SendPacketOpcode;
import handling.world.World;
import handling.world.family.MapleFamily;
import handling.world.family.MapleFamilyBuff;
import handling.world.family.MapleFamilyCharacter;
import java.util.ArrayList;
import java.util.Iterator;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;

public class FamilyPacket {
    public /* synthetic */ FamilyPacket() {
        FamilyPacket a2;
    }

    public static /* synthetic */ void addFamilyCharInfo(MapleFamilyCharacter a2, MaplePacketLittleEndianWriter a3) {
        if (a2 == null) {
            a3.writeZeroBytes(38);
            return;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        MapleFamilyCharacter mapleFamilyCharacter = a2;
        a3.writeInt(a2.getId());
        maplePacketLittleEndianWriter.writeInt(mapleFamilyCharacter.getSeniorId());
        maplePacketLittleEndianWriter.writeShort(mapleFamilyCharacter.getJobId());
        if (GameSetConstants.MAPLE_VERSION >= 148) {
            a3.writeShort(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a3;
        MapleFamilyCharacter mapleFamilyCharacter2 = a2;
        maplePacketLittleEndianWriter2.write(mapleFamilyCharacter2.getLevel());
        maplePacketLittleEndianWriter2.write(mapleFamilyCharacter2.isOnline() ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a3;
        MapleFamilyCharacter mapleFamilyCharacter3 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a3;
        MapleFamilyCharacter mapleFamilyCharacter4 = a2;
        a3.writeInt(mapleFamilyCharacter4.getCurrentRep());
        maplePacketLittleEndianWriter4.writeInt(mapleFamilyCharacter4.getTotalRep());
        maplePacketLittleEndianWriter4.writeInt(a2.getTotalRep());
        a3.writeInt(mapleFamilyCharacter3.getTotalRep());
        maplePacketLittleEndianWriter3.writeLong(Math.max(mapleFamilyCharacter3.getChannel(), 0));
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2.getName());
    }

    public static /* synthetic */ byte[] sendFamilyMessage(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(6);
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FAMILY_RESULT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] changeRep(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FAMILY_FAMOUS_POINT_INC_RESULT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendFamilyJoinResponse(boolean a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FAMILY_JOIN_REQUEST_RESULT.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ byte[] getFamilyPedigree(MapleCharacter a) {
        block26: {
            var1_1 = new MaplePacketLittleEndianWriter();
            v0 = a;
            var1_1.writeShort(SendPacketOpcode.FAMILY_CHART_RESULT.getValue());
            var1_1.writeInt(v0.getId());
            var2_2 = World.Family.getFamily(v0.getFamilyId());
            var3_3 = 2;
            var4_5 = 0;
            var5_6 = 0;
            if (var2_2 == null) {
                var1_1.writeInt(2);
                v1 = a;
                v2 = v1;
                FamilyPacket.addFamilyCharInfo(new MapleFamilyCharacter(v1, 0, 0, 0, 0), var1_1);
            } else {
                var1_1.writeInt(var2_2.getMFC(a.getId()).getPedigree().size() + 1);
                v3 = var2_2;
                FamilyPacket.addFamilyCharInfo(v3.getMFC(v3.getLeaderId()), var1_1);
                if (a.getSeniorId() > 0) {
                    var6_7 = var2_2.getMFC(a.getSeniorId());
                    if (var6_7.getSeniorId() > 0) {
                        FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var6_7.getSeniorId()), var1_1);
                    }
                    FamilyPacket.addFamilyCharInfo((MapleFamilyCharacter)var6_7, var1_1);
                }
                v2 = a;
            }
            if (v2.getMFC() == null) {
                v4 = new MapleFamilyCharacter(a, 0, 0, 0, 0);
                v5 = var1_1;
            } else {
                v4 = a.getMFC();
                v5 = var1_1;
            }
            FamilyPacket.addFamilyCharInfo(v4, v5);
            if (var2_2 == null) break block26;
            if (a.getSeniorId() <= 0 || (var6_7 = var2_2.getMFC(a.getSeniorId())) == null) ** GOTO lbl39
            if (var6_7.getJunior1() > 0 && var6_7.getJunior1() != a.getId()) {
                v6 = a;
                FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var6_7.getJunior1()), var1_1);
            } else {
                if (var6_7.getJunior2() > 0 && var6_7.getJunior2() != a.getId()) {
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var6_7.getJunior2()), var1_1);
                }
lbl39:
                // 4 sources

                v6 = a;
            }
            if (v6.getJunior1() > 0) {
                FamilyPacket.addFamilyCharInfo(var2_2.getMFC(a.getJunior1()), var1_1);
            }
            if (a.getJunior2() > 0) {
                FamilyPacket.addFamilyCharInfo(var2_2.getMFC(a.getJunior2()), var1_1);
            }
            if (a.getJunior1() > 0) {
                var6_7 = var2_2.getMFC(a.getJunior1());
                if (var6_7.getJunior1() > 0) {
                    ++var3_3;
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var6_7.getJunior1()), var1_1);
                }
                if (var6_7.getJunior2() > 0) {
                    ++var3_3;
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var6_7.getJunior2()), var1_1);
                }
            }
            if (a.getJunior2() > 0) {
                var6_7 = var2_2.getMFC(a.getJunior2());
                if (var6_7.getJunior1() > 0) {
                    ++var3_3;
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var6_7.getJunior1()), var1_1);
                }
                if (var6_7.getJunior2() > 0) {
                    ++var3_3;
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var6_7.getJunior2()), var1_1);
                }
            }
            v7 = var2_2;
            var4_5 = v7.getGens();
            var5_6 = v7.getMemberSize();
        }
        v8 = var1_1;
        var1_1.writeLong(var3_3);
        v8.writeInt(var4_5);
        v8.writeInt(-1);
        var1_1.writeInt(var5_6);
        if (var2_2 != null) {
            if (a.getJunior1() > 0) {
                var6_7 = var2_2.getMFC(a.getJunior1());
                if (var6_7.getJunior1() > 0) {
                    v9 = var1_1;
                    v9.writeInt(var6_7.getJunior1());
                    v9.writeInt(var2_2.getMFC(var6_7.getJunior1()).getDescendants());
                }
                if (var6_7.getJunior2() > 0) {
                    v10 = var1_1;
                    v10.writeInt(var6_7.getJunior2());
                    v10.writeInt(var2_2.getMFC(var6_7.getJunior2()).getDescendants());
                }
            }
            if (a.getJunior2() > 0) {
                var6_7 = var2_2.getMFC(a.getJunior2());
                if (var6_7.getJunior1() > 0) {
                    v11 = var1_1;
                    v11.writeInt(var6_7.getJunior1());
                    v11.writeInt(var2_2.getMFC(var6_7.getJunior1()).getDescendants());
                }
                if (var6_7.getJunior2() > 0) {
                    v12 = var1_1;
                    v12.writeInt(var6_7.getJunior2());
                    v12.writeInt(var2_2.getMFC(var6_7.getJunior2()).getDescendants());
                }
            }
        }
        v13 = var6_7 = a.usedBuffs();
        var1_1.writeInt(v13.size());
        v14 = var2_2 = v13.iterator();
        while (true) {
            if (!v14.hasNext()) {
                v15 = var1_1;
                v15.writeShort(2);
                return v15.getPacket();
            }
            var3_4 = (Pair)var2_2.next();
            var1_1.writeInt((Integer)var3_4.getLeft());
            var1_1.writeInt((Integer)var3_4.getRight());
            v14 = var2_2;
        }
    }

    public static /* synthetic */ byte[] getFamilyData() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FAMILY_PRIVILEGE_LIST.getValue());
        Object object = MapleFamilyBuff.getBuffEntry();
        maplePacketLittleEndianWriter.writeInt(object.size());
        Object object2 = object = object.iterator();
        while (object2.hasNext()) {
            MapleFamilyBuff.MapleFamilyBuffEntry mapleFamilyBuffEntry = (MapleFamilyBuff.MapleFamilyBuffEntry)object.next();
            object2 = object;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleFamilyBuff.MapleFamilyBuffEntry mapleFamilyBuffEntry2 = mapleFamilyBuffEntry;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.write(mapleFamilyBuffEntry.type);
            maplePacketLittleEndianWriter3.writeInt(mapleFamilyBuffEntry.rep);
            maplePacketLittleEndianWriter.writeInt(mapleFamilyBuffEntry2.count);
            maplePacketLittleEndianWriter2.writeMapleAsciiString(mapleFamilyBuffEntry2.name);
            maplePacketLittleEndianWriter2.writeMapleAsciiString(mapleFamilyBuffEntry.desc);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getSeniorMessage(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FAMILY_JOIN_ACCEPTED.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] familyLoggedIn(boolean a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FAMILY_NOTIFY_LOGIN_OR_LOGOUT.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ byte[] getFamilyPedigreeA(MapleCharacter a) {
        block26: {
            var1_1 = new MaplePacketLittleEndianWriter();
            v0 = a;
            var1_1.writeShort(SendPacketOpcode.FAMILY_CHART_RESULT.getValue());
            var1_1.writeInt(v0.getId());
            var2_2 = World.Family.getFamily(v0.getFamilyId());
            var3_3 = 2;
            var3_3 = 0;
            var4_5 = 0;
            if (var2_2 == null) {
                var1_1.writeInt(2);
                v1 = a;
                v2 = v1;
                FamilyPacket.addFamilyCharInfo(new MapleFamilyCharacter(v1, 0, 0, 0, 0), var1_1);
            } else {
                var1_1.writeInt(var2_2.getMFC(a.getId()).getPedigree().size() + 1);
                v3 = var2_2;
                FamilyPacket.addFamilyCharInfo(v3.getMFC(v3.getLeaderId()), var1_1);
                if (a.getSeniorId() > 0 && (var5_6 = var2_2.getMFC(a.getSeniorId())) != null) {
                    if (var5_6.getSeniorId() > 0) {
                        FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var5_6.getSeniorId()), var1_1);
                    }
                    FamilyPacket.addFamilyCharInfo((MapleFamilyCharacter)var5_6, var1_1);
                }
                v2 = a;
            }
            if (v2.getMFC() == null) {
                v4 = new MapleFamilyCharacter(a, 0, 0, 0, 0);
                v5 = var1_1;
            } else {
                v4 = a.getMFC();
                v5 = var1_1;
            }
            FamilyPacket.addFamilyCharInfo(v4, v5);
            if (var2_2 == null) break block26;
            if (a.getSeniorId() <= 0 || (var5_6 = var2_2.getMFC(a.getSeniorId())) == null) ** GOTO lbl38
            if (var5_6.getJunior1() >= 0 && var5_6.getJunior1() != a.getId()) {
                v6 = a;
                FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var5_6.getJunior1()), var1_1);
            } else {
                if (var5_6.getJunior2() > 0) {
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var5_6.getJunior2()), var1_1);
                }
lbl38:
                // 4 sources

                v6 = a;
            }
            if (v6.getJunior1() > 0 && (var5_6 = var2_2.getMFC(a.getJunior1())) != null) {
                FamilyPacket.addFamilyCharInfo((MapleFamilyCharacter)var5_6, var1_1);
            }
            if (a.getJunior2() > 0 && (var5_6 = var2_2.getMFC(a.getJunior2())) != null) {
                FamilyPacket.addFamilyCharInfo((MapleFamilyCharacter)var5_6, var1_1);
            }
            if (a.getJunior1() > 0 && (var5_6 = var2_2.getMFC(a.getJunior1())) != null) {
                if (var5_6.getJunior1() > 0 && var2_2.getMFC(var5_6.getJunior1()) != null) {
                    ++var3_3;
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var5_6.getJunior1()), var1_1);
                }
                if (var5_6.getJunior2() > 0 && var2_2.getMFC(var5_6.getJunior2()) != null) {
                    ++var3_3;
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var5_6.getJunior2()), var1_1);
                }
            }
            if (a.getJunior2() > 0 && (var5_6 = var2_2.getMFC(a.getJunior2())) != null) {
                if (var5_6.getJunior1() > 0 && var2_2.getMFC(var5_6.getJunior1()) != null) {
                    ++var3_3;
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var5_6.getJunior1()), var1_1);
                }
                if (var5_6.getJunior2() > 0 && var2_2.getMFC(var5_6.getJunior2()) != null) {
                    FamilyPacket.addFamilyCharInfo(var2_2.getMFC(var5_6.getJunior2()), var1_1);
                }
            }
            var4_5 = var2_2.getMemberSize();
        }
        v7 = var1_1;
        v8 = ++var3_3;
        var1_1.writeLong(2 + v8);
        v7.writeInt(v8);
        v7.writeInt(-1);
        var1_1.writeInt(var4_5);
        if (var2_2 != null) {
            if (a.getJunior1() > 0 && (var5_6 = var2_2.getMFC(a.getJunior1())) != null) {
                if (var5_6.getJunior1() > 0 && var2_2.getMFC(var5_6.getJunior1()) != null) {
                    v9 = var1_1;
                    v9.writeInt(var5_6.getJunior1());
                    v9.writeInt(var2_2.getMFC(var5_6.getJunior1()).getDescendants());
                }
                if (var5_6.getJunior2() > 0 && var2_2.getMFC(var5_6.getJunior2()) != null) {
                    v10 = var1_1;
                    v10.writeInt(var5_6.getJunior2());
                    v10.writeInt(var2_2.getMFC(var5_6.getJunior2()).getDescendants());
                }
            }
            if (a.getJunior2() > 0 && (var5_6 = var2_2.getMFC(a.getJunior2())) != null) {
                if (var5_6.getJunior1() > 0 && var2_2.getMFC(var5_6.getJunior1()) != null) {
                    v11 = var1_1;
                    v11.writeInt(var5_6.getJunior1());
                    v11.writeInt(var2_2.getMFC(var5_6.getJunior1()).getDescendants());
                }
                if (var5_6.getJunior2() > 0 && var2_2.getMFC(var5_6.getJunior2()) != null) {
                    v12 = var1_1;
                    v12.writeInt(var5_6.getJunior2());
                    v12.writeInt(var2_2.getMFC(var5_6.getJunior2()).getDescendants());
                }
            }
        }
        v13 = var5_6 = a.usedBuffs();
        var1_1.writeInt(v13.size());
        v14 = var2_2 = v13.iterator();
        while (true) {
            if (!v14.hasNext()) {
                v15 = var1_1;
                v15.writeShort(2);
                v15.writeZeroBytes(30);
                return var1_1.getPacket();
            }
            var3_4 = (Pair)var2_2.next();
            var1_1.writeInt((Integer)var3_4.getLeft());
            var1_1.writeInt((Integer)var3_4.getRight());
            v14 = var2_2;
        }
    }

    public static /* synthetic */ byte[] familySummonRequest(String a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FAMILY_SUMMON_REQUEST.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] familyBuff(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        int n2 = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FAMILY_SET_PRIVILEGE.getValue());
        maplePacketLittleEndianWriter.write(n2);
        if (n2 >= 2 && a2 <= 4) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter2.writeInt(a3);
            maplePacketLittleEndianWriter2.writeInt(a2 == 3 ? 0 : a4);
            maplePacketLittleEndianWriter.writeInt(a2 == 2 ? 0 : a4);
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.write(0);
            maplePacketLittleEndianWriter3.writeInt(a5);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] cancelFamilyBuff() {
        return FamilyPacket.familyBuff(0, 0, 0, 0);
    }

    public static /* synthetic */ byte[] getFamilyInfo(MapleCharacter a2) {
        MapleCharacter mapleCharacter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleCharacter mapleCharacter2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MapleCharacter mapleCharacter3 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FAMILY_INFO_RESULT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getCurrentRep());
        maplePacketLittleEndianWriter3.writeInt(a2.getTotalRep());
        maplePacketLittleEndianWriter.writeInt(mapleCharacter3.getTotalRep());
        maplePacketLittleEndianWriter2.writeShort(mapleCharacter3.getNoJuniors());
        maplePacketLittleEndianWriter2.writeShort(2);
        maplePacketLittleEndianWriter.writeShort(mapleCharacter2.getNoJuniors());
        Iterator iterator = World.Family.getFamily(mapleCharacter2.getFamilyId());
        if (iterator != null) {
            mapleCharacter = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MapleFamily mapleFamily = iterator;
            maplePacketLittleEndianWriter.writeInt(mapleFamily.getLeaderId());
            maplePacketLittleEndianWriter4.writeMapleAsciiString(mapleFamily.getLeaderName());
            maplePacketLittleEndianWriter4.writeMapleAsciiString(((MapleFamily)((Object)iterator)).getNotice());
        } else {
            maplePacketLittleEndianWriter.writeLong(0L);
            mapleCharacter = a2;
        }
        Iterator iterator2 = iterator = mapleCharacter.usedBuffs();
        maplePacketLittleEndianWriter.writeInt(iterator2.size());
        Iterator iterator3 = iterator = iterator2.iterator();
        while (iterator3.hasNext()) {
            Pair pair = (Pair)iterator.next();
            maplePacketLittleEndianWriter.writeInt((Integer)pair.getLeft());
            maplePacketLittleEndianWriter.writeInt((Integer)pair.getRight());
            iterator3 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 1 << 1;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 1 << 1;
        int n5 = n3;
        int n6 = 4 << 3 ^ 2;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ byte[] getFamilyResult(MapleCharacter a) {
        block24: {
            var1_1 = World.Family.getFamily(a.getFamilyId());
            var2_2 = new ArrayList<MapleFamilyCharacter>();
            var3_3 = 2;
            if (var1_1 == null) {
                v0 = var2_2;
                v1 = v0;
                v0.add(new MapleFamilyCharacter(a, 0, 0, 0, 0));
            } else {
                v2 = var1_1;
                var2_2.add(v2.getMFC(v2.getLeaderId()));
                if (a.getSeniorId() > 0) {
                    var2_2.add(var1_1.getMFC(a.getSeniorId()));
                }
                v1 = var2_2;
            }
            v1.add(a.getMFC() == null ? new MapleFamilyCharacter(a, 0, 0, 0, 0) : a.getMFC());
            if (var1_1 == null) break block24;
            if (a.getSeniorId() <= 0 || (var4_4 = var1_1.getMFC(a.getSeniorId())) == null) ** GOTO lbl31
            if (var4_4.getJunior1() > 0 && var4_4.getJunior1() != a.getId()) {
                v3 = a;
                var2_2.add(var1_1.getMFC(var4_4.getJunior1()));
            } else {
                if (var4_4.getJunior2() > 0 && var4_4.getJunior2() != a.getId()) {
                    var2_2.add(var1_1.getMFC(var4_4.getJunior1()));
                }
lbl31:
                // 4 sources

                v3 = a;
            }
            if (v3.getJunior1() > 0) {
                var2_2.add(var1_1.getMFC(a.getJunior1()));
            }
            if (a.getJunior2() > 0) {
                var2_2.add(var1_1.getMFC(a.getJunior2()));
            }
            if (a.getJunior1() > 0) {
                var4_4 = var1_1.getMFC(a.getJunior1());
                if (var4_4.getJunior1() > 0) {
                    ++var3_3;
                    var2_2.add(var1_1.getMFC(var4_4.getJunior1()));
                }
                if (var4_4.getJunior2() > 0) {
                    ++var3_3;
                    var2_2.add(var1_1.getMFC(var4_4.getJunior2()));
                }
            }
            if (a.getJunior2() > 0) {
                var4_4 = var1_1.getMFC(a.getJunior2());
                if (var4_4.getJunior1() > 0) {
                    ++var3_3;
                    var2_2.add(var1_1.getMFC(var4_4.getJunior1()));
                }
                if (var4_4.getJunior2() > 0) {
                    ++var3_3;
                    var2_2.add(var1_1.getMFC(var4_4.getJunior2()));
                }
            }
        }
        var4_4 = new MaplePacketLittleEndianWriter();
        v4 = var2_2;
        v5 = var4_4;
        v5.writeShort(SendPacketOpcode.FAMILY_CHART_RESULT.getValue());
        v5.writeInt(a.getId());
        var4_4.writeInt(v4.size());
        v6 = var2_2 = v4.iterator();
        while (v6.hasNext()) {
            var5_5 = (MapleFamilyCharacter)var2_2.next();
            v6 = var2_2;
            FamilyPacket.addFamilyCharInfo((MapleFamilyCharacter)var5_5, (MaplePacketLittleEndianWriter)var4_4);
        }
        var4_4.writeLong(var3_3);
        var4_4.writeInt(var1_1 == null ? 0 : var1_1.getGens());
        v7 = var4_4;
        v7.writeInt(-1);
        v7.writeInt(var1_1 == null ? 0 : var1_1.getMemberSize());
        if (var1_1 != null) {
            if (a.getJunior1() > 0) {
                var2_2 = var1_1.getMFC(a.getJunior1());
                if (var2_2.getJunior1() > 0) {
                    v8 = var4_4;
                    v8.writeInt(var2_2.getJunior1());
                    v8.writeInt(var1_1.getMFC(var2_2.getJunior1()).getDescendants());
                }
                if (var2_2.getJunior2() > 0) {
                    v9 = var4_4;
                    v9.writeInt(var2_2.getJunior2());
                    v9.writeInt(var1_1.getMFC(var2_2.getJunior2()).getDescendants());
                }
            }
            if (a.getJunior2() > 0) {
                var2_2 = var1_1.getMFC(a.getJunior2());
                if (var2_2.getJunior1() > 0) {
                    v10 = var4_4;
                    v10.writeInt(var2_2.getJunior1());
                    v10.writeInt(var1_1.getMFC(var2_2.getJunior1()).getDescendants());
                }
                if (var2_2.getJunior2() > 0) {
                    v11 = var4_4;
                    v11.writeInt(var2_2.getJunior2());
                    v11.writeInt(var1_1.getMFC(var2_2.getJunior2()).getDescendants());
                }
            }
        }
        var2_2 = a.usedBuffs();
        v12 = var2_2;
        var4_4.writeInt(v12.size());
        v13 = var5_5 = v12.iterator();
        while (true) {
            if (!v13.hasNext()) {
                v14 = var4_4;
                v14.writeShort(2);
                v14.writeZeroBytes(30);
                return var4_4.getPacket();
            }
            var1_1 = (Pair)var5_5.next();
            var4_4.writeInt((Integer)var1_1.getLeft());
            var4_4.writeInt((Integer)var1_1.getRight());
            v13 = var5_5;
        }
    }

    public static /* synthetic */ byte[] sendFamilyInvite(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FAMILY_JOIN_REQUEST.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(a2.getLevel());
            maplePacketLittleEndianWriter3.writeInt(a2.getJob());
            if (GameSetConstants.MAPLE_VERSION >= 148) {
                maplePacketLittleEndianWriter.writeInt(a2.getSubcategory());
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a2.getName());
        return maplePacketLittleEndianWriter4.getPacket();
    }
}

