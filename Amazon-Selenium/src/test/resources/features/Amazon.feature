Feature: Amazon Search and Product Testing
  Scenario: Home Page
    Given I am on the Amazon home page amazon.com
    When I search for “Cucumber Testing”,
    Then I should get a result for “The Cucumber Book: Behaviour-Driven Development for Testers and Developers”

  Scenario: Verify Search Result/Product Page produces correct information
    Given I performed the above search
    When I click on the image of the book
    Then I should be on a Paperback tab with an “Add to Cart” button

  Scenario: Verify Product Page Add-to-Cart functionality
    Given I am on the page above
    When I click “Add to Cart”
    Then the anonymous shopping cart should have 1 item in it.

  Scenario: Verify Cart Page contains correct information
    Given I have performed the above actions
    When I click on the anonymous shopping cart,
    Then I should see the book listed with a subtotal of $32.40

  Scenario: Verify Cart Page Delete functionality
    Given I am on the above page
    When I click on “Delete”
    Then the page should tell me that my Amazon Cart is empty

  Scenario: Verify correct Product Page
    Given I am on the above page
    When I click the link for the removed book
    Then I should see an ISBN-13 number of 978-1680502381