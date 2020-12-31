/*
 * Decompiled with CFR 0.150.
 */
package scripting;

import client.MapleBuffStatValueHolder;
import client.MapleClient;
import constants.GameSetConstants;
import handling.channel.handler.BuddyListHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.script.Invocable;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import scripting.npc.NPCScriptManager;
import tools.FilePrinter;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.StringUtil;
import tools.crypt.AESOperator;

public abstract class AbstractScriptManager {
    private static final /* synthetic */ Map<String, Pair<Long, String>> ALLATORIxDEMO;
    private static final /* synthetic */ ScriptEngineManager d;

    public /* synthetic */ Invocable getInvocable(String a2, MapleClient a3) {
        AbstractScriptManager a4;
        return a4.getInvocable(a2, a3, false);
    }

    public static /* synthetic */ {
        d = new ScriptEngineManager();
        ALLATORIxDEMO = new ConcurrentHashMap<String, Pair<Long, String>>();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ Invocable getInvocable(String a, MapleClient a, boolean a) {
        block26: {
            a = GameSetConstants.getNpcFolder() + "/" + (String)a;
            var4_6 = null;
            var5_7 = -1L;
            if (a != null && a.getPlayer().isOperateStorage()) {
                a.getPlayer().dropMessage(5, BuddyListHandler.ALLATORIxDEMO("\u4f17\u6b59\u575f\u64f7\u4f2b\u5033\u5edc\u001b"));
                return null;
            }
            if (a != null) {
                var4_6 = a.getScriptEngine((String)a);
            }
            if (var4_6 != null && a != null && a) {
                v0 = a;
                v0.removeClickedNPC();
                v0.removeScriptEngine((String)a);
                NPCScriptManager.getInstance().dispose(a);
                v0.sendPacket(MaplePacketCreator.enableActions());
                return null;
            }
            if (var4_6 != null) break block26;
            a = new File((String)a);
            var5_7 = a.lastModified();
            if (!a.exists()) {
                return null;
            }
            if (a != null && a.getPlayer() != null && a.getPlayer().getDebugMessage()) {
                a.getPlayer().dropMessage(MapleBuffStatValueHolder.ALLATORIxDEMO("7%$\t>6?#1\"<%pmp\u001012$q"));
            }
            var4_6 = AbstractScriptManager.d.getEngineByName(BuddyListHandler.ALLATORIxDEMO("T\u0016I\u001fU\u0005T"));
            if (a != null && a.getPlayer() != null && a.getPlayer().getDebugMessage()) {
                a.getPlayer().dropMessage(MapleBuffStatValueHolder.ALLATORIxDEMO("7%$\t>6?#1\"<%pmp\u001012$r"));
            }
            if (a != null) {
                v1 = a;
                v1.setScriptEngine((String)a, var4_6);
                if (v1 != null && a.getPlayer() != null && a.getPlayer().getDebugMessage()) {
                    a.getPlayer().dropMessage(BuddyListHandler.ALLATORIxDEMO("\u0010_\u0003s\u0019L\u0018Y\u0016X\u001b_W\u0017Wj\u0016H\u0003\t"));
                }
            }
            var7_8 = null;
            try {
                var8_9 = "";
                var9_12 = true;
                if (!AbstractScriptManager.ALLATORIxDEMO.containsKey(a)) ** GOTO lbl42
                if (AbstractScriptManager.ALLATORIxDEMO.get(a).getLeft() == var5_7) {
                    var8_9 = AbstractScriptManager.ALLATORIxDEMO.get(a).getRight();
                    v2 = var9_12 = false;
                } else {
                    AbstractScriptManager.ALLATORIxDEMO.remove(a);
lbl42:
                    // 2 sources

                    v2 = var9_12;
                }
                if (v2) {
                    var7_8 = new InputStreamReader((InputStream)new FileInputStream((File)a), StringUtil.codeString((File)a));
                    var10_14 = new BufferedReader(var7_8);
                    var11_16 = new StringBuffer();
                    v3 = var10_14;
                    while ((a = v3.readLine()) != null) {
                        var11_16.append((String)a + "\r\n");
                        v3 = var10_14;
                    }
                    var8_9 = var11_16.toString();
                    AbstractScriptManager.ALLATORIxDEMO.put((String)a, new Pair<Long, String>(var5_7, var11_16.toString()));
                }
                var4_6.eval(AESOperator.getInstance().decrypt(var8_9));
                if (a != null && a.getPlayer() != null && a.getPlayer().getDebugMessage()) {
                    a.getPlayer().dropMessage(MapleBuffStatValueHolder.ALLATORIxDEMO("7%$\t>6?#1\"<%pmp\u001012$t"));
                }
                if (a != null && a.getPlayer() != null && a.getPlayer().getDebugMessage()) {
                    a.getPlayer().dropMessage(BuddyListHandler.ALLATORIxDEMO("\u0010_\u0003s\u0019L\u0018Y\u0016X\u001b_W\u0017Wj\u0016H\u0003\u000f"));
                }
            }
            catch (IOException | ScriptException var8_11) {
                System.out.println(var8_11);
                FilePrinter.printError(MapleBuffStatValueHolder.ALLATORIxDEMO("\u000123$21#$\u00133290$\r1.1'52~4(4"), "Error executing script. Path: " + (String)a + "\nException " + var8_11);
                var9_13 = null;
                return var9_13;
            }
            finally {
                try {
                    if (var7_8 != null) {
                        var7_8.close();
                    }
                }
                catch (IOException var10_15) {}
            }
        }
        v4 = var4_6;
        return (Invocable)v4;
    }

    public /* synthetic */ AbstractScriptManager() {
        AbstractScriptManager a2;
    }

    public static /* synthetic */ void clearScripts() {
        ALLATORIxDEMO.clear();
    }
}

