package STTA.OnlyTestingBlog;

import org.testng.annotations.Test;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

public class EntryPointMain {

	@SuppressWarnings("deprecation")
	@Test
	public static void main(String[] args) {
	TestListenerAdapter tla = new TestListenerAdapter();	
	TestNG testng = new TestNG();
	List<String> suites = Lists.newArrayList();
	suites.add("testng.xml");
	testng.setTestSuites(suites);
	testng.addListener(tla);
	testng.run();
	}
}
