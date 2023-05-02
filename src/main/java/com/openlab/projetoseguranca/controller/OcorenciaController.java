package com.openlab.projetoseguranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlab.projetoseguranca.model.Ocorrencia;
import com.openlab.projetoseguranca.repository.OcorrenciaRepository;

@RequestMapping("/ocorrencia")
@RestController
public class OcorenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @PostMapping("/salvar")
    public Ocorrencia salvar(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    @GetMapping("/listar")
    public List<Ocorrencia> listar() {
        return ocorrenciaRepository.findAll();
    }

}
