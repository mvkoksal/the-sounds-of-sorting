package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private int index1;
    private int index2;

    /**
     * Initializes the fields of a SwapEvent
     * @param index1 the first index into the array
     * @param index2 the second index into the array
     */
    public SwapEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }
    
    /**
     * Swaps the values in the two indices of the array
     * @param arr the array being modified
     */
    public void apply(T[] arr) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * Returns the indices affected by this SwapEvent
     * @return a list of the two indices we swapped the values of
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> indices = new ArrayList<>();
        indices.add(index1);
        indices.add(index2);
        return indices;
    }

    /**
     * Indicate whether this event is emphasized.
     * @return true, SwapEvents are emphasized.
     */
    public boolean isEmphasized() {
        return true;
    }
}
