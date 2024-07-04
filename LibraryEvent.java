package BooksPackage;

public class LibraryEvent {
	private String eventType;
    private Media media;

    public LibraryEvent(String eventType, Media media) {
        this.eventType = eventType;
        this.media = media;
    }

    public String getEventType() {
        return eventType;
    }

    public Media getMedia() {
        return media;
    }
}
