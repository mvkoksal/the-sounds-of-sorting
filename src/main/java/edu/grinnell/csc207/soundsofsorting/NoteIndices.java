package edu.grinnell.csc207.soundsofsorting;
import java.util.ArrayList;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    private Integer indices[];
    private boolean[] highlighted;

    /**
     * Initializes the fields of a NoteIndices object.
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        indices = new Integer[n];
        highlighted = new boolean[n];
        clearAllHighlighted();
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        // Initialize indices
        indices = new Integer[n];
        for (int i=0; i < n; i++) {
            indices[i] = i;
        }
        // Initialize highlighted
        highlighted = new boolean[n];
        clearAllHighlighted();

        // Shuffle
        for (int i = indices.length -1; i > 0; i--) {
            int randomIndex = (int)(Math.random() * (i+1));
            int temp = indices[i];
            indices[i] = indices[randomIndex];
            indices[randomIndex] = temp;
        }
    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return indices;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        highlighted[index] = true;
    }
    
    /**
     * Indicates whether the given index is highlighted
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        if (highlighted[index]) {
            return true;
        } else {
            return false;
        }
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int i=0; i < highlighted.length; i++){
            highlighted[i] = false;
        }
    }
}
