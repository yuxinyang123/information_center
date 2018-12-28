# -*- coding:utf-8 -*-  
from bs4 import BeautifulSoup
import requests
import re
import json



def clawer():
    url = "http://s.weibo.com/top/summary?cate=realtimehot"
    r = requests.get(url)


    titles = []
    hotnums = []
    hoturl = []
    html = r.text

    soup = BeautifulSoup(html,'lxml')
    title = soup.find_all('td',class_='td-02')
    for i in title:
        uspan = i.find('span')
        ua = i.find('a')
        if uspan:
            hotnums.append(uspan.get_text())
            titles.append(ua.get_text())
            hoturl.append('http://s.weibo.com'+ua.attrs['href'])

    
    ulists = []
    for i in range(len(hotnums)):
        lists = []
        lists.append(i+1)
        lists.append(titles[i])
        lists.append(hotnums[i])
        lists.append(hoturl[i])
        data = {}
        data['id'] = lists[0]
        data['title'] = lists[1]
        data['hotnum'] = lists[2]
        data['hoturl'] = lists[3]
        ulists.append(data)
    
    hotjson = json.dumps(ulists,ensure_ascii=False)
    print(hotjson)
    


if __name__ == "__main__":
    clawer()