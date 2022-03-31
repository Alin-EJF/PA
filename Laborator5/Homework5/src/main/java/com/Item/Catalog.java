package com.Item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.Item.generics.AddCommand;
import com.Item.generics.ListCommand;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable, ListCommand, AddCommand {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(@JsonProperty("name") String name) {
        this.name = name;
    }

    /**
     * add: adds a new entry into the catalog;
     *
     * @param item
     */
    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * save: saves the catalog to an external file using JSON format; you may use Jackson or other library;
     *
     * @param path The path where we want to save the object
     */
    public void save(String path) throws IOException {
        CatalogUtil.save(this, path);
    }

    /**
     * load: loads the catalog from an external file.
     *
     * @param path The path to the catalog object
     */

    public void load(String path) throws IOException, InvalidCatalogException {
        Catalog catalog = CatalogUtil.load(path);
        this.name = catalog.name;
        this.items = catalog.items;
    }

    public void list() {
        System.out.println(items);
    }

    public void view(String path) throws IOException {

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(URI.create(path));
        } catch (Exception e) {
            try {
                desktop.open(new File(path));
            } catch (IOException ioException1) {
                System.out.println("nu merge nici cu path catre fisier");
            }
        }
    }




        public String getName () {
            return name;
        }

        public List<Item> getItems () {
            return items;
        }
        /**
         *  toString: a textual representation of the catalog;
         */
        @Override
        public String toString () {
            return "Catalog{" +
                    "name='" + name + '\'' +
                    ", items=" + items +
                    '}';
        }
    }

