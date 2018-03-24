<html>
<head>
    Department Management
</head>
<body>

<form action="" method="post">
    ID: <input type="text" name="ID"><br>
    <input type="submit" value="Show department by ID'" name="getByID">
</form>
<br>
<br>
<form action="" method="get">
    <input type="submit" value="Show all departments'" name="getAll">
</form>

</body>
</html>
<?php
/**
 * Created by IntelliJ IDEA.
 * User: JY
 * Date: 2018-03-24
 * Time: 12:14 PM
 */

require_once ('DBConnector.php');

$DB = new DBConnector();
$DB->connect();

if (isset($_POST['getByID'])){
    echo "you entered " . $_POST['ID'];
    $ID = $_POST['ID'];
    $sqlQuery = "SELECT * FROM Department WHERE DID='$ID'";
    while($row = $DB->parse_query($sqlQuery))
    {
        //echo $row['Player'];
    }
}

if (isset($_GET['getAll'])){
    $sqlQuery = "SELECT * FROM Department";
    $result = $DB->parse_query($sqlQuery);
    while($row = mysqli_fetch_assoc($result)) {
        foreach($row as $k => $v){
            echo $k."->".$v." ";
        }
        echo "<br>";
    }
}

?>