package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;


public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer: List.of("", "group footer")) {
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new GroupData()
                    .withName(randomString(i * 10))
                    .withHeader(randomString(i * 10))
                    .withFooter(randomString(i * 10)));
        }
        return result;
    }

    /*@ParameterizedTest
    @ValueSource(strings = {"group name", "group name'"})
    public void canCreateGroup(String namee) {
        int groupCount = app.groupss().getCount();
        app.groupss().openGroupsPage();
        app.groupss().createGroup(new GroupData(namee, "group header", "group footer"));
        int newGroupCount = app.groupss().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }*/

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroup(GroupData groupp) {
        int groupCount = app.groups().getGroupsCount();
        app.groups().createGroup(groupp);
        int newGroupCount = app.groups().getGroupsCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }


    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group name'", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData groupp) {
        int groupCount = app.groups().getGroupsCount();
        app.groups().createGroup(groupp);
        int newGroupCount = app.groups().getGroupsCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
}
