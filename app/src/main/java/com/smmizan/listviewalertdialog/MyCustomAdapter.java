package com.smmizan.listviewalertdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mizan on 24/02/2019.
 */

public class MyCustomAdapter extends ArrayAdapter<String> {

    LayoutInflater inflater;

    Context myContext;

    List<String> newList;

    public MyCustomAdapter(Context context, int resource, List<String> list) {

        super(context, resource, list);

        // TODO Auto-generated constructor stub

        myContext = context;

        newList = list;

        inflater = LayoutInflater.from(context);

    }

    @Override

    public View getView(final int position, View view, ViewGroup parent) {

        final MyCustomAdapter.ViewHolder holder;

        if (view == null) {

            holder = new MyCustomAdapter.ViewHolder();

            view = inflater.inflate(R.layout.list_item, null);

            holder.tvSname = (TextView) view.findViewById(R.id.tvtext_item);

            view.setTag(holder);

        } else {

            holder = (MyCustomAdapter.ViewHolder) view.getTag();

        }

        holder.tvSname.setText(newList.get(position).toString());



        return view;

    }

    private class ViewHolder {
        TextView tvSname;
    }
}
