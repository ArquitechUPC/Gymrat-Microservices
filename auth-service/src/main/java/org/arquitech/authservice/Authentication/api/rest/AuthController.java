package org.arquitech.authservice.Authentication.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.arquitech.authservice.Authentication.domain.model.entity.Role;
import org.arquitech.authservice.Authentication.domain.model.entity.User;
import org.arquitech.authservice.Authentication.resource.*;
import org.arquitech.authservice.Authentication.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "auth", description = "the auth API")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Login", description = "Login to the application")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @Operation(summary = "Change password", description = "Change password")
    @PostMapping("/change-password")
    public ResponseEntity<AuthResponse> login(@RequestBody ChangePasswordRequest request) {
        return ResponseEntity.ok(authService.changePassword(request));
    }

    @Operation(summary = "Get user", description = "Get users info")
    @GetMapping("/get-clients-info")
    public ResponseEntity<List<UsersInfoResponse>> get(@RequestParam Integer companyId) {
        return ResponseEntity.ok(authService.getUsersByCompanyIdAndRole(companyId, Role.USER));
    }

    @Operation(summary = "Register", description = "Register to the application")
    @PostMapping("/register-admin")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/register-client")
    public ResponseEntity<?> registerClient(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerClient(request));
    }

    @PostMapping("/register-trainer")
    public ResponseEntity<?> registerTrainer(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerTrainer(request));
    }

    @GetMapping("/exist-user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(authService.findUserById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsersInfoResponse>> getById(@PathVariable Integer id){
        return ResponseEntity.ok(authService.findByUserId(id));
    }

}
