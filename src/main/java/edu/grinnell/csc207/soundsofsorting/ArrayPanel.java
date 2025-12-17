package edu.grinnell.csc207.soundsofsorting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }
    
    /**
     * Draws a rectangle for each element in the array being sorted
     * @param g the screen to draw on
     */
    @Override
    public void paintComponent(Graphics g) {

        int width = getWidth();
        int height = getHeight();
        // Clear panel
        g.clearRect(0, 0, width, height);

        Integer[] indices = notes.getNotes();
        int notesLength = indices.length;

        // Get the width of each rectangle so they fit in the panel
        int rectWidth = width / notesLength;

        // Find the max value
        int max = indices[0];

        for (int i = 1; i < notesLength; i++) {
            if (indices[i] > max) {
                max = indices[i];
            }
        }

        // Draw each rectangle one by one
        for (int i = 0; i < notesLength; i++) {
            int rectHeight = 0;
            if (max != 0) {
                // Fit the rectangle to the screen
                rectHeight = (int) (((double) indices[i]/ (double) max) * height);
            }

            int x = i * rectWidth;
            int y = height - rectHeight; // drawing from top to bottom

            // Change color if the index is highlighted
            if (notes.isHighlighted(i)) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.CYAN);
            }

            // Draw rectangle
            g.fillRect(x, y, rectWidth, rectHeight);
        }
    }
}