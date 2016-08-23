<?PHP
$getId = $_GET["id"];
$data = "data:$getId,server time:".time();
echo 'var serverData = "'.$data.'";';
?>
