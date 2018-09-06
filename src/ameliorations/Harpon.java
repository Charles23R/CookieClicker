package ameliorations;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class Harpon extends Amelioration{

    public Harpon() {
        setBouton(new Button("1-Harpon"));
        setEffet(new Label(""));
        setLevel(new Label("1"));
        setCout(new Label("50"));
    }

    @Override
    public void ameliorer(Player player) {
        player.setPointParClic(player.getPointParClic()*2);

        player.getNbClics().setText(String.valueOf(Integer.parseInt(player.getNbClics().getText()) + getCout())));
    }
}
