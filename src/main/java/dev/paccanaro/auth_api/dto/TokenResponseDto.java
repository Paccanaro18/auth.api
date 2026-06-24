package dev.paccanaro.auth_api.dto;

public record TokenResponseDto(String token, long expires_in) {

}
