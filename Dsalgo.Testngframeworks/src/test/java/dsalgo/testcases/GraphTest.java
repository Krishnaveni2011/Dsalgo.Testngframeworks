package dsalgo.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;
import dsalgo.pageobjects.DataStructure_POM;
import dsalgo.pageobjects.Graph_POM;
import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.Login_POM;

import dsalgo.utilities.Loggerload;

public class GraphTest extends BaseClass{
	
		ConfigReader reader = new ConfigReader();
		HomePage homepage = new HomePage();
		Login_POM sign = new Login_POM();

		@BeforeMethod
		public void OpenApp() {

			driver.get(ConfigReader.getProperty("appURL"));
			Login_POM sign = new Login_POM();
			HomePage homepage = new HomePage();
			DataStructure_POM dspom = new DataStructure_POM();
			Graph_POM graph = new Graph_POM();
			homepage.clickOnGetStartedButton();
			sign.signInclick();
			dspom.Login("Rockstars_Numpy", "Numpy@Rock123");
			homepage.clickOnLoginBtn();
			String Title = graph.getStackPageTitle();
			Loggerload.info("Title of the Page : \" " + Title + "\" ");
			assertEquals(Title, "NumpyNinja", "Title do not match");

		}

		@Test(priority = 1, dataProvider = "DataTryEditorValidCode", dataProviderClass = DataProviderClass.class)
		public void GraphPageValidCode(String code, String output) throws InterruptedException {
			Graph_POM graph = new Graph_POM();
			graph.Graph_GetStartedbutton();
			graph.Graph_Graphlink();
			graph.Tryeditor_Graph();
			graph.setvalidcode(code);
			graph.GraphRun_Button();
			Assert.assertEquals(graph.getActualResult(), output);
			Loggerload
					.info("You are viewing the Assessment Title in the Try Editor Page" + driver.getTitle() + " page.");
		}

		@Test(priority = 2, dataProvider = "DataTryEditorInvalidCode", dataProviderClass = DataProviderClass.class)
		public void GraphInValidcode(String code, String output) throws InterruptedException {

			Graph_POM graph = new Graph_POM();
			graph.Graph_GetStartedbutton();
			graph.Graph_Graphlink();
			graph.Tryeditor_Graph();
			graph.setvalidcode(code);
			graph.GraphRun_Button();
			String actualError = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Assert.assertEquals(actualError, output);
			Loggerload.info("You are viewing the " + driver.getTitle() + " page.");
		}

		@Test(priority = 3, dataProvider = "DataTryEditorValidCode", dataProviderClass = DataProviderClass.class)
		public void GraphRepresentationValidCode(String code, String output) throws InterruptedException {
			Graph_POM graph = new Graph_POM();
			graph.Graph_GetStartedbutton();
			graph.Graph_Representationlink();
			graph.Tryeditor_Graph();
			graph.setvalidcode(code);
			graph.GraphRun_Button();
			Assert.assertEquals(graph.getActualResult(), output);
			Loggerload
					.info("You are viewing the Assessment Title in the Try Editor Page" + driver.getTitle() + " page.");
		}

		@Test(priority = 4, dataProvider = "DataTryEditorInvalidCode", dataProviderClass = DataProviderClass.class)
		public void GraphRepresentationInValidcode(String code, String output) throws InterruptedException {

			Graph_POM graph = new Graph_POM();
			graph.Graph_GetStartedbutton();
			graph.Graph_Graphlink();
			graph.Tryeditor_Graph();
			graph.setvalidcode(code);
			graph.GraphRun_Button();
			String actualError = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Assert.assertEquals(actualError, output);
			Loggerload.info("You are viewing the " + driver.getTitle() + " page.");
		}

		@Test(priority = 5, description = "DS Practicequestion")
		public void VerifyStackPracticeQuestio() throws InterruptedException {

			Graph_POM graph = new Graph_POM();
			graph.Graph_GetStartedbutton();
			graph.Graph_Graphlink();
			graph.Graph_practiceqn();
			String Title = graph.getStackPageTitle();
			Loggerload.info("Title of the Page : \" " + Title + "\" ");
			assertEquals(Title, "Practice Questions", "Title do not match");
		}

	}


