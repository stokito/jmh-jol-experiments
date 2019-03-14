package com.github.stokito.experiments.country.hashset;
import static java.util.Arrays.asList;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class CountryValidator {
  private static final Set<String> COUNTRIES = new TreeSet<>(asList(Locale.getISOCountries()));

  public static boolean isValidCountryCode(String countryCode) {
    return countryCode != null && COUNTRIES.contains(countryCode);
  }
}