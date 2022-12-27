<?php
require("sql_config.php");
$servername ="localhost";
$username ="root";
$password ="12345678";
$database = "Java";
$conn = new mysqli($servername, $username, $password,$database);
mysqli_query($conn,"set names 'utf8'"); //数据库输出编码
mysqli_select_db($conn,$database); //打开数据库
$result = mysqli_query($conn,"select user_id,username from developers");//打开表

$array= array();
class Users{
    public $userid;
    public $username;
}
//mysql_fetch_array() 函数从结果集中取得一行作为关联数组，返回根据从结果集取得的行生成的数组，如果没有更多行则返回 false
while($row = mysqli_fetch_array($result)){
    $users = new Users();
    $users->userid = $row[0];
    $users->username = $row[1];
    $array[] = $users;//将数据给到数组
}
echo $row;
$data=json_encode($array);//转化为json格式
echo $data;//检查是否能够输出正确的json格式数据。
?>
