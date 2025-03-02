package com.br.agendamento_notificacao_api.business;


import com.br.agendamento_notificacao_api.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

        private final AgendamentoRepository repository;

}
