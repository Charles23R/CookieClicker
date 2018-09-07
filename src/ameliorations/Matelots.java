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
        setMax(new Label(""));
    }

    @Override
    public void ameliorer(Player player, Amelioration navire) {
        if (Integer.parseInt(getLevel().getText()) < ((Integer.parseInt(navire.getLevel().getText()) * 5)) || navire.getMax().getText().equals("MAX")) {
            if (Integer.parseInt(getCout().getText()) <= Integer.parseInt(player.getNbClics().getText())) {

                if (Integer.parseInt(getLevel().getText()) == 1) {
                    player.setPtAuto(1);
                } else {
                    player.setPtAuto(player.getPtAuto() * 2);
                }

                int temp = (Integer.parseInt(player.getNbClics().getText()) - ((Integer.parseInt(getCout().getText())) - player.getRemise()));
                player.getNbClics().setText(String.valueOf(temp));
                getCout().setText(String.valueOf(Integer.parseInt(getCout().getText()) * 2));
                getLevel().setText(String.valueOf(Integer.parseInt(getLevel().getText()) + 1));
            }
        }
    }
}