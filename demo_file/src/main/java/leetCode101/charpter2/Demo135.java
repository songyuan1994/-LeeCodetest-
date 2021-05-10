package leetCode101.charpter2;


import java.util.Arrays;

public class Demo135 {
    public static void main(String[] args) {
        int[] r = new int[]{1,3,5,3,2,1};
        System.out.println(candy2(r));
    }

    public static int candy(int[] ratings) {

        int[] result = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            result[i] = 1;
        }

        if (ratings.length < 2) {
            return ratings.length;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; --i) {
            if(ratings[i]<ratings[i-1]){
                result[i-1] = Math.max(result[i-1],result[i]+1);
            }
        }
        return Arrays.stream(result).sum();
    }

    /**
     * 官方题解，这里用循环法，
     * 引入增加队列跟降序队列。
     * 需要注意的情况就是，如果升序<=降序队列长度，那么是需要在原来的加1的。
     * 知道别人生气了，也不过来道歉，然后就说自己难过。真挺假的。
     *
     * @param ratings 队列
     * @return 分数
     */
    public static int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}
