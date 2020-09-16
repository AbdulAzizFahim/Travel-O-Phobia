package com.example.searching;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class Hotel_Booking_Adapter extends FirebaseRecyclerAdapter<Hotel_Item,Hotel_Booking_Adapter.myviewholder>
{
    private OnNoteListener mOnNoteListener;
    public Hotel_Booking_Adapter(@NonNull FirebaseRecyclerOptions<Hotel_Item> options , OnNoteListener onNoteListener) {
        super(options);
        this.mOnNoteListener = onNoteListener;

    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Hotel_Item hotel)
    {
        holder.hotelname.setText(hotel.getHotel_Name());
        holder.hoteldetails.setText(hotel.getHotel_Details());
        holder.hoteladdress.setText(hotel.getHotel_Address());
        Glide.with(holder.hotelimg.getContext()).load(hotel.getHotel_Img()).into(holder.hotelimg);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item,parent,false);
        return new myviewholder(view,mOnNoteListener);
    }

    class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        CircleImageView hotelimg;
        TextView hotelname,hoteldetails,hoteladdress;
        OnNoteListener hotelOnNote;

        public myviewholder(@NonNull View itemView , OnNoteListener hotelOnNote)
        {
            super(itemView);
            hotelimg=(CircleImageView)itemView.findViewById(R.id.hotelimageView);
            hotelname=(TextView)itemView.findViewById(R.id.hoteltextView1);
            hoteldetails=(TextView)itemView.findViewById(R.id.hoteltextView2);
            hoteladdress=(TextView)itemView.findViewById(R.id.hotel_address_text1);
            itemView.setOnClickListener(this);
            this.hotelOnNote = hotelOnNote;
        }

        @Override
        public void onClick(View v) {
            hotelOnNote.onNoteClick(getAdapterPosition());
        }
    }
    public interface  OnNoteListener{
        void onNoteClick(int position);
    }
}