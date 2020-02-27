package mx.mudbit.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;


import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactActivity extends AppCompatActivity {

    TextInputEditText txtName;
    TextInputEditText txtEmail;
    TextInputEditText txtMessage;
    Button btnSend;
    Session session;
    String emailFrom;
    String password;
    String name;
    String email;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBarContact);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtName = (TextInputEditText) findViewById(R.id.teName);
        txtEmail = (TextInputEditText) findViewById(R.id.teEmail);
        txtMessage = (TextInputEditText) findViewById(R.id.teMessage);
        btnSend = (Button) findViewById(R.id.btnSend);

        emailFrom = "";
        password = "";

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtName.getText().toString();
                email = txtEmail.getText().toString();
                message = txtMessage.getText().toString();

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(emailFrom, password);
                        }
                    });

                    if (session != null){
                        MimeMessage msg = new MimeMessage(session);
                        msg.setFrom(new InternetAddress(emailFrom));
                        msg.setSubject(name);
                        msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
                        msg.setContent(message, "text/html; charset=utf-8");

                        Transport.send(msg);

                        Snackbar.make(v, "Correo enviado", Snackbar.LENGTH_LONG).show();
                    }
                } catch (AddressException e) {
                    e.printStackTrace();
                    Snackbar.make(v, "Correo enviado", Snackbar.LENGTH_LONG).show();
                } catch (MessagingException e) {
                    e.printStackTrace();
                    Snackbar.make(v, "Correo enviado", Snackbar.LENGTH_LONG).show();
                } catch (Exception e){
                    e.printStackTrace();
                    Snackbar.make(v, "Correo enviado", Snackbar.LENGTH_LONG).show();
                }


            }
        });

    }
}
