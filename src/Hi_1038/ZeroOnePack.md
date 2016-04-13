###问题分析
定义F(i,v)表示在前i件物品中，容量为v时能够获取的最大的价值。那么
F(i+1,v)=max(F(i,v),F(i,v-need(i+1))+value(i+1)]，第i+1物品可放可不放。
伪代码1：

```
f(0,0..m)=0
for i=1...n
  for j=need(i)..m
      f(i,j)=max(f(i-1,j),f(i-1,j-need(i))+value(i)
```
减少空间复杂度
我们发现计算f(i,j)的时候，需要f(i-1,j)和f(i-1,j-need(i))的两个值，即在第i轮使用f(i-1,j)和f(i-1,j-need(i))。如果我们将j倒过来的时候，m...need(i)，此时就能这样的结果。

```
f(0..m)=0
for i=1...n
  for j=m..need(i)
      f(j)=max(f(j),f(j-need(i))+value(i)
```
