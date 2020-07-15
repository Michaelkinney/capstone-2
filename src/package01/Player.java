package package01;

import package02.SuperWeapon;

public class Player {

    public int hp;                        // make private     attempted encapsulation
    public SuperWeapon currentWeapon;     // ^^^              could not fully implement

    public int getHp() {
        return hp;
    }

    public void setHp(int newHp) {
        this.hp = newHp;
    }

    public SuperWeapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(SuperWeapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }
}
