package lld.game.gamestrategy;

import lld.game.entity.Player;

import java.util.Random;

public class AttackStrategy implements PlayStrategy{

    private Random random = new Random();

    @Override
    public int play(Player p) {
        int diceRollValue = this.random.nextInt(6) + 1;
        int attack = p.getAttack();

        int finalAttack = attack*diceRollValue;

        return finalAttack;
    }
}
