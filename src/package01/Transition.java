package package01;

public class Transition {

    UI ui;

    public Transition(UI userInterface){

        ui = userInterface;

    }

    public void showTitleScreen(){

        //Shows main menu
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        //Game screens hidden in this menu
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }
    public void titleToTown(){

        //Hide main menu
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        //Game screens Shown
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);

    }

}
