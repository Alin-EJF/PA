package com;

import java.util.Locale;

public abstract class CommandBase {
    protected String[] args;

    public CommandBase(String[] args) {
        this.args = args;
    }

    public abstract Locale execute(Locale locale);
}
