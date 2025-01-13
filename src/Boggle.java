import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boggle {
    private static Boolean[][] searched;
    private static Trie words;
    private static ArrayList<String> goodWords;
    private static String currentWord;

    public static String[] findWords(char[][] board, String[] dictionary) {
        goodWords = new ArrayList<>();

        // Creates array the same size as board to track whether the spot has been searched and fills with false
        searched = new Boolean[board.length][board[0].length];
        for(int i = 0; i < searched.length; i++) {
            for(int j = 0; j < searched[0].length; j++) {
                searched[i][j] = false;
            }
        }

        // Adds all words in the dictionary into a trie
        words = new Trie();
        for(String word: dictionary) {
            words.insert(word);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(i, j, "", board);
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    // Does depth first search to find all words that appear in the board and dictionary
    public static void dfs (int row, int col, String prefix, char[][] board) {
        // Makes sure spot is valid and on the board
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        // Makes sure spot has not been searched
        if(searched[row][col]) {
            return;
        }

        // Makes sure prefix leads to words
        if(!words.lookup2(prefix)) {
            return;
        }

        searched[row][col] = true;
        // Adds word to list of good words if the word is not already in the list and if the word is a valid word in
        // the dictionary
        if(!goodWords.contains(prefix) && words.lookup(prefix)) {
            goodWords.add(prefix);
        }

        // Recurses for al nearby spots
        String nextPrefix = prefix + board[row][col];
        dfs(row + 1, col, nextPrefix, board);
        dfs(row - 1, col, nextPrefix, board);
        dfs(row, col + 1, nextPrefix, board);
        dfs(row, col - 1, nextPrefix, board);

        // Sets spot to false so it can be searched later
        searched[row][col] = false;
    }
}
