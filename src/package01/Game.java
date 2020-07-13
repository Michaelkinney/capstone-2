package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    Transition tn = new Transition(ui);
    Story story = new Story(this, ui, tn);

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public interface EndingText {              //interface with lambda
        abstract void sayThanks();
    }

    public static void main(String[] args) {

        new Game();

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EndingText endingText =()->{System.out.println("Thanks for playing!");};    //lambda
        endingText.sayThanks();

    }

    public Game(){

        ui.createUI(cHandler);           // calling createUI method from UI(and passing cHandler back to UI)
        story.defaultSetup();
        tn.showTitleScreen();

    }

    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "start": tn.titleToTown(); story.townGate(); break;
                case "c1": story.selectPosition(nextPosition1); break;
                case "c2": story.selectPosition(nextPosition2); break;
                case "c3": story.selectPosition(nextPosition3); break;
                case "c4": story.selectPosition(nextPosition4); break;
            }

        }
    }

}
