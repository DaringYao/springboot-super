package com.rain.test;

import com.rain.util.GetDistanceByLatAndLng;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/27 7:28
 */
public class Test {
    public static void main(String[] args) throws IOException {
        GetDistanceByLatAndLng g = new GetDistanceByLatAndLng();
        String distance = g.distance("渭源西县新寨镇", "北京市海淀区");
        System.out.println(distance);

    }
}
