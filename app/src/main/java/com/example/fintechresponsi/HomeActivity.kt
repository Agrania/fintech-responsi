package com.example.fintechresponsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeFragment = HomeFragment()
        val paymentFragment = PaymentFragment()
        val historyFragment = HistoryFragment()
        val settingFragment = SettingFragment()

        makeCurrentFragment(homeFragment)

        button_navigation.setOnNavigationItemSelectedListener {
            when(it.ItemId){
                R.id.ic_Home -> makeCurrentFragment(homeFragment)
                R.id.ic_Payment -> makeCurrentFragment(paymentFragment)
                R.id.ic_History -> makeCurrentFragment(historyFragment)
                R.id.ic_Setting -> makeCurrentFragment(settingFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
}