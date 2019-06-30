package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Name1").withMiddlename("Middle name1")
            .withLastname("Last name1").withHomephone("9999999999");
    app.contact().create(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
}
