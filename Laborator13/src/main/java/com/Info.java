package com;

import app.LocaleExplore;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info extends CommandBase {
    public Info(String[] args) {
        super(args);
    }

    @Override
    public Locale execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle(LocaleExplore.baseName, locale);
        Object[] arguments = {locale.getCountry()};


        Currency currency = Currency.getInstance(locale);
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        System.out.println(new MessageFormat(messages.getString("info")).format(arguments));
        System.out.println("Country: " + locale.getCountry() + " (" + locale.getDisplayCountry() + ")");
        System.out.println("Language: " + locale.getLanguage() + " (" + locale.getDisplayLanguage() + ")");
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName() + ")");
        System.out.println("Weekdays: " + Arrays.toString(dateFormatSymbols.getWeekdays()));
        System.out.println("Months: " + Arrays.toString(dateFormatSymbols.getMonths()));
        System.out.println("Today: " + LocalDate.now().getMonth().getDisplayName(TextStyle.FULL,locale));



        return locale;
    }
}
