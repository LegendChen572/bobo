/*
 * Decompiled with CFR 0.150.
 */
package constants.skills;

public class SkillType {
    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ 4;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ 3;
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

    public /* synthetic */ SkillType() {
        SkillType a2;
    }

    public static class GM {
        public static final /* synthetic */ int \u7d42\u6975\u8f15\u529f = 9001001;
        public static final /* synthetic */ int \u7d42\u6975\u7948\u79b1 = 9001002;
        public static final /* synthetic */ int \u7d42\u6975\u8056\u706b = 9001008;
        public static final /* synthetic */ int \u7d42\u6975\u795d\u798f = 9001003;
        public static final /* synthetic */ int \u5fa9\u6d3b = 9001005;
        public static final /* synthetic */ int \u7d42\u6975\u77ac\u79fb = 9001007;
        public static final /* synthetic */ int \u6e2c\u8b0a\u6a5f = 9001009;
        public static final /* synthetic */ int \u7d42\u6975\u96b1\u85cf = 9001004;
        public static final /* synthetic */ int \u7d42\u6975\u9f8d\u5486\u54ee = 9001006;
        public static final /* synthetic */ int \u7d42\u6975\u6de8\u5316 = 9001000;

        public /* synthetic */ GM() {
            GM a2;
        }
    }
}

