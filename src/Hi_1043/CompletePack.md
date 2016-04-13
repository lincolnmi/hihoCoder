f(0,0..m)=0
for i=1..n
	for j=need(i)..m
		f(j)=max(f(j),f(j-need(i))+value(i))