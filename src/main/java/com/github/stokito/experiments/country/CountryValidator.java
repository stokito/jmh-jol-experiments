package com.github.stokito.experiments.country;

import static java.util.Arrays.asList;
import static java.util.Arrays.binarySearch;
import static org.apache.commons.lang3.ArrayUtils.indexOf;
import static org.apache.commons.lang3.ArrayUtils.removeElement;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

/**
 * https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
 *
 * https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
 */
public class CountryValidator {
  // JDK8 had the AN code and it was removed in JDK11. To make test results similar on both JDK let's remove it
  public static final String[] ISO_COUNTRIES = removeElement(Locale.getISOCountries(), "AN");
  public static final String COUNTRIES_STR = initStr(ISO_COUNTRIES);
  public static final int[] COUNTRIES_INT = initIntArray(ISO_COUNTRIES);
  public static final short[] COUNTRIES_SHORT = initShortArray(ISO_COUNTRIES);
  public static final List<String> COUNTRIES_LIST = asList(ISO_COUNTRIES);
  public static final HashSet<String> COUNTRIES_HASHSET = new HashSet<>(COUNTRIES_LIST);
  public static final TreeSet<String> COUNTRIES_SET = new TreeSet<>(COUNTRIES_LIST);

  private static int[] initIntArray(String[] isoCountries) {
    int[] countriesInt = new int[isoCountries.length];
    for (int i = 0; i < isoCountries.length; i++) {
      String isoCountry = isoCountries[i];
//      if (isoCountry.equals("AN")) continue;
      countriesInt[i] = isoCountry.hashCode();
    }
    return countriesInt;
  }

  private static short[] initShortArray(String[] isoCountries) {
    short[] countriesShort = new short[isoCountries.length];
    for (int i = 0; i < isoCountries.length; i++) {
      String isoCountry = isoCountries[i];
//      if (isoCountry.equals("AN")) continue;
      countriesShort[i] = (short) isoCountry.hashCode();
    }
    return countriesShort;
  }

  private static String initStr(String[] isoCountries) {
    StringBuilder sb = new StringBuilder(ISO_COUNTRIES.length * 2);
    for (String isoCountry : isoCountries) {
      //      if (isoCountry.equals("AN")) continue;
      sb.append(isoCountry.charAt(0)).append(Character.toLowerCase(isoCountry.charAt(1)));
    }
    return sb.toString();
  }

  public static boolean isValidCountryCode(String countryCode) {
    return binarySearch(ISO_COUNTRIES, countryCode) >= 0;
  }

  public static boolean isValidCountryCodeSet(String countryCode) {
    return COUNTRIES_SET.contains(countryCode);
  }

  public static boolean isValidCountryCodeHashSet(String countryCode) {
    return COUNTRIES_HASHSET.contains(countryCode);
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
    int intCode = countryCode.hashCode();
    return binarySearch(COUNTRIES_INT, intCode) >= 0;
  }

  public static boolean isValidCountryCodeShort(String countryCode) {
    short needle = (short) countryCode.hashCode();
    return binarySearch(COUNTRIES_SHORT, needle) >= 0;
  }

  public static boolean isValidCountryCodeShortLinear(String countryCode) {
    short needle = (short) countryCode.hashCode();
    return indexOf(COUNTRIES_SHORT, needle) >= 0;
  }

  public static boolean isValidCountryCodeStr(String countryCode) {
    // String needle = String.valueOf(new char[]{countryCode.charAt(0), Character.toLowerCase(countryCode.charAt(1))});
    // A little bit faster hack assuming that we are dealing with ASCII https://stackoverflow.com/questions/3696441/converting-a-char-to-uppercase
    // To upper case: 'l' & 0x5f To lowerChar = 'L' ^ 0x20
    char lowercase = (char) (countryCode.charAt(1) ^ 0x20);
    String needle = String.valueOf(new char[]{countryCode.charAt(0), lowercase});
    return COUNTRIES_STR.contains(needle);
  }

  public static boolean isInvalidCountryCode(String countryCode) {
    return countryCode.equals("AA") || countryCode.equals("ZZ") || countryCode.charAt(0) == 'X';
  }

}
