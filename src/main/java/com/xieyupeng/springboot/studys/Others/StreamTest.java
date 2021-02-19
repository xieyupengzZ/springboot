package com.xieyupeng.springboot.studys.Others;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java8 stream
 */
public class StreamTest {

    public static class Members{

        String name = "";

        public Members(String name) {
            if(name != null){
                this.name = name;
            }
        }

        public static List<Members> initData(){

            String[] names = {"xieyupeng"
                    ,"dongxian"
                    ,"xiewenyong"
                    ,"wanghaobing"
                    ,"zhengyuanjie"
                    ,"xieyupeng"
                    ,null};
            List<Members> membersList = new ArrayList<Members>();

            for (String name : names) {
                Members members = new Members(name);
                membersList.add(members);
            }

            return membersList;
        }

        public static List<String> initName(){
            String[] names = {"xieyupeng"
                    ,"dongxian"
                    ,"xiewenyong"
                    ,"wanghaobing"
                    ,"zhengyuanjie"
                    ,"xieyupeng"
                    ,""
                    ,null};
            return Arrays.asList(names);
        }

    }

    /**
     * 同一个stream只能被操作一次
     */
    public static void APIStream(){

        List<String> list = Members.initName();
        Stream<String> stream = list.stream();
        //名称不为空
        Predicate<String> predicate = (String m) -> m==null?false:m.length()>0;
        //输出
        Consumer consumer = System.out::println;


        //TODO [allMatch] 全部满足表达式要求,返回true
        stream = list.stream();
        System.out.println(stream.allMatch(predicate));

        //TODO [anyMatch] 一个满足表达式要求,返回true
        stream = list.stream();
        System.out.println(stream.anyMatch(predicate));

        //TODO [noneMatch]
        stream = list.stream();
        System.out.println(stream.noneMatch(predicate));

        //TODO [filter] 过滤
        stream = list.stream();
//        stream.filter(predicate).forEach(consumer);

        //TODO [distinct] 去重
        stream = list.stream().filter(predicate);
//        stream.distinct().forEach(consumer);
//        stream.collect(Collectors.toSet()).forEach(consumer);

        //TODO [collect] 集合转换
        stream = list.stream().filter(predicate);
        List<String> lists = stream.collect(Collectors.toList());
//        Set<String> sets = stream.collect(Collectors.toSet());

        //TODO [findAny、findFirst] 查找，可以配合 [filter] 使用。Optional 返回类型 配合 [orElse] 使用 才能正确输出
        stream = list.stream().filter(predicate);
//        System.out.println(stream.findAny().orElse(null));
//        System.out.println(stream.findFirst().orElse(null));


        //TODO [forEachOrdered] 按定义的顺序迭代Stream
        stream = list.stream().filter(predicate);
//        stream.forEachOrdered(consumer);

        //TODO [limit] 截取
        stream = list.stream().filter(predicate);
//        stream.limit(3).forEach(consumer);

        //TODO [max] Optional 返回类型 配合 [orElse] 使用 才能正确输出
        stream = list.stream().filter(predicate);
        System.out.println(stream.max((String s1,String s2)->s1.length()-s2.length()));

        //TODO [min] Optional 返回类型 配合 [orElse] 使用 才能正确输出
        stream = list.stream().filter(predicate);
        System.out.println(stream.min((String s1,String s2)->s1.length()-s2.length()));

        //TODO [toArray] 转成数组
        stream = list.stream().filter(predicate);
        stream.toArray();

        //TODO [sorted] 排序
        stream = list.stream().filter(predicate);
        stream.sorted((String s1,String s2) -> s1.length() - s2.length());

        //TODO [skip] 丢弃该位置之前的所有元素，返回剩下的元素
        stream = list.stream().filter(predicate);
//        stream.skip(3).forEach(consumer);

        //TODO [peek] 不会对元素造成影响，只是利用元素进行一些处理。
        stream = list.stream().filter(predicate);
//        stream.peek(String::toUpperCase).forEach(consumer);

        //TODO [reduce] 对每个元素进行操作，最后返回一个值。如最大值，最小值。
        stream = list.stream().filter(predicate);
        System.out.println(stream.reduce((String s1,String s2)->s1.length()>s2.length()?s1:s2).orElse(null));

        //TODO [map] 方法，对一个流中值进行某种形式的转换
        //集合流中 每一个元素 变成了另个一形式
        stream = list.stream().filter(predicate);
        Function<String,String> functionMap = (String n) -> n.toUpperCase();
//        functionMap = String::toUpperCase;
        Stream<String> streamap1 = stream.map(functionMap);
//        streamap1.forEach(consumer);

        //TODO [flatMap] 方法，对一个流中值进行某种形式的转换
        //和 map 的区别在于，传入的 function 表达式，返回类型的必须是一个Stream
        //按照map的思维，就是 集合流中 每一个元素，变成了一个流，就是一个流的集合流
        //但是 flatMap 最后返回的是一个流，它会吧 每个流 中的元素全都合并成一个流
        stream = list.stream().filter(predicate);
        Function<String,Stream<Character>> functionFlatMap = (String n )->characterStream(n);
//        Stream<Stream<Character>> streamap= stream.map(functionFlatMap);
        Stream<Character> streaFlatmap= stream.flatMap(functionFlatMap);
//        streaFlatmap.forEach(consumer);

        //TODO 静态方法
        //流的构造器
        Stream.builder().build();
        //空的流
        Stream.empty();
        //数组转流
        Stream.of(new String[]{"xieyupeng"
                , "xieyupeng"
                , "dongxian"
                , "xiewenyong"
                , "wanghaobing"
                , "zhengyuanjie"
                , ""
                , null});
        //合并两个流
        stream = list.stream().filter(predicate);
        Stream stream1 = list.stream();
        Stream<String> stream2 = Stream.concat(stream,stream1);
//        stream2.forEach(consumer);

    }

    /**
     * 把字符串改成字符数组流
     * @param s
     * @return
     */
    public static Stream<Character> characterStream(String s){
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray())
            result.add(c);
        return result.stream();
    }

    public static void main(String[] args) {
        StreamTest.APIStream();
    }


}
