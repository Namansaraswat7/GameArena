package lld.game.gamestrategy;

import lld.game.entity.Player;

import java.util.Random;

public class DefendStrategy implements PlayStrategy {

    private Random random = new Random();

    @Override
    public int play(Player p) {
        int diceRollValue = this.random.nextInt(6) + 1;

        int defend = p.getStrength();
        int finalDefend = defend*diceRollValue;

        return finalDefend;
    }
}
