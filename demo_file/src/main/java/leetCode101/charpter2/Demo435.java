package leetCode101.charpter2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Thin'k'pa'd
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class Demo435 {
    public static void main(String[] args) {

    }

    /**
     *
     *贪心算法，首先把数组按照最右节点大小排序
     * 找到最小的，当做初始节点，那么后面的最右节点一定是大于等于它的
     * 然后判断下左节点是否大于等于最右，如果大于证明没有交界，则把当前的置为初始节点
     * 然后因为已经排过序了，所以下一个仍然是最右边一定大于等于当前的，所以判断条件是一样的
     * 这样一次循环就能找到了。
     *
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

}
