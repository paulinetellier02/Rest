package org.libreapps.rest.obj;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Product {
    private final int id;
    private final String name;
    private final String type;
    private final double price;

    public Product(JSONObject jObject) {
        this.id =jObject.optInt("id");
        this.name = jObject.optString("name");
        this.type = jObject.optString("type");
        this.price = jObject.optDouble("price");
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getPrice() { return price; }
}