$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "Assignment for QED42",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@qed42_assignment"
    }
  ]
});
formatter.scenario({
  "name": "Scenario 1 - AG grid operations",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@qed42_assignment"
    },
    {
      "name": "@scenario1"
    }
  ]
});
formatter.step({
  "name": "\"chrome\" browser is open",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.browser_is_open(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to \"https://generic-ui.com/demo\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_navigates_to(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects \"100\" from drop-down",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_selects_from_drop_down(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is able to see \"100\" rows in the grid table",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_is_able_to_see_rows_in_the_grid_table(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get the below data from grid where project status is active",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.get_the_below_data_from_grid_where_project_status_is_active(java.util.List\u003cjava.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Scenario 2 - Price Comparision b/w filpkart and amazon",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@qed42_assignment"
    },
    {
      "name": "@scenario2"
    }
  ]
});
formatter.step({
  "name": "\"chrome\" browser is open",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.browser_is_open(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to \"https://www.flipkart.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_navigates_to(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search for \"APPLE iPhone 13 (Starlight, 256 GB)\" on \"flipkart\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_search_for_on_flipkart(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is  able to see price of that item on \"flipkart\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_is_able_to_see_price_of_that_item_on_flipkart(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"chrome\" browser is open",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.browser_is_open(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to \"https://www.amazon.com/\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_navigates_to(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "change the display price to INR",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.change_the_display_price_to_inr()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search for \"APPLE iPhone 13 (Starlight, 256 GB)\" on \"amazon\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_search_for_on_flipkart(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is  able to see price of that item on \"amazon\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_is_able_to_see_price_of_that_item_on_flipkart(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user compares the price and print the result",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_compares_the_price_and_print_the_result()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});