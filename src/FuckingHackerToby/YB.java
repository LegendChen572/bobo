/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.D;
import FuckingHackerToby.ka;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class YB
extends ka<D>
implements MouseListener,
MouseMotionListener,
MouseWheelListener {
    private /* synthetic */ float E;
    private static final /* synthetic */ int ALLATORIxDEMO = 0;
    private /* synthetic */ int B;
    private static final /* synthetic */ boolean K = true;
    private /* synthetic */ int k;
    private static final /* synthetic */ int d = 1;
    private /* synthetic */ float g;
    private static final /* synthetic */ boolean a = false;

    private /* synthetic */ int ALLATORIxDEMO(int a2) {
        YB a3;
        return (int)((float)a2 / a3.g - (float)a3.k / a3.g);
    }

    public /* synthetic */ void ALLATORIxDEMO(int a2, int a3) {
        YB a4;
        YB yB = a4;
        yB.B = a2;
        yB.k = a3;
    }

    @Override
    public /* synthetic */ void mouseDragged(MouseEvent a2) {
        YB a3;
        a3.ALLATORIxDEMO(a2);
    }

    @Override
    public /* synthetic */ void mouseExited(MouseEvent a2) {
    }

    private /* synthetic */ void ALLATORIxDEMO(MouseEvent a22, boolean a3) {
        YB a4;
        YB yB = a4;
        MouseEvent mouseEvent = a22;
        int a22 = a4.H(mouseEvent.getX());
        int n2 = yB.ALLATORIxDEMO(mouseEvent.getY());
        int n3 = a22.getButton();
        yB.ALLATORIxDEMO(a6 -> a6.ALLATORIxDEMO(a22, n2, n3, a3));
    }

    public /* synthetic */ YB() {
        YB a2;
        a2.g = 1.0f;
        a2.E = 1.0f;
        YB yB = a2;
        yB.k = 0;
        yB.B = 0;
    }

    @Override
    public /* synthetic */ void mouseReleased(MouseEvent a2) {
        YB a3;
        a3.ALLATORIxDEMO(a2, false);
    }

    @Override
    private /* synthetic */ void ALLATORIxDEMO(MouseWheelEvent a22) {
        YB a3;
        YB yB = a3;
        MouseWheelEvent mouseWheelEvent = a22;
        int a22 = a3.H(mouseWheelEvent.getX());
        int n2 = yB.ALLATORIxDEMO(mouseWheelEvent.getY());
        int n3 = a22.getWheelRotation();
        yB.ALLATORIxDEMO(a5 -> a5.ALLATORIxDEMO(a22, n2, n3));
    }

    @Override
    public /* synthetic */ void mouseEntered(MouseEvent a2) {
    }

    @Override
    public /* synthetic */ void mousePressed(MouseEvent a2) {
        YB a3;
        a3.ALLATORIxDEMO(a2, true);
    }

    private /* synthetic */ int H(int a2) {
        YB a3;
        return (int)((float)a2 / a3.E - (float)a3.B / a3.E);
    }

    @Override
    public /* synthetic */ void mouseWheelMoved(MouseWheelEvent a2) {
        YB a3;
        a3.ALLATORIxDEMO(a2);
    }

    @Override
    public /* synthetic */ void mouseClicked(MouseEvent a2) {
    }

    @Override
    private /* synthetic */ void ALLATORIxDEMO(MouseEvent a22) {
        YB a3;
        YB yB = a3;
        MouseEvent mouseEvent = a22;
        int a22 = a3.H(mouseEvent.getX());
        int n2 = yB.ALLATORIxDEMO(mouseEvent.getY());
        int n3 = a22.getModifiers();
        yB.ALLATORIxDEMO(a5 -> a5.H(a22, n2, n3));
    }

    public /* synthetic */ void ALLATORIxDEMO(float a2, float a3) {
        YB a4;
        YB yB = a4;
        yB.E = a2;
        yB.g = a3;
    }

    @Override
    public /* synthetic */ void mouseMoved(MouseEvent a2) {
        YB a3;
        a3.ALLATORIxDEMO(a2);
    }
}

