package com.study.serializable;

import com.study.serializable.bean.LabeledPoint;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * TrainsientTest
 *
 * @author zhougf
 * @date 2019/5/13
 */
public class TrainsientTest {
    public static void main(String[] args)
    {

        LabeledPoint label = new LabeledPoint("Book", 5.00, 5.00);

        try
        {
            // 写入前
            System.out.println(label);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Label.txt"));
            //通过对象输出流，将label写入流中
            out.writeObject(label);
            out.close();
            // 写入后
            System.out.println(label);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Label.txt"));
            LabeledPoint label1 = (LabeledPoint) in.readObject();
            in.close();
            // 读出并加1.0后
            System.out.println(label1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
