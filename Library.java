package com.example.bookproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Library<T extends Media> {
    private List<T> mediaItems = new ArrayList<>();
    private List<LibraryObserver> observers = new ArrayList<>();
    private Type mediaListType; // Define Type for media list

    public Library(String jsonFilePath) {
        loadFromJson(jsonFilePath); // Load media items from JSON file on initialization
    }

    private void loadFromJson(String jsonFilePath) {
        try (FileReader reader = new FileReader(jsonFilePath)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            Gson gson = new Gson();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                String type = jsonObject.get("type").getAsString();
                switch (type) {
                    case "book":
                        Book book = gson.fromJson(jsonObject, Book.class);
                        mediaItems.add((T) book);
                        break;
                    case "movie":
                        Movie movie = gson.fromJson(jsonObject, Movie.class);
                        mediaItems.add((T) movie);
                        break;
                    // Add cases for other media types as needed
                    default:
                        throw new IllegalArgumentException("Unknown media type: " + type);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read the JSON file: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Failed to parse the JSON file. Ensure it is an array of media objects.");
        }
    }

    public void addMedia(T media) {
        mediaItems.add(media);
        notifyObservers(new LibraryEvent("New Media Added", media));
    }

    public void updateMediaPrice(String mediaTitle, double newPrice) {
        for (T media : mediaItems) {
            if (media.getTitle().equalsIgnoreCase(mediaTitle)) {
                media.updatePrice(newPrice);
                notifyObservers(new LibraryEvent("Price Updated", media));
                break;
            }
        }
    }

    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(LibraryEvent event) {
        for (LibraryObserver observer : observers) {
            observer.updateEvent(event);
        }
    }

    public void displayAllMedia() {
        if (mediaItems.isEmpty()) {
            System.out.println("No media available.");
        } else {
            mediaItems.forEach(Media::displayMediaInfo);
        }
    }

    public void saveToJson(String jsonFilePath) {
        try (FileWriter writer = new FileWriter(jsonFilePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonArray jsonArray = new JsonArray();
            for (T media : mediaItems) {
                JsonObject jsonObject = gson.toJsonTree(media).getAsJsonObject();
                jsonObject.addProperty("type", determineMediaType(media)); // Add type field
                jsonArray.add(jsonObject);
            }
            gson.toJson(jsonArray, writer);
        } catch (IOException e) {
            System.err.println("Failed to save to the JSON file: " + e.getMessage());
        }
    }

    private String determineMediaType(T media) {
        if (media instanceof Book) {
            return "book";
        } else if (media instanceof Movie) {
            return "movie";
        }
        // Add other media types as needed
        throw new IllegalArgumentException("Unknown media type: " + media.getClass().getSimpleName());
    }
}
