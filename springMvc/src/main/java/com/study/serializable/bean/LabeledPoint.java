package com.study.serializable.bean;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * LabeledPoint
 *
 * @author zhougf
 * @date 2019/5/13
 */
public class LabeledPoint implements Serializable {
    private String label;
    transient private Point2D.Double point;

    public LabeledPoint(String str, double x, double y)
    {
        label = str;
        point = new Point2D.Double(x, y);
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {

        out.defaultWriteObject();
        out.writeDouble(point.getX());
        out.writeDouble(point.getY());
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {

        in.defaultReadObject();
        double x = in.readDouble() + 1.0;
        double y = in.readDouble() + 1.0;
        point = new Point2D.Double(x, y);
    }

    @Override
    public String toString()
    {
        return getClass().getName()+ "[label = " + label+ ", point.getX() = " + point.getX()+ ", point.getY() = " +

                point.getY()+ "]";
    }
}
