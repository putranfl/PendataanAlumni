package pnj.uts.Muhammad_Zaki_Hanif;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import pnj.uts.Muhammad_Zaki_Hanif.databinding.ActivityDetailBeritaBinding;

public class DetailBeritaActivity extends AppCompatActivity {

    private ActivityDetailBeritaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBeritaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        binding.tvTittle.setText(intent.getStringExtra("title"));
        binding.tvDeskripsi.setText(intent.getStringExtra("deskripsi"));
    }
}