package com.example.daka

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val MYACTION = "android.intent.action.STARTMYAP"
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var web = WebView(this)
        setContentView(web)

        val settings = web.settings
        settings.javaScriptEnabled = true

        web.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                web.loadUrl("javascript:document.getElementsByName('jibenxinxi_shifoubenrenshangbao')[0].click()")
                web.loadUrl("javascript:document.getElementsByName('jiankangxinxi_muqianshentizhuangkuang')[0].click()")
                //延时

                web.loadUrl("javascript:setTimeout(\"document.getElementsByName('xingchengxinxi_weizhishifouyoubianhua')[0].click()\",\"1000\");")

                //web.loadUrl("javascript:document.getElementsByClassName('el-button Findbutton el-button--primary')[0].click()")
                //web.loadUrl("javascript:document.getElementsByName('xingchengxinxi_weizhishifouyoubianhua')[0].click()")
                web.loadUrl("javascript:setTimeout(\"document.getElementsByClassName('el-button Findbutton el-button--primary')[0].click()\",\"1000\");")
                }
        }

        web.loadUrl("http://e-report.neu.edu.cn/mobile/notes/create")
        val am = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(MYACTION)
        val pi = PendingIntent.getBroadcast(this, 0, intent, 1)
        am[AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 43200000] = pi //15秒钟以后启动

    }
}
