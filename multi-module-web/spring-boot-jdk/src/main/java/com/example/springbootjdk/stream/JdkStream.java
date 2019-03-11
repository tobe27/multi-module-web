package com.example.springbootjdk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
 *
 * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 *
 * 这种风格将要处理的元素集合看作一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选，排序，聚合等。
 *
 * Stream有以下特性及优点：
 *
 *  无存储。Stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
 *
 *  为函数式编程而生。对Stream的任何修改都不会修改背后的数据源，比如对Stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新Stream。
 *
 *  惰式执行。Stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
 *
 *  可消费性。Stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
 *
 *  主要有三种关键性操作：分别是流的创建、中间操作（intermediate operation）以及最终操作(terminal operation)。
 *
 * @author CREATED BY L.C.Y on 2019-3-11
 */
public class JdkStream {

    // ======================================流中间操作===============================
    /**
     * filter 方法用于通过设置的条件过滤出元素
     */
    public void operateByFilter() {
        /**
         * 通过已有的集合创建流
         */
        List<String> languageList = Arrays.asList("Java", "Java", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");
        Stream<String> langStream = languageList.stream();

        /**
         * 通过Stream创建流
         */
        Stream<String> langStream1 = Stream.of("Java", "Python", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");

        // 过滤空字符串
        langStream.filter(String::isEmpty).forEach(System.out::println);
        // 过滤非空字符串
        langStream1.filter(lang -> !lang.isEmpty()).forEach(System.out::println);
    }

    /**
     * map 方法用于映射每个元素到对应的结果
     */
    public void operateByMap() {
        /**
         * 通过已有的集合创建流
         */
        List<String> languageList = Arrays.asList("Java", "Java", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");
        Stream<String> langStream = languageList.stream();

        /**
         * 通过Stream创建流
         */
        Stream<String> langStream1 = Stream.of("Java", "Python", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");

        // 把元素映射为大写
        langStream.map(String::toUpperCase).forEach(System.out::println);

        // 把元素映射为小写
        langStream1.map(s -> s.toLowerCase()).forEach(System.out::println);
    }

    /**
     * limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素。
     */
    public void operateByLimitOrSkip() {
        /**
         * 通过已有的集合创建流
         */
        List<String> languageList = Arrays.asList("Java", "Java", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");
        Stream<String> langStream = languageList.stream();

        /**
         * 通过Stream创建流
         */
        Stream<String> langStream1 = Stream.of("Java", "Python", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");
        // limit 返回 Stream 的前面 n 个元素
        langStream.limit(5).forEach(System.out::println);

        // skip 则是扔掉前 n 个元素
        langStream1.skip(2).forEach(System.out::println);
    }

    /**
     * sorted 方法用于对流进行排序;distinct主要用来去重.
     */
    public void operateBySortedOrDistinct() {
        /**
         * 通过已有的集合创建流
         */
        List<String> languageList = Arrays.asList("Java", "Java", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");
        Stream<String> langStream = languageList.stream();

        /**
         * 通过Stream创建流
         */
        Stream<String> langStream1 = Stream.of("Java", "Python", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");

        // 排序
        langStream.sorted().forEach(System.out::println);

        // 去重
        langStream1.distinct().forEach(System.out::println);
    }

    public void terminalOperate() {
        /**
         * 通过已有的集合创建流
         */
        List<String> languageList = Arrays.asList("Java", "Java", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");
        Stream<String> langStream = languageList.stream();

        /**
         * 通过Stream创建流
         */
        Stream<String> langStream1 = Stream.of("Java", "Python", "", "Python", "JavaScript", "CSS", "HTML", "C", "C++", "C#");

        // count,计数
        System.out.println(langStream.filter(s -> !s.isEmpty()).map(s -> s.toLowerCase()).sorted().limit(8).skip(1).distinct().count());

        // collect，生成集合
        List<String> collectStringList = langStream1.filter(s -> s.contains("C")).collect(Collectors.toList());

        // forEach，遍历
        collectStringList.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        JdkStream jdkStream = new JdkStream();
        System.out.println("==========Filter============");
        jdkStream.operateByFilter();

        System.out.println("==========Map============");
        jdkStream.operateByMap();

        System.out.println("==========Limit=Skip==========");
        jdkStream.operateByLimitOrSkip();

        System.out.println("==========Sorted=Distinct===========");
        jdkStream.operateBySortedOrDistinct();

        System.out.println("==========count===========");
        jdkStream.terminalOperate();
    }


}
