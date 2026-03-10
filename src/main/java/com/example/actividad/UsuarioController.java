package com.example.actividad;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
    @PostMapping
    public String crearUsuario(@RequestBody Usuario nuevoUsuario) {
        usuarios.add(nuevoUsuario);
        return "Usuario " + nuevoUsuario.getNombre() + " " + nuevoUsuario.getApellido() + " agregado con éxito.";
    }
}