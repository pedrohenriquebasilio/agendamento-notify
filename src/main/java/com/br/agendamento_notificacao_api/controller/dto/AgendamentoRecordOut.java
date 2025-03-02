package com.br.agendamento_notificacao_api.controller.dto;

import com.br.agendamento_notificacao_api.infrastructure.entities.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AgendamentoRecordOut(Long id, String emailDestinatario, String telefoneDestinatario, String mensagem,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                   LocalDateTime dataHoraEnvio, StatusNotificacaoEnum statusNotificacaoEnum) {
}
