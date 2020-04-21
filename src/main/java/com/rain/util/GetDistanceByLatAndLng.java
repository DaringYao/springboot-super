package com.rain.util;

import java.io.IOException;

//根据经纬度计算距离
public class GetDistanceByLatAndLng {

    public  String distance(String adress1,String adress2) throws IOException {
        /**
         * 甘肃省定西市渭源县清源镇
         *lng : 104.194926
         *lat : 35.172499
         * 甘肃省定西市渭源县新寨镇
         *lng : 104.240063
         * lat : 35.28701
         * 北京市海淀区
         * lng : 116.449559
         * lat : 39.926375
         *
         * 清源镇到新寨镇13.3918km
         * 清源镇到北京1202.6223km
         *
         * 测试正确
         */
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        Double[] coordinate1 = getLatAndLngByBaidu.getCoordinate(adress1);
        Double[] coordinate2 = getLatAndLngByBaidu.getCoordinate(adress2);
        System.out.println(coordinate1[1]);
        System.out.println(coordinate1[0]);
        System.out.println(coordinate2[1]);
        System.out.println(coordinate2[0]);

        double distanse = getDistance(coordinate1[0], coordinate1[1], coordinate2[0],  coordinate2[1]);
        String disStr = distanse+"km";
        System.out.println(disStr);
        return disStr;


    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
    private static double EARTH_RADIUS = 6378.137;
    //地球半径
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;

        return s;

    }}
