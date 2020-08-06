package br.com.leangua.capital;

import br.com.leangua.empresa.models.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogProducer {

    @Autowired
    private KafkaTemplate<String, Empresa> producer;

    public void enviarAoKafka(Empresa empresa){
        producer.send("spec3-leandro-guarino-3", empresa);
    }

}
