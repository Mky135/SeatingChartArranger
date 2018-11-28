package util;

import java.awt.*;
import java.util.*;

public class SeatHandler
{
    public Student[][] seatingChart;
    private ArrayList<Student> students = new ArrayList<>();

    public SeatHandler(int rows, int columns)
    {
        seatingChart = new Student[rows][columns];
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public void setSeatingChart()
    {
        int i = 0;
        for(int r = 0; r < seatingChart.length; r++)
        {
            for(int c = 0; c < seatingChart[0].length; c++)
            {
                if(i < students.size())
                {
                    seatingChart[r][c] = students.get(i);
                    i++;
                }
            }
        }
    }

    public void shuffle()
    {
        Random random = new Random();

        Student[][] oldSeatingChart = seatingChart;

        for(int i = seatingChart.length - 1; i > 0; i--)
        {
            for(int j = seatingChart[i].length - 1; j > 0; j--)
            {
                boolean sameSeat = false;

                do
                {
                    int m = random.nextInt(i + 1);
                    int n = random.nextInt(j + 1);

                    Student temp = seatingChart[i][j];
                    seatingChart[i][j] = seatingChart[m][n];
                    seatingChart[m][n] = temp;

                    if(oldSeatingChart[i][j] == seatingChart[m][n])
                    {
//                        System.out.println("Student " + temp.getName() + " was placed in the same spot");
                        sameSeat = true;
                    }
                    else
                    {
                        sameSeat = false;
                    }
                }
                while(!sameSeat);
            }
        }

        for(int r = 0; r < seatingChart.length; r++)
        {
            for(int c = 0; c < seatingChart[0].length; c++)
            {
                seatingChart[r][c].setSeat(new Point(r, c));
            }
        }
    }
}
