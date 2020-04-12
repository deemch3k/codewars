package ua.dima.challanges.kyu7;

/*
Create a function that returns the name of the winner in a fight between two fighters.

Each fighter takes turns attacking the other and whoever kills the other first is victorious.
Death is defined as having health <= 0.

Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.

Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0.
You can mutate the Fighter objects.

 */

public class Fighters {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        while (fighter1.health >= 0 || fighter2.health >= 0) {
            if (fighter1.name.equals(firstAttacker)) {
                fighter2.setHealth(fighter2.getHealth() - fighter1.getDamagePerAttack());
                if (fighter2.getHealth() <= 0) return fighter1.getName();
                fighter1.setHealth(fighter1.getHealth() - fighter2.getDamagePerAttack());
                if (fighter1.getHealth() <= 0) return fighter2.getName();
            } else {
                fighter1.setHealth(fighter1.getHealth() - fighter2.getDamagePerAttack());
                if (fighter1.getHealth() <= 0) return fighter2.getName();
                fighter2.setHealth(fighter2.getHealth() - fighter1.getDamagePerAttack());
                if (fighter2.getHealth() <= 0) return fighter1.getName();
            }
        }
        return null;
    }
}

 class Fighter {
    public String name;
    public int health, damagePerAttack;
    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

     public int getDamagePerAttack() {
         return damagePerAttack;
     }
 }

