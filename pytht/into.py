import bs4
import requests

from bs4 import BeautifulSoup
from service.OneImgGet import OneImgGet
from util.BeautifulPicture import BeautifulPicture

from service.clic import clicd


clicd.mouse_click(500,280)

# oneImg = OneImgGet()
# oneImg.theBeatlesImg()

# 百度sb表情包
# oneImg.Baidu_SB()


# 抓取腾牛表情包动图


# i = 1
# while (oneImg.TN_GIFImg(i)):
#     i = i + 1

# str = "wu.uq.ndjqwkekqe.dlf"
# inx = str.rindex('.')
# print(inx)

# beau = BeautifulPicture()
# beau.getch()

'''
# 给请求指定一个请求头来模拟chrome浏览器
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36'}

# 也有post具体看requests文档
r = requests.get('https://unsplash.com', headers=headers)
# r.text是http response的网页html文档 print打印
# print(r.text)
html_doc = r.text
# html转换lxml格式
soup = BeautifulSoup(html_doc, 'lxml')
# 获得第一个img标签
tag = soup.find('img')
print("输出标签的值", tag)
print("输出返回值类型", type(tag))
print("输出标签的名字", tag.name)
print("输出标签的style属性", tag['style'])
print("输出图片链接地址", tag['src'])

tags = soup.find('div')
# tags = soup.find_all('img')
# for tag in tags:
#     print("遍历所有img标签", tag)

# 获取navigableString
navStr = tag.string
# 没用不知道为什么
print("输出navigableString", navStr)

# 判断是不是注释
markup = "<b><!--Hey, buddy. Want to buy a used parser?--></b>"
soupoo = BeautifulSoup(markup)
soupzt = soupoo.b.string
print("是不是注释？", type(soupzt))
if type(soupzt) == bs4.element.Comment:
    print("是注释")
else:
    print("不是注释")

# 节点循环
# 直接子节点循环
for cldren in tags.children:
    print("直接子节点", cldren)

soup.parent  # 父节点
# 所有父节点
for prt in tags.parents:
    if prt is None:
        print("没有父节点")
    else:
        print("所有父节点", prt.name)

# 兄弟节点
# soup.b.next_sibling  # 后面的兄弟节点
# soup.c.previous_sibling  # 前面的兄弟节点
# 所有前面兄弟的节点
for strsib in tags.previous_siblings:
    if strsib is None:
        print("前面没有节点")
    else:
        print("所有前面兄弟的节点", strsib.name)
for endsib in tags.next_siblings:
    if not endsib is None:
        print("所有后面兄弟的节点", endsib.name)

# r = requests.get('https://unsplash.com') #像目标url地址发送get请求，返回一个response对象
# print(r.text) #r.text是http response的网页HTML
'''
