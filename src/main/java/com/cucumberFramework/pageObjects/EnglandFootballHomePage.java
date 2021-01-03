package com.cucumberFramework.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumberFramework.helper.WaitHelper;

public class EnglandFootballHomePage {
	
	private WebDriver driver;
	
	static String filePath = "C://Users//Hp//Workspace//Cucumber-BDD-Automation-Framework-master//images//screenshot.jpeg";
	
	//********* WebElements for theFA.com **********//	
	
	@FindBy(xpath=".//*[@id='signInLink']")
	public WebElement signIN;
	
	@FindBy(xpath=".//*[@id='signInName']")
	public WebElement UserName;
	
	@FindBy(xpath=".//*[@id='password']")
	public WebElement Pwd;
	
	@FindBy(xpath=".//*[@id='next']")
	public WebElement signInButton;
	
	@FindBy(xpath="//h2[contains(text(),'Sign in')]")
	public WebElement SignIncon;
	
	@FindBy(xpath="(//li/button[contains(text(),'Qafa')])[2]")
	public WebElement UserSignedIn;
	
	
	@FindBy(xpath="//*[@id=\"onetrust-accept-btn-handler\"]")
	public WebElement btnAllCookies;
	
	//********* WebElements for WLC **********//
	
	@FindBy(xpath="//div[contains(@class,'logo')]/a[@tabindex='0']")
	public WebElement WLClogo;
	
	@FindBy(xpath="//li/a[contains(text(),'For Girls')]")
	public WebElement lnktheGirls;
	
	@FindBy(xpath="//h2[contains(text(),'GET INSPIRED')]")
	public WebElement wbeGetInspire;
	
	
			
    @FindBy(xpath = "(//div[@class='Padd'])[1]//div[@class='owl-item active']//a[@class='blocklink']")		
    public List<WebElement> lnkWebCarousel;
	
    @FindBy(xpath = "//h1[contains (text(),'How to... pass a football')]")
    public WebElement wbeHowToPassFootball;
    
	//***********************************************//
	@FindBy(xpath="//input[@type='email']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement Continue;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@id='nav-tools']/a[@data-nav-role='signin']")
	WebElement SignInfromNav;
	
	@FindBy(xpath="//span[contains(text(),'Sign')]/parent::a")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//div[@id='nav-shop']/a")
	public WebElement allShopNav;

	@FindBy(xpath="//span[@data-nav-panelkey='TvApplElecPanel']")
	public WebElement TvApplElecPanel;
	
	@FindBy(xpath="//span[contains(text(),'Headphones')]/parent::a")
	public WebElement headPhonesCatLnk;
	
	@FindBy(xpath="//div[@id='mainResults']/ul/li[1]/div/div/div/a[contains(@class,'access-detail-page')]")
	public WebElement firstHeadPhoneLnk;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	public WebElement addToCartBtn;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	public WebElement cartButton;
	
	@FindBy(xpath="//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']")
	public List<WebElement> itemList;
	
	//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']
	
	@FindBy(xpath="//div[contains(@class,'nav-search-field')]/input")
	public WebElement itemSearchField;
	
	@FindBy(xpath="//div[starts-with(@class,'sg-col-4')]/div[@class='sg-col-inner']/div/h5/a")
	public WebElement secondMacbookItem;
	
	@FindBy(xpath="//select[@id='quantity' or @name='quantity']")
	public List<WebElement> qtyField;
	
	
	WaitHelper waitHelper;
	
	public EnglandFootballHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void enterUserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	//*******************FA***********************//
	public void enterFAUserName(String userName){
		this.UserName.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	//*******************FA************************//
	
	public void enterFAPassword(String password){
		this.Pwd.sendKeys(password);
	}
	public void clickLoginButton(){
		loginButton.click();
	}
	
	//*******************FA*************************//
	public void clickSignIn() throws InterruptedException{
		signInButton.click();
		//Thread.sleep(10000);
	}
	
	
	
	public void enterSearchItemandAddToCart(String item){
		String mainWindow=driver.getWindowHandle();
		this.itemSearchField.sendKeys(item);
		this.itemSearchField.submit();
		secondMacbookItem.click();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
		 String childWindow=itr.next();
		 if(!mainWindow.equals(childWindow)){
			 driver.switchTo().window(childWindow);
			 System.out.println(driver.switchTo().window(childWindow).getTitle());
			 if(qtyField.size()>=1){
				 
				 Select sel = new Select(qtyField.get(0));
				 sel.selectByValue("2");
			 }
			 
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView(true);",addToCartBtn);
			 js.executeScript("arguments[0].click();", addToCartBtn);
			 if(driver.findElements(By.xpath("//div[@class='a-popover-inner']//button[contains(text(),'Skip')]")).size()>=1){
				 
				 driver.findElements(By.xpath("//div[@class='a-popover-inner']//button[contains(text(),'Skip')]")).get(0).click();
			 }
			 //addToCartBtn.click();
			 //driver.close();
		 }
		}
		driver.switchTo().window(mainWindow);
	}
	
	public void clickSignInButton(){
		Actions builder = new Actions(driver);
		builder.moveToElement(SignInfromNav).build().perform();
		SignInfromNav.click();
	}
	//***TheFA*****//
	public void clickSignInLink() {
		signIN.click();
	}
	
	
	public void clearCartItemifExist(){
		cartButton.click();
		int i = itemList.size();
		if(i>=1){
			itemList.get(0).click();
			i = itemList.size();
		}
	}
	
	public void clickHeadphonesLnk(){
		Actions builder = new Actions(driver);
		builder.moveToElement(allShopNav).build().perform();
		builder.moveToElement(TvApplElecPanel).build().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", headPhonesCatLnk);
		
	}
	
	public void AddHeadphoneToCart(){
		
		firstHeadPhoneLnk.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", addToCartBtn);
	}
	
	public void clickContinueButton(){
		Continue.click();
	}
	
	
	
	public void clickLogoutButton(){
		Actions builder = new Actions(driver);
		builder.moveToElement(SignInfromNav).build().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", logoutBtn);;
	}
	
	public void acceptCookies() {
		btnAllCookies.click();
		
	}
	
	public void visibilityOfItemsInCarousel() {
		int n = lnkWebCarousel.size();
		/*for(int i = 1;i<=n;i++) {
			lnkWebCarousel.get(i).isDisplayed();
		}*/
		
		Iterator<WebElement> itr = lnkWebCarousel.iterator();
		while(itr.hasNext()) {
		    System.out.println("Elements are "+itr.next().isDisplayed());		    
		}
		
	}
	
	public void carouselCompVisibleByScroll() throws IOException, InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", wbeHowToPassFootball);
        Thread.sleep(2000);
        takeScreenshot(driver,filePath);
        		
	}
	

	public void takeScreenshot(WebDriver webdriver, String filePath) throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

                //Move image file to new destination

                File DestFile=new File(filePath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

		
	}
}
