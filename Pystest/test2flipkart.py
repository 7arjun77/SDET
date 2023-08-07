import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture
def browser():
    driver = webdriver.Chrome()
    driver.implicitly_wait(10)
    url = "https://www.flipkart.com/"
    driver.get(url)
    yield driver
    driver.quit()

def LOGINandMSG(browser):
    browser.maximize_window()
    browser.find_element(By.XPATH,"//button[@class='_2KpZ6l _2doB4z']").click()
    login_button = browser.find_element(By.PARTIAL_LINK_TEXT,"Login")
    #login_button = browser.find_element(By.XPATH,"//*[@id='container']/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[2]/div[2]/div/div/div")
    assert login_button.is_displayed()
    login_button.click()


    #enter ph no
    PH = browser.find_element(By.XPATH,"//div[@class='_36HLxm col col-3-5']//form//input[@type='text']")
    number = "7994189262"
    PH.send_keys(number)
    OTP = browser.find_element(By.XPATH,"//button[contains(text(), 'Request OTP')]")
    OTP.click()


    #message = browser.find_element(By.XPATH,"//div[contains(text(), 'Please enter the OTP sent to')]")
    message = browser.find_element(By.XPATH,"/html/body/div[2]/div/div/div/div/div[2]/div/div/div[1]")
    phmessage=browser.find_element(By.XPATH,"/html/body/div[2]/div/div/div/div/div[2]/div/div/div[2]/span")

    expmsg = "Please enter the OTP sent to "+ number
    actualmsg= message.text +" "+ phmessage.text
    print("\n Popup message verified \n The message:  "+actualmsg)

    #validating messages
    assert expmsg == actualmsg
