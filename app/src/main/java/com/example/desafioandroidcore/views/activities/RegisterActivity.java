package com.example.desafioandroidcore.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.desafioandroidcore.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputEmail;
    private TextInputLayout inputSenha;
    private TextInputLayout inputRepeatSenha;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(inputNome.getEditText() != null && inputEmail.getEditText().getText()!= null
                        && inputSenha.getEditText().getText() != null && inputRepeatSenha.getEditText().getText()!= null
                        && inputSenha.getEditText().getText().toString().equals(inputRepeatSenha.getEditText().getText().toString())) {
                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else if(!inputSenha.getEditText().getText().toString().equals(inputRepeatSenha.getEditText().getText().toString())){
                    inputSenha.setError("As senhas devem ser iguais");
                    inputRepeatSenha.setError("As senhas devem ser iguais");
                } else{
                    inputNome.setError("Campo obrigatório");
                    inputEmail.setError("Campo obrigatório");
                    inputSenha.setError("Campo obrigatório");
                    inputRepeatSenha.setError("Campo obrigatório");
                }
            }
        });
    }

    public void initViews(){
        inputNome = findViewById(R.id.inputNome);
        inputEmail = findViewById(R.id.inputEmail);
        inputSenha = findViewById(R.id.inputSenha);
        inputRepeatSenha = findViewById(R.id.inputRepeatPassword);
        btnRegister = findViewById(R.id.btnRegister);

    }
}
