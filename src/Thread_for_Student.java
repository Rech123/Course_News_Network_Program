import java.io.*;
import java.net.Socket;


/**
 * Created by rashed on 5/3/2017.
 */
public class Thread_for_Student extends  Thread{

private Teacher_course_news teacher_course_news ;
    private MainClass mainClass;
   private Socket studentconnection ;

    public Thread_for_Student(Socket studentconnection,MainClass mainClass,Teacher_course_news teacher_course_news){
        this.studentconnection = studentconnection;
        this.teacher_course_news=teacher_course_news;
        this.mainClass=mainClass;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(studentconnection.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(studentconnection.getInputStream()));

            out.println("Log in ");
            String student_password =in.readLine();
            System.out.println(student_password);

          boolean correctpassword =mainClass.remotelogin(teacher_course_news,student_password);
            if(correctpassword){
                String news =mainClass.getnews(teacher_course_news,student_password);
                out.println(news);
            }
            else {
                out.println("passord uncorrect!!!");
            }

            out.close();
            in.close();

            studentconnection.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
