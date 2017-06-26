import java.util.ArrayList;
import java.util.List;

public class Teacher_course_news implements IObsevable {
    private List<Ioberver> StudentsList ;
    private String news ;
    private String course_code ;

    public Teacher_course_news(){
        StudentsList=new ArrayList();
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void add(Ioberver ioberver) {
        if (ioberver instanceof Ioberver){
        StudentsList.add(ioberver);}

    }

    @Override
    public void remover(Ioberver ioberver) {
StudentsList.remove(ioberver);
    }

    @Override
    public void Notify() {
        for (Ioberver ioberver :StudentsList){
             ioberver.update();
            }
    }


}
