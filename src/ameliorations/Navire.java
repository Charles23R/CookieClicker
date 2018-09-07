package ameliorations;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class Navire extends Amelioration {

    public Navire() {
        setBouton(new Button("3-Navire"));
        setEffet(new Label(""));
        setLevel(new Label("1"));
        setCout(new Label("500"));
        setMax(new Label(""));
    }

    @Override
    public void ameliorer(Player player, Amelioration navire) {
        if (Integer.parseInt(getLevel().getText())<4){
            if (Integer.parseInt(getCout().getText())<=Integer.parseInt(player.getNbClics().getText())) {

                int temp = (Integer.parseInt(player.getNbClics().getText())-((Integer.parseInt(getCout().getText()))-player.getRemise()));
                player.getNbClics().setText(String.valueOf(temp));
                getCout().setText(String.valueOf(Integer.parseInt(getCout().getText()) * 4));
                getLevel().setText(String.valueOf(Integer.parseInt(getLevel().getText())+1));

                if (Integer.parseInt(getLevel().getText())==4){
                    getLevel().setTranslateX(2000);
                    getMax().setText("MAX");
                }
            }
        }
    }
}
