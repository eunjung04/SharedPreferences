package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseAcitivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValue()
    }

    override fun setupEvents() {

        login.setOnClickListener {
            val inputId = idEdt.text.toString()
            ContextUtil.setUserId(mContext, inputId)



    }

    override fun setValue() {
        idEdt.setText(ContextUtil.getUserId(mContext))
    }

    }

}
