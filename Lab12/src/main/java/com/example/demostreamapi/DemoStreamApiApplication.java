package com.example.demostreamapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Functional interface -> Lambda Expression -> Stream API
* Functional interface chỉ có 1 method ( phương thức trừu tượng )
 * */
@SpringBootApplication
public class DemoStreamApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoStreamApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*//Functional interface

        //Cách 1
        Greeting vietnam=new Vietnam();
        vietnam.sayHello("Cường");

        //Cách 2 anoymus class
        Greeting english=new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello "+name);
            }
        };
        english.sayHello("Cường");

        //cách 3 sử dụng Lambda Expression
        Greeting french = (name) -> System.out.println("Bonjour " + name);
        french.sayHello("Cường");

        Greeting china = (name) ->{
            System.out.println("Nihao "+name);
        };
        china.sayHello("Cường");

        List<Integer> numbers=new ArrayList<>(List.of(1,2,3,4,3,6,9,7,9));
        for (int i=0;i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }

        for (Integer number: numbers) {
            System.out.println(number);
        }

        numbers.forEach(number -> System.out.println(number) ) ;//System.out::println);
        numbers.sort((a,b) -> b-a);
        System.out.println(numbers);*/

        //StreamAPI

        /*
        * Cho một List number như sau
Và thực hiện các chức năng

Duyệt numbers
Tìm các giá trị chẵn trong list
Tìm các giá trị > 5 trong list
Tìm giá trị max trong list
Tìm giá trị min trong list
Tính tổng các phần tử của mảng
Lấy danh sách các phần tử không trùng nhau
Lấy 5 phần tử đầu tiên trong mảng
Lấy phần tử từ thứ 3 -> thứ 5
Lấy phần tử đầu tiên > 5
Kiểm tra xem list có phải là list chẵn hay không
Kiểm tra xem list có phần tử > 10 hay không
Có bao nhiêu phần tử > 5
Nhân đôi các phần tủ trong list và trả về list mới
Kiểm tra xem list không chứa giá trị nào = 8 hay không*/

        /*List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);
        //Duyệt number
        System.out.println("Duyệt numbers: ");
        numbers.forEach(System.out::println);

        //TÌm chẵn
        numbers.stream()
                .filter(num -> num % 2 == 0)//.toList()
                .forEach(System.out::println);

        //>5
        numbers.stream()
                .filter(num -> num - 5 > 0)//.toList()
                .forEach(System.out::println);

        //Max
        int max=numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("Giá trị max: "+max);
        //Min
        int min=numbers.stream()
                .min(Integer::compareTo)
                .orElse(0);
        System.out.println("Giá trị min: "+min);

        //Tính tổng
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Tổng các phần tử của mảng: " + sum);

        //Không trùng nhau
        numbers.stream()
                .distinct().toList()
                .forEach(System.out::println);

        //5 phần tử đầu tiên
        numbers.stream()
                .limit(5)
                .forEach(System.out::println);

        //từ thứ 3 đến thứ 5
        numbers.stream()
                .skip(2)
                .limit(3)
                .forEach(System.out::println);

        //Lấy phần tử đầu tiên >5
        numbers.stream()
                .filter(num -> num>5)
                .limit(1)
                .forEach(System.out::println);

        //list chẵn list lẻ
        boolean allList=numbers.stream()
                .allMatch(num -> num%2==0); //every JS
        System.out.println("List chẵn là : "+allList);

        //>10 hay không
        boolean Big10=numbers.stream()
                .anyMatch(num -> num-10>0); //some Js
        System.out.println("List có >10 "+Big10);

        //có bao nhiêu >5
        long count=numbers.stream()
                .filter(num -> num-5>0)
                .count();
        System.out.println("Số lượng > 5 " + count);

        //nhân đôi phần tử trong list và trả về list mới
        List<Integer> doubleNumbers= numbers.stream()
                .map(num -> num * 2).toList();
        System.out.println("List mới "+doubleNumbers);

        //list chứa 8 không
        boolean have8=numbers.stream()
                .noneMatch(num -> num !=8);
        System.out.println("List chứa 8 là "+ have8 );*/
    }




}
