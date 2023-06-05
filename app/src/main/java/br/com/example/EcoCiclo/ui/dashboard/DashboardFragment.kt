package br.com.example.ecociclo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.example.ecociclo.LanguageAdapter
import br.com.example.ecociclo.R
import br.com.example.ecociclo.databinding.FragmentDashboardBinding
import com.example.searchviewkotlin.LanguageData
import java.util.ArrayList
import java.util.Locale


class DashboardFragment : Fragment() {

private var _binding: FragmentDashboardBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

    return root
  }


    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<LanguageData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

   private fun addDataToList() {
        mList.add(
            LanguageData(
                "99 Pay",
                R.drawable._9pay,
                "Saldo: R$ 33,71"
            )
        )
        mList.add(
            LanguageData(
                "Ame Digital",
                R.drawable.amedigital,
                "Saldo: R$ 42,70"
            )
        )
        mList.add(
            LanguageData(
                "PicPay",
                R.drawable.picpay,
                "Saldo: R$ 14,00"
            )
        )
        mList.add(
            LanguageData(
                "Recarga pay",
                R.drawable.recargapay,
                "Saldo: R$ 5,50"
            )
        )
        mList.add(
           LanguageData(
               "Cuponomia",
               R.drawable.cuponomia,
               "Saldo: R$ 12,90"
           )
        )
        mList.add(
           LanguageData(
               "Méliuz",
               R.drawable.meliuz,
               "Saldo: R$ 22,50"
           )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)


        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        addDataToList()
        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}