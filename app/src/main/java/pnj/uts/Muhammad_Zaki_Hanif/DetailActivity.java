package pnj.uts.Muhammad_Zaki_Hanif;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pnj.uts.Muhammad_Zaki_Hanif.Data.Alumni;
import pnj.uts.Muhammad_Zaki_Hanif.Data.SqlDatabaseHelper;
import pnj.uts.Muhammad_Zaki_Hanif.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private Alumni alumni;
    private final SqlDatabaseHelper db = new SqlDatabaseHelper(DetailActivity.this);
    private ActivityDetailBinding binding;
    final Calendar myCalendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        storeDataAlumniToModel(db.getAlumniByNim(intent.getLongExtra("nim",0)));

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
            new DatePickerDialog(DetailActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        binding.etNim.setText(String.valueOf(alumni.getNim()));
        binding.etNamaAlumni.setText(alumni.getNama_alumni());
        binding.etAlamat.setText(alumni.getAlamat());
        binding.etTanggalLahir.setText(alumni.getTanggal_lahir());
        binding.etTempatLahir.setText(alumni.getTempat_lahir());
        binding.etAgama.setText(alumni.getAgama());
        binding.etPekerjaan.setText(alumni.getPekerjaan());
        binding.etJabatan.setText(alumni.getJabatan());
        binding.etTelp.setText(String.valueOf(alumni.getTelp()));
        binding.etTahunMasuk.setText(String.valueOf(alumni.getTahun_masuk()));
        binding.etTahunLulus.setText(String.valueOf(alumni.getTahun_lulus()));

        binding.btnHapus.setOnClickListener(view -> {
            if (db.deleteAlumni(Long.parseLong(String.valueOf(alumni.getNim())))){
                Toast.makeText(this,"berhasil menghapus data",Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this,"gagal menghapus data",Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnUbah.setOnClickListener(view -> {
            if(isValidate()){
                Boolean addAlumni = db.updateAlumni(new Alumni(
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
                    Toast.makeText(this,"berhasil mengubah data",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(this,"gagal mengubah data",Toast.LENGTH_SHORT).show();
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

    private void storeDataAlumniToModel(Cursor cursor) {
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            alumni = new Alumni(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(9),
                    cursor.getString(10),
                    BigInteger.valueOf(cursor.getLong(0)),
                    BigInteger.valueOf(Long.parseLong(cursor.getString(6))),
                    BigInteger.valueOf(Long.parseLong(cursor.getString(7))),
                    BigInteger.valueOf(Long.parseLong(cursor.getString(8)))
            );
        }
    }
}