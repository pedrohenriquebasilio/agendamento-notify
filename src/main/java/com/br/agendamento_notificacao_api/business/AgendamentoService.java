package com.br.agendamento_notificacao_api.business;


import com.br.agendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.br.agendamento_notificacao_api.controller.dto.AgendamentoRequestDto;
import com.br.agendamento_notificacao_api.controller.dto.AgendamentoResponseOut;
import com.br.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import com.br.agendamento_notificacao_api.infrastructure.exception.NotFoundException;
import com.br.agendamento_notificacao_api.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

        private final AgendamentoRepository repository;
        private final IAgendamentoMapper agendamentoMapper;

        public AgendamentoResponseOut gravarAgendamento(AgendamentoRequestDto agendamento){
               return agendamentoMapper.forResponse(repository.save(agendamentoMapper.forEntity(agendamento)));

        }

        public AgendamentoResponseOut buscarAgendamentosPorId(Long id){
                return agendamentoMapper.forResponse(repository.findById(id).orElseThrow(()-> new NotFoundException("ID NOT FOUND")));
        }

        public  void  CancelarAgendamento(Long id){
              Agendamento agendamento = repository.findById(id).orElseThrow(()-> new NotFoundException("Id não encontrado"));
              repository.save(
                      agendamentoMapper.forEntityCancelamento(agendamento)
              );
        }

}
