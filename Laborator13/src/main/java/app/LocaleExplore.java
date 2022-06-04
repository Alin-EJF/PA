package app;

import com.*;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static final String baseName = "res.Messages";
   public static boolean running = true;

    public static void main(String[] args) {
        LocaleExplore app = new LocaleExplore();
        app.run();
    }

    private void run() {
        //Locale locale = Locale.forLanguageTag("ro");
        Locale locale = Locale.getDefault();
        ResourceBundle messages;



        Scanner keyboard = new Scanner(System.in);
        String line;

        while (running) {
            messages = ResourceBundle.getBundle(baseName, locale);

            System.out.println(messages.getString("prompt"));
            line = keyboard.nextLine();

            CommandBase command = parseCommand(line);
            locale = command.execute(locale);
        }
    }

    private CommandBase parseCommand(String line) {
        String[] splitLine = line.split(" ");

        if (splitLine.length == 1 && splitLine[0].equals("quit"))
            return new Quit(null);

        if (splitLine.length == 1 && splitLine[0].equals("info"))
            return new Info(null);

        if (splitLine.length == 2 && splitLine[0].equals("display") && splitLine[1].equals("locales"))
            return new DisplayLocales(null);

        if (splitLine.length == 3 && splitLine[0].equals("set") && splitLine[1].equals("locale")
                && (splitLine[2].equals("ro") || splitLine[2].equals("us")))
            return new SetLocale(new String[]{splitLine[2]});

        return new Invalid(null);
    }
}
