package com.example.prac.chapter04;

import org.apache.commons.math3.distribution.BinomialDistribution;

public class BinomialDistributionTester {
    static final int n = 5;
    static final double p = 0.25;

    public static void main(String[] args) {
        BinomialDistribution bd = new BinomialDistribution(n, p);
        for (int x = 0; x <= n; x++){
            System.out.printf("%4d%8.4f%n", x, bd.probability(x));
        }
        System.out.printf("평균 = %6.4f%n", bd.getNumericalMean());
        double variance = bd.getNumericalVariance();
        double stdv = Math.sqrt(variance);
        System.out.printf("표준변차 = %6.4f%n", stdv);
    }


}
