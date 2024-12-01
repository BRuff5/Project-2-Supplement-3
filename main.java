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

}

