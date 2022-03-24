package com;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.items.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Book.class, name = "book"),
        @JsonSubTypes.Type(value = Article.class, name = "article"),
        @JsonSubTypes.Type(value = Dissertation.class, name = "dissertation"),
        @JsonSubTypes.Type(value = Journal.class, name = "journal"),
        @JsonSubTypes.Type(value = Report.class, name = "report")
})
public abstract class Item  implements Serializable {
    private final String id;
    private String title;
    private String location;  //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }



    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}
