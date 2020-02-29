package compang.cases;

import compang.Cases;
import compang.annotations.Benchmark;
import compang.annotations.Measurement;
import compang.annotations.Warmup;

import java.util.Arrays;
import java.util.Random;

@Measurement(iterations = 10,group = 3)
public class Sortcases implements Cases {

        public static void quicksort(int[] arr){
            int low = 0;
            int high = arr.length-1;
            if(arr.length<1) return;
            else quicksort(arr,low,high);
        }

        private  static  int partition(int[] arr,int l,int r){
            int randomIndex=(int)(Math.random()*(r-l+1)+l);
            swap(arr,l,randomIndex);
            int pivot=arr[l];
            int i=l+1;
            int j=r;
            while (true){
                while(i<=r&&arr[i]<pivot) i++;
                while (j>=l+1&&arr[j]>pivot) j--;
                if(i>j) break;
                swap(arr,i,j);
                i++;
                j--;
            }
            swap(arr,l,j);
            return j;
        }

    private static void quicksort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition(arr, low, high);
        quicksort(arr, low, q - 1);
        quicksort(arr, q + 1, high);
    }

        private static void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

      /*  private static void print(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+"\t");
            }
        }*/


        @Benchmark
        @Warmup(iterations = 200)
    public static void testQuickSort(){
            int[] a=new int[100000];
            Random random=new Random(20190727);
            for(int i=0;i<a.length;i++){
                a[i]=random.nextInt(10000);
            }
            quicksort(a);
        }
        @Benchmark
    public static void testArraysSort(){
        int[] a=new int[100000];
        Random random=new Random(20190727);
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(10000);
        }
       Arrays.sort(a);
    }
    }


