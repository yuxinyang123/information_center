# -*- coding:utf-8 -*-  
from selenium import webdriver
import time
from math import floor
from bs4 import BeautifulSoup
import requests
import json

t = time.time()
t = floor(t)
st = str(t)

option = webdriver.FirefoxOptions()
option.add_argument('headless')

driver = webdriver.Firefox(firefox_options=option)


def login(username,password):
    url = "http://202.206.100.217/xtgl/dl_loginForward.html?language=&_t="+st

    driver.get(url)

    name_input = driver.find_element_by_id("yhm")
    pass_input = driver.find_element_by_id("mm")
    login_button = driver.find_element_by_id("dl")

    

    name_input.clear()
    name_input.send_keys(username)
    time.sleep(1)
    pass_input.clear
    pass_input.send_keys(password)
    time.sleep(0.5)
    login_button.click()

    time.sleep(0.5)
#    print(driver.get_cookies())

#   time.sleep(1)
#    print(driver.title)


def getgrade(username,password):
    fileObject = open('grade.json', 'a')
    fileObject.write('[\n')

    url2 = "http://202.206.100.217/cjcx/cjcx_cxDgXscj.html?gnmkdm=N305005&layout=default&su="+username
    driver.get(url2)

    time.sleep(2)
    years_one = driver.find_element_by_xpath("//div[@id='xnm_chosen']")
    years_one.click()
    years_two = driver.find_element_by_xpath("//div[@id='xnm_chosen']/div/ul/li[@data-option-array-index='0']")
    years_two.click()

    time.sleep(1)
    semester_one = driver.find_element_by_xpath("//div[@id='xqm_chosen']")
    semester_one.click()
    semester_two = driver.find_element_by_xpath("//div[@id='xqm_chosen']/div/ul/li[@data-option-array-index='0']")
    semester_two.click()

    time.sleep(0.5)
    pagebox = driver.find_element_by_xpath("//select[@class='ui-pg-selbox']/option[@value='300']")
    pagebox.click()

    time.sleep(1)
    search = driver.find_element_by_id("search_go")
    search.click()

    time.sleep(2)
    html = driver.page_source
    
    ulist=[]

    soup = BeautifulSoup(html,'lxml')
    table = soup.find('table',id="tabGrid")
    
   

    for tr in table.find_all('tr'):
        ui=[]
        for td in tr.find_all('td'):
            ui.append(td.string)
        del ui[0]
        del ui[7]
        del ui[9]
        del ui[9]
        del ui[10]
        del ui[11]
        del ui[11]
        del ui[21:25]
        data={}
        data['term'] = ui[0]
        data['class'] = ui[1]
        data['classId'] = ui[2]
        data['className'] = ui[3]
        data['classNature'] = ui[4]
        data['credit'] = ui[5]
        data['grade'] = ui[6]
        data['PerformancePoint'] = ui[7]
        data['testNature'] = ui[8]
        data['classCollege'] = ui[9]
        data['classCategory'] = ui[10]
        data['studyClass'] = ui[11]
        data['teacher'] = ui[12]
        data['sudentId'] = ui[13]
        data['name'] = ui[14]
        data['sex'] = ui[15]
        data['studentNature'] = ui[16]
        data['college'] = ui[17]
        data['major'] = ui[18]
        data['studentGrade'] = ui[19]
        data_json = json.dumps(data,ensure_ascii=False)
        
        ulist.append(data_json)
        
    

    del ulist[0]
    fileObject = open('grade.json', 'a')
    for i in range(len(ulist)):
        fileObject.writelines(ulist[i])
        if i!=len(ulist)-1:
            fileObject.write(','+'\n')
    #    print(ulist[i])   


def webclose():
    driver.close()

     

    
