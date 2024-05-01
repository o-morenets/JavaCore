package stackOverflow.ticTacToe;

import java.util.ArrayList;

/**
 * класс манипулятор игроков
 */
public class PlayerManager {
    ArrayList<Player> players;

    PlayerManager() {
        players = new ArrayList<>();
    }

    void addPlayer(String name) {
        Player player = new Player(name);
        players.add(player);
    }

    Player getFirstPlayer() {
        return players.get(0);
    }

    Player getSecondPlayer() {
        return players.get(1);
    }
}
