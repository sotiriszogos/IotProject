function harv(power)
y1=0.09*power+0.091;
y2=0.09*power+0.91;
y3=0.09*power+9.1;
y4=0.09*power+91;
E = ['average power consumption ', num2str(power), ' ÏW'];
disp(E)
X1 = ['for photovoltaic (outdoor) and thermal (industrial) the harvester size is ', num2str(y1),' mm'];
disp(X1)
X2 = ['for vibration/motion the harvester size is ', num2str(y2),' mm'];
disp(X2)
X3 = ['for photovoltaic (indoor), air flow and thermal the harvester size is ', num2str(y3),' mm'];
disp(X3)
X4 = ['for electromagnetic the harvester size is ', num2str(y4),' mm'];
disp(X4)
end
