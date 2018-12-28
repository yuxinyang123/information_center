import xlrd
import numpy as np
import xlwt
import csv
import uuid
from pandas import read_csv
def getExcelData(path,sheet_index=0):
    bk=xlrd.open_workbook(path)
    
    sh=bk.sheet_by_index(0)
    row_num=sh.nrows
    col_num=sh.ncols   
    superList = []
    superList1 = []
    dict1={'操作系统':['必修',4.0],'软件测试基础':['必修',2.5],'计算机组成原理':['选修',3.0],'足球':['必修',1.0],'乒乓球':['必修',1.0],'数据结构':['必修',4.0],'面向对象程序设计':['必修',4.0],'大学英语三':['选修',4.0],'高级英语口语':['选修',2.0],'学术英语写作':['选修',2.0],'法律英语与翻译':['选修',2.0],'英语演讲艺术':['选修',2.0],'离散数学':['必修',3.0],'Web开发二':['必修',2.5],'毛泽东思想和中国特色社会主义理论体系概论':['必修',6.0],'学术英语写作入门':['选修',2.0],'方向基础课':['必修',3.0],'职场商务英语':['选修',2.0],'高级英语阅读':['选修',2.0],'概率与统计':['选修',4.0],'轮滑':['必修',1.0],'交谊舞':['必修',1.0],'数据库原理':['必修',3.0],'英语报刊选读':['选修',2.0],'英语修辞':['选修',2.0],'英语基础口语':['选修',2.0],'排球':['必修',1.0],'网球':['必修',1.0],'CMS与模板制作':['选修',1.0],'大学英语四':['必修',4.0],'高级英语视听说':['选修',2.0],'高级英语写作':['选修',2.0],'中国文化概况（英语）':['选修',2.0],'英美外刊导读':['选修',2.0],'英国文学':['选修',2.0]} 
    for i in range(1,row_num):
        row_data=sh.row_values(i)
        studentName=row_data[1]
        for j in range(2,col_num):
            lists=[]
            lists1=[]
            if(row_data[j]==""):
                continue
            else:
                data=row_data[j]
                studentId=row_data[0]
                col_data=sh.col_values(j)
                subject=col_data[0]
                a=uuid.uuid3(uuid.NAMESPACE_DNS,studentId)    
                # for key in dict1:
                #     # print(key)
                #     if(key==subject):
                c=dict1[subject]
                classType=c[0]
                classScore=c[1]
    
                lists.append(a)
                # print(lists)  
                subjectId=j    
                lists.append(subjectId)                
                lists.append(subject)
                lists.append(data)
                lists.append(classType)
                lists.append(classScore)
                superList.append(lists)   
       
        lists1.append(studentId)
        lists1.append(a)
        lists1.append(studentName)
        superList1.append(lists1)
        b=lists1[0]
    
    with open('C:\\Users\\del\\Desktop\\grade.csv','w',newline = "") as csvfile:
        writer = csv.writer(csvfile)
        for singleList in superList:
            writer.writerow(singleList)
    with open('C:\\Users\\del\\Desktop\\id.csv','w',newline = "") as csvfile:
        writer = csv.writer(csvfile)
        for singleList1 in superList1:
            writer.writerow(singleList1)
if __name__ == '__main__':
   
    getExcelData('C:\\Users\\del\\Desktop\\2016.xls')
    
    

    print("hah")