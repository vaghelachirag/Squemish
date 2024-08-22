package com.example.mypraticeapplication.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import com.example.mypraticeapplication.R
import java.util.Locale

class CustomArrayAdapter<T>(context: Context, private val layoutResId: Int, items: List<T>): ArrayAdapter<T>(context, layoutResId, items) {

    val mInflater: LayoutInflater = LayoutInflater.from(context)

    private val filter = MyFilter(items, this)
    override fun getFilter(): Filter {
        return filter
    }

    private val filteredItems: MutableList<T> = ArrayList()

    init {
        filteredItems.addAll(items)
    }



    override fun getCount(): Int = filteredItems.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = mInflater.inflate(R.layout.item_custom_array_adapter, parent, false)
        val holder = ViewHolder(view)

        val item = filteredItems[position]
        holder.bind(item.toString())

        return view!!
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }

    private class ViewHolder(view: View) {
        private val textView: TextView = view.findViewById(R.id.text_view)

        fun bind(item: String?) {
            textView.text = item
        }
    }

    private inner class MyFilter<T>(private val originalItems: List<T>, private val adapter: ArrayAdapter<T>) : Filter() {

        private var filteredItems: List<T> = originalItems

        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val results = FilterResults()

            filteredItems = if (constraint == null || constraint.isEmpty()) {
                originalItems
            } else {
                val filterPattern = constraint.toString().lowercase(Locale.getDefault())
                originalItems.filter {
                    it.toString().lowercase(Locale.getDefault()).contains(filterPattern)
                }
            }

            results.values = filteredItems
            results.count = filteredItems.size

            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            filteredItems = results?.values as? List<T> ?: emptyList()
            (adapter as CustomArrayAdapter).filteredItems.clear()
            adapter.filteredItems.addAll(filteredItems)
            adapter.notifyDataSetChanged()
        }

        override fun convertResultToString(resultValue: Any?): CharSequence {
            Log.d(TAG, "convertResultToString: $resultValue")
            return resultValue.toString()
        }
    }

    companion object {
        private const val TAG = "CustomArrayAdapter"
    }

}