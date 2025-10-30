package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    // Bubble Sort Tests
    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }

     @Test
    public void BubbleSort_generic() {
        Integer[] arr = {5, 2, 4, 6, 1, 3};
        List<SortEvent<Integer>> events = Sorts.bubbleSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void BubbleSort_sortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<SortEvent<Integer>> events = Sorts.bubbleSort(arr);
        assertTrue(sorted(arr));
        
        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void BubbleSort_duplicates() {
        Integer[] arr = {3, 1, 2, 3, 2};
        List<SortEvent<Integer>> events = Sorts.bubbleSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void BubbleSort_singleElement() {
        Integer[] arr = {7};
        List<SortEvent<Integer>> events = Sorts.bubbleSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }
    
    // Insertion Sort Tests
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }

    @Test
    public void InsertionSort_generic() {
        Integer[] arr = {5, 2, 4, 6, 1, 3};
        List<SortEvent<Integer>> events = Sorts.insertionSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void InsertionSort_sortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<SortEvent<Integer>> events = Sorts.insertionSort(arr);
        assertTrue(sorted(arr));
        
        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void InsertionSort_duplicates() {
        Integer[] arr = {3, 1, 2, 3, 2};
        List<SortEvent<Integer>> events = Sorts.insertionSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void InsertionSort_singleElement() {
        Integer[] arr = {7};
        List<SortEvent<Integer>> events = Sorts.insertionSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }
    
    // Selection Sort Tests
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void SelectionSort_generic() {
        Integer[] arr = {5, 2, 4, 6, 1, 3};
        List<SortEvent<Integer>> events = Sorts.selectionSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void SelectionSort_sortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<SortEvent<Integer>> events = Sorts.selectionSort(arr);
        assertTrue(sorted(arr));
        
        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void SelectionSort_duplicates() {
        Integer[] arr = {3, 1, 2, 3, 2};
        List<SortEvent<Integer>> events = Sorts.selectionSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void SelectionSort_singleElement() {
        Integer[] arr = {7};
        List<SortEvent<Integer>> events = Sorts.selectionSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    // Merge Sort Tests
    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }

    @Test
    public void MergeSort_generic() {
        Integer[] arr = {5, 2, 4, 6, 1, 3};
        List<SortEvent<Integer>> events = Sorts.mergeSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void MergeSort_sortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<SortEvent<Integer>> events = Sorts.mergeSort(arr);
        assertTrue(sorted(arr));
        
        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void MergeSort_duplicates() {
        Integer[] arr = {3, 1, 2, 3, 2};
        List<SortEvent<Integer>> events = Sorts.mergeSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void MergeSort_singleElement() {
        Integer[] arr = {7};
        List<SortEvent<Integer>> events = Sorts.mergeSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }
    
    // Quick Sort Tests
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }
    
    @Test
    public void QuickSort_generic() {
        Integer[] arr = {5, 2, 4, 6, 1, 3};
        List<SortEvent<Integer>> events = Sorts.quickSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void QuickSort_sortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<SortEvent<Integer>> events = Sorts.quickSort(arr);
        assertTrue(sorted(arr));
        
        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void QuickSort_duplicates() {
        Integer[] arr = {3, 1, 2, 3, 2};
        List<SortEvent<Integer>> events = Sorts.quickSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void QuickSort_singleElement() {
        Integer[] arr = {7};
        List<SortEvent<Integer>> events = Sorts.quickSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }
    
    // Gnome Sort Tests
    @Test
    public void testGnomeSort() {
        testSort(Sorts::gnomeSort);
    }
    
    @Test
    public void GnomeSort_generic() {
        Integer[] arr = {5, 2, 4, 6, 1, 3};
        List<SortEvent<Integer>> events = Sorts.gnomeSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void GnomeSort_sortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<SortEvent<Integer>> events = Sorts.gnomeSort(arr);
        assertTrue(sorted(arr));
        
        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void GnomeSort_duplicates() {
        Integer[] arr = {3, 1, 2, 3, 2};
        List<SortEvent<Integer>> events = Sorts.gnomeSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }

    @Test
    public void GnomeSort_singleElement() {
        Integer[] arr = {7};
        List<SortEvent<Integer>> events = Sorts.gnomeSort(arr);
        assertTrue(sorted(arr));

        Integer[] eventArray = Arrays.copyOf(arr, arr.length);
        Sorts.eventSort(eventArray, events);
        assertTrue(sorted(eventArray));
    }
}