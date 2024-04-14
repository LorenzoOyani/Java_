//
//import java.util.Arrays;
//import java.util.Scanner;
//
//import static java.lang.System.in;
//
//public static int[] slide(int k, int[] arr) {
//    int[] result = new int[arr.length - k + 1];
//    int sumWindow = 0;
//    int end = 0;
//    int start = 0;
//    for (; end <= arr.length - k; end++ ) {
//        sumWindow += arr[end];
//
//        while (end >= k - 1) {
//            result[start] = sumWindow / k;
//            sumWindow -= arr[end];
//            end++;
//            start++;
//        }
//    }
//    return result;
//
//
//}
//public static class SlidingWindow {
//
//
//public void main() {
//    Scanner sc = new Scanner(in);
//    System.out.println("Enter an integer value(exit with 0): ");
//    int value;
//    while (true) {
//        value = sc.nextInt();
//        if (value == 0) {
//            break;
//        }
//        int k = 8;
//        int[] array = new int[value];
//       int[] resultantArray =  slide(k, array);
//        System.out.println(STR."The value of the averages is \{Arrays.toString(resultantArray)}");
//    }
//}
//}
//
//public void main() {
//}
//
//
