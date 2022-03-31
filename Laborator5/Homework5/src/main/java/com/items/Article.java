package com.items;

import com.Item.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Article extends Item {

    @JsonCreator
    public Article(@JsonProperty("id")String id) {
        super(id);
    }
}
