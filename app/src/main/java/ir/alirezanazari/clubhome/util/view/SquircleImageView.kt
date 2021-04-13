package ir.alirezanazari.clubhome.util.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import ir.alirezanazari.clubhome.util.toDp

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class SquircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    style: Int = 0
) : AppCompatImageView(context, attrs, style) {

    private val clipPath = Path()
    private val borderPath = Path()

    private val clipPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
    }
    private val borderPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
    }

    init {
        scaleType = ScaleType.CENTER_CROP
        setLayerType(LAYER_TYPE_HARDWARE, null)
        clipPaint.apply {
            color = 0xFF0000
            xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        }

        borderPaint.apply {
            color = 0x200000
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        clipPath.apply {
            moveTo(0.0f, 100.0f)
            cubicTo(0.0f, 33.0f, 33.0f, 0.0f, 100.0f, 0.0f)
            cubicTo(167.0f, 0.0f, 200.0f, 33.0f, 200.0f, 100.0f)
            cubicTo(200.0f, 167.0f, 167.0f, 200.0f, 100.0f, 200.0f)
            cubicTo(33.0f, 200.0f, 0.0f, 167.0f, 0.0f, 100.0f)
            close()
        }

        val matrix = Matrix().apply {
            setScale(w / 200f, h / 200f, 0f, 0f)
        }
        clipPath.transform(matrix)

        matrix.setScale(
            (w - context.toDp(1f)) / w,
            (w - context.toDp(1f)) / h,
            w / 2f,
            h / 2f
        )
        clipPath.transform(matrix, borderPath)

        clipPath.toggleInverseFillType()
        borderPath.toggleInverseFillType()
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        canvas?.apply {
            drawPath(borderPath, borderPaint)
            drawPath(clipPath, clipPaint)
        }
    }
}