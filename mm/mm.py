# -*- coding: utf-8 -*-
#Author:Victor
#Date:2015-07-06

import urllib
import re
import time
import os
import uuid
import socket

socket.setdefaulttimeout(20)

def get_html(url):
    page = urllib.urlopen(url)
    html = page.read()
    page.close()
    return html

def unique_str():
    return str(uuid.uuid1())

def get_link(html):
    relink = r'class="tit"><a href="(http:.*\.html)"'
    rel = re.compile(relink)
    link = re.findall(rel,html)
    #print link
    return link


def get_name(link):
    html_link = get_html(link)
    rename = r'<title>(.*)</ti'
    ren = re.compile(rename)
    name = re.findall(ren, html_link)
    name = ''.join(name)
    name = name.split(' ')[0]
    #print name
    return name
    


def get_img(link):
    html_img = get_html(link)
    reg = 'src="(http:.*\.jpg)" /><br />'
    imgre = re.compile(reg)
    imglist = re.findall(imgre, html_img)
    print imglist
    homedir = os.getcwd()
    name = get_name(link)
    
    picpath = homedir + '\mm\\' + str(name)
    if not os.path.exists(picpath):
        os.makedirs(picpath)

    for imgurl in imglist:
        x = unique_str() + '.jpg'
        target = picpath + '\\%s' % x
        urllib.urlretrieve(imgurl, target)

if __name__ == "__main__":
    print '''
                 ***         Gentlemen           ***
                 *** Welcome to use this spider  ***
                 *** Created on 2015-07-06       ***
                 ***    @author : victor         ***
          '''
    
    for i in range(1,74):
        try:
            html = get_html('http://www.meizitu.com/a/list_1_%d.html'%i)
            link = get_link(html)
            for li in link:
                get_img(li)
                time.sleep(5)
        except:
            pass

    print "All the images have been downloaded"
            
    
        
     
        
        
    
    
