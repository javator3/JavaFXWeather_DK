package pl.sda.openweather.model;

public class Weather {
    private Location location;
    private Current current;

    public void Weather(){

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
