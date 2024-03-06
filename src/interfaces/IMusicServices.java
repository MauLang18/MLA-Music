/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import datos.Lista;
import model.MusicModel;

/**
 *
 * @author maula
 */
public interface IMusicServices {
    boolean agregarCancion(MusicModel request);
    boolean modificarCancion(MusicModel request);
    boolean eliminarCancion(MusicModel request);
    Lista<MusicModel> obtenerCancion();
    Lista<MusicModel> obtenerUltimaCancion();
    boolean eliminarCancionGeneral();
}
