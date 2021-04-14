package model;

import java.util.Arrays;

public class Address
{
    private String zipcode;

    private double[] coord;

    private String street;

    private String building;

    public String getZipcode ()
    {
        return zipcode;
    }

    public void setZipcode (String zipcode)
    {
        this.zipcode = zipcode;
    }

    public double[] getCoord ()
    {
        return coord;
    }

    public void setCoord (double[] coord)
    {
        this.coord = coord;
    }

    public String getStreet ()
    {
        return street;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getBuilding ()
    {
        return building;
    }

    public void setBuilding (String building)
    {
        this.building = building;
    }

	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + ", coord=" + Arrays.toString(coord) + ", street=" + street
				+ ", building=" + building + "]";
	}

}