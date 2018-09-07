package ameliorations;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public abstract class Amelioration {
    private Button bouton;
    private Label effet;
    private Label level;
    private Label cout;
    private Label max;

    public abstract void ameliorer(Player player, Amelioration navire);

    public Button getBouton() {
        return bouton;
    }

    public void setBouton(Button bouton) {
        this.bouton = bouton;
    }

    public Label getEffet() {
        return effet;
    }

    public void setEffet(Label effet) {
        this.effet = effet;
    }

    public Label getLevel() {
        return level;
    }

    public void setLevel(Label level) {
        this.level = level;
    }

    public Label getCout() {
        return cout;
    }

    public void setCout(Label cout) {
        this.cout = cout;
    }

    public Label getMax() {
        return max;
    }

    public void setMax(Label max) {
        this.max = max;
    }
}
