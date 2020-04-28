package com.bosiwan.springbootdemo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCodeTest {

    /**
     * Demo（有一链表，{1,2,3,4,5}，把偶数过滤掉）
     */
    public static void filterTest() {
        List list = new ArrayList();
        for (int i = 1; i <= 5; ++i) {
            list.add(i);
        }
        // (int) param % 2 == 1 为奇数，过滤偶数
        list.stream().filter(param -> (int) param % 2 == 1)
                .forEach(System.out::println);
    }

    /**
     * sorted()：对元素排序
     */
    public static void sortedTest() {
        List list = new ArrayList();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        // 升序
        list.stream().sorted().forEach(System.out::println);
        // 降序
        list.stream().sorted((param1, param2) -> ((int) param1 < (int) param2 ? 1 : -1))
                .forEach(System.out::println);
    }

    /**
     * map()：元素映射
     */
    public static void mapTest() {
        List list = new ArrayList();
        list.add(1);
        list.add(0);
        list.stream().map(param -> (int) param == 1 ? true : false).forEach(System.out::println);

    }

    /**
     * distinct()：去重
     */
    public static void distinctTest() {
        List list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(0);
        list.stream().distinct().forEach(System.out::println);

    }

    /**
     * forEach()：遍历每个元素。
     * reduce()：把Stream 元素组合起来。例如，字符串拼接，数值的 sum，min，max ，average 都是特殊的 reduce。
     * collect()：返回一个新的集合。
     * min()：找到最小值。
     * max()：找到最大值。
     */

    public static void reduceTest() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(
                list.stream().reduce((param1, param2) -> (int) param1 % (int) param2).get());

    }

    public static void collectTest() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List _list = (List) list.stream().filter((param) -> (int) param % 2 == 0)
                .collect(Collectors.toList());
        _list.stream().forEach(System.out::println);
    }



    public static void maxAndMinTest() {

            List list = new ArrayList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);

            System.out.println(list.stream().min(
                    (param1,param2) -> (int)param1 > (int)param2 ? 1:-1 ).get());
            System.out.println(list.stream().max(
                    (param1,param2) -> (int)param1 > (int)param2 ? 1:-1 ).get());

        }

    public static void mapNewTest() {

        // 创建一个Map
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("name", "Zebe");
        infoMap.put("site", "www.zebe.me");
        infoMap.put("email", "zebe@vip.qq.com");
        // 传统的Map迭代方式
        for (Map.Entry<String, Object> entry : infoMap.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
        // JDK8的迭代方式
        infoMap.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });


    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[6];
        int tmp = 0 ;
        for(int i = 0 ;i<nums.length;i++){
            tmp = nums[i] ;
            for(int j = 0 ;j<nums.length;j++){
                if(tmp + nums[j] == target){
                   result [0] = i;
                   result [1] = j;
                   return result;
                }
            }
        }
        return result ;
    }


    public static int lengthOfLongestSubstring(String s) {
        byte[] byteArray = s.getBytes();
        byte tmpByte ;
        byte nextByte ;
        List<Integer> re = new ArrayList<Integer>();
        int first = 0 ;
        int end = 0 ;
        for (int i = 0; i <byteArray.length ; i++) {
            tmpByte = byteArray [i] ;
            first = i ;
            for (int j = i+1; j <byteArray.length-1 ;j++) {
                nextByte = byteArray [j] ;

                end =j ;
                if(tmpByte != nextByte && byteArray [j] != byteArray [j-1]){
                    re.add(end - first);
                    continue;
                }else {
                    break;
                }

            }
        }
        if(re == null || re.size() == 0 ){
            return 1 ;
        }else {
            return re.stream().max(
                    (param1,param2) -> (int)param1 > (int)param2 ? 1:-1 ).get();
        }
    }

    public static void main(String[] args) {
        String s = "pwwkew" ;
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

        int[] nums = {2, 7, 11, 15} ;
        int target = 9 ;
        twoSum(nums,target);

//        int i = 1 % 2 ;
//        System.out.println(i);
        List list = List.of("12","14","k","v");
        list.forEach(System.out::println);

        List keyList = new ArrayList();
        List valueList = new ArrayList();
        Map.of("Key",List.of("k1","v1")).forEach((key, value) -> {
            System.out.println(key + "：" + value);
            List map = value ;
            map.forEach(
                System.out::println
            );
            keyList.add(key);
            valueList.add(value);
        });

//        maxAndMinTest();
    }
}
