package manager;

import model.GroupData;
import org.openqa.selenium.By;
import tests.HelperBase;

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

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup();
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

    private void removeSelectedGroup() {
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

    private void selectGroup() {
        click(By.name("selected[]"));
    }

    public void openGroupsPage() {
        if (!managerr.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public int getCount() {
        openGroupsPage();
        return managerr.driverr.findElements(By.name("selected[]")).size();
    }
}
