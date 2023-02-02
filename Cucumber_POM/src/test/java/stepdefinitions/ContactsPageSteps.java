package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.pages.ContactsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContactsPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ContactsPage contactsPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> dataList = dataTable.asMaps();
		String userName = dataList.get(0).get("username");
		String password = dataList.get(0).get("password");

		DriverFactory.getDriver()
				.get("https://ui.cogmento.com/");
		contactsPage = loginPage.doLogin(userName, password);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().deleteAllCookies();
		DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Given("user is on Contacts page")
	public void user_is_on_contacts_page() {
	    contactsPage.clickOnContacts();
	}

	@Then("contacts label should be displayed")
	public void contacts_label_should_be_displayed() {
		Assert.assertTrue(contactsPage.isContactsLabelExist());

	}

	@Then("contact with given name {string} should be clicked.")
	public void contact_with_given_name_should_be_clicked(String name) throws InterruptedException {
		contactsPage.clickOnPerson(name);

	    
	}
	@Given("user is on Add Contact Page")
	public void user_is_on_add_contact_page() throws InterruptedException {
	    contactsPage.clickOnNewContacts();

	}

	@When("user enters {string} in firstname field")
	public void user_enters_in_firstname_field(String fn) {
		contactsPage.enterFirstName(fn);
	}

	@When("user enters {string} in lastname field")
	public void user_enters_in_lastname_field(String ln) {
		contactsPage.enterLastName(ln);
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		contactsPage.clickOnSave();
	}

}
