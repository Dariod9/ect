y1= lcgRand(1,7e5,0,(2e31)-1,1e4);

subplot(1,2,1);
hist(y1);
nums=length(unique(y1))
