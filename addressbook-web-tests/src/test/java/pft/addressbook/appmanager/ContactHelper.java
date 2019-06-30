package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("home"), contactData.getHomephone());
       }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }


    public void submitContactModification() {
        click(By.name("update"));
    }


    public void selectContactByID(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }

    public void initContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitContactDeletion() {
        alertAccept();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public void create(ContactData contactData) {
        initContactCreation();
        fillContactForm(contactData);
        submitContactCreation();
    }
    public void modify(ContactData contact) {
        initContactModificationByID(contact.getId());
        fillContactForm(contact);
        submitContactModification();
    }

    private void initContactModificationByID(int id) {
        wd.findElement(By.xpath("//input[@value = '" + id + "']/../../td[8]")).click();
    }

    public void delete(ContactData contact) {
        selectContactByID(contact.getId());
        initContactDeletion();
        submitContactDeletion();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element: elements)
        {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }

}
