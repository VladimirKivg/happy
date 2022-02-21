function showAlert() {
    alert("The button was clicked!");
}

var muvenColor = document.querySelector('header');
var td = document.querySelectorAll('td')
var button = document.querySelectorAll('.submit')
console.log(button.length)
function f() {
    muvenColor.textContent='давай в перед'
    console.log(muvenColor.valueOf())
}

f()
muvenColor.addEventListener('mouseenter',function () {
this.style.backgroundColor='#F6F764'
    f()
});
muvenColor.addEventListener('mouseleave',function () {
    this.style.backgroundColor='#8BECD5'
    f()
});

for (var x = 0;x<td.length;x++){
    td[x].addEventListener('mouseenter',function () {
this.style.backgroundColor='#826DB2'
    })

    td[x].addEventListener('mouseleave',function () {
        this.style.backgroundColor='#CDBF05'
    })

}
