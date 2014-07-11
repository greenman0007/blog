function countTime(){
    var i = 6;
    i--;
    if(i==-1)
      return null;
    document.getElementById("time").innerHTML = i;
    setTimeout("countTime();",1000);
}