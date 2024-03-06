/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import datos.Lista;
import interfaces.IMusicServices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import model.Conexion;
import model.MusicModel;
import model.PlaylistModel;

/**
 *
 * @author maula
 */
public class MusicServices extends Conexion implements IMusicServices {

    @Override
    public boolean agregarCancion(MusicModel request) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO TB_CANCION (NombreCancion,Artista,Album,Anio,Duracion,IdPlaylist,Ruta) VALUES (?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, request.getNombreCancion());
            ps.setString(2, request.getArtista());
            ps.setString(3, request.getAlbum());
            ps.setInt(4, request.getAnio());
            ps.setString(5, request.getDuracion());
            ps.setInt(6, request.getIdPlaylist());
            ps.setString(7, request.getRuta());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean modificarCancion(MusicModel request) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "CALL modificarOC (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, request.getId());
            ps.setString(2, request.getNombreCancion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean eliminarCancion(MusicModel request) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "CALL eliminarOC (?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, request.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public Lista<MusicModel> obtenerCancion() {
        Lista<MusicModel> listaCanciones = new Lista<>();

        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM TB_CANCION";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MusicModel cancion = new MusicModel();
                cancion.setId(rs.getInt("id"));
                cancion.setNombreCancion(rs.getString("nombreCancion"));
                cancion.setDuracion(rs.getString("duracion"));
                cancion.setRuta(rs.getString("ruta"));

                listaCanciones.insertarAlFinal(cancion);
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

        return listaCanciones;
    }

    @Override
    public Lista<MusicModel> obtenerUltimaCancion() {
        Lista<MusicModel> listaCanciones = new Lista<>();

        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM TB_CANCION ORDER BY Id DESC LIMIT 1";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MusicModel cancion = new MusicModel();
                cancion.setId(rs.getInt("id"));
                cancion.setNombreCancion(rs.getString("nombreCancion"));
                cancion.setRuta(rs.getString("ruta"));

                listaCanciones.insertarAlFinal(cancion);
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

        return listaCanciones;
    }

    @Override
    public boolean eliminarCancionGeneral() {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM TB_CANCION WHERE IdPlaylist = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
