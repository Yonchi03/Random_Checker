package Project;

abstract class Building {

    //Fields
    private final float area;
    private final String address;

    //Constructor
    protected Building(float area, String address) {
        this.area = area;
        this.address = address;
    }

    //Getters
    public float getArea() { return area; }
    public String getAddress() { return address; }
}