package com.example.penjualanbarang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editNamaBar,editJumlahBar, editHarga, editUangBay;
    private Button btnProses,btnHapus, btnExit;
    private TextView txtNamaBar, txtJumlahBar, txtHarga, txtUangBay,txtBonus, txtTotalBelanja,txtKembali, txtKeterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Aplikasi Penjualan Barang");
        editNamaBar = (EditText)findViewById(R.id.nama_barang);
        editJumlahBar = (EditText)findViewById(R.id.jml_barang);
        editHarga = (EditText)findViewById(R.id.harga_barang);
        editUangBay = (EditText)findViewById(R.id.jml_uang);

        btnProses = (Button)findViewById(R.id.proses);
        btnHapus = (Button)findViewById(R.id.reset);
        btnExit = (Button)findViewById(R.id.exit);

        txtNamaBar = (TextView)findViewById(R.id.nama_barang);
        txtJumlahBar = (TextView)findViewById(R.id.jml_barang);
        txtHarga = (TextView)findViewById(R.id.harga_barang);
        txtUangBay = (TextView)findViewById(R.id.jml_uang);
        txtTotalBelanja = (TextView)findViewById(R.id.total);
        txtKembali = (TextView)findViewById(R.id.kembalian);
        txtKeterangan = (TextView)findViewById(R.id.Keterangan);
        txtBonus = (TextView)findViewById(R.id.bonus);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaBarang = editNamaBar.getText().toString().trim();
                String jumlahBarang = editJumlahBar.getText().toString().trim();
                String hargaBarang = editHarga.getText().toString().trim();
                String uangBayar = editUangBay.getText().toString().trim();

                double jb = Double.parseDouble(jumlahBarang);
                double h = Double.parseDouble(hargaBarang);
                double ub = Double.parseDouble(uangBayar);
                double total = (jb*h);

                txtTotalBelanja.setText("Total Belanja : "+total);

                if (total >= 2000000)
                {
                    txtBonus.setText("Bonus : Harddisk");
                }
                else if (total >= 50000)
                {
                   txtBonus.setText("Bonus : Mouse");
                }
                else
                {
                    txtBonus.setText("Bonus : Tidak Ada Bonus");
                }

                double uangKembalian = (ub-total);
                if (ub<total)
                {
                    txtKeterangan.setText("Keterangan : uang bayar kurang Rp."+(-uangKembalian));
                    txtKembali.setText("Uang Kembalian : Rp. 0");
                }
                else
                {
                    txtKeterangan.setText("Keterangan : Tunggu Kembalian");
                    txtKembali.setText("Uang Kembalian :"+uangKembalian);
                }
            }
        });
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNamaBar.setText(" ");
                txtJumlahBar.setText(" ");
                txtHarga.setText(" ");
                txtUangBay.setText(" ");
                txtKembali.setText("Uang Kembali : Rp. 0");
                txtKeterangan.setText("-");
                txtBonus.setText("-");
                txtTotalBelanja.setText("Total Belanja : Rp 0");

                Toast.makeText(getApplicationContext(), "Data sudah dihapus", Toast.LENGTH_LONG).show();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
