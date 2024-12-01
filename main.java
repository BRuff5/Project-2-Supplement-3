public class main {

    /**
     * Perform a binary search .
     *
     * @param sortedArray A sorted array 
     * @param target      What is being searched
     * @return if target element is found
     */
    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0, right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Calculate the determinant of a square matrix.
     *
     * @param matrix 2D array.
     * @return The determinant 
     * @throws IllegalArgumentException If the matrix is not square.
     */
    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        for (int[] row : matrix) {
            if (row.length != n) {
                throw new IllegalArgumentException("Matrix must be square.");
            }
        }
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        int det = 0;
        for (int col = 0; col < n; col++) {
            det += (col % 2 == 0 ? 1 : -1) * matrix[0][col] * determinant(minor(matrix, col));
        }
        return det;
    }

    private static int[][] minor(int[][] matrix, int excludeCol) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            int colIndex = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludeCol) continue;
                minor[i - 1][colIndex++] = matrix[i][j];
            }
        }
        return minor;
    }


    /**
     * Multiply two matrices.
     *
     * @param matrixA The first matrix.
     * @param matrixB The second matrix.
     * @return The product of the matrices.
     * @throws IllegalArgumentException If the matrices cannot be multiplied.
     */
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length, colsA = matrixA[0].length;
        int rowsB = matrixB.length, colsB = matrixB[0].length;
        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }

        int[][] product = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                product[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    product[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return product;
    }

    // Test methods
    public static void main(String[] args) {
        // Binary Search Test
        int[] sortedArray = {1, 3, 5, 7, 9};
        System.out.println("Binary Search Test:");
        System.out.println("Index of 5: " + binarySearch(sortedArray, 5)); // Should print 2
        System.out.println("Index of 8: " + binarySearch(sortedArray, 8)); // Should print -1

        // Determinant Test
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("\nDeterminant Test:");
        System.out.println("Determinant: " + determinant(matrix)); // Should print 0

        // Matrix Multiplication Test
        int[][] matrixA = {
            {1, 2},
            {3, 4}
        };
        int[][] matrixB = {
            {5, 6},
            {7, 8}
        };
        System.out.println("\nMatrix Multiplication Test:");
        int[][] result = multiplyMatrices(matrixA, matrixB);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        // Should print:
        // 19 22
        // 43 50
    }
}

