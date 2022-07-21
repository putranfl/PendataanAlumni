package pnj.uts.Muhammad_Zaki_Hanif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import pnj.uts.Muhammad_Zaki_Hanif.databinding.ActivityLoginBinding;
import pnj.uts.Muhammad_Zaki_Hanif.sharedPreference.Preferences;

public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private final String email = "hanif@gmail.com";
    private final String nama = "Muhammad Zaki Hanif";
    private final String kelas = "Ti 6B";
    private final int nim = 1907411043;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (!Preferences.getEmailUser(this).equals("")) {
            toMainActivity();
        }


        binding.btnLogin.setOnClickListener(view -> {
            if (binding.edtEmail.getText().toString().equals(email) && binding.edtPassword.getText().toString().equals("hanif")) {
                Preferences.setDataUser(this, email, nama, kelas, nim);
                toMainActivity();
            } else {
                Toast.makeText(this, "data yang dimasukan salah", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void toMainActivity(){
        this.startActivity(new Intent(Login.this,MainActivity.class));
        finish();
    }
}