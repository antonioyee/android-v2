package mx.antonioyee.feedrecyclerview.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by antonioyee on 24/02/16.
 */
public class Feed {

    private String title;
    private String description;
    private Date date;
    private String pathImage;

    public Feed(String title, String description, Date date, String pathImage) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.pathImage = pathImage;
    }

    public Feed(Date date, String title, String description, String pathImage) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.pathImage = pathImage;
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

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public static List<Feed> getData(){
        List<Feed> aNews = new ArrayList<>();

        for(int i=1; i<=1000; i++){
            Calendar calendar = Calendar.getInstance();

            Feed feed1 = new Feed(calendar.getTime(), "This is a automatic Title " + i, "Description #" + i + " Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.", "http://culturacolectiva.com/wp-content/uploads/2015/08/tradicion-16-septiembre.jpeg");

            aNews.add(feed1);
        }

        return aNews;
    }

}
