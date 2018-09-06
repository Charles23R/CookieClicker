package ameliorations;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class Matelots extends Amelioration {

    public Matelots() {
        setBouton(new Button("2-Matelots"));
        setEffet(new Label(""));
        setLevel(new Label("1"));
        setCout(new Label("50"));
    }

    @Override
    public void ameliorer(Player player) {

    }
}
