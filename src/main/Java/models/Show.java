package models;

public class Show extends VideoMedia {

    public Show(String title, String length, boolean available){
        super(title, length, available);
    }

    @Override
    public String getLength() {
        return super.getLength() + " Episodes";
    }
}
