/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class ConcurrentEnumMap<K extends Enum<K>, V>
extends EnumMap<K, V>
implements Serializable {
    private /* synthetic */ Lock d;
    private /* synthetic */ ReentrantReadWriteLock a;
    private static final /* synthetic */ long K = 11920818021L;
    private /* synthetic */ Lock ALLATORIxDEMO;

    @Override
    public /* synthetic */ void clear() {
        ConcurrentEnumMap a2;
        a2.ALLATORIxDEMO.lock();
        try {
            super.clear();
            return;
        }
        finally {
            a2.ALLATORIxDEMO.unlock();
        }
    }

    @Override
    public /* synthetic */ boolean containsKey(Object a22) {
        ConcurrentEnumMap a3;
        a3.d.lock();
        try {
            boolean a22 = super.containsKey(a22);
            return a22;
        }
        finally {
            a3.d.unlock();
        }
    }

    @Override
    public /* synthetic */ Set<K> keySet() {
        ConcurrentEnumMap a2;
        a2.d.lock();
        try {
            Set set = super.keySet();
            return set;
        }
        finally {
            a2.d.unlock();
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ (2 << 2 ^ 1);
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 2 << 1;
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ (2 ^ 5) << 1;
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

    @Override
    public /* synthetic */ boolean containsValue(Object a22) {
        ConcurrentEnumMap a3;
        a3.d.lock();
        try {
            boolean a22 = super.containsValue(a22);
            return a22;
        }
        finally {
            a3.d.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public /* synthetic */ V put(K a2, V a3) {
        ConcurrentEnumMap a4;
        a4.ALLATORIxDEMO.lock();
        try {
            a2 = super.put(a2, a3);
            return (V)a2;
        }
        finally {
            a4.ALLATORIxDEMO.unlock();
        }
    }

    @Override
    public /* synthetic */ EnumMap<K, V> clone() {
        ConcurrentEnumMap a2;
        return super.clone();
    }

    @Override
    public /* synthetic */ V get(Object a2) {
        ConcurrentEnumMap a3;
        a3.d.lock();
        try {
            a2 = super.get(a2);
            return (V)a2;
        }
        finally {
            a3.d.unlock();
        }
    }

    @Override
    public /* synthetic */ Collection<V> values() {
        ConcurrentEnumMap a2;
        a2.d.lock();
        try {
            Collection collection = super.values();
            return collection;
        }
        finally {
            a2.d.unlock();
        }
    }

    @Override
    public /* synthetic */ V remove(Object a2) {
        ConcurrentEnumMap a3;
        a3.ALLATORIxDEMO.lock();
        try {
            a2 = super.remove(a2);
            return (V)a2;
        }
        finally {
            a3.ALLATORIxDEMO.unlock();
        }
    }

    @Override
    public /* synthetic */ boolean equals(Object a2) {
        ConcurrentEnumMap a3;
        return super.equals(a2);
    }

    public /* synthetic */ ConcurrentEnumMap(Class<K> a2) {
        ConcurrentEnumMap a3;
        ConcurrentEnumMap concurrentEnumMap = a3;
        super(a2);
        concurrentEnumMap.a = new ReentrantReadWriteLock();
        concurrentEnumMap.d = a3.a.readLock();
        concurrentEnumMap.ALLATORIxDEMO = concurrentEnumMap.a.writeLock();
    }

    @Override
    public /* synthetic */ void putAll(Map<? extends K, ? extends V> a2) {
        ConcurrentEnumMap a3;
        a3.ALLATORIxDEMO.lock();
        try {
            super.putAll(a2);
            return;
        }
        finally {
            a3.ALLATORIxDEMO.unlock();
        }
    }

    @Override
    public /* synthetic */ Set<Map.Entry<K, V>> entrySet() {
        ConcurrentEnumMap a2;
        a2.d.lock();
        try {
            Set set = super.entrySet();
            return set;
        }
        finally {
            a2.d.unlock();
        }
    }

    @Override
    public /* synthetic */ int size() {
        ConcurrentEnumMap a2;
        a2.d.lock();
        try {
            int n2 = super.size();
            return n2;
        }
        finally {
            a2.d.unlock();
        }
    }
}

