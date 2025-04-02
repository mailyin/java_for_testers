package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.groupss().getCount() == 0) {
            app.groupss().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        app.groupss().modifyGroup(new GroupData().withName("modified name"));
    }
}
