import java.util.List;
import java.util.Scanner;

public class Player implements Runnable {
    private final String name;
    private Game game;
    private boolean theirTurn; //its his turn or not
    private Player nextPlayer;
    private int score;
    private boolean gameOver = false;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    private String createMockWord(List<Tile> extracted){
        StringBuilder word = new StringBuilder();
        for(Tile tile : extracted){
            word.append(tile.getLetter());
        }
        return word.toString();
    }
    public void computeScor(List<Tile> extracted){
        int sumPoints = 0;
        for(Tile letter : extracted){
            sumPoints += letter.getPoints();
        }
        sumPoints *= extracted.size();
        score += sumPoints;
    }
    public boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if(extracted == null){
            gameOver = true;
            return false;
        }
        if (extracted.isEmpty()) {
            return false;
        }
        // word with all the extracted tiles;
        String word = createMockWord(extracted);

        //word validation
        if(game.getDictionary().isWord(word)){
            game.getBoard().addWord(this, word);
            game.getBag().removeTiles(word);
            computeScor(extracted);
        }
        else{
            System.out.println("Wrong word.");
        }

        // make the player sleep 50ms;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    //getter
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    //setter
    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isTheirTurn() {
        return theirTurn;
    }

    public void setTheirTurn(boolean theirTurn) {
        this.theirTurn = theirTurn;
    }
    public boolean getTheirTurn() {
        return theirTurn;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    //implement the run method;
    @Override
    public void run() {
        List<Tile> letters = game.getBag().getLetters();
        while (!gameOver) {
            game.getBag().extractToken(this);
        }
    }
}