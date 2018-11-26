# -*- coding:utf-8 -*-  

import edu_getdata
from edu_getdata import login
from edu_getdata import getgrade
from edu_getdata import webclose
from edu_getdata import getSchedule
import sys
import getopt


if __name__ == "__main__":
    user = sys.argv[1]
    pw = sys.argv[2]
    login(user,pw)
    getgrade(user,pw)
    getSchedule(user)
    webclose()
    