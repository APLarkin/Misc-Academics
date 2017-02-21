var x = Math.floor((Math.random() * 100) + 1);
var y = document.getElementByID("Guess").value;
var tries = 10;

if(x > y)
{
	tries = tries-1;
	return "Higher";
}
if(x < y)
{
	tries = tries-1;
	return "Lower";
}
if(tries == 0)
{
	tries = 10;
	return "You lose.";
}
else
{
	return "You win";
}