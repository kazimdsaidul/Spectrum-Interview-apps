package com.kazi.spectruminterview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.utils.viewUtil.hide
import com.cloudwell.paywell.consumer.utils.viewUtil.show
import com.kazi.spectruminterview.R
import com.kazi.spectruminterview.ui.home.adapter.EmployeeItem
import com.kazi.test.data.db.entities.Employee
import com.kazi.test.ui.employeesList.employeesViewModelFactory.EmployeesViewModelFactory
import com.kazi.test.ui.employeesList.view.IVIewEmployerList
import com.kazi.test.utils.Coroutines
import kotlinx.android.synthetic.main.fragment_home.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class CompanyFragment : Fragment(), IVIewEmployerList, KodeinAware {

    private lateinit var homeViewModel: HomeViewModel

    override val kodein by kodein()

    private val factory: EmployeesViewModelFactory by instance()
    private lateinit var viewModel: EmployeesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel.text.observe(this, Observer {

        })
        return root
    }

    override fun onResume() {
        super.onResume()
        viewModel.view = this
        viewModel.getEmployeesList()
        bindUI()
    }

    private fun bindUI() = Coroutines.main {
        progress_bar.show()
        viewModel.listOfEmployees.observe(this, Observer {
            progress_bar.hide()
            initRecyclerView(it.toQuoteItem())
        })
    }

    private fun initRecyclerView(quoteItem: List<EmployeeItem>) {

//        val mAdapter = GroupAdapter<RecyclerView.ViewHolder>().apply {
//            addAll(quoteItem)
//        }
//
//        recyclerview.apply {
//            layoutManager = LinearLayoutManager(context)
//            setHasFixedSize(true)
//            adapter = mAdapter
//        }
//
//
//
//        mAdapter.setOnItemClickListener(object : OnItemClickListener {
//            override fun onItemClick(item: Item<*>, view: View) {
//                val employeeItem = item as EmployeeItem
//                viewModel.onItemClick(employeeItem.employee)
//
//            }
//        })
    }


    private fun List<Employee>.toQuoteItem(): List<EmployeeItem> {
        return this.map {
            EmployeeItem(it)
        }
    }


    override fun openEmpDetailsActivity(employee: Employee) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hiddenProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun noInternetConnectionFound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}