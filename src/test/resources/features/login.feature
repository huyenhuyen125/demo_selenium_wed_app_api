Feature:  Aikao login page

  Scenario Outline:  Check validate of [ID Login] field and [Pw] field
    Given Open login page
    When Click button [Đăng Nhập] home page
    And Click button [Đăng Nhập] login page
    Then Verify message "<ErrorEmail>" in login page
    Examples:
      | ErrorEmail                              |
      | Bạn chưa nhập tên đăng nhập và mật khẩu |


  Scenario:  checkbox
    Given Open register page
    When Check to checkbox [Xác nhận điều khoản ] register page
    And Check to radio button open [Hiện mật khẩu ] register page


  Scenario:  alert
    Given Open add page alert
    When Click button [add to cart]
    Then Verify alert "Product added"
    When Accept alert


  Scenario:  dropdowns
    Given Open dropown custom page
    When Input to textbox

  @login
  Scenario:  dropdowns
    Given Open dropown options page
    Then Verify title label
      | label_id        | label_expected |
      | userName-label  | Name           |
      | userEmail-label | Email          |
      | genterWrapper   | Gender         |
      | subjects-label  | Subjects       |
    When Input to textbox label
      | idTextbox          | inputText          |
      | firstName          | nguyen             |
      | lastName           | thi huyen          |
      | userEmail          | huyen123@gmail.com |
      | userNumber         | 012345678          |
      | hobbies-checkbox-2 | Reading            |
    When Click to button submit









