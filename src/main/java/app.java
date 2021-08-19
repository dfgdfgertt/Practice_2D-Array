import java.sql.Array;
import java.util.Random;
import java.util.Scanner;

public class app {

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] main) {
        int[][] arr = generatedArrays();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        //Bai 1
        findNumInArrays(arr);

        //Bai 2
        System.out.println("Mảng có phải mảng toàn các số nguyên tố: " + verifyPrimeArrays(arr));

        //Bai 3
        System.out.println("Mảng có lớn nhất là: " + findMax(arr));

        //Bai 4
        //a
        sumColumAndRow(arr);

        //b
        System.out.println("Tổng đường chéo chính: " + sumMainCross(arr));
        System.out.println("Tổng đường chéo phụ: " + sumSubCross(arr));

        //c
        System.out.println("Tổng nửa trên đường chéo chính: " + sumAboveMainCross(arr));
        System.out.println("Tổng nửa dưới đường chéo chính: " + sumBelowMainCross(arr));

        //d
        System.out.println("Tổng nửa trên đường chéo phụ: " + sumAboveSubCross(arr));
        System.out.println("Tổng nửa dưới đường chéo phụ: " + sumBelowSubCross(arr));
    }

    // Tạo mảng
    public static int[][] generatedArrays(){
        Random random = new Random();
        int m = random.nextInt(4) + 3, n = m;
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(9);
            }
        }
        return arr;
    }

    // nhập số bài 1
    public static void findNumInArrays(int[][] arr){
        System.out.print("Tìm 1 số\nNhập 1 số dương: ");
        int x = input.nextInt();
        System.out.print("Số có tồn tại trong mảng: " +  find(x,arr));

    }

    // Tìm số
    public static boolean find(int x, int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (x == arr[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // check prime
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // check mảng prime
    public static boolean verifyPrimeArrays(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!isPrimeNumber(arr[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // tim max
    public static int findMax(int[][] arr){
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max)
                    max = arr[i][j];
            }
        }
        return max;
    }

    // nhap dong va cot
    public static void sumColumAndRow(int[][] arr){
        int d =-1 ,c =-1;
        do {
            System.out.print("Nhập dòng (0-" +(arr.length-1) +"): ");
            d = input.nextInt();
        }while (d < 0 || d >= arr.length);
        do {
            System.out.print("Nhập cột (0-" +(arr[d].length-1) +"): ");
            c = input.nextInt();
        }while (c < 0 || c >= arr[d].length);
        System.out.print("Tổng là: " + sum(arr,c,d));
    }

    //sum dong d, cot c
    public static int sum(int[][] arr, int c, int d){
        int sum=0;
        for (int i = 0; i < arr[d].length; i++) {
            sum+= arr[d][i];
        }
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j][c];
        }
        return sum- arr[d][c];
    }

    // cộng đường chéo chính
    public static int sumMainCross(int[][] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ( i == j)
                    sum += arr[i][j];
            }
        }
        return sum;
    }

    // cộng đường chéo phụ
    public static int sumSubCross(int[][] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ( (i+j) == (arr.length-1))
                    sum += arr[i][j];
            }
        }
        return sum;
    }

    // cộng phía trên đường chéo chính
    public static int sumAboveMainCross(int[][] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr[i].length; j++) {
                    sum += arr[i][j];
            }
        }
        return sum;
    }

    // cộng phía dưới đường chéo chính
    public static int sumBelowMainCross(int[][] arr){
        int sum=0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    // cộng phía trên đường chéo phụ
    public static int sumAboveSubCross(int[][] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr.length-i-1); j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }


    // cộng phía dưới đường chéo phụ
    public static int sumBelowSubCross(int[][] arr){
        int sum=0;
        int j = arr.length-1;
        do {
            for (int i = arr.length-j; i < arr.length; i++) {
                sum += arr[i][j];
            }
            j--;
        }while (j > 0);
        return sum;
    }
}
