package com.example.citysportgym.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.citysportgym.Fragments.EventFragment
import com.example.citysportgym.Fragments.MessageFragment
import com.example.citysportgym.Fragments.ProfileFragment
import com.example.citysportgym.Fragments.SportFragment

class MyAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ProfileFragment()
            1 -> return SportFragment()
            2 -> return EventFragment()
            else -> return MessageFragment()

        }
    }
}