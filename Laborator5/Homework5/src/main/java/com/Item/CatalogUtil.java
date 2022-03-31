package com.Item;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.INDENT_OUTPUT,true); //indentare
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);  //nu afiseaza campurile cu null

        mapper.writeValue(
                new File(path),
                catalog);
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
                new File(path),
                Catalog.class);
    }

    public static void view(Item item) {
        System.out.println(item.toString());
    }
}
