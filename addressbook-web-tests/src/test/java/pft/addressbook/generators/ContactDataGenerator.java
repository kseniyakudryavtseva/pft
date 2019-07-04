package pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter (names = "-c", description = "Contact count")
    public int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    @Parameter (names = "-d", description = "Data format")
    public String format;

    public static void main (String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try{
            jCommander.parse(args);
        }catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("xml")){
            saveAsXML(contacts, new File(file));
        }
        else {
            System.out.println("Unrecognised format");
        }
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactData.class);
        String xml = xStream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }


    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0; i<count; i++)
        {
            contacts.add(new ContactData().withFirstname(String.format("firstname %s",i)).withLastname(String.format("lastname %s",i))
                    .withMiddlename(String.format("middlename %s",i)).withHomephone(String.format("homephone %s",i))
                    .withMobilephone(String.format("mobilephone %s",i)).withtWorkphone(String.format("workphone %s",i))
                    .withAddress(String.format("address %s",i)).withEmail(String.format("email %s",i))
                    .withEmail2(String.format("email2 %s",i)).withEmail3(String.format("email3 %s",i)));
        }
        return contacts;
    }
}
