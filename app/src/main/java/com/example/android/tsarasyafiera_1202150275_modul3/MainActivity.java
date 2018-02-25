package com.example.android.tsarasyafiera_1202150275_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<String> Judul;
    private ArrayList<String> Deskripsi;
    private ArrayList<Integer> Gambar;

    //susunan array yang terdiri dari sekumpulan data
    private String[] judul = {"Ades",
            "Amidis",
            "Aqua",
            "Cleo",
            "Club",
            "Equil",
            "Evian",
            "Leminerale",
            "Nestle",
            "Pristine",
            "Vit"};

    //daftar minuman
    private String[] deskripsi = {"Ini adalah minuman merk Ades",
            "Ini adalah minuman merk Amidis",
            "Ini adalah minuman merk Aqua",
            "Ini adalah minuman merk Cleo",
            "Ini adalah minuman merk Club",
            "Ini adalah minuman merk Equil",
            "Ini adalah minuman merk Evian",
            "Ini adalah minuman merk Leminerale",
            "Ini adalah minuman merk Nestle",
            "Ini adalah minuman merk Pristine",
            "Ini adalah minuman merk Vit"};

    //daftar gambar
    private int[] gambar = {R.drawable.ades,R.drawable.amidis,R.drawable.aqua,R.drawable.cleo,R.drawable.club,R.drawable.equil,R.drawable.evian,
            R.drawable.leminerale,R.drawable.nestle,R.drawable.pristine,R.drawable.vit};

    //menghubungan dengan layout dan setting layout Manager
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.rv1);


        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);


        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        Judul = new ArrayList<>();
        Deskripsi = new ArrayList<>();
        Gambar = new ArrayList<>();


        adapter = new RecyclerAdapter(Judul, Deskripsi, Gambar);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
        DaftarItem();

        // If there is more than one column, disable swipe to dismiss
        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, swipeDirs) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap the items and notify the adapter
                Collections.swap(Deskripsi, from,to);
                Collections.swap(Judul,from,to);
                Collections.swap(Gambar,from,to);
                adapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Judul.remove(viewHolder.getAdapterPosition());
                Deskripsi.remove(viewHolder.getAdapterPosition());
                Gambar.remove(viewHolder.getAdapterPosition());
                //Notify the adapter
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(recyclerView);



    }

    //perulangan array
    private void DaftarItem() {
        for (int w=0; w<judul.length; w++) {
            Gambar.add(gambar[w]);
            Judul.add(judul[w]);
            Deskripsi.add(deskripsi[w]);
        }
    }

}