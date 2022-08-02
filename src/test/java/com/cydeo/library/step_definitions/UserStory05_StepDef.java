package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.DBUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class UserStory05_StepDef {

    String mostPopularGenre;

    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
        DBUtilities.runQuery("inner join books b on book_borrow.book_id = b.id inner join book_categories bc on b.book_category_id = bc.id group by bc.name order by count(*) desc");
        mostPopularGenre = DBUtilities.getFirstRowFirstColumn();
    }
    @Then("verify {string} is the most popular book genre")
    public void verify_is_the_most_popular_book_genre(String genre) {
        Assertions.assertEquals(mostPopularGenre,genre);
        System.out.println(genre);
    }
}
