package project1;

public class ShowInWeek {

	private String week_date;
	private String category;
	private int weekly_rank;
	private String title;
	private String season_title;
	private int weekly_hours;
	private int cumulative;

	// Default Constructor
	public ShowInWeek()
	{
		// Title + Week Date is a valid ID for equals method
		week_date = "N/A";
		category = "N/A";
		weekly_rank = -1;
		title = "N/A";
		season_title = "N/A";
		weekly_hours = -1;
		cumulative = -1;
	}

	// Full Constructor
	public ShowInWeek(String week_date, String category, int weekly_rank, String title, String season_title,
			int weekly_hours, int cumulative) {
		super();
		this.week_date = week_date;
		this.category = category;
		this.weekly_rank = weekly_rank;
		this.title = title;
		this.season_title = season_title;
		this.weekly_hours = weekly_hours;
		this.cumulative = cumulative;
	}

	public ShowInWeek(Object selectedItem) {
		
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String show_title) {
		this.title = show_title;
	}

	public String getWeek_date() {
		return week_date;
	}

	public void setWeek_date(String week_date) {
		this.week_date = week_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getWeekly_rank() {
		return weekly_rank;
	}

	public void setWeekly_rank(int weekly_rank) {
		this.weekly_rank = weekly_rank;
	}

	public String getSeason_title() {
		return season_title;
	}

	public void setSeason_title(String season_title) {
		this.season_title = season_title;
	}

	public int getWeekly_hours() {
		return weekly_hours;
	}

	public void setWeekly_hours(int weekly_hours) {
		this.weekly_hours = weekly_hours;
	}

	public int getCumulative() {
		return cumulative;
	}

	public void setCumulative(int cumulative) {
		this.cumulative = cumulative;
	}

	// toString
	public String toString()
	{
		// Return all of the fields
		return ("\n1) Week: " + getWeek_date() + "\n2) Category: " + getCategory() + "\n3) Weekly Rank: " + getWeekly_rank()
		+"\n4) Show Title: "+ getTitle() + "\n5) Season_Title: " + getSeason_title() + "\n6) Weekly Hours: "
		+ getWeekly_hours() + "\n7) Cumulative Weeks at Top: " + getCumulative());
//		return (getWeek_date() + " " + getCategory() + " " + getWeekly_rank() + " " + getTitle() + " " + getSeason_title() + " " + getWeekly_hours() + " " + getCumulative());
	}

	// Compare equality between entries
	public boolean equals(Object o)
	{
		// save object as local variable
		ShowInWeek inputObj = (ShowInWeek)o;

		// this callerID which is week date + title for the object calling function
		String callerID;
		callerID = this.getWeek_date() + this.getTitle();

		// Compare callerID to the object is the object in parameter
		String compID = inputObj.getWeek_date() + inputObj.getTitle();

		// if the two strings equal each other then it's the same "ID"
		if(callerID.equals(compID))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
