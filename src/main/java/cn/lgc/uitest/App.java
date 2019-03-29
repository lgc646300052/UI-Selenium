package cn.lgc.uitest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
	private WebDriver driver;
    public static void main( String[] args )
    {
    	App app = new App();
    	WebDriver driver = app.getWebDriver();
    	app.testTitle();
    	app.testElement();
    	
//    	driver.close();
    	Scanner scan = new Scanner(System.in);
    	String kw = scan.next();
    	while (! "q".equals(kw)) {
    		kw = scan.next();
    	}
    	driver.close();
    	driver.quit();
    }
    
    public WebDriver getWebDriver() {
    	/*
		 * 指定浏览器驱动的路径
		 * 不指定会报 "org.openqa.selenium.WebDriverException: unknown error: cannot find Chrome binary" 异常
		 * 注意：使用不同浏览器时，此处的key也不一样
		 */
		System.setProperty("webdriver.chrome.driver", "F:\\LGC\\自动化测试\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		//指定浏览器的启动文件路径
		//不指定会报  "java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.chrome.driver system property" 异常
		options.setBinary("C:\\Program Files (x86)\\Chrome\\chrome.exe");
		driver = new ChromeDriver(options);	//使用谷歌浏览器测试，运行后会自动打开谷歌浏览器
		return driver;
    }
    
    /**
     * 获得title标签中的内容
     */
    public void testTitle() {
    	driver.get("http://www.baidu.com/");	//访问外网资源
//	    driver.get("file:///F:\\LGC\\workspace_cloud\\UI-Test\\html\\index.html");	//访问本地资源，开头加不加file:///都可以
	
	    String title = driver.getTitle();		//获得浏览器中的标题
	    System.out.printf(title);				//会输出“百度一下，你就知道”
    }
    
    /**
     * 获得元素并操作该元素
     */
    public void testElement() {
    	WebElement inKW = driver.findElement(By.id("kw"));	//搜索框
    	WebElement btnSU = driver.findElement(By.id("su"));	//搜索按钮
    	inKW.sendKeys("测试");	//在搜索框中输入“测试”
    	btnSU.submit();			//点击搜索按钮提交
    }
}
