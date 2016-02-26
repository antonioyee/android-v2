package mx.antonioyee.pueblosmagicos.models;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import mx.antonioyee.pueblosmagicos.database.DatabaseAdapter;
import mx.antonioyee.pueblosmagicos.database.DatabaseHelper;

/**
 * Created by antonioyee on 23/02/16.
 */
public class MagicTown {

    public static final String TABLE_NAME = "MagicTown";
    public static final String ID_MAGIC_TOWN = "idMagicTown";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String PATH_MAIN_PHOTO = "pathMainPhoto";
    public static final String STATE = "state";

    private int idMagicTown;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private String pathMainPhoto;
    private String state;
    private List<String> links;
    private List<String> photos;

    public MagicTown(String name, String description, Double latitude, Double longitude, String pathMainPhoto, List<String> links, List<String> photos) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pathMainPhoto = pathMainPhoto;
        this.links = links;
        this.photos = photos;
    }

    public MagicTown(String name, String pathMainPhoto) {
        this.name = name;
        this.pathMainPhoto = pathMainPhoto;
    }

    public MagicTown(String name, String state, String pathMainPhoto) {
        this.name = name;
        this.state = state;
        this.pathMainPhoto = pathMainPhoto;
    }

    public MagicTown(int idMagicTown, String name, String description, Double latitude, Double longitude, String pathMainPhoto, String state) {
        this.idMagicTown = idMagicTown;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pathMainPhoto = pathMainPhoto;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPathMainPhoto() {
        return pathMainPhoto;
    }

    public void setPathMainPhoto(String pathMainPhoto) {
        this.pathMainPhoto = pathMainPhoto;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public int getIdMagicTown() {
        return idMagicTown;
    }

    public void setIdMagicTown(int idMagicTown) {
        this.idMagicTown = idMagicTown;
    }

    public static List<MagicTown> getData(){
        List<MagicTown> towns = new ArrayList<>();

        towns.add(new MagicTown("Álamos"," Sonora","http://www.sectur.gob.mx/wp-content/uploads/2014/04/SON_alamos_635-700x275.jpg"));
        towns.add(new MagicTown("Arteaga"," Coahuila","http://www.sectur.gob.mx/wp-content/uploads/2014/04/Arteaga-Bosques-de-Monterreal-2-700x275.jpg"));
        towns.add(new MagicTown("Bacalar"," Quintana Roo","http://www.playasmexico.com.mx/IMG/jpg_bacalar.jpg"));
        towns.add(new MagicTown("Batopilas"," Chihuahua","https://batopilas.files.wordpress.com/2009/04/mexico0702.jpg"));
        towns.add(new MagicTown("Bernal"," Querétaro","http://www.sectur.gob.mx/wp-content/uploads/2014/04/QRO_bernal_94-700x275.jpg"));
        towns.add(new MagicTown("Cadereyta de Montes"," Querétaro","http://www.sectur.gob.mx/wp-content/uploads/2014/04/82957394-700x275.jpg"));
        towns.add(new MagicTown("Calvillo"," Aguascalientes","http://turespacio.com/wp-content/uploads/2014/02/calvillo-2.jpg"));
        towns.add(new MagicTown("Capulálpam de Méndez"," Oaxaca","http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/Capulalpam_de_Mendez/photoEscudo_Capulalpam_de_Mendez_SCAPULALPAM_Home_HEADER_950x434.jpg"));
        towns.add(new MagicTown("Chiapa de Corzo"," Chiapas","http://mexdesc.impresionesaerea.netdna-cdn.com/sites/default/files/styles/adaptive/public/fichas-destino/chiapas_pueblo_magico_chiapa_corzo_aerea_am.jpg"));
        towns.add(new MagicTown("Chignahuapan"," Puebla","https://zonaturistica1.scdn5.secure.raxcdn.com/files/atractivos/1854/A1854.jpg"));
        towns.add(new MagicTown("Cholula"," Puebla","http://static.capital21.df.gob.mx/wp-content/uploads/2015/03/30002113/cholula-1.jpg"));
        towns.add(new MagicTown("Coatepec"," Veracruz","http://www.totonal.com/uploads/coatepec_03.jpg"));
        towns.add(new MagicTown("Comala"," Colima","http://www.pueblosmexico.com.mx/IMG/arton164.jpg"));
        towns.add(new MagicTown("Comitán"," Chiapas","http://www.playasmexico.com.mx/IMG/arton4057.jpg"));
        towns.add(new MagicTown("Cosalá"," Sinaloa","http://www.pueblosmexico.com.mx/IMG/jpg_fuente_sin0303_cosala.jpg"));
        towns.add(new MagicTown("Creel"," Chihuahua","http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/CHI_ntp_Creel/photoEscudo_CHI_ntp_Creel_SCREEL_Impresindible_Barrancadelcobre_Header_950x434.jpg"));
        towns.add(new MagicTown("Cuatro Ciénegas"," Coahuila","https://i.ytimg.com/vi/aJXd23iT5AM/maxresdefault.jpg"));
        towns.add(new MagicTown("Cuetzalan del Progreso"," Puebla","http://www.wikipuebla.poblanerias.com/wp-content/uploads/2012/12/cuetzalanmagico02.jpg"));
        towns.add(new MagicTown("Cuitzeo del Porvenir"," Michoacán","http://www.pueblosmexico.com.mx/IMG/jpg_photoEscudo_Cuitzeo_SCUITZEO_Home_HEADER_950x434.jpg"));
        towns.add(new MagicTown("Dolores Hidalgo"," Guanajuato","http://www.pueblosmexico.com.mx/IMG/arton23406.jpg"));
        towns.add(new MagicTown("El Oro"," México","http://1.bp.blogspot.com/-KL1IYcpoWmE/VliG9H9IZVI/AAAAAAAATZg/IyHf8aZpPgs/s1600/el%2Boro%2Bpueblo%2Bmagico%2Bviaja%2Bbonito.jpg"));
        towns.add(new MagicTown("El Rosario"," Sinaloa","http://www.vmexicoalmaximo.com/sinaloa/img/galleries/el-rosario-g01-p02-catedral-lateral.jpg"));
        towns.add(new MagicTown("El Fuerte"," Sinaloa","http://www.vmexicoalmaximo.com/sinaloa/img/galleries/el-fuerte-g01-p04-fachada-museo.jpg"));
        towns.add(new MagicTown("Huamantla"," Tlaxcala","http://viajeamexico.es/wp-content/uploads/2011/08/mexico1.jpg"));
        towns.add(new MagicTown("Huasca de Ocampo"," Hidalgo","http://www.travel.com.mx/wp-content/uploads/2014/12/21chico1.jpg"));
        towns.add(new MagicTown("Huichapan"," Hidalgo","http://www.hidalgo.travel/wp-content/uploads/2014/11/Huichapan_featured_post.png"));
        towns.add(new MagicTown("Izamal"," Yucatán","http://www.revistaexplore.com/images/contenidoblog/yucatan/image/IZAMAL/Convento.jpg"));
        towns.add(new MagicTown("Jala"," Nayarit","http://www.pueblosmexico.com.mx/IMG/arton23465.jpg"));
        towns.add(new MagicTown("Jalpa"," Guanajuato","http://www.mexicodesconocido.com.mx/assets/images/pueblos%20magicos/yuriria_guanajuato/pueblos-magicos-guanajuato-yuriria-convento-atras.jpg"));
        towns.add(new MagicTown("Jalpan de Serra"," Querétaro","http://turismo.mexplora.com/wp-content/uploads/2014/01/640px-Misi%C3%B3n_Santiago_de_Jalpan1.jpg"));
        towns.add(new MagicTown("Jeréz de García Salinas"," Zacatecas","http://blog.seccionamarilla.com.mx/wp-content/uploads/2014/05/0000_sombrerete_alta.jpg"));
        towns.add(new MagicTown("Jiquilpan"," Michoacán","https://s-media-cache-ak0.pinimg.com/736x/f3/23/51/f3235151dc0ce19fc78c395a5032cf17.jpg"));
        towns.add(new MagicTown("Loreto"," Baja California Sur","http://mexdesc.impresionesaerea.netdna-cdn.com/sites/default/files/fichas-destino/baja_california_sur_pueblo_magico_loreto_am.jpg"));
        towns.add(new MagicTown("Lagos de Moreno"," Jalisco","https://i.ytimg.com/vi/n4-hNHBMZCo/maxresdefault.jpg"));
        towns.add(new MagicTown("Magdalena de Kino"," Sonora","https://i.ytimg.com/vi/9IeCepxScas/maxresdefault.jpg"));
        towns.add(new MagicTown("Malinalco"," México","http://revista.pricetravel.com.mx/wp-content/uploads/carsanper/2014/12/jpg/Viajes-a-pueblos-m%C3%A1gicos.jpg"));
        towns.add(new MagicTown("Mapimi"," Durango","http://www.mispueblos.com.mx/static/imgs/PueblosMagicos/Mapimi-Durango.jpg"));
        towns.add(new MagicTown("Mazamitla"," Jalisco","http://img.informador.com.mx/biblioteca/imagen/370x277/808/807030.jpg"));
        towns.add(new MagicTown("Metepec"," México","http://mexdesc.impresionesaerea.netdna-cdn.com/sites/default/files/styles/adaptive/public/fichas-destino/estado_mexico_pueblo_magico_metepec_plaza_juarez_tlanchana_al.jpg?itok=nlOjrjyw"));
        towns.add(new MagicTown("Mier"," Tamaulipas","http://tamaulipas.gob.mx/wp-content/uploads/2013/12/FOTO-01-COMUNICADO-0498-SEDET.jpg"));
        towns.add(new MagicTown("Mineral de Angangueo"," Michoacán","http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/Angangueo/photoEscudo_Angangueo_SANGANGEO_Home_Header_950x434.jpg"));
        towns.add(new MagicTown("Mineral de Pozos"," Guanajuato","http://www.unionguanajuato.mx/sites/default/files/minasok_0.jpg"));
        towns.add(new MagicTown("Mineral del Chico"," Hidalgo","http://www.mineraldelchico.com.mx/wp-content/uploads/2014/11/MineralDelChico05.jpg"));
        towns.add(new MagicTown("Nochistlán"," Zacatecas","http://www.datatur.sectur.gob.mx/SiteCollectionImages/Pueblos%20Magicos/ZAC_Nochistlan/pueblos-magicos-zacatecas-nochistlan-parian-plaza.jpg"));
        towns.add(new MagicTown("Pahuatlán"," Puebla","http://poblano.mx/archivos/2015/03/Pahuatlan-via-puebla-mexico.com-.jpg"));
        towns.add(new MagicTown("Palizada"," Campeche","http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/Palizada/photoEscudo_Palizada_S_PALIZADA_Home_Header_950x434px.jpg"));
        towns.add(new MagicTown("Papantla"," Veracruz","http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/Papantla_Veracruz/photoEscudo_Papantla_Veracruz_papantla.principal.panoramica.jpg"));
        towns.add(new MagicTown("Parras de la Fuente"," Coahuila","http://www.fovissste.gob.mx/work/models/Expresion_Fovissste/Resource/305/1/images/photoEscudo_Parras_SPARRAS_Home_HEADER_950x434.jpg"));
        towns.add(new MagicTown("Pátzcuaro"," Michoacán","http://www.travelbymexico.com/patzcuaro/preview.jpg"));
        towns.add(new MagicTown("Pino"," Zacatecas","http://www.buscate.com.mx/turismo/turismo-pueblos-magicos-zacatecas-pinos-img0001.jpg"));
        towns.add(new MagicTown("Real de Asientos"," Aguascalientes","https://zonaturistica2.scdn4.secure.raxcdn.com/files/atractivos/1364/A1364.jpg"));
        towns.add(new MagicTown("Real de Catorce"," San Luis Potosi","http://www.suma.mx/images/destinos/realdecatorce/real.jpg"));
        towns.add(new MagicTown("Real de Monte"," Hidalgo","https://zonaturistica2.scdn4.secure.raxcdn.com/files/atractivos/1103/A1103.jpg"));
        towns.add(new MagicTown("Salvatierra"," Guanajuato","http://turespacio.com/wp-content/uploads/2012/12/b464b7b9e81d1c6e36f602b728a406d3_int470.jpg"));
        towns.add(new MagicTown("San Cristobal de las Casas"," Chiapas","http://viamexico.mx/ckeditor/ckfinder/userfiles/images/8406528011_1c9401e4d0_b.jpg"));
        towns.add(new MagicTown("San Sebastián del Oeste"," Jalisco","http://turismo.guadalajaravisit.com/wp-content/uploads/2011/12/san_sebastian_del_oeste_pueblo_m%C3%A1gico.jpg"));
        towns.add(new MagicTown("Santa Clara del Cobre"," Michoacán","http://www.folkartmexico.com/wp-content/uploads/2013/08/Santa-Clara-del-Cobre-Michoacan-Mexico-Pueblo-Magico-Turismo-411.jpg"));
        towns.add(new MagicTown("Santiago"," Nuevo León","http://www.periodicoenfoque.com.mx/wp-content/uploads/2014/06/santiago-NL.jpg"));
        towns.add(new MagicTown("Sombrerete"," Zacatecas","http://www.pueblosmexico.com.mx/IMG/arton23472.jpg"));
        towns.add(new MagicTown("Tacámbaro"," Michoacán","https://www.quadratin.com.mx/www/contenido/uploads/2013/05/Exhibiran-la-herencia-grafica-de-Tacambaro-Michoacan-en-el-MuFi.jpg"));

        return towns;
    }

    public static List<MagicTown> getMagicTowns(){
        List<MagicTown> object = new ArrayList<>();

        Cursor cursor = DatabaseAdapter.getDB().query(TABLE_NAME,null,null,null,null,null,null);

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            int idMagicTown = cursor.getInt(cursor.getColumnIndexOrThrow(ID_MAGIC_TOWN));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(NAME));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION));
            String pathMainPhoto = cursor.getString(cursor.getColumnIndexOrThrow(PATH_MAIN_PHOTO));
            String state = cursor.getString(cursor.getColumnIndexOrThrow(STATE));
            double latitude = cursor.getDouble(cursor.getColumnIndexOrThrow(LATITUDE));
            double longitude = cursor.getDouble(cursor.getColumnIndexOrThrow(LONGITUDE));

            object.add(new MagicTown(idMagicTown, name, description, latitude, longitude, pathMainPhoto, state));
        }

        return object;
    }

    public static void updateMagicTown(MagicTown town){
        ContentValues cv = new ContentValues();

        cv.put(NAME, town.getName());
        cv.put(DESCRIPTION, town.getDescription());
        cv.put(STATE, town.getState());
        cv.put(LATITUDE, town.getLatitude());
        cv.put(LONGITUDE, town.getLongitude());
        cv.put(PATH_MAIN_PHOTO, town.getPathMainPhoto());

        DatabaseAdapter.getDB().update(TABLE_NAME, cv, ID_MAGIC_TOWN + "=" + town.getIdMagicTown(), null);
    }
}
