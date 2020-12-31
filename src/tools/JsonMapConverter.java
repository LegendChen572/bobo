/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.type.TypeReference
 *  com.fasterxml.jackson.databind.ObjectMapper
 */
package tools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import tools.LoadPacket;
import tools.npcgenerator.NPCMessage;

public class JsonMapConverter {
    public static /* synthetic */ Map<String, Long> JsonToMapLong(String a2) {
        Map<String, Long> map = new HashMap<String, Long>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            map = (Map)objectMapper.readValue(a2, (TypeReference)new TypeReference<HashMap<String, Long>>(){
                {
                    2 a2;
                }
            });
            return map;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return map;
        }
    }

    public /* synthetic */ JsonMapConverter() {
        JsonMapConverter a2;
    }

    public static /* synthetic */ Map<Object, Object> JsonToMapObject(String a2) {
        HashMap<Object, Object> hashMap = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            hashMap = (Map)objectMapper.readValue(a2, (TypeReference)new TypeReference<HashMap<Object, Object>>(){
                {
                    4 a2;
                }
            });
            return hashMap;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            hashMap = null;
            return null;
        }
    }

    public static /* synthetic */ String MapToJsonItem(Map<String, Object> a2) {
        String string = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            string = objectMapper.writeValueAsString(a2);
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string;
        }
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(LoadPacket.ALLATORIxDEMO("=0\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u0014\u0019\u00143\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00170=0\u00173\u00173\u00173\u00173\u00140\u00170\u00173\u00170\u00173\u00173\u00140\u00170\u00140\u00170\u00140\u00170\u00143\u00170\u00140\u00173\u00173\u00173\u00173\u0014\u0019\u00143\u00173\u00173\u00173\u00143\u00143\u00143\u00173\u00143\u00173\u00143\u00143\u00170\u00173\u00143\u00143\u00143\u00143\u00170\u00173\u00173\u00173\u00173\u00170=0\u00173\u00173\u00173\u00170\u00140\u00170\u00173\u00170\u00173\u00170\u00140\u00173\u00143\u00170\u00170\u00170\u00143\u00173\u00143\u00173\u00173\u00173\u00173\u0014\u0019\u00143\u00173\u00173\u00173\u00143\u00143\u00140\u00143\u00140\u00143\u00143\u00143\u00170\u00173\u00140\u00143\u00143\u00143\u00140\u00143\u00173\u00173\u00173\u00170=0\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u0014\u0019\u00143xqQfDpVg^|Y3Uj\u0017R[\u007fVgXa^3xqQfDpVgXa\u0017e\u0000=\u00043sVz\\\u00170=0\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u0014\u0019\u00143\u00173\u00173\u00173\u00173\u00173_gCc\r<\u0018d@d\u0019r[\u007fVgXa^=T|Z3\u00173\u00173\u00173\u00173\u00173\u00170=0\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u00173\u0014\u0019\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140\u00140="));
        Object object = new HashMap<String, Integer>();
        object.put(NPCMessage.ALLATORIxDEMO("\u5e0b"), 1);
        object.put(LoadPacket.ALLATORIxDEMO("\u5e6a\u5e4e"), 2);
        object = JsonMapConverter.MapToJson(object);
        System.out.println("MapToJson:" + (String)object);
        object = JsonMapConverter.JsonToMap((String)object);
        System.out.println(NPCMessage.ALLATORIxDEMO("'\u0001\u0002\u001c9\u001d \u0013\u001dH"));
        Object object2 = object = object.entrySet().iterator();
        while (object2.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            System.out.println("key = " + (String)entry.getKey() + " value = " + entry.getValue());
            object2 = object;
        }
    }

    public static /* synthetic */ Map<String, Integer> JsonToMap(String a2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            map = (Map)objectMapper.readValue(a2, (TypeReference)new TypeReference<HashMap<String, Integer>>(){
                {
                    1 a2;
                }
            });
            return map;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return map;
        }
    }

    public static /* synthetic */ Map<String, String> JsonToMapItem(String a2) {
        HashMap<String, String> hashMap = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            hashMap = (Map)objectMapper.readValue(a2, (TypeReference)new TypeReference<HashMap<String, String>>(){
                {
                    3 a2;
                }
            });
            return hashMap;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            hashMap = null;
            return null;
        }
    }

    public static /* synthetic */ String MapToJson(Map<String, Integer> a2) {
        String string = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            string = objectMapper.writeValueAsString(a2);
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string;
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4;
        int cfr_ignored_0 = 5 << 3 ^ 2;
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ 5;
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

    public static /* synthetic */ String MapToJsonLong(Map<String, Long> a2) {
        String string = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            string = objectMapper.writeValueAsString(a2);
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string;
        }
    }
}

