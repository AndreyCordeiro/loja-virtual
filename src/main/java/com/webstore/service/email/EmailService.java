package com.webstore.service.email;

public interface EmailService {
    String enviarEmailTexto(String destinatario, String titulo, String mensagem);
}
