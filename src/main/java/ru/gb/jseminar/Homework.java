package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import javax.net.ssl.ExtendedSSLSession;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        Deque<Integer> resMultiple = new ArrayDeque<>(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(resMultiple);

        Deque<Integer> resSum = new ArrayDeque<>(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
        System.out.println(resSum);
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null){
            throw new Exception("Входные данные неверные.");
        }

        Deque<Integer> res = new ArrayDeque<>();
        int dozens = 0;

        while (d1.size() > 0 || d2.size() > 0){
            int result = 0;
            dozens = 0;
            
            for (Integer i : d1) {
                for (Integer j : d2){
                    result = i * j;
                    if (result >= 10){
                        dozens = result / 10;
                        result = result % 10;
                    }
                    if (result < 10){
                        result = dozens + result;
                        dozens = 0;
                    }
                    res.offer(result);
                }
                if (dozens != 0){
                    res.offer(dozens);
                }
            }
            if (dozens != 0){
                res.offer(dozens);
            }     
        }
        
        return res;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
        if (d1 == null || d2 == null){
            throw new Exception("Входные данные неверные.");
        }

        Deque<Integer> res = new ArrayDeque<>();
        int dozens = 0;

        return res;
    }
}
