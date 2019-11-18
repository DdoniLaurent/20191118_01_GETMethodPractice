package com.tioeun.a20191118_01_getmethodpractice

import android.os.Bundle
import android.widget.Toast
import com.tioeun.a20191118_01_getmethodpractice.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        loginBtn.setOnClickListener {
            if(rememberIdCheckBox.isChecked){

                ContextUtil.setUserId(mContext, idEdt.text.toString())

                Toast.makeText(mContext, "아이디를 저장했습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(mContext, "아이디를 저장 X", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setValues() {

//        저장되어 있는 아이디가 뭔지?
        var savedId = ContextUtil.getUserId(mContext)
        idEdt.setText(savedId)
    }

}
