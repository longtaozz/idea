from selenium import webdriver

# 设置为google浏览器
driver = webdriver.Chrome
driver.maximize_window()
driver.implicitly_wait(26)
url = "https://www.baidu.com"
driver.get(url)
# # 判断关键词是否在网站中不在中断
# assert "百度一下，你就知道" in driver.title
# # 查找id为kw的元素，此为输入框
# elem = driver.find_element_by_id("kw")
# elem.clear()
# # 搜索imqq
# elem.send_keys("imqq")
# # 提交
# elem.send_keys(Keys.RETURN)
# # 如果页面中有No results found则退出
# assert "No results found." not in driver.page_source
# print(driver)
