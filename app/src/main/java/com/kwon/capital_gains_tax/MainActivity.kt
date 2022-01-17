package com.kwon.capital_gains_tax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.royrodriguez.transitionbutton.TransitionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_btn.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                // Start the loading animation when the user tap the button
                start_btn.startAnimation()

                // Do your networking task or background work here.
                val handler = Handler()
                handler.postDelayed(Runnable {
                    val isSuccessful = true

                    // Choose a stop animation if your call was succesful or not
                    if (isSuccessful) {
                        start_btn.stopAnimation(start_btn.StopAnimationStyle.EXPAND,
                            TransitionButton.OnAnimationStopEndListener {
                                val intent = Intent(baseContext, NewActivity::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                                startActivity(intent)
                            })
                    } else {
                        start_btn.stopAnimation(
                            start_btn.StopAnimationStyle.SHAKE,
                            null
                        )
                    }
                }, 2000)
            }
        })
    }
}