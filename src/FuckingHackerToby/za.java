/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;

public final class za {
    private static final /* synthetic */ int ALLATORIxDEMO = 1024;

    public static /* synthetic */ boolean ALLATORIxDEMO(String a2, String a3) {
        Path path = Paths.get(a2, new String[0]);
        a3 = Paths.get((String)a3, new String[0]);
        return za.ALLATORIxDEMO(path, (Path)a3);
    }

    public static /* synthetic */ String[] ALLATORIxDEMO(String a2) {
        Iterable<Path> iterable = Paths.get(a2, new String[0]);
        try {
            iterable = Files.readAllLines(iterable);
            String[] arrstring = (String[])iterable.stream().toArray(String[]::new);
            return arrstring;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ boolean D(String a2) {
        Path path = Paths.get(a2, new String[0]);
        Path path2 = path.getParent();
        try {
            Files.createDirectories(path2, new FileAttribute[0]);
            Files.createFile(path, new FileAttribute[0]);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static /* synthetic */ boolean ALLATORIxDEMO(String a2) {
        return za.ALLATORIxDEMO(new File(a2));
    }

    public static /* synthetic */ boolean ALLATORIxDEMO(Path a2, Path a32) {
        try {
            CopyOption[] arrcopyOption = new CopyOption[1];
            arrcopyOption[0] = StandardCopyOption.REPLACE_EXISTING;
            Files.copy(a2, a32, arrcopyOption);
            return true;
        }
        catch (Exception a32) {
            return false;
        }
    }

    public static /* synthetic */ boolean ALLATORIxDEMO(String a2, String ... a32) {
        Path path = Paths.get(a2, new String[0]);
        a32 = Arrays.asList(a32);
        try {
            Files.write(path, (Iterable<? extends CharSequence>)a32, new OpenOption[0]);
            return true;
        }
        catch (Exception a32) {
            a32.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ byte[] ALLATORIxDEMO(String a2) {
        Object object = Paths.get(a2, new String[0]);
        try {
            object = Files.readAllBytes((Path)object);
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ String[] H(String a2) {
        Closeable closeable = za.class.getResourceAsStream(a2);
        closeable = new InputStreamReader((InputStream)closeable);
        closeable = new BufferedReader((Reader)closeable);
        ArrayList<String> arrayList = new ArrayList<String>();
        String string = null;
        try {
            while ((string = ((BufferedReader)closeable).readLine()) != null) {
                arrayList.add(string);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        String[] arrstring = (String[])arrayList.stream().toArray(String[]::new);
        return arrstring;
    }

    public static /* synthetic */ boolean ALLATORIxDEMO(String a2, byte[] a32) {
        Path path = Paths.get(a2, new String[0]);
        try {
            Files.write(path, a32, new OpenOption[0]);
            return true;
        }
        catch (Exception a32) {
            a32.printStackTrace();
            return false;
        }
    }

    private /* synthetic */ za() {
        za a2;
    }

    public static /* synthetic */ byte[] H(String a2) {
        InputStream inputStream = za.class.getClassLoader().getResourceAsStream(a2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[1024];
        int n2 = 0;
        try {
            while ((n2 = inputStream.read(arrby)) != -1) {
                byteArrayOutputStream.write(arrby, 0, n2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static /* synthetic */ boolean H(String a2) {
        Path path = Paths.get(a2, new String[0]);
        try {
            Files.createDirectories(path, new FileAttribute[0]);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static /* synthetic */ boolean ALLATORIxDEMO(File a2) {
        Desktop desktop;
        if (Desktop.isDesktopSupported() && a2.exists() && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.OPEN)) {
            try {
                desktop.open(a2);
                return true;
            }
            catch (IOException iOException) {
                return false;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean l(String a2) {
        Path path = Paths.get(a2, new String[0]);
        try {
            Files.delete(path);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

