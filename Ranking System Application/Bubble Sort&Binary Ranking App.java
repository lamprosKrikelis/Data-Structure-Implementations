
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
// import java.util.Arrays;

public class work {
       public static class BubbleSort {
            public static void bubbleSort(int[] arr)
            {
                Random rb= new Random();
                for(int k =0 ; k < arr.length; k++){
                    arr[k]= rb.nextInt(100);
                }

                int n = arr.length;
                for (int i = 0; i < n - 1; i++)
                    for (int j = 0; j < n - i - 1; j++)
                        if (arr[j] > arr[j + 1]) {
                            // swap arr[j+1] and arr[j]
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
            }

            /* Prints the array */
            void printArray(int[] arr)
            {
                for (int j : arr)
                    System.out.print(j + " ");
                System.out.println();
            }

             //@SuppressWarnings("unused")
             static void Pass(int[] pass){
                //int[] Pass = new int [100];

                 for(int k =0 ; k < 100; k++){
                     pass[k] = k;
                     System.out.print(pass[k] + " ");
                 }
                 System.out.println();
            }

           static void User(int[] arr){
               Scanner scan = new Scanner(System.in);
               if (scan.hasNextInt()) {
                   int password = scan.nextInt();
                   if (password >= 0 && password < 100) {
                       System.out.println("your key word is: " + password +
                               " and your current rank is: " + arr[password]);
                   } else{
                       System.out.println("Please enter a key word  ");
                   }
               }else{
                   System.out.println("Please enter a key word  ");
               }
           }

            // Driver method to test above
            public static void main(String[] args)
            {
                BubbleSort ob = new BubbleSort();
                int[] arr =new int[100] ;
                int[] pass = new int[100];

                bubbleSort(arr);
                //System.out.println("Sorted array");
                System.out.println("The employees rank using random function ");
                ob.printArray(arr);

                System.out.print(" \n ");

                //System.out.println("Ranking system for 100 employees ");
                Pass(pass);

                System.out.println("Please enter your key word");
                User(arr);

            }
       }
}

