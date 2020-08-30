package com.company;

import com.mysql.cj.log.Log;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Students {

    public static void main(String[] args) {
        Students pro= new Students();
        pro.GreaterThan8CGPA();
        pro.Infosys();
        pro.SortByRollno();
    }

    void GreaterThan8CGPA(){
        try{
            // create connection to the schema mydb1
            Class.forName("com.mysql.cj.jdbc.Driver");
            // at port 8080 where schema is mydb1 and username and password are both root
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/mydb1", "root", "root");
            System.out.println("Connection to mydb1 success!");

            // print roll numbers, names and cgpa's from table student info for students having more than 8 cgpa
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NAME, ROLLNO, CGPA FROM STUDENT_INFO WHERE CGPA>8");
            System.out.println("PART - 1 :-");
            System.out.println("ROLLNO"+"\t|\t "+"NAME"+"\t\t\t|\t "+"CGPA");
            System.out.println(("_________________________________________\n"));
            while(rs.next()){
                int id = rs.getInt("ROLLNO");
                String name = rs.getString("NAME");
                float cgpa = rs.getFloat("CGPA");
                System.out.println(id+"\t\t|\t "+name+"\t\t|\t "+cgpa);
            }

        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    void Infosys(){
        try{
            // create connection to the schema mydb1
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/mydb1", "root", "root");
            System.out.println("Connection to mydb1 success!");

            // print roll numbers, names and companies from table student info for students placed at infosys
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NAME, ROLLNO, COMPANY FROM STUDENT_INFO WHERE COMPANY='Infosys'");
            System.out.println("\n\nPART - 2 :-");
            System.out.println("ROLLNO"+"\t|\t "+"NAME"+"\t\t\t|\t "+"COMPANY");
            System.out.println(("____________________________________________\n"));
            while(rs.next()){
                int id = rs.getInt("ROLLNO");
                String name = rs.getString("NAME");
                String company = rs.getString("COMPANY");
                System.out.println(id+"\t\t|\t "+name+"\t\t|\t "+company);
            }

        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    void SortByRollno(){
        try{
            // create connection to the schema mydb1
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/mydb1", "root", "root");
            System.out.println("Connection to mydb1 success!");

            // print roll numbers and names from table student info after sorting the roll number column in ascending order
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NAME, ROLLNO FROM STUDENT_INFO ORDER BY ROLLNO ASC");
            System.out.println("\n\nPART - 3 :-");
            System.out.println("ROLLNO"+"\t|\t "+"NAME");
            System.out.println(("_____________________\n"));
            while(rs.next()){
                int id = rs.getInt("ROLLNO");
                String name = rs.getString("NAME");
                System.out.println(id+"\t\t|\t "+name);
            }

        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

}