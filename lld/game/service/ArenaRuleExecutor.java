package lld.game.service;

import lld.game.entity.Player;
import lld.game.exception.ArenaException;
import lld.game.gamestrategy.AttackStrategy;
import lld.game.gamestrategy.DefendStrategy;
import lld.game.gamestrategy.PlayStrategy;

import java.util.Objects;
import java.util.Random;

public class ArenaRuleExecutor {
    private Random random = new Random();

    private static int MAX_DICE_VALUE = 6;

    private PlayStrategy attack = new AttackStrategy();

    private PlayStrategy defend = new DefendStrategy();


    public void isValidMatch(Player p1, Player p2) {

        if(Objects.isNull(p1) || Objects.isNull(p2) || Objects.equals(p1,p2)) {
            throw new ArenaException("Players present in arena are either null or equal, hence Match can not be started");
        }

        if(p1.getHealth() == 0 || p1.getStrength() == 0 || p1.getAttack() == 0 || p2.getHealth() == 0 || p2.getStrength() == 0 || p2.getAttack() == 0) {
            throw new ArenaException("Match cannot be started because either P1 or P2 has one of its attributes set to 0");
        }

        if(p1.getAttack() * MAX_DICE_VALUE < p2.getStrength() && p2.getAttack() * MAX_DICE_VALUE < p1.getStrength()) {
            throw new ArenaException("Match is not going to end as attack and strength of each player is not in correct state");
        }

    }
    public int toss(){
        return random.nextInt(2);
    }

    public PlayStrategy getAttack() {
        return attack;
    }

    public PlayStrategy getDefend() {
        return defend;
    }

    public Player play(Player p1, Player p2, PlayerService playerService) {

        Player tossWinner = this.toss() == 1 ? p1 : p2;

        Player firstPlayer = tossWinner;
        playerService.updateTurnStatus(firstPlayer,true);
        Player secondPlayer = tossWinner == p1 ? p2 : p1;

        while(firstPlayer.getHealth() > 0 && secondPlayer.getHealth() > 0) {

            int healthDamage = -1;
            int attack = 0;
            int defend = 0;

            if(playerService.getPlayerTurnStatus(firstPlayer)) {

                attack = this.getAttack().play(firstPlayer);
                defend = this.getDefend().play(secondPlayer);

                healthDamage = attack - defend;
                if(healthDamage > 0)
                    playerService.updateHealth(secondPlayer,healthDamage);

                playerService.updateTurnStatus(firstPlayer,false);
                playerService.updateTurnStatus(secondPlayer,true);

            }

            else {

                attack = this.getAttack().play(secondPlayer);
                defend = this.getDefend().play(firstPlayer);
                healthDamage = attack - defend;
                if(healthDamage > 0)
                    playerService.updateHealth(firstPlayer,healthDamage);
                playerService.updateTurnStatus(firstPlayer,true);
                playerService.updateTurnStatus(secondPlayer,false);

            }
        }

        if(firstPlayer .getHealth() <= 0)
            return secondPlayer;
        else
            return firstPlayer;
    }
}
