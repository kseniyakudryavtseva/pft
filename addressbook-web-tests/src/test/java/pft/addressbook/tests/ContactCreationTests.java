package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Name1", "Middle name1", "Last name1", "9999999999"));
    app.getContactHelper().submitContactCreation();
  }
}
