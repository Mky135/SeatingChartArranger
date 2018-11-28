import util.FileHandler;
import util.SeatHandler;
import util.Student;

import java.awt.*;

public class Main
{
    public static void main (String[] args)
    {
        FileHandler fileHandler = new FileHandler("src/Names2.txt");

        SeatHandler seatHandler = new SeatHandler(4, 4);

        int i =0;
        for(int r = 0; r < seatHandler.seatingChart.length; r++)
        {
            for(int c= 0; c < seatHandler.seatingChart[0].length; c++)
            {
                seatHandler.addStudent(new Student(fileHandler.getLine(i), new Point(r, c)));
                i++;
            }
        }

        seatHandler.setSeatingChart();

        for(int r = 0; r < seatHandler.seatingChart.length; r++)
        {
            for(int c= 0; c < seatHandler.seatingChart[0].length; c++)
            {
                System.out.print(seatHandler.seatingChart[r][c] + ", ");
            }

            System.out.println();
        }

        System.out.println("_________________________________________");
        seatHandler.shuffle();

        for(int r = 0; r < seatHandler.seatingChart.length; r++)
        {
            for(int c= 0; c < seatHandler.seatingChart[0].length; c++)
            {
                System.out.print(seatHandler.seatingChart[r][c] + " ");
            }

            System.out.println();
        }
    }
}
