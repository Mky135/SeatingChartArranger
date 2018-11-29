package util;

import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.awt.Point;

public class StudentUI
{
    final Tooltip tooltip = new Tooltip();

    private Label name = new Label();
    private Point seat;
    private ImageView imageView;

    public StudentUI(Student student)
    {
        this.name.setText(student.getName());
        this.seat = student.getSeat();
    }

    public void add(AnchorPane pane, int w, int h)
    {
        double width = (pane.getMaxWidth()-(2*(w)))/w;
        double height = (pane.getMaxHeight()-(2*(h)))/h;

        Image image = new Image(getClass().getResourceAsStream("/stock.jpg"), height, width, true, true);
        imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        tooltip.setText(name.getText());
        tooltip.setShowDelay(Duration.ZERO);
        Tooltip.install(imageView, tooltip);

        imageView.setLayoutY(seat.y * (height-20));
        imageView.setLayoutX(seat.x * (width-20));

        pane.getChildren().add(imageView);
    }
}