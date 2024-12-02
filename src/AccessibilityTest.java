/**
 * The AccessibilityTest class stores information about a single test.
 * @author Dat Dinh.
 * @version Version 1.
 * Assignment 5.
 * Due Date: 22/11/24.
 * No sources used.
 * No help obtained.
 * We confirm that the above list of sources is complete AND that we have not talked to 
 * anyone else about the solution to this problem.
 */
public class AccessibilityTest {
	// store information of each potential error for each category
	private String category;
	private String googleResult;
	private String waveResult;
	private String sortsiteResult;
	private String aslintResult;
	private String testDescription;
	/**
	 * Constructor: takes all 6 pieces of information below
	 * @param category the category
	 * @param googleResult the google result
	 * @param waveResult the wave result
	 * @param sortsiteResult the sortsite result
	 * @param aslintResult the aslint result
	 * @param testDescription the test description
	 */
	public AccessibilityTest(String category, String googleResult, String waveResult, 
			String sortsiteResult, String aslintResult, String testDescription)
	{
		this.setCategory(category);
		this.setGoogleResult(googleResult);
		this.setWaveResult(waveResult);
		this.setSortsiteResult(sortsiteResult);
		this.setAslintResult(aslintResult);
		this.setTestDescription(testDescription);
	}
	/**
	 * get the category
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * set category
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * get google result
	 * @return the googleResult
	 */
	public String getGoogleResult() {
		return googleResult;
	}
	/**
	 * set google result
	 * @param googleResult the googleResult to set
	 */
	public void setGoogleResult(String googleResult) {
		this.googleResult = googleResult.toLowerCase();
	}
	/**
	 * get wave result
	 * @return the waveResult
	 */
	public String getWaveResult() {
		return waveResult;
	}
	/**
	 * set wave result
	 * @param waveResult the waveResult to set
	 */
	public void setWaveResult(String waveResult) {
		this.waveResult = waveResult.toLowerCase();
	}
	/**
	 * get sortsite result
	 * @return the sortsiteResult
	 */
	public String getSortsiteResult() {
		return sortsiteResult;
	}
	/**
	 * set sortsite result
	 * @param sortsiteResult the sortsiteResult to set
	 */
	public void setSortsiteResult(String sortsiteResult) {
		this.sortsiteResult = sortsiteResult.toLowerCase();
	}
	/**
	 * get aslint result
	 * @return the aslintResult
	 */
	public String getAslintResult() {
		return aslintResult;
	}
	/**
	 * set aslint result
	 * @param aslintResult the aslintResult to set
	 */
	public void setAslintResult(String aslintResult) {
		this.aslintResult = aslintResult.toLowerCase();
	}
	/**
	 * get the test description
	 * @return the testDescription
	 */
	public String getTestDescription() {
		return testDescription;
	}
	/**
	 * set the test description
	 * @param testDescription the testDescription to set
	 */
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	/**
	 * String representation
	 */
	@Override
	public String toString()
	{
		return String.format("%s: %s |GOOGLE: %s |WAVE: %s |SORTSITE: %s |ASLINT: %s", getCategory(),
				getTestDescription(), getGoogleResult(), getWaveResult(), getSortsiteResult(), getAslintResult());
	}

}
