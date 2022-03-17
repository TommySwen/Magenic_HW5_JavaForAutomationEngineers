package models;

//VideoMedia is the basics of what a video may be
public class VideoMedia {

    private String title;
    private String length;
    private boolean available;

    public VideoMedia(){
    }

    public VideoMedia(String title, String length, boolean available){
        this.title = title;
        this.length = length;
        this.available = available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public boolean getAvailable() {
        return available;
    }
}
