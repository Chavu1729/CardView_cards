package com.example.cardview_cards;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private List<Cards> cartas;
    private int layout;
    private Activity activity;

    public CardAdapter(List<Cards> cartas, int layout, Activity activity) {
        this.cartas = cartas;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        private TextView tvNombre;
        private TextView tvDanio;
        private ImageView ivBackground;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDanio = itemView.findViewById(R.id.tvDanio);
            ivBackground = itemView.findViewById(R.id.ivBackground);
            itemView.setOnCreateContextMenuListener(this);
        }

        public void bind(final Cards carta, final OnItemClickListener listener){
            this.tvNombre.setText((carta.getNombre()));
            this.tvDanio.setText(carta.getDanio());

            Picasso.get().load(carta.getImgBackground()).fit().into(this.ivBackground);
            this.ivBackground.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    listener.onItemClick(carta, getAdapterPosition());
                }
            });
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.usar_carta:
                    cartas.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Cards cartaSeleccionada = cartas.get(this.getAdapterPosition());
            contextMenu.setHeaderTitle(cartaSeleccionada.getNombre());
            MenuInflater inflater = activity.getMenuInflater();
            inflater.inflate(R.menu.context_menu_cartas, contextMenu);
            for (int i = 0; i < contextMenu.size(); i++){
                contextMenu.getItem(i).setOnMenuItemClickListener(this);
            }
        }
    }

    public interface OnItemClickListener  {
        void onItemClick(Cards cartas, int position);

    }
}
