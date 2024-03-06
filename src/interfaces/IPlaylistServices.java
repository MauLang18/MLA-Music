/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import datos.Lista;
import model.PlaylistModel;

/**
 *
 * @author maula
 */
public interface IPlaylistServices {
    boolean agregarPlaylist(PlaylistModel request);
    boolean modificarPlaylist(PlaylistModel request);
    boolean eliminarPlaylist(PlaylistModel request);
    Lista<PlaylistModel> obtenerPlaylist();
    Lista<PlaylistModel> obtenerUltimaPlaylist();
}
