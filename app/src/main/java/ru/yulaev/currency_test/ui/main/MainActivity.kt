package ru.yulaev.currency_test.ui.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.yulaev.currency_test.R
import ru.yulaev.currency_test.main.MainPresenter
import ru.yulaev.currency_test.model.CurrencyModel
import ru.yulaev.currency_test.ui.BaseActivity

class MainActivity : BaseActivity(), IMain {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Список валют"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.update -> {
                presenter.getCurrency(1)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onError(errorText: String) {
        Toast.makeText(this, errorText, Toast.LENGTH_LONG).show()
    }

    override fun onShowLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        progressBar.visibility = View.GONE
    }


    override fun fillLayout(currencies: List<CurrencyModel>) {
        if (adapter == null) {
            adapter = MainAdapter(currencies)
            currenciesRecView.layoutManager = GridLayoutManager(this, 1)
            currenciesRecView.adapter = adapter
        } else {
            adapter!!.setData(currencies)
        }
    }

}
