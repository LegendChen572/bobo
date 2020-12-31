/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 */
package tools.others;

import client.messages.commands.player.\u738b\u4e4b\u8c37;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.FileoutputUtil;
import tools.others.IcatchScanner;
import tools.packet.FamilyPacket;

public class PortScanner {
    public static /* synthetic */ Map<Integer, HashSet<String>> ipmap;
    public static /* synthetic */ int nowscan;
    public static /* synthetic */ int count;
    public static /* synthetic */ HashSet<String> ipall;
    public static /* synthetic */ int successscan;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void scan(HashSet<String> a2) {
        try {
            for (String string : a2) {
                long l2 = System.currentTimeMillis();
                ExecutorService executorService = Executors.newFixedThreadPool(20);
                int n2 = 10;
                Object object = new ArrayList<Future<ScanResult>>();
                object.add(executorService.submit(new Callable<ScanResult>(){

                    @Override
                    public /* synthetic */ ScanResult call() {
                        3 a2;
                        try {
                            Socket socket;
                            Socket socket2 = socket = new Socket();
                            3 v1 = a2;
                            socket2.connect(new InetSocketAddress(v1.a3, v1.a4), a2.a5);
                            socket2.close();
                            return new ScanResult(a2.a4, true);
                        }
                        catch (Exception exception) {
                            return new ScanResult(a2.a4, false);
                        }
                    }
                    {
                        3 a2;
                    }
                }));
                object.add(executorService.submit(new /* invalid duplicate definition of identical inner class */));
                object.add(executorService.submit(new /* invalid duplicate definition of identical inner class */));
                executorService.awaitTermination(200L, TimeUnit.MILLISECONDS);
                int n3 = 0;
                object = object.iterator();
                while (object.hasNext()) {
                    Future future = (Future)object.next();
                    if (!((ScanResult)future.get()).isOpen()) continue;
                    ++n3;
                    FileoutputUtil.logToFile(FamilyPacket.ALLATORIxDEMO("N=E!\r\u001br\u63d1\u63ed}k\u0002}\u0001a\u0013l|V*V"), "\r\n" + string + ":" + ((ScanResult)future.get()).getPort(), false);
                    IcatchScanner.scanIP(string, ((ScanResult)future.get()).getPort());
                }
                if (++nowscan % 1000 != 0) continue;
                System.out.println("\u5df2\u6383\u63cf: " + nowscan);
                System.gc();
            }
            return;
        }
        catch (InterruptedException interruptedException) {
            Logger.getLogger(PortScanner.class.getName()).log(Level.SEVERE, null, interruptedException);
            return;
        }
        catch (ExecutionException executionException) {
            Logger.getLogger(PortScanner.class.getName()).log(Level.SEVERE, null, executionException);
        }
    }

    public /* synthetic */ PortScanner() {
        PortScanner a2;
    }

    public static /* synthetic */ boolean isScanIp(String a2) {
        return a2.contains(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"/\u0016*"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void scanA(HashSet<String> a2) {
        try {
            Iterator<String> iterator = a2.iterator();
            while (iterator.hasNext()) {
                String[] arrstring = iterator.next().split(FamilyPacket.ALLATORIxDEMO("\u0018"));
                ExecutorService executorService = Executors.newFixedThreadPool(20);
                int n2 = 10;
                Object object = new ArrayList<Future<ScanResult>>();
                long l2 = System.currentTimeMillis();
                object.add(executorService.submit(new /* invalid duplicate definition of identical inner class */));
                executorService.awaitTermination(200L, TimeUnit.MILLISECONDS);
                int n3 = 0;
                object = object.iterator();
                while (object.hasNext()) {
                    Future future = (Future)object.next();
                    if (!((ScanResult)future.get()).isOpen()) continue;
                    ++n3;
                    FileoutputUtil.logToFile(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"rHyT1nN\u63a4\u63d1\bWwAt]fP\tj_j"), "\r\n" + arrstring[0] + ":" + ((ScanResult)future.get()).getPort(), false);
                    IcatchScanner.scanIP(arrstring[0], ((ScanResult)future.get()).getPort());
                }
                System.out.println("\u5df2\u6383\u63cf: " + ++nowscan);
            }
            return;
        }
        catch (InterruptedException interruptedException) {
            Logger.getLogger(PortScanner.class.getName()).log(Level.SEVERE, null, interruptedException);
            return;
        }
        catch (ExecutionException executionException) {
            Logger.getLogger(PortScanner.class.getName()).log(Level.SEVERE, null, executionException);
        }
    }

    public static /* synthetic */ void startScanA() throws Exception {
        Object object;
        Object object2;
        Object object3;
        if (ipmap.size() == 0) {
            object3 = new File("");
            object2 = ((File)object3).getAbsolutePath();
            object = (String)object2 + File.separator;
            Object object4 = new File((String)object + "auth.txt");
            object4 = new BufferedReader(new FileReader((File)object4));
            String string = null;
            int n2 = 1;
            int n3 = 0;
            HashSet<String> hashSet = new HashSet<String>();
            Object object5 = object4;
            while ((string = ((BufferedReader)object5).readLine()) != null) {
                if (n2 % 5000 == 0) {
                    Integer n4 = n3;
                    ++n3;
                    ipmap.put(n4, (HashSet)hashSet.clone());
                    hashSet.clear();
                } else {
                    hashSet.add(string);
                }
                ++n2;
                ++count;
                object5 = object4;
            }
            System.out.println("\u5df2\u8f09\u5165\u6240\u6709\u53f0\u7063IP : " + count + " \u500b");
            ((BufferedReader)object4).close();
        }
        Object object6 = object3 = ipmap.entrySet().iterator();
        while (object6.hasNext()) {
            object2 = (Map.Entry)object3.next();
            object = new Thread((Map.Entry)object2){
                public final /* synthetic */ Map.Entry ALLATORIxDEMO;

                @Override
                public /* synthetic */ void run() {
                    try {
                        1 a2;
                        PortScanner.scanA((HashSet)a2.ALLATORIxDEMO.getValue());
                        return;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        return;
                    }
                }
                {
                    1 a2;
                    a2.ALLATORIxDEMO = entry;
                }
            };
            object6 = object3;
            ((Thread)object).start();
        }
    }

    public static /* synthetic */ void startScan() throws Exception {
        Object object;
        Object object2;
        Object object3;
        if (ipmap.size() == 0) {
            object3 = new File("");
            object2 = ((File)object3).getAbsolutePath();
            object = (String)object2 + File.separator;
            Object object4 = new File((String)object + "iplist.txt");
            object4 = new BufferedReader(new FileReader((File)object4));
            String string = null;
            int n2 = 1;
            int n3 = 0;
            HashSet<String> hashSet = new HashSet<String>();
            block0: while (true) {
                Object object5 = object4;
                while ((string = ((BufferedReader)object5).readLine()) != null) {
                    if (!PortScanner.isScanIp(string)) continue block0;
                    if (!string.isEmpty()) {
                        if (n2 % 5000 == 0) {
                            Integer n4 = n3;
                            ++n3;
                            ipmap.put(n4, (HashSet)hashSet.clone());
                            hashSet.clear();
                        } else {
                            hashSet.add(string);
                        }
                        ++n2;
                    }
                    ++count;
                    object5 = object4;
                }
                break;
            }
            System.out.println("\u5df2\u8f09\u5165\u6240\u6709\u53f0\u7063IP : " + count + " \u500b");
            ((BufferedReader)object4).close();
        }
        Object object6 = object3 = ipmap.entrySet().iterator();
        while (object6.hasNext()) {
            object2 = (Map.Entry)object3.next();
            object = new Thread((Map.Entry)object2){
                public final /* synthetic */ Map.Entry ALLATORIxDEMO;
                {
                    2 a2;
                    a2.ALLATORIxDEMO = entry;
                }

                @Override
                public /* synthetic */ void run() {
                    try {
                        2 a2;
                        PortScanner.scan((HashSet)a2.ALLATORIxDEMO.getValue());
                        return;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        return;
                    }
                }
            };
            object6 = object3;
            ((Thread)object).start();
        }
    }

    public static /* synthetic */ {
        ipall = new HashSet();
        nowscan = 0;
        successscan = 0;
        count = 0;
        ipmap = new HashMap<Integer, HashSet<String>>();
    }

    public static /* synthetic */ void scan(String a2) {
        int n2;
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        int n3 = 10;
        Object object = new ArrayList<Future<ScanResult>>();
        long l2 = System.currentTimeMillis();
        int n4 = n2 = 1;
        while (n4 <= 65535) {
            object.add(executorService.submit(new /* invalid duplicate definition of identical inner class */));
            n4 = n2;
        }
        try {
            executorService.awaitTermination(200L, TimeUnit.MILLISECONDS);
            n2 = 0;
            object = object.iterator();
            while (object.hasNext()) {
                Future future = (Future)object.next();
                if (!((ScanResult)future.get()).isOpen()) continue;
                ++n2;
                System.out.println("\u958b:" + ((ScanResult)future.get()).getPort());
                FileoutputUtil.logToFile(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"rHyT1nN\u63a4\u63d1\bWwAt]fP\tj_j"), "\r\n" + a2 + ":" + ((ScanResult)future.get()).getPort(), false);
                IcatchScanner.scanIP(a2, ((ScanResult)future.get()).getPort());
            }
        }
        catch (InterruptedException interruptedException) {
            Logger.getLogger(PortScanner.class.getName()).log(Level.SEVERE, null, interruptedException);
            return;
        }
        catch (ExecutionException executionException) {
            Logger.getLogger(PortScanner.class.getName()).log(Level.SEVERE, null, executionException);
        }
    }

    public static class ScanResult {
        private /* synthetic */ boolean ALLATORIxDEMO;
        private /* synthetic */ int d;

        public /* synthetic */ void setOpen(boolean a2) {
            a.ALLATORIxDEMO = a2;
        }

        public /* synthetic */ boolean isOpen() {
            ScanResult a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ int getPort() {
            ScanResult a2;
            return a2.d;
        }

        public /* synthetic */ ScanResult(int a2, boolean a3) {
            ScanResult a4;
            ScanResult scanResult = a4;
            scanResult.d = a2;
            scanResult.ALLATORIxDEMO = a3;
        }

        public /* synthetic */ void setPort(int a2) {
            a.d = a2;
        }
    }
}

