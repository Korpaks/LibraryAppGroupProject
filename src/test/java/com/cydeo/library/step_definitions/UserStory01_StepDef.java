package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.DBUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;


public class UserStory01_StepDef {

    List<Integer> userIds;


    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        //this part is already defined in hooks class
    }

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DBUtilities.runQuery("select id from users");
        userIds = DBUtilities.getColumnDataAsList(1);

    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        DBUtilities.runQuery("select count(id) from users");
        String numberOfAllIds = DBUtilities.getFirstRowFirstColumn();
        DBUtilities.runQuery("select count(distinct id) from users");
        String numberOfUniqueIds = DBUtilities.getFirstRowFirstColumn();

        Assertions.assertEquals(numberOfUniqueIds, numberOfAllIds);

    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result() {

    }
}
