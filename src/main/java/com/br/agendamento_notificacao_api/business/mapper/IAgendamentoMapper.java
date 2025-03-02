package com.br.agendamento_notificacao_api.business.mapper;

import com.br.agendamento_notificacao_api.controller.dto.AgendamentoRequestDto;
import com.br.agendamento_notificacao_api.controller.dto.AgendamentoResponseOut;
import com.br.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import com.br.agendamento_notificacao_api.infrastructure.entities.StatusNotificacaoEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.time.LocalDateTime;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {


    Agendamento forEntity(AgendamentoRequestDto agendamentoRequestDto);


    AgendamentoResponseOut forResponse(Agendamento agendamento);


    @Mapping(target = "dataHoraModificacao", expression = "java(LocalDateTime.now())")
    @Mapping(target = "statusNotificacao", constant = "CANCELADO")
    Agendamento forEntityCancelamento(Agendamento agendamento);
}
