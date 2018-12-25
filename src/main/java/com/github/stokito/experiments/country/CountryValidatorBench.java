package com.github.stokito.experiments.country;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

/**
 * Benchmark                               Mode  Cnt    Score      Error   Units
 * CountryValidatorBench.baseline         thrpt    5  924.929 ± 1069.319  ops/ms
 * CountryValidatorBench.baselineReverse  thrpt    5  748.684 ± 1131.896  ops/ms
 * CountryValidatorBench.test             thrpt    5   91.082 ±   50.104  ops/ms
 * CountryValidatorBench.testReverse      thrpt    5   80.600 ±   91.820  ops/ms
 * CountryValidatorBench.testSet          thrpt    5  403.769 ±  308.207  ops/ms
 * CountryValidatorBench.testSetReverse   thrpt    5  490.557 ±  138.109  ops/ms
 *
 *
 *
 * Benchmark                               Mode  Cnt     Score    Error   Units
 * CountryValidatorBench.baseline         thrpt   25  1183.324 ±  6.348  ops/ms
 * CountryValidatorBench.baselineReverse  thrpt   25  1165.580 ± 27.476  ops/ms
 * CountryValidatorBench.test             thrpt   25   106.091 ±  0.561  ops/ms
 * CountryValidatorBench.testInt          thrpt   25   148.105 ±  0.590  ops/ms
 * CountryValidatorBench.testIntReverse   thrpt   25   147.676 ±  0.473  ops/ms
 * CountryValidatorBench.testNew          thrpt   25    21.255 ±  0.192  ops/ms
 * CountryValidatorBench.testReverse      thrpt   25   105.665 ±  0.332  ops/ms
 * CountryValidatorBench.testSet          thrpt   25   554.652 ±  0.731  ops/ms
 * CountryValidatorBench.testSetNew       thrpt   25     0.933 ±  0.014  ops/ms
 * CountryValidatorBench.testSetReverse   thrpt   25   553.115 ±  1.765  ops/ms
 */
@State(Scope.Thread)
public class CountryValidatorBench {
  private static final String[] ISO_COUNTRIES = Locale.getISOCountries();

  @Setup(Level.Trial)
  public void setup() {

  }

/*
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void baseline(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(isoCountry);
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void baselineReverse(Blackhole bh) {
    for (int i = ISO_COUNTRIES.length - 1; i >= 0; i--) {
      bh.consume(ISO_COUNTRIES[i]);
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void test(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCode(isoCountry));
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testReverse(Blackhole bh) {
    for (int i = ISO_COUNTRIES.length - 1; i >= 0; i--) {
      bh.consume(CountryValidator.isValidCountryCode(ISO_COUNTRIES[i]));
    }
  }
*/
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testSet(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeSet(isoCountry));
    }
  }
/*
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testSetReverse(Blackhole bh) {
    for (int i = ISO_COUNTRIES.length - 1; i >= 0; i--) {
      bh.consume(CountryValidator.isValidCountryCodeSet(ISO_COUNTRIES[i]));
    }
  }
*/
/*  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testInt(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeInt(isoCountry));
    }
  }*/
/*
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testIntReverse(Blackhole bh) {
    for (int i = ISO_COUNTRIES.length - 1; i >= 0; i--) {
      bh.consume(CountryValidator.isValidCountryCodeInt(ISO_COUNTRIES[i]));
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testNew(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeNew(isoCountry));
    }
  }


  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testSetNew(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeSetNew(isoCountry));
    }
  }

*/


  /**
   * Benchmark                            Mode  Cnt    Score    Error   Units
   * CountryValidatorBench.testParseInt  thrpt    5  243.845 ± 18.978  ops/ms
   */
/*
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testParseInt(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      int intCode = Integer.parseInt(isoCountry, 36);
      bh.consume(intCode);
    }
  }
*/
}
