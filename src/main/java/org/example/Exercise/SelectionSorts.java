package org.example.Exercise;


public class SelectionSorts {
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int smallestValue = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[smallestValue]) {
                    smallestValue = j;
                }
            }
            int temp;
            if (smallestValue != i) {
                temp = list[smallestValue];
                list[smallestValue] = list[i];
                list[i] = temp;
            }
        }

    }

    void main() {
        int[] listOfValues = new int[]{2, 4, 5, 7, 8, 9, 3, 2, 0};
        System.out.println("The array before sorting");
        for (int i = 0; i < listOfValues.length; i++) {
            System.out.println(STR."index at \{i} :\{listOfValues[i]}");

        }
        selectionSort(listOfValues);
        System.out.println("after soring..");
        for (int j = 0; j < listOfValues.length; j++) {
            System.out.println(STR."index at \{j}: \{listOfValues[j]}");
        }
    }
}
