package model;
public class Date
{
    private double $date;

    public double get$date ()
    {
        return $date;
    }

    public void set$date (double $date)
    {
        this.$date = $date;
    }

    @Override
    public String toString()
    {
        return "[$date = "+$date+"]";
    }
}