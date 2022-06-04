package com;

import app.LocaleExplore;

import java.util.Locale;
import java.util.ResourceBundle;

public class Quit extends CommandBase{
    public Quit(String[] args) {
        super(args);
    }

    @Override
    public Locale execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle(LocaleExplore.baseName, locale);
        System.out.println(messages.getString("quit"));

        LocaleExplore.running = false;
        return locale;
    }
}
