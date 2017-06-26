


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * Created by rashed on 5/5/2017.
 */
public class MainClass {
    private   ArrayList students =new ArrayList();
    public static void main(String []arags) {

        Scanner sc = new Scanner(System.in);
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        Teacher_course_news teacher_course_news = new Teacher_course_news();
        MainClass mainClass = new MainClass();
        while(true) {
            System.out.println("1--- write news ");
            System.out.println("2---- Add new Student ");
            System.out.println("3--- Notify ALL Students");
            int option = sc.nextInt();
            if (option == 1) {
                String input ="";
                System.out.println("write news ");
                try {
                    input= bf.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mainClass.setnews(input, teacher_course_news);
            } else if (option == 2) {
                System.out.println("Student Name");
                String newstudent =sc.next();
                mainClass.addStudent(newstudent, teacher_course_news);
            }
            else if (option==3){
                break;
            }
            else {
                System.out.println("Uncorrect command ");
            }
        }


        try {
            ServerSocket serversocket = new ServerSocket(9109);
            System.out.println("wating forclients .....");
            while(true){
            Socket studentconnection =serversocket.accept();
            Thread_for_Student  thread_for_student = new Thread_for_Student(studentconnection,mainClass,teacher_course_news);
            thread_for_student.start();}
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public void setnews(String news ,Teacher_course_news teacher_course_news){
        teacher_course_news.setNews(news);
    }
    public void addStudent(String name ,Teacher_course_news teacher_course_news){
        Student student = new Student(teacher_course_news,name);
        teacher_course_news.add(student);
        students.add(student);
    }
    public boolean remotelogin(Teacher_course_news teacher_course_news ,String name){
        Student student1 =new Student(teacher_course_news,name);

        int i=0;
        boolean loginstatue =false;
        while (!students.isEmpty() && i < students.size()){

            Student student3 =(Student)students.get(i);
           loginstatue = student3.equals(student1);
        if(loginstatue){
            break;
        }i++;}

        return loginstatue;}
    public String getnews(Teacher_course_news teacher_course_news,String name){
        Student student = new Student(teacher_course_news,name);
        String news = student.update();
    return news;}



    }

