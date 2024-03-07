package com.ren.reply;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-11 21:06
 * @description:
 **/
public class Main {

    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            String request = getRequest(scanner.next());
            System.out.println(request);
        }
    }

    public static String getRequest(String question) {

        String answer = "";
        try {
            String info = URLEncoder.encode(question, "utf-8");//处理字符串
            String getURL = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=" + info;//网址拼接
            URL getUrl = new URL(getURL);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuffer last = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                last.append(line);
            }
            reader.close();
            connection.disconnect();//获取结束，得到返回的json

            String request = last.toString();
            JSONObject object = JSONObject.parseObject(request);
            answer = object.getString("content");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }//当遇到异常就抛出异常
        return answer;//返回结果
    }

}

