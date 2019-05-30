package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("sergey", "petrovich",
                "ivanov","5555555"));
        app.getContactHelper().submitContactModification();


    }
}
