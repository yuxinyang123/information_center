# -*- coding:utf-8 -*-  
from bs4 import BeautifulSoup
import requests
import re



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

    # for (i,j,k) in zip(titles,hotnums,hoturl):
    #     print(titles[i],hotnums[j],hoturl[k])

    for i in range(len(hotnums)):
        print(str(i)+"|"+titles[i]+"|"+hotnums[i]+"|"+hoturl[i])


if __name__ == "__main__":
    clawer()