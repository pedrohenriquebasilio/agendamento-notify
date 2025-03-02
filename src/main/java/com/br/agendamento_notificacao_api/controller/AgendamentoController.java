package com.br.agendamento_notificacao_api.controller;


import com.br.agendamento_notificacao_api.business.AgendamentoService;
import com.br.agendamento_notificacao_api.controller.dto.AgendamentoRequestDto;
import com.br.agendamento_notificacao_api.controller.dto.AgendamentoResponseOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponseOut> gravarAgendamentos(@RequestBody AgendamentoRequestDto agendamento){
        return ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseOut> buscarAgendamentoPorId(@PathVariable("id") long id){
        return  ResponseEntity.ok(agendamentoService.buscarAgendamentosPorId(id));
    }

    @GetMapping("/cancelamento")
    public ResponseEntity<AgendamentoResponseOut> cancelarAgendamento(@PathVariable("id") long id){
        agendamentoService.CancelarAgendamento(id);
        return ResponseEntity.accepted().build();
    }
}
