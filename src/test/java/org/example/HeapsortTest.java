package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapsortTest {

    // Test Arrays
    int[] shortHeapKaputt = { 14,16,8,10,7,9,3,2,4,1};
    int[] shortHeapKorrekt = { 16,14,10,8,7,9,3,2,4,1 };
    int[] longHeapRandom = { 100,123,124,515,543,634,7634,643,634,98,65,154,684,32,346,439,8,7,6,5,4,3,2,1 };
    int[] longHeapBestCase = { 7634,684,154,543,643,123,124,439,515,634,98,100,3,1,7,346,8,4,32,634,65,5,2,6 };

    //sortierte Arrays
    int[] sorteadHeapLong = { 1,2,3,4,5,6,7,8,32,65,98,100,123,124,154,346,439,515,543,634,634,643,684,7634};
    int[] sortedHeapShort = { 1,2,3,4,7,8,9,10,14,16 };

    Heapsort h;

    @BeforeEach
    void setUp() {
        h = new Heapsort();
    }
    @Test
    void heapSortKaputterHeap() {
        assertArrayEquals(sortedHeapShort,h.HeapSort(shortHeapKaputt.clone()));
    }
    @Test
    void heapSortKorrekterHeap() {
        assertArrayEquals(sortedHeapShort,h.HeapSort(shortHeapKorrekt.clone()));
    }
    @Test
    void heapSortLong() {
        assertArrayEquals(sorteadHeapLong,h.HeapSort(longHeapRandom.clone()));
    }
    @Test
    void heapSortLongBestCase() {
        assertArrayEquals(sorteadHeapLong,h.HeapSort(longHeapBestCase.clone()));
    }
    @Test
    void buildHeapKorrekterHeap() {
        assertArrayEquals(shortHeapKorrekt, h.BuildHeap(shortHeapKorrekt.clone()));
    }
    @Test
    void buildHeapNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {h.BuildHeap(null);
                });
    }
    @Test
    void buildHeapKaputterHeap() {
        int[] shortHeapBuildHeapResult = {16, 14, 9, 10, 7, 8, 3, 2, 4, 1};
        assertArrayEquals(shortHeapBuildHeapResult, h.BuildHeap(shortHeapKaputt.clone()));
    }
    @Test
    void heapify() {
        int[] shortHeapHeapifyResult = {16, 14, 8, 10, 7, 9, 3, 2, 4, 1};
        assertArrayEquals(shortHeapHeapifyResult, h.Heapify(shortHeapKaputt.clone(), 0, shortHeapKaputt.length - 1));
    }
}