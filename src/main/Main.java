package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import player.Player;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(900);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Como estas");
        primaryStage.setResizable(false);

        Player joueur = new Player();
        ArrayList<Button> listeAmelioration = new ArrayList<Button>();
        Button amelioration1 = new Button("Pioche");
        Button amelioration2 = new Button("Villageois");
        Button amelioration3 = new Button("3");
        Button amelioration4 = new Button("4");
        Button amelioration5 = new Button("5");
        listeAmelioration.add(amelioration1);
        listeAmelioration.add(amelioration2);
        listeAmelioration.add(amelioration3);
        listeAmelioration.add(amelioration4);
        listeAmelioration.add(amelioration5);
        Label texte = new Label("Nombre de clics :");

        texte.setTranslateX(300);
        texte.setTranslateY(10);
        texte.setScaleX(2);
        texte.setScaleY(2);
        joueur.getNbClics().setTranslateY(10);
        joueur.getNbClics().setTranslateX(470);
        joueur.getNbClics().setScaleX(2);
        joueur.getNbClics().setScaleY(2);

        joueur.getClicker().setScaleY(4);
        joueur.getClicker().setScaleX(8);
        joueur.getClicker().setTranslateX(550);
        joueur.getClicker().setTranslateY(400);

        for (int i = 0; i < listeAmelioration.size(); i++) {
            listeAmelioration.get(i).setScaleX(4);
            listeAmelioration.get(i).setScaleY(2);
            listeAmelioration.get(i).setTranslateY(i * 160 + 30);
            listeAmelioration.get(i).setTranslateX(50);
        }

        joueur.getClicker().setOnAction((event) -> {
            joueur.getNbClics().setText(String.valueOf(Integer.parseInt(joueur.getNbClics().getText()) + joueur.getPointParClic()));
        });

        Group root = new Group(amelioration1, amelioration2, amelioration3, amelioration4, amelioration5, joueur.getClicker(), texte, joueur.getNbClics());

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
