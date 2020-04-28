package com.bosiwan.springbootdemo.utils;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * JDK8新特性，stream流，Map集合遍历
 * Created by Tiger on 2018/11/2.
 */

public class JDKDemo {

    private static int num = 2000000;

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        int i= 0;
        while (i < num){
            map.put("k_"+i,"v_"+i);
            i ++;
        }
        // TODO: 2018/11/2 测试1
//        traverseMap(map);
        // TODO: 2018/11/2 测试2
//        mapTest(map,"v_1");
        // TODO: 2018/11/2 测试3

        long startTime = System.currentTimeMillis();
        Map<String,String> filterMap = filterMapValue(map,"v_1");
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        Map<String,String> filterMap1 = filterMapValue1(map,"v_1");
        System.out.println(System.currentTimeMillis() - startTime);
//        traverseMap(filterMap1);

        startTime = System.currentTimeMillis();
        Map<String,String> filterMap2 = filterMapValue2(map,"v_1");
        System.out.println(System.currentTimeMillis() - startTime);
//        traverseMap(filterMap1);

    }

    /**
     * 遍历map
     * */
    public static void traverseMap(Map<String,String> map){
        if (map == null || map.isEmpty()){
            return;
        }
        //Lambda表达式，代码简单易懂
        map.forEach((k,v) ->{
            System.out.println(k +","+ v);
        });
    }

    /**
     * 统计map中包含某一类值的个数，如果是以前的话，这里的代码应该会多好几行
     * contains:只要对应的String中包含，返回值就是true，否则false
     * */
    private static long mapTest(Map<String,String> map,String contains){
        long count = map.entrySet().stream().filter(
                entry -> (entry.getValue().contains(contains))
        ).count();
        System.out.println(count);
        return count;

    }

    /**
     * 过滤掉map中包含指定的value,然后返回过滤之后的map
     * */
    private static  Map<String,String> filterMapValue(Map<String,String> map,String contains){
        if(map == null || map.isEmpty()){
            return null;
        }
        return map.entrySet().stream().filter(entry -> (
                ! entry.getValue().contains(contains)
        )).collect(Collectors.toMap(
                entry1 -> entry1.getKey(),
                entry2 -> entry2.getValue()
        ));

    }

    /**
     * 使用并行流过滤掉map中包含指定的value,然后返回过滤之后的map
     * todo 测试发现 parallelStream在数据大时速度明显优于stream
     * todo 代码简便，速度又快，为什么不用呢。。。。。
     * */
    private static  Map<String,String> filterMapValue1(Map<String,String> map,String contains){

        if(map == null || map.isEmpty()){
            return null;
        }
        return map.entrySet().parallelStream().filter(entry ->
                ! entry.getValue().contains(contains)
        ).collect(Collectors.toMap(
                entry1 -> entry1.getKey(),
                entry2 -> entry2.getValue()
        ));

    }
    /**
     * todo 测试发现，以前的老写法比parallelStream快
     * */
    private static Map<String,String> filterMapValue2(Map<String,String> map,String contains){

        if(map == null || map.isEmpty()){
            return null;
        }

        Map<String,String> map1 = new HashMap<String, String>();
        Set<Map.Entry<String,String>> entries = map.entrySet();

        for(Map.Entry<String,String> entry : entries){
            if(! entry.getValue().contains(contains)){
                map1.put(entry.getKey(),entry.getValue());
            }
        }
        return map1;
    }

}
