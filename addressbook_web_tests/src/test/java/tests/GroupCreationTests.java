package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        appp.groupss().openGroupsPage();
        appp.groupss().createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        appp.groupss().createGroup(new GroupData().withName(""));
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        appp.groupss().createGroup(new GroupData().withName("some name"));
    }

    @Test
    public void canCreateGroupWithHeaderOnly() {
        appp.groupss().createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void canCreateGroupWithFooterOnly() {
        appp.groupss().createGroup(new GroupData().withFooter("some footer"));
    }
}
