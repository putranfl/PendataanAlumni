package pnj.uts.Muhammad_Zaki_Hanif;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;

import java.math.BigInteger;
import java.util.ArrayList;

import pnj.uts.Muhammad_Zaki_Hanif.Adapter.ListAdapter;
import pnj.uts.Muhammad_Zaki_Hanif.Adapter.MyItemRecyclerViewAdapter;
import pnj.uts.Muhammad_Zaki_Hanif.Data.Alumni;
import pnj.uts.Muhammad_Zaki_Hanif.Data.SqlDatabaseHelper;
import pnj.uts.Muhammad_Zaki_Hanif.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {

    private ArrayList<Alumni> alumni = new ArrayList<>();
    private final SqlDatabaseHelper db = new SqlDatabaseHelper(ListActivity.this);
    private ActivityListBinding binding;
    private ListAdapter listAdapter;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        storeDataAlumniToModel(db.getAllAlumni());

        listAdapter = new ListAdapter(alumni);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new ListAdapter(this));
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);


//        binding.rvAlumni.setLayoutManager(layoutManager);
//        binding.rvAlumni.setAdapter(listAdapter);


    }

    private void storeDataAlumniToModel(Cursor cursor) {
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()){
                alumni.add(new Alumni(
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
                ));
            }
        }
    }
}