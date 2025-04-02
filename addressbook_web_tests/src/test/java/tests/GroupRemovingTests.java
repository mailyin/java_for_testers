package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupRemovingTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.groupss().getCount() == 0) {
            app.groupss().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        int groupCount = app.groupss().getCount();
        app.groupss().removeGroup();
        int newGroupCount = app.groupss().getCount();
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }
}
