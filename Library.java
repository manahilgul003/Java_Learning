package BooksPackage;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends Media> {
    private List<T> mediaItems = new ArrayList<>();
    private List<ObserverPattern> observers = new ArrayList<>();

    public void addMedia(T media) {
        mediaItems.add(media);
        notifyObservers(new LibraryEvent("New media added", media));
    }

    public void updateMediaPrice(T media, double newPrice) {
        media.updatePrice(newPrice);
        notifyObservers(new LibraryEvent("Media price updated", media));
    }

    public void displayAllMedia() {
        mediaItems.forEach(Media::displayInfo);
    }

    public List<T> getAllMedia() {
        return mediaItems;
    }

    public void addObserver(ObserverPattern observer) {
        observers.add(observer);
    }

    private void notifyObservers(LibraryEvent event) {
        for (ObserverPattern observer : observers) {
            observer.updateEvent(event);
        }
    }
}
