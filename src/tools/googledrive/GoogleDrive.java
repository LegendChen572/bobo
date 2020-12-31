/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.api.client.auth.oauth2.AuthorizationCodeFlow
 *  com.google.api.client.auth.oauth2.Credential
 *  com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
 *  com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver
 *  com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
 *  com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver$Builder
 *  com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow$Builder
 *  com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
 *  com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
 *  com.google.api.client.http.AbstractInputStreamContent
 *  com.google.api.client.http.FileContent
 *  com.google.api.client.http.HttpRequestInitializer
 *  com.google.api.client.http.HttpTransport
 *  com.google.api.client.http.javanet.NetHttpTransport
 *  com.google.api.client.json.JsonFactory
 *  com.google.api.client.json.jackson2.JacksonFactory
 *  com.google.api.client.util.store.DataStoreFactory
 *  com.google.api.client.util.store.FileDataStoreFactory
 *  com.google.api.services.drive.Drive
 *  com.google.api.services.drive.Drive$Builder
 *  com.google.api.services.drive.model.File
 *  com.google.api.services.drive.model.FileList
 */
package tools.googledrive;

import client.MapleBuffStatValueHolder;
import client.SummonSkillEntry;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import constants.GameSetConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GoogleDrive {
    private static final /* synthetic */ String d = "tools/googledrive/credentials.json";
    private static final /* synthetic */ JsonFactory k;
    private static final /* synthetic */ String K = "tokens";
    private static /* synthetic */ Drive ALLATORIxDEMO;
    private static final /* synthetic */ List<String> a;
    private static final /* synthetic */ String B = "OAuth client";

    public static final /* synthetic */ com.google.api.services.drive.model.File createGoogleFolder(String a2, String a3) throws IOException {
        com.google.api.services.drive.model.File file = new com.google.api.services.drive.model.File();
        file.setName((String)a3);
        file.setMimeType(MapleBuffStatValueHolder.ALLATORIxDEMO("10 ,9#149/>o&.4n7/?'<%}! 0#n6/<$52"));
        if (a2 != null) {
            String[] arrstring = new String[1];
            arrstring[0] = a2;
            a3 = Arrays.asList(arrstring);
            file.setParents((List)a3);
        }
        a3 = (com.google.api.services.drive.model.File)ALLATORIxDEMO.files().create(file).setFields(SummonSkillEntry.ALLATORIxDEMO("bW'\u0013eRfV")).execute();
        return a3;
    }

    public static /* synthetic */ {
        k = JacksonFactory.getDefaultInstance();
        String[] arrstring = new String[1];
        arrstring[0] = SummonSkillEntry.ALLATORIxDEMO("[\u007fG{@1\u001c$D|D%Td\\l_nR{Zx\u001dh\\f\u001cjF\u007f[$WyZ}V");
        a = Arrays.asList(arrstring);
        ALLATORIxDEMO = null;
    }

    public static final /* synthetic */ List<com.google.api.services.drive.model.File> getGoogleSubFolderByName(String a2, String a3) throws IOException {
        String string = null;
        ArrayList<com.google.api.services.drive.model.File> arrayList = new ArrayList<com.google.api.services.drive.model.File>();
        String string2 = null;
        string2 = a2 == null ? " name = '" + a3 + "'  and mimeType = 'application/vnd.google-apps.folder'  and 'root' in parents" : " name = '" + a3 + "'  and mimeType = 'application/vnd.google-apps.folder'  and '" + a2 + "' in parents";
        do {
            a3 = (FileList)ALLATORIxDEMO.files().list().setQ(string2).setSpaces(MapleBuffStatValueHolder.ALLATORIxDEMO("$\")&%")).setFields(SummonSkillEntry.ALLATORIxDEMO("]nK\u007fcjTngdXn]'\u0013mZgVx\u001bbW'\u0013eRfV'\u0013hAnR\u007fVogb^n\u001a")).setPageToken(string).execute();
            Iterator iterator = a3.getFiles().iterator();
            while (iterator.hasNext()) {
                Iterator iterator2;
                com.google.api.services.drive.model.File file = (com.google.api.services.drive.model.File)iterator2.next();
                iterator = iterator2;
                arrayList.add(file);
            }
        } while ((string = a3.getNextPageToken()) != null);
        return arrayList;
    }

    public static final /* synthetic */ List<com.google.api.services.drive.model.File> getGoogleRootFoldersByName(String a2) throws IOException {
        return GoogleDrive.getGoogleSubFolderByName(null, a2);
    }

    public /* synthetic */ GoogleDrive() {
        GoogleDrive a2;
    }

    private static /* synthetic */ Credential ALLATORIxDEMO(NetHttpTransport a2) throws IOException {
        InputStream inputStream = GoogleDrive.class.getClassLoader().getResourceAsStream(d);
        if (inputStream == null) {
            throw new FileNotFoundException(SummonSkillEntry.ALLATORIxDEMO("YVx\\~AhV+]dG+UdFeW1\u0013\u007f\\d_x\u001cl\\dTgVoAbEn\u001chAnWn]\u007fZj_x\u001da@d]"));
        }
        inputStream = GoogleClientSecrets.load((JsonFactory)k, (Reader)new InputStreamReader(inputStream));
        inputStream = new GoogleAuthorizationCodeFlow.Builder((HttpTransport)a2, k, (GoogleClientSecrets)inputStream, a).setDataStoreFactory((DataStoreFactory)new FileDataStoreFactory(new File(K))).setAccessType(MapleBuffStatValueHolder.ALLATORIxDEMO("/6&<)>%")).build();
        LocalServerReceiver localServerReceiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp((AuthorizationCodeFlow)inputStream, (VerificationCodeReceiver)localServerReceiver).authorize(SummonSkillEntry.ALLATORIxDEMO("~@nA"));
    }

    public static /* synthetic */ void upload(String a2, String a3) throws IOException, GeneralSecurityException {
        com.google.api.services.drive.model.File file;
        Object object;
        NetHttpTransport netHttpTransport = object = GoogleNetHttpTransport.newTrustedTransport();
        ALLATORIxDEMO = new Drive.Builder((HttpTransport)netHttpTransport, k, (HttpRequestInitializer)GoogleDrive.ALLATORIxDEMO(netHttpTransport)).setApplicationName(B).build();
        object = GameSetConstants.SERVER_NAME;
        if (GoogleDrive.getGoogleSubFolderByName(null, (String)a3).size() < 1) {
            file = GoogleDrive.createGoogleFolder(null, (String)a3);
        }
        if (GoogleDrive.getGoogleSubFolderByName(GoogleDrive.getGoogleSubFolderByName(null, (String)a3).get(0).getId(), (String)object).size() < 1) {
            file = GoogleDrive.createGoogleFolder(GoogleDrive.getGoogleSubFolderByName(null, (String)a3).get(0).getId(), (String)object);
        }
        file = new com.google.api.services.drive.model.File();
        file.setName(a2 + ".zip");
        String[] arrstring = new String[1];
        arrstring[0] = GoogleDrive.getGoogleSubFolderByName(GoogleDrive.getGoogleSubFolderByName(null, (String)a3).get(0).getId(), (String)object).get(0).getId();
        file.setParents(Arrays.asList(arrstring));
        a3 = new File("backup/" + a2 + ".zip");
        a3 = new FileContent(null, (File)a3);
        a3 = (com.google.api.services.drive.model.File)ALLATORIxDEMO.files().create(file, (AbstractInputStreamContent)a3).setFields(MapleBuffStatValueHolder.ALLATORIxDEMO("9$")).execute();
        System.out.println("File ID: " + a3.getId());
    }
}

