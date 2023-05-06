package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Estudante;
import com.openlab.projetoseguranca.repository.EstudanteRepository;
import com.openlab.projetoseguranca.service.UsuarioService;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar")
    public Estudante salvar(@RequestBody Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    @GetMapping("/listar")
    public List<Estudante> listar() {
        return estudanteRepository.findAll();
    }
    
    @PostMapping("/buscar")
    public List<Estudante> buscarEstudante(@RequestBody Estudante estudante) {
        return usuarioService.listarEstudantesCoordencao(estudante);
    }

}
