    package lld.game.service;

    import lld.game.entity.Player;
    import lld.game.exception.ArenaException;

    import java.util.Objects;

    public class ArenaService {

        ArenaRuleExecutor arenaRuleExecutor = new ArenaRuleExecutor();

        PlayerService playerService = null;

        public ArenaService() {
            this.playerService = new PlayerService();
        }

        public PlayerService getPlayerService() {
            return playerService;
        }

        public void setPlayerService(PlayerService playerService) {
            this.playerService = playerService;
        }

        public Player playMatch(Player p1, Player p2) {

            arenaRuleExecutor.isValidMatch(p1,p2);

            return arenaRuleExecutor.play(p1,p2, playerService);

        }
    }
