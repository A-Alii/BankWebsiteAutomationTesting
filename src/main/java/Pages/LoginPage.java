package Pages;

import Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class LoginPage extends TestBase {

    public LoginPage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }


    JavascriptExecutor js =( (JavascriptExecutor) driver);
    //
    @FindBy(name = "uid")
    WebElement userId;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement buttonLogin;


    public void enterData(String user , String pass){
        userId.clear();
        userId.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
    }

    public void clickLogin(){
        buttonLogin.click();
    }

    public String getAlertText(){
        //js.executeScript("arguments[0].style.border='5px solid red';", driver.switchTo().alert());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }


}
