# _*_ coding:UTF-8 _*_
import win32api
import win32con
from ctypes import *
import time

class clicd():
    def mouse_click(x=None,y=None):
        if not x is None and not y is None:
            clicd.mouse_move(x,y)
            time.sleep(0.05)
        win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0)
        win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, 0, 0, 0, 0)
    def mouse_dclick(x=None,y=None):
        if not x is None and not y is None:
            clicd.mouse_move(x,y)
            time.sleep(0.05)
        win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0)
        win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, 0, 0, 0, 0)
        win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0)
        win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, 0, 0, 0, 0)
    def mouse_move(x,y):
        windll.user32.SetCursorPos(x, y)
