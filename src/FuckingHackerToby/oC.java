/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.G;
import FuckingHackerToby.ka;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class oC
extends ka<G>
implements KeyListener {
    private static final /* synthetic */ boolean d = true;
    private static final /* synthetic */ boolean ALLATORIxDEMO = false;

    public /* synthetic */ oC() {
        oC a2;
    }

    @Override
    public /* synthetic */ void keyPressed(KeyEvent a2) {
        oC a3;
        a3.ALLATORIxDEMO(a2, true);
    }

    @Override
    public /* synthetic */ void keyReleased(KeyEvent a2) {
        oC a3;
        a3.ALLATORIxDEMO(a2, false);
    }

    private /* synthetic */ void ALLATORIxDEMO(KeyEvent a2, boolean a3) {
        oC a4;
        a4.ALLATORIxDEMO(arg_0 -> oC.ALLATORIxDEMO(a2.getKeyCode(), a3, arg_0));
    }

    private static /* synthetic */ void ALLATORIxDEMO(int a2, boolean a3, G a4) {
        a4.ALLATORIxDEMO(a2, a3);
    }

    @Override
    public /* synthetic */ void keyTyped(KeyEvent a2) {
    }
}

