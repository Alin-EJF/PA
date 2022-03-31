package com.Item;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Report {



    public void execute(Catalog catalog) throws Exception {
        Configuration cfg = new Configuration(new Version("2.3.23")); //new Version("2.3.23")

        cfg.setClassForTemplateLoading(Item.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        try {
            Template template = cfg.getTemplate("catalog.ftl");

            Map<String, Object> templateData = new HashMap<>();
            templateData.put("name", catalog.getName());
            templateData.put("items", catalog.getItems());

            StringWriter out = new StringWriter();

            template.process(templateData, out);

            BufferedWriter writer = new BufferedWriter(new FileWriter("catalog.html"));
            writer.write(out.getBuffer().toString());
            out.flush();
            writer.flush();

            System.out.println("Successfully generated report");

            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File("./catalog.html"));

        } catch (IOException | TemplateException e) {
            System.err.println(e.toString());
        }


    }
}
