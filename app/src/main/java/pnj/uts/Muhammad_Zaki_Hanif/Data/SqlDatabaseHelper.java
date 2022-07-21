package pnj.uts.Muhammad_Zaki_Hanif.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "data-alumni.db";
    private static final int DATABASE_VERSION = 1;

    public SqlDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table alumni(" +
                "nim INTEGER PRIMARY KEY NOT NULL," +
                "nama_alumni TEXT NOT NULL," +
                "tempat_lahir TEXT NOT NULL," +
                "tanggal_lahir TEXT NOT NULL," +
                "alamat TEXT NOT NULL," +
                "agama TEXT NOT NULL," +
                "telp INTEGER NOT NULL," +
                "tahun_masuk INTEGER NOT NULL," +
                "tahun_lulus INTEGER NOT NULL," +
                "pekerjaan TEXT NOT NULL," +
                "jabatan TEXT NOT NULL);";
        sqLiteDatabase.execSQL(query);
    }

    public Cursor getAllAlumni() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from alumni", null);
    }

    public Boolean addAlumni(Alumni alumni) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nim", alumni.getNim().longValue());
        cv.put("nama_alumni", alumni.getNama_alumni());
        cv.put("tempat_lahir", alumni.getTempat_lahir());
        cv.put("tanggal_lahir", alumni.getTanggal_lahir());
        cv.put("alamat", alumni.getAlamat());
        cv.put("agama", alumni.getAgama());
        cv.put("telp", alumni.getTelp().longValue());
        cv.put("tahun_masuk", alumni.getTahun_masuk().longValue());
        cv.put("tahun_lulus", alumni.getTahun_lulus().longValue());
        cv.put("pekerjaan", alumni.getPekerjaan());
        cv.put("jabatan", alumni.getJabatan());


        long result = db.insert("alumni", null, cv);
        return result != -1;
    }

    public Cursor getAlumniByNim(long nim){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from alumni where nim = "+nim, null);
    }

    public Boolean deleteAlumni(long nim) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("alumni","nim = "+nim, null) > 0;
    }

    public boolean updateAlumni(Alumni alumni) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nim", alumni.getNim().longValue());
        cv.put("nama_alumni", alumni.getNama_alumni());
        cv.put("tempat_lahir", alumni.getTempat_lahir());
        cv.put("tanggal_lahir", alumni.getTanggal_lahir());
        cv.put("alamat", alumni.getAlamat());
        cv.put("agama", alumni.getAgama());
        cv.put("telp", alumni.getTelp().longValue());
        cv.put("tahun_masuk", alumni.getTahun_masuk().longValue());
        cv.put("tahun_lulus", alumni.getTahun_lulus().longValue());
        cv.put("pekerjaan", alumni.getPekerjaan());
        cv.put("jabatan", alumni.getJabatan());


        return db.update("alumni", cv,"nim = "+Long.valueOf(String.valueOf(alumni.getNim())),null)>0;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS alumni");
    }
}
