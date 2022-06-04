package com;

import app.LocaleExplore;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales extends CommandBase {

    public DisplayLocales(String[] args) {
        super(args);
    }

    @Override
    public Locale execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle(LocaleExplore.baseName, locale);

        System.out.println(messages.getString("locales") + " ro, us");
        return locale;
    }
}
