/*
 * Decompiled with CFR 0.150.
 */
package scripting.portal;

import client.MapleClient;
import client.MapleCoolDownValueHolder;
import client.inventory.MapleImp;
import constants.GameSetConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import scripting.portal.PortalPlayerInteraction;
import scripting.portal.PortalScript;
import server.MaplePortal;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.StringUtil;
import tools.crypt.AESOperator;

public class PortalScriptManager {
    private static final /* synthetic */ ScriptEngineFactory ALLATORIxDEMO;
    private final /* synthetic */ Map<String, PortalScript> d;
    private static final /* synthetic */ PortalScriptManager a;

    public final /* synthetic */ void executePortalScript(MaplePortal a2, MapleClient a3) {
        PortalScriptManager portalScriptManager;
        PortalScriptManager a4;
        PortalScript portalScript = a4.ALLATORIxDEMO(a2.getScriptName());
        if (a3 != null && a3.getPlayer() != null && a3.getPlayer().hasGmLevel(2)) {
            a3.getPlayer().dropMessage("\u60a8\u5df2\u7d93\u5efa\u7acb\u8207\u50b3\u9001\u9580\u8173\u672c: " + a2.getScriptName() + ".js \u7684\u95dc\u806f\u3002");
        }
        if (a3.isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo("\u5df2\u7d93\u5efa\u7acb\u8207\u50b3\u9001\u9580\u8173\u672c: " + a2.getScriptName() + ".js \u7684\u95dc\u806f\u3002"));
        }
        if (portalScript != null) {
            try {
                portalScript.enter(new PortalPlayerInteraction(a3, a2));
                portalScriptManager = a4;
            }
            catch (Exception exception) {
                System.err.println("\u9032\u5165\u50b3\u9001\u8173\u672c\u5931\u6557: " + a2.getScriptName() + ":" + exception);
                portalScriptManager = a4;
            }
        } else {
            System.err.println("\u672a\u8655\u7406\u7684\u50b3\u9001\u8173\u672c " + a2.getScriptName() + " \u6240\u5728\u5730\u5716 " + a3.getPlayer().getMapId());
            FilePrinter.printError(MapleCoolDownValueHolder.ALLATORIxDEMO("s4Q/B7p8Q2S/n:M:D>QuW#W"), "\u672a\u8655\u7406\u7684\u50b3\u9001\u8173\u672c " + a2.getScriptName() + " \u6240\u5728\u5730\u5716 " + a3.getPlayer().getMapId());
            portalScriptManager = a4;
        }
        portalScriptManager.clearScripts();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final /* synthetic */ PortalScript ALLATORIxDEMO(String a2) {
        PortalScriptManager a3;
        if (a3.d.containsKey(a2)) {
            return a3.d.get(a2);
        }
        Object object = new File(GameSetConstants.getNpcFolder() + "/portal/" + a2 + ".js");
        if (!((File)object).exists()) {
            a3.d.put(a2, null);
            return null;
        }
        InputStreamReader inputStreamReader = null;
        ScriptEngine scriptEngine = ALLATORIxDEMO.getScriptEngine();
        String string = "";
        try {
            String string2;
            inputStreamReader = new InputStreamReader((InputStream)new FileInputStream((File)object), StringUtil.codeString((File)object));
            object = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            Object object2 = object;
            while ((string2 = ((BufferedReader)object2).readLine()) != null) {
                stringBuffer.append(string2 + "\r\n");
                object2 = object;
            }
            string = stringBuffer.toString();
            scriptEngine.eval(AESOperator.getInstance().decrypt(string));
        }
        catch (FileNotFoundException | UnsupportedEncodingException | ScriptException exception) {
            System.err.println("Error executing Portalscript: " + a2 + ":" + exception);
            FilePrinter.printError(MapleImp.ALLATORIxDEMO("\u0000P\"K1S\u0003\\\"V K\u001d^>^7Z\"\u0011$G$"), exception);
        }
        catch (IOException iOException) {
            Logger.getLogger(PortalScriptManager.class.getName()).log(Level.SEVERE, null, iOException);
        }
        finally {
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            }
            catch (IOException iOException) {}
        }
        ScriptEngine scriptEngine2 = scriptEngine;
        Object object3 = object = ((Invocable)((Object)scriptEngine2)).getInterface(PortalScript.class);
        a3.d.put(a2, (PortalScript)object3);
        return object3;
    }

    public static final /* synthetic */ PortalScriptManager getInstance() {
        return a;
    }

    public static /* synthetic */ {
        a = new PortalScriptManager();
        ALLATORIxDEMO = new ScriptEngineManager().getEngineByName(MapleImp.ALLATORIxDEMO(">^#W?M>")).getFactory();
    }

    public final /* synthetic */ void clearScripts() {
        PortalScriptManager a2;
        a2.d.clear();
    }

    public /* synthetic */ PortalScriptManager() {
        PortalScriptManager a2;
        PortalScriptManager portalScriptManager = a2;
        portalScriptManager.d = new HashMap<String, PortalScript>();
    }
}

