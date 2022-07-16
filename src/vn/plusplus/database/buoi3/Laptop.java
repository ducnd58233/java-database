package vn.plusplus.database.buoi3;

public class Laptop {
    private String name;
    private String maker;
    private Long price;
    private int sold;
    private String screenResolution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", sold=" + sold +
                ", screenResolution='" + screenResolution + '\'' +
                '}';
    }
}
