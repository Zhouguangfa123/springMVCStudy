package com;

import com.commom.ProPerTiesTools;

import java.util.Properties;

/**
 * test
 *
 * @author zhougf
 * @date 2019/5/27
 */
public class test {
    public static void main(String[] args) throws Exception{
        Properties properties = ProPerTiesTools.getProperties("src/main/resources/user.properties");
        System.out.println(properties.getProperty("userName"));
    }
}
