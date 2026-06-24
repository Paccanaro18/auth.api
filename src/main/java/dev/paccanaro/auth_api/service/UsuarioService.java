package dev.paccanaro.auth_api.service;

import dev.paccanaro.auth_api.dto.UpdateUsuarioRequestDto;
import dev.paccanaro.auth_api.dto.UsuarioResponseDto;
import dev.paccanaro.auth_api.entity.UsuarioEntity;
import dev.paccanaro.auth_api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDto fichaUsuario(Authentication authentication) {
        UsuarioEntity usuario = (UsuarioEntity) authentication.getPrincipal();
        return responseDto(usuario);
    }
    private UsuarioResponseDto responseDto(UsuarioEntity usuario) {
        return new UsuarioResponseDto(
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getId()
        );
    }

    public UsuarioResponseDto atualizar(Authentication authentication, UpdateUsuarioRequestDto updateUsuarioRequestDto) {
        UsuarioEntity usuario = (UsuarioEntity) authentication.getPrincipal();

        if (updateUsuarioRequestDto.nome() != null) usuario.setNome(updateUsuarioRequestDto.nome());
        if (updateUsuarioRequestDto.email() != null) usuario.setEmail(updateUsuarioRequestDto.email());
        usuarioRepository.save(usuario);
        return responseDto(usuario);
    }


    public List<UsuarioResponseDto> listaUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::responseDto)
                .toList();
    }

    public void deletarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
