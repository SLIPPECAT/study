package com.example.prac.chapter04;

import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

import java.util.Random;

public class CorrectionExample {
    static final Random RANDOM = new Random();
    static double[][] data1 = random(1000);
    static double[][] data2 = {{1,2,3,4,5}, {1,3,5,7,9}};
    static double[][] data3 = {{1,2,3,4,5}, {9,8,7,6,5}};

    public static void main(String[] args) {
        System.out.printf("상관계수1 = %6.3f%n", rho(data1));
        System.out.printf("상관계수2 = %6.3f%n", rho(data2));
        System.out.printf("상관계수3 = %6.3f%n", rho(data3));
    }

    private static double[][] random(int n) {
        double[][] a = new double[2][n];
        for (int i = 0; i < n; i++) {
            a[0][i] = RANDOM.nextDouble();
            a[1][i] = RANDOM.nextDouble();
        }
        return a;
    }
    private static double rho(double[][] data) {
        //분산
        Variance v = new Variance();
        double varX = v.evaluate(data[0]);
        double sigX = Math.sqrt(varX);
        double varY = v.evaluate(data[1]);
        double sigY = Math.sqrt(varY);
        // 공분산
        Covariance c = new Covariance(data);
        double sigXY = c.covariance(data[0], data[1]);
        return sigXY/(sigX*sigY);
    }



}
