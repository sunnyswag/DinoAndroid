package com.demo.dinoandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.dinoandroid.R
import com.demo.dinoandroid.adapter.ReferencesListAdapter
import com.demo.dinoandroid.domain.ReferenceData
import com.demo.dinoandroid.viewmodel.PagerViewModel
import com.demo.dinoandroid.viewmodel.ReferencesViewModel
import pl.droidsonroids.gif.GifImageView

class EnterFragment: Fragment(), View.OnClickListener {

    private lateinit var referencesViewModel: ReferencesViewModel
    private lateinit var pagerViewModel: PagerViewModel

    private lateinit var referencesList: RecyclerView
    private lateinit var dinoIcon: GifImageView
    private lateinit var references: TextView

    private val dataSet = listOf(
        ReferenceData("123", "12432", "https://github.com/sunnyswag/DinoAndroid"),
        ReferenceData("1234", "124322","https://github.com/sunnyswag/DinoAndroid")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_enter, container)
        initUI(root)
        initViewModel()
        initAdapter(container)

        return root
    }

    private fun initAdapter(container: ViewGroup?) {
        referencesList.layoutManager = LinearLayoutManager(container?.context)
        referencesList.adapter = ReferencesListAdapter(dataSet, referencesViewModel)
    }

    private fun initViewModel() {
        referencesViewModel = ViewModelProvider(requireActivity()).get(ReferencesViewModel::class.java)
        pagerViewModel = ViewModelProvider(requireActivity()).get(PagerViewModel::class.java)
        referencesViewModel.referenceListDisplay.observe(viewLifecycleOwner) {
            referencesList.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }
    }

    private fun initUI(root: View) {
        dinoIcon = root.findViewById(R.id.dino_icon)
        references = root.findViewById(R.id.references)
        referencesList = root.findViewById(R.id.referencesList)

        dinoIcon.setOnClickListener(this)
        references.setOnClickListener(this)
        referencesList.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.dino_icon -> pagerViewModel.goToGameFragment.value = true
            R.id.references -> referencesViewModel.referenceListDisplay.value =
                !(referencesViewModel.referenceListDisplay.value as Boolean)
        }
    }

}