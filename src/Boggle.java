import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boggle {
    private static Boolean[][] searched;
    private static Trie words;

    public static String[] findWords(char[][] board, String[] dictionary) {
        ArrayList<String> goodWords = new ArrayList<String>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Create a boolean array that holds the information of whether a spot has been searched
        // Sort all dictionary words into a Trie
        searched = new Boolean[board.length][board[0].length];
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
        if(searched[row][col]) {
            return;
        }
        if(!words.lookup(prefix)) {
            return;
        }
        searched[row][col] = true;

        String nextPrefix = prefix + board[row][col];
        dfs(row + 1, col, nextPrefix, board);
        dfs(row - 1, col, nextPrefix, board);
        dfs(row, col + 1, nextPrefix, board);
        dfs(row, col - 1, nextPrefix, board);

        searched[row][col] = false;
    }
}
