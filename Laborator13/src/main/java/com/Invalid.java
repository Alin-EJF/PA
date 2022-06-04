package com;

import app.LocaleExplore;

import java.util.Locale;
import java.util.ResourceBundle;

public class Invalid extends CommandBase {
    public Invalid(String[] args) {
        super(args);
    }

    @Override
    public Locale execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle(LocaleExplore.baseName, locale);
        System.out.println(messages.getString("invalid"));
        return locale;
    }
}
