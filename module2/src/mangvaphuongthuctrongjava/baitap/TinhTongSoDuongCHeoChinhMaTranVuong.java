package mangvaphuongthuctrongjava.baitap;

public class TinhTongSoDuongCHeoChinhMaTranVuong {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) Math.floor(Math.random() * 100);
            }
        }
        System.out.println("The matrix is: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i][i];
        }
        System.out.println("The total of main diagonal line in the matrix is "+total);
    }
}
