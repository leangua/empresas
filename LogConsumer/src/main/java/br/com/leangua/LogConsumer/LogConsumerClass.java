package br.com.leangua.LogConsumer;

import br.com.leangua.empresa.models.Empresa;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogConsumerClass {

    @Autowired
    GravarArquivoLog gravarArquivoLog;

    @KafkaListener(topics = "spec3-leandro-guarino-3", groupId = "leandro-guarino")
    public void receber(@Payload Empresa empresa) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        gravarArquivoLog.persistirLog(empresa);
        System.out.println("Log de acesso: " + empresa.getCnpj());
    }
}
