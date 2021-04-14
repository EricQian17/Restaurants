package model;
public class Grades
{
    private Date date;

    private int score;

    private String grade;

    public Date getDate ()
    {
        return date;
    }

    public void setDate (Date date)
    {
        this.date = date;
    }

    public int getScore ()
    {
        return score;
    }

    public void setScore (int score)
    {
        this.score = score;
    }

    public String getGrade ()
    {
        return grade;
    }

    public void setGrade (String grade)
    {
        this.grade = grade;
    }

	@Override
	public String toString() {
		return "Grades [date=" + date + ", score=" + score + ", grade=" + grade + "]";
	}

    
}