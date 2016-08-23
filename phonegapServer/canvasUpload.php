<?php
$data = $_POST['data'];
$fileName = time().".png";
//removing the "data:image/png;base64," part
$uri =  substr($data,strpos($data,",")+1);
$decodedData = base64_decode($uri);
$fp = fopen($fileName, 'wb');
fwrite($fp, $decodedData);
fclose($fp);
echo "png=$fileName<BR>";
echo "<img src=$fileName>";
?>
