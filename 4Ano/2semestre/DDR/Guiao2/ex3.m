G= [ 1 2
 1 3
 1 4
 1 5
 1 6
 1 14
 1 15
 2 3
 2 4
 2 5
 2 7
 2 8
 3 4
 3 5
 3 8
 3 9
 3 10
 4 5
 4 10
 4 11
 4 12
 4 13
 5 12
 5 13
 5 14
 6 7
 6 16
 6 17
 6 18
 6 19
 7 19
 7 20
 8 9
 8 21
 8 22
 9 10
 9 22
 9 23
 9 24
 9 25
 10 11
 10 26
 10 27
 11 27
 11 28
 11 29
 11 30
 12 30
 12 31
 12 32
 13 14
 13 33
 13 34
 13 35
 14 36
 14 37
 14 38
 15 16
 15 39
 15 40
 20 21];

%%
%a

g = graph(G(:,1), G(:,2));

fid = fopen('ex3.lp', 'wt');

fprintf(fid, 'Minimize\n');
for i= 6:40
   if i <= 15
       fprintf(fid, ' + %f x%d', 12, i);    % tier2
   else
       fprintf(fid, ' + %f x%d', 8, i);     % tier3
   end
end

fprintf(fid, '\nSubject To\n');
for j = 6:40
    for i = 6:40
        [p, d] = shortestpath(g, j, i);
        if d <= 2
            fprintf(fid, ' + x%d', i);
        end
    end
    fprintf(fid, ' >= %f\n', 1);
end


fprintf(fid,'Binary\n');
for i = 6:40
    fprintf(fid, ' x%d', i);
end

fprintf(fid,'\nEnd\n');
fclose(fid);

%%
%b


results= 0; %zeros(1,N); %vector with N simulation results
results2= 0; %zeros(1,N); %vector with N simulation results

r1=0;
r2=0;

r_tier2 = 10 * 5000;
r_tier3 = 25 * 2500;
total_requests_per_day = (r_tier2 + r_tier3) / 24;

lambda = total_requests_per_day;

%for n=1:100
%    for W=0:1000
results=zeros(1,5);
results2=zeros(1,5);
n=[74 75 76 77 78];
W=[49000 50000 51000 52000 53000];
R=50000;
for i=1:5
    [results(i) results2(i)] = simulator2(lambda,30,n(i),1000,W(3),R,'movies.txt');
end

figure(1)

bar(n, [results; results2])                


grid on

media = mean(results);
media2 = mean(results2);
fprintf(" Media 1 : %.7f \n",media)
fprintf(" Media 2 : %.7f \n \n",media2)


%%
%c

n9=7*2500+4*5000;
n13=6*2500+5*5000;
n16=6*2500+3*5000;
n21=3*2500+3*5000;
n30=6*2500+3*5000;


totalClients=10*5000+25*2500;

perc9=n9/totalClients;
perc13=n13/totalClients;
perc16=n16/totalClients;
perc21=n21/totalClients
perc30=n30/totalClients;

totalServers=76;

servers9=perc9*totalServers
servers13=perc13*totalServers
servers16=perc16*totalServers
servers21=perc21*totalServers
servers30=perc30*totalServers

totalServersNeeded=round(servers9)+round(servers13)+round(servers16)+round(servers21)+round(servers30);

realServers9=round(servers9)*totalServers/totalServersNeeded
realServers13=round(servers13)*totalServers/totalServersNeeded
realServers16=round(servers16)*totalServers/totalServersNeeded
realServers21=round(servers21)*totalServers/totalServersNeeded
realServers30=round(servers30)*totalServers/totalServersNeeded