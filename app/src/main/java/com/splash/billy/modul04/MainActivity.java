package com.splash.billy.modul04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNomorAnggota, tvNamaAnggota, tvEmail, tvTelepon;
    TextView tvJudul, tvAuthor, tvTahun, tvPublisher, tvTgPinjam, tvTgKembali,tv_tglkembali,tv_tglpinjam;
    LinearLayout vgDataPinjam;
    Members members;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();

        members = getIntent().getParcelableExtra("members");
        if( members == null ){
            Intent intent = new Intent(MainActivity.this, infoActivity.class);
            startActivity(intent);
        } else {
            Log.d(">>>>>> CHECK 3 >>>>>>", members.getEmail());
            tvNomorAnggota.setText( members.getIdmember() );
            tvNamaAnggota.setText( members.getNamalengkap() );
            tvEmail.setText( members.getEmail() );
            tvTelepon.setText( members.getTelepon() );
            if( members.getPinjaman().getStatus() != 0 ){
                Buku buku = members.getPinjaman().getBuku();
                tvJudul.setText(buku.getJudul());
                tvAuthor.setText(buku.getAuthor());
                tvTahun.setText(buku.getTahun());
                tvPublisher.setText(buku.getPublisher());
                tvTgPinjam.setText(members.getPinjaman().getTanggalPinjam());
                tvTgKembali.setText(members.getPinjaman().getTanggalkembali());
                vgDataPinjam.setVisibility(View.VISIBLE);
            } else {
                tvJudul.setText("Tidak ada Pinjaman");
                vgDataPinjam.setVisibility(View.VISIBLE);
                tvTgPinjam.setText(" ");
                tvTgKembali.setText(" ");
                tvAuthor.setText(" ");
                tvPublisher.setText(" ");
                tv_tglkembali.setText(" ");
                tv_tglpinjam.setText(" ");
                tvTahun.setText(" ");
            }
        }
    }
    private void initLayout() {
        tvNomorAnggota = (TextView) findViewById(R.id.tvNoAnggota);
        tvNamaAnggota = (TextView) findViewById(R.id.tvNamaAnggota);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvTelepon = (TextView) findViewById(R.id.tvTelepon);
        vgDataPinjam = (LinearLayout)findViewById(R.id.vgDataPinjam);
        tvJudul = (TextView)findViewById(R.id.tvJudulBuku);
        tvAuthor = (TextView)findViewById(R.id.tvAuthor);
        tvTahun = (TextView)findViewById(R.id.tvTahun);
        tvPublisher = (TextView)findViewById(R.id.tvPublisher);
        tvTgPinjam = (TextView)findViewById(R.id.tvTgPinjam);
        tvTgKembali = (TextView)findViewById(R.id.tvTgKembali);
        tvNomorAnggota.setText("");
        tvNamaAnggota.setText("");
        tvEmail.setText("");
        tvTelepon.setText("");
        tv_tglkembali=(TextView)findViewById(R.id.tv_tglkembali);
        tv_tglpinjam=(TextView)findViewById(R.id.tv_tglpinjam);
        vgDataPinjam.setVisibility(View.INVISIBLE);
    }
}
