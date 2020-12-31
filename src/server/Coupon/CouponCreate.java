/*
 * Decompiled with CFR 0.150.
 */
package server.Coupon;

import client.SkillEntry;
import handling.auction.handler.MTSOperation;
import java.sql.SQLException;
import server.Coupon.Coupon;
import server.Coupon.CouponFactory;
import server.Coupon.CouponReward;
import server.MapleItemInformationProvider;
import server.Randomizer;
import tools.FilePrinter;

public class CouponCreate {
    private static /* synthetic */ CouponCreate ALLATORIxDEMO;

    public /* synthetic */ CouponCreate() {
        CouponCreate a2;
    }

    public static /* synthetic */ String RandomItem(boolean a2) {
        CouponReward couponReward;
        Coupon coupon2 = new Coupon();
        String string = coupon2.checkedCouponCode();
        CouponReward couponReward2 = couponReward = coupon2.generateReward();
        int n2 = Randomizer.rand(couponReward.getMinNumber(), couponReward2.getMaxNumber());
        int n3 = couponReward2.getItemId() == 1 ? 1 : (couponReward.getItemId() == 2 ? 2 : 3);
        try {
            CouponFactory.CreateNXCode(string, n3, couponReward.getItemId(), n2);
        }
        catch (SQLException sQLException) {
            FilePrinter.printError(MTSOperation.ALLATORIxDEMO("`#V<L\"e-@8L>ZbW4W"), "CreateNXCode" + sQLException);
            return SkillEntry.ALLATORIxDEMO("\u5ebe\u864a\u5244\u5eef\u5900\u6542\u001d\u8ade\u805e\u7e7e\u7b90\u7413\u54d04");
        }
        if (a2) {
            return "#b\u514c\u63db\u5238\u5275\u5efa\u6210\u529f! \u60a8\u7684\u514c\u63db\u5e8f\u865f\u70ba: #r" + string + "#b\u8acb\u81f3\u5546\u57ce\u8f38\u5165\u514c\u63db!";
        }
        return string;
    }

    public static /* synthetic */ String RandomItem() {
        return CouponCreate.RandomItem(true);
    }

    public static final /* synthetic */ CouponCreate getInstance() {
        if (ALLATORIxDEMO == null) {
            ALLATORIxDEMO = new CouponCreate();
        }
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ String CreateNXCode(int a2, int a3, int a42, int a5) {
        String string = new Coupon().checkedCouponCode();
        try {
            CouponFactory.CreateNXCode_Center(string, a2, a3, a42, a5);
        }
        catch (SQLException a42) {
            FilePrinter.printError(MTSOperation.ALLATORIxDEMO("`#V<L\"e-@8L>ZbW4W"), "CreateNXCode" + a42);
            return SkillEntry.ALLATORIxDEMO("\u5ebe\u864a\u5244\u5eef\u5900\u6542\u001d\u8ade\u805e\u7e7e\u7b90\u7413\u54d04");
        }
        Object a42 = "";
        switch (a2) {
            case 1: {
                while (false) {
                }
                a42 = "\u9ede\u6578: " + a3 + " \u9ede";
                break;
            }
            case 2: {
                a42 = "\u6953\u9ede: " + a3 + " \u9ede";
                break;
            }
            default: {
                a42 = "\u7269\u54c1:" + MapleItemInformationProvider.getInstance().getName(a3);
            }
        }
        Object[] arrobject = new Object[3];
        arrobject[0] = SkillEntry.ALLATORIxDEMO("j\u5159\u63ea\u5e9a\u866eH\u0011/");
        arrobject[1] = string;
        arrobject[2] = a42;
        return String.format(MTSOperation.ALLATORIxDEMO("i\u000e}\u0013?*i\u000eyPE\u0006a\u0012|P"), arrobject);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new CouponCreate();
    }
}

