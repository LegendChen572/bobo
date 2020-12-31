/*
 * Decompiled with CFR 0.150.
 */
package provider.WzXML;

import client.messages.commands.player.eventSystem.SellSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import provider.MapleData;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataProvider;
import provider.WzXML.WZDirectoryEntry;
import provider.WzXML.WZFileEntry;
import provider.WzXML.XMLDomMapleData;
import tools.wztosql.DumpItemsAdditions;

public class XMLWZFile
implements MapleDataProvider {
    private /* synthetic */ WZDirectoryEntry ALLATORIxDEMO;
    private /* synthetic */ File d;

    private /* synthetic */ void ALLATORIxDEMO(File a2, WZDirectoryEntry a3) {
        int n2;
        a2 = a2.listFiles();
        int n3 = a2.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            File file = a2[n2];
            String string = file.getName();
            if (file.isDirectory() && !string.endsWith(SellSystem.ALLATORIxDEMO("[\u0006\u0018\b"))) {
                XMLWZFile a4;
                WZDirectoryEntry wZDirectoryEntry = new WZDirectoryEntry(string, 0, 0, a3);
                a3.addDirectory(wZDirectoryEntry);
                a4.ALLATORIxDEMO(file, wZDirectoryEntry);
            } else if (string.endsWith(DumpItemsAdditions.ALLATORIxDEMO("\b1K%"))) {
                String string2 = string;
                a3.addFile(new WZFileEntry(string2.substring(0, string2.length() - 4), 0, 0, a3));
            }
            n4 = ++n2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public /* synthetic */ MapleData getData2(String a22) {
        XMLWZFile a3;
        Serializable serializable = new File(a3.d, (String)a22 + ".xml");
        File file = new File(a3.d, (String)a22);
        if (!serializable.exists()) {
            System.out.println("Datafile " + (String)a22 + " does not exist in " + a3.d.getAbsolutePath());
            return null;
        }
        try {
            a22 = new FileInputStream((File)serializable);
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        try {
            serializable = new XMLDomMapleData((FileInputStream)a22, file.getParentFile());
        }
        catch (Throwable throwable) {
            try {
                ((FileInputStream)a22).close();
            }
            catch (IOException a22) {
                throw new RuntimeException(a22);
            }
            throw throwable;
        }
        try {
            Object a22;
            ((FileInputStream)a22).close();
            return serializable;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public /* synthetic */ MapleDataDirectoryEntry getRoot() {
        XMLWZFile a2;
        return a2.ALLATORIxDEMO;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public /* synthetic */ MapleData getData(String a22) {
        XMLDomMapleData xMLDomMapleData;
        XMLWZFile a3;
        Object object = new File(a3.d, a22 + ".xml");
        File file = new File(a3.d, a22);
        if (!((File)object).exists()) {
            System.out.println("Datafile " + a22 + " does not exist in " + a3.d.getAbsolutePath());
            return null;
        }
        try {
            object = new FileInputStream((File)object);
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException("Datafile " + a22 + " does not exist in " + a3.d.getAbsolutePath());
        }
        try {
            xMLDomMapleData = new XMLDomMapleData((FileInputStream)object, file.getParentFile());
        }
        catch (Throwable throwable) {
            try {
                ((FileInputStream)object).close();
            }
            catch (IOException a22) {
                throw new RuntimeException(a22);
            }
            throw throwable;
        }
        try {
            ((FileInputStream)object).close();
            return xMLDomMapleData;
        }
        catch (IOException a22) {
            throw new RuntimeException(a22);
        }
    }

    public /* synthetic */ XMLWZFile(File a2) {
        XMLWZFile a3;
        a3.d = a2;
        a3.ALLATORIxDEMO = new WZDirectoryEntry(a2.getName(), 0, 0, null);
        a3.ALLATORIxDEMO(a3.d, a3.ALLATORIxDEMO);
    }
}

