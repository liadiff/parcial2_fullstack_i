package com.parcial2.parcial2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.dto.PartidaDTO;
import com.parcial2.parcial2.model.Entidad;
import com.parcial2.parcial2.model.Partida;
import com.parcial2.parcial2.repository.PartidaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PartidaService {

    @Autowired
    PartidaRepository partidaRepository;

    public List<PartidaDTO> listarPartidas() {
        List<PartidaDTO> partidasDTOs = new ArrayList<>();

        for (Partida p : partidaRepository.findAll()) {
            partidasDTOs.add(convertirDTO(p));
        }

        return partidasDTOs;
    }

    public PartidaDTO buscarPorId(Integer id) {
        return convertirDTO(partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La partida " + id + " no esta en los registros")));
    }

    public PartidaDTO guardarPartida(Partida partida) {
        if (!partida.getJugador().getJugable()) {
            throw new RuntimeException("No se ha podido registrar la Partida: El jugador no es jugable");
        }

        if (partida.getEnemigo().getJugable()) {
            throw new RuntimeException("No se ha podido registrar la Partida: El enemigo es jugable");
        }
        return convertirDTO(partidaRepository.save(partida));
    }

    public String eliminarPartida(Integer id) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la partida: Partida " + id + " inexistente"));

        partidaRepository.delete(partida);
        return "Partida " + id + " eliminada exitosamente";
    }

    public PartidaDTO actualizarPartida(Integer id, Partida partida) {
        Partida partida_original = partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha podido actualizar la partida: Partida " + id + " actualizada"));

        if (partida.getJugador() != null) {
            partida_original.setJugador(partida.getJugador());
        }

        if (partida.getEnemigo() != null) {
            partida_original.setEnemigo(partida.getEnemigo());
        }

        if (partida.getBatalla() != null) {
            partida_original.setBatalla(partida.getBatalla());
        }

        return convertirDTO(partidaRepository.save(partida_original));
    }

    public Entidad obtenerJugador(Integer id) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha podido obtener el jugador de la partida: Partida " + id + " inexistente"));

        return partida.getJugador();
    }

    public Entidad obtenerEnemigo(Integer id) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha podido obtener el enemigo de la partida: Partida " + id + " inexistente"));

        return partida.getEnemigo();
    }

    private PartidaDTO convertirDTO(Partida partida) {
        PartidaDTO partidaDTO = new PartidaDTO();
        partidaDTO.setId(partida.getId());
        partidaDTO.setJugador(partida.getJugador());
        partidaDTO.setBatalla(partida.getBatalla());
        partidaDTO.setEnemigo(partida.getEnemigo());
        return partidaDTO;
    }
}
