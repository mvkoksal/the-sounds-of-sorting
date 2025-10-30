package edu.grinnell.csc207.soundsofsorting.sortevents;
import java.util.List;
import java.util.ArrayList;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {

    private int index1;
    private int index2;

    public CompareEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }
    
    public void apply(T[] arr) {

    }

    public List<Integer> getAffectedIndices() {
        List<Integer> indices = new ArrayList<>();
        indices.add(index1);
        indices.add(index2);
        return indices;
    }

    public boolean isEmphasized() {
        return false;
    }
}
