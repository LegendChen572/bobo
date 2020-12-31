/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Fa;
import FuckingHackerToby.M;
import handling.channel.handler.HiredMerchantHandler;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import tools.npcgenerator.Instruction;

public final class Za
extends Fa
implements M {
    private static final /* synthetic */ Dimension a;
    private /* synthetic */ JTextArea g;
    private /* synthetic */ JScrollPane k;
    private /* synthetic */ String K;
    private /* synthetic */ JTextField B;
    private static final /* synthetic */ String d = "You: ";

    public static /* synthetic */ {
        a = new Dimension(500, 500);
    }

    @Override
    public /* synthetic */ String c() {
        Za a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ void m(String a2) {
        Za a3;
        a2 = (String)a2 + System.lineSeparator();
        Za za2 = a3;
        za2.g.append((String)a2);
        JScrollBar jScrollBar = za2.k.getVerticalScrollBar();
        jScrollBar.setValue(jScrollBar.getMaximum());
    }

    public /* synthetic */ Za() {
        Za a2;
        Za za2 = a2;
        Za za3 = a2;
        za2.g = new JTextArea();
        za3.B = new JTextField();
        za2.k = new JScrollPane(a2.g, 22, 31);
        Container container = ((JFrame)((Object)za2.d)).getContentPane();
        za2.B.addActionListener(a3 -> {
            Za a4;
            a3 = a4.B.getText();
            if (!((String)((Object)a3)).isEmpty()) {
                Za za2 = a4;
                za2.K = a3;
                za2.ALLATORIxDEMO(a2 -> {
                    Za a3;
                    a2.ALLATORIxDEMO("Message sent", a3);
                });
                a4.m(d + (String)((Object)a3));
            }
            a4.B.setText("");
        });
        Za za4 = a2;
        Za za5 = a2;
        Za za6 = a2;
        za6.g.setEditable(false);
        za6.g.setLineWrap(true);
        za6.g.setWrapStyleWord(true);
        container.add((Component)a2.k, HiredMerchantHandler.ALLATORIxDEMO("7k\u001az\u0011|"));
        container.add((Component)za5.B, Instruction.ALLATORIxDEMO("2u\u0014n\t"));
        ((JFrame)((Object)za4.d)).setDefaultCloseOperation(1);
        ((Component)((Object)za5.d)).setPreferredSize(a);
        ((Window)((Object)za4.d)).pack();
        ((Window)((Object)za4.d)).setLocationRelativeTo(null);
    }
}

