package com.fandu.home.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fandu.home.MainViewModel
import com.fandu.home.R
import com.fandu.home.databinding.MainBinder
import com.fandu.data.model.CustomModel
import com.fandu.home.view.CustomListeners
import com.fandu.home.view.MainActivity
import com.fandu.home.view.adapter.CustomAdapter

// note fandu
// send to ui xml main_fragment = MainBinder
// send to ui xml main_fragment (data)
// send to MainViewModel
// send to CustomAdapter
// send to CustomListeners
// send to CustomModel
// send to MainActivity untuk add nya
// tembak from MainActivity

class MainFragment : Fragment(), CustomListeners {

    companion object {
        fun newInstance() : MainFragment = MainFragment()
    }

    private lateinit var binding: MainBinder
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter : CustomAdapter
    //private lateinit var itemDecorationHelper: BottomOffsetDecorationHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setRecyclerView()
        setFloatingActionButton()
    }

    private fun setRecyclerView() {
        adapter = CustomAdapter(context!!, this)
        //itemDecorationHelper = BottomOffsetDecorationHelper(context!!,R.dimen.extra_scroll)

        binding.recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        //binding.recyclerView.removeItemDecoration(itemDecorationHelper)
        binding.recyclerView.adapter = adapter

        viewModel.getItems().observe(viewLifecycleOwner, object : Observer<List<CustomModel>> {
            override fun onChanged(list : List<CustomModel>) {
                binding.recyclerView.removeAllViews()
                adapter.setItems(list)
                adapter.notifyDataSetChanged();
            }
        })
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun setFloatingActionButton() {
        binding.floatingActionButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                onAdd()
            }
        })
    }

    private fun onAdd() {
        (activity as MainActivity).callAddFragment()
    }

    override fun onUpdate(item: CustomModel, position: Int) {
        Toast.makeText(context,"onUpdate(${item.name},${position})",Toast.LENGTH_SHORT).show()
    }

    override fun onDelete(item: CustomModel, position: Int) {
        Toast.makeText(context,"onDelete(${item.name},${position})",Toast.LENGTH_SHORT).show()
    }

}