package br.com.alura.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviar(String nome, String emailConvidado) {
		
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setSSLOnConnect(true);
            email.setAuthenticator(new DefaultAuthenticator("cassiano.ricardo.da.silva@gmail.com", "******"));
           

            
            try {
				email.setFrom("cassiano.ricardo.da.silva@gmail.com");
			
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailConvidado);
            email.send();
            } catch (EmailException e) {
				
				e.printStackTrace();
			}

	}

}
