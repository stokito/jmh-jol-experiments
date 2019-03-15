package com.github.stokito.experiments.country;

import static com.github.stokito.experiments.country.CountryValidator.COUNTRIES_HASHSET;
import static com.github.stokito.experiments.country.CountryValidator.COUNTRIES_INT;
import static com.github.stokito.experiments.country.CountryValidator.COUNTRIES_SET;
import static com.github.stokito.experiments.country.CountryValidator.COUNTRIES_SHORT;
import static com.github.stokito.experiments.country.CountryValidator.COUNTRIES_STR;
import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.commons.collections4.map.HashedMap;
import org.junit.Ignore;
import org.junit.Test;
import org.openjdk.jol.info.GraphLayout;

public class CountryValidatorTest {

  /**
   * JDK11
   * java.lang.String@6dde5c8cd footprint:
   *      COUNT       AVG       SUM   DESCRIPTION
   *          1       520       520   [B
   *          1        24        24   java.lang.String
   *          2                 544   (total)
   *
   *
   * [I@769f71a9d footprint:
   *      COUNT       AVG       SUM   DESCRIPTION
   *          1      1016      1016   [I
   *          1                1016   (total)
   *
   *
   * [S@4c9f8c13d footprint:
   *      COUNT       AVG       SUM   DESCRIPTION
   *          1       520       520   [S
   *          1                 520   (total)
   *
   *
   * java.util.TreeSet@5ae50ce6d footprint:
   *      COUNT       AVG       SUM   DESCRIPTION
   *        249        24      5976   [B
   *          1        16        16   java.lang.Object
   *        249        24      5976   java.lang.String
   *          1        48        48   java.util.TreeMap
   *        249        40      9960   java.util.TreeMap$Entry
   *          1        16        16   java.util.TreeSet
   *        750               21992   (total)
   *
   *
   * java.util.HashSet@77eca502d footprint:
   *      COUNT       AVG       SUM   DESCRIPTION
   *        249        24      5976   [B
   *          1      2064      2064   [Ljava.util.HashMap$Node;
   *          1        16        16   java.lang.Object
   *        249        24      5976   java.lang.String
   *          1        48        48   java.util.HashMap
   *        249        32      7968   java.util.HashMap$Node
   *          1        16        16   java.util.HashSet
   *        751               22064   (total)
   *
   *
   * JDK8 layout is the same but since char is always two bytes so the string is twice bigger:
   * java.lang.String@59ec2012d footprint:
   *      COUNT       AVG       SUM   DESCRIPTION
   *          1      1016      1016   [C
   *          1        24        24   java.lang.String
   *          2                1040   (total)
   *
   *
   */
  @Test
  public void jol() {
    out.println(GraphLayout.parseInstance(COUNTRIES_STR).toFootprint());
    out.println(GraphLayout.parseInstance(COUNTRIES_INT).toFootprint());
    out.println(GraphLayout.parseInstance(COUNTRIES_SHORT).toFootprint());
    out.println(GraphLayout.parseInstance(COUNTRIES_SET).toFootprint());
    out.println(GraphLayout.parseInstance(COUNTRIES_HASHSET).toFootprint());
  }

  @Test
  public void allCodes() {
    //JDK11 - without AN code
    assertEquals("AdAeAfAgAiAlAmAoAqArAsAtAuAwAxAzBaBbBdBeBfBgBhBiBjBlBmBnBoBqBrBsBtBvBwByBzCaCcCdCfCgChCiCkClCmCnCoCrCuCvCwCxCyCzDeDjDkDmDoDzEcEeEgEhErEsEtFiFjFkFmFoFrGaGbGdGeGfGgGhGiGlGmGnGpGqGrGsGtGuGwGyHkHmHnHrHtHuIdIeIlImInIoIqIrIsItJeJmJoJpKeKgKhKiKmKnKpKrKwKyKzLaLbLcLiLkLrLsLtLuLvLyMaMcMdMeMfMgMhMkMlMmMnMoMpMqMrMsMtMuMvMwMxMyMzNaNcNeNfNgNiNlNoNpNrNuNzOmPaPePfPgPhPkPlPmPnPrPsPtPwPyQaReRoRsRuRwSaSbScSdSeSgShSiSjSkSlSmSnSoSrSsStSvSxSySzTcTdTfTgThTjTkTlTmTnToTrTtTvTwTzUaUgUmUsUyUzVaVcVeVgViVnVuWfWsYeYtZaZmZw", COUNTRIES_STR);
    //JDK8 - contains additional code AN which was removed in JDK11
//    assertEquals("AdAeAfAgAiAlAmAnAoAqArAsAtAuAwAxAzBaBbBdBeBfBgBhBiBjBlBmBnBoBqBrBsBtBvBwByBzCaCcCdCfCgChCiCkClCmCnCoCrCuCvCwCxCyCzDeDjDkDmDoDzEcEeEgEhErEsEtFiFjFkFmFoFrGaGbGdGeGfGgGhGiGlGmGnGpGqGrGsGtGuGwGyHkHmHnHrHtHuIdIeIlImInIoIqIrIsItJeJmJoJpKeKgKhKiKmKnKpKrKwKyKzLaLbLcLiLkLrLsLtLuLvLyMaMcMdMeMfMgMhMkMlMmMnMoMpMqMrMsMtMuMvMwMxMyMzNaNcNeNfNgNiNlNoNpNrNuNzOmPaPePfPgPhPkPlPmPnPrPsPtPwPyQaReRoRsRuRwSaSbScSdSeSgShSiSjSkSlSmSnSoSrSsStSvSxSySzTcTdTfTgThTjTkTlTmTnToTrTtTvTwTzUaUgUmUsUyUzVaVcVeVgViVnVuWfWsYeYtZaZmZw", COUNTRIES_STR);
  }

  @Test
  public void isValidCountryCode() {
    for (String isoCountry : CountryValidator.ISO_COUNTRIES) {
      assert CountryValidator.isValidCountryCode(isoCountry);
    }
    assert !CountryValidator.isValidCountryCode("XX");
  }

  @Test
  public void isValidCountryCodeInt() {
    for (String isoCountry : CountryValidator.ISO_COUNTRIES) {
      assert CountryValidator.isValidCountryCodeInt(isoCountry);
    }
    assert !CountryValidator.isValidCountryCode("XX");
  }

  @Test
  public void isValidCountryCodeShort() {
    for (String isoCountry : CountryValidator.ISO_COUNTRIES) {
      assertTrue(CountryValidator.isValidCountryCodeShort(isoCountry));
    }
    assertFalse(CountryValidator.isValidCountryCodeShort(null));
    assertFalse(CountryValidator.isValidCountryCodeShort("XX"));
    assertFalse(CountryValidator.isValidCountryCodeShort("ad"));
    assertFalse(CountryValidator.isValidCountryCodeShort("Ad"));
    assertFalse(CountryValidator.isValidCountryCodeShort("B%"));
    assertFalse(CountryValidator.isValidCountryCodeShort("Łń"));
  }

  @Test
  public void isValidCountryCodeStr() {
    for (String isoCountry : CountryValidator.ISO_COUNTRIES) {
      assert CountryValidator.isValidCountryCodeStr(isoCountry);
    }
    assert !CountryValidator.isValidCountryCode("XX");
  }

  @Test
  public void isValidCountryCodeSet() {
    for (String isoCountry : CountryValidator.ISO_COUNTRIES) {
      assert CountryValidator.isValidCountryCodeSet(isoCountry);
    }
    assert !CountryValidator.isValidCountryCode("XX");
  }

  public static String samehash(String s, int level) {
    if (s.length() < 2)
      return s;
    String sub2 = s.substring(0, 2);
    char c0 = sub2.charAt(0);
    char c1 = sub2.charAt(1);
    c0 = (char) (c0 + level);
    c1 = (char) (c1 - 31 * level);
    String newsub2 = new String(new char[] { c0, c1 });
    String re =  newsub2 + s.substring(2);
    return re;
  }

  @Ignore
  @Test
  public void name() {
    HashSet<Integer> hashes = new HashSet<>(25 * 25);
    int allPermutations = 0;
    for (char c1 = 'A'; c1 < 'Z'; c1++) {
      for (char c2 = 'A'; c2 < 'Z'; c2++) {
        allPermutations++;
        String str = "" + c1 + "" + c2;
        if (!hashes.add(str.hashCode())) {
          out.println(str);
        }
      }
    }
    out.println(allPermutations);
    out.println(hashes.size());
  }
}