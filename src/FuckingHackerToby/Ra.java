/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 */
package FuckingHackerToby;

import FuckingHackerToby.Fa;
import FuckingHackerToby.a;
import FuckingHackerToby.b;
import client.messages.commands.player.\u53ef\u53ef\u8c37;
import client.messages.commands.player.\u61a8\u61a8\u8c37;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class Ra
extends Fa
implements b {
    private static final /* synthetic */ Dimension ALLATORIxDEMO;
    private /* synthetic */ JTextArea K;
    private /* synthetic */ JButton d;
    private /* synthetic */ JScrollPane a;

    @Override
    public /* synthetic */ void E() {
        Ra a2;
        a2.K.setText("");
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2, a a3) {
        Ra a4;
        a3.ALLATORIxDEMO(a2, a4);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new Dimension(500, 500);
    }

    public /* synthetic */ Ra() {
        Container container;
        Ra a3;
        Ra ra2 = a3;
        Ra ra3 = a3;
        ra2.K = new JTextArea();
        ra3.a = new JScrollPane(a3.K, 22, 30);
        ra2.d = new JButton("Clear");
        ra2.d.setActionCommand("Clear");
        ra2.d.addActionListener(a2 -> {
            Ra a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            Ra ra2 = a3;
            ra2.ALLATORIxDEMO(arg_0 -> ra2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        Ra ra4 = a3;
        ra4.K.setEditable(false);
        ra4.K.setLineWrap(true);
        ra4.K.setWrapStyleWord(true);
        Container container2 = container = ((JFrame)((Object)ra4.d)).getContentPane();
        container2.add((Component)a3.a, \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\n\f'\u001d,\u001b"));
        container2.add((Component)a3.d, \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"_8y#d"));
        ((JFrame)((Object)ra4.d)).setDefaultCloseOperation(1);
        ((Component)ra4.d).setPreferredSize(ALLATORIxDEMO);
        ((Window)((Object)ra4.d)).pack();
        ((Window)((Object)ra4.d)).setLocationRelativeTo(null);
    }

    @Override
    public /* synthetic */ void b(String a2) {
        Ra a3;
        a3.K.append(a2);
    }
}

