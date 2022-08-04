package com.cydeo.library.DataBase;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.DBUtilities;
import com.cydeo.library.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DataBaseConnection {

    LoginPage login = new LoginPage();

    @Test
    public void test01(){
        //create connection

        String url = "jdbc:mysql://34.230.35.214:3306/library2";
        String username =  "library2_client";
        String password =  "6s2LQQTjBcGFfDhY" ;
        DBUtilities.createConnection(url, username, password);

        //run query
        DBUtilities.runQuery("select count(*) from users");

        String DBNumberOrUsers = DBUtilities.getFirstRowFirstColumn();
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        login.loginLibrarian();
        BrowserUtils.waitForVisibilityOf(login.userCount);
        String UINumberOfUsers = login.userCount.getText();
        Driver.closeDriver();
        Assertions.assertEquals(DBNumberOrUsers, UINumberOfUsers);

    }
}
