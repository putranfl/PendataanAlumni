package pnj.uts.Muhammad_Zaki_Hanif;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pnj.uts.Muhammad_Zaki_Hanif.Data.Alumni;
import pnj.uts.Muhammad_Zaki_Hanif.Data.SqlDatabaseHelper;
import pnj.uts.Muhammad_Zaki_Hanif.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    private ActivityAddBinding binding;
    private final SqlDatabaseHelper db = new SqlDatabaseHelper(AddActivity.this);
    final Calendar myCalendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();

            }
        };
        binding.etTanggalLahir.setOnClickListener(view -> {
            new DatePickerDialog(AddActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });
        binding.btnSimpan.setOnClickListener(view -> {
            if(isValidate()){
                Boolean addAlumni = db.addAlumni(new Alumni(
                        binding.etNamaAlumni.getText().toString().trim(),
                        binding.etTempatLahir.getText().toString().trim(),
                        binding.etTanggalLahir.getText().toString().trim(),
                        binding.etAlamat.getText().toString().trim(),
                        binding.etAgama.getText().toString().trim(),
                        binding.etPekerjaan.getText().toString().trim(),
                        binding.etJabatan.getText().toString().trim(),
                        BigInteger.valueOf(Long.parseLong(binding.etNim.getText().toString())),
                        BigInteger.valueOf(Long.parseLong(binding.etTelp.getText().toString())),
                        BigInteger.valueOf(Long.parseLong(binding.etTahunMasuk.getText().toString())),
                        BigInteger.valueOf(Long.parseLong(binding.etTahunLulus.getText().toString()))
                ));
                if(addAlumni){
                    Toast.makeText(this,"berhasil menambah data",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(this,"gagal menaambah data",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this,"semua field harus diisi",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLabel(){
        String myFormat="E, dd MMMM yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        binding.etTanggalLahir.setText(dateFormat.format(myCalendar.getTime()));
    }

    private boolean isValidate(){
        if (binding.etNamaAlumni.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etNim.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etAgama.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etAlamat.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etTempatLahir.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etTanggalLahir.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etTelp.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etTahunMasuk.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etTahunLulus.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etPekerjaan.getText().toString().trim().isEmpty()){
            return false;
        }else if (binding.etJabatan.getText().toString().trim().isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}