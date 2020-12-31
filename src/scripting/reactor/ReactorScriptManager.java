/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u83c7\u83c7\u8c37
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 */
package scripting.reactor;

import client.MapleClient;
import client.messages.commands.player.\u83c7\u83c7\u8c37;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import scripting.AbstractScriptManager;
import scripting.reactor.ReactorActionManager;
import server.maps.MapleReactor;
import server.maps.ReactorDropEntry;
import tools.FilePrinter;

public class ReactorScriptManager
extends AbstractScriptManager {
    private final /* synthetic */ Map<Integer, List<ReactorDropEntry>> ALLATORIxDEMO;
    private static final /* synthetic */ ReactorScriptManager d;

    /*
     * Exception decompiling
     */
    public final /* synthetic */ List<ReactorDropEntry> getDrops(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public static /* synthetic */ {
        d = new ReactorScriptManager();
    }

    public static final /* synthetic */ ReactorScriptManager getInstance() {
        return d;
    }

    public final /* synthetic */ void clearDrops() {
        ReactorScriptManager a2;
        a2.ALLATORIxDEMO.clear();
    }

    public final /* synthetic */ void act(MapleClient a2, MapleReactor a3) {
        Invocable invocable;
        block3: {
            ReactorScriptManager a4;
            invocable = a4.getInvocable("reactor/" + a3.getReactorId() + ".js", (MapleClient)a2);
            if (invocable != null) break block3;
            return;
        }
        try {
            ScriptEngine scriptEngine = (ScriptEngine)((Object)invocable);
            a2 = new ReactorActionManager((MapleClient)a2, a3);
            scriptEngine.put(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"F<"), a2);
            invocable.invokeFunction(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"x\u0002m"), new Object[0]);
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Error executing reactor script. ReactorID: " + a3.getReactorId() + ", ReactorName: " + a3.getName() + ":" + exception);
            FilePrinter.printError(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"f4U2@>F\u0002W#]!@\u001cU?U6Q#\u001a%L%"), "Error executing reactor script. ReactorID: " + a3.getReactorId() + ", ReactorName: " + a3.getName() + ":" + exception);
            return;
        }
    }

    public /* synthetic */ ReactorScriptManager() {
        ReactorScriptManager a2;
        ReactorScriptManager reactorScriptManager = a2;
        reactorScriptManager.ALLATORIxDEMO = new HashMap<Integer, List<ReactorDropEntry>>();
    }
}

