package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {

            JSONObject jObject = new JSONObject(json);
            JSONObject jName = jObject.getJSONObject("name");
            JSONArray jAlsoKnownAs = jName.getJSONArray("alsoKnownAs");
            JSONArray jIngredients = jObject.getJSONArray("ingredients");

            ArrayList<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < jAlsoKnownAs.length(); i++) {
                alsoKnownAs.add(jAlsoKnownAs.getString(i));
            }

            ArrayList<String> ingredients = new ArrayList<>();
            for (int i = 0; i < jIngredients.length(); i++) {
                ingredients.add(jIngredients.getString(i));
            }

            Sandwich sandwich = new Sandwich(jName.getString("mainName"),
                    alsoKnownAs, jObject.getString("placeOfOrigin"),
                    jObject.getString("description"),
                    jObject.getString("image"),
                    ingredients);

            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
