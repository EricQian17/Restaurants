package model;
public class Score
{
    private int $numberInt;

    public int get$numberInt ()
    {
        return $numberInt;
    }

    public void set$numberInt (int $numberInt)
    {
        this.$numberInt = $numberInt;
    }

    @Override
    public String toString()
    {
        return "[$numberInt = "+$numberInt+"]";
    }
}