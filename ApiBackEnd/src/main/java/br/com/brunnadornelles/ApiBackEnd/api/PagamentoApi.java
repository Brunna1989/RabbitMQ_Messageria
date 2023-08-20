package br.com.brunnadornelles.ApiBackEnd.api;

import br.com.brunnadornelles.ApiBackEnd.dto.PagamentoDTO;
import br.com.brunnadornelles.ApiBackEnd.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoApi {
    @Autowired
    private PagamentoFacade pagamentoFacade;

    @PostMapping
    public String processar (@RequestBody PagamentoDTO request) {
        return pagamentoFacade.solicitarPagamento(request);
    }
}