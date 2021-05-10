package leetCode101.charpter3;

import java.util.Arrays;

/**
 * 本章主要讲玩转双指针：
 * 若两个指针指向同一数组，遍历方向相同且不会相交，则称为滑动窗口(两个指针包围的区域即为当前的窗口)，
 * 经常用于区间搜索
 *
 * 本题描述：
 * 两数之和-输入有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 示例 1：
 *
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */
public class Demo167 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,4};
        int target = 22;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int head = 0;
        int tail = numbers.length-1;
        while (head!=tail) {
            if(numbers[head]+numbers[tail]>target){
                tail--;
            }
            if(numbers[head]+numbers[tail]<target){
                head++;
            }
            if(numbers[head]+numbers[tail]==target){
                result[0]=head+1;
                result[1]=tail+1;
                break;
            }
        }
        return result;
    }

    /**
     * 二分查找
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

}
