package com.example.groupieadapter

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.groupieadapter.databinding.ActivityMainBinding
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section
import java.util.*

class MainActivity : AppCompatActivity() {
    private val excitingSection = Section()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //    setSupportActionBar(binding.toolbar)

        val boringFancyItems = generateFancyItems(6)
        val excitingFancyItems = generateFancyItems(12)

        val groupAdapter = GroupieAdapter().apply {
            spanCount = 3
        }

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, groupAdapter.spanCount).apply {
                spanSizeLookup = groupAdapter.spanSizeLookup
            }
            adapter = groupAdapter
        }

        ExpandableGroup(ExpandableHeaderItem("Boring Group"), false).apply {
            add(Section(boringFancyItems))
            groupAdapter.add(this)
        }

        val value = ExpandableGroup(ExpandableHeaderItem("Exciting  Group"), true)

        value.add(Section(excitingFancyItems))
         groupAdapter.add(value)

    }

    private fun generateFancyItems(count: Int): MutableList<FancyItem> {
        val rnd = Random()
        return MutableList(count) {
            val color = Color.argb(
                255, rnd.nextInt(256),
                rnd.nextInt(256), rnd.nextInt(256)
            )
            FancyItem(color, rnd.nextInt(100))
        }
    }
}