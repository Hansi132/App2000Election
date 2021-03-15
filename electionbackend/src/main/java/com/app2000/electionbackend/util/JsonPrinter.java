package com.app2000.electionbackend.util;

import com.google.gson.Gson;

public class JsonPrinter {
    public static String print(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
