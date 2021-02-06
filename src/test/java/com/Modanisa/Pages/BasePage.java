package com.Modanisa.Pages;

import com.Modanisa.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    /**
     * Constructor to initialize Driver
     */
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
