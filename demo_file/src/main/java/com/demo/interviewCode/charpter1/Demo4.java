package com.demo.interviewCode.charpter1;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 生成窗口最大值数组
 */
public class Demo4 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int index = 2696%8;
        System.out.println(index);
        int[] res = getMaxWindow(arr,w);
        System.out.println(JSON.toJSONString(res));
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> queryMax = new LinkedList<>();
        int[] res = new int[arr.length - w +1];
        int index = 0;
        for(int i = 0 ; i< arr.length; i++){
            while(!queryMax.isEmpty() && arr[queryMax.peekLast()] <= arr[i]){
                queryMax.pollLast();
            }
            queryMax.addLast(i);
            if(queryMax.peekFirst() == i-w){
                queryMax.pollFirst();
            }
            if(i >= w -1){
                res[index++] = arr[queryMax.peekFirst()];
            }
        }
        return res;
    }


}
