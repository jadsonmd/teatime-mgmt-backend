package com.teatime.service;

import com.teatime.model.Usuario;
import com.teatime.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuario updateUsuario(String id, Usuario usuarioDetails) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setName(usuarioDetails.getName());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setIdParceiro(usuarioDetails.getIdParceiro());
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario not found with id: " + id);
        }
    }

    public void deleteUsuario(String id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()) {
            usuarioRepository.delete(optionalUsuario.get());
        } else {
            throw new RuntimeException("Usuario not found with id: " + id);
        }
    }
}