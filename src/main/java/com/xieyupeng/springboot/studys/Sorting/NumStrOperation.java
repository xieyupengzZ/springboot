package com.xieyupeng.springboot.studys.Sorting;

/**
 * Created by XYP on 2018/4/9.
 * 数字型字符串，以数字的形式计算和
 */
public class NumStrOperation {

    /**
     * 1、创建一个数组长度记录每个位的值，大小是最长的字符串长度+1
     * 2、while循环两两对应位相加，%10 是当前位的值，/10 是进位，进位单独用一个变量替换保存，下次循环和两个数一起相加
     * 3、分别用标志位记录两个字符串是否结束，两个都结束了就退出循环
     */
    public static String functionOne(String a,String b){

        //去掉所有字符
        a=a.replaceAll("\\s+","");
        b=b.replaceAll("\\s+","");
        System.out.println("a = "+a + ", b = "+b);
        //去掉字符串前面的0
        a=a.replaceAll("^0+","");
        b=b.replaceAll("^0+","");
        System.out.println("a = "+a + ", b = "+b);

        //字符串相加
        int[] chars = new int[a.length()>b.length()?a.length()+1:b.length()+1];
        int order = 1;
        int num = 0;
        char a1 = '0';
        char b1 = '0';
        boolean endOfA = false;
        boolean endOfB = false;
        while (!endOfA||!endOfB){
            if(a.length()-order>=0){
                a1 = a.charAt(a.length()-order);
            }else {
                a1 = '0';
                endOfA = true;
            }
            if(b.length()-order>=0){
                b1 = b.charAt(b.length()-order);
            }else {
                b1 = '0';
                endOfB = true;
            }
            if(endOfA&endOfB){
                break;
            }
            int c1 = Integer.parseInt(String.valueOf(a1))+Integer.parseInt(String.valueOf(b1))+num;
            chars[chars.length-order] = (char) (c1%10);
            num = c1/10;
            order++;
        }

        //数组转字符串
        StringBuilder stringBuilder = new StringBuilder();
        boolean isZero = true;
        for (int aChar : chars) {
            //初始化数组的时候，因为不知道最后的结果位数，所以可能会多一位，即多一个0，因为数组初始化的时候，元素值都默认0
            if(aChar!=0&&isZero){
                isZero = false;
            }
            if(!isZero){
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 两个数字型字符串相加
     * 前面补零使两个字符串长度一致
     */
    public static void functionTwo(String a,String b){

        //去掉所有字符
        a=a.replaceAll("\\s+","");
        b=b.replaceAll("\\s+","");
        System.out.println("a = "+a + ", b = "+b);
        //去掉字符串前面的0
        a=a.replaceAll("^0+","");
        b=b.replaceAll("^0+","");
        System.out.println("a = "+a + ", b = "+b);

        //以最长的字符串为准，短的前面补零，保证两个字符串长度一致
        int al = a.length();
        int bl = b.length();
        if(al>bl){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0 ; i <al-bl; i ++){
                stringBuilder.append(0);
            }
            b = stringBuilder.append(b).toString();
        }
        if(bl>al){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0 ; i <bl-al; i ++){
                stringBuilder.append(0);
            }
            a = stringBuilder.append(a).toString();
        }
        System.out.println("a = "+a + ", b = "+b);

        //逆向相加，逆向保存，每次都把进位保存到小的前一个数组位，然后下次循环就可以加上了
        //字符串和数组的位置对比，a总共i个字符，数组 i+1 个
        //a:   xieyu ... p   e   n   g
        //list:01234 ... i-3 i-2 i-1 i i+1
        int[] list = new int[a.length()+1];
        for (int i = a.length()-1 ; i >= 0 ; i --){
            String achar = String.valueOf(a.charAt(i));
            String bchar = String.valueOf(b.charAt(i));
            int c = Integer.parseInt(achar) + Integer.parseInt(bchar) + list[i+1];
            list[i+1] = c%10;
            list[i] = c/10;
        }

        //数组转字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : list) {
            stringBuilder.append(i);
        }
        String result = stringBuilder.toString().replaceAll("^0+","");
        System.out.println("a + b = "+result);
    }

    //字符串反向输出
    public static String huiwenStr(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {

        functionTwo("00003923000 99239000 ","00000000000 0000000000000023423");
    }

}
