package lopvadoituongtrongjava.baitap.stopwatch;

import java.util.Arrays;
import java.util.Date;

public class DemoStopWatch {
    public static void main(String[] args) {
        StopWatch time = new StopWatch();
        time.start();
        //selection sort:
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round((Math.random() * 1000) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        time.end();
        System.out.println("Chương trình đã thực hiện: " + time.getElapsedTime());
    }
}
