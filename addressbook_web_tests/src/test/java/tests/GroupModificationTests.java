package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (!appp.groupss().isGroupPresent()) {
            appp.groupss().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        appp.groupss().modifyGroup(new GroupData().withName("modified name"));
    }
}
