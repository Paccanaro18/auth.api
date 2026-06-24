package dev.paccanaro.auth_api.dto;

import dev.paccanaro.auth_api.entity.UsuarioEntity;

public record UsuarioResponseDto(String email, String nome, Integer id) {

}
