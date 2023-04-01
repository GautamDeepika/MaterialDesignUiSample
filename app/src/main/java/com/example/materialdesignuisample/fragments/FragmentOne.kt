package com.example.materialdesignuisample.fragments

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.materialdesignuisample.R
import com.example.materialdesignuisample.adapter.CustomAdapter
import com.example.materialdesignuisample.adapter.TransactAdapter
import com.example.materialdesignuisample.data.Crypto
import com.example.materialdesignuisample.data.CryptoCurrent
import com.example.materialdesignuisample.databinding.FragmentOneBinding
import com.google.android.material.navigation.NavigationView

class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneBinding
    private lateinit var adapter: CustomAdapter
    private lateinit var transAdapter: TransactAdapter
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        toggle =
            ActionBarDrawerToggle(requireActivity(), drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        openNotificationFragment()
        adapterSetUp()
        openDrawerMenu()
    }

    private fun openDrawerMenu() {
        binding.includeAction.setOnClickListener {
            openCloseNavigationDrawer(it)
        }
    }

    private fun openCloseNavigationDrawer(view: View?) {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

    }

    private fun adapterSetUp() {
        val values = defineCryptoParameters()
        binding.rvList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter = CustomAdapter(values)
        binding.rvList.adapter = adapter

        val transac = defineCryptoCurrentParameters()
        binding.rvtrans.layoutManager =
            LinearLayoutManager(requireContext())
        transAdapter = TransactAdapter(transac)
        binding.rvtrans.adapter = transAdapter
    }

    private fun openNotificationFragment() {
        binding.includeAction.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentOne_to_notificationFragment)
        }
    }

    private fun defineCryptoParameters(): ArrayList<Crypto> {
        val a = Crypto("GBP")
        val b = Crypto("USD")
        val c = Crypto("TL")
        val d = Crypto("EUR")

        return arrayListOf<Crypto>(a, b, c, d)
    }

    private fun defineCryptoCurrentParameters(): ArrayList<CryptoCurrent> {
        val a1 = CryptoCurrent("-$124", "${R.drawable.ic_baseline_add_circle_outline_24}")
        val b1 = CryptoCurrent("-$124", "${R.drawable.ic_baseline_notifications_active_24}")
        val c1 = CryptoCurrent("-$124", "${R.drawable.ic_baseline_home_24}")
        val d1 = CryptoCurrent("-$124", "${R.drawable.ic_baseline_image_24}")
        val bursa = arrayListOf<CryptoCurrent>(a1, b1, c1, d1)
        return bursa
    }
}