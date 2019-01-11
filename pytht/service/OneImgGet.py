# coding=utf-8
import time

from util.BeautifulPicture import BeautifulPicture
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.keys import Keys


class OneImgGet():
    def __init__(self):
        self.url = "https://unsplash.com"

    # 获取https://unsplash.com所有img标签里的图片（第一版）
    def img_pic(self):
        file_path = "F:\\asapk\pyImg"
        beauti = BeautifulPicture()
        r = beauti.requestget(self.url)

        # 获得请求的网页文档html
        str_code = r.text
        # 将html请求内容转为lxml
        soup = BeautifulSoup(str_code, 'lxml')
        # 获得所有img标签
        label_imgs = soup.find_all('img')

        # 创建文件
        beauti.creat_file(file_path)
        # 图片数组
        for img in label_imgs:
            if not img is None:
                img_url = img['src']
                # 时间当作文件名称
                img_name = time.strftime("%Y%m%d%H%M%S", time.localtime())
                beauti.save_img(img_url, img_name)

    def two_img_pic(self):
        file_path = "F:\\asapk\pyImg"
        beauti = BeautifulPicture()
        r = beauti.seleniumGet(self.url)
        # 执行5次下拉操作
        beauti.dropDown(r, 5)

        # 将html请求内容转为lxml
        soup = BeautifulSoup(r.page_source, 'lxml')
        # 获得所有img标签
        label_imgs = soup.find_all('img')

        # 创建文件
        beauti.creat_file(file_path)
        # 图片数组
        for img in label_imgs:
            if not img is None:
                img_url = img['src']
                # 时间当作文件名称
                img_name = time.strftime("%Y%m%d%H%M%S", time.localtime())
                beauti.save_img(img_url, img_name)

    def theBeatlesImg(self):
        beauti = BeautifulPicture()
        url = "http://music.163.com/#/artist/album?id=12107534&limit=20&offset=0"
        file_path = "F:\\asapk\pyImg\\TiMo\\"

        # 使用phantomJs处理js数据
        driver = webdriver.PhantomJS()
        driver.get(url)
        # 加载iframe中html内容
        driver.switch_to.frame("g_iframe")
        html = driver.page_source
        soup = BeautifulSoup(html, 'lxml')
        lis = soup.find(id='m-song-module').find_all('li')
        for li in lis:
            album_name = li.find('p', class_='dec')['title']
            # 对名称进行相应的处理
            file_name = album_name.replace('/', '').replace(':', ',')
            # 发布时间，现在没用到
            album_date = li.find('span', class_='s-fc3').get_text()
            img = li.find('img')
            imgSrc = img["src"]
            ind = imgSrc.index('?')
            # 截掉?后面参数拿到完整的图片
            imgUrl = imgSrc[:ind]
            beauti.save_img_file(imgUrl, file_name, file_path)

    def Baidu_SB(self):
        beauti = BeautifulPicture()
        url = "https://image.baidu.com/"
        file_path = "F:\\asapk\pyImg\SB"

        driver = webdriver.Chrome()
        driver.get(url)

        # 创建文件
        beauti.creat_file(file_path)
        # 获取输入框
        inp = driver.find_element_by_id('kw')
        inp.clear()
        inp.send_keys("傻子表情包")
        inp.send_keys(Keys.RETURN)
        time.sleep(2)
        # 执行3次下拉操作
        beauti.dropDown(driver, 30)

        soup = BeautifulSoup(driver.page_source, 'lxml')
        imgDiv = soup.find(id="imgid")
        imgs = imgDiv.find_all('img')
        for img in imgs:
            imgSrc = img['src']
            # 时间当作文件名称
            img_name = time.strftime("%Y%m%d%H%M%S", time.localtime())
            beauti.save_img(imgSrc, img_name)
            time.sleep(1)

    # 抓头牛腾情包
    def TN_GIFImg(self, page):
        beauti = BeautifulPicture()
        # 创建文件夹存放表情包
        file_path = "F:\\asapk\pyImg\TNGIF\\"
        url = "https://www.qqtn.com/bq/dtbq_" + str(page) + ".html"
        print(url)
        t_url = "https://www.qqtn.com"
        driver = beauti.requestget(url)
        driver.encoding = 'GBK'
        lhtml = BeautifulSoup(driver.text, 'lxml')
        gifAll = lhtml.find(class_="g-gxlist-imgbox")
        ul_lis = gifAll.find_all('li')
        if len(ul_lis) < 20:
            # 小于20为最后一页
            return False

        for index in range(len(ul_lis)):
            # 循环所有的li
            a = ul_lis[index].find('a')
            # 检查人气是否满足要求
            btext = a.find('b').string
            if int(btext) > 5000:
                # 过滤掉5000以下人气的表情包
                # 获得表情包的标题
                gif_name = a.find('strong').string
                # 判断是否有相同的表情包
                gif_file = file_path + gif_name
                is_have = beauti.creat_file(gif_file)
                if is_have:
                    bao_url = t_url + a['href']
                    driver_bao = beauti.requestget(bao_url)
                    driver_bao.encoding = 'GBK'
                    bao_lhtml = BeautifulSoup(driver_bao.text, 'lxml')
                    # 检查拿到的链接请求是否失败，失败不做抓取
                    if "404页面未找到_腾牛网" != bao_lhtml.find('title'):
                        zoom = bao_lhtml.find(id='zoom')
                        zoom_ps = zoom.find_all('p')
                        for i in range(len(zoom_ps)):
                            if i != 0:
                                for zoom_p_img in zoom_ps[i].find_all('img'):
                                    gif_url = zoom_p_img['src']
                                    img_type = gif_url[gif_url.rindex('.')+1:]
                                    # 时间当作文件名称
                                    img_name = time.strftime("%Y%m%d%H%M%S", time.localtime())
                                    beauti.save_img(gif_url, img_name, img_type)
                                    time.sleep(1)
            if (len(ul_lis) - 1 == index):
                return True
        return False
