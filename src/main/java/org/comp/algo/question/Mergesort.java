package org.comp.algo.question;

import java.util.Arrays;

import org.junit.Test;

public class Mergesort {

    @Test
    public void mergeSortTest() {
        int[] arr=new int[] {2,3,5,1,4};
        int[] temp=new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void mergeSortTestOneElement() {
        int[] arr=new int[] {2};
        int[] temp=new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void mergeSortTestDecreasing() {
        int[] arr=new int[] {5,4,3,2,1};
        int[] temp=new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void mergeSortTestIncreasing() {
        int[] arr=new int[] {1,2,3,4,5};
        int[] temp=new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void insertIonSortTest() {
        int[] arr=new int[] {5,4,3,2,1};
        insertonSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void insertIonSortMergeTest() {
        int[] arr=new int[] {5,4,3,2,1,21,4,5,12,7,8,12,0,9,6,5,1,8,4,21,34,56,1,2};
        int[] temp=new int[arr.length];
        mergeSortWithInsertion(arr,temp,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void insertIonSortMergeTest2() {
        int[] arr=new int[] {5,4,3,2,1,21,4,5,12,-1,-2,7,8,12,0,9,6,5,1,8,4,21,34,56,1,2};
        int[] temp=new int[arr.length];
        mergeSortWithInsertion(arr,temp,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void insertIonSortWithIndex() {
        int[] arr=new int[] {5,4,3,2,1};
        insertonSort(arr,1, 3);
        System.out.println(Arrays.toString(arr));
    }
    
    public void insertonSort(int[] arr, int s, int e) {
        for(int i=s+1; i<=e; i++) {
            for(int j=i; j>s && arr[j] < arr[j-1]; j--) {
                int t=arr[j];
                arr[j] = arr[j-1];
                arr[j-1]=t;
            }
        }
    }
    
    public void mergeSort(int[] arr, int[] temp,int s, int e) {
        if(s==e) {
            return;
        }
        int m = s+(e-s)/2;
        mergeSort(arr, temp, s, m);
        mergeSort(arr, temp, m+1, e);
        merge(arr, temp, s, m, e);
    }
    
    public void mergeSortWithInsertion(int[] arr, int[] temp,int s, int e) {
        if(e-s < 5) {
            insertonSort(arr, s, e);
            return;
        }
        int m = s+(e-s)/2;
        mergeSort(arr, temp, s, m);
        mergeSort(arr, temp, m+1, e);
        merge(arr, temp, s, m, e);
    }

    public void merge(int[] arr, int[] temp, int s, int m, int e) {
        for(int i=s; i<=e; i++) {
            temp[i]=arr[i];
        }
        
        int j=m+1;
        int k=s;
        while(s<=m && j <= e) {
            if(temp[s] <= temp[j]) {
                arr[k++] = temp[s++];
            }else {
                arr[k++] = temp[j++];
            }            
        }
        while(s<=m) {
            arr[k++] = temp[s++];
        }
    }
}
