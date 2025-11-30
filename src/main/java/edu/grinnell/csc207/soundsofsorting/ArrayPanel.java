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

    @Override
    public void paintComponent(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        // Clear panel
        g.clearRect(0, 0, width, height);

        Integer[] indices = notes.getNotes();
        int notesLength = indices.length;

        // Get the width of each rectangle so they fit in the panel
        int rectWidth = width / notesLength;

        // Draw each rectangle one by one
        for (int j = 0; j < notesLength; j++) {
            int x = j * rectWidth;
            int y = height - indices[j]; // drawing from top to bottom

            // Change color if the index is highlighted
            if (notes.isHighlighted(j)) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fill3DRect(x, y, rectWidth, indices[j], false);
        }
    }
}