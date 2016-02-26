package mx.antonioyee.pueblosmagicos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by antonioyee on 26/02/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MagicTowns.db";
    private static final Integer VER_1 = 1;
    private static final Integer DATABASE_VERSION = VER_1;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MagicTown (" +
                "   idMagicTown integer  NOT NULL   PRIMARY KEY AUTOINCREMENT," +
                "   name varchar(250)  NOT NULL," +
                "   description text," +
                "   state varchar(250)  NOT NULL," +
                "   latitude double," +
                "   longitude double," +
                "   pathMainPhoto text  NOT NULL" +
                ");");

        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Álamos',' Sonora','http://www.sectur.gob.mx/wp-content/uploads/2014/04/SON_alamos_635-700x275.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Arteaga',' Coahuila','http://www.sectur.gob.mx/wp-content/uploads/2014/04/Arteaga-Bosques-de-Monterreal-2-700x275.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Bacalar',' Quintana Roo','http://www.playasmexico.com.mx/IMG/jpg_bacalar.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Batopilas',' Chihuahua','https://batopilas.files.wordpress.com/2009/04/mexico0702.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Bernal',' Querétaro','http://www.sectur.gob.mx/wp-content/uploads/2014/04/QRO_bernal_94-700x275.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Cadereyta de Montes',' Querétaro','http://www.sectur.gob.mx/wp-content/uploads/2014/04/82957394-700x275.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Calvillo',' Aguascalientes','http://turespacio.com/wp-content/uploads/2014/02/calvillo-2.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Capulálpam de Méndez',' Oaxaca','http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/Capulalpam_de_Mendez/photoEscudo_Capulalpam_de_Mendez_SCAPULALPAM_Home_HEADER_950x434.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Chiapa de Corzo',' Chiapas','http://mexdesc.impresionesaerea.netdna-cdn.com/sites/default/files/styles/adaptive/public/fichas-destino/chiapas_pueblo_magico_chiapa_corzo_aerea_am.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Chignahuapan',' Puebla','https://zonaturistica1.scdn5.secure.raxcdn.com/files/atractivos/1854/A1854.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Cholula',' Puebla','http://static.capital21.df.gob.mx/wp-content/uploads/2015/03/30002113/cholula-1.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Coatepec',' Veracruz','http://www.totonal.com/uploads/coatepec_03.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Comala',' Colima','http://www.pueblosmexico.com.mx/IMG/arton164.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Comitán',' Chiapas','http://www.playasmexico.com.mx/IMG/arton4057.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Cosalá',' Sinaloa','http://www.pueblosmexico.com.mx/IMG/jpg_fuente_sin0303_cosala.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Creel',' Chihuahua','http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/CHI_ntp_Creel/photoEscudo_CHI_ntp_Creel_SCREEL_Impresindible_Barrancadelcobre_Header_950x434.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Cuatro Ciénegas',' Coahuila','https://i.ytimg.com/vi/aJXd23iT5AM/maxresdefault.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Cuetzalan del Progreso',' Puebla','http://www.wikipuebla.poblanerias.com/wp-content/uploads/2012/12/cuetzalanmagico02.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Cuitzeo',' Michoacán','http://www.pueblosmexico.com.mx/IMG/jpg_photoEscudo_Cuitzeo_SCUITZEO_Home_HEADER_950x434.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Dolores Hidalgo',' Guanajuato','http://www.pueblosmexico.com.mx/IMG/arton23406.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('El Oro',' México','http://1.bp.blogspot.com/-KL1IYcpoWmE/VliG9H9IZVI/AAAAAAAATZg/IyHf8aZpPgs/s1600/el%2Boro%2Bpueblo%2Bmagico%2Bviaja%2Bbonito.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('El Rosario',' Sinaloa','http://www.vmexicoalmaximo.com/sinaloa/img/galleries/el-rosario-g01-p02-catedral-lateral.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('El Fuerte',' Sinaloa','http://www.vmexicoalmaximo.com/sinaloa/img/galleries/el-fuerte-g01-p04-fachada-museo.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Huamantla',' Tlaxcala','http://viajeamexico.es/wp-content/uploads/2011/08/mexico1.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Huasca de Ocampo',' Hidalgo','http://www.travel.com.mx/wp-content/uploads/2014/12/21chico1.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Huichapan',' Hidalgo','http://www.hidalgo.travel/wp-content/uploads/2014/11/Huichapan_featured_post.png')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Izamal',' Yucatán','http://www.revistaexplore.com/images/contenidoblog/yucatan/image/IZAMAL/Convento.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Jala',' Nayarit','http://www.pueblosmexico.com.mx/IMG/arton23465.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Jalpa',' Guanajuato','http://www.mexicodesconocido.com.mx/assets/images/pueblos%20magicos/yuriria_guanajuato/pueblos-magicos-guanajuato-yuriria-convento-atras.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Jalpan de Serra',' Querétaro','http://turismo.mexplora.com/wp-content/uploads/2014/01/640px-Misi%C3%B3n_Santiago_de_Jalpan1.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Jeréz de García Salinas',' Zacatecas','http://blog.seccionamarilla.com.mx/wp-content/uploads/2014/05/0000_sombrerete_alta.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Jiquilpan',' Michoacán','https://s-media-cache-ak0.pinimg.com/736x/f3/23/51/f3235151dc0ce19fc78c395a5032cf17.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Loreto',' Baja California Sur','http://mexdesc.impresionesaerea.netdna-cdn.com/sites/default/files/fichas-destino/baja_california_sur_pueblo_magico_loreto_am.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Lagos de Moreno',' Jalisco','https://i.ytimg.com/vi/n4-hNHBMZCo/maxresdefault.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Magdalena de Kino',' Sonora','https://i.ytimg.com/vi/9IeCepxScas/maxresdefault.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Malinalco',' México','http://revista.pricetravel.com.mx/wp-content/uploads/carsanper/2014/12/jpg/Viajes-a-pueblos-m%C3%A1gicos.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Mapimi',' Durango','http://www.mispueblos.com.mx/static/imgs/PueblosMagicos/Mapimi-Durango.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Mazamitla',' Jalisco','http://img.informador.com.mx/biblioteca/imagen/370x277/808/807030.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Metepec',' México','http://mexdesc.impresionesaerea.netdna-cdn.com/sites/default/files/styles/adaptive/public/fichas-destino/estado_mexico_pueblo_magico_metepec_plaza_juarez_tlanchana_al.jpg?itok=nlOjrjyw')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Mier',' Tamaulipas','http://tamaulipas.gob.mx/wp-content/uploads/2013/12/FOTO-01-COMUNICADO-0498-SEDET.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Mineral de Angangueo',' Michoacán','http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/Angangueo/photoEscudo_Angangueo_SANGANGEO_Home_Header_950x434.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Mineral de Pozos',' Guanajuato','http://www.unionguanajuato.mx/sites/default/files/minasok_0.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Mineral del Chico',' Hidalgo','http://fotos.eluniversal.com.mx/web_img/fotogaleria/21chico1.JPG')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Nochistlán',' Zacatecas','http://www.samaelgnosis.net/congresos/2014/fotos_nochistlan/nochistlan_calidad_028.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Pahuatlán',' Puebla','http://poblano.mx/archivos/2015/03/Pahuatlan-via-puebla-mexico.com-.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Palizada',' Campeche','http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/Palizada/photoEscudo_Palizada_S_PALIZADA_Home_Header_950x434px.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Papantla',' Veracruz','http://www.visitmexico.com/work/models/PueblosMagicos30/WebPage/Papantla_Veracruz/photoEscudo_Papantla_Veracruz_papantla.principal.panoramica.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Parras de la Fuente',' Coahuila','http://www.fovissste.gob.mx/work/models/Expresion_Fovissste/Resource/305/1/images/photoEscudo_Parras_SPARRAS_Home_HEADER_950x434.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Pátzcuaro',' Michoacán','http://www.travelbymexico.com/patzcuaro/preview.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Pino',' Zacatecas','http://www.buscate.com.mx/turismo/turismo-pueblos-magicos-zacatecas-pinos-img0001.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Real de Asientos',' Aguascalientes','https://zonaturistica2.scdn4.secure.raxcdn.com/files/atractivos/1364/A1364.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Real de Catorce',' San Luis Potosi','http://www.suma.mx/images/destinos/realdecatorce/real.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Real de Monte',' Hidalgo','https://zonaturistica2.scdn4.secure.raxcdn.com/files/atractivos/1103/A1103.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Salvatierra',' Guanajuato','http://turespacio.com/wp-content/uploads/2012/12/b464b7b9e81d1c6e36f602b728a406d3_int470.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('San Cristobal de las Casas',' Chiapas','http://viamexico.mx/ckeditor/ckfinder/userfiles/images/8406528011_1c9401e4d0_b.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('San Sebastián del Oeste',' Jalisco','http://turismo.guadalajaravisit.com/wp-content/uploads/2011/12/san_sebastian_del_oeste_pueblo_m%C3%A1gico.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Santa Clara del Cobre',' Michoacán','http://www.folkartmexico.com/wp-content/uploads/2013/08/Santa-Clara-del-Cobre-Michoacan-Mexico-Pueblo-Magico-Turismo-411.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Santiago',' Nuevo León','http://www.periodicoenfoque.com.mx/wp-content/uploads/2014/06/santiago-NL.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Sombrerete',' Zacatecas','http://www.pueblosmexico.com.mx/IMG/arton23472.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tacámbaro',' Michoacán','https://www.quadratin.com.mx/www/contenido/uploads/2013/05/Exhibiran-la-herencia-grafica-de-Tacambaro-Michoacan-en-el-MuFi.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tapalpa',' Jalisco','http://blog.seccionamarilla.com.mx/wp-content/uploads/2015/02/tapalpa.png')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tapijulapa',' Tabasco','http://mexdesc.impresionesaerea.netdna-cdn.com/sites/default/files/styles/adaptive/public/fichas-destino/tabasco_pueblo_magico_tapijulapa_iglesia_santiago_apostol_ir_0.jpg?itok=q2DOuHtM')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Taxco',' Guerrero','http://radiomil.com.mx/radiomil/system/storage/serve/295924/Screenshot_3.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tecate',' Baja California','http://turespacio.com/wp-content/uploads/2013/01/amanecer-en-tecate.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tepotzotlán',' México','http://www.lohechoenmexico.mx/mximg3/fotos/m_9071_Tepotzotlan_Lo_hecho_en%20mexico.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tepoztlán',' Morelos','http://www.noticiasggl.com/wp-content/uploads/2015/03/bv02150.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tequila',' Jalisco','http://image.posta.com.mx/sites/default/files/00214.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tequisquiapan',' Querétaro','http://www.queretaro.travel/uploads/AtractivosTURISMO/713863515_tequisportada.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Teúl de González Ortega',' Zacatecas','http://mexico.cnn.com/media/2013/09/25/teul-zacatecas.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tlatlauquitepec',' Puebla','http://www.wikipuebla.poblanerias.com/wp-content/uploads/2014/07/tlatlaq.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tlayacapan',' Morelos','http://viajandomexico.com/wp-content/uploads/2013/05/ex-convento-de-la-natividad-de-tlayacapan-morelos.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tlalpujahua',' Michoacán','http://www.vmexicoalmaximo.com/images/noticias/2014/6/santuario/santuario.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Todos Santos',' Baja California Sur','http://www.mispueblos.com.mx/static/imgs/PueblosMagicos/Todos-Santos-Baja-California-Sur.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tula',' Tamaulipas','http://tamaulipas.gob.mx/wp-content/uploads/2010/12/tula04.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Tzintzuntzan',' Michoacán','http://www.brianovercast.com/img/s/v-3/p143771716-3.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Valladolid',' Yucatán','http://blog.maestrotvsnte.mx/wp-content/uploads/2015/11/5.-Valladolid16-1.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Valle de Bravo',' México','http://www.visitmexico.com/work/models/VisitMexico30/WebPage/VDB_Water_sports_Activity_Ac/photoEscudo_VDB_Water_sports_Activity_Ac_watersports.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Viesca',' Coahuila','http://www.mexicodesconocido.com.mx/assets/images/pueblos%20magicos/viesca_coahuila/pueblos-magicos-viesca-coahuila-capilla-santa-ana-jul13.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Xico',' Veracruz','http://radiomil.com.mx/radiomil/system/storage/serve/325368/foto1_1.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Xicotepec','Puebla','http://www.corazondepuebla.com.mx/images/xicotepec02.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Xilitla',' San Luis Potosí','https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRxik37NRPHLBUHQ3tBAnRM5jvsJ5McRh7QZo6wp7CSlEPYt6doFQ')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Yuriria',' Guanajuato','http://www.pueblosmexico.com.mx/IMG/arton23486.jpg')");
        db.execSQL("INSERT INTO MagicTown (name, state, pathMainPhoto) VALUES ('Zacatlán',' Puebla','https://es.wikipedia.org/wiki/Zacatl%C3%A1n#/media/File:SanPedroZacatlan01.JPG')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if ( oldVersion != DATABASE_VERSION ){
            db.execSQL("DROP TABLE IF EXIST MagicTown");
        }
    }

}
