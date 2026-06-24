package dev.paccanaro.auth_api.controller;

import dev.paccanaro.auth_api.dto.UsuarioResponseDto;
import dev.paccanaro.auth_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios")
    public List<UsuarioResponseDto> usuarios(){
        return usuarioService.listaUsuarios();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/usuarios/{id}")
    public void deletarUsuario(@PathVariable Integer id) {
        usuarioService.deletarUsuario(id);
        ResponseEntity.noContent().build();
    }

}
