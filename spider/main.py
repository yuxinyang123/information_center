# -*- coding:utf-8 -*-  

import sys

from edu_getdata import getSchedule
from edu_getdata import getgrade
from edu_getdata import login
from edu_getdata import webclose

if __name__ == "__main__":
    try:
        user = sys.argv[1]
    except Exception as e:
        webclose()
        sys.exit(0)

    try:
        pw = sys.argv[2]
    except Exception as e:
        webclose()
        sys.exit(0)

    login(user, pw)
    getgrade(user, pw)
    getSchedule(user)
    webclose()
