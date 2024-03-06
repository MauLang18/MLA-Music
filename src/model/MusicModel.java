/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants;

/**
 *
 * @author maula
 */
public class MusicModel implements Identificable{
    private int Id;
    private String NombreCancion;
    private String Artista;
    private String Album;
    private int Anio;
    private String Duracion;
    private int IdPlaylist;
    private String Ruta;

    public MusicModel() {
    }

    public MusicModel(int Id, String Nombre, String Artista, String Album, int Anio, String Duracion, int IdPlaylist, String Ruta) {
        this.Id = Id;
        this.NombreCancion = Nombre;
        this.Artista = Artista;
        this.Album = Album;
        this.Anio = Anio;
        this.Duracion = Duracion;
        this.IdPlaylist = IdPlaylist;
        this.Ruta = Ruta;
    }

    public MusicModel(String Nombre, String Artista, String Album, int Anio, String Duracion, int IdPlaylist, String Ruta) {
        //this.Id = 
        this.NombreCancion = Nombre;
        this.Artista = Artista;
        this.Album = Album;
        this.Anio = Anio;
        this.Duracion = Duracion;
        this.IdPlaylist = IdPlaylist;
        this.Ruta = Ruta;
    }

    @Override
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombreCancion() {
        return NombreCancion;
    }

    public void setNombreCancion(String NombreCancion) {
        this.NombreCancion = NombreCancion;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String Album) {
        this.Album = Album;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public int getIdPlaylist() {
        return IdPlaylist;
    }

    public void setIdPlaylist(int IdPlaylist) {
        this.IdPlaylist = IdPlaylist;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }
}
