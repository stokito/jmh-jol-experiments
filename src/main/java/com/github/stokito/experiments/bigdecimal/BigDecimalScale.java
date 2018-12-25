package com.github.stokito.experiments.bigdecimal;

import java.math.BigDecimal;

/**
  What is the difference between BigDecimal movePointRight and scaleByPowerOfTen?
  https://stackoverflow.com/questions/25454734/what-is-the-difference-between-bigdecimal-movepointright-and-scalebypoweroften/25455000#25455000

    number:     1.2345;      the scale is  4 plain: 1.2345
    multiplied: 123450.0000; the scale is  4 plain: 123450.0000
    pointRight: 123450;      the scale is  0 plain: 123450
    scaleBy:    1.2345E+5;   the scale is -1 plain: 123450
    scaleBy.compareTo(multiplied): 0
    scaleBy.compareTo(pointRight): 0
    scaleBy.equals(multiplied): false
    scaleBy.equals(pointRight): false
 */
public class BigDecimalScale {
    public static void main(String... args) {
      long base = 12345;
      int scale = 4;

      BigDecimal number = BigDecimal.valueOf(base, scale);
      System.out.println("number:     " + number + ";      the scale is  " + number.scale() + " plain: " + number.toPlainString());
      BigDecimal multiplied = number.multiply(BigDecimal.valueOf(100000));
      System.out.println("multiplied: " + multiplied + "; the scale is  " + multiplied.scale() + " plain: " + multiplied.toPlainString());
      BigDecimal pointRight = number.movePointRight(5);
      System.out.println("pointRight: " + pointRight + ";      the scale is  " + pointRight.scale() + " plain: " + pointRight.toPlainString());
      BigDecimal scaleBy = number.scaleByPowerOfTen(5);
      System.out.println("scaleBy:    " + scaleBy + ";   the scale is " + scaleBy.scale() + " plain: " + scaleBy.toPlainString());
      System.out.println("scaleBy.compareTo(multiplied): "+ scaleBy.compareTo(multiplied));
      System.out.println("scaleBy.compareTo(pointRight): " + scaleBy.compareTo(pointRight));
      System.out.println("scaleBy.equals(multiplied): " + scaleBy.equals(multiplied));
      System.out.println("scaleBy.equals(pointRight): " + scaleBy.equals(pointRight));
    }
}
