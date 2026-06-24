package dev.paccanaro.auth_api.service;

import dev.paccanaro.auth_api.config.TokenProvider;
import dev.paccanaro.auth_api.dto.LoginRequestDto;
import dev.paccanaro.auth_api.dto.RegisterRequestDto;
import dev.paccanaro.auth_api.dto.TokenResponseDto;
import dev.paccanaro.auth_api.entity.RolesEntity;
import dev.paccanaro.auth_api.entity.UsuarioEntity;
import dev.paccanaro.auth_api.enums.RoleTypeEnum;
import dev.paccanaro.auth_api.repository.RolesRepository;
import dev.paccanaro.auth_api.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    @Value("${spring.jwt.expiration}")
    private long expiration;

    public void register(RegisterRequestDto registerRequestDto) throws BadRequestException {

        if(usuarioRepository.findByEmail(registerRequestDto.getEmail()).isPresent()){
            throw new BadRequestException("Email Já Cadastrado no banco de dados");
        }
        RolesEntity role = rolesRepository.findByNome(RoleTypeEnum.ROLE_USUARIO.name())
                .orElseGet(() -> rolesRepository.save(RolesEntity.builder()
                        .nome(RoleTypeEnum.ROLE_USUARIO.name())
                        .build()));

        usuarioRepository.save(UsuarioEntity.builder()
                        .nome(registerRequestDto.getNome())
                        .email(registerRequestDto.getEmail())
                        .roles(Set.of(role))
                        .senha(passwordEncoder.encode(registerRequestDto.getSenha()))
                        .build());

    }

    public TokenResponseDto login(LoginRequestDto loginRequestDto) throws BadRequestException {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getSenha()));
            String token = tokenProvider.gerarToken(authentication);
            return new TokenResponseDto(token, expiration);
        }catch (BadCredentialsException  badCredentialsException){
                throw new BadRequestException("Credenciais Invalidas");
        }catch (Exception e){
            throw new BadRequestException("Erro Inesperado");
        }
    }




}
