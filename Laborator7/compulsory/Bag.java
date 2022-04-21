import java.util.*;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();

    public Bag() {
        Random random = new Random();
        for (char c = 'a'; c < 'z'; c++) {
            // add 10 new tiles with letter c to the collection
            int points = random.nextInt(10 - 1) + 1;
            for (int i = 0; i < 9; i++) {
                Tile tile = new Tile(c, points);
                letters.add(tile);
            }
        }
        //we shuffle the list of tiles
        Collections.shuffle(letters);
    }
    private Tile getTileByLetter(char letter){
        for(Tile tile : letters){
            if(tile.getLetter() == letter){
                return tile;
            }
        }
        return null;
    }
    public synchronized void removeTiles(String word){
        if(letters.size() < 7){
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            for(Tile letter : letters){
                if(letter.getLetter() == word.charAt(i)){
                    Tile temp = getTileByLetter(word.charAt(i));
                    letters.remove(temp);
                    break;
                }
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        Random random = new Random();
        if(letters.size() < 7){
            return null;
        }
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            //poll one tile from the collection
            Tile tile = letters.get(random.nextInt(0, letters.size()));
            extracted.add(tile);
        }
        return extracted;
    }

    public List<Tile> getLetters() {
        return letters;
    }
    public synchronized void extractToken(Player player) {
        while (!player.getTheirTurn()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(letters.isEmpty())
                return;
        }
        player.submitWord();

        player.setTheirTurn(false);
        player.getNextPlayer().setTheirTurn(true);
        notifyAll();
    }

    @Override
    public String toString() {
        return "Bag{" +
                "letters=" + letters +
                '}';
    }
}