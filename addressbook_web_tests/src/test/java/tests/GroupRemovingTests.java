package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovingTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (!appp.groupss().isGroupPresent()) {
            appp.groupss().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        appp.groupss().removeGroup();
    }
}
