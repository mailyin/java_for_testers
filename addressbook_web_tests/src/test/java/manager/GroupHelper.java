package manager;

import model.GroupData;
import org.openqa.selenium.By;
import tests.HelperBase;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager managerr) {
        super(managerr);
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup(GroupData group) {
        openGroupsPage();
        selectGroup(group);
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup(null);
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }



    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    private void removeSelectedGroups() {
        click(By.name("delete"));
    }

    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData groupp) {
        type(By.name("group_name"), groupp.name());
        type(By.name("group_header"), groupp.header());
        type(By.name("group_footer"), groupp.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup(GroupData group) {
        click(By.cssSelector(String.format("input[value='%s']", group.id())));
    }

    public void openGroupsPage() {
        if (!managerr.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public int getGroupsCount() {
        openGroupsPage();
        return managerr.driverr.findElements(By.name("selected[]")).size();
    }

    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {
        var checkboxes = managerr.driverr.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<GroupData> getList() {
        var groups = new ArrayList<GroupData>();
        var spans = managerr.driverr.findElements(By.cssSelector("span.group"));
        for (var spann : spans) {
            var name = spann.getText();
            var checkbox = spann.findElement(By.name("selected[]"));
            var id = checkbox.getDomAttribute("value");
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }
}
