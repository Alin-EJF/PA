import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        if (players.isEmpty()) {
            player.setNextPlayer(player);
            player.setTheirTurn(true);
        } else {
            player.setTheirTurn(false);
            player.setNextPlayer(players.get(0));
            players.get(players.size() - 1).setNextPlayer(player);
        }

        players.add(player);
        player.setGame(this);
    }

    //starts the game, using a separate thread for each player.
    public void play() {
        List<Thread> threads = new ArrayList<>();
        for (Player player : players) {
            threads.add(new Thread(player, player.getName()));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    //getter
    public Board getBoard() {
        return board;
    }

    public Bag getBag() {
        return bag;
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));

        System.out.println(game.getBag().getLetters());
        game.play();
        game.printScores();
    }



    public Map<Player, Integer> getScores() {
        Map<Player, Integer> scores = new LinkedHashMap<>();
        players.forEach(player -> scores.put(player, player.getScore()));
        return scores;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void printScores() {
        System.out.println("Scores:");
        var scores = getScores();
        for (var entry : scores.entrySet())
            System.out.println(entry.getKey().getName() + ": " + entry.getValue() + " points");

        players.sort((o1, o2) -> Integer.compare(scores.get(o2), scores.get(o1)));

        System.out.println("-------------------\n The winner is: " +
                (scores.get(players.get(0)).equals(scores.get(players.get(1))) ? "tie" : players.get(0).getName()));
    }

}
