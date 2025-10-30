package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private int index1;
    private int index2;

    public SwapEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }
    
    public void apply(T[] arr) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> indices = new ArrayList<>();
        indices.add(index1);
        indices.add(index2);
        return indices;
    }

    public boolean isEmphasized() {
        return true;
    }
}
