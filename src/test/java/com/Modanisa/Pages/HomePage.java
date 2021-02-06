package com.Modanisa.Pages;

import com.Modanisa.Utilities.BrowserUtils;
import com.Modanisa.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//input)[1]")
    public WebElement textBox;

    @FindBy(css = ".view")
    public List<WebElement> listOfTexts;

    @FindBy(css = ".toggle")
    public List<WebElement> listOfCheckBoxes;

    @FindBy(css = ".destroy")
    public List<WebElement> listOfDeleteButtons;

    /**
     * Send keys to textBox and hit enter
     * @param item ToDo
     */
    public void writeToTextBoxAndHitEnter(String item){
        textBox.sendKeys(item + Keys.ENTER);
    }

    /**
     * Find the text in the ToDo list
     * @param item ToDo
     * @return index number
     */
    public int findItemIndex(String item){
        for (int i = 0; i < listOfTexts.size(); i++) {
            if (listOfTexts.get(i).getText().equals(item)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Generate xPath for related item
     * @param item ToDo
     * @return xPath as String
     */
    private String getXpathOfItem(String item){
        return "//label[.='"+item+"']";
    }

    /**
     * Check if Checkbox is checked or not
     * @param item ToDo
     * @return true if CheckBox is checked
     */
    public boolean isDone(String item){
        String classText = Driver.get().findElement(By.xpath(getXpathOfItem(item)+"/../..")).getAttribute("class");
        return classText.equals("todo completed");
    }

    /**
     * Check if Checkbox is checked or not
     * @param item ToDo
     * @return true if CheckBox is NOT checked
     */
    public boolean isUnDone(String item){
        return !isDone(item);
    }

    /**
     * Click related items required element
     * @param element to be clicked
     * @param item related ToDO item
     */
    public void clickElementOfItem(String element, String item){
        switch (element){
            case "checkBox":
                listOfCheckBoxes.get(findItemIndex(item)).click();
                break;
            case "deleteButton":
                BrowserUtils.hover(listOfTexts.get(findItemIndex(item)));
                listOfDeleteButtons.get(findItemIndex(item)).click();
                break;
        }
    }

    /**
     * Get first item in ToDo list
     * @return item as String
     */
    public String getFirstItemText(){
        return listOfTexts.get(0).getText();
    }

    /**
     * Check if list is empty or not
     * @return true if list is empty
     */
    public boolean isListEmpty(){
        //Decreasing implicitly wait time to be quicker
        Driver.get().manage().timeouts().implicitlyWait(200,TimeUnit.MICROSECONDS);
        boolean isEmpty = listOfTexts.size()==0;
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return isEmpty;
    }

}
