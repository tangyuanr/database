package com.company;

import java.sql.*;

public class DatabaseManagementSystem {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        Connection connect = DriverManager
                .getConnection("jdbc:mysql://localhost/oyc353_4", "oyc353_4", "Coyote18");

        // Statements allow to issue SQL queries to the database
        Statement statement = connect.createStatement();


        //populate Student table
//        for(int i= 0;i<50;i++){
//            String sqlQuery = "insert into Student(SID, Name, gender, email) values("+i+", 'Student "+i+"', "+(int)(Math.random()*2)+", 'Student"+i+"@example.com');";
//            statement.execute(sqlQuery);
//        }

        //populate Members + Demos + Teams table
        int SID=0;
        for(int i=0;i<10;i++){
            int NoOfMembers= (int)(Math.random()*4+1);

            String DemoDate="";
            String role = "";

            int TeamLeader = 0;
            String sqlQueryTeams="";
            if (1==(int)(Math.random()*2)){
                TeamLeader=SID;
                sqlQueryTeams="insert into Teams(TID, LeaderID, NoOfMembers) VALUES("+i+", "+TeamLeader+", "+(NoOfMembers)+")";
            }
            else {
                sqlQueryTeams="insert into Teams(TID, NoOfMembers) VALUES("+i+","+(NoOfMembers)+")";
            }
//            String sqlQueryTeams="insert into Teams(TID, LeaderID, NoOfMembers) VALUES("+i+", , "+NoOfMembers+")";
            statement.execute(sqlQueryTeams);
            System.out.println(sqlQueryTeams);


            if (1==(int)(Math.random()*2)){
                DemoDate="2018-03-01";
            }
            else {
                DemoDate="2018-03-02";
            }
            String time = "0"+i+":00:00";
            for(int j=0;j<NoOfMembers;j++){

                if (j==0 && TeamLeader!=0){
                    role="Team leader";
                }
                else
                    role="Member";
                String sqlQueryMembers = "insert into Members(SID, TID, datejoined, role) VALUES ("+SID+", "+i+", '2018-02-14', \'"+role+"\');";
                System.out.println(sqlQueryMembers);
                statement.execute(sqlQueryMembers);

                //insert demo
                String sqlQueryDemos="insert into Demos(SID, TID, Date, time) VALUES ("+SID+", "+i+", \'"+DemoDate+"\', \'"+time+"\')";
                statement.execute(sqlQueryDemos);
                System.out.println(sqlQueryDemos);

                SID+=1;
            }

        }






//        statement.executeQuery(sqlQuery);

    }
}
