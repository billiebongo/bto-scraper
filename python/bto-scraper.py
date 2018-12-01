#before running script, get the URL

import sys
import urllib.request as req
from bs4 import BeautifulSoup
from lxml import html
import re
import os
import time
import json
def is_number(s):
    try:
        int(s)
        return True
    except ValueError:
        return False



def urlForEachBlock(town,flat_type,dateno,blockno, neighbourhood, contract):
    town=town.replace(" ","+")
    flat_type=flat_type.replace("(","%28")
    flat_type=flat_type.replace(" ","+")
    flat_type=flat_type.replace(")","%29")
    flat_type=flat_type.replace("/","%2F")
    url = "https://services2.hdb.gov.sg/webapp/BP13AWFlatAvail/BP13EBSFlatSearch?Town=" + town + "&Flat_Type=BTO&" + "selectedTown="+ town + "&Flat=" + flat_type+"&ethnic=Y&ViewOption=A&Block=" + blockno +"&DesType=A&EthnicA=Y&EthnicM=&EthnicC=&"+"EthnicO=&numSPR=&dteBallot="+dateno+"&Neighbourhood="+ neighbourhood +"&Contract="+ contract +"&BonusFlats1=N&searchDetails=&brochure=false";
    return url

def makeFileName(blockno, flat_type_c):
    flat_type_c=flat_type_c.replace("%20", "").replace("(","").replace(")","").replace("/","").replace("$","")
    file_name=blockno+"_"+flat_type_c
    return file_name


##No parser was explicitly specified, so I'm using the best available HTML parser for this
#system ("lxml"). This usually isn't a problem, but if you run this code on another system, or
#in a different virtual environment, it may use a different parser and behave differently.

def parseText(blockno,flat_type_c): #per block, return (POSSESSION_COMPLETION_IMG_STREET_COORD_ETHNIC_UNITS)
#returns possession, completion, img, street, coordinates, ethnic, quota, units
    f_name=makeFileName(blockno, flat_type_c)
    print("looking for "+f_name)
    filename=str(f_name+".html")
    f = open(filename,'r').read()
    string2="" #IMPT!!
    completion="null"
    possession="null"
    ethnic_quota="null"
    textsoup = BeautifulSoup(f)
    #returns street, completion, possession and coorc
    with req.urlopen("https://maps.googleapis.com/maps/api/geocode/json?address=clementi+ave+6+singapore") as url:
        data = json.loads(url.read().decode())
    results=data["results"]
    coord=results[0]["geometry"]["location"]
    lat=coord["lat"]
    lng=coord["lng"]
    string2=string2+str(lat)+","+str(lng)+"**"
    rs=""
    rs=textsoup.find("div", {"id": "blockDetails"}).findAll("div", {"class":"large-5 columns"})[0] #LOCATION
    string2=string2+rs.text.strip()+"**"
    rs=textsoup.find("div", {"id": "blockDetails"}).findAll("div", {"class":"large-7 columns"}) #COMPLETION AND POSSESSION
    if rs[0]: #got possession?
        string2=string2+str(rs[0].text.strip())+"**"
    else:
        string2=string2+"no possession stated"+"**"
    if rs[1]: #got completion?
        string2=string2+str(rs[1].text.strip())+"**"
    else:
        string2=string2+"no completion stated"+"**"
    """
    if rs[2]: #ehtnic quota
        string2=string2+str(rs[2].text.strip())+"**"
    else:
        string2=string2+"no ethnic quota stated"+"**"
    """
    #get sitePlan image
    q=textsoup.findAll("script",{"type":"text/javascript"}) #assuming its the 2nd script js tag
    if q[1]:
        startPos=q[1].text.find("var sitePlan    = \"http://esales.hdb.gov.sg/hdbvsf/ea")
        endPos=q[1].text.find(".png")
        string2=string2+q[1].text[int(startPos+19):int(endPos+4)]+"**"
    #get UNITS separated by ,
    blockDets=textsoup.find("div", {"id": "blockDetails"})

    tables=blockDets.findAll("table")
    td_in_table2=tables[1].findAll("td")
    units_string=""
    for unit in td_in_table2: #FIND AVAILABLE BLOCKS
        if unit.find("font",{"color":"#000099"}):
            units_string=units_string+str(unit.text.strip())[0:-2]+","
    string2=string2+units_string
    #for td in tds:
        #if td['onclick']:
        #print(td.text)

    return string2





"""
def createTextForEachLink(): #UNUSED
    print("creating new  file")
    try:
        name="newfile.txt"
        file=open(name,'a')

        file.close()
    except:
            print("error occured")
            sys.exit(0)
"""

def getBlockDetails(blockno, flat_type_c, url): #given URL produce text
    os.system("cd /Applications")
    print(url)
    openURL="chrome-cli open \""+url+"\""
    os.system(openURL)
    time.sleep(8)
    flat_type_c=flat_type_c.replace("%20", "").replace("(","").replace(")","").replace("/","").replace("$","")
    filename_command="chrome-cli source > "+blockno+"_"+flat_type_c+".html"
    print(filename_command)
    os.system(filename_command)
    os.system("chrome-cli close")
    #os.system("chrome-cli close")

def writeListToFile(ls):
    print("creating new  file")
#    try:
    name="newfile.txt"
    f=open(name,"w")
    for l in ls:
        f.write(str(l+"\n"))
    f.close()
    #except:
            #print("error occured")
            #sys.exit(0)

#def getCoordinateForEach():
def getListOfBuildings(): #return list of buildings with the building URL
    home_page="https://services2.hdb.gov.sg/webapp/BP13AWFlatAvail/BP13SEstateSummary?sel=BTO"
    page = req.urlopen(home_page)
    soup = BeautifulSoup(page, "html.parser")
    towncodes=[]
    indivBlockURL=[]
    listOfRoomTypePerTown=[]
    data=[]
    opt=soup.findAll("option")
    for el in opt:
        if not (("Any" in (str(el.text))) or ("2017" in (str(el.text))) or ("2016" in (str(el.text)))):
            towncodes.append(str(el["value"]))
    for towncode in towncodes:
        select_town=soup.find("div", {"id": towncode})
        try:
            select_tds=select_town.find("tbody").findAll("td")

            for select_td in select_tds: #FOR EACH FLAT_TYPE
                if (is_number(str(select_td.text))==False) and ("Room" in select_td.text):
                    tc=towncode.split(";")
                    dateno=tc[0]#
                    town=tc[1]
                    flat_type=str(select_td.text)
                    flat_type_c=flat_type.replace(" ","%20")
                    town_c=town.replace(" ", "%20")
                    #URL PER BUILDING/FLATYPE
                    url = "https://services2.hdb.gov.sg/webapp/BP13AWFlatAvail/BP13EBSFlatSearch?Town=" + town_c + "&Flat_Type=BTO&" +"DesType=A&ethnic=Y&Flat=" + flat_type_c + "&ViewOption=A&dteBallot=" + dateno +"&projName=";

                    ###FOR EACH BLOCK URL, GET THE BLOCKDETAILS
                    page = req.urlopen(url)
                    indiv_building_soup = BeautifulSoup(page, "html.parser")
                    table=indiv_building_soup.findAll("table")
                    for t in table: #actlly only one
                        searchOnClicks=t.findAll("div")
                        for searchOnClick in searchOnClicks:
                            if (searchOnClick['onclick']) and ("$" not in flat_type) and ("#cc0000" not in str(searchOnClick)): #for now
                                checkBlk=str(searchOnClick["onclick"])[10:-3].split("','")
                                blockno=checkBlk[0]
                                neighbourhood=checkBlk[1]
                                contract=checkBlk[2]
                                string1=blockno+"**"+town+"**"+"NULLBUILDING"+"**"+dateno+"**"+flat_type
                                """
                                urlPerBlock=urlForEachBlock(town,flat_type,dateno,blockno,neighbourhood,contract)

                                print(urlPerBlock)
                                getBlockDetails(blockno, flat_type_c ,urlPerBlock)
                                indivBlockURL.append(urlPerBlock)
                                """

                                string1=string1+"**"+parseText(blockno,flat_type_c)
                                data.append(string1)
                                print(string1)
                                string1=""


        except TypeError:
            print("NoneType")
    """
    writeListToFile(indivBlockURL)
    #print(indivBlockURL)

    """
    return data






getListOfBuildings()
#expect all the text files and newfile.text and print list of buldings URL finally


#f=open("newfile.txt","w")
#for item in listOfBlockUrl:
#    f.write(str(item+"\n"))
#f.close()

#link="https://services2.hdb.gov.sg/webapp/BP13AWFlatAvail/BP13EBSFlatSearch?Town=Clementi&Flat_Type=BTO&selectedTown=Clementi&Flat=4-Room&ethnic=Y&ViewOption=A&projName=A&Block=209A&DesType=A&EthnicA=Y&EthnicM=&EthnicC=&EthnicO=&numSPR=&dteBallot=201702&Neighbourhood=N2&Contract=C3&BonusFlats1=N&searchDetails=&brochure=false"
#getBlockDetails("810", link)
#print(parseText(str(8000)))
#getListOfBuildings()
