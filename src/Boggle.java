import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boggle {
    private static Boolean[][] searched;
    private static Trie words;
    private static ArrayList<String> goodWords;

    public static String[] findWords(char[][] board, String[] dictionary) {
        goodWords = new ArrayList<>();
        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Create a boolean array that holds the information of whether a spot has been searched
        // Sort all dictionary words into a Trie
        searched = new Boolean[board.length][board[0].length];
        for(int i = 0; i < searched.length; i++) {
            for(int j = 0; j < searched[0].length; j++) {
                searched[i][j] = false;
            }
        }

        words = new Trie();
        for(int i = 0; i < dictionary.length; i++) {
            words.insert(dictionary[i]);
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

    public static void dfs (int row, int col, String prefix, char[][] board) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        if(searched[row][col]) {
            return;
        }
        // How to check if prefix is valid?
        if(!words.lookup2(prefix)) {
            return;
        }

        searched[row][col] = true;

        String nextPrefix = prefix + board[row][col];
        dfs(row + 1, col, nextPrefix, board);
        dfs(row - 1, col, nextPrefix, board);
        dfs(row, col + 1, nextPrefix, board);
        dfs(row, col - 1, nextPrefix, board);

        if(!goodWords.contains(prefix)) {
            goodWords.add(prefix);
        }
        searched[row][col] = false;
    }
}
