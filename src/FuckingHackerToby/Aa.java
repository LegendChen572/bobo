/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Na;
import FuckingHackerToby.ja;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import server.StructSetItem;
import tools.html.getHtml;

public final class Aa
extends AbstractTableModel {
    private static final /* synthetic */ ja<String> K;
    private static final /* synthetic */ ja<Boolean> d;
    private /* synthetic */ ArrayList<Na> C;
    private static final /* synthetic */ ja<Long> ALLATORIxDEMO;
    private /* synthetic */ ArrayList<ja<?>> H;
    private static final /* synthetic */ ja<ImageIcon> E;
    private static final /* synthetic */ ja<String> k;
    private static final /* synthetic */ ja<String> g;
    private static final /* synthetic */ ja<String> B;
    private static final /* synthetic */ long F = 919111102883611810L;
    private static final /* synthetic */ ja<String> e;
    private static final /* synthetic */ ja<Boolean> a;

    @Override
    public /* synthetic */ String getColumnName(int a2) {
        Aa a3;
        int n2 = a3.H.size();
        if (a2 <= n2 - 1 && a2 >= 0) {
            return a3.H.get((int)a2).a;
        }
        return super.getColumnName(a2);
    }

    @Override
    public /* synthetic */ int getColumnCount() {
        Aa a2;
        return a2.H.size();
    }

    @Override
    public /* synthetic */ Object getValueAt(int a22, int a3) {
        Aa a4;
        Aa aa2 = a4;
        Na a22 = aa2.ALLATORIxDEMO(a22);
        int n2 = aa2.H.size();
        if (a22 == null || a3 > n2 - 1 || a3 < 0) {
            return null;
        }
        return a4.H.get((int)a3).ALLATORIxDEMO.apply(a22);
    }

    public static /* synthetic */ {
        e = new ja<String>(StructSetItem.ALLATORIxDEMO("*G\tC"), String.class, Na::E);
        E = new ja<ImageIcon>(getHtml.ALLATORIxDEMO("'e\bk\u001fc\u0004d"), ImageIcon.class, Na::ALLATORIxDEMO);
        g = new ja<String>(StructSetItem.ALLATORIxDEMO("-vDG\u0000B\u0016C\u0017U"), String.class, Na::D);
        B = new ja<String>(getHtml.ALLATORIxDEMO("'e\bk\u0007*\u001be\u0019~"), String.class, Na::ALLATORIxDEMO);
        k = new ja<String>("Operating system", String.class, Na::l);
        K = new ja<String>(StructSetItem.ALLATORIxDEMO("p\u0001T\u0017O\u000bH"), String.class, Na::H);
        a = new ja<Boolean>(getHtml.ALLATORIxDEMO("Y\u001fx\u000ek\u0006c\u0005mKn\u000ey\u0000~\u0004z"), Boolean.class, Na::H);
        d = new ja<Boolean>(StructSetItem.ALLATORIxDEMO("u\u0010T\u0001G\tO\nADP\u000bO\u0007C"), Boolean.class, Na::ALLATORIxDEMO);
        ALLATORIxDEMO = new ja<Long>(getHtml.ALLATORIxDEMO(";c\u0005m"), Long.class, Na::ALLATORIxDEMO);
    }

    public /* synthetic */ Aa() {
        Aa a2;
        Aa aa2 = a2;
        Aa aa3 = a2;
        aa2.C = new ArrayList();
        aa3.H = new ArrayList();
        aa2.H(e);
        aa2.H(E);
        aa2.H(g);
        aa2.H(B);
        aa2.H(k);
        aa2.H(K);
        aa2.H(a);
        aa2.H(d);
        aa2.H(ALLATORIxDEMO);
    }

    public /* synthetic */ void D(Na a2) {
        Aa a3;
        SwingUtilities.invokeLater(() -> {
            Aa a3;
            a3.C.add(a2);
            a3.fireTableDataChanged();
        });
    }

    public /* synthetic */ void l(Na a2) {
        Aa a3;
        SwingUtilities.invokeLater(() -> {
            Aa a3;
            a3.C.remove(a2);
            a3.fireTableDataChanged();
        });
    }

    public /* synthetic */ void ALLATORIxDEMO(ja<?> a2) {
        Aa a3;
        a3.H.remove(a2);
    }

    @Override
    public /* synthetic */ boolean isCellEditable(int a2, int a3) {
        return false;
    }

    public /* synthetic */ void H(ja<?> a2) {
        Aa a3;
        a3.H.add(a2);
    }

    @Override
    public /* synthetic */ int getRowCount() {
        Aa a2;
        return a2.C.size();
    }

    public /* synthetic */ Na ALLATORIxDEMO(int a2) {
        Aa a3;
        if (a2 <= a3.C.size() - 1 && a2 >= 0) {
            return a3.C.get(a2);
        }
        return null;
    }

    public /* synthetic */ Na[] ALLATORIxDEMO(int ... a2) {
        int n2;
        Na[] arrna = new Na[a2.length];
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            Aa a3;
            int n4 = a2[n2];
            arrna[n2++] = a3.ALLATORIxDEMO(n4);
            n3 = n2;
        }
        return arrna;
    }

    @Override
    public /* synthetic */ Class<?> getColumnClass(int a2) {
        Aa a3;
        int n2 = a3.H.size();
        if (a2 <= n2 - 1 && a2 >= 0) {
            return a3.H.get((int)a2).d;
        }
        return super.getColumnClass(a2);
    }
}

