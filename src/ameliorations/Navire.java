package ameliorations;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class Navire extends Amelioration {

    public Navire() {
        setBouton(new Button("5-Navire"));
        setEffet(new Label(""));
        setLevel(new Label("1"));
        setCout(new Label("50"));
    }

    @Override
    public void ameliorer(Player player) {

    }
}
