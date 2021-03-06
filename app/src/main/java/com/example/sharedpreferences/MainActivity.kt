package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        idSaveCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            ContextUtil.setSaveId(mContext,isChecked)

            if (isChecked) {
                Toast.makeText(mContext, "아이디를 저장합니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(mContext, "아이디 저장을 해제합니다.", Toast.LENGTH_SHORT).show()
            }
        }

        login.setOnClickListener {

            if (pwEdt.text.toString() == "1234") {
                if (idSaveCheckBox.isChecked) {

                    val inputId = idEdt.text.toString()
                    ContextUtil.setUserId(mContext, inputId)
                }

            }
        }


    }

    override fun setValue() {


        idEdt.setText(ContextUtil.getUserId(mContext))
        idSaveCheckBox.isChecked=ContextUtil.getSaveId((mContext))

    }
}

