package com.github.stokito.experiments.country;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Locale;
import java.util.TreeSet;
import org.junit.Test;
import org.openjdk.jol.info.GraphLayout;

/**
 *      COUNT       AVG       SUM   DESCRIPTION
 *          1        16        16   com.github.stokito.jsmallmap.CountryValidatorTest
 *          1                  16   (total)
 *
 *
 * com.github.stokito.jsmallmap.CountryValidatorTest@15327b79d footprint:
 *      COUNT       AVG       SUM   DESCRIPTION
 *        250        24      6000   [C
 *          1      1016      1016   [Ljava.lang.String;
 *          1        16        16   com.github.stokito.jsmallmap.CountryValidatorTest
 *        250        24      6000   java.lang.String
 *        502               13032   (total)
 *
 * 101,8125 Kib
 *
 * com.github.stokito.jsmallmap.CountryValidatorTest@15327b79d footprint:
 *      COUNT       AVG       SUM   DESCRIPTION
 *        250        24      6000   [C
 *          1      2064      2064   [Ljava.util.HashMap$Node;
 *          1        16        16   com.github.stokito.jsmallmap.CountryValidatorTest
 *          1        16        16   java.lang.Object
 *        250        24      6000   java.lang.String
 *          1        48        48   java.util.HashMap
 *        250        32      8000   java.util.HashMap$Node
 *          1        16        16   java.util.HashSet
 *        755               22160   (total)
 *
 * 173,125 Kib
 *
 *
 * com.github.stokito.jsmallmap.CountryValidatorTest@22927a81d footprint:
 *      COUNT       AVG       SUM   DESCRIPTION
 *        250        24      6000   [C
 *          1        16        16   com.github.stokito.jsmallmap.CountryValidatorTest
 *          1        16        16   java.lang.Object
 *        250        24      6000   java.lang.String
 *          1        48        48   java.util.TreeMap
 *        250        40     10000   java.util.TreeMap$Entry
 *          1        16        16   java.util.TreeSet
 *        754               22096   (total)
 *
 */
public class CountryValidatorTest {
//  public final String[] ISO_COUNTRIES = Locale.getISOCountries();
//  public final HashSet<String> COUNTRIES_SET = new HashSet<>(asList(Locale.getISOCountries()));
  public final TreeSet<String> COUNTRIES_SET = new TreeSet<>(asList(Locale.getISOCountries()));

  @Test
  public void isValidCountryCode() {
    for (String isoCountry : CountryValidator.ISO_COUNTRIES) {
      assert CountryValidator.isValidCountryCode(isoCountry);
    }
    out.println(GraphLayout.parseInstance(this).toFootprint());
  }

  @Test
  public void isValidCountryCodeInt() {
    for (String isoCountry : CountryValidator.ISO_COUNTRIES) {
      assert CountryValidator.isValidCountryCodeInt(isoCountry);
    }
    out.println(GraphLayout.parseInstance(this).toFootprint());
  }

  @Test
  public void isValidCountryCodeSet() {
    for (String isoCountry : CountryValidator.ISO_COUNTRIES) {
      assert CountryValidator.isValidCountryCodeSet(isoCountry);
    }
//    out.println(GraphLayout.parseInstance(CountryValidator.class).toFootprint());
  }
}