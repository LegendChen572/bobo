/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayMap<K, V>
extends AbstractMap<K, V>
implements Serializable {
    private transient /* synthetic */ Set<? extends Map.Entry<K, V>> d;
    public static final /* synthetic */ long serialVersionUID = 9179541993413738569L;
    private /* synthetic */ ArrayList<Entry<K, V>> ALLATORIxDEMO;

    public /* synthetic */ ArrayMap(int a2) {
        ArrayMap a3;
        a3.d = null;
        ArrayMap arrayMap = a3;
        a3.ALLATORIxDEMO = new ArrayList(a2);
    }

    @Override
    public /* synthetic */ V put(K a2, V a3) {
        int n2;
        ArrayMap a4;
        int n3 = a4.ALLATORIxDEMO.size();
        Entry<K, V> entry = null;
        if (a2 == null) {
            int n4 = n2 = 0;
            while (n4 < n3 && (entry = a4.ALLATORIxDEMO.get(n2)).getKey() != null) {
                n4 = ++n2;
            }
        } else {
            int n5 = n2 = 0;
            while (n5 < n3 && !a2.equals((entry = a4.ALLATORIxDEMO.get(n2)).getKey())) {
                n5 = ++n2;
            }
        }
        V v2 = null;
        if (n2 < n3) {
            Entry<K, V> entry2 = entry;
            v2 = entry2.getValue();
            entry2.setValue(a3);
            return v2;
        }
        a4.ALLATORIxDEMO.add(new Entry<K, V>(a2, a3));
        return v2;
    }

    @Override
    public /* synthetic */ Set<Map.Entry<K, V>> entrySet() {
        ArrayMap a2;
        if (a2.d == null) {
            ArrayMap arrayMap = a2;
            a2.d = new AbstractSet<Entry<K, V>>(){
                {
                    1 a3;
                }

                @Override
                public /* synthetic */ void clear() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public /* synthetic */ int size() {
                    1 a2;
                    return a2.ArrayMap.this.ALLATORIxDEMO.size();
                }

                @Override
                public /* synthetic */ Iterator<Entry<K, V>> iterator() {
                    1 a2;
                    return a2.ArrayMap.this.ALLATORIxDEMO.iterator();
                }
            };
        }
        return a2.d;
    }

    public /* synthetic */ ArrayMap() {
        ArrayMap a2;
        a2.d = null;
        ArrayMap arrayMap = a2;
        a2.ALLATORIxDEMO = new ArrayList();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ (3 << 2 ^ 3);
        int cfr_ignored_0 = 5 << 4 ^ 3;
        int n5 = n3;
        int n6 = 5 << 4 ^ 3 << 1;
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

    public /* synthetic */ ArrayMap(Map<K, V> a2) {
        ArrayMap a3;
        a3.d = null;
        ArrayMap arrayMap = a3;
        a3.ALLATORIxDEMO = new ArrayList();
        a3.putAll(a2);
    }

    public static class Entry<K, V>
    implements Map.Entry<K, V>,
    Serializable {
        public static final /* synthetic */ long serialVersionUID = 9179541993413738569L;
        public /* synthetic */ V value;
        public /* synthetic */ K key;

        @Override
        public /* synthetic */ V setValue(V a2) {
            Entry a3;
            V v2 = a3.value;
            a3.value = a2;
            return v2;
        }

        public /* synthetic */ String toString() {
            Entry a2;
            Entry entry = a2;
            return entry.key + "=" + entry.value;
        }

        @Override
        public /* synthetic */ int hashCode() {
            Entry a2;
            int n2 = a2.key == null ? 0 : a2.key.hashCode();
            int n3 = a2.value == null ? 0 : a2.value.hashCode();
            return n2 ^ n3;
        }

        @Override
        public /* synthetic */ boolean equals(Object a2) {
            block6: {
                Entry entry;
                Entry a3;
                Map.Entry entry2;
                block7: {
                    block5: {
                        if (!(a2 instanceof Map.Entry)) {
                            return false;
                        }
                        entry2 = (Map.Entry)a2;
                        if (a3.key != null) break block5;
                        if (entry2.getKey() != null) break block6;
                        entry = a3;
                        break block7;
                    }
                    if (!a3.key.equals(entry2.getKey())) break block6;
                    entry = a3;
                }
                if (entry.value == null ? entry2.getValue() == null : a3.value.equals(entry2.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public /* synthetic */ K getKey() {
            Entry a2;
            return a2.key;
        }

        public /* synthetic */ Entry(K a2, V a3) {
            Entry a4;
            Entry entry = a4;
            entry.key = a2;
            entry.value = a3;
        }

        @Override
        public /* synthetic */ V getValue() {
            Entry a2;
            return a2.value;
        }
    }
}

