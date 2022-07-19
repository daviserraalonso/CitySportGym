package com.example.citysportgym

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.citysportgym.Adapter.MyAdapter
import com.example.citysportgym.Fragments.ProfileFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileActivity : AppCompatActivity() {
    private var tabTitle = arrayOf("Perfil", "Actividades", "Membresia")
    private var editTextName: EditText? = null
    private var editTextEmail: EditText? = null
    private var editTextphone: EditText? = null
    private var editTextPassword: EditText? = null

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        // pager show content
        var pager = findViewById<ViewPager2>(R.id.viewPagerProfile)
        // tabLayout it´s TabsMenu
        var tabLayout = findViewById<TabLayout>(R.id.profileMenu)
        // Personaliced Adaprter
        pager.adapter = MyAdapter(supportFragmentManager, lifecycle)


        TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

        val b = intent.extras
        var name = ""
        var address = ""
        var userEmail = ""
        var phone = ""
        var password = ""

        if (b != null) {
            name = b.getString("name").toString()
            address = b.getString("address").toString()
            userEmail = b.getString("email").toString()
            phone = b.getString("phone").toString()
            password = b.getString("password").toString()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            val mFragment = ProfileFragment()
            val mArgs = Bundle()
            mArgs.putString("name", name)
            mArgs.putString("address", address)
            mArgs.putString("email", userEmail)
            mArgs.putString("phone", phone)
            mArgs.putString("password", password)
            mFragment.arguments = mArgs
            mFragment.arguments = b

        }
    }
}