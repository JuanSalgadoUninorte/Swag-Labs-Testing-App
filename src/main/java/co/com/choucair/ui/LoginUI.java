package co.com.choucair.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginUI extends PageObject {

    public static final Target USER_NAME = Target.the("").located(By.xpath("//android.widget.EditText[@text='Username']"));
    public static final Target PASSWORD = Target.the("").located(By.xpath("//android.widget.EditText[@text='Password']"));
    public static final Target LOGIN_BUTTON = Target.the("").located(By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']"));
    public static final Target ADD_BUTTON = Target.the("").located(By.xpath("//android.widget.TextView[@text='ADD TO CART']"));
    public static final Target ADD_BUTTON_2 = Target.the("").located(By.xpath("(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[2]/android.widget.TextView"));
    public static final Target CART_BUTTON = Target.the("").located(By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView"));
    public static final Target CHECKOUT = Target.the("").located(By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']"));
    public static final Target FIRST_NAME= Target.the("").located(By.xpath("//android.widget.EditText[@content-desc='test-First Name']"));
    public static final Target LAST_NAME = Target.the("").located(By.xpath("//android.widget.EditText[@content-desc='test-Last Name']"));
    public static final Target POSTAL_CODE = Target.the("").located(By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']"));
    public static final Target CONTINUE_BUTTON = Target.the("").located(By.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE']"));
    public static final Target FINISH_BUTTON = Target.the("").located(By.xpath("//android.view.ViewGroup[@content-desc='test-FINISH']"));
    public static final Target CONFIRMATION_MESSAGE = Target.the("").located(By.xpath("//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']"));
    public static final Target LAST = Target.the("").located(By.xpath("//android.widget.TextView[@text='Test.allTheThings() T-Shirt (Red)']"));
    public static final Target PREVIOUS = Target.the("").located(By.xpath("//android.widget.TextView[@text='Sauce Labs Fleece Jacket']"));


    public static final Target LAST_CHANCE =Target.the("").located(By.xpath("//android.widget.ScrollView[@content-desc='test-PRODUCTS']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[4]"));
}
