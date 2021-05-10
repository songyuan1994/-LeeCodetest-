package leetCode101.charpter2;

/**
 * @author Thin'k'pa'd
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，
 * 1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 * 示例 1：
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 */
public class Demo605 {
    public static void main(String[] args) {
        int[] flow=new int[]{0,0,1,0,1};
        System.out.println(canPlaceFlowers(flow,1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean pre=true;
        int rel = 0;
        for(int i=0;i<flowerbed.length;i++){
            if(pre && flowerbed[i]==0){
                rel++;
                pre=false;
            }else if(!pre && flowerbed[i]==1){
                rel--;
                pre=false;
            }else {
                pre=flowerbed[i]==0;
            }
        }

        return rel>=n;
    }
}
