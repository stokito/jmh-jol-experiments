package com.github.stokito.experiments.country.arrayshort;

import static java.util.Arrays.binarySearch;
import java.util.Locale;

/**
 * Validator of country code.
 * Uses binary search over array of sorted country codes.
 * Country code has two ASCII letters so we need at least two bytes to represent the code.
 * Two bytes are represented in Java by short type. This is useful for us because we can use Arrays.binarySearch(short[] a, short needle)
 * Each country code is converted to short via countryCodeNeedle() function.
 *
 * Average speed of the method is 246.058 ops/ms which is twice slower than lookup over HashSet (523.678 ops/ms).
 * Complexity is O(log(N)) instead of O(1) for HashSet.
 * But it consumes only 520 bytes of RAM to keep the list of country codes instead of 22064 (> 21 Kb) to hold HashSet of country codes.
 */
public class CountryValidator {
  /** Sorted array of country codes converted to short */
  private static final short[] COUNTRIES_SHORT = initShortArray(Locale.getISOCountries());

  public static boolean isValidCountryCode(String countryCode) {
    if (countryCode == null) {
      return false;
    }
    short needle = countryCodeNeedle(countryCode);
    return binarySearch(COUNTRIES_SHORT, needle) >= 0;
  }

  /**
   * Country code has two ASCII letters so we need at least two bytes to represent the code.
   * Two bytes are represented in Java by short type. So we should convert two bytes of country code to short.
   * We can use something like:
   * short val = (short)(((hi & 0xFF) << 8) | (lo & 0xFF));
   * But in fact very similar logic is done inside of String.hashCode() function.
   * And what is even more important is that each string object already has cached hash code.
   * So for us the conversion of two letter country code to short can be immediately.
   * We can relay on String's hash code because it's specified in JLS
   **/
  private static short countryCodeNeedle(String countryCode) {
    return (short) countryCode.hashCode();
  }

  private static short[] initShortArray(String[] isoCountries) {
    short[] countriesShortArray = new short[isoCountries.length];
    for (int i = 0; i < isoCountries.length; i++) {
      String isoCountry = isoCountries[i];
      countriesShortArray[i] = countryCodeNeedle(isoCountry);
    }
    return countriesShortArray;
  }
}
