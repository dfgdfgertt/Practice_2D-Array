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

    }

    public static int[][] generatedArrays(){
        Random random = new Random();
        int m = random.nextInt(4) + 2, n= random.nextInt(4) + 2;
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(9);
            }
        }
        return arr;
    }

    public static void findNumInArrays(int[][] arr){
        System.out.print("Tìm 1 số\nNhập 1 số dương: ");
        int x = input.nextInt();
        System.out.print("Số có tồn tại trong mảng: " +  find(x,arr));

    }

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


}
