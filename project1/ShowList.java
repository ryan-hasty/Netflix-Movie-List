package project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.ArrayList;
import java.util.Random;

public class ShowList {


	private String fileName;
	private ArrayList<ShowInWeek> sList;
	//private Scanner scan = new Scanner(System.in);
	Random random = new Random();
	
	
	public ShowList()
	{
		sList = new ArrayList<ShowInWeek>();
		fileName = null;
	}

	public ShowList(String fn) {
		// constructor with given data and input file
		this();
		fileName = fn;
		readFile();
	}	

	public void addShow(ShowInWeek s)
	{

		sList.add(s);
	}
	
	// toString
	public String toString()
	{
		String returnMe = "";

		for (ShowInWeek ShowInWeek : sList) {
			returnMe += ShowInWeek.toString() + "\n";
		}
		return returnMe;
	}
	
	// Purge a given show
	public void purge(ShowInWeek s) 
	{
		// need to make this purge all shows with name
		// use for each
		// if the show list contains specified object then mark

		String temp = s.getTitle() + s.getCategory();

		for (ShowInWeek showInWeek : sList) {

			if ((showInWeek.getTitle() + showInWeek.getCategory()).equals(temp))
			{
				showInWeek.setTitle(("*" + showInWeek.getTitle()));
			}
		}
	}

	// Unpurge a given show
	public void unpurge(ShowInWeek s)
	{
		String temp = s.getTitle() + s.getCategory();

		for (ShowInWeek showInWeek : sList) {

			if (((showInWeek.getTitle() + showInWeek.getCategory()).startsWith("*")) && ((showInWeek.getTitle() + showInWeek.getCategory())).equals(temp))
			{
				showInWeek.setTitle(showInWeek.getTitle().substring(1));
			}
		}

	}

	// Check if is purged
	public boolean isPurged(ShowInWeek s)
	{
		if(s.getWeek_date().startsWith("*"))
		{
			System.out.println("This show is purged: " + s.getTitle() + " getting another one");
			return true;
		}
		return false;
	}

	// Editors
	public void editWeekDate(ShowInWeek s, String weekDate)
	{
		if(sList.contains(s))
		{
			System.out.println(s.getWeek_date());
			s.setWeek_date(weekDate);
			System.out.println("has been changed to: " + s.getWeek_date());
		}
		else
		{
			System.out.println("Object not found");
		}
	}

	public void editCategory(ShowInWeek s, String category)
	{
		if(sList.contains(s))
		{
			System.out.println(s.getCategory());
			s.setCategory(category);
			System.out.println("has been changed to: " + s.getCategory());
		}
		else
		{
			System.out.println("Object not found");
		}
	}

	public void editWeeklyRank(ShowInWeek s, int weeklyRank)
	{
		if(sList.contains(s))
		{
			System.out.println(s.getWeekly_rank());
			s.setWeekly_rank(weeklyRank);
			System.out.println("has been changed to: " + s.getWeekly_rank());
		}
		else
		{
			System.out.println("Object not found");
		}
	}

	public void editTitle(ShowInWeek s, String title)
	{
		if(sList.contains(s))
		{
			System.out.print(s.getTitle());
			s.setTitle(title);
			System.out.println(" has been changed to: " + s.getTitle());
		}
		else
		{
			System.out.println("Object not found");
		}
	}

	public void editSeasonTitle(ShowInWeek s, String seasonTitle)
	{
		if(sList.contains(s))
		{
			System.out.println(s.getSeason_title());
			s.setSeason_title(seasonTitle);
			System.out.println("has been changed to: " + s.getSeason_title());
		}
		else
		{
			System.out.println("Object not found");
		}
	}

	public void editWeeklyHours(ShowInWeek s, int weeklyHours)
	{
		if(sList.contains(s))
		{
			System.out.println(s.getWeekly_hours());
			s.setWeekly_hours(weeklyHours);
			System.out.println("has been changed to: " + s.getWeekly_hours());
		}
		else
		{
			System.out.println("Object not found");
		}
	}

	public void editCumulative(ShowInWeek s, int cumulative)
	{
		if(sList.contains(s))
		{
			System.out.println(s.getCumulative());
			s.setCumulative(cumulative);
			System.out.println("has been changed to: " + s.getCumulative());
		}
		else
		{
			System.out.println("Object not found");
		}
	}

	// Suggest Random Show in List
	public ShowInWeek randomSuggest()
	{

		ShowInWeek myRandomShow = sList.get(random.nextInt(sList.size()));

		while(isPurged(myRandomShow))
		{
			myRandomShow = sList.get(random.nextInt(sList.size()));
		}

		System.out.println("You should watch: " + myRandomShow.getTitle());
		return myRandomShow;
	}

	// Predict a show to watch based on a given show
	public ShowInWeek predictShowInWeek(ShowInWeek s)
	{
		ShowInWeek myRandomShow = new ShowInWeek();

		myRandomShow = sList.get(random.nextInt(sList.size()));

		while(s.equals(myRandomShow) || isPurged(myRandomShow))
		{
			myRandomShow = sList.get(random.nextInt(sList.size()));
		}
		System.out.println("You should watch: " + myRandomShow.getTitle());

		return myRandomShow;
	}

	// Predict a movie to watch based on a collection

	public ShowInWeek predictCollection(ShowList s)
	{
		ShowInWeek myRandomShow = new ShowInWeek();
		myRandomShow = sList.get(random.nextInt(sList.size()));

		while(s.contains(myRandomShow) || s.isPurged(myRandomShow))
		{
			myRandomShow = sList.get(random.nextInt(sList.size()));
		}
		System.out.println("You should watch: " + myRandomShow.getTitle());

		return myRandomShow;
	}	
	private boolean contains(ShowInWeek s) {

		for (ShowInWeek showInWeek : sList) {
			if(s.equals(showInWeek))
			{
				return true;
			}
		}

		return false;
	}

	public ShowList getShows(ShowInWeek s)
	{
		String temp = s.getWeek_date();
		ShowList returnList = new ShowList();
		
		for (ShowInWeek showInWeek : sList) {
			
			if(showInWeek.getWeek_date().equals(temp))
			{
				returnList.addShow(showInWeek);
			}
		}
		
		System.out.println(returnList);
		return returnList;
	}

	
	
	
	
	
	private void readFile () {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);	
			String line;
			
			while ((line = lineReader.readLine())!=null) 
			{
				String week_date = line;
				String category = lineReader.readLine();
				int weekly_rank = Integer.parseInt(lineReader.readLine());
				String title = lineReader.readLine();
				String season_title = lineReader.readLine();
				int weekly_hours = Integer.parseInt(lineReader.readLine());
				int cumulative = Integer.parseInt(lineReader.readLine());	
				
				addShow(new ShowInWeek(week_date,category,weekly_rank,title,season_title,
				weekly_hours,cumulative));
				}
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line;
				while ((line = lineReader.readLine())!=null) 
				{
					String week_date = line;
					String category = lineReader.readLine();
					int weekly_rank = Integer.parseInt(lineReader.readLine());
					String title = lineReader.readLine();
					String season_title = lineReader.readLine();
					int weekly_hours = Integer.parseInt(lineReader.readLine());
					int cumulative = Integer.parseInt(lineReader.readLine());	
					
					addShow(new ShowInWeek(week_date,category,weekly_rank,title,season_title,
					weekly_hours,cumulative));	
					}
			} catch (Exception e2) {
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	} // end of readFile method	
	
	public void writeFile () {
		// overloaded method: this calls doWrite with file used to read data
		// use this for saving data between runs
		doWrite(fileName);
	} // end of writeFile method

	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method
	
	private void doWrite(String fn) {
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			
			
			for (ShowInWeek showInWeek : sList) {
				
				myOutfile.write(showInWeek.getWeek_date()+"\n");
				myOutfile.write(showInWeek.getCategory()+"\n");
				myOutfile.write(showInWeek.getWeekly_rank()+"\n");
				myOutfile.write(showInWeek.getTitle()+"\n");
				myOutfile.write(showInWeek.getSeason_title()+"\n");
				myOutfile.write(showInWeek.getWeekly_hours()+"\n");
				myOutfile.write(showInWeek.getCumulative()+"\n");
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}	



}