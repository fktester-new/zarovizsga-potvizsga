package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{

    public static int CLEANING_PRICE = 100;

    private String address;
    private int area;
    private int numberOfFloors;
    private BuildingType type = BuildingType.OFFICE;

    public Office(String address, int area, int numberOfFloors) {
        this.address = address;
        this.area = area;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    @Override
    public BuildingType getType() {
        return type;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public int clean() {
        return CLEANING_PRICE * area * numberOfFloors;
    }
}
