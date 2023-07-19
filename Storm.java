/**
 * @author Pushkar Taday
 */

/**
 * This class represents a storm with a name , precipitation, windSpeed and date.
 */

import java.io.Serializable;

public class Storm implements Serializable {

    private String name;
    private double precipitation;
    private double windSpeed;
    String Date;

    /**
     * This is a parameterized constructor which gets invoked when the object of the class gets instantiated with the given set of parameters
     * @param name
     * name of the storm
     * @param precipitation
     * rainfall of the storm
     * @param windSpeed
     * wind speed of the storm
     * @param Date
     * date of the storm
     */
    Storm(String name,double precipitation,double windSpeed,String Date)
    {
        this.name=name;
        this.precipitation=precipitation;
        this.windSpeed=windSpeed;
        this.Date=Date;
    }

    /**
     *This is an accessor method for the name of the storm
     * @return
     * String name of the storm
     */
    public String getName() {
        return name;
    }

    /**
     * This is an accessor method for the precipitation of the storm
     * @return
     * precipitation of the storm
     */
    public double getPrecipitation() {
        return precipitation;
    }

    /**
     * This is an accessor method for the windspeed of the storm
     * @return
     * windspeed of the storm
     */

    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * This is an accessor method for the date of the storm
     * @return
     * date of the storm
     */

    public String getDate() {
        return Date;
    }

    /**
     * This is a mutator method for the name of the storm
     * @param name
     * name of the storm
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a mutator method for the precipitation of the storm
     * @param precipitation
     * precipitation of the storm
     */
    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * This is a mutator method for the windspeed of the storm
     * @param windSpeed
     * windspeed of the storm
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * This is a mutator method for the date of the storm
     * @param date
     * date of the storm
     */
    public void setDate(String date) {
        Date = date;
    }

    /**
     * This is a method which prints the description of the object
     * @return
     * string representation of the object
     */
    public String toString() {
        return String.format("%-20s%-15.1f%-15.1f%-20s", getName(), getWindSpeed(), getPrecipitation(),getDate());
    }
}
