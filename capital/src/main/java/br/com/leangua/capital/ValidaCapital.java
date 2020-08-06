package br.com.leangua.capital;



import br.com.leangua.empresa.models.Empresa;
import br.com.leangua.empresa.models.EmpresaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ValidaCapital {

    @Autowired
    ConsultaCapitalClient consultaCapitalClient;

    @Autowired
    LogProducer logProducer;

    @KafkaListener(topics = "spec3-leandro-guarino-2", groupId = "leandro-guarino")
    public void receber(@Payload Empresa empresa) {
        System.out.println("CNPJ1: " + empresa.getCnpj());
        EmpresaDto empresaDto = consultaCapitalClient.getByCnpj(empresa.getCnpj());
        System.out.println("Empresa: " + empresaDto.getCnpj() + " capital: " + empresaDto.getCapital_social());
        if (empresaDto.getCapital_social() > 1000000.00){
            System.out.println("Empresa " + empresa.getCnpj() + " cadastrada, enviando para o log...");
            logProducer.enviarAoKafka(empresa);
        }
    }

}
