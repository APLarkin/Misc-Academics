

var r = 100;
var g = 200;
var b = 50;

r.document.getElementByID("RVal").value;
g.document.getElementByID("GVal").value;
b.document.getElementByID("BVal").value;

rgb = document.getElementByID("box");

rgb.style.height = "500px";
rgb.style.width = "500px";
rgb.style.backgroundColor = 'rgb(' + r + ',' + g + ',' + b + ')'; 