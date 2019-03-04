package com.androidarchitecturecomponents.slider

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.androidarchitecturecomponents.R

class MainSliderActivity : AppCompatActivity() {


    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView

    private val data = (1..20).toList().map { it.toString() } as ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_slider)
        setTvSelectedItem()
        setHorizontalPicker()

        val ivSelector = findViewById<ImageView>(R.id.ivSelector)
        ivSelector.layoutParams.width= ScreenUtils.getScreenWidth(this) / 5
    }

    private fun setTvSelectedItem() {
        tvSelectedItem = findViewById(R.id.tv_selected_item)
    }

    private fun setHorizontalPicker() {
        rvHorizontalPicker = findViewById(R.id.rv_horizontal_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int = ScreenUtils.getScreenWidth(this) / 2 - ScreenUtils.dpToPx(this, 40)
        //TODO
        rvHorizontalPicker.setPadding(padding, 0, padding, 0)

//         Setting layout manager
        rvHorizontalPicker.layoutManager = SliderLayoutManager(this).apply {
            callback = object : SliderLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    tvSelectedItem.setText(data[layoutPosition])
                }
            }
        }

        // Setting Adapter
        rvHorizontalPicker.adapter = SliderAdapter().apply {
            setData(data)
            callback = object : SliderAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvHorizontalPicker.smoothScrollToPosition(rvHorizontalPicker.getChildLayoutPosition(view))
                }
            }
        }
    }
}
