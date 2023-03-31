package com.bookstore.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;



@Document(indexName="cf_etf", type="_doc")
public class Cf_etf {
    @Id
    private String symbol;
    private String fund_name;
    private int rating;
    private String morningstar_category;
    private String category;
    private String family;
    private String market_cap;
    private String description;
    private String exchange;
//    ...
}