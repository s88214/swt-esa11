package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Heapsort {
    /**
     * Heapsort sortiert ein Array A nach dem Heapsort-Sortieralgorithmus. Das Ergbeniss ist ein aufsteigend sortiertes Array.
     *
     * @param A Array das sortiert werden soll.
     * @return Gibt sortiertes Array zurück
     */
    public int[] HeapSort(int[] A) {
        //Baue gegebenes Array um, welches Heap Eigenschaften hat.
        A = BuildHeap(A);
        int lastIndex = A.length-1;
        for (int i = lastIndex; i > 0; i--) {
            //Austausch (A[0], A[i]
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            //Reduziere Länge von A um 1
            lastIndex--;

            //Heapify(A,0)
            A = Heapify(A, 0, lastIndex);
        }
        return A;
    }

    /**
     * Ordnet die werte des Arrays zu einem Heap
     *
     * @param A Array mit oder ohne Heap-Eigenschaften
     * @return Array A mit Heap-Eigenschaften
     */
    public int[] BuildHeap(int[] A) {
        if (A == null)
            throw new IllegalArgumentException("Array is null");
        //suche das Blatt mit dem kleinsten Index
        int k = (A.length-1) / 2 + 1;

        //führe heapify auf allen Blätter aus
        for (int i = k-1; i >= 0; i--) {
            A = Heapify(A,i, A.length-1);
        }
        return A;
    }

    /**
     * Stellt Heap-Eigenschafte für Teilbaum mit Index i her
     *
     * @param A komplettes Array
     * @param i Index des Teilbaums dessen Heap-Eigenschaften wiederhergestellt werden sollen
     * @param lastIndex letzter Index von A. Dieser Parameter wird benötigt, um sich die neu erstellen / teilkopieren eines Arrays zu sparen.
     * @return Array mit wiederhegestellten Heap-Eigenschaften in Teilbaum mit Index i.
     */
    public int[] Heapify(int[] A, int i, int lastIndex) {
        int largest = i;
        int ln = 2*(i+1)-1;
        int rn = 2*(i+1);
        //prüfe ob nachfolger von i existiert und wähle den größeren
        if ( rn <= lastIndex && A[rn] > A[largest] )
            largest = rn;

        if (ln <= lastIndex && A[ln] > A[largest])
            largest = ln;

        if (A[largest] > A[i]) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            Heapify(A,largest,lastIndex);
        }
        return A;
    }
}
