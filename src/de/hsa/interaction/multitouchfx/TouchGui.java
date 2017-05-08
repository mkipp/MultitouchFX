package de.hsa.interaction.multitouchfx;

import java.util.HashMap;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Michael Kipp
 */
public class TouchGui extends Application {

    private HashMap<Integer, TouchCursor> id2cursor = new HashMap<>();

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        root.setPrefSize(1000, 800);

        Scene scene = new Scene(root, 1000, 800);

        scene.setOnTouchPressed(e -> {
            TouchCursor cur = id2cursor.get(e.getTouchPoint().getId());
            if (cur == null) {
                TouchCursor c = new TouchCursor(40);

                id2cursor.put(e.getTouchPoint().getId(), c);
                root.getChildren().add(c);
                c.setCenter(e.getTouchPoint().getX(), e.getTouchPoint().getY());
            } else {
                cur.setCenter(e.getTouchPoint().getX(), e.getTouchPoint().getY());
                cur.setVisible(true);
            }
        });

        scene.setOnTouchMoved(e -> {
            TouchCursor cur = id2cursor.get(e.getTouchPoint().getId());
            cur.setCenter(e.getTouchPoint().getX(), e.getTouchPoint().getY());
        });

        scene.setOnTouchReleased(e -> {
            TouchCursor c = id2cursor.get(e.getTouchPoint().getId());
            c.setVisible(false);
        });

        stage.setTitle("TouchGui");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {
            Platform.exit();
        });
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
