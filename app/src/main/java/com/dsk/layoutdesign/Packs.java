package com.dsk.layoutdesign;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Packs extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("Packs", "inside onCreate");
        View view = inflater.inflate(R.layout.fragment_packs, container, false);
        RecyclerView rv = view.findViewById(R.id.rv);

        List<PackDetails> data = new ArrayList<>();
        data.add(new PackDetails("LAST RECHARGE","₹299", "Price", "2 GB",
                "per day", "365 days", "validity", "Essential",
                "Remote door lock", "Remote immobilisation", "TPMS status"));
        data.add(new PackDetails("Only ~₹240/month","₹479", "Price", "1.5 GB",
                "per day", "365 days", "validity", "Standard",
                "Remote charging", "Thermal pre-conditioning", "LV Battery"));
        data.add(new PackDetails("Watch KBC with Big B","₹148", "Price", "15 GB",
                "data","365 days", "validity", "Premium",
                "Head lamp", "Remote immobilisation", "Remote charging"));

        rv.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false));
        PacksAdapter adapter = new PacksAdapter(this.getContext(), data);
        rv.setAdapter(adapter);

        return view;
    }

}
