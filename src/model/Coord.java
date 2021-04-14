package model;

public class Coord
{
    private double $numberDouble;

    public double get$numberDouble ()
    {
        return $numberDouble;
    }

    public void set$numberDouble (double $numberDouble)
    {
        this.$numberDouble = $numberDouble;
    }

	@Override
	public String toString() {
		return "Coord [$numberDouble=" + $numberDouble + "]";
	}


    

}