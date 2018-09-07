package player;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Player {
    private Button clicker;
    private int pointParClic;
    private int ptAuto;
    private Label nbClics;
    private int remise;

    public Player() {
        this.clicker = new Button("Pêcher");
        this.pointParClic = 1;
        this.ptAuto = 0;
        this.nbClics = new Label("0");
        this.remise=0;
    }

    public Button getClicker() {
        return clicker;
    }

    public void setClicker(Button clicker) {
        this.clicker = clicker;
    }

    public int getPointParClic() {
        return pointParClic;
    }

    public void setPointParClic(int pointParClic) {
        this.pointParClic = pointParClic;
    }

    public int getPtAuto() {
        return ptAuto;
    }

    public void setPtAuto(int ptAuto) {
        this.ptAuto = ptAuto;
    }

    public Label getNbClics() {
        return nbClics;
    }

    public void setNbClics(Label nbClics) {
        this.nbClics = nbClics;
    }

    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) {
        this.remise = remise;
    }
}
