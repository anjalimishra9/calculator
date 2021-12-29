//function that display value
function dis(val) {
	document.getElementById("result").value += val;
}

//function to allow only numeric and +-*/. characters
function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	var isValid = ((charCode >= 48 && charCode <= 57) || (charCode >= 42 && charCode <= 46));
	//alert('charCode:'+ charCode + ',isValid:' + isValid);
	return isValid;
}

//function that clear the display
function clr() {
	document.getElementById("result").value = "";
}

function escapeHtml(unsafe) {
	return unsafe
		.replaceAll("+", "plus")
		.replaceAll("-", "minus")
		.replaceAll("*", "multiply")
		.replaceAll("/", "divide");
}

function calculate() {
	var expr = document.getElementById("result").value;	
	var pattern = /^[\/|_]|[~"#%&*:<>?\\{|}]|[\+\-\*\.\/]{2,}|[\+\-\*\.\/|.]$/;
	var isValidExpression = !pattern.test(expr);
	//alert(expr + ':' + isValidExpression);
	if (isValidExpression) {
		expr = escapeHtml(expr.toString());
		console.log('expr: ' + expr);

		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: getContextPath() + "/api/calculate?expr='" + expr + "'",
			timeout: 30000,
			success: function(data) {
				console.log('success: ', data);
				document.getElementById("result").value = data;
			},
			error: function(e) {
				console.log('error: ', e);

			},
			done: function(e) {
				console.log('done');
			}

		})
	} else {
		alert("Found Invalid Expression:" + expr + "!");
		clr();
	}


}

function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}