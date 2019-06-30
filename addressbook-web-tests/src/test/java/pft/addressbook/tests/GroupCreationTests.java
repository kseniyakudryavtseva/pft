package pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;
import pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }


}
