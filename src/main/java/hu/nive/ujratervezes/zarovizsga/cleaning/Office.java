package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{

    private String address;
    private int area;
    private int numberOfFloors;

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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public int clean() {
        return 100 * area * numberOfFloors;
    }
}
