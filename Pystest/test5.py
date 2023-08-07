import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By



@pytest.fixture
def browser():
    driver = webdriver.Chrome()
    driver.implicitly_wait(10)
    url = "https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/"
    driver.get(url)
    yield driver
    driver.quit()


# Test to verify title of main URL
def test5q(browser):
    expected_title = "Want to practice test automation? Try these demo sites! | Automation Panda"
    assert expected_title in browser.title
    print("\n Page Tittle: ",browser.title, "\n ***** Main Title is verified ***** ")


    #speaking
    speaking = browser.find_element(By.ID, "menu-item-10593")
    speaking.click()
    expectedT = "Speaking | Automation Panda"
    assert expectedT == browser.title
    print(" Page Title: ",browser.title,"\n ***** Speaking Page Title is verified ***** ")


    #keynoteAddress
    keynoteAddr = browser.find_element(By.CLASS_NAME, "wp-block-heading")
    assert keynoteAddr.is_displayed()
    expected = "Keynote Addresses"
    assert expected == keynoteAddr.text
    print("\n ***** Keynote Address Text is verified ***** ")

    #ConferebceTalks
    conferenceTalks = browser.find_element(By.XPATH, "//h2[@id='conferences']")
    assert conferenceTalks.is_displayed()
    expected_text = "Conference Talks"
    assert expected_text == conferenceTalks.text
    print("\n ***** Conference Talks Text is verified ***** ")