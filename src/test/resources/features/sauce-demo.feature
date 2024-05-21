Feature: Sauce Demo

  @failed-login
  Scenario Outline: Verify user login failed
    Given User open the web
    When User fill "username" input value "<username>" in "Login" page
    And User fill "password" input value "<password>" in "Login" page
    And User click on "loginButton" on page "Login"
    Then User will be receive alert message "<message>"
    Examples:
      | username        | password     | message                                             |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |

  @add-to-cart
  Scenario Outline: User add to cart and logout
    Given User open the web
    When User fill "username" input value "<username>" in "Login" page
    And User fill "password" input value "<password>" in "Login" page
    And User click on "loginButton" on page "Login"
    And User click on "addToCart" on page "Home"
    When User click on text "Sauce Labs Bike Light"
    And User click on "addToCartDetail" on page "Detail"
    When Verify get information detail "priceProductDetail" on "Detail" page
    And User click on "cartButtonDetail" on page "Detail"
    When Verify get information checkout "priceProductCheckout" on "Checkout" page
    And User click on "checkoutButton" on page "Checkout"
    When User fill "firstname" input value "<firstname>" in "Checkout" page
    And User fill "postalCode" input value "<code>" in "Checkout" page
    And User click on "continueButton" on page "Checkout"
    Then User will be receive alert message "<message>"
    And User fill "lastname" input value "<lastname>" in "Checkout" page
    And User click on "continueButton" on page "Checkout"
    Then Verify information price total order "priceTotal" on "Info Order" page
    And User will be displayed value text "<product1>"
    And User will be displayed value text "<product2>"
    When User click on "finishButton" on page "Info Order"
    And User click on "backToHome" on page "Info Order"
    Then User will be redirected to "Product" page
    And User click on "optionButton" on page "Home"
    And User click on "logoutButton" on page "Home"
    Then User will be redirected to "Login" page
    Examples:
      | username      | password     | firstname | lastname | code  | message               | product1            | product2              |
      | standard_user | secret_sauce | Dummy     | User     | 28654 | Last Name is required | Sauce Labs Backpack | Sauce Labs Bike Light |

