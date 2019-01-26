Feature: BabyPlus
  I want to use this template for my feature file

  Scenario: Launch
    Given I want to launch BabyPlus app
    Then I am in welcome screen
    When I click on JOIN US button
    And I generate email id 
    And I enter valid email id and password "babyplus123"
    And I select create account button
    Then I am on tracking page
    
    
    
    
