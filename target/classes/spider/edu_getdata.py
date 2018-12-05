# -*- coding:utf-8 -*-  
from selenium import webdriver
import time
from math import floor
from bs4 import BeautifulSoup
import requests
import json
import re

t = time.time()
t = floor(t)
st = str(t)
 
options = webdriver.FirefoxOptions()
options.set_headless()
options.add_argument('--disable-gpu')
driver = webdriver.Firefox(firefox_options=options)



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

def getgrade(username,password):
    
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
        data['teacher'] = ui[11]
        data['studentId'] = ui[12]
        data['stuName'] = ui[13]
        data['sex'] = ui[14]
        data['studentNature'] = ui[15]
        data['college'] = ui[16]
        data['major'] = ui[17]
        data['year'] = ui[18]
        data['studentGrade'] = ui[19]
        
        ulist.append(data)
        
    del ulist[0]
    dataJsonGrade = json.dumps(ulist,ensure_ascii=False)
    
    print('{"GRADE":')
    print(dataJsonGrade)
    print(',')
   
def getSchedule(user):
    url = "http://202.206.100.217/kbcx/xskbcx_cxXskbcxIndex.html?gnmkdm=N2151&layout=default&su="+user
    driver.get(url)
    
    time.sleep(0.5)
    table_button = driver.find_element_by_xpath("//div[@id='tb']/button[@href='#table2']")
    table_button.click()

    time.sleep(0.5)
    html = driver.page_source

    soup = BeautifulSoup(html,"lxml")
    table = soup.find('table',id="kblist_table")

    ulist=[]

    for tr in table.find_all('tbody'):
        ui=[]
        for td in tr.find_all('td'):
            ui.append(td.get_text())
           
            list2=['time1','time2','time3','time4','time5','time6','time7','time8','time9','time10','time11','time12','time13','time14',
            'time15','time16','time17','time18','time19','time20','time21','time22','time23','time24']
            list3=['week','class1','class2','class3','class4','class5','class6','class7','class8','class9','class10','class11',
            'class12','class13','class14','class15','class16','class17','class18','class19','class20']
            d={}
            for i in range(len(ui)):               
                if re.match(r'\d',ui[i]):                 
                    d[list2[i]]=ui[i]
                else:
                    d[list3[i]]=ui[i]
        ulist.append(d)

    del ulist[0]

    data={}
    data["Monday"]=ulist[0]
    data["Tuesday"]=ulist[1]
    data["Wednesday"]=ulist[2]
    data["Thursday"]=ulist[3]
    data["Friday"]=ulist[4]
    data["Saturday"]=ulist[5]
    data["Sunday"]=ulist[6]
    dataJsonSchedule = json.dumps(data,ensure_ascii=False)    

    print('"CLASS":')
    print(dataJsonSchedule)
    print('}')

def webclose2():
    driver.close()

def webclose():
    driver.close()

     

    
