package ir.alirezanazari.clubhome.util.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.ViewToolbarBinding
import ir.alirezanazari.clubhome.util.gone

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    style: Int = 0
) : FrameLayout(context, attrs, style) {

    private var binding: ViewToolbarBinding? = null

    init {
        binding = ViewToolbarBinding.inflate(LayoutInflater.from(context), this, true)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ToolbarView)

        try {
            binding!!.titleTextView.text = ta.getString(R.styleable.ToolbarView_tv_title).orEmpty()
        } finally {
            ta.recycle()
        }
    }

    fun onBackButtonClicked(listener: () -> Unit) {
        binding?.backButton?.setOnClickListener {
            listener.invoke()
        }
    }

    fun goneButtons() {
        binding?.backButton?.gone()
    }

}