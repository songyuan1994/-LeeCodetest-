package leetCode101.charpter5;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Thin'k'pa'd
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] num = new int[]{6,9,5,3};
        quickSort(num,0,4);
    }

    public static void quickSort(int[] nums, int l, int r) {
        int first = l;
        int last = r - 1;
        int k = nums[first];
        while (first<last){
            while(first<last && nums[last]>=k){
                --last;
            }
            nums[first] = nums[last];
            while(first<last && nums[first]<=k){
                ++first;
            }
            nums[last] = nums[first];
        }
        System.out.println(Arrays.toString(nums));
    }
}
