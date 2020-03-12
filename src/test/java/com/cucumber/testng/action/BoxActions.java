package com.cucumber.testng.action;

import com.cucumber.testng.page_objects.web.ifmdx.BoxPage;
import com.cucumber.testng.page_objects.web.ifmdx.MenuPage;

import static com.cucumber.testng.utilities.misc_utils.StringUtililties.randomString;

public class BoxActions {

    private String boxName;
    private MenuPage menuPage;
    private BoxPage boxPage;
    private String variable;

    public BoxActions(MenuPage menuPage, BoxPage boxPage) {
        this.menuPage = menuPage;
        this.boxPage = boxPage;
    }

    public void createBox(String boxName) {
        this.boxName = boxName;
        menuPage.gotoBoxManagement()
                .createNewBox(boxName);
        variable = randomString(4);
        System.out.println("Random variable is --- " + variable);
    }

    public String verifyBoxCreated() {
        return boxPage.verifyBoxPresent(boxName);
    }

    public String getBoxNameFromBoxAction() {
        return this.boxName;
    }

    public BoxPage getBoxPage() {
        return this.boxPage;
    }

    public String getVariable() {
        return variable;
    }
}
