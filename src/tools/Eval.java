/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.ItemVac;
import client.messages.commands.player.eventSystem.BankSystem;
import handling.world.CheaterData;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;
import tools.FixDropNullItem;
import tools.LoadPacket;
import tools.data.RandomAccessByteStream;
import tools.googledrive.SyncServerData;

public final class Eval {
    private final /* synthetic */ Operation ALLATORIxDEMO;

    public static /* synthetic */ BigDecimal eval(String a2) {
        return new Eval(a2).eval();
    }

    public static /* synthetic */ BigDecimal eval(String a2, Map<String, BigDecimal> a3) {
        return new Eval(a2).eval(a3);
    }

    public /* synthetic */ String toString() {
        Eval a2;
        return a2.ALLATORIxDEMO.toString();
    }

    public /* synthetic */ BigDecimal eval(Map<String, BigDecimal> a2) {
        Eval a3;
        return a3.ALLATORIxDEMO.ALLATORIxDEMO(a2);
    }

    public /* synthetic */ BigDecimal eval() {
        Eval a2;
        return a2.eval(null);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ (3 << 2 ^ 3);
        int cfr_ignored_0 = 2 ^ 5;
        int n5 = n3;
        int n6 = 4 << 4 ^ 2 << 1;
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

    public /* synthetic */ Eval(String a2) {
        Eval a3;
        Eval eval = a3;
        eval.ALLATORIxDEMO = new Compiler(a2).ALLATORIxDEMO();
    }

    public static class Compiler {
        private final /* synthetic */ Tokeniser ALLATORIxDEMO;

        public /* synthetic */ Operation ALLATORIxDEMO() {
            Compiler a2;
            Object object = a2.ALLATORIxDEMO(null, null, '\u0000', '\u0000', -1);
            if (object instanceof Operation) {
                return (Operation)object;
            }
            return Operation.ALLATORIxDEMO(object);
        }

        public /* synthetic */ Compiler(String a2) {
            Compiler a3;
            Compiler compiler = a3;
            compiler.ALLATORIxDEMO = new Tokeniser(a2);
        }

        private /* synthetic */ Object ALLATORIxDEMO(int a2) {
            Compiler a3;
            Object object = a3.ALLATORIxDEMO.ALLATORIxDEMO();
            if (object == Tokeniser.K) {
                object = a3.ALLATORIxDEMO(null, null, a2 + 1, ')', -1);
                return object;
            }
            if (object instanceof Operator) {
                return Operation.ALLATORIxDEMO((Operator)((Object)object), a3.ALLATORIxDEMO(a2));
            }
            return object;
        }

        private /* synthetic */ Object ALLATORIxDEMO(Object a2, Operator a3, int a4, char a5, int a6) {
            Compiler a7;
            Object object = a2 != null ? a2 : a7.ALLATORIxDEMO(a4);
            Operator operator = a3 != null ? a3 : a7.ALLATORIxDEMO.ALLATORIxDEMO(a5);
            block0: while (true) {
                Operator operator2 = operator;
                while (operator2 != Operator.END) {
                    Object object2;
                    Object object3;
                    if (operator == Operator.TERNARY) {
                        Compiler compiler = a7;
                        object3 = compiler.ALLATORIxDEMO(null, null, a4, ':', -1);
                        object2 = compiler.ALLATORIxDEMO(null, null, a4, a5, -1);
                        object = Operation.ALLATORIxDEMO(operator, object, object3, object2);
                        operator2 = Operator.END;
                        continue;
                    }
                    Compiler compiler = a7;
                    object3 = compiler.ALLATORIxDEMO(a4);
                    object2 = compiler.ALLATORIxDEMO.ALLATORIxDEMO(a5);
                    if (object2 == Operator.END) {
                        object = Operation.ALLATORIxDEMO(operator, object, object3);
                        operator = Operator.END;
                        if (a3 == null || a5 == '\u0000') continue block0;
                        a7.ALLATORIxDEMO.ALLATORIxDEMO(Operator.END);
                        continue block0;
                    }
                    if (object2.B <= a6) {
                        object = Operation.ALLATORIxDEMO(operator, object, object3);
                        a7.ALLATORIxDEMO.ALLATORIxDEMO((Operator)((Object)object2));
                        operator = Operator.END;
                        continue block0;
                    }
                    if (operator.B >= object2.B) {
                        object = Operation.ALLATORIxDEMO(operator, object, object3);
                        operator = object2;
                        continue block0;
                    }
                    object = Operation.ALLATORIxDEMO(operator, object, a7.ALLATORIxDEMO(object3, (Operator)((Object)object2), a4, a5, operator.B));
                    operator = a7.ALLATORIxDEMO.ALLATORIxDEMO(a5);
                    if (operator != Operator.END || a3 == null || a5 == '\u0000') continue block0;
                    a7.ALLATORIxDEMO.ALLATORIxDEMO(Operator.END);
                    continue block0;
                }
                break;
            }
            return object;
        }
    }

    public static final class Operation {
        public final /* synthetic */ Object ALLATORIxDEMO;
        public final /* synthetic */ Operator K;
        public final /* synthetic */ Type k;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object a;

        /*
         * Enabled aggressive block sorting
         */
        public /* synthetic */ BigDecimal ALLATORIxDEMO(Map<String, BigDecimal> a2) {
            Operation a3;
            switch (a3.K.k) {
                case 3: {
                    Operation operation = a3;
                    Operation operation2 = a3;
                    Operation operation3 = a3;
                    return a3.K.ALLATORIxDEMO(operation.ALLATORIxDEMO(operation.a, a2), operation2.ALLATORIxDEMO(operation2.d, a2), operation3.ALLATORIxDEMO(operation3.ALLATORIxDEMO, a2));
                }
                case 2: {
                    Operation operation = a3;
                    Operation operation4 = a3;
                    return a3.K.ALLATORIxDEMO(operation.ALLATORIxDEMO(operation.a, a2), operation4.ALLATORIxDEMO(operation4.d, a2), null);
                }
            }
            Operation operation = a3;
            return a3.K.ALLATORIxDEMO(operation.ALLATORIxDEMO(operation.a, a2), null, null);
        }

        public static /* synthetic */ Operation ALLATORIxDEMO(Object a2) {
            return new Operation(Operator.NOP.a, Operator.NOP, a2, null, null);
        }

        private static /* synthetic */ void ALLATORIxDEMO(Object a2, Type a3) {
            Type type;
            if (a2 instanceof Operation && (type = ((Operation)a2).k) != a3) {
                throw new RuntimeException("cannot use " + type.d + " operands with " + a3.d + " operators");
            }
        }

        private /* synthetic */ Operation(Type a2, Operator a3, Object a4, Object a5, Object a6) {
            Operation a7;
            Operation operation = a7;
            Operation operation2 = a7;
            a7.k = a2;
            operation2.K = a3;
            operation2.a = a4;
            operation.d = a5;
            operation.ALLATORIxDEMO = a6;
        }

        public static /* synthetic */ Object ALLATORIxDEMO(Operator a2, Object a3, Object a4, Object a5) {
            Object object = a3;
            Operation.ALLATORIxDEMO(object, Type.BOOLEAN);
            Operation.ALLATORIxDEMO(a4, Type.ARITHMETIC);
            Operation.ALLATORIxDEMO(a5, Type.ARITHMETIC);
            if (object instanceof BigDecimal) {
                if (((BigDecimal)a3).signum() != 0) {
                    return a4;
                }
                return a5;
            }
            return new Operation(Type.ARITHMETIC, a2, a3, a4, a5);
        }

        public static /* synthetic */ Object ALLATORIxDEMO(Operator a2, Object a3) {
            Object object = a3;
            Operation.ALLATORIxDEMO(object, a2.d);
            if (object instanceof BigDecimal) {
                return a2.ALLATORIxDEMO((BigDecimal)a3, null, null);
            }
            return new Operation(a2.a, a2, a3, null, null);
        }

        public static /* synthetic */ Object ALLATORIxDEMO(Operator a2, Object a3, Object a4) {
            Object object = a3;
            Operation.ALLATORIxDEMO(object, a2.d);
            Operation.ALLATORIxDEMO(a4, a2.d);
            if (object instanceof BigDecimal && a4 instanceof BigDecimal) {
                return a2.ALLATORIxDEMO((BigDecimal)a3, (BigDecimal)a4, null);
            }
            return new Operation(a2.a, a2, a3, a4, null);
        }

        public /* synthetic */ String toString() {
            Operation a2;
            switch (a2.K.k) {
                case 3: {
                    Operation operation = a2;
                    Operation operation2 = a2;
                    return "(" + operation.a + operation.K.K + operation2.d + ":" + operation2.ALLATORIxDEMO + ")";
                }
                case 2: {
                    Operation operation = a2;
                    while (false) {
                    }
                    return "(" + operation.a + operation.K.K + a2.d + ")";
                }
            }
            return "(" + a2.K.K + a2.a + ")";
        }

        private /* synthetic */ BigDecimal ALLATORIxDEMO(Object a2, Map<String, BigDecimal> a3) {
            if (a2 instanceof Operation) {
                return ((Operation)a2).ALLATORIxDEMO(a3);
            }
            if (a2 instanceof String) {
                BigDecimal bigDecimal;
                if (a3 == null || (bigDecimal = a3.get(a2)) == null) {
                    throw new RuntimeException("no value for variable \"" + a2 + "\"");
                }
                return bigDecimal;
            }
            return (BigDecimal)a2;
        }
    }

    public static abstract class Operator
    extends Enum<Operator> {
        public static final /* synthetic */ /* enum */ Operator SUB;
        public static final /* synthetic */ /* enum */ Operator NE;
        public static final /* synthetic */ /* enum */ Operator CEIL;
        public static final /* synthetic */ /* enum */ Operator ABS;
        public final /* synthetic */ Type a;
        public static final /* synthetic */ /* enum */ Operator NEG;
        public static final /* synthetic */ /* enum */ Operator ADD;
        public static final /* synthetic */ /* enum */ Operator MUL;
        private static final /* synthetic */ Operator[] ALLATORIxDEMO;
        public final /* synthetic */ Type d;
        public final /* synthetic */ int B;
        public static final /* synthetic */ /* enum */ Operator POW;
        public static final /* synthetic */ /* enum */ Operator LT;
        public final /* synthetic */ int k;
        public static final /* synthetic */ /* enum */ Operator END;
        public static final /* synthetic */ /* enum */ Operator GE;
        public static final /* synthetic */ /* enum */ Operator AND;
        public static final /* synthetic */ /* enum */ Operator REMAINDER;
        public static final /* synthetic */ /* enum */ Operator DIV;
        public static final /* synthetic */ /* enum */ Operator GT;
        public static final /* synthetic */ /* enum */ Operator LE;
        public static final /* synthetic */ /* enum */ Operator FLOOR;
        public final /* synthetic */ String K;
        public static final /* synthetic */ /* enum */ Operator NOP;
        public static final /* synthetic */ /* enum */ Operator EQ;
        public static final /* synthetic */ /* enum */ Operator OR;
        public static final /* synthetic */ /* enum */ Operator TERNARY;
        public static final /* synthetic */ /* enum */ Operator PLUS;
        public static final /* synthetic */ /* enum */ Operator INT;

        public abstract /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal var1, BigDecimal var2, BigDecimal var3);

        public static /* synthetic */ Operator valueOf(String a2) {
            return Enum.valueOf(Operator.class, a2);
        }

        public static /* synthetic */ {
            END = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\bK\t"), 0, -1, 0, null, null, null){
                {
                    1 a7;
                }

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    throw new RuntimeException(ItemVac.ALLATORIxDEMO("P;QU|\u00065\u00145\u0011`\u0018x\f5\u001ae\u0010g\u0014a\u001cz\u001b"));
                }
            };
            TERNARY = new Operator(BankSystem.ALLATORIxDEMO("#6%=6!."), 1, 0, 3, RandomAccessByteStream.ALLATORIxDEMO("r"), null, null){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.signum() != 0) {
                        return a3;
                    }
                    return a4;
                }
                {
                    2 a7;
                }
            };
            AND = new Operator(BankSystem.ALLATORIxDEMO("6=3"), 2, 0, 2, RandomAccessByteStream.ALLATORIxDEMO("#k"), Type.BOOLEAN, Type.BOOLEAN){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.signum() != 0 && a3.signum() != 0) {
                        return BigDecimal.ONE;
                    }
                    return BigDecimal.ZERO;
                }
                {
                    3 a7;
                }
            };
            OR = new Operator(BankSystem.ALLATORIxDEMO("<%"), 3, 0, 2, RandomAccessByteStream.ALLATORIxDEMO("y1"), Type.BOOLEAN, Type.BOOLEAN){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.signum() != 0 || a3.signum() != 0) {
                        return BigDecimal.ONE;
                    }
                    return BigDecimal.ZERO;
                }
                {
                    4 a7;
                }
            };
            GT = new Operator(BankSystem.ALLATORIxDEMO("4#"), 4, 1, 2, RandomAccessByteStream.ALLATORIxDEMO("s"), Type.BOOLEAN, Type.ARITHMETIC){
                {
                    5 a7;
                }

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.compareTo(a3) > 0) {
                        return BigDecimal.ONE;
                    }
                    return BigDecimal.ZERO;
                }
            };
            GE = new Operator(BankSystem.ALLATORIxDEMO("42"), 5, 1, 2, RandomAccessByteStream.ALLATORIxDEMO(";p"), Type.BOOLEAN, Type.ARITHMETIC){
                {
                    6 a7;
                }

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.compareTo(a3) >= 0) {
                        return BigDecimal.ONE;
                    }
                    return BigDecimal.ZERO;
                }
            };
            LT = new Operator(BankSystem.ALLATORIxDEMO("?#"), 6, 1, 2, RandomAccessByteStream.ALLATORIxDEMO("q"), Type.BOOLEAN, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.compareTo(a3) < 0) {
                        return BigDecimal.ONE;
                    }
                    return BigDecimal.ZERO;
                }
                {
                    7 a7;
                }
            };
            LE = new Operator(BankSystem.ALLATORIxDEMO("?2"), 7, 1, 2, RandomAccessByteStream.ALLATORIxDEMO("9p"), Type.BOOLEAN, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.compareTo(a3) <= 0) {
                        return BigDecimal.ONE;
                    }
                    return BigDecimal.ZERO;
                }
                {
                    8 a7;
                }
            };
            EQ = new Operator(BankSystem.ALLATORIxDEMO("6&"), 8, 1, 2, RandomAccessByteStream.ALLATORIxDEMO("8p"), Type.BOOLEAN, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.compareTo(a3) == 0) {
                        return BigDecimal.ONE;
                    }
                    return BigDecimal.ZERO;
                }
                {
                    9 a7;
                }
            };
            NE = new Operator(BankSystem.ALLATORIxDEMO("=2"), 9, 1, 2, RandomAccessByteStream.ALLATORIxDEMO("$p"), Type.BOOLEAN, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    if (a2.compareTo(a3) != 0) {
                        return BigDecimal.ONE;
                    }
                    return BigDecimal.ZERO;
                }
                {
                    10 a7;
                }
            };
            ADD = new Operator(BankSystem.ALLATORIxDEMO("673"), 10, 2, 2, RandomAccessByteStream.ALLATORIxDEMO("f"), Type.ARITHMETIC, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2.add(a3);
                }
                {
                    11 a7;
                }
            };
            SUB = new Operator(BankSystem.ALLATORIxDEMO("$&5"), 11, 2, 2, RandomAccessByteStream.ALLATORIxDEMO("`"), Type.ARITHMETIC, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2.subtract(a3);
                }
                {
                    12 a7;
                }
            };
            DIV = new Operator(BankSystem.ALLATORIxDEMO("3:!"), 12, 3, 2, "/", Type.ARITHMETIC, Type.ARITHMETIC){
                {
                    13 a7;
                }

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2.divide(a3, MathContext.DECIMAL128);
                }
            };
            REMAINDER = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\u001f@\u0000D\u0004K\t@\u001f"), 13, 3, 2, BankSystem.ALLATORIxDEMO("R"), Type.ARITHMETIC, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2.remainder(a3, MathContext.DECIMAL128);
                }
                {
                    14 a7;
                }
            };
            MUL = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\u0000P\u0001"), 14, 3, 2, BankSystem.ALLATORIxDEMO("]"), Type.ARITHMETIC, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2.multiply(a3);
                }
                {
                    15 a7;
                }
            };
            NEG = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\u0003@\n"), 15, 4, 1, BankSystem.ALLATORIxDEMO("Z"), Type.ARITHMETIC, Type.ARITHMETIC){
                {
                    16 a7;
                }

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2.negate();
                }
            };
            PLUS = new Operator(RandomAccessByteStream.ALLATORIxDEMO("U\u0001P\u001e"), 16, 4, 1, BankSystem.ALLATORIxDEMO("\\"), Type.ARITHMETIC, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2;
                }
                {
                    17 a7;
                }
            };
            ABS = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\fG\u001e"), 17, 4, 1, BankSystem.ALLATORIxDEMO("W\u0012\u0015\u0000W"), Type.ARITHMETIC, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2.abs();
                }
                {
                    18 a7;
                }
            };
            POW = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\u001dJ\u001a"), 18, 4, 2, BankSystem.ALLATORIxDEMO("W\u0003\u0018\u0004W"), Type.ARITHMETIC, Type.ARITHMETIC){
                {
                    19 a7;
                }

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a42) {
                    try {
                        return a2.pow(a3.intValueExact());
                    }
                    catch (ArithmeticException a42) {
                        throw new RuntimeException("pow argument: " + a42.getMessage());
                    }
                }
            };
            INT = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\u0004K\u0019"), 19, 4, 1, BankSystem.ALLATORIxDEMO("\u001a\u0019\u0007W"), Type.ARITHMETIC, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return new BigDecimal(a2.toBigInteger());
                }
                {
                    20 a7;
                }
            };
            CEIL = new Operator(RandomAccessByteStream.ALLATORIxDEMO("F\bL\u0001"), 20, 4, 1, BankSystem.ALLATORIxDEMO("\u0014\u0016\u001e\u001fW"), Type.ARITHMETIC, Type.ARITHMETIC){

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return new BigDecimal(Math.ceil(a2.doubleValue()));
                }
                {
                    21 a7;
                }
            };
            FLOOR = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\u000bI\u0002J\u001f"), 21, 4, 1, BankSystem.ALLATORIxDEMO("\u0015\u001b\u001c\u0018\u0001W"), Type.ARITHMETIC, Type.ARITHMETIC){
                {
                    22 a7;
                }

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return new BigDecimal(Math.floor(a2.doubleValue()));
                }
            };
            NOP = new Operator(RandomAccessByteStream.ALLATORIxDEMO("\u0003J\u001d"), 22, 4, 1, "", Type.ARITHMETIC, Type.ARITHMETIC){
                {
                    23 a7;
                }

                @Override
                public /* synthetic */ BigDecimal ALLATORIxDEMO(BigDecimal a2, BigDecimal a3, BigDecimal a4) {
                    return a2;
                }
            };
            Operator[] arroperator = new Operator[23];
            arroperator[0] = END;
            arroperator[1] = TERNARY;
            arroperator[2] = AND;
            arroperator[3] = OR;
            arroperator[4] = GT;
            arroperator[5] = GE;
            arroperator[6] = LT;
            arroperator[7] = LE;
            arroperator[8] = EQ;
            arroperator[9] = NE;
            arroperator[10] = ADD;
            arroperator[11] = SUB;
            arroperator[12] = DIV;
            arroperator[13] = REMAINDER;
            arroperator[14] = MUL;
            arroperator[15] = NEG;
            arroperator[16] = PLUS;
            arroperator[17] = ABS;
            arroperator[18] = POW;
            arroperator[19] = INT;
            arroperator[20] = CEIL;
            arroperator[21] = FLOOR;
            arroperator[22] = NOP;
            ALLATORIxDEMO = arroperator;
        }

        public /* synthetic */ Operator(String a2, int a3, int a4, int a5, String a6, Type a7, Type a8, tools.Eval$1 a9) {
            a10(a2, a3, a4, a5, a6, a7, a8);
            Operator a10;
        }

        public static /* synthetic */ Operator[] values() {
            return (Operator[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ Operator(int n22, int n22, String a2, Type a3, Type a4) {
            void a5;
            void a6;
            void var2_-1;
            void var1_-1;
            Operator a7;
            Operator operator = a7;
            Operator operator2 = a7;
            a7.B = (int)a2;
            operator2.k = (int)a3;
            operator2.K = a4;
            operator.a = a6;
            operator.d = a5;
        }
    }

    public static final class Tokeniser {
        private /* synthetic */ Operator ALLATORIxDEMO;
        public static final /* synthetic */ Character K;
        private /* synthetic */ int d;
        private final /* synthetic */ String a;

        /*
         * Enabled aggressive block sorting
         */
        public /* synthetic */ Operator ALLATORIxDEMO(char a2) {
            Tokeniser a3;
            if (a3.ALLATORIxDEMO != null) {
                Operator operator = a3.ALLATORIxDEMO;
                a3.ALLATORIxDEMO = null;
                return operator;
            }
            Tokeniser tokeniser = a3;
            Tokeniser tokeniser2 = tokeniser;
            int n2 = tokeniser.a.length();
            char c2 = '\u0000';
            while (tokeniser2.d < n2) {
                Tokeniser tokeniser3 = a3;
                c2 = tokeniser3.a.charAt(tokeniser3.d);
                if (!Character.isWhitespace(c2)) break;
                Tokeniser tokeniser4 = a3;
                tokeniser2 = tokeniser4;
                ++tokeniser4.d;
            }
            if (a3.d == n2) {
                if (a2 == '\u0000') {
                    return Operator.END;
                }
                throw new RuntimeException("missing " + a2);
            }
            ++a3.d;
            if (c2 == a2) {
                return Operator.END;
            }
            switch (c2) {
                case '+': {
                    return Operator.ADD;
                }
                case '-': {
                    return Operator.SUB;
                }
                case '/': {
                    return Operator.DIV;
                }
                case '%': {
                    return Operator.REMAINDER;
                }
                case '*': {
                    return Operator.MUL;
                }
                case '?': {
                    return Operator.TERNARY;
                }
                case '>': {
                    if (a3.d < n2) {
                        Tokeniser tokeniser5 = a3;
                        if (tokeniser5.a.charAt(tokeniser5.d) == '=') {
                            ++a3.d;
                            return Operator.GE;
                        }
                    }
                    return Operator.GT;
                }
                case '<': {
                    if (a3.d < n2) {
                        Tokeniser tokeniser6 = a3;
                        switch (tokeniser6.a.charAt(tokeniser6.d)) {
                            case '=': {
                                ++a3.d;
                                return Operator.LE;
                            }
                            case '>': {
                                ++a3.d;
                                return Operator.NE;
                            }
                        }
                    }
                    return Operator.LT;
                }
                case '=': {
                    if (a3.d < n2) {
                        Tokeniser tokeniser7 = a3;
                        if (tokeniser7.a.charAt(tokeniser7.d) == '=') {
                            ++a3.d;
                            return Operator.EQ;
                        }
                    }
                    throw new RuntimeException("use == for equality at position " + a3.d);
                }
                case '!': {
                    if (a3.d < n2) {
                        Tokeniser tokeniser8 = a3;
                        if (tokeniser8.a.charAt(tokeniser8.d) == '=') {
                            ++a3.d;
                            return Operator.NE;
                        }
                    }
                    throw new RuntimeException("use != or <> for inequality at position " + a3.d);
                }
                case '&': {
                    if (a3.d < n2) {
                        Tokeniser tokeniser9 = a3;
                        if (tokeniser9.a.charAt(tokeniser9.d) == '&') {
                            ++a3.d;
                            return Operator.AND;
                        }
                    }
                    throw new RuntimeException("use && for AND at position " + a3.d);
                }
                case '|': {
                    if (a3.d < n2) {
                        Tokeniser tokeniser10 = a3;
                        if (tokeniser10.a.charAt(tokeniser10.d) == '|') {
                            ++a3.d;
                            return Operator.OR;
                        }
                    }
                    throw new RuntimeException("use || for OR at position " + a3.d);
                }
            }
            if (Character.isUnicodeIdentifierStart(c2)) {
                Tokeniser tokeniser11 = a3;
                Tokeniser tokeniser12 = tokeniser11;
                int n3 = tokeniser11.d - 1;
                while (tokeniser12.d < n2) {
                    Tokeniser tokeniser13 = a3;
                    if (!Character.isUnicodeIdentifierPart(tokeniser13.a.charAt(tokeniser13.d))) break;
                    Tokeniser tokeniser14 = a3;
                    tokeniser12 = tokeniser14;
                    ++tokeniser14.d;
                }
                if (a3.a.substring(n3, a3.d).equals(CheaterData.ALLATORIxDEMO("ejb"))) {
                    return Operator.POW;
                }
            }
            throw new RuntimeException("operator expected at position " + a3.d + " instead of '" + c2 + "'");
        }

        public /* synthetic */ void ALLATORIxDEMO(Operator a2) {
            a.ALLATORIxDEMO = a2;
        }

        public /* synthetic */ void ALLATORIxDEMO(int a2) {
            a.d = a2;
        }

        private /* synthetic */ BigDecimal ALLATORIxDEMO() {
            char c2;
            Tokeniser a2;
            Tokeniser tokeniser = a2;
            Tokeniser tokeniser2 = tokeniser;
            int n2 = tokeniser.a.length();
            int n3 = tokeniser.d;
            while (tokeniser2.d < n2) {
                Tokeniser tokeniser3 = a2;
                c2 = tokeniser3.a.charAt(tokeniser3.d);
                if (!Character.isDigit(c2) && c2 != '.') break;
                Tokeniser tokeniser4 = a2;
                tokeniser2 = tokeniser4;
                ++tokeniser4.d;
            }
            if (a2.d < n2) {
                Tokeniser tokeniser5 = a2;
                c2 = tokeniser5.a.charAt(tokeniser5.d);
                if (c2 == 'E' || c2 == 'e') {
                    Tokeniser tokeniser6 = a2;
                    ++tokeniser6.d;
                    if (tokeniser6.d < n2) {
                        Tokeniser tokeniser7 = a2;
                        c2 = tokeniser7.a.charAt(tokeniser7.d);
                        if (c2 == '+' || c2 == '-') {
                            ++a2.d;
                        }
                    }
                    Tokeniser tokeniser8 = a2;
                    while (tokeniser8.d < n2) {
                        Tokeniser tokeniser9 = a2;
                        c2 = tokeniser9.a.charAt(tokeniser9.d);
                        if (!Character.isDigit(c2)) break;
                        Tokeniser tokeniser10 = a2;
                        tokeniser8 = tokeniser10;
                        ++tokeniser10.d;
                    }
                }
            }
            return new BigDecimal(a2.a.substring(n3, a2.d));
        }

        public /* synthetic */ Object ALLATORIxDEMO() {
            Tokeniser a2;
            Tokeniser tokeniser = a2;
            Tokeniser tokeniser2 = tokeniser;
            int n2 = tokeniser.a.length();
            char c2 = '\u0000';
            while (tokeniser2.d < n2) {
                Tokeniser tokeniser3 = a2;
                char c3 = tokeniser3.a.charAt(tokeniser3.d);
                c2 = c3;
                if (!Character.isWhitespace(c3)) break;
                Tokeniser tokeniser4 = a2;
                tokeniser2 = tokeniser4;
                ++tokeniser4.d;
            }
            if (a2.d == n2) {
                throw new RuntimeException(LoadPacket.ALLATORIxDEMO("|GvErYw\u0017vOcRpCvS3UfC3R}S3Xu\u0017`Ca^}P3Q|B}S"));
            }
            if (c2 == '(') {
                ++a2.d;
                return K;
            }
            if (c2 == '-') {
                ++a2.d;
                return Operator.NEG;
            }
            if (c2 == '+') {
                ++a2.d;
                return Operator.PLUS;
            }
            if (c2 == '.' || Character.isDigit(c2)) {
                return a2.ALLATORIxDEMO();
            }
            if (Character.isUnicodeIdentifierStart(c2)) {
                String string;
                int n3 = a2.d++;
                Tokeniser tokeniser5 = a2;
                while (tokeniser5.d < n2) {
                    Tokeniser tokeniser6 = a2;
                    if (!Character.isUnicodeIdentifierPart(tokeniser6.a.charAt(tokeniser6.d))) break;
                    Tokeniser tokeniser7 = a2;
                    tokeniser5 = tokeniser7;
                    ++tokeniser7.d;
                }
                if ((string = a2.a.substring(n3, a2.d)).equals(CheaterData.ALLATORIxDEMO("tgf"))) {
                    return Operator.ABS;
                }
                if (string.equals(LoadPacket.ALLATORIxDEMO("^}C"))) {
                    return Operator.INT;
                }
                if (string.equals(CheaterData.ALLATORIxDEMO("fply"))) {
                    return Operator.CEIL;
                }
                if (string.equals(LoadPacket.ALLATORIxDEMO("Q\u007fX|E"))) {
                    return Operator.FLOOR;
                }
                return string;
            }
            throw new RuntimeException("operand expected but '" + c2 + "' found");
        }

        public /* synthetic */ String toString() {
            Tokeniser a2;
            Tokeniser tokeniser = a2;
            return a2.a.substring(0, a2.d) + ">>>" + tokeniser.a.substring(tokeniser.d);
        }

        public static /* synthetic */ {
            K = Character.valueOf('(');
        }

        public /* synthetic */ Tokeniser(String a2) {
            Tokeniser a3;
            Tokeniser tokeniser = a3;
            a3.ALLATORIxDEMO = null;
            tokeniser.a = a2;
            tokeniser.d = 0;
        }

        public /* synthetic */ int ALLATORIxDEMO() {
            Tokeniser a2;
            return a2.d;
        }
    }

    public static final class Type
    extends Enum<Type> {
        public final /* synthetic */ String d;
        public static final /* synthetic */ /* enum */ Type BOOLEAN;
        private static final /* synthetic */ Type[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ Type ARITHMETIC;

        public static /* synthetic */ {
            ARITHMETIC = new Type(FixDropNullItem.ALLATORIxDEMO("w\u0014\u007f\u0012~\u000bs\u0012\u007f\u0005"), 0, SyncServerData.ALLATORIxDEMO("\u0014x\u001c~\u001dg\u0010~\u001ci"));
            BOOLEAN = new Type(FixDropNullItem.ALLATORIxDEMO("\u0004y\tz\u0003w\b"), 1, SyncServerData.ALLATORIxDEMO("h\u001ae\u0019o\u0014d"));
            Type[] arrtype = new Type[2];
            arrtype[0] = ARITHMETIC;
            arrtype[1] = BOOLEAN;
            ALLATORIxDEMO = arrtype;
        }

        public static /* synthetic */ Type[] values() {
            return (Type[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ Type(String string) {
            void a2;
            void var2_-1;
            void var1_-1;
            Type a3;
            a3.d = a2;
        }

        public static /* synthetic */ Type valueOf(String a2) {
            return Enum.valueOf(Type.class, a2);
        }
    }
}

