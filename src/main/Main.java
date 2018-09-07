package main;

import ameliorations.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import player.Player;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Set le primary stage
        primaryStage.setWidth(900);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Le jeu du baleinier");
        primaryStage.setResizable(false);

        /////Création de tout élément graphique/Objet/Tableau///////
        Group root=new Group();
        Scene scene = new Scene(root);
        Player joueur = new Player();
        ArrayList<Amelioration> listeAmelioration = new ArrayList<Amelioration>();
        ArrayList<Label> listeLevel = new ArrayList<Label>();
        ArrayList<Label> listeCout = new ArrayList<Label>();
        Label texte = new Label("Nombre de clics :");

        Amelioration harpon=new Harpon();
        Amelioration matelot=new Matelots();
        Amelioration navire=new Navire();
        Amelioration marchandage=new Marchandage();
        Amelioration esthetique=new Estetik();
        listeAmelioration.add(harpon);
        listeAmelioration.add(matelot);
        listeAmelioration.add(navire);
        listeAmelioration.add(marchandage);
        listeAmelioration.add(esthetique);


        /////Ajustement de tout objet != d'une amélioration///////
        texte.setTranslateX(500);
        texte.setTranslateY(10);
        texte.setScaleX(2);
        texte.setScaleY(2);

        joueur.getNbClics().setTranslateY(10);
        joueur.getNbClics().setTranslateX(750);
        joueur.getNbClics().setScaleX(2);
        joueur.getNbClics().setScaleY(2);

        joueur.getClicker().setScaleY(4);
        joueur.getClicker().setScaleX(8);
        joueur.getClicker().setTranslateX(550);
        joueur.getClicker().setTranslateY(300);

        /////Ajustement de toutes les améliorations///////
        for (int i = 0; i < listeAmelioration.size(); i++) {
            listeAmelioration.get(i).getBouton().setScaleX(1.5);
            listeAmelioration.get(i).getBouton().setScaleY(1);
            listeAmelioration.get(i).getBouton().setTranslateY(i * 160 + 30);
            listeAmelioration.get(i).getBouton().setTranslateX(50);

            listeAmelioration.get(i).getLevel().setScaleX(2);
            listeAmelioration.get(i).getLevel().setScaleY(1);
            listeAmelioration.get(i).getLevel().setTranslateY(i * 160 + 60);
            listeAmelioration.get(i).getLevel().setTranslateX(150);

            listeAmelioration.get(i).getCout().setScaleX(2);
            listeAmelioration.get(i).getCout().setScaleY(1);
            listeAmelioration.get(i).getCout().setTranslateY(i * 160 + 80);
            listeAmelioration.get(i).getCout().setTranslateX(150);

            listeCout.add(new Label("Coût :"));
            listeCout.get(i).setScaleX(2);
            listeCout.get(i).setScaleY(1);
            listeCout.get(i).setTranslateY(i * 160 + 80);
            listeCout.get(i).setTranslateX(50);

            listeLevel.add(new Label("Niveau :"));
            listeLevel.get(i).setScaleX(2);
            listeLevel.get(i).setScaleY(1);
            listeLevel.get(i).setTranslateY(i * 160 + 60);
            listeLevel.get(i).setTranslateX(50);

            listeAmelioration.get(i).getEffet().setScaleX(1.5);
            listeAmelioration.get(i).getEffet().setScaleY(1.5);
            listeAmelioration.get(i).getEffet().setTranslateY(500);
            listeAmelioration.get(i).getEffet().setTranslateX(350);

            listeAmelioration.get(i).getMax().setScaleX(2);
            listeAmelioration.get(i).getMax().setScaleY(1);
            listeAmelioration.get(i).getMax().setTranslateY(i * 160 + 60);
            listeAmelioration.get(i).getMax().setTranslateX(150);
        }

        /////Timeline (Steins;Gate c'est une référence à la série Stein;Gate)///////
        final Timeline steinsGate = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            joueur.getNbClics().setText(String.valueOf(Integer.parseInt(joueur.getNbClics().getText()) + joueur.getPtAuto()));
        }));
        steinsGate.setCycleCount(steinsGate.INDEFINITE);
        steinsGate.play();

        /////Actions du bouton normal///////
        joueur.getClicker().setOnAction((event) -> {
            joueur.getNbClics().setText(String.valueOf(Integer.parseInt(joueur.getNbClics().getText()) + joueur.getPointParClic()));
            if (Integer.parseInt(esthetique.getLevel().getText())>=3){
                joueur.getClicker().setTextFill(Color.rgb(((int)(Math.random()*256)),((int)(Math.random()*256)),((int)(Math.random()*256))));
            }
            else if (Integer.parseInt(esthetique.getLevel().getText())==2){
                scene.setFill(Color.PINK);
            }
            if (Integer.parseInt(esthetique.getLevel().getText())>=4){
                scene.setFill(Color.rgb(((int)(Math.random()*256)),((int)(Math.random()*256)),((int)(Math.random()*256))));
            }
        });

        /////Action des améliorations///////
        matelot.getBouton().setOnAction((event)->{
            matelot.ameliorer(joueur, navire);
        });

        marchandage.getBouton().setOnAction((event)->{
            marchandage.ameliorer(joueur, navire);
        });

        navire.getBouton().setOnAction((event)->{
            navire.ameliorer(joueur, navire);
        });

        esthetique.getBouton().setOnAction((event)->{
            esthetique.ameliorer(joueur, navire);
        });

        harpon.getBouton().setOnAction((event)->{
            harpon.ameliorer(joueur, navire);
        });

        /////Afficher l'effet de chaque bouton///////
        harpon.getBouton().setOnMouseEntered((event)->{
            harpon.getEffet().setText("Augmente le nombre de dégat par clic");
        });

        matelot.getBouton().setOnMouseEntered((event)->{
            matelot.getEffet().setText("Augmente le nombre de clics automatiques par seconde");
        });

        marchandage.getBouton().setOnMouseEntered((event)->{
            marchandage.getEffet().setText("Donne un pourcentage de remise pour chaque achat");
        });

        esthetique.getBouton().setOnMouseEntered((event)->{
            esthetique.getEffet().setText("Augmente votre qualité de vie");
        });

        navire.getBouton().setOnMouseEntered((event)->{
            navire.getEffet().setText("Débloque l'amélioration des autres capacités:\nNiveau 1 -> Améliorations disponibles jusqu'à 5\nNiveau 2 -> Améliorations disponibles jusqu'à 10\nNiveau 3 -> Améliorations disponibles jusqu'à 15\nNiveau 4 -> Améliorations disponibles jusqu'à l'infini");
        });

        harpon.getBouton().setOnMouseExited((event)->{
            harpon.getEffet().setText("");
        });

        matelot.getBouton().setOnMouseExited((event)->{
            matelot.getEffet().setText("");
        });

        marchandage.getBouton().setOnMouseExited((event)->{
            marchandage.getEffet().setText("");
        });

        esthetique.getBouton().setOnMouseExited((event)->{
            esthetique.getEffet().setText("");
        });

        navire.getBouton().setOnMouseExited((event)->{
            navire.getEffet().setText("");
        });


        /////Remplissage du root et lancement de la scène///////
        root.getChildren().add(joueur.getClicker());
        root.getChildren().add(texte);
        root.getChildren().add(joueur.getNbClics());

        for (int i=0; i<5; i++){
            root.getChildren().add(listeAmelioration.get(i).getCout());
            root.getChildren().add(listeAmelioration.get(i).getLevel());
            root.getChildren().add(listeAmelioration.get(i).getBouton());
            root.getChildren().add(listeAmelioration.get(i).getEffet());
            root.getChildren().add(listeCout.get(i));
            root.getChildren().add(listeLevel.get(i));
            root.getChildren().add(listeAmelioration.get(i).getMax());
        }
        scene.setRoot(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
