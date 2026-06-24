package dev.paccanaro.auth_api.controller;

import dev.paccanaro.auth_api.dto.LoginRequestDto;
import dev.paccanaro.auth_api.dto.RegisterRequestDto;
import dev.paccanaro.auth_api.dto.TokenResponseDto;
import dev.paccanaro.auth_api.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {


   private final  AuthService authService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequestDto registerRequestDto) throws Exception {
        authService.register(registerRequestDto);
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody @Valid LoginRequestDto loginRequestDto) throws Exception {
       return authService.login(loginRequestDto);
    }

}
