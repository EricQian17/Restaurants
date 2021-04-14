package model;

import java.util.Arrays;

public class Restaurant
{
    private Address address;

    private String restaurant_id;

    private String name;

    private String cuisine;

    private _id _id;

    private String borough;

    private Grades[] grades;
    
    private String simpleAddress;


	public Address getAddress ()
    {
        return address;
    }

    public void setAddress (Address address)
    {
        this.address = address;
    }

    public String getRestaurant_id ()
    {
        return restaurant_id;
    }

    public void setRestaurant_id (String restaurant_id)
    {
        this.restaurant_id = restaurant_id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCuisine ()
    {
        return cuisine;
    }

    public void setCuisine (String cuisine)
    {
        this.cuisine = cuisine;
    }

    public _id get_id ()
    {
        return _id;
    }

    public void set_id (_id _id)
    {
        this._id = _id;
    }

    public String getBorough ()
    {
        return borough;
    }

    public void setBorough (String borough)
    {
        this.borough = borough;
    }

    public Grades[] getGrades ()
    {
        return grades;
    }

    public void setGrades (Grades[] grades)
    {
        this.grades = grades;
    }
    public String getSimpleAddress() {
    	
    	simpleAddress = address.getBuilding()+" "+address.getStreet()+", "+address.getZipcode();
    	
		return simpleAddress;
	}

	public void setSimpleAddress(String simpleAddress) {
		this.simpleAddress = simpleAddress;
	}

	@Override
	public String toString() {
		return "Restaurant [address=" + address + ", restaurant_id=" + restaurant_id + ", name=" + name + ", cuisine="
				+ cuisine + ", _id=" + _id + ", borough=" + borough + ", grades=" + Arrays.toString(grades) + "]";
	}

	

}
