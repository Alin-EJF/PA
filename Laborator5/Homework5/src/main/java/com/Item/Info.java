package com.Item;

import java.io.*;
import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;


public class Info {

    public void execute(Catalog catalog) throws Exception{

        if (catalog == null)
            throw new NullPointerException("A catalog has to be loaded first!");


        Item item = catalog.findById();
        if (item == null) {
            System.err.println("Item doesn't exist!");
            return;
        }

        Metadata metadata = getMetadata(item);
        if(metadata == null)
            return;

        for (String name : metadata.names())
            System.out.println(name + ": " + metadata.get(name));


    }


    public Metadata getMetadata(Item item) {
        try {
            InputStream stream = new FileInputStream(item.getLocation());
            Tika tika = new Tika();
            Metadata metadata = new Metadata();

            tika.parse(stream, metadata);
            return metadata;
        } catch (IOException e) {
            System.err.println(e.toString());
        }

        return null;
    }

    public void printMetadata() {
        for (var item : items) {
            System.out.println(item.getId());

            Metadata metadata = getMetadata(item);
            if (metadata == null)
                return;

            for (String name : metadata.names())
                System.out.println(name + ": " + metadata.get(name));

            System.out.println("\n");
        }
    }

}