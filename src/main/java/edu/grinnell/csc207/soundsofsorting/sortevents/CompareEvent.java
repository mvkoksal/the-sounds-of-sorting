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
    
    /**
     * Initializes fields of a CompareEvent
     * @param index1 first index into the array
     * @param index2 second index into the array
     */
    public CompareEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }
    
    /**
     * Does nothing, since it just records comparison
     */
    public void apply(T[] arr) {
    }

    /**
     * Returns the indices affected by this CompareEvent
     * @return a list of the two indices compared
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> indices = new ArrayList<>();
        indices.add(index1);
        indices.add(index2);
        return indices;
    }

    /**
     * Indicate whether this event is emphasized.
     * @return false, CompareEvents are not emphasized.
     */
    public boolean isEmphasized() {
        return false;
    }
}
