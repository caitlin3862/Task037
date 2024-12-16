package com.example.navigationdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.findNavController

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu_fragment_1, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.frag1_menu_screen2){
                    val navController: NavController = view.findNavController()
                    navController.navigate(R.id.secondFragment)
                    return true
                }
                if (menuItem.itemId == R.id.frag1_menu_screen3){
                    val navController: NavController = view.findNavController()
                    navController.navigate(R.id.thirdFragment)
                    return true
                }
                if (menuItem.itemId == R.id.frag1_menu_toast){
                    Toast.makeText(context, "Tapped menu item", Toast.LENGTH_SHORT).show()
                    return true
                }
                return false;
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

}
