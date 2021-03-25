function retval = px (a)

N = 1e5; 
p = 0.5;
n = 4;
if a=0 or a=n
  return nchoosea(n,k)*(p^a)*(1-p^(n-a))
elseif a=1
  return nchoosea(n,k)*(p^0)*(1-p^(n-0)) + nchoosea(n,k)*(p^a)*(1-p^(n-a))
 elseif a=2
  return nchoosea(n,k)*(p^0)*(1-p^(n-0)) + nchoosea(n,k)*(p^1)*(1-p^(n-1)) + nchoosea(n,k)*(p^0)*(1-p^(n-0)) + nchoosea(n,k)*(p^2)*(1-p^(n-2))

 endfunction