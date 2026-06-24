package dev.paccanaro.auth_api.controller;

import dev.paccanaro.auth_api.dto.UpdateUsuarioRequestDto;
import dev.paccanaro.auth_api.dto.UsuarioResponseDto;
import dev.paccanaro.auth_api.entity.UsuarioEntity;
import dev.paccanaro.auth_api.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/me")
        public UsuarioResponseDto fichaUsuario(Authentication authentication) {
            return usuarioService.fichaUsuario(authentication);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/me")
    public UsuarioResponseDto atualizarUsuario(Authentication authentication,
                                 @RequestBody UpdateUsuarioRequestDto requestDto) {
        return usuarioService.atualizar(authentication, requestDto);

    }


}
