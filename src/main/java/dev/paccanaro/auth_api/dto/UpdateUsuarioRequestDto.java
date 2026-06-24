package dev.paccanaro.auth_api.dto;


public record UpdateUsuarioRequestDto(
        String nome,
        String email
) {}