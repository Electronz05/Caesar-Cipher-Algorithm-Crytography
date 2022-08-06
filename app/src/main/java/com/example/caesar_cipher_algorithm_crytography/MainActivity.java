package com.example.caesar_cipher_algorithm_crytography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button encrypt, decrypt;
    private EditText message,cipher,key;
    private TextView screen_output;
    private static  final String alphabetString="abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encrypt=findViewById(R.id.btnencrypt);
        decrypt=findViewById(R.id.btndecrypt);
        screen_output=findViewById(R.id.tV1);
        message=findViewById(R.id.inputMessage);
        cipher=findViewById(R.id.ciphEdt);
        key=findViewById(R.id.key_dt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encrypt12(message.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrypt12(cipher.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });
    }
    public void decrypt12(String message, int key)
    {
        StringBuilder sb = new StringBuilder();
        for (Character c: message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                int tempKey = key % 26;
                int padding = (c % 26) < key ? 26 : 0;
                sb.append((char)(((c - 65 - tempKey + padding) % 26) + 65));
            } else if (Character.isLowerCase(c)) {
                int tempKey = key % 26;
                int padding = (c % 26) < key ? 26 : 0;
                sb.append((char)(((c - 97 - tempKey + padding) % 26) + 97));
            } else if (Character.isDigit(c)) {
                int tempKey = key % 10;
                int padding = (c % 10) < key ? 10 : 0;
                sb.append((char)(((c - 48 - tempKey + padding) % 10) + 48));
            } else {
                sb.append(c);
            }
        }

        String encryptedText = sb.toString();
        screen_output.setText(encryptedText);
    }

    public String encrypt12(String message, int shiftKey)
    {
        StringBuilder sb = new StringBuilder();
        for (Character c: message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                int tempKey = shiftKey % 26;
                sb.append((char)(((c - 65 + tempKey) % 26) + 65));
            } else if (Character.isLowerCase(c)) {
                int tempKey = shiftKey % 26;
                sb.append((char)(((c - 97 + tempKey) % 26) + 97));
            } else if (Character.isDigit(c)) {
                int tempKey = shiftKey % 10;
                sb.append((char)(((c - 48 + tempKey) % 10) + 48));
            } else {
                sb.append(c);
            }
        }

        String cipherText = sb.toString();
        screen_output.setText(cipherText);
        return cipherText;
    }
}