/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  org.apache.commons.codec.binary.Base64
 *  org.apache.http.HttpEntity
 *  org.apache.http.client.entity.UrlEncodedFormEntity
 *  org.apache.http.client.methods.CloseableHttpResponse
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.conn.ssl.NoopHostnameVerifier
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClients
 *  org.apache.http.message.BasicNameValuePair
 *  org.apache.http.util.EntityUtils
 */
package tools.imgur;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.net.ssl.HostnameVerifier;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import tools.imgur.ImgurResponse;

public class UploadImage {
    public static void main(String[] args) {
        String imageDir = "D:\\server\\photo\\penguin.png";
        String clientId = "3b99d51e8ee4c9c";
        UploadImage.imgur(imageDir, clientId);
    }

    public static String imgur(String imageDir, String clientID) {
        String address = "https://api.imgur.com/3/upload";
        String ret = "";
        CloseableHttpClient client = HttpClients.custom().setSSLHostnameVerifier((HostnameVerifier)NoopHostnameVerifier.INSTANCE).build();
        HttpPost post = new HttpPost(address);
        BufferedImage image = null;
        File file = new File(imageDir);
        try {
            image = ImageIO.read(file);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)image, "png", byteArray);
            byte[] byteImage = byteArray.toByteArray();
            String dataImage = new Base64().encodeAsString(byteImage);
            post.addHeader("Authorization", "Client-ID " + clientID);
            ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("image", dataImage));
            post.setEntity((HttpEntity)new UrlEncodedFormEntity(nameValuePairs));
            CloseableHttpResponse response = client.execute((HttpUriRequest)post);
            String jsonString = EntityUtils.toString((HttpEntity)response.getEntity());
            ImgurResponse responseJson = (ImgurResponse)new ObjectMapper().readValue(jsonString, ImgurResponse.class);
            System.out.println(responseJson.getData().getLink());
            ret = responseJson.getData().getLink();
        }
        catch (Exception e2) {
            System.out.println(e2.getMessage());
            e2.printStackTrace();
        }
        return ret;
    }

    public static String imgur(InputStream stream, String clientID) {
        String address = "https://api.imgur.com/3/upload";
        String ret = "";
        CloseableHttpClient client = HttpClients.custom().setSSLHostnameVerifier((HostnameVerifier)NoopHostnameVerifier.INSTANCE).build();
        HttpPost post = new HttpPost(address);
        BufferedImage image = null;
        try {
            image = ImageIO.read(stream);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)image, "png", byteArray);
            byte[] byteImage = byteArray.toByteArray();
            String dataImage = new Base64().encodeAsString(byteImage);
            post.addHeader("Authorization", "Client-ID " + clientID);
            ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("image", dataImage));
            post.setEntity((HttpEntity)new UrlEncodedFormEntity(nameValuePairs));
            CloseableHttpResponse response = client.execute((HttpUriRequest)post);
            String jsonString = EntityUtils.toString((HttpEntity)response.getEntity());
            ImgurResponse responseJson = (ImgurResponse)new ObjectMapper().readValue(jsonString, ImgurResponse.class);
            System.out.println(responseJson.getData().getLink());
            ret = responseJson.getData().getLink();
        }
        catch (Exception e2) {
            System.out.println(e2.getMessage());
            e2.printStackTrace();
        }
        return ret;
    }
}

