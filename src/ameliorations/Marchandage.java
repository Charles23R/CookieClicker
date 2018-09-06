package ameliorations;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class Marchandage extends Amelioration {
    private double pourcentage;

    public Marchandage() {
        setBouton(new Button("3-Marchandage"));
        setEffet(new Label(""));
        setLevel(new Label("1"));
        setCout(new Label("50"));
        this.pourcentage=1;
    }

    @Override
    public void ameliorer(Player player) {

    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }
}
