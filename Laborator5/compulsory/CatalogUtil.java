package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();
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
