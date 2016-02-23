package mx.antonioyee.pueblosmagicos.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by antonioyee on 23/02/16.
 */
public class News {

    private String title;
    private String description;
    private Date date;
    private String link;
    private String pathImage;

    public News(String title, String description, Date date, String link, String pathImage) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.link = link;
        this.pathImage = pathImage;
    }

    public News(Date date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public static List<News> getData(){
        List<News> news = new ArrayList<>();

        for(int i=0; i<1000; i++){
            Calendar calendar = Calendar.getInstance();

            News news1 = new News(calendar.getTime(), "This is a automatic Title " + i, "Creating automatic Description " + i);

            news.add(news1);
        }

        return news;
    }

}
