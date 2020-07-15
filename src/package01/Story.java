package package01;

import package02.*;

public class Story {

    Game game;
    UI ui;
    Transition tn;
    Player player = new Player();
    SuperMonster monster;
    int silverRing;

    public Story(Game g, UI userInterface, Transition tManager){

        game = g;
        ui = userInterface;
        tn = tManager;
    }

    public void defaultSetup(){

        player.setHp(10);
        ui.hpNumberLabel.setText("" + player.getHp());

        player.currentWeapon = new Weapon_Stick();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        silverRing = 0;
    }

    public void selectPosition(String nextPosition){

        switch(nextPosition){
            case "townGate": townGate(); break;
            case "talkGuard": talkGuard(); break;
            case "attackGuard": attackGuard(); break;
            case "crossRoad": crossRoad(); break;
            case "north": north(); break;
            case "east": east(); break;
            case "west": west(); break;
            case "fight": fight(); break;
            case "playerAttack": playerAttack(); break;
            case "monsterAttack": monsterAttack(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "ending": ending(); break;
            case "toTitle": toTitle(); break;

            case "crossRoad2": crossRoad2(); break;
            case "waterFall": waterFall(); break;
            case "villager": villager(); break;
            //case "blackSmith": blackSmith(); break;         not used due to positioning
        }

    }

    public void townGate(){
        ui.mainTextArea.setText("You are at the main gate of the town after many months of travel. \nA disgruntled guard is standing before you.");
        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("Attack the guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";

    }

    public void talkGuard(){

        if(silverRing == 0){
            ui.mainTextArea.setText("Guard: Good evening Dwarf. I have never seen you before and I am in a horrible mood. \nSomething dear to me has been stolen. If you can find it, you may be deemed worthy to enter the town");
            ui.choice1.setText("Continue");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "townGate";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if(silverRing == 1) {           // else if?
            ending();
        }
    }


    public void attackGuard(){

        ui.mainTextArea.setText("Guard: Are you serious? \n\nThe guard slaps you and you fall down. \n(You receive 5 damage)");
        player.hp = player.getHp() - 5;
        ui.hpNumberLabel.setText("" + player.getHp());
        ui.choice1.setText("Continue");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void crossRoad(){
        ui.mainTextArea.setText("You are at a crossroad. \nSouth will bring you back to the guard." + ("\nChoose a direction, explore, and find a way to help the guard"));
        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("Go South");
        ui.choice4.setText("Go West");

        game.nextPosition1 = "north";
        game.nextPosition2 = "crossRoad2";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "villager";
    }

    public void north(){
        ui.mainTextArea.setText("In your delight you find a river. \nYou drink the water and rest at the bank. \n\n(You restore 5 health)");
        player.hp = player.getHp() + 5;
        ui.hpNumberLabel.setText("" + player.getHp());
        ui.choice1.setText("Leave");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void east(){            // method originally named east but is not a direction. Rename method to findWeapon
        ui.mainTextArea.setText("You stumble upon a cave and find an Axe! \n\n(You obtained an Axe, a Dwarf's best friend)");

        player.currentWeapon = new Weapon_Axe();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        ui.choice1.setText("Leave");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad2";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void west(){         // Method originally named west but not a direction. Rename to monsterEncounter.

        monster = new Monster_Troll();

        ui.mainTextArea.setText("You encounter a " + monster.name + "!" + " It emerges from its cave. A dirty, green, 7 foot tall beast with warts and hair all over its hideous figure!");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossRoad2";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // add here more pathways


    public void crossRoad2() {
        ui.mainTextArea.setText("You have entered another crossroad. \nYou have many options");
        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("Go South");
        ui.choice4.setText("Go West");

        game.nextPosition1 = "waterFall";
        game.nextPosition2 = "west";
        game.nextPosition3 = "east";
        game.nextPosition4 = "crossRoad";
    }

    public void waterFall() {
        ui.mainTextArea.setText("You hear the sounds of rushing water. Behind the brush you find a waterfall! \n\nYou rest for a bit and admire its beauty" + "\n(You restore 5 health)");
        player.hp = player.getHp() + 5;
        ui.hpNumberLabel.setText("" + player.getHp());

        ui.choice1.setText("Leave");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad2";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void villager() {
        ui.mainTextArea.setText("Villager: Hey there Dwarf. \nBe careful there are reports of a Troll wandering in the caves far to the east. \n\nI wouldn't go that way if I were you!");
        ui.choice1.setText("Leave");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    /*public void blackSmith() {            not used due to positioning
        ui.mainTextArea.setText("");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    } */




    public void fight(){

        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do you do?");
        ui.choice1.setText("Attack");
        ui.choice1.setText("Run");
        ui.choice1.setText("");
        ui.choice1.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad2";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerAttack() {

        int playerDamage = new java.util.Random().nextInt(player.getCurrentWeapon().damage);

        ui.mainTextArea.setText("You attacked the " + monster.name + " and gave " + playerDamage + " damage!");

        monster.hp = monster.hp - playerDamage;

        ui.choice1.setText("Continue");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (monster.hp > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (monster.hp <= 0) {                   // else if ?   or < 1 ?
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void monsterAttack() {

        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        ui.mainTextArea.setText(" The Troll attacked and gave you " + monsterDamage + " damage!");

        player.hp = player.getHp() - monsterDamage;
        ui.hpNumberLabel.setText("" + player.getHp());

        ui.choice1.setText("Continue");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.getHp() > 0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (player.getHp() <= 0 ) {              // else if?
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    public void win () {

        ui.mainTextArea.setText("You've defeated the " + monster.name + "!\nThe creature dropped a small ring!\n\n(You pick up this small ring and pocket it)");

        silverRing = 1;

        ui.choice1.setText("Leave");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad2";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void lose () {

        ui.mainTextArea.setText("You have died!\n\n<GAME OVER>");

        ui.choice1.setText("Main Menu");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void ending () {

        ui.mainTextArea.setText("Guard: Oh you have found it! My wife was going to kill me for losing my wedding ring\nThank you so much Dwarf, welcome to our town!\n\nBy the way, I never learned your name?\n\n\n<THE END>");

        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }

    public void toTitle () {

        defaultSetup();
        tn.showTitleScreen();

    }

}
