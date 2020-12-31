/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 */
package server.swing.tools;

import client.messages.commands.player.\u61b6\u6200\u8c37;
import handling.RecvPacketOpcode;
import handling.SendPacketOpcode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import server.maps.MapleMapFactory;
import server.shark.SharkPacket;
import server.shark.SharkReader;
import tools.data.ByteArrayByteStream;
import tools.data.LittleEndianAccessor;

public class ScriptExport
extends JFrame {
    private /* synthetic */ String I;
    private /* synthetic */ int[] B;
    private /* synthetic */ boolean k;
    private final /* synthetic */ MapleMapFactory g;
    private /* synthetic */ int H;
    private /* synthetic */ File J;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private static final /* synthetic */ SimpleDateFormat E;
    private /* synthetic */ SharkReader M;
    private /* synthetic */ JButton K;
    private /* synthetic */ String F;
    private final /* synthetic */ Map<Integer, Integer> C;
    private /* synthetic */ JButton a;
    public /* synthetic */ boolean e;
    private /* synthetic */ JLabel d;

    private /* synthetic */ void ALLATORIxDEMO(String a2, String a3, boolean a4) {
        ScriptExport scriptExport;
        ScriptExport a5;
        if (!a5.F.isEmpty()) {
            a5.ALLATORIxDEMO(a4);
        }
        if (!SharkReader.ALLATORIxDEMO("#.").equals(a2)) {
            a5.e = true;
        }
        ScriptExport scriptExport2 = a5;
        scriptExport2.F = a2;
        scriptExport2.I = a3;
        if (a5.e) {
            a5.ALLATORIxDEMO("/* global " + a2 + " */", false);
            if (!\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"ic").equals(a2) && !SharkReader.ALLATORIxDEMO(" .").equals(a2)) {
                a5.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"okk*j~x~ly979'(1"), false);
            }
            a5.ALLATORIxDEMO("", false);
        }
        if (SharkReader.ALLATORIxDEMO("\"*").equals(a2)) {
            a5.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u007f\u007fwimcvd9ow~|x1zp#9q"), false);
            return;
        }
        if (SharkReader.ALLATORIxDEMO(" .").equals(a2)) {
            a5.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u007f\u007fwimcvd9kz~1#9q"), false);
            return;
        }
        if (SharkReader.ALLATORIxDEMO("#.").equals(a2)) {
            ScriptExport scriptExport3 = a5;
            if (a5.e) {
                scriptExport3.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"lldz~pew*j~xxm\"te}o5*msio5*jouoz~pew#9q"), false);
            } else {
                scriptExport3.ALLATORIxDEMO("", false);
                a5.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("%'-17;,<c7-6k?,6&~c&:\"&~c!&>&17;,<jr8"), false);
            }
        } else {
            a5.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u007f\u007fwimcvd9kz~pew\"te}o5*msio5*jouoz~pew#9q"), false);
        }
        ScriptExport scriptExport4 = a5;
        if (SharkReader.ALLATORIxDEMO("?0").equals(a2)) {
            scriptExport4.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"*9*9c\u007f*1gvn|*$7$*)#9q"), false);
            ScriptExport scriptExport5 = a5;
            scriptExport = scriptExport5;
            ScriptExport scriptExport6 = a5;
            scriptExport6.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("crcrcrcr0&\"&6!n\u007fx"), false);
            scriptExport6.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"9*9*d*|fjo9q"), false);
            scriptExport5.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("crcrcrcr0&\"&6!hyx"), false);
            scriptExport5.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"*9*9w"), false);
        } else {
            scriptExport4.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("crcr*4cz.='7co~occjr8"), false);
            ScriptExport scriptExport7 = a5;
            scriptExport = scriptExport7;
            ScriptExport scriptExport8 = a5;
            scriptExport8.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"*9*9*9*9ymkm\u007fj!21"), false);
            scriptExport8.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("rcrc/c7/!&r8"), false);
            scriptExport7.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"*9*9*9*9ymkm\u007fj'41"), false);
            scriptExport7.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("crcr>"), false);
        }
        scriptExport.ALLATORIxDEMO("", false);
        ScriptExport scriptExport9 = a5;
        ScriptExport scriptExport10 = a5;
        scriptExport10.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"*9*9|xx9c979'(1"), false);
        scriptExport10.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("rcrc;%rk!737'0r\u007foc;hyjr8"), false);
        scriptExport9.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"}cjzvy|\"01"), true);
        scriptExport9.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("rcrc/c7/!&r*4cz0&\"&6!co~oc;hyjr8"), false);
    }

    public /* synthetic */ ScriptExport() {
        ScriptExport a2;
        ScriptExport scriptExport = a2;
        ScriptExport scriptExport2 = a2;
        ScriptExport scriptExport3 = a2;
        scriptExport3.J = null;
        scriptExport3.M = null;
        scriptExport2.I = "";
        scriptExport2.F = "";
        ScriptExport scriptExport4 = a2;
        scriptExport2.C = new HashMap<Integer, Integer>();
        scriptExport.H = 0;
        scriptExport.e = true;
        scriptExport.g = new MapleMapFactory(255, 255);
        a2.B = null;
        a2.k = false;
        a2.ALLATORIxDEMO();
    }

    private /* synthetic */ void H() {
        ScriptExport a2;
        if (a2.J == null) {
            System.out.println(SharkReader.ALLATORIxDEMO("\u65d5\u4eb5\u70e8\u7a39"));
            return;
        }
        if (!a2.J.exists()) {
            System.out.println(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u658d\u4eef\u4e07\u5b41\u5722"));
            return;
        }
        ScriptExport scriptExport = a2;
        a2.M = new SharkReader(a2.J);
        while (scriptExport.M.available() > 0L) {
            ScriptExport scriptExport2 = a2;
            scriptExport = scriptExport2;
            scriptExport2.ALLATORIxDEMO(scriptExport2.M.read());
        }
        a2.ALLATORIxDEMO(true);
        System.out.println(SharkReader.ALLATORIxDEMO("\u89b1\u5346\u5bde\u6253"));
    }

    private /* synthetic */ List<Integer> ALLATORIxDEMO(int[] a2) {
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = 0;
        int n4 = n2 = 0;
        while (n4 < a2.length) {
            int n5 = a2[n2];
            while (n5 > 1) {
                int n6;
                ++n3;
                if ((n6 & 1) != 0) {
                    arrayList.add(31 - n3 + n2 * 32);
                }
                n5 = n6 >> 1;
            }
            n4 = ++n2;
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        ScriptExport a3;
        if (a2) {
            a3.setLocationRelativeTo(null);
        }
        super.setVisible(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(boolean a2) {
        ScriptExport scriptExport;
        ScriptExport a3;
        if (!SharkReader.ALLATORIxDEMO("\"*").equals(a3.F) && !\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"kg").equals(a3.F)) {
            if (a2) {
                a3.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("6*!3=07k{x"), true);
            }
            scriptExport = a3;
            ScriptExport scriptExport2 = a3;
            ScriptExport scriptExport3 = a3;
            scriptExport3.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"9*9*d*|fjo9q"), false);
            scriptExport3.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO("6*!3=07k{x"), true);
            scriptExport2.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"*9*9w"), false);
            scriptExport2.ALLATORIxDEMO(SharkReader.ALLATORIxDEMO(">"), false);
        } else {
            ScriptExport scriptExport4 = a3;
            scriptExport = scriptExport4;
            scriptExport4.ALLATORIxDEMO(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"w"), false);
        }
        scriptExport.F = "";
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        ScriptExport a2;
        ScriptExport scriptExport = a2;
        ScriptExport scriptExport2 = a2;
        ScriptExport scriptExport3 = a2;
        ScriptExport scriptExport4 = a2;
        scriptExport3.d = new JLabel();
        scriptExport4.ALLATORIxDEMO = new JTextField();
        scriptExport3.K = new JButton();
        scriptExport3.a = new JButton();
        scriptExport2.setDefaultCloseOperation(3);
        scriptExport.setTitle(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u5c0b\u531c~v\u8179\u6735\u89e9\u531c\u5662"));
        scriptExport2.d.setText(SharkReader.ALLATORIxDEMO(".!!\u6ac6\u680b\u8dbd\u5fd2"));
        scriptExport.K.setText(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"$7$"));
        scriptExport.K.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.ScriptExport.this.H(a2);
            }
            {
                1 a3;
            }
        });
        scriptExport.a.setText(SharkReader.ALLATORIxDEMO("\u89b1\u5346"));
        scriptExport.a.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.ScriptExport.this.ALLATORIxDEMO(a2);
            }
        });
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        scriptExport.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.d).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.ALLATORIxDEMO, -2, 262, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.K)).addComponent(a2.a, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.d).addComponent(a2.ALLATORIxDEMO, -2, -1, -2).addComponent(a2.K)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.a).addContainerGap(-1, 32767)));
        scriptExport.pack();
    }

    private /* synthetic */ void ALLATORIxDEMO(SharkPacket a2) {
        ScriptExport a3;
        LittleEndianAccessor littleEndianAccessor = new LittleEndianAccessor(new ByteArrayByteStream(a2.info));
        if (a2.outbound) {
            int n2;
            RecvPacketOpcode[] arrrecvPacketOpcode = RecvPacketOpcode.values();
            int n3 = arrrecvPacketOpcode.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                RecvPacketOpcode recvPacketOpcode = arrrecvPacketOpcode[n2];
                if (recvPacketOpcode.getValue() == a2.opcode) {
                    try {
                        a3.ALLATORIxDEMO(littleEndianAccessor, recvPacketOpcode);
                        return;
                    }
                    catch (Exception exception) {
                        System.err.println("\u89e3\u5ba2\u6236\u7aef\u5305\u932f\u8aa4, \u5305\u982d" + recvPacketOpcode.name() + "\r\n" + littleEndianAccessor.toString(true));
                        return;
                    }
                }
                n4 = ++n2;
            }
        } else {
            int n5;
            SendPacketOpcode[] arrsendPacketOpcode = SendPacketOpcode.values();
            int n6 = arrsendPacketOpcode.length;
            int n7 = n5 = 0;
            while (n7 < n6) {
                SendPacketOpcode sendPacketOpcode = arrsendPacketOpcode[n5];
                if (sendPacketOpcode.getValue() == a2.opcode) {
                    try {
                        a3.ALLATORIxDEMO(littleEndianAccessor, sendPacketOpcode);
                        return;
                    }
                    catch (Exception exception) {
                        System.err.println("\u89e3\u4f3a\u670d\u5668\u5305\u932f\u8aa4, \u5305\u982d" + sendPacketOpcode.name() + "\r\n" + littleEndianAccessor.toString(true));
                        return;
                    }
                }
                n7 = ++n5;
            }
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(LittleEndianAccessor a2, RecvPacketOpcode a3) {
        ScriptExport a4;
        a2 = "";
        boolean bl = false;
        boolean bl2 = true;
        String string = "";
        String string2 = "";
        switch (a3) {
            // Empty switch
        }
        if (!((String)a2).isEmpty()) {
            a4.ALLATORIxDEMO((String)a2, bl);
        }
        if (!string.isEmpty()) {
            a4.ALLATORIxDEMO(string, string2, bl2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private /* synthetic */ void ALLATORIxDEMO(String a2222222) {
        Object object;
        int n2;
        Object object2;
        ScriptExport a3;
        Object object3;
        block28: {
            object3 = SharkReader.ALLATORIxDEMO("\u89a0\u5357\u8130\u677el");
            if (a3.I.isEmpty()) {
                a3.I = E.format(Calendar.getInstance().getTime());
            }
            object2 = a3.F;
            int n3 = -1;
            switch (((String)object2).hashCode()) {
                case 3178: {
                    if (!((String)object2).equals(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"zg"))) break;
                    n2 = n3 = 0;
                    break block28;
                }
                case 3577: {
                    if (!((String)object2).equals(SharkReader.ALLATORIxDEMO("\"*"))) break;
                    n2 = n3 = 1;
                    break block28;
                }
                case 3364: {
                    if (!((String)object2).equals(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"pg"))) break;
                    n2 = n3 = 2;
                    break block28;
                }
                case 3494: {
                    if (!((String)object2).equals(SharkReader.ALLATORIxDEMO("?0"))) break;
                    n2 = n3 = 3;
                    break block28;
                }
                case 3643: {
                    if (!((String)object2).equals(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"kg"))) break;
                    n2 = n3 = 4;
                    break block28;
                }
                case 3612: {
                    if (!((String)object2).equals(SharkReader.ALLATORIxDEMO("#."))) break;
                    n3 = 5;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                object = object3 = (String)object3 + "npc/";
                break;
            }
            case 1: {
                object = object3 = (String)object3 + "\u50b3\u9001\u9ede/";
                break;
            }
            case 2: {
                object = object3 = (String)object3 + "\u9053\u5177/";
                break;
            }
            case 3: {
                object = object3 = (String)object3 + "\u5730\u5716/";
                break;
            }
            case 4: {
                object = object3 = (String)object3 + "\u53cd\u61c9\u5806/";
                break;
            }
            case 5: {
                object = object3 = (String)object3 + "\u4efb\u52d9/";
                break;
            }
            default: {
                object = object3 = (String)object3 + "\u672a\u77e5/";
            }
        }
        object3 = (String)object + a3.I + ".js";
        object2 = null;
        File file = new File((String)object3);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        object2 = new FileOutputStream((String)object3, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)object2, \u61b6\u6200\u8c37.ALLATORIxDEMO((String)"_ML42"));
        outputStreamWriter.write(a2222222);
        outputStreamWriter.flush();
        try {
            if (object2 == null) return;
            ((FileOutputStream)object2).close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (IOException iOException) {
            try {
                if (object2 == null) return;
                ((FileOutputStream)object2).close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
            catch (Throwable throwable) {
                try {
                    if (object2 == null) throw throwable;
                    ((FileOutputStream)object2).close();
                    throw throwable;
                }
                catch (IOException a2222222) {
                    // empty catch block
                }
                throw throwable;
            }
        }
    }

    private /* synthetic */ void H(ActionEvent a2) {
        ScriptExport a3;
        a2 = new JFileChooser();
        ((JFileChooser)a2).showOpenDialog(null);
        a3.J = ((JFileChooser)a2).getSelectedFile();
        if (a3.J != null) {
            if (!a3.J.exists()) {
                System.out.println(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u6a9e\u6851\u4e07\u5b41\u5722"));
                return;
            }
            ScriptExport scriptExport = a3;
            scriptExport.ALLATORIxDEMO.setText(scriptExport.J.getPath());
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(LittleEndianAccessor a2, SendPacketOpcode a3) {
        ScriptExport a4;
        a2 = "";
        boolean bl = false;
        boolean bl2 = true;
        String string = "";
        String string2 = "";
        switch (a3) {
            // Empty switch
        }
        if (!((String)a2).isEmpty()) {
            a4.ALLATORIxDEMO((String)a2, bl);
        }
        if (!string.isEmpty()) {
            a4.ALLATORIxDEMO(string, string2, bl2);
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        ScriptExport a3;
        if (a3.J == null) {
            JOptionPane.showMessageDialog(null, SharkReader.ALLATORIxDEMO("\u8a99\u510b\u902a\u6484\u89d3\u89a0\u5357\u76c7\u6901\u9b89\u6ac6\u680bzm?00j"));
            return;
        }
        if (!a3.J.exists()) {
            System.out.println(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u658d\u4eef\u4e07\u5b41\u5722"));
            return;
        }
        ScriptExport scriptExport = a3;
        a3.I = "";
        scriptExport.F = "";
        scriptExport.e = true;
        a3.H();
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2, boolean a3) {
        String string;
        Object object;
        ScriptExport a4;
        if (a4.F.isEmpty()) {
            System.out.println("\u672a\u5beb\u8173\u672c:" + a2);
            return;
        }
        if (a3) {
            ScriptExport scriptExport;
            String string2;
            if (a4.F.equals(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"ic"))) {
                string2 = SharkReader.ALLATORIxDEMO("rcrc");
                scriptExport = a4;
            } else {
                string2 = \u61b6\u6200\u8c37.ALLATORIxDEMO((String)"9*9*9*9*");
                scriptExport = a4;
            }
            object = string2 + scriptExport.F + ".";
            string = a2;
        } else {
            object = "";
            string = a2;
        }
        a4.ALLATORIxDEMO((String)object + string + "\r\n");
    }

    public static /* synthetic */ {
        E = new SimpleDateFormat(SharkReader.ALLATORIxDEMO("+:+:\u5e26\u000e\u001f\u674b6'\u65b7\u000b\u001a\u6601?.\u52540!\u7991"));
    }
}

