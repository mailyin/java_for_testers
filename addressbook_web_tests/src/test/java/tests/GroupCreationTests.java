package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        int groupCount = app.groupss().getCount();
        app.groupss().openGroupsPage();
        app.groupss().createGroup(new GroupData("group name", "group header", "group footer"));
        int newGroupCount = app.groupss().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groupss().createGroup(new GroupData().withName(""));
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groupss().createGroup(new GroupData().withName("some name"));
    }

    @Test
    public void canCreateGroupWithHeaderOnly() {
        app.groupss().createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void canCreateGroupWithFooterOnly() {
        app.groupss().createGroup(new GroupData().withFooter("some footer"));
    }
}
