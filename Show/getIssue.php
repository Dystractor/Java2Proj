<?php

$servername = "localhost";
$username = "root";
$password = "12345678";
$database = "Java";
$conn = new mysqli($servername, $username, $password, $database);
mysqli_query($conn, "set names 'utf8'"); //数据库输出编码
mysqli_select_db($conn, $database); //打开数据库
$result = mysqli_query($conn, "select issues.state,COUNT(state)
from issues
group by state");
//打开表

$array = array();

class inkcold1
{
    public $state;
    public $count;
}

//mysql_fetch_array() 函数从结果集中取得一行作为关联数组，返回根据从结果集取得的行生成的数组，如果没有更多行则返回 false
while ($row = mysqli_fetch_array($result)) {
    $user = new inkcold1();
    $user->state = $row[0];
    $user->count = $row[1];
    $array[] = $user;//将数据给到数组
}
$data = json_encode($array);//转化为json格式
echo $data;//检查是否能够输出正确的json格式数据。
?>
