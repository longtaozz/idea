import requests
import os
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup


class BeautifulPicture():
    def __init__(self):
        # 创建请求头模拟chrome浏览器
        self.headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36'}

    # 使用requests get请求
    def requestget(self, web_url):
        try:
            r = requests.get(web_url, headers=self.headers, timeout=5)
            return r
        except:
            return None

    # 使用selenium get请求
    def seleniumGet(self, web_url):
        try:
            driver = webdriver.Chrome()
            driver.get(web_url)
            return driver
        except:
            return None

    # 创建文件
    def creat_file(self, file_name):
        # 移除首尾空格
        pathx = file_name.strip()
        # 判断文件夹是否存在
        is_hava = os.path.exists(pathx)
        if not is_hava:
            os.makedirs(pathx)
            os.chdir(pathx)
            print("文件夹创建成功")
            return True
        else:
            os.chdir(pathx)
            print("文件夹已存在")
            return False

    # 保存图片img_type:jpg,gif
    def save_img(self, img_url, img_name, img_type):
        r = self.requestget(img_url)
        if r is None:
            print("访问超时")
        else:
            name = img_name + '.' + img_type
            # 文件打开方式（函数资料http://www.runoob.com/python/python-func-open.html）
            f = open(name, 'ab')
            f.write(r.content)
            f.close()
            print("保存成功")

    # 储存图片时创建文件夹单独储存
    def save_img_file(self, img_url, img_name, file_url):
        fileName = file_url + img_name
        if self.creat_file(fileName):
            r = self.requestget(img_url)
            if r is None:
                print("访问超时")
            else:
                name = img_name + '.jpg'
                f = open(name, 'ab')
                f.write(r.content)
                f.close()
                print("保存成功")
        else:
            print("已有此专辑")

    # 判断是否联网
    def network(self):
        NETWORK_STATUS = True
        try:
            requests.get('https://www.taobao.com/', timeout=0.1)
        except requests.exceptions.ConnectTimeout:
            NETWORK_STATUS = False
        print(NETWORK_STATUS)

    def getch(self):
        # 使用chrome浏览器
        driver = webdriver.Chrome()
        url = "https://www.baidu.com"
        driver.get(url)
        print(driver.name)
        print(driver.page_source)

        # 页面下拉至底部实现上拉加载操作
        # driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        # 检查标题是否正确，不正确跳出
        assert "百度一下，你就知道" in driver.title
        # 通过id查找为kw的元素（此为百度输入框）
        inpt = driver.find_element_by_id("kw")
        inpt.clear()
        inpt.send_keys("扶摇")
        # 提交
        inpt.send_keys(Keys.RETURN)
        soup = BeautifulSoup(driver.page_source, 'lxml')
        print(soup)
        # 检查文本是否含有No results found.
        assert "No results found." not in driver.page_source
        time.sleep(10)
        # 关掉当前页面
        driver.close()
        # 关掉浏览器
        driver.quit()

    # 上拉加载
    def dropDown(self, driver, nuber):
        for i in range(nuber):
            # 页面下拉至底部实现上拉加载操作
            driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
            # 暂停10s等待页面加载
            time.sleep(10)
        # 关掉当前页面
        # driver.close()
        # 关掉浏览器
        # driver.quit()
