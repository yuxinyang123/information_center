
#import login2
#from login2 import getgrade
#from login2 import login
import edu_grade
from edu_grade import login
from edu_grade import getgrade
from edu_grade import webclose
import sys
import getopt


if __name__ == "__main__":
    fileObject = open('grade.json', 'a')
    user = sys.argv[1]
    pw = sys.argv[2]
    login(user,pw)
    getgrade(user,pw)
    fileObject.write('\n]')
    fileObject.close()
    webclose()
    