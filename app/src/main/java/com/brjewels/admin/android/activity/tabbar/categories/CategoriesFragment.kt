package com.brjewels.admin.android.activity.tabbar.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.brjewels.admin.android.adapter.CategoriesListAdapter
import com.brjewels.admin.android.databinding.FragmentCategoriesBinding
import com.brjewels.admin.android.models.CategoriesListModel

class CategoriesFragment : Fragment() {
    private var _binding : FragmentCategoriesBinding? = null
    private val binding get() = _binding!!
    private lateinit var mList : ArrayList<CategoriesListModel>
    private lateinit var adapter : CategoriesListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater , container , false)

        binding.textViewMens.setOnClickListener { onCategoryClick(it) }
        binding.textViewWomens.setOnClickListener { onCategoryClick(it) }
        binding.textViewUnisex.setOnClickListener { onCategoryClick(it) }


        uniSexRecycler()
        mensRecycler()
        womensRecycler()


        return binding.root
    }

    private fun onCategoryClick(view: View) {
        val categoryTag = (view.tag as String).toInt()

        val underlineView = binding.underlineView
        underlineView.animate().translationX(view.x + view.width / 2 - underlineView.width / 2).start()

        val categoryViewFlipper = binding.categoryViewFlipper
        categoryViewFlipper.displayedChild = categoryTag
    }

    private fun uniSexRecycler(){
        binding.unisexCategoryRecycler.setHasFixedSize(true)
        binding.unisexCategoryRecycler.setLayoutManager(LinearLayoutManager(requireContext()))

        mList = ArrayList<CategoriesListModel>()

        //list1

        //list1
        val nestedList1: MutableList<String> = ArrayList()
        nestedList1.add("K XA KHABAR")
        nestedList1.add("K XA KHABAR")


        val nestedList2: MutableList<String> = ArrayList()
        nestedList2.add("K XA KHABAR")
        nestedList2.add("K XA KHABAR")
        nestedList2.add("K XA KHABAR")

        val nestedList3: MutableList<String> = ArrayList()
        nestedList3.add("K XA KHABAR")
        nestedList3.add("K XA KHABAR")
        nestedList3.add("K XA KHABAR")


        val nestedList4: MutableList<String> = ArrayList()
        nestedList4.add("K XA KHABAR")
        nestedList4.add("K XA KHABAR")
        nestedList4.add("K XA KHABAR")

        val nestedList5: MutableList<String> = ArrayList()
        nestedList5.add("K XA KHABAR")
        nestedList5.add("K XA KHABAR")
        nestedList5.add("K XA KHABAR")

        val nestedList6: MutableList<String> = ArrayList()
        nestedList6.add("K XA KHABAR")
        nestedList6.add("K XA KHABAR")
        nestedList6.add("K XA KHABAR")



        mList.add(CategoriesListModel(nestedList1, "RING"))
        mList.add(CategoriesListModel(nestedList2, "NECKLACE"))
        mList.add(CategoriesListModel(nestedList3, "MANGALSUTRA"))
        mList.add(CategoriesListModel(nestedList4, "RANI HAR"))
        mList.add(CategoriesListModel(nestedList5, "PAUJU"))
        mList.add(CategoriesListModel(nestedList6, "BERUWA"))


        adapter = CategoriesListAdapter(mList)
        binding.unisexCategoryRecycler.setAdapter(adapter)
    }

    private fun womensRecycler(){
        binding.womensCategoryRecycler.setHasFixedSize(true)
        binding.womensCategoryRecycler.setLayoutManager(LinearLayoutManager(requireContext()))

        mList = ArrayList<CategoriesListModel>()

        //list1

        //list1
        val nestedList1: MutableList<String> = ArrayList()
        nestedList1.add("K XA KHABAR")
        nestedList1.add("K XA KHABAR")


        val nestedList2: MutableList<String> = ArrayList()
        nestedList2.add("K XA KHABAR")
        nestedList2.add("K XA KHABAR")
        nestedList2.add("K XA KHABAR")

        val nestedList3: MutableList<String> = ArrayList()
        nestedList3.add("K XA KHABAR")
        nestedList3.add("K XA KHABAR")
        nestedList3.add("K XA KHABAR")


        val nestedList4: MutableList<String> = ArrayList()
        nestedList4.add("K XA KHABAR")
        nestedList4.add("K XA KHABAR")
        nestedList4.add("K XA KHABAR")

        val nestedList5: MutableList<String> = ArrayList()
        nestedList5.add("K XA KHABAR")
        nestedList5.add("K XA KHABAR")
        nestedList5.add("K XA KHABAR")

        val nestedList6: MutableList<String> = ArrayList()
        nestedList6.add("K XA KHABAR")
        nestedList6.add("K XA KHABAR")
        nestedList6.add("K XA KHABAR")



        mList.add(CategoriesListModel(nestedList1, "kt ko hai"))
        mList.add(CategoriesListModel(nestedList2, "necklace"))
        mList.add(CategoriesListModel(nestedList3, "mangalsutra"))
        mList.add(CategoriesListModel(nestedList4, "rani HAR"))
        mList.add(CategoriesListModel(nestedList5, "PAUJU"))
        mList.add(CategoriesListModel(nestedList6, "beruwa ring"))


        adapter = CategoriesListAdapter(mList)
        binding.womensCategoryRecycler.setAdapter(adapter)
    }


    private fun mensRecycler(){
        binding.mensCategoryRecycler.setHasFixedSize(true)
        binding.mensCategoryRecycler.setLayoutManager(LinearLayoutManager(requireContext()))

        mList = ArrayList<CategoriesListModel>()

        //list1

        //list1
        val nestedList1: MutableList<String> = ArrayList()
        nestedList1.add("K XA KHABAR")
        nestedList1.add("K XA KHABAR")


        val nestedList2: MutableList<String> = ArrayList()
        nestedList2.add("K XA KHABAR")
        nestedList2.add("K XA KHABAR")
        nestedList2.add("K XA KHABAR")

        val nestedList3: MutableList<String> = ArrayList()
        nestedList3.add("K XA KHABAR")
        nestedList3.add("K XA KHABAR")
        nestedList3.add("K XA KHABAR")


        val nestedList4: MutableList<String> = ArrayList()
        nestedList4.add("K XA KHABAR")
        nestedList4.add("K XA KHABAR")
        nestedList4.add("K XA KHABAR")

        val nestedList5: MutableList<String> = ArrayList()
        nestedList5.add("K XA KHABAR")
        nestedList5.add("K XA KHABAR")
        nestedList5.add("K XA KHABAR")

        val nestedList6: MutableList<String> = ArrayList()
        nestedList6.add("K XA KHABAR")
        nestedList6.add("K XA KHABAR")
        nestedList6.add("K XA KHABAR")



        mList.add(CategoriesListModel(nestedList1, "kta haru ko hai"))
        mList.add(CategoriesListModel(nestedList2, "ring"))
        mList.add(CategoriesListModel(nestedList3, "bracelet"))
        mList.add(CategoriesListModel(nestedList4, "chain"))
        mList.add(CategoriesListModel(nestedList5, "hatti puchhar"))
        mList.add(CategoriesListModel(nestedList6, "BERUWA"))


        adapter = CategoriesListAdapter(mList)
        binding.mensCategoryRecycler.setAdapter(adapter)
    }


}