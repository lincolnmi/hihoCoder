令values(i,S)表示前i个位置，(i-m+1)到i这些位置是否被打扫如S集合中所表示的那样时，可以打扫的最多垃圾数。
则 i位置被选中
values(i,S)=max(values(i-1,S - {i-m} + {i-m被选}),values(i-1,S - {i-m} + {i-m未选})) + array[i]
i位置未被选中
values(i,S)=max(values(i-1,S - {i-m} + {i-m被选}),values(i-1,S - {i-m} + {i-m未选}))