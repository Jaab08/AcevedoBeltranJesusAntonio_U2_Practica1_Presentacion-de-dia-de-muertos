package mx.tecnm.tepic.ladm_u2_practica1_presentaciondiademuertos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View

class Lienzo (p:MainActivity) :View(p) {
    var cX = 100f
    var incY = 10
    var incY2 = 10
    var incX = 10

    var trabajando = false

    var lapida1 = Imagen(this, 50f,1100f,R.drawable.lapida)
    var lapida2 = Imagen(this, 400f,1100f,R.drawable.lapida)
    var lapida3 = Imagen(this, 750f,1100f,R.drawable.lapida)

    var lapida9 = Imagen(this, 50f,1600f,R.drawable.lapida)
    var lapida10 = Imagen(this, 400f,1600f,R.drawable.lapida)
    var lapida11 = Imagen(this, 750f,1600f,R.drawable.lapida)

    var catrin = Imagen(this, 100f,-340f,R.drawable.catrin)
    var catrina = Imagen(this, 600f,2250f,R.drawable.catrina)
    var xolo= Imagen(this, 120f,450f,R.drawable.xoloitzcuintle)

    val timer = object : CountDownTimer(2000, 100){
        override fun onTick(p0: Long) {
            catrin.y += incY
            if (catrin.y <= -350 || catrin.y >= 2300f) {
                incY *= -1
            }
            invalidate()
        }

        override fun onFinish() {
            start()
        }

    }

    val timer2 = object : CountDownTimer(2000, 100){
        override fun onTick(p0: Long) {
            catrina.y += incY2
            if (catrina.y <= -350 || catrina.y >= 2300) {
                incY2 *= -1
            }
            invalidate()
        }

        override fun onFinish() {
            start()
        }

    }

    val timer3 = object : CountDownTimer(2000, 100){
        override fun onTick(p0: Long) {
            xolo.x += incX
            if (xolo.x <= -200 || xolo.x >= 1200) {
                incX *= -1
            }
            invalidate()
        }

        override fun onFinish() {
            start()
        }

    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p = Paint()

        // RECTANGULO DE MITAD HACIA ARRIBA CIELO
        p.setColor(Color.argb(255, 63,81,181))
        c.drawRect(0f,0f,1080f,1065f,p)

        // RECTANGULO DE MITAD HACIA ABAJO PASTO
        p.setColor(Color.argb(255,27,94,32))
        c.drawRect(0f,1065f,1080f,2131f,p)

        //LUNA
        p.strokeWidth = 7f
        p.setColor(Color.argb(255,235,230,210))
        c.drawCircle(540f,200f,150f,p)
        p.style = Paint.Style.STROKE
        p.setColor(Color.BLACK)
        c.drawCircle(540f,200f,150f,p)

        // Nubes
        p.style = Paint.Style.FILL
        p.setColor(Color.argb(255,145,145,140))
        cX = 100f
        for (i in 0..2){
            c.drawCircle(cX,200f,75f,p)
            cX += 75f
        }
        cX = 510f
        for (i in 0..2){
            c.drawCircle(cX,300f,75f,p)
            cX += 75f
        }
        cX = 810f
        for (i in 0..2){
            c.drawCircle(cX,150f,75f,p)
            cX += 75f
        }

        // Troncos
        p.style = Paint.Style.FILL
        p.setColor(Color.argb(255, 80,45,30))
        c.drawRect(200f,800f, 300f,1065f,p)
        c.drawRect(880f,800f, 780f,1065f,p)

        xolo.pintar(c)
        // Arboles
        p.setColor(Color.argb(255,27,94,32))
        c.drawCircle(250f,605f,200f,p)
        c.drawCircle(830f,605f,200f,p)

        // LAPIDAS
        lapida1.pintar(c)
        lapida2.pintar(c)
        lapida3.pintar(c)

        lapida9.pintar(c)
        lapida10.pintar(c)
        lapida11.pintar(c)

        catrin.pintar(c)
        catrina.pintar(c)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (trabajando == false) {
                    timer.start()
                    timer2.start()
                    timer3.start()
                    trabajando = true
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {

            }
        }
        invalidate()
        return true
    }

}