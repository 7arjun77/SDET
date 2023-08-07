import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture
def browser():
    driver = webdriver.Chrome()
    driver.implicitly_wait(10)
    url = "https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/"
    driver.get(url)
    driver.maximize_window()
    yield driver
    driver.quit()



# Test for Main page title
def mainTitle(browser):
    expected_title = "Automation Panda"
    assert expected_title in browser.title
    print("\n        Page Tittle:        ", browser.title, "\n         ***** Main Title is verified   *****                ")



# Test for speakiing
def speaking(browser):
    speaking = browser.find_element(By.ID, "menu-item-10593")
    speaking.click()
    expectedT = "Speaking | Automation Panda"
    assert expectedT == browser.title
    print("\n     Page Title:      ", browser.title,"\n         *****   Speaking Page Title is verified   *****                ")


# Test for Keynote Addresss
def keynote_addresses(browser):
    speaking = browser.find_element(By.ID, "menu-item-10593")
    speaking.click()
    keynoteAddr = browser.find_element(By.CLASS_NAME, "wp-block-heading")
    assert keynoteAddr.is_displayed()
    expected = "Keynote Addresses"
    assert expected == keynoteAddr.text
    print("\n         ***** Keynote Address Text is verified   *****                ")



# Test for conference talks
def conference_talks(browser):
    speaking = browser.find_element(By.ID, "menu-item-10593")
    speaking.click()
    conferenceTalks = browser.find_element(By.XPATH, "//h2[@id='conferences']")
    assert conferenceTalks.is_displayed()
    expected_text = "Conference Talks"
    assert expected_text == conferenceTalks.text
    print("\n         ***** Conference Talks Text is verified   *****                ")