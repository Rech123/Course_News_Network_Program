
public class Student implements Ioberver {
    private Teacher_course_news teacher_course_news ;
    private String studentname ;
    public Student(Teacher_course_news teacher_course_news,String studentname){
        this.teacher_course_news =teacher_course_news ;
        this.studentname =studentname;

    }
    public boolean equals(Student studentinput){
        if(studentinput instanceof Student){
            if(studentinput.studentname.equals(this.studentname)){
                System.out.println("loged in as "+this.studentname);
                return true;
            }

        }
  return false;  }

    @Override
    public String  update() {
        String news_update =teacher_course_news.getNews();
        System.out.println("news ::"+news_update);
    return news_update;}
}
