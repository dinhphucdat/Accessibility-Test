
import java.util.*;
import java.io.*;
/**
 * The AccessibilityResults class processes information about tests into ArrayList.
 * @author Dat Dinh
 * @version Version 1
 * Assignment 5
 * Due Date: 22/11/24
 * No sources used
 * No help obtained
 * We confirm that the above list of sources is complete AND that we have not talked to 
 * anyone else about the solution to this problem.
 */
public class AccessibilityResults {
	// ArrayList object to store information about each AccessbilityTest object.
	private ArrayList<AccessibilityTest> testList;
	/**
	 * Constructor: reads in the result file, create an ArrayList of AccessibilityTest objects.
	 * @param testFile result file name
	 */
	public AccessibilityResults(String testFile)
	{
		// new ArrayList
		testList = new ArrayList<>();
		// this is to handle error: prints the error at which line in the file
		int lineManager = 0;
		// try-catch
		try (Scanner file = new Scanner(new File(testFile)))
		{
			while (file.hasNextLine())
			{
				testList.add(readFile(file.nextLine(), ++lineManager));
			}
		}
		catch (FileNotFoundException e)
		{
			System.err.println("File not found");
		}
		catch (IOException e)
		{
			e.getMessage();
		}
	}
	/**
	 * assists the constructor in reading each line in the file
	 * @param line a line
	 * @param lineManager the line where an exception could be potentially thrown.
	 * @return an AccessibilityTest object.
	 * @throws IOException when the line is not well-formatted.
	 */
	private AccessibilityTest readFile(String line, int lineManager) throws IOException
	{
		// split each word into an array, separate by a space
		String[] lineProcess = line.split(" ");
		// declare variables
		String category;
		String googleResult;
		String waveResult;
		String sortsiteResult;
		String aslintResult;
		String testDescription;
		// one way to know if the line is poorly formatted is checking if it covers all 4 errors for each test.
		if (lineProcess.length <= 5)
			throw new IOException(String.format("Test line formatted incorrectly at line %d", lineManager));
		// collect each piece into its corresponding variable
		category = lineProcess[0];
		googleResult = lineProcess[1];
		waveResult = lineProcess[2];
		sortsiteResult = lineProcess[3];
		aslintResult = lineProcess[4];
		// the description entails all remaining elements in the split array. Join them together.
		String[] descriptionRaw = Arrays.copyOfRange(lineProcess, 5, lineProcess.length);
		testDescription = String.join(" ", descriptionRaw);
		return new AccessibilityTest(category, googleResult, waveResult, sortsiteResult, aslintResult, testDescription);
	}
	/**
	 * gets number of tests in total
	 * @return number of tests
	 */
	public int numTests()
	{
		return testList.size();
	}
	/**
	 * gets the AccessibilityTest at a specific index
	 * @param index index
	 * @return AccessibilityTest
	 */
	public AccessibilityTest testAt(int index)
	{
		if (index < 0 || index >= testList.size())
			throw new IllegalArgumentException("index invalid - out of bound for testAt()");
		return testList.get(index);
	}
	/**
	 * gets a List of AccessibilityTest objects specified
	 * @param bound1 first bound
	 * @param bound2 second bound
	 * @return List view of the internal ArrayList
	 */
	public List<AccessibilityTest> testAt(int bound1, int bound2)
	{
		if (!(bound1 <= bound2) || bound1 < 0 || bound1 >= testList.size() || bound2 < 0 || bound2 >= testList.size())
			throw new IllegalArgumentException("out of bound - testAt(2 arguments)");
		return testList.subList(bound1, bound2);
	}
	/**
	 * search categories based on keyword
	 * @param target keyword, or part of it
	 * @return result that matches
	 */
	public int numOfCategory(String target)
	{
		int numMatch = 0;
		target = target.toLowerCase();
		// iterate through ArrayList
		for(ListIterator<AccessibilityTest> it = testList.listIterator(); it.hasNext();)
		{
			AccessibilityTest current = it.next();
			String currentCat = current.getCategory().toLowerCase();
			// if found an index then accumulate numMatch
			if (currentCat.indexOf(target) != -1)
				numMatch++;
		}
		return numMatch;
	}
	/**
	 * show all test results based on keyword
	 * @param target keyword, or part of it
	 * @return if there is anything then true, otherwise false
	 */
	public boolean showTestResults(String target)
	{
		int numMatch = 0;
		target = target.toLowerCase();
		// iterate
		for(ListIterator<AccessibilityTest> it = testList.listIterator(); it.hasNext();)
		{
			AccessibilityTest current = it.next();
			// prevent case-insensitive
			String currentToString = current.toString().toLowerCase();
			if (currentToString.indexOf(target) != -1)
			{
				System.out.println(current);
				numMatch++;
			}
		}
		System.out.println("\n* TOTAL TESTS MATCHED: " + numMatch);
		if (numMatch == 0)
			return false;
		else
			return true;
	}
	/**
	 * shows all results based on keyword searching only for categories
	 * @param target keyword, or part of it
	 * @return if there is anything then true, otherwise false
	 */
	public boolean showByCategory(String target)
	{
		int numMatch = 0;
		target = target.toLowerCase();
		// iterate
		for(ListIterator<AccessibilityTest> it = testList.listIterator(); it.hasNext();)
		{
			AccessibilityTest current = it.next();
			// prevent case-insensitive
			String currentCategory = current.getCategory().toLowerCase();
			if (currentCategory.indexOf(target) != -1)
			{
				System.out.println(current);
				numMatch++;
			}
		}
		System.out.println("\n* TOTAL TESTS MATCHED: " + numMatch);
		if (numMatch == 0)
			return false;
		else
			return true;
	}
	/**
	 * shows all tests having all failed potential errors
	 * @return if there is any test that has all failed errors, true. If not, false
	 */
	public boolean showAllFailed()
	{
		int numFailed = 0;
		// fail indicator
		final String GOAL = "notfound";
		// iterate
		for(ListIterator<AccessibilityTest> it = testList.listIterator(); it.hasNext();)
		{
			AccessibilityTest current = it.next();
			// all errors need to be notfound
			if (current.getGoogleResult().equals(GOAL) && current.getWaveResult().equals(GOAL) 
					&& current.getSortsiteResult().equals(GOAL) && current.getAslintResult().equals(GOAL))
			{
				System.out.println(current);
				numFailed++;
			}
		}
		System.out.println("\n* TOTAL TESTS FAILED: " + numFailed);
		if (numFailed == 0)
			return false;
		else
			return true;
	}
	/**
	 * shows number of errors that passed based on keywords searching for errors and categories
	 * @param checker error checker
	 * @param category category
	 * @return number of checker errors that passed
	 */
	public int numPass(String checker, String category)
	{
		int numPass = 0;
		// prevent case-insensitive
		checker = checker.toLowerCase();
		category = category.toLowerCase();
		// 4 checkers
		String checkerOne = "google";
		String checkerTwo = "wave";
		String checkerThree = "sortsite";
		String checkerFour = "aslint";
		// iterate
		ListIterator<AccessibilityTest> it = testList.listIterator();

		while (it.hasNext())
		{
			AccessibilityTest current = it.next();
			if (current.getCategory().toLowerCase().contains(category))
			{
				// Check if checker matches and if the result contains "error" or "error_paid"
				if (checkerOne.contains(checker) && 
				    (current.getGoogleResult().contains("error") || current.getGoogleResult().contains("error_paid")))
					numPass++;

				if (checkerTwo.contains(checker) && 
				    (current.getWaveResult().contains("error") || current.getWaveResult().contains("error_paid")))
					numPass++;

				if (checkerThree.contains(checker) && 
				    (current.getSortsiteResult().contains("error") || current.getSortsiteResult().contains("error_paid")))
					numPass++;

				if (checkerFour.contains(checker) && 
				    (current.getAslintResult().contains("error") || current.getAslintResult().contains("error_paid")))
					numPass++;
			}
		}
		return numPass;
	}


}
