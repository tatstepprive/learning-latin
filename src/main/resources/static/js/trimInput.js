//alert("CONNECTED");
var inputs=document.querySelectorAll("input[type='text']");
for (var i=0; i<inputs.length; i++){
    inputs[i].addEventListener("change", function () {
 //       console.log("Before trim='"+this.value+"'");
        $(this).val($(this).val().trim());
 //       console.log("After trim='"+this.value+"'");
    });
}