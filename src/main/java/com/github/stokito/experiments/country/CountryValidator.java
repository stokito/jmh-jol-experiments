package com.github.stokito.experiments.country;

import static java.util.Arrays.asList;
import static java.util.Arrays.binarySearch;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.TreeSet;

public class CountryValidator {
  public static final String[] ISO_COUNTRIES = Locale.getISOCountries();
  public static final int[] COUNTRIES_INT = new int[ISO_COUNTRIES.length];
//  public static final HashSet<String> COUNTRIES_SET = new HashSet<>(asList(ISO_COUNTRIES));
  public static final TreeSet<String> COUNTRIES_SET = new TreeSet<>(asList(ISO_COUNTRIES));

  static {
    for (int i = 0; i < ISO_COUNTRIES.length; i++) {
//      COUNTRIES_INT[i] = Integer.parseInt(ISO_COUNTRIES[i], 36);
      COUNTRIES_INT[i] = ISO_COUNTRIES[i].hashCode();
    }
  }

  public static boolean isValidCountryCode(String countryCode) {
    return binarySearch(ISO_COUNTRIES, countryCode) >= 0;
  }

  public static boolean isValidCountryCodeSet(String countryCode) {
    return COUNTRIES_SET.contains(countryCode);
  }

  public static boolean isValidCountryCodeNew(String countryCode) {
    String[] ISO_COUNTRIES = Locale.getISOCountries();
    return binarySearch(ISO_COUNTRIES, countryCode) >= 0;
  }

  public static boolean isValidCountryCodeSetNew(String countryCode) {
    HashSet<String> COUNTRIES_SET = new HashSet<>(asList(Locale.getISOCountries()));
    return COUNTRIES_SET.contains(countryCode);
  }

  public static boolean isValidCountryCodeInt(String countryCode) {
//    int intCode = Integer.parseInt(countryCode, 36);
    int intCode = countryCode.hashCode();
    return binarySearch(COUNTRIES_INT, intCode) >= 0;
  }

}
