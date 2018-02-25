package com.example.android.tsarasyafiera_1202150275_modul3;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<String> arrayListJudul, arrayListDeskripsi;
    private ArrayList<Integer> arrayListGambar;

    RecyclerAdapter(ArrayList<String> arrayListJudul, ArrayList<String> arrayListDeskripsi, ArrayList<Integer> arrayListGambar) {
        this.arrayListJudul = arrayListJudul;
        this.arrayListDeskripsi = arrayListDeskripsi;
        this.arrayListGambar = arrayListGambar;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Judul, Deskripsi;
        private ImageView Gambar;
        private LinearLayout itemList;

        public ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            Judul = itemView.findViewById(R.id.judul);
            Deskripsi = itemView.findViewById(R.id.deskripsi);
            Gambar = itemView.findViewById(R.id.gambar);
            itemList = itemView.findViewById(R.id.list_waters);
        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_adapter, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, final int position) {
        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat pada Posisi Tertentu

        final String judul = arrayListJudul.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan sebelumnya

        final String desc = arrayListDeskripsi.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan sebelumnya

        final Integer gambar = arrayListGambar.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan sebelumnya

        holder.Judul.setText(judul);// Mengambil text sesuai posisi yang telah ditentukan sebelumnya

        holder.Deskripsi.setText(desc); // Mengambil text sesuai posisi yang telah ditentukan

        holder.Gambar.setImageResource(gambar); // Mengambil gambar sesuai posisi yang telah ditentukan

        //Membuat Action Saat List Ditekan
        holder.itemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                String descs1 = "ADES Air Mineral 600Ml merupakan air minum dalam kemasan yang terbuat dari mata air gunung pilihan yang terjaga unsur mineralnya hingga dapat dikonsumsi dengan baik dan aman setiap hari. Air minum dalam kemasan ini dapat memberikan kesegaran pada tubuh dan membantu mengurangi dehidrasi.";
                String descs2 = "AMIDIS adalah produk Air Minum Dalam Kemasan (AMDK) yang sudah diproduksi sejak tahun 1997 dan merupakan air minum distilasi pertama di Indonesia yang telah menjadi salah satu produk AMDK yang dipercaya karena kualitas mutu dan kemurniannya. AMIDIS sangat memperhatikan kualitas dari produk.";
                String descs3 = "AQUA berasal dari sumber mata air yang terpilih dengan segala kemurnian dan kandungan mineral alami yang terpelihara. AQUA dikemas dengan proses higienis dalam beberapa ukuran kemasan botol plastik; 330 ml, 600 ml, 750 ml dan 1500 ml serta kemasan gelas plastik ukuran 240 ml dan kemasan galon 19 l";
                String descs4 = "Air Murni Cleo diambil dari mata air pegunungan dan diproses melalui hyper membrane filter 0,0001 mikron sehingga tidak mengandung mikroorganisme dan mineral anorganik, misalnya chlorine dan natrium fluoride..";
                String descs5 = "Club adalah merek air minum dalam kemasan atau air mineral di Indonesia. Merek ini berasal dari Surabaya dan Pandaan, Pasuruan, Jawa Timur. Club diproduksi oleh PT Tirta Sukses Perkasa (dahulu PT Tirta Bahagia) sejak tahun 1986. Pada bulan November 2013, merek Club diakuisisi oleh PT Indofood CBP.";
                String descs6 = "Equil mungkin masih asing di telinga kebanyakan masyarakat Indonesia.  Namun merk air mineral murni ini sudah cukup dikenal kalangan menengah atas dan ekspatriat. Equil kerap hadir di meja restoran fine dining, hotel bintang lima, hingga meja Istana Negara saat rapat kabinet.";
                String descs7 = "Evian Setiap tetesnya melewati perjalanan dan proses alami selama 15 tahun sebelum muncul di mata air. Pembentukan mineral terjadi selama proses alami tersebut, melewati lapisan es dan bebatuan, dalam komposisi yang unik. Maka itulah Evian aman dan bisa dikonsumsi setiap hari. ";
                String descs8 = "LE MINERALE Air Mineral 600ml, merupakan air mineral yang diambil dari mata air dari Gunung Bromo. Air mineral yang berasal dari sumber air pegunungan yang kaya akan mineral alami yang diperlukan tubuh setiap hari. Air Mineral diproses secara higienis dengan teknologi modern.";
                String descs9 = "Kesegaran tak tergantikan dari Nestlé Pure Life Mineral Water yang berasal dari segala kemurnian mata air pilihan dan diproses secara higienis. Spesifikasi Produk. Jenis Produk: Air Mineral. Isi: 1500ml. Kemasan: Botol. Manfaat. Membantu mengurangi dehidrasi tubuh; Memberikan kesegaran pada tubuh.";
                String descs10 = "Sumber Mata Air Sumber mata air PRISTINE murni dan asli berasal dari Pegunungan Pangrango Gede,30 mil dari Jakarta Selatan ( 1.5 jam dari Jakarta Pusat),berlokasi disamping “ Taman Nasional Pangrango Gede”.";
                String descs11 = "VIT adalah sebuah merek air minum dalam kemasan (AMDK) yang diproduksi oleh PT Tirta Investama di Indonesia. Mulai diproduksi sejak tanggal 16 November 1982 dan awalnya dimiliki oleh PT Varia Industri Tirta.";

                switch (position) {
                    case 0:
                        intent.putExtra("judul", arrayListJudul.get(position));
                        intent.putExtra("deskripsi", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs1);
                        v.getContext().startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("judul", arrayListJudul.get(position));
                        intent.putExtra("deskripsi", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs2);
                        v.getContext().startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("judul", arrayListJudul.get(position));
                        intent.putExtra("deskripsi", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs3);
                        v.getContext().startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("judul", arrayListJudul.get(position));
                        intent.putExtra("deskripsi", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs4);
                        v.getContext().startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("judul", arrayListJudul.get(position));
                        intent.putExtra("deskripsi", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs5);
                        v.getContext().startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("judul", arrayListJudul.get(position));
                        intent.putExtra("deskripsi", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs6);
                        v.getContext().startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("judul", arrayListJudul.get(position));
                        intent.putExtra("deskripsi", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs7);
                        v.getContext().startActivity(intent);
                        break;
                    case 7:
                        intent.putExtra("judul", arrayListJudul.get(position));
                        intent.putExtra("deskripsi", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs8);
                        v.getContext().startActivity(intent);
                        break;
                    case 8:
                        intent.putExtra("judul", arrayListDeskripsi.get(position));
                        intent.putExtra("gambar", arrayListGambar.get(position));
                        intent.putExtra("descs", descs9);
                        v.getContext().startActivity(intent);
                        break;
                    case 9:
                        intent.putExtra("title", arrayListDeskripsi.get(position));
                        intent.putExtra("desc", arrayListGambar.get(position));
                        intent.putExtra("descs", descs10);
                        v.getContext().startActivity(intent);
                        break;
                    case 10:
                        intent.putExtra("title", arrayListDeskripsi.get(position));
                        intent.putExtra("desc", arrayListGambar.get(position));
                        intent.putExtra("descs", descs11);
                        v.getContext().startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListJudul.size();
    }
}
