package main.java.model;

public class FoodItem {
    private String id;
    private String foodName;
    private String expiryDate;
    private String foodType;
    private String imagePath;
    private double latitude;
    private double longitude;

    // Constructor
    public FoodItem() {
    }

    // ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Food Name
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    // Expiry Date
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Food Type
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    // Image Path
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Latitude
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Longitude
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // Optional: toString() for debugging
    @Override
    public String toString() {
        return "FoodItem{" +
                "id='" + id + '\'' +
                ", foodName='" + foodName + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", foodType='" + foodType + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}