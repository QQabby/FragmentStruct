package com.demo.fragment

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
       var transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_home -> {
               // message.setText(R.string.title_home)
                transaction.replace(R.id.fragment_container,homeFragment,"homeTag")
                transaction.commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
               // message.setText(R.string.title_dashboard)
                transaction.replace(R.id.fragment_container,recordFragment,"recordTag")
                transaction.commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                transaction.replace(R.id.fragment_container,notificationFragment,"notificationTag")
                transaction.commit()

                // message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    var recordFragment = RecordFragment()
    var notificationFragment = NotificationFragment()
    var homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        var fm = supportFragmentManager
        var transaction = fm.beginTransaction()

        transaction.replace(R.id.fragment_container,homeFragment,"homeTag")
        transaction.commit()

    }

    fun setFunctionFragment( tag:String ){

        var baseFragment = supportFragmentManager.findFragmentByTag(tag) as BaseFragment
        var functionManager = FunctionManager.getInstance()
        baseFragment.setFunctionManager(
                functionManager.addFunction(HomeFragment.INTERFACE_NOPARAMANDRESULT,
                        object : FunctionNoParamNoResult(HomeFragment.INTERFACE_NOPARAMANDRESULT){
            override fun function() {
                Toast.makeText(this@MainActivity, "click 无参数无返回值的方法", Toast.LENGTH_SHORT).show()
            }
        })
         .addFunction(HomeFragment.INTERFACE_ONLYPARAM,object : FunctionOnlyParam<String>(HomeFragment.INTERFACE_ONLYPARAM){
             override fun function(param: String?) {
                 Toast.makeText(this@MainActivity, "click 有参数的方法"+param, Toast.LENGTH_SHORT).show()
             }
         })
        .addFunction(HomeFragment.INTERFACE_ONLYRESULT,object:FunctionOnlyResult<String>(HomeFragment.INTERFACE_ONLYRESULT){
            override fun function(): String {
                return "我是结果";
            }
        })

        .addFunction(HomeFragment.INTERFACE_RESULTANDPARAM,object :FunctionParamAndResult<String,String>(HomeFragment.INTERFACE_RESULTANDPARAM){
            override fun function(param: String?): String {
                Toast.makeText(this@MainActivity, "参数"+param, Toast.LENGTH_SHORT).show()
                return "result"
            }
        })
        )
    }
}
