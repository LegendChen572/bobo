/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jdesktop.beansbinding.AutoBinding$UpdateStrategy
 *  org.jdesktop.beansbinding.BeanProperty
 *  org.jdesktop.beansbinding.Binding
 *  org.jdesktop.beansbinding.BindingGroup
 *  org.jdesktop.beansbinding.Bindings
 *  org.jdesktop.beansbinding.ELProperty
 *  org.jdesktop.beansbinding.Property
 */
package server.swing;

import client.messages.commands.player.eventSystem.SellSystem;
import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.beansbinding.Property;
import tools.MaplePacketOperation;

public class Progressbar
extends JFrame {
    private /* synthetic */ JProgressBar d;
    private /* synthetic */ JLabel K;
    private /* synthetic */ int B;
    private /* synthetic */ int g;
    private /* synthetic */ int E;
    public static final /* synthetic */ Progressbar instance;
    private /* synthetic */ int C;
    private /* synthetic */ BindingGroup ALLATORIxDEMO;
    private /* synthetic */ String k;
    private /* synthetic */ int H;
    private /* synthetic */ String e;
    private /* synthetic */ JLabel a;

    @Override
    public /* synthetic */ String getTitle() {
        Progressbar a2;
        return a2.e;
    }

    @Override
    public /* synthetic */ void setTitle(String a2) {
        Progressbar a3;
        a3.e = a2;
        if (a3.C > 1) {
            Progressbar progressbar = a3;
            a2 = (String)a2 + "(" + progressbar.H + "/" + progressbar.C + ")";
        }
        super.setTitle((String)a2);
    }

    private /* synthetic */ void H() {
        Progressbar.setTitle("", 1);
        Progressbar.setStep(1);
        Progressbar.setText("");
        Progressbar.setMaximum(100);
        Progressbar.setMinimum(0);
        Progressbar.setValue(0);
    }

    public static /* synthetic */ void setStep(int a2) {
        Progressbar.instance.H = a2;
        instance.setTitle(Progressbar.instance.e);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        Progressbar a2;
        Progressbar progressbar = a2;
        Progressbar progressbar2 = a2;
        Progressbar progressbar3 = a2;
        Progressbar progressbar4 = a2;
        progressbar3.ALLATORIxDEMO = new BindingGroup();
        progressbar4.K = new JLabel();
        progressbar3.d = new JProgressBar();
        progressbar3.a = new JLabel();
        progressbar3.K.setIcon(new ImageIcon(a2.getClass().getResource(MaplePacketOperation.ALLATORIxDEMO("jI(A\"Eji&O+\u000e5N\""))));
        progressbar3.K.setText(SellSystem.ALLATORIxDEMO("\u001f#\u0014\r\u0010\u0003@Y"));
        progressbar2.setDefaultCloseOperation(0);
        progressbar2.setResizable(false);
        Progressbar progressbar5 = a2;
        Object object = Bindings.createAutoBinding((AutoBinding.UpdateStrategy)AutoBinding.UpdateStrategy.READ_WRITE, (Object)progressbar5.K, (Property)ELProperty.create((String)MaplePacketOperation.ALLATORIxDEMO("a[,C*NkI(A\"E8")), (Object)a2, (Property)BeanProperty.create((String)SellSystem.ALLATORIxDEMO("\u0006\u0016\u0000\u001b&\u0018\u000e\u0012\n")));
        progressbar.ALLATORIxDEMO.addBinding((Binding)object);
        progressbar5.d.setBorderPainted(false);
        progressbar.a.setText(MaplePacketOperation.ALLATORIxDEMO("\u6b26\u5708\u52e5\u8f29k\u000ek"));
        object = new GroupLayout(a2.getContentPane());
        progressbar.getContentPane().setLayout((LayoutManager)object);
        Object object2 = object;
        Object object3 = object;
        ((GroupLayout)object2).setHorizontalGroup(((GroupLayout)object2).createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(((GroupLayout)object3).createSequentialGroup().addContainerGap().addGroup(((GroupLayout)object).createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.d, -1, 438, 32767).addGroup(((GroupLayout)object).createSequentialGroup().addComponent(a2.a).addGap(0, 0, 32767))).addContainerGap()));
        ((GroupLayout)object2).setVerticalGroup(((GroupLayout)object3).createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, ((GroupLayout)object).createSequentialGroup().addContainerGap(11, 32767).addComponent(a2.a).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.d, -2, 24, -2).addContainerGap()));
        progressbar.ALLATORIxDEMO.bind();
        progressbar.pack();
    }

    public static /* synthetic */ void setValue(int a2) {
        Progressbar.instance.E = Math.max(Math.min(a2, Progressbar.instance.g), Progressbar.instance.B);
        Progressbar.instance.d.setValue(Progressbar.instance.E);
        Progressbar.setText(Progressbar.instance.k);
    }

    public static /* synthetic */ void visible(boolean a2) {
        instance.setVisible(a2);
    }

    public static /* synthetic */ int getValue() {
        return Progressbar.instance.E;
    }

    public static /* synthetic */ void updateTitle(String a2) {
        instance.setTitle(a2);
    }

    public static /* synthetic */ {
        instance = new Progressbar();
    }

    public static /* synthetic */ void setText(String a2) {
        Progressbar.instance.k = a2;
        Progressbar.instance.a.setText(Progressbar.instance.k + (String)(Progressbar.getPercent() > -1 ? "(" + Progressbar.getPercent() + "%)" : ""));
    }

    public static /* synthetic */ int getPercent() {
        if (Progressbar.instance.g <= 0) {
            return -1;
        }
        return (Progressbar.instance.E - Progressbar.instance.B) * 100 / Progressbar.instance.g;
    }

    public static /* synthetic */ void nextStep() {
        Progressbar.setStep(++Progressbar.instance.H);
    }

    public static /* synthetic */ void setSteps(int a2) {
        Progressbar.instance.C = a2;
        instance.setTitle(Progressbar.instance.e);
    }

    public static /* synthetic */ void setMaximum(int a2) {
        Progressbar.instance.g = a2;
        Progressbar.instance.d.setMaximum(Progressbar.instance.g);
    }

    public /* synthetic */ Progressbar() {
        Progressbar a2;
        Progressbar progressbar = a2;
        Progressbar progressbar2 = a2;
        Progressbar progressbar3 = a2;
        Progressbar progressbar4 = a2;
        Progressbar progressbar5 = a2;
        Progressbar progressbar6 = a2;
        progressbar6.C = 1;
        progressbar6.H = 1;
        progressbar5.e = "";
        progressbar5.E = 0;
        progressbar4.g = 100;
        progressbar4.B = 0;
        progressbar3.k = "";
        progressbar3.C = 1;
        progressbar2.H = 1;
        progressbar2.e = "";
        progressbar.E = 0;
        progressbar.g = 100;
        a2.B = 0;
        a2.k = "";
        a2.ALLATORIxDEMO();
    }

    public static /* synthetic */ void addValue() {
        Progressbar.setValue(++Progressbar.instance.E);
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        Progressbar a3;
        if (a2) {
            a3.setLocationRelativeTo(null);
        }
        super.setVisible(a2);
        if (!a2) {
            a3.H();
        }
    }

    public static /* synthetic */ void setTitle(String a2, int a3) {
        Progressbar.setSteps(a3);
        instance.setTitle(a2);
    }

    public static /* synthetic */ void setMinimum(int a2) {
        Progressbar.instance.B = a2;
        Progressbar.instance.d.setMinimum(Progressbar.instance.B);
    }
}

