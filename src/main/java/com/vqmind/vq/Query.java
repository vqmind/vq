package com.vqmind.vq;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.Map;
import java.util.TreeMap;

public class Query {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Map<String, String> collector = new TreeMap<>();

    public Query(String jsonContent) {
        JsonElement root = gson.fromJson(jsonContent, JsonElement.class);
        this.traverse(root, "$");
        //for (String key: collector.keySet()) {
        //    System.out.println(key + "=" + collector.get(key));
        //}
    }

    private void traverse(JsonElement elem, String prefix) {
        if (elem.isJsonPrimitive()) {
            collector.put(prefix, elem.getAsJsonPrimitive().getAsString());
            collector.put(String.format("pretty(%s)", prefix), gson.toJson(elem));
        } else if (elem.isJsonArray()) {
            collector.put(prefix, elem.toString());
            collector.put(String.format("pretty(%s)", prefix), gson.toJson(elem));
            for (int index = 0; index < elem.getAsJsonArray().size(); index++) {
                this.traverse(elem.getAsJsonArray().get(index), prefix + "[" + index + "]");
            }
        } else if (elem.isJsonObject()) {
            collector.put(prefix, elem.toString());
            collector.put(String.format("pretty(%s)", prefix), gson.toJson(elem));
            for (String key : elem.getAsJsonObject().keySet()) {
                this.traverse(elem.getAsJsonObject().get(key), prefix + "." + key);
            }
        }
    }
//
//    private String format(JsonElement elem) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        return gson.toJson(elem);
//    }

    public String find(String path) {
        return collector.get(path);
    }
}
