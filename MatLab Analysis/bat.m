function bat(power)
ymple=-10^9*power+10^6;
yprasino=-10^9*power+10^10;
ykokkino=-10^9*power+1.00001*10^10;
if ymple < 0
    ymple = 0;
end
if yprasino < 0
    yprasino = 0;
end    
if ykokkino < 0
    ykokkino = 0;
end
E = ['average power consumption ', num2str(power), ' W'];
disp(E)
M = ['thin film battery lifetime ', num2str(ymple),' seconds'];
disp(M)
P = ['button cell battery lifetime ', num2str(yprasino),' seconds'];
disp(P)
K = ['smartwatch battery lifetime ', num2str(ykokkino),' seconds'];
disp(K)
end
