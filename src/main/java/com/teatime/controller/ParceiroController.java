package com.teatime.controller;

import com.teatime.model.Parceiro;
import com.teatime.model.Unidade;
import com.teatime.model.Usuario;
import com.teatime.service.ParceiroService;
import com.teatime.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parceiros")
public class ParceiroController {

    @Autowired
    private ParceiroService parceiroService;

    @GetMapping("/{id}")
    public ResponseEntity<Parceiro> getParceiroById(@PathVariable String id) {
        return ResponseEntity.ok(parceiroService.getUsuarioById(id));
    }

    @GetMapping("/unidades/{idParceiro}")
    public List<Unidade> getUnidades(@PathVariable String idParceiro) {
        return parceiroService.getUnidades(idParceiro);
    }
}
