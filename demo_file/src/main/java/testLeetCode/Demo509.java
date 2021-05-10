package testLeetCode;

import org.springframework.util.StringUtils;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 力扣 509题 斐波那锲数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * @author Thin'k'pa'd
 */
public class Demo509 {
    public static final List<String> imageType = new ArrayList<>();

    static void init(){
        imageType.add("png");
        imageType.add("gif");
        imageType.add("jpeg");
        imageType.add("bmp");
    }

    private static volatile long upper;


    public static void main(String[] args) {
        System.out.println(fib2(5));

        String fileName = "222";
        String fileTypeStr = "";
        int fileTypeIndex = fileName.lastIndexOf(".");
        if (fileTypeIndex >= 0) {
            fileTypeStr = fileName.substring(fileTypeIndex);
        }
        if(!imageType.contains(fileTypeStr) && !StringUtils.isEmpty(fileTypeStr)){
            fileName = fileName.replace(fileTypeStr,".jpeg");
        }
        System.out.println(fileName);
    }

    /**
     * 自己写的递归算法，但是这样算法太SB了，因为递归每次都要求前面的
     * 比如F（10）就要一直算很多遍f(5)，效率太低。
     * @param n
     * @return
     */
    public static int fib(int n) {
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fib2(int n) {
        if(n<=1){
            return n;
        }
        int f=1,s=1,result=0;
        for(int i=2;i<n;i++){
            result =  s+f;
            f=s;
            s=result;
        }
        return result;
    }

}
