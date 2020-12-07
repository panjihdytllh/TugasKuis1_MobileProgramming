package com.example.tugassqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Laptop> ListLaptop = new ArrayList<Laptop>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListLaptop );
        mListView = (ListView) findViewById(R.id.list_laptop);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListLaptop.clear();
        List<Laptop> contacts = db.ReadLaptop();
        for (Laptop cn : contacts) {
            Laptop judulModel = new Laptop();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_harga(cn.get_harga());
            ListLaptop.add(judulModel);
            if ((ListLaptop.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Laptop obj_itemDetails = (Laptop) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Smerk = obj_itemDetails.get_merk();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Iharga",Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListLaptop.clear();
        mListView.setAdapter(adapter_off);
        List<Laptop> contacts = db.ReadLaptop();
        for (Laptop cn : contacts) {
            Laptop judulModel = new Laptop();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_harga(cn.get_harga());
            ListLaptop.add(judulModel);
            if ((ListLaptop.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

