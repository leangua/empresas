package br.com.leangua.empresa.controllers;

import br.com.leangua.empresa.models.Empresa;
import br.com.leangua.empresa.services.EmpresaService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping("/empresa")
    public void cadastraEmpresa(@RequestBody Empresa empresa){
        empresaService.enviarAoKafka(empresa);
    }
}
