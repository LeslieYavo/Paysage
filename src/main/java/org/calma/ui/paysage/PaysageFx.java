package org.calma.ui.paysage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PaysageFx extends Application {
    @Override
    public void start(Stage stage) {
        // Groupe principal
        Group root = new Group();

        // Ciel (fond)
        Rectangle sky = new Rectangle(800, 600);
        sky.setFill(Color.LIGHTBLUE);
        root.getChildren().add(sky);

        // Soleil
        Circle sun = new Circle(700, 100, 50);
        sun.setFill(Color.YELLOW);
        root.getChildren().add(sun);

        // Montagnes
        Polygon mountain1 = new Polygon();
        mountain1.getPoints().addAll(
                200.0, 400.0,  // Sommet gauche
                400.0, 200.0,  // Pic
                600.0, 400.0   // Sommet droit
        );
        mountain1.setFill(Color.DARKGRAY);
        root.getChildren().add(mountain1);

        Polygon mountain2 = new Polygon();
        mountain2.getPoints().addAll(
                300.0, 400.0,
                500.0, 250.0,
                700.0, 400.0
        );
        mountain2.setFill(Color.GRAY);
        root.getChildren().add(mountain2);

        // Sol
        Rectangle ground = new Rectangle(0, 400, 800, 200);
        ground.setFill(Color.FORESTGREEN);
        root.getChildren().add(ground);

        // Arbres
        for (int i = 0; i < 5; i++) {
            // Tronc
            Rectangle trunk = new Rectangle(100 + i * 120, 350, 20, 50);
            trunk.setFill(Color.SADDLEBROWN);
            root.getChildren().add(trunk);

            // Feuillage
            Circle foliage = new Circle(110 + i * 120, 340, 30);
            foliage.setFill(Color.DARKGREEN);
            root.getChildren().add(foliage);
        }

        // Nuages
        addCloud(root, 150, 100);
        addCloud(root, 400, 80);
        addCloud(root, 600, 150);

        // Création de la scène
        Scene scene = new Scene(root, 800, 600);

        // Configuration de la fenêtre
        stage.setTitle("Paysage JavaFX avec Nuages");
        stage.setScene(scene);
        stage.show();
    }

    private void addCloud(Group root, double x, double y) {
        Group cloud = new Group();

        // Les cercles qui composent un nuage
        Circle c1 = new Circle(x, y, 30, Color.WHITE);
        Circle c2 = new Circle(x + 30, y + 10, 35, Color.WHITE);
        Circle c3 = new Circle(x - 30, y + 10, 35, Color.WHITE);
        Circle c4 = new Circle(x, y + 20, 30, Color.WHITE);

        cloud.getChildren().addAll(c1, c2, c3, c4);

        root.getChildren().add(cloud);
    }

    public static void main(String[] args) {
        launch();
    }
}

