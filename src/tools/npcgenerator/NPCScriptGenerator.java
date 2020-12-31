/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 *  org.apache.commons.codec.DecoderException
 */
package tools.npcgenerator;

import FuckingHackerToby.L;
import client.messages.commands.player.\u53ef\u53ef\u8c37;
import handling.channel.handler.BuddyListHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.DecoderException;
import tools.npcgenerator.Condition;
import tools.npcgenerator.Instruction;
import tools.npcgenerator.Location;
import tools.npcgenerator.Mesos;
import tools.npcgenerator.NPC;
import tools.npcgenerator.NPCMessage;
import tools.npcgenerator.Reader;
import tools.npcgenerator.Warp;

public class NPCScriptGenerator {
    private /* synthetic */ boolean k;
    private /* synthetic */ int g;
    private /* synthetic */ boolean K;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ boolean a;
    private /* synthetic */ boolean B;
    private /* synthetic */ int d;
    private /* synthetic */ L H;
    private /* synthetic */ int E;
    private /* synthetic */ Map<Integer, NPC> e;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void E() {
        a.l();
        var1_1 = BuddyListHandler.ALLATORIxDEMO("^\u001cJ\u0016Y\u001c_\u0003IYN\u000fN");
        try {
            var3_2 = new BufferedReader(new FileReader(var1_1));
            try {
                a.H();
                var5_5 /* !! */  = new LinkedList<Instruction>();
lbl8:
                // 6 sources

                while (true) {
                    v0 = var3_2;
lbl10:
                    // 13 sources

                    while ((var4_8 = v0.readLine()) != null) {
                        if (!var4_8.contains(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0004i9x"))) ** GOTO lbl-1000
                        if (var4_8.contains(BuddyListHandler.ALLATORIxDEMO("t'y(n6v<\u001a"))) {
                            v0 = var3_2;
                            v1 = a;
                            v1.B = true;
                            v1.E = 0;
                            continue;
                        }
                        ** GOTO lbl-1000
                    }
                    ** GOTO lbl176
                    break;
                }
            }
            catch (Throwable var4_9) {
                try {
                    var3_2.close();
                    v2 = var4_9;
                    throw v2;
                }
                catch (Throwable var5_6) {
                    v3 = var4_9;
                    v2 = v3;
                    v3.addSuppressed(var5_6);
                }
                throw v2;
            }
        }
        catch (IOException var3_3) {
            System.err.println("Error while reading the file " + var1_1 + ".");
            return;
        }
        catch (DecoderException var3_4) {
            System.err.println("Error while trying to decode string in file " + var1_1 + ".");
            return;
        }
lbl-1000:
        // 1 sources

        {
            if (!var4_8.contains(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0019\\\u0014S\u0003M\u001bG\bA\u0018^\u0012,")) || !a.B) ** GOTO lbl8
            v0 = var3_2;
            a.k = true;
            ** GOTO lbl10
        }
lbl-1000:
        // 1 sources

        {
            block30: {
                block35: {
                    block34: {
                        block33: {
                            block32: {
                                block31: {
                                    block29: {
                                        block28: {
                                            block27: {
                                                if (a.a) {
                                                    var6_10 = var4_8.length() > 200 ? 1 : 0;
                                                    var2_7 = new Reader(var4_8);
                                                    var2_7.skip(2);
                                                    var7_11 = var2_7.readInt();
                                                    v4 = var2_7;
                                                    if (var6_10 == 0) {
                                                        v4.skip(5);
                                                        v5 = a;
                                                        var8_13 = var2_7.readInt();
                                                    } else {
                                                        v4.skip(109);
                                                        v5 = a;
                                                        var8_13 = var2_7.readInt();
                                                    }
                                                    v5.H = new L();
                                                    v6 = a;
                                                    v6.H.H(var8_13);
                                                    v6.H.ALLATORIxDEMO(var7_11 + 1);
                                                    v6.a = false;
                                                }
                                                if (!a.k) break block27;
                                                v7 = var2_7 = new Reader(var4_8);
                                                v7.skip(2);
                                                var6_10 = v7.readByte();
                                                a.B = var2_7.readByte() == 1;
                                                switch (var6_10) {
                                                    case 2: {
                                                        var7_12 = var2_7.readMapleString();
                                                        v8 = a;
                                                        break;
                                                    }
                                                    case 3: 
                                                    case 4: {
                                                        a.ALLATORIxDEMO = var8_13 = var2_7.readInt();
                                                    }
                                                    default: {
                                                        v8 = a;
                                                    }
                                                }
                                                v8.k = false;
                                                v0 = var3_2;
                                                ** GOTO lbl10
                                            }
                                            if (a.d <= -1) break block28;
                                            var2_7 = new Reader(var4_8);
                                            switch (a.d) {
                                                case 0: {
                                                    v9 = var2_7;
                                                    v9.skip(11);
                                                    var6_10 = v9.readInt();
                                                    var7_11 = v9.readByte();
                                                    v10 = var8_14 = new Warp();
                                                    v10.setMapId(var6_10);
                                                    v10.setSpawnPoint((short)var7_11);
                                                    var5_5 /* !! */ .add(v10);
                                                    v11 = a;
                                                    v11.ALLATORIxDEMO(var5_5 /* !! */ );
                                                    var5_5 /* !! */  = new LinkedList<E>();
                                                    v11.H();
                                                    v12 = a;
                                                    break;
                                                }
                                                case 1: {
                                                    var9_16 = var2_7.readByte();
                                                    if (var9_16 == 5) {
                                                        var10_17 = var2_7.readInt();
                                                        var11_19 = new Mesos();
                                                        v12 = a;
                                                        v13 = var11_19;
                                                        v13.setAmount(var10_17);
                                                        var5_5 /* !! */ .add(v13);
                                                        break;
                                                    }
                                                    if (var9_16 == 0) {
                                                        // empty if block
                                                    }
                                                }
                                                default: {
                                                    v12 = a;
                                                }
                                            }
                                            v12.d = -1;
                                            v0 = var3_2;
                                            ** GOTO lbl10
                                        }
                                        if (a.B || !var4_8.contains(BuddyListHandler.ALLATORIxDEMO("%_\u0014_\u001eL\u0012^"))) break block29;
                                        if (!var4_8.contains(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0000M\u0005\\\bX\u0018S\u001aM\u0007,"))) ** GOTO lbl8
                                        v0 = var3_2;
                                        a.a = true;
                                        ** GOTO lbl10
                                    }
                                    if (!a.B) ** GOTO lbl8
                                    if (!var4_8.contains(BuddyListHandler.ALLATORIxDEMO("%_\u0014_\u001eL\u0012^"))) break block30;
                                    if (!var4_8.contains(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"B\u0007O\bX\u0016@\u001c,"))) break block31;
                                    v0 = var3_2;
                                    a.K = true;
                                    ** GOTO lbl10
                                }
                                if (!var4_8.contains(BuddyListHandler.ALLATORIxDEMO(" {%j(n8e:{'\u001a"))) break block32;
                                v0 = var3_2;
                                a.d = 0;
                                ** GOTO lbl10
                            }
                            if (!var4_8.contains(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"_\u001fC\u0000S\u0004X\u0016X\u0002_\bE\u0019J\u0018,"))) break block33;
                            v0 = var3_2;
                            a.d = 1;
                            ** GOTO lbl10
                        }
                        if (!var4_8.contains(BuddyListHandler.ALLATORIxDEMO("8j2t(t'y(i?u'\u001a"))) break block34;
                        v0 = var3_2;
                        a.H();
                        ** GOTO lbl10
                    }
                    if (!var4_8.contains(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"Y\u0007H\u0016X\u0012S\u0004G\u001e@\u001b_"))) break block35;
                    v0 = var3_2;
                    a.H();
                    ** GOTO lbl10
                }
                if (!var4_8.contains(BuddyListHandler.ALLATORIxDEMO("8j2t(i#u%{0\u007f"))) ** GOTO lbl8
                v0 = var3_2;
                a.H();
                ** GOTO lbl10
            }
            if (!a.K) ** continue;
            var2_7 = new Reader(var4_8);
            var2_7.skip(3);
            var6_10 = var2_7.readInt();
            var7_11 = var2_7.readByte();
            var2_7.skip(1);
            var8_15 = var2_7.readMapleString();
            var9_16 = 0;
            if (var7_11 == 0) {
                var9_16 = (byte)(var9_16 | var2_7.readByte() << 1);
                var9_16 = (byte)(var9_16 | var2_7.readByte());
            }
            a.g = var6_10;
            v14 = a;
            (a.e.containsKey(var6_10) != false ? a.e.get(var6_10) : new NPC(var6_10)).applyConversation(v14.E, v14.H, var7_11, var8_15, var9_16, a.ALLATORIxDEMO, var5_5 /* !! */ );
            a.e.put(var6_10, var10_18);
            ++a.E;
            var5_5 /* !! */  = new LinkedList<E>();
            a.K = false;
            v0 = var3_2;
            ** GOTO lbl10
lbl176:
            // 1 sources

            v15 = a;
            v15.D();
            v15.ALLATORIxDEMO();
        }
        var3_2.close();
    }

    private /* synthetic */ void D() {
        NPCScriptGenerator a2;
        Iterator<NPC> iterator;
        Iterator<NPC> iterator2 = iterator = a2.e.values().iterator();
        while (iterator2.hasNext()) {
            iterator.next().adjustConditions();
            iterator2 = iterator;
        }
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0006t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/]/w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,t\u0006t,w,w,w,w/t,t,w,t,w,w/t,t/t,t/t,t/w,t/t,w,w,w,w/]/w,w,w,w/w/w/w,w/w,w/w/w,t,w/w/w/w/w,t,w,w,w,w,t\u0006t,w,w,w,t/t,t,w,t,w,t/t,w/w,t,t,t/w,w/w,w,w,w,w/]/w,w,w,w/w/w/t/w/t/w/w/w,t,w/t/w/w/w/t/w,w,w,w,t\u0006t,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w/]/wC5j\"\u007f4m#e8bwn.,\u0016`;m#c%ewC5j\"\u007f4m#c%,!;y?wH\u0012A\u0018,t\u0006t,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w/]/w,w,w,w,w,wd#x'6x# { \"6`;m#c%eyo8aw,w,w,w,w,w,t\u0006t,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w/]/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t/t\u0006"));
        new NPCScriptGenerator().E();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private /* synthetic */ void ALLATORIxDEMO() {
        var1_1 = a.e.values().iterator();
        block9: while (true) {
            block26: {
                if (var1_1.hasNext() == false) return;
                var2_2 = var1_1.next();
                var3_3 = var2_2.getId() + ".txt";
                try {
                    var4_4 = new BufferedWriter(new FileWriter(var3_3));
                    var5_6 = new StringBuilder();
                    var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"$x6x\"\u007fw1w!f7Z\u0006Z\u0006"));
                    var5_6.append(BuddyListHandler.ALLATORIxDEMO("\\\u0002T\u0014N\u001eU\u0019\u001a\u0004N\u0016H\u0003\u0012^\u001a\f7}3"));
                    var6_8 = 0;
                    v0 = var6_8;
                    while (v0 < var2_2.getMessages().get(0).size()) {
                        var7_10 = var2_2.getMessages().get(0).get(var6_8).getConditions();
                        var8_12 = 0;
                        if (var2_2.getMessages().get(0).get(var6_8).getConditions() != null) {
                            var8_12 = var7_10.size();
                            var5_6.append((CharSequence)a.H(var7_10));
                        }
                        var5_6.append((CharSequence)a.ALLATORIxDEMO(var2_2.getMessages().get(0).get(var6_8)));
                        var9_14 = 0;
                        v1 = var9_14;
                        while (v1 < var8_12) {
                            var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"^qZ\u0006"));
                            v1 = ++var9_14;
                        }
                        v0 = ++var6_8;
                    }
                    {
                        catch (Throwable var5_7) {
                            try {
                                var4_4.close();
                                v2 = var5_7;
                                throw v2;
                            }
                            catch (Throwable var6_9) {
                                v3 = var5_7;
                                v2 = v3;
                                v3.addSuppressed(var6_9);
                            }
                            throw v2;
                        }
                    }
                    if (var2_2.getMessages().size() == 1) {
                        var5_6.append(BuddyListHandler.ALLATORIxDEMO("~Y\u001a\u0014\u0013S\u0004J\u0018I\u0012\u0012^\u0001z0"));
                    }
                    var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"qZ\u0006Z\u0006"));
                    if (var2_2.getMessages().size() > 1) {
                        var5_6.append(BuddyListHandler.ALLATORIxDEMO("\u0011O\u0019Y\u0003S\u0018TW[\u0014N\u001eU\u0019\u0012\u001aU\u0013_[\u001a\u0003C\u0007_[\u001a\u0004_\u001b_\u0014N\u001eU\u0019\u0013WAz0"));
                        var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"^\u007f#m#y$'|7Z\u0006"));
                        var5_6.append(BuddyListHandler.ALLATORIxDEMO("~S\u0011\u001a_\u0012\u001aU\u0013_W\u0007J\u001aG\u001aQ\u001cWN\u000eJ\u0012\u001aJ\u0007W\u000e^\u001a\u000bFWW\u0018^\u0012\u001aJ\u0007W\u0017F\u0013WAz0"));
                        var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0005^o:\"3e$|8\u007f2$~7Z\u0006"));
                        var5_6.append(BuddyListHandler.ALLATORIxDEMO("3~H\u0012N\u0002H\u0019\u0001z0"));
                        var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"^qZ\u0006"));
                        var5_6.append(BuddyListHandler.ALLATORIxDEMO("~S\u0011\u001a_W\u0018^\u0012\u001aJ\u0007W\nW\u001cQ\u001a\u0003C\u0007_W\u0007J\u001aG\u0013WAz0"));
                        var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"^\u0005$x6x\"\u007fw!j,e7Z\u0006"));
                        var5_6.append(BuddyListHandler.ALLATORIxDEMO("~Gz0"));
                        var6_8 = 1;
                        v4 = var6_8;
                        break block26;
                    }
                    ** GOTO lbl92
                }
                catch (IOException var4_5) {
                    System.err.println("Error while writing the file " + var3_3 + ".");
                    continue;
                }
            }
            while (true) {
                if (v4 < var2_2.getMessages().size()) {
                    if (var6_8 > 1) {
                        var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"wi;\u007f2,>jw$$x6x\"\u007fw1j,")).append(var6_8 - 1).append(BuddyListHandler.ALLATORIxDEMO("^\u001a\f7}3"));
                    } else {
                        var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0005>jw$$x6x\"\u007fw1j,")).append(var6_8 - 1).append(BuddyListHandler.ALLATORIxDEMO("^\u001a\f7}3"));
                    }
                    v5 = var7_11 = 0;
                } else {
                    var5_6.append(BuddyListHandler.ALLATORIxDEMO("z0"));
                    var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"q"));
lbl92:
                    // 2 sources

                    v6 = var4_4;
                    v6.append(var5_6);
                    v6.close();
                    var4_4.close();
                    continue block9;
                }
                while (v5 < var2_2.getMessages().get(var6_8).size()) {
                    var8_13 = var2_2.getMessages().get(var6_8).get(var7_11);
                    if (var8_13.getConditions() != null) {
                        var5_6.append((CharSequence)a.H(var8_13.getConditions()));
                    }
                    var5_6.append((CharSequence)a.ALLATORIxDEMO(var8_13.getSelectedOption()));
                    var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0005"));
                    if (var8_13.getSelectedOption() > -1) {
                        var5_6.append(BuddyListHandler.ALLATORIxDEMO("~3"));
                    }
                    var5_6.append((CharSequence)a.ALLATORIxDEMO(var8_13.getInstructions()));
                    var5_6.append((CharSequence)a.ALLATORIxDEMO(var8_13));
                    if (var8_13.getSelectedOption() > -1) {
                        var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0005^qZ\u0006"));
                    }
                    if (var8_13.getConditions() != null) {
                        v7 = var9_14 = 0;
                        while (v7 < var8_13.getConditions().size()) {
                            var5_6.append(BuddyListHandler.ALLATORIxDEMO("3~Gz0"));
                            v7 = ++var9_14;
                        }
                    }
                    v5 = ++var7_11;
                }
                var5_6.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"^q"));
                v4 = ++var6_8;
            }
            break;
        }
    }

    private /* synthetic */ void l() {
        NPCScriptGenerator a2;
        NPCScriptGenerator nPCScriptGenerator = a2;
        nPCScriptGenerator.e = new LinkedHashMap<Integer, NPC>();
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ StringBuilder ALLATORIxDEMO(NPCMessage a2) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (a2.getMessageType()) {
            case 0: {
                switch (a2.getMessageButtons()) {
                    case 0: {
                        stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("Y\u001a\u0014\u0004_\u0019^8Q_\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                        return stringBuilder;
                    }
                    case 1: {
                        stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("Y\u001a\u0014\u0004_\u0019^9_\u000fN_\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                        return stringBuilder;
                    }
                    case 2: {
                        stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("Y\u001a\u0014\u0004_\u0019^'H\u0012L_\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                        return stringBuilder;
                    }
                    case 3: {
                        stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("Y\u001a\u0014\u0004_\u0019^9_\u000fN'H\u0012L_\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                        return stringBuilder;
                    }
                }
                return stringBuilder;
            }
            case 1: {
                StringBuilder stringBuilder2 = stringBuilder;
                stringBuilder2.append(BuddyListHandler.ALLATORIxDEMO("\u0014WYI\u0012T\u0013c\u0012I9U_\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                return stringBuilder2;
            }
            case 2: {
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder3.append(BuddyListHandler.ALLATORIxDEMO("\u0014WYI\u0012T\u0013}\u0012N#_\u000fN_\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                return stringBuilder3;
            }
            case 3: {
                StringBuilder stringBuilder4 = stringBuilder;
                stringBuilder4.append(BuddyListHandler.ALLATORIxDEMO("\u0014WYI\u0012T\u0013}\u0012N9O\u001aX\u0012H_\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                return stringBuilder4;
            }
            case 4: {
                StringBuilder stringBuilder5 = stringBuilder;
                stringBuilder5.append(BuddyListHandler.ALLATORIxDEMO("Y\u001a\u0014\u0004_\u0019^$S\u001aJ\u001b__\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                return stringBuilder5;
            }
            case 7: {
                StringBuilder stringBuilder6 = stringBuilder;
                stringBuilder6.append(BuddyListHandler.ALLATORIxDEMO("\u0014WYI\u0012T\u0013i\u0003C\u001b__\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                return stringBuilder6;
            }
            case 12: {
                StringBuilder stringBuilder7 = stringBuilder;
                stringBuilder7.append(BuddyListHandler.ALLATORIxDEMO("\u0014WYI\u0012T\u0013{\u0014Y\u0012J\u0003~\u0012Y\u001bS\u0019__\u0018")).append(a2.getMessage()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)".~7Z\u0006"));
                return stringBuilder7;
            }
            case 14: {
                stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("\u0014WYI\u0012T\u0013j\u001b[\u0014_\u0004\u0012^\u0001z0"));
                return stringBuilder;
            }
        }
        return stringBuilder;
    }

    private /* synthetic */ void H() {
        NPCScriptGenerator a2;
        NPCScriptGenerator nPCScriptGenerator = a2;
        NPCScriptGenerator nPCScriptGenerator2 = a2;
        NPCScriptGenerator nPCScriptGenerator3 = a2;
        NPCScriptGenerator nPCScriptGenerator4 = a2;
        nPCScriptGenerator4.E = 0;
        nPCScriptGenerator4.g = 0;
        nPCScriptGenerator3.B = 0;
        nPCScriptGenerator3.k = false;
        nPCScriptGenerator2.K = false;
        nPCScriptGenerator2.d = -1;
        nPCScriptGenerator.ALLATORIxDEMO = -1;
        nPCScriptGenerator.a = false;
    }

    private /* synthetic */ StringBuilder H(List<Condition> a2) {
        StringBuilder stringBuilder = new StringBuilder();
        a2 = a2.iterator();
        while (a2.hasNext()) {
            Condition condition = (Condition)a2.next();
            if (!(condition instanceof Location)) continue;
            condition = (Location)condition;
            stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("~S\u0011\u001a_Y\u001a\u0014\u0010_\u0003w\u0016J>^_\u0013W\u0007J\u001a")).append(((Location)condition).getMapId()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"%wwZ\u0006"));
        }
        return stringBuilder;
    }

    private /* synthetic */ StringBuilder ALLATORIxDEMO(int a2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a2 > -1) {
            stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("~S\u0011\u001a_I\u0012V\u0012Y\u0003S\u0018TW\u0007J\u001a")).append(a2).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"%wwZ\u0006"));
        }
        return stringBuilder;
    }

    public /* synthetic */ NPCScriptGenerator() {
        NPCScriptGenerator a2;
        NPCScriptGenerator nPCScriptGenerator = a2;
        nPCScriptGenerator.d = -1;
        nPCScriptGenerator.ALLATORIxDEMO = -1;
    }

    private /* synthetic */ StringBuilder ALLATORIxDEMO(List<Instruction> a2) {
        StringBuilder stringBuilder = new StringBuilder();
        a2 = a2.iterator();
        while (a2.hasNext()) {
            Instruction instruction;
            Instruction instruction2;
            Instruction instruction3 = (Instruction)a2.next();
            if (instruction3 instanceof Mesos) {
                instruction2 = (Mesos)instruction3;
                instruction = instruction3;
                stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("3~Y\u001a\u0014\u0010[\u001eT:_\u0004U\u0004\u0012")).append(((Mesos)instruction2).getAmount()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"~7Z\u0006"));
            } else {
                if (instruction3 instanceof Warp) {
                    instruction2 = (Warp)instruction3;
                    stringBuilder.append(BuddyListHandler.ALLATORIxDEMO("~3\u0014WYM\u0016H\u0007\u0012")).append(((Warp)instruction2).getMapId()).append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"{,")).append(((Warp)instruction2).getSpawnPoint()).append(BuddyListHandler.ALLATORIxDEMO("^\u0001z0"));
                }
                instruction = instruction3;
            }
            if (!instruction.isDispose()) continue;
            stringBuilder.append(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u0005^o:\"3e$|8\u007f2$~7Z\u0006"));
        }
        return stringBuilder;
    }

    private /* synthetic */ void ALLATORIxDEMO(List<Instruction> a2) {
        NPC nPC;
        NPCScriptGenerator a3;
        NPCScriptGenerator nPCScriptGenerator = a3;
        if (nPCScriptGenerator.e.containsKey(nPCScriptGenerator.g)) {
            NPC nPC2;
            NPCScriptGenerator nPCScriptGenerator2 = a3;
            nPC = nPC2 = nPCScriptGenerator2.e.get(nPCScriptGenerator2.g);
        } else {
            NPC nPC3;
            nPC = nPC3 = new NPC(a3.g);
        }
        NPCScriptGenerator nPCScriptGenerator3 = a3;
        nPC.applyConversation(nPCScriptGenerator3.E, nPCScriptGenerator3.H, -1, "", (byte)0, -1, a2);
    }
}

