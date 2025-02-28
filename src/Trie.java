import java.util.Arrays;

public class Trie {
    private Node root;

    public Trie() {
        // Creates new root to search
        root = new Node();
    }

    void insert(String s) {
        // Starts the process at the root node
        Node current = root;
        // Creates for loop to work through word
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i);
            // Creates new node if node for the correct letter doesn't exist
            if(current.next[j] == null) {
                current.next[j] = new Node();
            }
            // Changes the current to the next Node
            current = current.next[j];
        }
        // Sets the word to true once it's over
        current.setWord(true);
    }

    // Searches through trie to see if given word is already there
    boolean lookup (String s) {
        // Starts at root
        Node current = root;
        // Creates for loop to search through every letter in word
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i);
            // Returns false if the next letter isn't in the trie because the word isn't in the tree
            if(current.next[j] == null) {
                return false;
            }
            // Moves onto the next letter
            current = current.next[j];
        }
        return current.isWord();
    }

    // Method checks to see if the prefix exists in the trie; uses similar algorithm to lookup()
    boolean lookup2 (String s) {
        Node current = root;
        for(int i = 0; i < s.length(); i++) {
            int j = s.charAt(i);
            if(current.next[j] == null) {
                return false;
            }
            current = current.next[j];
        }
        return true;
    }
    // Prints out trie for debugging purposes
    void printTrie () {
        System.out.println(Arrays.toString(root.getNext()));
    }
}
