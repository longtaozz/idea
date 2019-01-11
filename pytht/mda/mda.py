import pandas as pd

from pylab import *

names = np.array(['Bob', 'Joe', 'Will', 'Bob', 'Will', 'Joe', 'Joe'])
print(names[2])

s = pd.Series(np.random.randint(0, 7, size=10))  # 统计出现的个数,左边是下标,右边是出场的次数
x = s.value_counts()  # 统计个数
print(x)




fig, ax = plt.subplots()
ax.plot(x, x**2, label=r"$y = \alpha^2$")
ax.plot(x, x**3, label=r"$y = \alpha^3$")
ax.legend(loc=2) # upper left corner
ax.set_xlabel(r'$\alpha$', fontsize=18)
ax.set_ylabel(r'$y$', fontsize=18)
ax.set_title('title')

plt.show()

fig.savefig("filename.png", dpi=200)
