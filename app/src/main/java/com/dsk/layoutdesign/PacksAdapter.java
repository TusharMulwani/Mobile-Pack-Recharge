package com.dsk.layoutdesign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PacksAdapter extends RecyclerView.Adapter<PacksAdapter.viewHolder> {

    private Context c;
    private final List<PackDetails> data;

    public PacksAdapter(Context context, List<PackDetails> data) {
        this.c = context;
        this.data = data;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.packs_view_model, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        PackDetails details = data.get(position);

        LinearLayout packContainer = holder.packContainer;
        LinearLayout viewDetails = holder.viewDetails;
        LinearLayout buyPack = holder.buyPack;
        TextView heading = holder.heading;
        TextView price = holder.price;
        TextView priceSubtitle = holder.priceSubtitle;
        //TextView data = holder.data;
        //TextView dataSubtitle = holder.dataSubtitle;
        TextView validity = holder.validity;
        TextView validitySubtitle = holder.validitySubtitle;
        TextView dataType = holder.dataType;

        heading.setText(details.getHeading());
        price.setText(details.getPrice());
        priceSubtitle.setText(details.getPriceSubtitle());
        //data.setText(details.getData());
        //dataSubtitle.setText(details.getDataSubtitle());
        validity.setText(details.getValidity());
        validitySubtitle.setText(details.getValiditySubtitle());
        dataType.setText(details.getDataType());

        packContainer.setOnClickListener(view -> {
            /*Intent intent = new Intent(c, PackDetailsActivity.class);
            intent.putExtra("packDetails", details);
            c.startActivity(intent);*/
        });

        buyPack.setOnClickListener(view -> {
            Intent intent = new Intent(c, PaymentActivity.class);
            intent.putExtra("packDetails", details);
            c.startActivity(intent);
        });

        viewDetails.setOnClickListener(view -> {
            Intent intent = new Intent(c, PackDetailsActivity.class);
            intent.putExtra("packDetails", details);
            c.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder {

        public LinearLayout buyPack;
        public LinearLayout viewDetails;
        public LinearLayout packContainer;
        public TextView heading;
        public TextView price;
        public TextView priceSubtitle;
        //public TextView data;
        //public TextView dataSubtitle;
        public TextView validity;
        public TextView validitySubtitle;
        public TextView dataType;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            buyPack = itemView.findViewById(R.id.buyPack);
            viewDetails = itemView.findViewById(R.id.viewDetails);
            packContainer = itemView.findViewById(R.id.packContainer);
            heading = itemView.findViewById(R.id.heading);
            price = itemView.findViewById(R.id.price);
            priceSubtitle = itemView.findViewById(R.id.priceSubtitle);
            //data = itemView.findViewById(R.id.data);
            //dataSubtitle = itemView.findViewById(R.id.dataSubtitle);
            validity = itemView.findViewById(R.id.validity);
            validitySubtitle = itemView.findViewById(R.id.validitySubtitle);
            dataType = itemView.findViewById(R.id.dataType);

        }
    }
}
