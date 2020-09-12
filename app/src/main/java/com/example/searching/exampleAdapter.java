package com.example.searching;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class exampleAdapter extends FirebaseRecyclerAdapter<modelC,exampleAdapter.myviewholder>
{
    private OnNoteListener mOnNoteListener;
    public exampleAdapter(@NonNull FirebaseRecyclerOptions<modelC> options , OnNoteListener onNoteListener) {
        super(options);
        this.mOnNoteListener = onNoteListener;

    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull modelC model)
    {
        holder.name.setText(model.getName());
        holder.details.setText(model.getDetails());
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        return new myviewholder(view,mOnNoteListener);
    }

    class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        CircleImageView img;
        TextView name,details;
        OnNoteListener oniChan;

        public myviewholder(@NonNull View itemView , OnNoteListener oni)
        {
            super(itemView);
            img=(CircleImageView)itemView.findViewById(R.id.imageView);
            name=(TextView)itemView.findViewById(R.id.textView1);
            details=(TextView)itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
            this.oniChan = oni;

        }

        @Override
        public void onClick(View v) {
            oniChan.onNoteClick(getAdapterPosition());
        }
    }
    public interface  OnNoteListener{
        void onNoteClick(int position);
    }


}
