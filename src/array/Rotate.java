package array;

import org.junit.Test;

/**
 * @author : champion
 * @version V1.0
 * @Description:
 * @date Date : 2020年08月20日 14:02
 */
public class Rotate {

    @Test
    public void test() {
        int[][] matrix =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        printMatrix(matrix);
        rotate2(matrix);
        printMatrix(matrix);
    }

    public void rotate(int[][] matrix) {
        int border = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int newI = j;
                int newJ = border - i;
                int temp = -matrix[i][j];
                matrix[i][j] = -matrix[newI][newJ];
                matrix[newI][newJ] = temp;
            }
        }
        System.out.println("*************");
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "-");
            }
            System.out.println();
        }
    }

    public void rotate1(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            int end = len - i - 1;
            for (int j = 0; j < end - i; j++) {

                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[end - j][i];

                matrix[end - j][i] = matrix[end][end - j];

                matrix[end][end - j] = matrix[i + j][end];

                matrix[i + j][end] = temp;
                System.out.println(i + "," + j);
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        printMatrix( matrix );
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

}