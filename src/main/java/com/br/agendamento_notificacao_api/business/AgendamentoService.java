package com.br.agendamento_notificacao_api.business;


import com.br.agendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.br.agendamento_notificacao_api.controller.dto.AgendamentoRequestDto;
import com.br.agendamento_notificacao_api.controller.dto.AgendamentoResponseOut;
import com.br.agendamento_notificacao_api.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

        private final AgendamentoRepository repository;
        private final IAgendamentoMapper agendamentoMapper;

        public AgendamentoResponseOut gravarAgendamento(AgendamentoRequestDto agendamento){
               return agendamentoMapper.forResponse(repository.save(agendamentoMapper.forEntity(agendamento)));

        }

}
