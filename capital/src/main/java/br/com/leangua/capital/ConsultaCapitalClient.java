package br.com.leangua.capital;

import br.com.leangua.empresa.models.EmpresaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cnpj", url="https://www.receitaws.com.br/")
public interface ConsultaCapitalClient {

    @GetMapping("v1/cnpj/{cnpj}")
    EmpresaDto getByCnpj(@PathVariable String cnpj);
}
