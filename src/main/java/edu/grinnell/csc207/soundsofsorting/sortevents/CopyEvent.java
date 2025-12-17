package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    private T value;
    private int target_index;

    /**
     * Initializes fields of this CopyEvent
     * @param value the value being copied
     * @param target_index the index being copied into
     */
    public CopyEvent(T value, int target_index) {
        this.value = value;
        this.target_index = target_index;
    }

    /**
     * Copies the value field into the target index.
     * @param arr the array being modified
     */
    public void apply(T[] arr) {
        arr[target_index] = value;
    }

    /**
     * Returns the indices affected by this CopyEvent
     * @return a list of the index copied into
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> indices = new ArrayList<>();
        indices.add(target_index);
        return indices;
    }

    /**
     * Indicate whether this event is emphasized.
     * @return true, CopyEvents are emphasized.
     */
    public boolean isEmphasized() {
        return true;
    }
}
