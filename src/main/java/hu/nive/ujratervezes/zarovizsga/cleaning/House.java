package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable{

    public static int CLEANING_PRICE = 80;
    private String address;
    private int area;
    private BuildingType type = BuildingType.HOUSE;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    @Override
    public BuildingType getType() {
        return type;
    }

    @Override
    public int clean() {
        return CLEANING_PRICE * area;
    }
}
