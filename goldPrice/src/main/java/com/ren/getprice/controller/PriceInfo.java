package com.ren.getprice.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class PriceInfo {

    @Resource
    private JavaMailSender mailSender;

    @GetMapping("send")
    private void send() throws InterruptedException {

        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom("3256772458@qq.com");
        // 收件人
        message.setTo("0@igotu.top");
        // 邮件标题
        message.setSubject("金价变动！！");
        // 邮件内容
        message.setText(getInfo(412.00, 411.95));
        // 抄送人
        message.setCc("3256772458@qq.com");
        mailSender.send(message);
    }

    /**
     * 设置高低区间返回msg
     * @param highPrice
     * @param lowPrice
     * @return
     * @throws InterruptedException
     */
    public static String getInfo(Double highPrice, Double lowPrice) throws InterruptedException {
        while(true){
            Thread.sleep(800);
            if (getPrice() > highPrice){
                return "价格高于 ： "+highPrice+"  请准备进行抛投处理";
            }
            if (getPrice() <= lowPrice){
                return "价格低于 ： "+lowPrice+"  请准备进行加仓处理";
            }
        }
    }

    /**
     * 调用priceapi查询价格
     * @return
     */
    public static Double getPrice() {
        String param = "location=108.62 ,21.95&key=key";
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader br = null;
        PrintWriter out = null;
        Double price = null;
        try {
            //接口地址
            String url = "https://api.jdjygold.com/gw/generic/hj/h5/m/latestPrice";
            URL uri = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("accept", "*/*");
            //发送参数
            connection.setDoOutput(true);
            out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            //接收结果
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            //缓冲逐行读取
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String backStr = sb.toString();

            JSONObject parseObject = JSONArray.parseObject(backStr);
            JSONObject obj = parseObject.getJSONObject("resultData");
            String uid = obj.getString("datas");
            JSONObject parseObjects = JSONArray.parseObject(uid);
            String price1 = parseObjects.getString("price");
            price = Double.valueOf(price1);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭流
            try {
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception ignored) {
                System.out.println(ignored);
            }
        }
        return price;
    }
}

