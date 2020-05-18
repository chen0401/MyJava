package com.c.java.jol;


import org.openjdk.jol.info.ClassLayout;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/15 09:46
 * @description
 **/
public class JavaObjectLayout {

    public static String get(String message) {
        // message => json => xml
        String xml = "<soapenv:Envelope\n" +
                "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "xmlns:ns0=\"http:// <IP 地址>:<端口>\"\n" +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "<soapenv:Body> <ns0:sendMt> <username>lcspxt</username> <password>lcspxt</password> <phoneNumbers>15960208888</phoneNumbers> <smsContent>发送短信测试</smsContent> <smsId>132</smsId> <sendTime>2013-07-15 14:11:20</sendTime>\n" +
                "</ns0:sendMt>\n" +
                "</soapenv:Body>\n" +
                "</soapenv:Envelope>";
        return xml;
    }

    public static void main(String[] args) throws IOException {

        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        Person person = new Person();
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        System.out.println(System.identityHashCode(person));
        System.out.println(ClassLayout.parseInstance(person).toPrintable());

        java.net.URL url = null;
        try {
            url = new URL("http://sms.xmut.edu.cn:80/webservice/SmsWebService?wsdl");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.write(get("").getBytes("UTF-8"));//params就是上面生成的xml内容
            dos.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line = null;
            StringBuffer strBuf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                strBuf.append(line);
            }
            dos.close();
            reader.close();
        } catch (Exception e) {
        }

    }

}
