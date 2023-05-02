package com.openlab.projetoseguranca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.openlab.projetoseguranca.model.Estudante;
import com.openlab.projetoseguranca.repository.EstudanteRepository;
import com.openlab.projetoseguranca.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> listarEstudantesCoordencao(Estudante estudante) {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        estudantes.add(estudanteRepository.findById(estudante.getId()).get());
        estudantes.add(estudanteRepository.findByRa(estudante.getRa()).get());
        estudantes.add(estudanteRepository.findByCpf(estudante.getCpf()).get());
        estudantes.add(estudanteRepository.findByNome(estudante.getNome()).get());
        return estudantes;
    }
}
