package com.commom;

import java.io.*;
import java.util.Properties;

/**
 * ProPerTiesTools
 *
 * @author zhougf
 * @date 2019/5/27
 */
public class ProPerTiesTools {
    private static final Properties properties = new Properties();

    private ProPerTiesTools() {}

    public static Properties getProperties(String filePath) throws IOException {
        // ʹ��InPutStream����ȡproperties�ļ�
       BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
         properties.load(bufferedReader);
        return properties;
    }
}
