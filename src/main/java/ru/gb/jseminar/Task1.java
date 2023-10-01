package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) throws Exception{
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,6,7));
        // result [6,6,0,1]

        Task1 sq = new Task1();

        System.out.println("Сумма = " + sq.sum(d1, d2));

    }

    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null){
            throw new Exception("Входные данные неверные.");
        }

        Deque<Integer> res = new ArrayDeque<>();
        int dozens = 0;
        while (d1.size() > 0 || d2.size() > 0){
            int sum = dozens;
            dozens = 0;
            if (d1.size() > 0){
                sum = sum + d1.pollFirst();
            }
            if (d2.size() > 0){
                sum = sum + d2.pollFirst();
            }
            if (sum >= 10){
                sum = sum - 10;
                dozens = 1;
            }
            res.offer(sum);
        }
        if (dozens != 0){
            res.offer(dozens);
        }
        return res;
    }
}
