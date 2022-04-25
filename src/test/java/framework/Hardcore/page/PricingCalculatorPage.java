package framework.Hardcore.page;

import framework.Hardcore.model.VirtualMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage {
    private WebDriver driver;

    @FindBy(id = "input_81")
    private WebElement inputNumberOfInstance;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement selectOSType;

    @FindBy(xpath = "//*[@placeholder='VM Class']")
    private WebElement selectVMClass;

    @FindBy(xpath = "//*[@placeholder='Series']")
    private WebElement selectSeries;

    @FindBy(xpath = "//*[@placeholder='Instance type']")
    private WebElement selectInstanceType;

    @FindBy(xpath = "//div[contains(text(), 'Add GPUs.')]")
    private WebElement checkboxAddGPU;

    @FindBy(xpath = "//*[@placeholder='GPU type']")
    private WebElement selectGPUType;

    @FindBy(xpath = "//*[@placeholder='Number of GPUs']")
    private WebElement selectGPUNumber;

    @FindBy(xpath = "//*[@placeholder='Local SSD']")
    private WebElement selectLocalSSD;

    @FindBy(xpath = "//*[@placeholder='Datacenter location']")
    private WebElement selectDatacenter;

    @FindBy(xpath = "//*[@placeholder='Committed usage']")
    private WebElement selectCommittedUsage;

    @FindBy(xpath = "//*[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement estimateButton;

    private final Logger logger =LogManager.getRootLogger();

    public PricingCalculatorPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PricingCalculatorPage fillVirtualMachineData(VirtualMachine virtualMachine){
        setInstanceNumbers(virtualMachine.getNumberOfInstances());
        setOSType(virtualMachine.getOsType());
        setVMClass(virtualMachine.getVmClass());
        setSeries(virtualMachine.getSeries());
        setInstanceType(virtualMachine.getInstanceType());
        checkAddGPUs();
        setGPUType(virtualMachine.getGpuType());
        setGPUNumber(virtualMachine.getNumberOfGPUs());
        setLocaleSSD(virtualMachine.getLocalSSD());
        setDatacenter(virtualMachine.getDatacenterLocation());
        setCommittedUsage(virtualMachine.getCommittedUsage());
        return this;
    }

    private void selectOption(WebElement select, String text){

        WebElement option = select.findElement(By.xpath(".//md-option[contains(., '" + text + "')]"));
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(select));
        select.click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(option));
        option.click();

    }

    public PricingCalculatorPage setInstanceNumbers(String number){
        inputNumberOfInstance.sendKeys(number);
        return this;
    }

    public PricingCalculatorPage setOSType(String osType){
        selectOption(selectOSType, osType);
        return this;
    }

    public PricingCalculatorPage setVMClass(String vmClass){
        selectOption(selectVMClass, vmClass);
        return this;
    }

    public PricingCalculatorPage setSeries(String series){
        selectOption(selectSeries, series);
        return this;
    }

    public PricingCalculatorPage setInstanceType(String instance){
        selectOption(selectInstanceType, instance);
        return this;
    }

    public PricingCalculatorPage checkAddGPUs(){
        checkboxAddGPU.click();
        return this;
    }

    public PricingCalculatorPage setGPUType(String gpuType){
        selectOption(selectGPUType, gpuType);
        return this;
    }

    public PricingCalculatorPage setGPUNumber(String gpuNumber){
        selectOption(selectGPUNumber, gpuNumber);
        return this;
    }

    public PricingCalculatorPage setLocaleSSD(String localeSSD){
        selectOption(selectLocalSSD, localeSSD);
        return this;
    }

    public PricingCalculatorPage setDatacenter(String datacenter){
        selectOption(selectDatacenter, datacenter);
        return this;
    }

    public PricingCalculatorPage setCommittedUsage(String committedUsage){
        selectOption(selectCommittedUsage, committedUsage);
        return this;
    }

    public CalculateResultPage estimate(){
        estimateButton.click();
        logger.info("Estimated Virtual Machine with properties ");
        return new CalculateResultPage(driver);
    }

}
