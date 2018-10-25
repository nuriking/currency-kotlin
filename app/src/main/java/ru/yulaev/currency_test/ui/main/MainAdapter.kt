package ru.yulaev.currency_test.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.items_currency.view.*
import ru.yulaev.currency_test.R
import ru.yulaev.currency_test.model.CurrencyModel

class MainAdapter(currencies: List<CurrencyModel>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var currencyList = currencies

    fun setData(currencies: List<CurrencyModel>) {
        currencyList = currencies
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_currency, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = currencyList[position].name
        holder.volume.text = currencyList[position].volume.toString()
        holder.amount.text = currencyList[position].price.amount.toString()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.name!!
        val volume = view.volume!!
        val amount = view.amount!!

    }
}