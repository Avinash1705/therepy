package com.example.therapy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.therapy.models.Data
import com.example.therapy.models.therapyModel

class gridViewAdapter(context: Context, val arrayList: List<Data>) : ArrayAdapter<Data>(context, 0,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        var listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(context).inflate(R.layout.row_card, parent, false);
        }

        val courseModel = arrayList[position]
        val courseTV = listitemView!!.findViewById<TextView>(R.id.tvMain)
        val courseIV = listitemView.findViewById<ImageView>(R.id.ivMain);

        courseTV.text = courseModel.name;
        Glide.with(context).load(courseModel.profile).into(courseIV)
        //onclick
        listitemView.setOnClickListener {
            Toast.makeText(context, "${courseModel.name} Clicked", Toast.LENGTH_SHORT).show()
        }
        return listitemView;
    }
}
