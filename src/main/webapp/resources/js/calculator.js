 //function that display value
function dis(val) {
     document.getElementById("result").value+=val;
}
   
 //function that clear the display
function clr() {
     document.getElementById("result").value = "";
}

function escapeHtml(unsafe)
{
    return unsafe
         .replaceAll("+", "plus")
         .replaceAll("-", "minus")
		 .replaceAll("*", "multiply")
		 .replaceAll("/", "divide");
 }

function calculate() {
	var expr = document.getElementById("result").value;
 	expr = escapeHtml(expr.toString());
    console.log('expr: ' + expr);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: getContextPath() + "/api/calculate?expr='" + expr + "'",
        timeout: 30000,
        success: function (data) {
           console.log('success: ', data);
           document.getElementById("result").value = data;
        },
        error: function (e) {
            console.log('error: ', e);

        },
        done: function (e) {
            console.log('done');
        }

    })


}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}