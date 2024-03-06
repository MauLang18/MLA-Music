/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import interfaces.IPlaylistServices;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Conexion;
import model.PlaylistModel;
import java.sql.Connection;
import datos.Lista;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

/**
 *
 * @author maula
 */
public class PlaylistServices extends Conexion implements IPlaylistServices{

    @Override
    public boolean agregarPlaylist(PlaylistModel request) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="INSERT INTO TB_PLAYLIST (Nombre) VALUES (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, request.getNombre());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean modificarPlaylist(PlaylistModel request) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarOC (?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, request.getId());
            ps.setString(2, request.getNombre());
            ps.setString(3, request.getImagen().toString());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean eliminarPlaylist(PlaylistModel request) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarOC (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, request.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }

    @Override
    public Lista<PlaylistModel> obtenerPlaylist() {
        Lista<PlaylistModel> listaPlaylists = new Lista<>();

        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM TB_PLAYLIST";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                PlaylistModel playlist = new PlaylistModel();
                playlist.setId(rs.getInt("id"));
                playlist.setImagen(new ImageIcon(getClass().getResource("/icon/playlistImg.jpg")));
                playlist.setNombre(rs.getString("nombre"));

                listaPlaylists.insertarAlFinal(playlist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listaPlaylists;
    }

    @Override
    public Lista<PlaylistModel> obtenerUltimaPlaylist() {
        Lista<PlaylistModel> listaPlaylists = new Lista<>();

        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM TB_PLAYLIST ORDER BY Id DESC LIMIT 1";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                PlaylistModel playlist = new PlaylistModel();
                playlist.setId(rs.getInt("id"));
                playlist.setImagen(new ImageIcon(getClass().getResource("/icon/playlistImg.jpg")));
                playlist.setNombre(rs.getString("nombre"));

                listaPlaylists.insertarAlFinal(playlist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listaPlaylists;
    }
}