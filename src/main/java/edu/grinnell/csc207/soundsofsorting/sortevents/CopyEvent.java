package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    private T value;
    private int target_index;

    public CopyEvent(T value, int target_index) {
        this.value = value;
        this.target_index = target_index;
    }
    
    public void apply(T[] arr) {
        arr[target_index] = value;
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> indices = new ArrayList<>();
        indices.add(target_index);
        return indices;
    }

    public boolean isEmphasized() {
        return true;
    }
}
