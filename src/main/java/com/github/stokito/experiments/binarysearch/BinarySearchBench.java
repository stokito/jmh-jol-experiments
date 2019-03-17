package com.github.stokito.experiments.binarysearch;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.openjdk.jmh.annotations.Mode.Throughput;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

/**
 *
 */
@State(Scope.Thread)
public class BinarySearchBench {

  private static final byte[] HAYSTACK = new byte[]{
    0, 1, 2, 3, 4, 5, 6, 7,
    8, 9, 10, 11, 12, 13, 14, 15,
    16, 17, 18, 19, 20, 21, 22, 23,
    24, 25, 26, 27, 28, 29, 30, 31
  };

  @Setup(Level.Trial)
  public void setup() {

  }

  @Benchmark
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void binarySearch0(Blackhole bh) {
    bh.consume(BinarySearch.binarySearch0(HAYSTACK, 0, 33, (byte) 31));
  }

  @Benchmark
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void binarySearch1(Blackhole bh) {
    bh.consume(BinarySearch.binarySearch1(HAYSTACK, 0, 33, (byte) 31));
  }

}
