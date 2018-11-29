import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.FileHandler;
import util.SeatHandler;
import util.Student;
import util.StudentUI;

import java.awt.*;

public class Main extends Application
{
    private static SeatHandler seatHandler = new SeatHandler(4, 2);

    public static void main (String[] args)
    {
        FileHandler fileHandler = new FileHandler("src/Names2.txt");



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

        launch(args);
    }

    @Override
    public void start(Stage  primaryStage) throws Exception
    {
//        Parent root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
        primaryStage.setTitle("Hello World");

        AnchorPane root = new AnchorPane();
        root.setMaxSize(1000, 1000);
        root.setPrefSize(500, 500);

        StudentUI studentUI;

        for(int r = 0; r < seatHandler.seatingChart.length; r++)
        {
            for(int c = 0; c < seatHandler.seatingChart[0].length; c++)
            {
                studentUI = new StudentUI(seatHandler.seatingChart[r][c]);
                studentUI.add(root, seatHandler.seatingChart.length, seatHandler.seatingChart[0].length);
            }
        }


        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
