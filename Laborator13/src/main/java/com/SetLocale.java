package com;

import app.LocaleExplore;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale extends CommandBase {
    public SetLocale(String[] args) {
        super(args);
    }

    @Override
    public Locale execute(Locale locale) {

        switch (args[0]) {
            case "ro":
                locale = Locale.forLanguageTag("ro-RO");
                break;

            default:
            case "us":
                locale = Locale.getDefault();
        }

        ResourceBundle messages = ResourceBundle.getBundle(LocaleExplore.baseName, locale);
        Object[] arguments = {args[0]};

        System.out.println(new MessageFormat(messages.getString("locale.set")).format(arguments));

        return locale;
    }
}
