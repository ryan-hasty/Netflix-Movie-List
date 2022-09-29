// Ryan Hasty
// Project 1
// Netflix Data Back-End

// All lines of actual code are commented using "Ctrl + /"
// All personal comments are not along the left border


package project1;

public class MainTester {

	public static void main(String[] args) {
		
		// test Constructor()
		ShowInWeek t2 = new ShowInWeek("2022-06-12", "Film", 3 , "Jumboliah","N/A", 2342342, 3);
		ShowInWeek t3 = new ShowInWeek("2022-06-12", "Film", 3 , "This Is Hard","N/A", 2342342, 3);
		ShowInWeek t4 = new ShowInWeek("2022-06-12", "Film", 3 , "Baffidilia","N/A", 2342342, 3);
		
//		System.out.println(t3);
		
		// Test reading in file
		ShowList shlist = new ShowList("./project1/netflixTopTenProcessed.txt");	
		
		// Create ShowList
		ShowList shlist2 = new ShowList();
		
		// testing adding shows individually
		shlist2.addShow(t2);		
		shlist2.addShow(t3);
		shlist2.addShow(t4);
//		System.out.println(shlist2);

		// Test to print out the list
		System.out.println(shlist);
		
		// Test getShows() Method which prints out the shows to watch in the function
//		shlist.getShows(t2);
		
		// Test purge() and unpurge() methods
//		shlist2.purge(t2);
//		shlist2.purge(t3);
//		System.out.println(shlist2);
//		shlist2.unpurge(t2);
//		System.out.println(shlist2);
		
		//test Edit() Methods
//		shlist2.editWeekDate(t3, "2022-9-28");
//		shlist2.editCategory(t3, "None");
//		shlist2.editWeeklyRank(t3, 52);
//		shlist2.editTitle(t3, "This is a Fake Title");
//		shlist2.editSeasonTitle(t3, "SeasonChangeTest");
//		shlist2.editWeeklyHours(t3, 99);
//		shlist2.editCumulative(t3, 15);
//		System.out.println(t3);
		
		// Test Equals() method
//		t2.equals(t3);
//		t2.equals(t4);
		
		// Test random and predictive suggestions
//		shlist.randomSuggest();
//		shlist2.predictShowInWeek(t4);
//		shlist.predictCollection(shlist2);
					
		
		// Test Write to file
//		shlist.writeFile("./project1/datatesting.txt");
		
	}

}
