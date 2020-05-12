package com.kelompok.sistempakar.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kelompok.sistempakar.R;
import com.kelompok.sistempakar.models.Kelas_Penyakit;

import java.util.List;

public class PenyakitItemAdapter extends BaseAdapter {
    private Context context;
    private List<Kelas_Penyakit> penyakitList;

    public PenyakitItemAdapter(Context context, List<Kelas_Penyakit> penyakitList) {
        this.context = context;
        this.penyakitList = penyakitList;
    }

    @Override
    public int getCount() {
        return penyakitList.size();
    }

    @Override
    public Object getItem(int position) {
        return penyakitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.nama_penyakit, parent, false);
        TextView txtNamaPenyakit = view.findViewById(R.id.txtNamaPenyakit);
        txtNamaPenyakit.setText(penyakitList.get(position).getNama());
        return view;
    }
}
