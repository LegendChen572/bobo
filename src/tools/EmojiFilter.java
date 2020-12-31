/*
 * Decompiled with CFR 0.150.
 */
package tools;

import constants.GameSetConstants;
import database.DBConPool;
import java.sql.SQLException;
import server.Extend.SpecialItemData;
import server.maps.MapleNodes;
import tools.FileoutputUtil;

/*
 * Exception performing whole class analysis ignored.
 */
public class EmojiFilter {
    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ (3 << 2 ^ 1);
        int n5 = n3;
        int n6 = 4 << 4 ^ (3 ^ 5) << 1;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public static /* synthetic */ String filterEmoji(String a2) {
        int n2;
        int n3 = a2.length();
        StringBuilder stringBuilder = new StringBuilder(n3);
        int n4 = n2 = 0;
        while (n4 < n3) {
            char c2 = a2.charAt(n2);
            if (EmojiFilter.ALLATORIxDEMO(c2)) {
                stringBuilder.append(c2);
            }
            n4 = ++n2;
        }
        return stringBuilder.toString();
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(char a2) {
        return a2 == '\u0000' || a2 == '\t' || a2 == '\n' || a2 == '\r' || a2 >= ' ' && a2 <= '\ud7ff' || a2 >= '\ue000' && a2 <= '\ufffd' || a2 >= '\u10000' && a2 <= '\u10ffff';
    }

    public /* synthetic */ EmojiFilter() {
        EmojiFilter a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void SupportEmoji_BuddyGroupName() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var1_2 = null;
            var1_2 = var0.prepareStatement(SpecialItemData.ALLATORIxDEMO("rdgma\bgiqdv\bSJFLWAV[S\bp`rftm\u0013HTZ\\]CFREVH\u0013HTZ\\]CFREVH\u0013~rzp`rz\u001b\u0019\u0004\u0001\u0013k{iaip|vz\u0013{v|\u0013]GN\u000bEQ\u001c\u0013k|d\u007figm\u0013]GN\u000bEQ\u001cl]]APGWMlKZ\b}gg\b}}\u007fd\u0013lvnr}\u007f|\u0013\u000f\u5c29\u6702\u8a1e\u5bb2\u7f97\u7d6c\u0014"));
            var1_2.execute();
            var1_2.close();
            ** if (var0 == null) goto lbl-1000
        }
        catch (Throwable var1_3) {
            if (var0 == null) ** GOTO lbl23
            try {
                var0.close();
                v0 = var1_3;
                ** GOTO lbl24
            }
            catch (Throwable var2_4) {
                try {
                    var1_3.addSuppressed(var2_4);
lbl23:
                    // 2 sources

                    v0 = var1_3;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    FileoutputUtil.outError(MapleNodes.ALLATORIxDEMO("bCi_!\u007f{\\~C|XKAaFgsLYjHwk|C{\\@McI\u757e\u5e14 XvX"), var0_1);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var0.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void SupportEmoji_bbs_threads_name() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var1_2 = null;
            var1_2 = var0.prepareStatement(SpecialItemData.ALLATORIxDEMO("rdgma\bgiqdv\bSJQ[l\\[ZVIW[S\bp`rftm\u0013H]I^MS\bSFREVH\u0013~rzp`rz\u001b\u001a\u0005\u0001\u0013k{iaip|vz\u0013{v|\u0013]GN\u000bEQ\u001c\u0013k|d\u007figm\u0013]GN\u000bEQ\u001cl]]APGWMlKZ\b}gg\b}}\u007fd\u0013lvnr}\u007f|\u0013\u000f\u0014"));
            var1_2.execute();
            var1_2.close();
            ** if (var0 == null) goto lbl-1000
        }
        catch (Throwable var1_3) {
            if (var0 == null) ** GOTO lbl23
            try {
                var0.close();
                v0 = var1_3;
                ** GOTO lbl24
            }
            catch (Throwable var2_4) {
                try {
                    var1_3.addSuppressed(var2_4);
lbl23:
                    // 2 sources

                    v0 = var1_3;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    FileoutputUtil.outError(MapleNodes.ALLATORIxDEMO("bCi_!\u007f{\\~C|XKAaFgslN}szD|IoH}s`McI\u757e\u5e14 XvX"), var0_1);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var0.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void SupportEmoji_Default() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var1_2 = null;
            var1_2 = var0.prepareStatement("ALTER DATABASE " + GameSetConstants.dbName + " CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin");
            var1_2.execute();
            var1_2.close();
            ** if (var0 == null) goto lbl-1000
        }
        catch (Throwable var1_3) {
            if (var0 == null) ** GOTO lbl23
            try {
                var0.close();
                v0 = var1_3;
                ** GOTO lbl24
            }
            catch (Throwable var2_4) {
                try {
                    var1_3.addSuppressed(var2_4);
lbl23:
                    // 2 sources

                    v0 = var1_3;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    FileoutputUtil.outError(MapleNodes.ALLATORIxDEMO("@aK}\u0003]Y~\\a^zicCdE\u757e\u5e14 XvX"), var0_1);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var0.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void SupportEmoji_bbs_threads_content() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var1_2 = null;
            var1_2 = var0.prepareStatement(SpecialItemData.ALLATORIxDEMO("rdgma\bgiqdv\bSJQ[lZVX_AV[S\bp`rftm\u0013HPG]\\VFGH\u0013HPG]\\VFGH\u0013~rzp`rz\u001b\u001a\u0005\u0001\u0013k{iaip|vz\u0013{v|\u0013]GN\u000bEQ\u001c\u0013k|d\u007figm\u0013]GN\u000bEQ\u001cl]]APGWMlKZ\b}gg\b}}\u007fd\u0013lvnr}\u007f|\u0013\u000f\u0014"));
            var1_2.execute();
            var1_2.close();
            ** if (var0 == null) goto lbl-1000
        }
        catch (Throwable var1_3) {
            if (var0 == null) ** GOTO lbl23
            try {
                var0.close();
                v0 = var1_3;
                ** GOTO lbl24
            }
            catch (Throwable var2_4) {
                try {
                    var1_3.addSuppressed(var2_4);
lbl23:
                    // 2 sources

                    v0 = var1_3;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    FileoutputUtil.outError(MapleNodes.ALLATORIxDEMO("@aK}\u0003]Y~\\a^zicCdEQNl_QXf^kMj_QOaBzI`X\u757e\u5e14 XvX"), var0_1);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var0.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void SupportEmoji_bbs_threads_startpost() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var1_2 = null;
            var1_2 = var0.prepareStatement(SpecialItemData.ALLATORIxDEMO("rdgma\bgiqdv\bSJQ[l\\[ZVIW[S\bp`rftm\u0013H@\\RZGX\\[GH\u0013H@\\RZGX\\[GH\u0013|vpg\bp`rzrkgma\b`mg\bF\\U\u0010^J\u0007\bpg\u007fdr|v\bF\\U\u0010^J\u0007wFFZK\\LVwPA\u0013f||\u0013ffd\u007f"));
            var1_2.execute();
            var1_2.close();
            ** if (var0 == null) goto lbl-1000
        }
        catch (Throwable var1_3) {
            if (var0 == null) ** GOTO lbl23
            try {
                var0.close();
                v0 = var1_3;
                ** GOTO lbl24
            }
            catch (Throwable var2_4) {
                try {
                    var1_3.addSuppressed(var2_4);
lbl23:
                    // 2 sources

                    v0 = var1_3;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    FileoutputUtil.outError(MapleNodes.ALLATORIxDEMO("@aK}\u0003]Y~\\a^zicCdEQNl_QXf^kMj_Q_zM|X~C}X\u757e\u5e14 XvX"), var0_1);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var0.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void SupportEmoji_charmessage() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var1_2 = null;
            var1_2 = var0.prepareStatement(SpecialItemData.ALLATORIxDEMO("rdgma\bgiqdv\bSK[IAIP\\VZ@H\u0013k{i}ov\bSK[IAEV[@ITMS\bSK[IAEV[@ITMS\beiak{ia\u0000\u0001\u001d\u0006\u0001\u0013k{iaip|vz\u0013{v|\u0013]GN\u000bEQ\u001c\u0013k|d\u007figm\u0013]GN\u000bEQ\u001cl]]APGWMlKZ\b}gg\b}}\u007fd\u0013lvnr}\u007f|\u0013\u000f\u5bba\u5ba1\u0014"));
            var1_2.execute();
            var1_2.close();
            ** if (var0 == null) goto lbl-1000
        }
        catch (Throwable var1_3) {
            if (var0 == null) ** GOTO lbl23
            try {
                var0.close();
                v0 = var1_3;
                ** GOTO lbl24
            }
            catch (Throwable var2_4) {
                try {
                    var1_3.addSuppressed(var2_4);
lbl23:
                    // 2 sources

                    v0 = var1_3;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    FileoutputUtil.outError(MapleNodes.ALLATORIxDEMO("@aK}\u0003]Y~\\a^zicCdEQOfM|Ak_}MiI\u757e\u5e14 XvX"), var0_1);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var0.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void SupportEmoji_SkillMacroName() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var1_2 = null;
            var1_2 = var0.prepareStatement(SpecialItemData.ALLATORIxDEMO("i\u007f|vz\u0013|rj\u007fm\u0013H@CZD_ERKAG@H\u0013k{i}ov\bSFREVH\u0013H]I^MS\beiak{ia\u0000\u0001\u001d\u0006\u0001\u0013k{iaip|vz\u0013{v|\u0013]GN\u000bEQ\u001c\u0013k|d\u007figm\u0013]GN\u000bEQ\u001cl]]APGWMlKZ\b}}\u007fd\u0013lvnr}\u007f|\u0013ffd\u007f"));
            var1_2.execute();
            var1_2.close();
            ** if (var0 == null) goto lbl-1000
        }
        catch (Throwable var1_3) {
            if (var0 == null) ** GOTO lbl23
            try {
                var0.close();
                v0 = var1_3;
                ** GOTO lbl24
            }
            catch (Throwable var2_4) {
                try {
                    var1_3.addSuppressed(var2_4);
lbl23:
                    // 2 sources

                    v0 = var1_3;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    FileoutputUtil.outError(MapleNodes.ALLATORIxDEMO("bCi_!\u007f{\\~C|XKAaFgs]Gg@baoO|C@McI\u757e\u5e14 XvX"), var0_1);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var0.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public static /* synthetic */ void SupportAllEmoji() {
        EmojiFilter.SupportEmoji_Default();
        EmojiFilter.SupportEmoji_charmessage();
        EmojiFilter.SupportEmoji_SkillMacroName();
        EmojiFilter.SupportEmoji_BuddyGroupName();
        EmojiFilter.SupportEmoji_bbs_threads_content();
        EmojiFilter.SupportEmoji_bbs_threads_name();
        EmojiFilter.SupportEmoji_bbs_threads_startpost();
    }
}

