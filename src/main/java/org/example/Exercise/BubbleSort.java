package org.example.Exercise;

public class BubbleSort {
    public void bubbleSort(int[] list) {
        boolean swapped = false;
        int n = list.length;
        for (int  i = 1; i < list.length; i++) {
            for (int  j = 0; j < n-i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

    }
    void main() {
        int[] listOfValues = new int[]{2, 4 ,5, 7,8,9,3,2,0};
        System.out.println("The array before sorting");
        for (int i = 0; i < listOfValues.length; i++) {
            System.out.println("index at "+ i + " :" + listOfValues[i]);

        }
        bubbleSort(listOfValues);
        System.out.println("after soring..");
        for (int j = 0; j < listOfValues.length; j++) {
            System.out.println("index at "+ j + ": " + listOfValues[j]);
        }
    }
}
