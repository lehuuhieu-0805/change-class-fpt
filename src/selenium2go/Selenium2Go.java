/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium2go;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author lehuuhieu
 */
public class Selenium2Go {
    
    public void selenium(WebDriver myBrower) throws Exception{
        
        WebDriverWait wait = new WebDriverWait(myBrower, 20);
        
        //click chuyen lop SWR
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/form/table/tbody/tr[1]/td/div/div[3]/table/tbody/tr[3]/td[7]/a"))).click();

        //get subject
        String subject = myBrower.findElement(By.id("ctl00_mainContent_lblSubject")).getText();

        //get old class
        String ollClass = myBrower.findElement(By.id("ctl00_mainContent_lblOldGroup")).getText();

        if (subject.equals("SWR302 - Software Requirement") && ollClass.equals("SE02D")) {
            Select dropNewClass = new Select(myBrower.findElement(By.name("ctl00$mainContent$dllCourse")));
            dropNewClass.selectByVisibleText("SE10D");

            //click save
            WebElement saveSWR302 = myBrower.findElement(By.name("ctl00$mainContent$btSave"));
            saveSWR302.click();

            Thread.sleep(1000);
            myBrower.switchTo().alert().accept();
        }

        //click Cancel
        WebElement cancelSWR302 = myBrower.findElement(By.id("ctl00_mainContent_btCancel"));
        cancelSWR302.click();

        //click chuyen lop LAB
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/form/table/tbody/tr[1]/td/div/div[3]/table/tbody/tr[6]/td[7]/a"))).click();

        //get subject
        subject = myBrower.findElement(By.id("ctl00_mainContent_lblSubject")).getText();

        //get old class
        ollClass = myBrower.findElement(By.id("ctl00_mainContent_lblOldGroup")).getText();

        if (subject.equals("LAB231 - Web Java Lab") && ollClass.equals("SE06D")) {
            Select dropNewClass = new Select(myBrower.findElement(By.name("ctl00$mainContent$dllCourse")));
            dropNewClass.selectByVisibleText("SE10D");

            //click save
            WebElement saveLAB231 = myBrower.findElement(By.name("ctl00$mainContent$btSave"));
            saveLAB231.click();

            Thread.sleep(1000);
            myBrower.switchTo().alert().accept();
        }

        //click Cancel
        WebElement cancelLAB231 = myBrower.findElement(By.name("ctl00$mainContent$btCancel"));
        cancelLAB231.click();
        
        Thread.sleep(60000);
        selenium(myBrower);
    }

    public static void main(String[] args) throws Exception{
        //cbi dieu khien trinh duyet qua code
        String driverPath = "chromedriver.exe"; // tro den file .exe tuong thich trinh duyet
        //dung song song voi chrome va dieu khien thao tac giong y chang con nguoi
        //JVM, co do choi can m quan ly
        System.setProperty("webdriver.chrome.driver", driverPath);
        //giong Class.forName() trong Java Web

        //goi trinh duyet len, default 1/2 man hinh
        //luc nay trinh duyet nam trong tay minh thong qua bien do minh dat ten, bien doi tuong OOP
        WebDriver myBrower = new ChromeDriver();
        //khai bao Cha new Con ke thua trong OOP, nam trong thu vien minh vua add vao
        //tu nay ve sau, trinh duyet bi dieu khien boi bien myBrowser, minh muon lam gi thi minh cham nhu trong lap trinh OOP

        //trinh duyet xuat hien roi, o tren va bung rong full man hinh
//        myBrower.manage().window().maximize();

        //set size cho trinh duyet
        Dimension dm = new Dimension(480, 935);
        myBrower.manage().window().setSize(dm);

        //tao muon may mo youtube len
//        myBrower.get("https://www.youtube.com/");
        myBrower.get("https://fap.fpt.edu.vn/");

        Select dropCampus = new Select(myBrower.findElement(By.name("ctl00$mainContent$ddlCampus")));
        dropCampus.selectByVisibleText("FU-Hồ Chí Minh");

        WebElement loginGmailBtn = myBrower.findElement(By.className("g-signin2"));
        loginGmailBtn.click();

        String parentWindow = myBrower.getWindowHandle();
        System.out.println("Parent Window ID: " + parentWindow);

        WebDriverWait wait = null;

        Set<String> s1 = myBrower.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String next_tab = i1.next();
            if (!parentWindow.equalsIgnoreCase(next_tab)) {
                myBrower.switchTo().window(next_tab);
                System.out.println("Working on Google Login");
                wait = new WebDriverWait(myBrower, 20);
                //email
                wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId"))).sendKeys("hieulhse140874@fpt.edu.vn");
                wait = new WebDriverWait(myBrower, 20);
                //click continue
                wait.until(ExpectedConditions.elementToBeClickable(By.className("VfPpkd-dgl2Hf-ppHlrf-sM5MNb"))).click();
                wait = new WebDriverWait(myBrower, 20);
                //password
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys("nhap mat khao vao");
                wait = new WebDriverWait(myBrower, 20);
                //click submit
                wait.until(ExpectedConditions.elementToBeClickable(By.className("VfPpkd-dgl2Hf-ppHlrf-sM5MNb"))).click();
            }
        }

        myBrower.switchTo().window(parentWindow);

        //click Move out class, suspend subject | Cancel
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/form/table/tbody/tr[1]/td/div/div[2]/div[1]/div[2]/div/table/tbody/tr/td/table/tbody/tr[1]/td[1]/ul/li[3]/a"))).click();

        Selenium2Go selenium2Go = new selenium2go.Selenium2Go();
        selenium2Go.selenium(myBrower);
    }

}
