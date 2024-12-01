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
}

