/**
 * The AccessibilityTester class serves as the user class.
 * @author Dat Dinh
 * @version Version 1
 * Assignment 5
 * Due Date: 22/11/24
 * No sources used
 * No help obtained
 * We confirm that the above list of sources is complete AND that we have not talked to 
 * anyone else about the solution to this problem.
 */
public class AccessibilityTester {
	/**
	 * prints out accessibility table
	 * @param a11y AccessibilityResults object
	 */
	public static void printAccessTable(AccessibilityResults a11y)
	{
		// set size of the regular cells and for large cells
		int regCell = 16;
		int largeCell = 30;
		// prints out header
		System.out.printf("| %-"+regCell+"s | %-"+regCell+"s | %-"+regCell+"s | "
				+ "%-"+regCell+"s | %-"+regCell+"s | %-"+largeCell+"s | %-"+regCell+"s%n", "Category", "Google Checker", 
				"Wave Checker", "Sortsite Checker", "ASLint", "Total Number Of Tests Possible", "Success Ratio");
		System.out.println("-".repeat(150));
		// category array. XXX: "" means Total, which will be handled using ternary operator
		String[] categories = {
				"Content", "Layout", "Colour/Contrast", "Typography", "Language", "Title", "Headings", 
				"Lists", "Tables", "Images", "Multimedia", "Links", "Buttons", "Forms", "Navigation", 
				"Keyboard", "Frames", "CSS", "HTML", ""
		};
		// checker array
		String[] checkers = {
				"Google", "wave", "sortsite", "aslint"
		};
		for (String category : categories)
		{
			System.out.printf("| %-"+regCell+"s ", (category == "" ? "Total" : category));
			for (String checker : checkers)
				System.out.printf("| %"+regCell+"s ", a11y.numPass(checker, category));
			// total of tests possible
			System.out.printf("| %"+largeCell+"s ", a11y.numOfCategory(category));
			// pass ratio
			System.out.printf("| %"+regCell+".3f%n", (double) a11y.numPass("", category)/(a11y.numOfCategory(category)*4));
			if (category != "")
				System.out.println("-".repeat(150));
		}
	}
	/**
	 * main
	 * @param args program arguments
	 * @throws ArrayIndexOutOfBoundsException if program argument is not specified
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AccessibilityResults a11y = new AccessibilityResults(args[0]);
			
			String showTestResultsStr = "colour";
			System.out.printf(">> Show test result for %s: \n\n".toUpperCase(), showTestResultsStr);
			a11y.showTestResults(showTestResultsStr);
			
			System.out.println("\n--------------------------------------------\n");
			
			String showByCategoryStr = "nav";
			System.out.printf(">> Show by category for %s: \n\n".toUpperCase(), showByCategoryStr);
			a11y.showByCategory(showByCategoryStr);
			
			System.out.println("\n--------------------------------------------\n");
			System.out.println(">> Show all failed: \n".toUpperCase());
			a11y.showAllFailed();
			
			System.out.println("\n--------------------------------------------\n");
			String checkerName = "Goog";
			String category = "";
			String checkerName1 = "lint";
			String category1 = "htm";
			System.out.printf(">> Show num pass for \"%s\", \"%s\": %d%n", checkerName, category, a11y.numPass(checkerName, category));
			System.out.printf(">> Show num pass for \"%s\", \"%s\": %d%n", checkerName1, category1, a11y.numPass(checkerName1, category1));
			
			System.out.println("\n--------------------------------------------\n");
			System.out.println(">> Print accessibility table\n".toUpperCase());
			printAccessTable(a11y);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Please place \"a11yCheckersResults.txt\" into the program argument");
		}
	}
}
