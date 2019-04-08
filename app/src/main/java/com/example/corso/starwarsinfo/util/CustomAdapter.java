package com.example.corso.starwarsinfo.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.corso.starwarsinfo.R;
import com.example.corso.starwarsinfo.data.Person;

import java.util.List;

public class CustomAdapter extends BaseAdapter{

    ItemSelectedCallback mCallback;
    private Context context = null;
    private List<Person> listaItem = null;

    public CustomAdapter(Context context, List<Person> listaItem, ItemSelectedCallback mCallback)
    {
        this.listaItem=listaItem;
        this.context=context;
        this.mCallback=mCallback;
    }


    @Override
    public int getCount() {
        return listaItem.size();
    }

    @Override
    public Person getItem(int position) {
        return listaItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if (view==null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.riga_item, null);
        }
        final Person person= (Person) getItem(position);
        TextView txt=(TextView) view.findViewById(R.id.text_riga_item);
        txt.setText(person.getName());
        LinearLayout rigaPeople = (LinearLayout) view.findViewById(R.id.riga_item);
        rigaPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onPersonClicked(position, getItem(position));
            }
        });


        return view;
    }

}
