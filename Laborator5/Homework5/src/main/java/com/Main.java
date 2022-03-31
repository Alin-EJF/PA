package com;



import com.items.Article;
import com.items.Book;
import com.Item.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        try {
            app.testCreateSave();
            app.testLoadView();
        }
        catch (IOException | InvalidCatalogException e) {
            System.err.println("We caught exception: "+ e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Something went wrong!");
        }





    }

    private void testCreateSave() throws Exception {
        Catalog catalog = new Catalog("MyRefs");
        var article = new Article("article1");
        var book = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1973, "Donald E. Knuth");
        catalog.add(book);
        catalog.add(new Book("knuth68", 1973));
        catalog.add(article);

        CatalogUtil.save(catalog, "C:\\Users\\Alin\\Desktop\\catalog.json");

        catalog.view("https://docs.oracle.com/javase/specs/jls/se17/html/index.html"); // merge separat asta
        Report report = new Report();   //merge separat asta
        report.execute(catalog);

       // Info info=new Info();
        //info.execute(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Alin\\Desktop\\catalog.json");
        CatalogUtil.view(catalog.findById("knuth68"));
    }


}
