package com.rain.util;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;



/**

 * 获取经纬度

 *

 * @author jueyue 返回格式：Map<String,Object> map map.put("status",

 * reader.nextString());//状态 map.put("result", list);//查询结果

 * list<map<String,String>>

 * 密钥:f247cdb592eb43ebac6ccd27f796e2d2

 */

public class GetLatAndLngByBaidu{



    /**

     * @param addr

     * 查询的地址

     * @return

     * @throws IOException

     */

    public Double[] getCoordinate(String addr) throws IOException {

        String lng = null;//经度

        String lat = null;//纬度

        String address = null;

        try {

            address = java.net.URLEncoder.encode(addr, "UTF-8");

        }catch (UnsupportedEncodingException e1) {

            e1.printStackTrace();

        }

        String key = "f247cdb592eb43ebac6ccd27f796e2d2";

        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key);

        URL myURL = null;

        URLConnection httpsConn = null;

        try {

            myURL = new URL(url);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        }

        InputStreamReader insr = null;

        BufferedReader br = null;

        try {

            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理

            if (httpsConn != null) {

                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");

                br = new BufferedReader(insr);

                String data = null;

                int count = 1;

                while((data= br.readLine())!=null){

                    if(count==5){

                        lng = (String)data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度

                        count++;

                    }else if(count==6){

                        lat = data.substring(data.indexOf(":")+1);//纬度

                        count++;

                    }else{

                        count++;

                    }

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if(insr!=null){

                insr.close();

            }

            if(br!=null){

                br.close();

            }

        }
        Double[] doubles = new Double[2];
        doubles[0] = Double.parseDouble(lng);
        doubles[1] = Double.parseDouble(lat);


        return doubles;

    }






        /**
         * 甘肃省定西市渭源县清源镇
         *lng : 104.194926
         * lat : 35.172499
         * 甘肃省定西市渭源县新寨镇
         *lng : 104.240063
         * lat : 35.28701
         * 北京市海淀区
         * lng : 116.449559
         * lat : 39.926375
         */
       /* public static void nskcfnsjdk(String adress) throws IOException {
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();

        Object[] o = getLatAndLngByBaidu.getCoordinate(adress);

        System.out.println(o[0]);//经度

        System.out.println(o[1]);//纬度

    }*/



}