package com.fandu.home.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.fandu.home.MainViewModel
import com.fandu.home.R
import com.fandu.home.databinding.MainBinder
import com.fandu.home.view.fragment.AddFragment
import com.fandu.home.view.fragment.MainFragment

// target from MainFragment
// send to MainViewModel
// send to MainFragment
// send to AddFragment

class MainActivity : AppCompatActivity() {
//class MainActivity : Fragment() {

//    companion object {
//        fun newInstance() : MainActivity = MainActivity()
//    }
//
//    private lateinit var binding: AddBinder
//    private lateinit var viewModel: MainViewModel
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.add_fragment,container,false)
//        return binding.root
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
//        binding.viewModel = viewModel
//        binding.lifecycleOwner = viewLifecycleOwner
//
//        binding.editText.requestFocus()
//        showSoftKeyboard()

//        binding.button.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view : View) {
//                viewModel.insertItem(CustomModel(binding.editText.text.toString()))
//                Toast.makeText(context,"onAdd(${binding.editText.text})", Toast.LENGTH_SHORT).show()
//                hideSoftKeyboard()
//                activity!!.supportFragmentManager.popBackStack() // baru
//            }
//        })
//    }

//    private fun showSoftKeyboard() {
//        val inputMethodManager: InputMethodManager = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
//    }
//
//    private fun hideSoftKeyboard() {
//        val inputMethodManager: InputMethodManager = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
//    }

    ///////// batas lagi ///////

//    private lateinit var viewModel : MainViewModel

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        initObservable()
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.activity_main_lagi, container, false)
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initView()
//        if (savedInstanceState == null) {
//            callMainFragment()

//            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        }
//    }
//
//    fun onMessage(message: String?) {
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//    }
//
//    fun onMessage(stringResId: Int) {
//        onMessage(getString(stringResId))
//    }

    /**
     * hide keyboard layout
     */
//    override fun hideKeyboard() {
//        return KeyboardUtils().hide(activity!!)
//    }

//    untuk network
//    fun initObservable() {
//        val networkBuilder = Network.builder().create(NetworkServices::class.java)
//
//        respository = MovieRepositoryImpl(networkBuilder)
//
//        useCase = PopularMovieUseCase(respository)
//
//        viewModel = ViewModelProviders
//            .of(this, PopularMovieFactory(useCase))
//            .get(PopularMovieViewModel::class.java)
//
//    }

//    fun initView() {
//
//        lstPopularMovie.layoutManager = GridLayoutManager(context, 2)
//        lstPopularMovie.adapter = adapter
//
//        viewModel.error.observe(viewLifecycleOwner, showError())
//
//        viewModel.movies.observe(viewLifecycleOwner, Observer {
//            adapter.movies = it.resultsIntent
//            adapter.notifyDataSetChanged()
//        })
//    }

    ////////// batas /////////////

    private lateinit var binding : MainBinder
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            Log.d("fandu 123456", "fandu 123")
            callMainFragment()

            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        }
    }

    private fun callMainFragment() {
        Log.d("fandu 123456", "fandu 123")
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerfandu,
                MainFragment.newInstance()
            )
            .commitNow()
    }

    fun callAddFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.containerfandu,
                AddFragment.newInstance()
            )
            .addToBackStack("AddFragment").commit()
    }

    fun showSoftKeyboard(activity: Activity, showKeyboard : Boolean) {
        var view = activity.currentFocus
        when(showKeyboard){
            true -> {
                val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            }
            false ->{
                val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                //Find the currently focused view, so we can grab the correct window token from it.

                //If no view currently has focus, create a new one, just so we can grab a window token from it
                if (view == null) {
                    view = View(activity)
                }
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        }
        else {
            supportFragmentManager.popBackStack()
        }
    }

}
