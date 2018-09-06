package ameliorations;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class Estetik extends Amelioration {

    public Estetik() {
        setBouton(new Button("4-Esthétique"));
        setEffet(new Label(""));
        setLevel(new Label("1"));
        setCout(new Label("50"));
    }

    @Override
    public void ameliorer(Player player) {

    }
}
