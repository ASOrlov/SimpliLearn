
var x = (2 * 3) + 5; //11
var y = 3 * 4;//12

var result = myFunction(2,3);
console.log(result);

function myFunction(num1, num2) {
	var a = num1 * num2; //6 12
	var b = num1 + num2;//5 7
	return(a + b); //11
}

console.log( myFunction(3, 4));

function toCelcius(f){
		return (5/9) * (f-32);
}

console.log("The temperature is "+ toCelcius(60));
