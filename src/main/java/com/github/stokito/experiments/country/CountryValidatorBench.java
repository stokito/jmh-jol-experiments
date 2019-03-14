package com.github.stokito.experiments.country;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.openjdk.jmh.annotations.Mode.Throughput;
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
 *
 *
 * # JMH version: 1.21
 * # VM version: JDK 11.0.2, OpenJDK 64-Bit Server VM, 11.0.2+9-LTS
 * # VM invoker: /usr/lib/jvm/zulu-11-amd64/bin/java
 * # VM options: <none>
 * # Warmup: 5 iterations, 10 s each
 * # Measurement: 5 iterations, 10 s each
 * # Timeout: 10 min per iteration
 * # Threads: 1 thread, will synchronize iterations
 * # Benchmark mode: Throughput, ops/time
 *
 * Benchmark                              Mode  Cnt     Score   Error   Units
 * CountryValidatorBench.baseline         thrpt   25  1151.736 ± 1.815  ops/ms
 * CountryValidatorBench.testHashSet      thrpt   25   523.678 ± 17.739  ops/ms
 * CountryValidatorBench.testInt          thrpt   25   251.990 ± 1.729  ops/ms
 * CountryValidatorBench.testSet          thrpt   25   100.394 ± 1.603  ops/ms
 * CountryValidatorBench.testShort        thrpt   25   246.058 ± 2.419  ops/ms
 * CountryValidatorBench.testShortLinear  thrpt   25    71.698 ± 1.227  ops/ms
 * CountryValidatorBench.testStr          thrpt   25    57.068 ± 0.090  ops/ms
 */
@State(Scope.Thread)
public class CountryValidatorBench {
  private static final String[] ISO_COUNTRIES = Locale.getISOCountries();

  @Setup(Level.Trial)
  public void setup() {

  }

  @Benchmark
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void baseline(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(isoCountry.hashCode());
    }
  }

/*
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void baselineReverse(Blackhole bh) {
    for (int i = ISO_COUNTRIES.length - 1; i >= 0; i--) {
      bh.consume(ISO_COUNTRIES[i]);
    }
  }
*/

  /*
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
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void testSet(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeSet(isoCountry));
    }
  }

  @Benchmark
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void testHashSet(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeHashSet(isoCountry));
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

/*
  @Benchmark
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void testInt(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeInt(isoCountry));
    }
  }
*/

  @Benchmark
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void testShort(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeShort(isoCountry));
    }
  }

  @Benchmark
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void testShortLinear(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeShortLinear(isoCountry));
    }
  }

  @Benchmark
  @BenchmarkMode(Throughput)
  @OutputTimeUnit(MILLISECONDS)
  public void testStr(Blackhole bh) {
    for (String isoCountry : ISO_COUNTRIES) {
      bh.consume(CountryValidator.isValidCountryCodeStr(isoCountry));
    }
  }

/*
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testIntReverse(Blackhole bh) {
    for (int i = ISO_COUNTRIES.length - 1; i >= 0; i--) {
      bh.consume(CountryValidator.isValidCountryCodeInt(ISO_COUNTRIES[i]));
    }
  }
*/

/*
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
