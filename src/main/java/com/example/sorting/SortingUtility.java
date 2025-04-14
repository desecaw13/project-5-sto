package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] data) {
        int i = 0;
        while (i < data.length) {
            if (i == 0 || data[i].compareTo(data[i - 1]) >= 0) {
                i++;
            } else {
                swap(data, i, i - 1);
                i--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = data.length - 2; i > 0; i--) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }


    public static <T extends Comparable<T>> void shellSort(T[] data) {
        int[] gaps = {488, 187, 72, 27, 10, 4, 1}; // Skean-Ehrenborg-Jaromczyk gaps

        for (int gap : gaps) {
            for (int i = gap; i < data.length; i += 1) {
                T hold = data[i];
                int j;
                for (j = i; (j >= gap) && (data[j - gap].compareTo(hold) > 0); j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = hold;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}
