/*
 * Decompiled with CFR 0.150.
 */
package server.swing.autoupdate;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressUI
extends BasicProgressBarUI {
    private /* synthetic */ int d;
    private /* synthetic */ Color ALLATORIxDEMO;
    private /* synthetic */ JProgressBar a;

    @Override
    public /* synthetic */ void paintDeterminate(Graphics a2, JComponent a3) {
        ProgressUI a4;
        ProgressUI progressUI = a4;
        a4.a.setBackground(new Color(255, 255, 255));
        progressUI.a.setForeground(Color.GREEN);
        super.paintDeterminate(a2, a3);
    }

    public /* synthetic */ ProgressUI(JProgressBar a2, Color a3) {
        ProgressUI a4;
        ProgressUI progressUI = a4;
        progressUI.a = a2;
        progressUI.ALLATORIxDEMO = a3;
    }
}

