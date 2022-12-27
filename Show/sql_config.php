<?php
//


$servername = "localhost";
$serverUsername = "root";
$serverPassword = "12345678";
$dbname = "Java";





////这部分的功能是读表数据并且转为json格式，便于js处理。
//require("sql_config.php");
//$db = mysqli_connect($servername,$serverUsername,$serverPassword,$dbname) or die("error connecting");
//mysqli_query($db, "set names 'utf8'"); //数据库输出编码
//mysqli_select_db($db, $dbname); //打开数据库
//$result = mysqli_query($db, "select * from commits");//打开你的表
//$data = "";
//$array = array();
//
//class User
//{
//    public $id;
//    public $place;
//    public $num;//字段添加处1
//}
//
//while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC)) {
//    $user = new User();
//    $user->id = $row['id'];
//    $user->place = $row['place'];
//    $user->num = $row['num'];//字段添加处2
//    $array[] = $user;
//}
//$data = json_encode($array);
//// echo "{".'"user"'.":".$data."}";
//echo $data;

