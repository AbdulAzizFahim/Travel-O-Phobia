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

public class ReviewAdapter extends FirebaseRecyclerAdapter<modelR,ReviewAdapter.myviewholder>
{

    public ReviewAdapter(@NonNull FirebaseRecyclerOptions<modelR> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull modelR model)
    {
        holder.name.setText(model.getName());
        holder.details.setText(model.getDetails());
        holder.place.setText(model.getPlace());
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView name,place,details;


        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView)itemView.findViewById(R.id.imageView);
            name=(TextView)itemView.findViewById(R.id.textView1);
            place=(TextView)itemView.findViewById(R.id.textView2);
            details=(TextView)itemView.findViewById(R.id.textView3);

        }
    }

}
