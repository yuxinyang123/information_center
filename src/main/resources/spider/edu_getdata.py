# -*- coding:utf-8 -*-  
import json
import re
import time
from bs4 import BeautifulSoup
from math import floor
from selenium import webdriver
from pyvirtualdisplay import Display

display = Display(visible=0, size=(800, 800))  
display.start()
t = time.time()
t = floor(t)
st = str(t)

# 火狐浏览器无界面运行
#options = webdriver.FirefoxOptions()
#options.add_argument("--headless")
#options.add_argument('--disable-gpu')
#driver = webdriver.Firefox(firefox_options=options)


# 谷歌浏览器无界面运行
# chrome_options = webdriver.ChromeOptions()
# chrome_options.add_argument('--headless')
# chrome_options.add_argument('--disable-gpu')
# driver = webdriver.Chrome(executable_path="/home/chromeheadless/chromedriver",chrome_options=chrome_options)
chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--window-size=1420,1080')
chrome_options.add_argument('--headless')
chrome_options.add_argument('--disable-gpu')
driver = webdriver.Chrome(executable_path="/home/spiderresource/chromedriver",chrome_options=chrome_options)


def login(username, password):
    url = "http://202.206.100.217/xtgl/dl_loginForward.html?language=&_t=" + st

    try:
        driver.get(url)
    except Exception:
        # print("网络异常",e)
        webclose()

    name_input = driver.find_element_by_id("yhm")
    pass_input = driver.find_element_by_id("mm")
    login_button = driver.find_element_by_id("dl")

    name_input.clear()
    name_input.send_keys(username)
    time.sleep(0.2)
    pass_input.clear
    pass_input.send_keys(password)
    time.sleep(0.2)
    login_button.click()

    time.sleep(0.2)


def getgrade(username, password):
    url2 = "http://202.206.100.217/cjcx/cjcx_cxDgXscj.html?gnmkdm=N305005&layout=default&su=" + username
    driver.get(url2)

    time.sleep(0.2)
    try:
        years_one = driver.find_element_by_xpath("//div[@id='xnm_chosen']")
    except Exception:
        # print("password false",identifier)
        webclose()
    years_one.click()
    years_two = driver.find_element_by_xpath("//div[@id='xnm_chosen']/div/ul/li[@data-option-array-index='0']")
    years_two.click()

    time.sleep(0.2)
    semester_one = driver.find_element_by_xpath("//div[@id='xqm_chosen']")
    semester_one.click()
    semester_two = driver.find_element_by_xpath("//div[@id='xqm_chosen']/div/ul/li[@data-option-array-index='0']")
    semester_two.click()

    time.sleep(0.2)
    pagebox = driver.find_element_by_xpath("//select[@class='ui-pg-selbox']/option[@value='300']")
    pagebox.click()

    time.sleep(0.2)
    search = driver.find_element_by_id("search_go")
    search.click()

    time.sleep(1)
    html = driver.page_source

    ulist = []

    soup = BeautifulSoup(html, 'lxml')
    table = soup.find('table', id="tabGrid")

    for tr in table.find_all('tr'):
        ui = []
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
        data = {}
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
    dataJsonGrade = json.dumps(ulist, ensure_ascii=False)

    print('{"GRADE":')
    print(dataJsonGrade)
    print(',')


def getSchedule(user):
    url = "http://202.206.100.217/kbcx/xskbcx_cxXskbcxIndex.html?gnmkdm=N2151&layout=default&su=" + user
    driver.get(url)

    time.sleep(0.2)
    try:
        table_button = driver.find_element_by_xpath("//div[@id='tb']/button[@href='#table2']")
    except Exception:
        webclose()
    table_button.click()

    time.sleep(0.2)
    html = driver.page_source

    soup = BeautifulSoup(html, "lxml")
    table = soup.find('table', id="kblist_table")

    ulist = []

    for tr in table.find_all('tbody'):
        ui = []
        for td in tr.find_all('td'):
            ui.append(td.get_text())

            list2 = ['time1', 'time2', 'time3', 'time4', 'time5', 'time6', 'time7', 'time8', 'time9', 'time10',
                     'time11', 'time12', 'time13', 'time14',
                     'time15', 'time16', 'time17', 'time18', 'time19', 'time20', 'time21', 'time22', 'time23', 'time24']
            list3 = ['week', 'class1', 'class2', 'class3', 'class4', 'class5', 'class6', 'class7', 'class8', 'class9',
                     'class10', 'class11',
                     'class12', 'class13', 'class14', 'class15', 'class16', 'class17', 'class18', 'class19', 'class20']
            d = {}
            for i in range(len(ui)):
                if re.match(r'\d', ui[i]):
                    d[list2[i]] = ui[i]
                else:
                    d[list3[i]] = ui[i]
        ulist.append(d)

    del ulist[0]

    data = {}
    data["Monday"] = ulist[0]
    data["Tuesday"] = ulist[1]
    data["Wednesday"] = ulist[2]
    data["Thursday"] = ulist[3]
    data["Friday"] = ulist[4]
    data["Saturday"] = ulist[5]
    data["Sunday"] = ulist[6]
    dataJsonSchedule = json.dumps(data, ensure_ascii=False)

    print('"CLASS":')
    print(dataJsonSchedule)
    print('}')


def webclose2():
    driver.close()


def webclose():
    driver.close()
