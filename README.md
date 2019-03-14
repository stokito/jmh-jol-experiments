# jmh-jol-experiments
Java experiments with JMH benchmarks and memory layout

JOL (Java Object Layout) is the tiny toolbox to analyze object layout schemes in JVMs
https://openjdk.java.net/projects/code-tools/jol/

JMH is a Java harness for building, running, and analysing nano/micro/milli/macro benchmarks written in Java and other languages targetting the JVM.
https://openjdk.java.net/projects/code-tools/jmh/

To run benchmark do

    mvn clean install
    java -jar target/benchmarks.jar -wi 1 -wf 1 -tu ms -i 1 -foe true -gc true CountryValidatorBench

## BigDecimal scale
http://vanillajava.blogspot.com/2014/07/if-bigdecimal-is-answer-it-must-have.html

https://stackoverflow.com/questions/21298457/which-method-will-be-better-when-multiply-100-with-bigdecimal
