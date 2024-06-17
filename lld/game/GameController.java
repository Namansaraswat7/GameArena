package lld.game;

import lld.game.entity.Player;
import lld.game.service.ArenaService;
import lld.game.service.PlayerService;

public class GameController {
    public static void main(String[] args) {

        ArenaService gameArena = new ArenaService();

        Player p1 = new Player(1,"Goku",100,10,10);
        Player p2 = new Player(2,"Vgeta",100,10,10);
        Player p3 = new Player(3,"pickachu",120,12,15);

        PlayerService playerService = new PlayerService();

        playerService.addPlayer(p1);
        playerService.addPlayer(p2);
        playerService.addPlayer(p3);
        playerService.setPlayerAbilities(p3,110,12,16);

        gameArena.setPlayerService(playerService);

        Player p =  gameArena.playMatch(p1,p2);

        System.out.println( p.getName() + " has won the match");

   }

}
