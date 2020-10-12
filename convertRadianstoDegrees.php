<html>
<head><title>Convert</title></head>
<body>
<font size = 5 color = "red"> Result </font>
<?php 
function convert($choose, $num) {
    $result = 0;
    if($choose == 2){
        $result = $num*180/pi();
        print "<br> Degges = $result";
    }
    if ($choose == 1) {
        $result = $num*pi()/180;
        print "<br> Radians = $result";
    }
}
$num = $_POST["input"];
$choose = $_POST["choose"];
convert($choose, $num)
?>
</body>
</html>