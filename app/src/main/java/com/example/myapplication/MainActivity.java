package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLimpar.setOnClickListener(this);
        binding.btnExibir.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnLimpar) {
            binding.edtNome.setText("");
            binding.rdgSexo.clearCheck();
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");
            binding.chkMusica.setChecked(false);
            binding.chkCinema.setChecked(false);
            binding.chkEsporte.setChecked(false);
            binding.chkGastronomia.setChecked(false);
            binding.swtNotificacoes.setChecked(false);
        } else if (v.getId() == R.id.btnExibir) {
            if (binding.lblDados.getVisibility() == View.VISIBLE) {
                binding.lblDados.setVisibility(View.INVISIBLE);
            } else {
                binding.lblDados.setVisibility(View.VISIBLE);
                binding.txtNome.setText("Nome: " + binding.edtNome.getText().toString());
                binding.txtSexo.setText("Sexo: " + (binding.rdbMasculino.isChecked() ? "Masculino" : "Feminino"));
                binding.txtEmail.setText("E-mail: " + binding.edtEmail.getText().toString());
                binding.txtTelefone.setText("Telefone: " + binding.edtTelefone.getText().toString());
                binding.txtPreferencias.setText("Interesses: " +
                        (binding.chkMusica.isChecked() ? "Música " : "") +
                        (binding.chkCinema.isChecked() ? "Cinema " : "") +
                        (binding.chkEsporte.isChecked() ? "Esporte " : "") +
                        (binding.chkGastronomia.isChecked() ? "Gastronomia " : ""));
                binding.txtNotificacoes.setText("Notificações: " + (binding.swtNotificacoes.isChecked() ? "Ativadas" : "Desativadas"));
            }

        }

    }
}