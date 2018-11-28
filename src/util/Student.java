package util;

import javafx.scene.image.Image;

import java.awt.*;

public class Student
{
    private String name;
    private Point seat;
    private Image picture;

    public Student(String name)
    {
        setName(name);
    }

    public Student(String name, Point seat)
    {
        setName(name);
        setSeat(seat);
    }

    public Student(String name, Point seat, Image picture)
    {
        setName(name);
        setSeat(seat);
        setPicture(picture);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Point getSeat()
    {
        return seat;
    }

    public void setSeat(Point seat)
    {
        this.seat = seat;
    }

    public Image getPicture()
    {
        return picture;
    }

    public void setPicture(Image picture)
    {
        this.picture = picture;
    }

    @Override
    public String toString()
    {
        return name + " " + seat;
    }
}
