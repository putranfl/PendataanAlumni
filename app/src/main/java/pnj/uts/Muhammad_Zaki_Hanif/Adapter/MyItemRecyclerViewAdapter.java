package pnj.uts.Muhammad_Zaki_Hanif.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pnj.uts.Muhammad_Zaki_Hanif.DetailBeritaActivity;
import pnj.uts.Muhammad_Zaki_Hanif.Fragment.placeholder.PlaceholderContent;
import pnj.uts.Muhammad_Zaki_Hanif.databinding.FragmentItemBinding;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderContent.PlaceholderItem> mValues;
    private Context context;
    public MyItemRecyclerViewAdapter(List<PlaceholderContent.PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mtvTittle.setText(mValues.get(position).content);
        holder.mtvDeskripsi.setText(mValues.get(position).details);
        holder.mCardContainer.setOnClickListener(v->{
            Intent intent = new Intent(context, DetailBeritaActivity.class);
            intent.putExtra("title", mValues.get(position).content);
            intent.putExtra("deskripsi", mValues.get(position).details);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mtvTittle;
        public final TextView mtvDeskripsi;
        public final ImageView mivBerita;
        public final LinearLayout mCardContainer;
        public PlaceholderContent.PlaceholderItem mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mivBerita = binding.ivBerita;
            mtvDeskripsi = binding.tvDeskripsi;
            mtvTittle = binding.tvTittle;
            mCardContainer = binding.cardContainer;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mtvTittle.getText() + "'";
        }
    }
}
