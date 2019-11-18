package com.tioeun.a20191118_01_getmethodpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tioeun.a20191118_01_getmethodpractice.datas.User
import com.tioeun.a20191118_01_getmethodpractice.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        ServerUtil.getRequestMyInfo(mContext, object : ServerUtil.JonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("내정보응답", json.toString())

                val data = json.getJSONObject("data")
                val user = data.getJSONObject("user")

//                val loginId = user.getString("login_id")
//
//                var me:User = User()
//                me.loginId = user.getString("login_id")
//                me.name = user.getString("name")
//                me.phone = user.getString("phone")

//                위의 코드를 아래 한줄로 요약
                var me = User.getUserFromJson(user)

                runOnUiThread {
                    nameTxt.text = me.name
                    phoneTxt.text = me.phone
                    idTxt.text = me.loginId
                }

            }

        })
    }


}
