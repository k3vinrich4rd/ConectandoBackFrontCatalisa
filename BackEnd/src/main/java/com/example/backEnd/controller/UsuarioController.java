package com.example.backEnd.controller;

import com.example.backEnd.model.UsuarioModel;
import com.example.backEnd.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> buscarTudo() {
        return ResponseEntity.ok(usuarioService.buscarNomes());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "pesquisaid/{id}")
    public ResponseEntity<Optional<UsuarioModel>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/pesquisa/{nomeUsuario}")
    public Optional<List<UsuarioModel>> tipoDeConta(String nomeUsuario) {
        return Optional.ofNullable(usuarioService.findByNomeUsuario(nomeUsuario));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioModel));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PatchMapping(path = "/put/{id}")
    public ResponseEntity<UsuarioModel> alterarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return ResponseEntity.ok(usuarioService.alterarCadUsuario(usuarioModel));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/delete/{id}")
    public void deletarConta(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }

}
