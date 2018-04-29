package com.example.demo.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Bob Simon
 * @Description：lambda测试，不过发现现在的遍历方式查询效率比较慢
 * @Date :Created in 2018-04-21 10:11
 * @Modified By
 **/
public class LambdaTest {

    /**
     * 为每个订单加上12%的税
     */
    public static void orderPlusTax(){
        /***老方法*/
       /* List<Double> costBeforeTax = Arrays.asList(100.00,200.00,300.00,400.00,500.00);
        double total = 0;
        for (Double cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);*/

        /***新方法*/
        List<Double> costBeforeTax = Arrays.asList(100.00, 200.00, 300.00, 400.00, 500.00);
        double bill = costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).reduce((sum, cost) -> (sum + cost)).get();
        System.out.println("Total : " + bill);
    }

    /**
     * 数组遍历
     */
    public static void collectionForeach(){
        List<String> list = Arrays.asList("Lambdas","Default Method","Stream API","Date and Time API");
        /**之前的遍历方式***/
        /* for(String string : list){
            System.out.println(string);
        } */
        /*******现在的遍历两种方式********/
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);
    }

    /**
     * 将字符串换成大写并用逗号链接起来
     */
    public static void changeStringToUpperCase(){
        List<String> G7 = Arrays.asList("USA","Japan","France","Germany","Italy","U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }

    /**
     * 获取数字的个数、最小值、最大值、总和以及平均值
     */
    public static void countValueOfTheArrays(){

        List<Integer> primes = Arrays.asList(3, 5, 7, 2, 19, 23, 29,11, 13, 17);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }


    public static void main(String[] args){
        long start = System.currentTimeMillis();
        //changeStringToUpperCase();
        countValueOfTheArrays();
        System.out.println(System.currentTimeMillis() - start);

    }

}
