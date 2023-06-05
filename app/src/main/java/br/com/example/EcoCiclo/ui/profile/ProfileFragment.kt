package br.com.example.EcoCiclo.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.example.ecociclo.R
import br.com.example.ecociclo.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        addEvents()
        return binding.root
    }

    private fun addEvents() {
        _binding?.vipCardView?.setOnClickListener {
            activity?.let { activity ->
                //val fragmentManager = activity.supportFragmentManager
                //val fragmentTransaction = fragmentManager.beginTransaction()
                //fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, NotificationsFragment())
                //fragmentTransaction.commit()

                findNavController().navigate(R.id.action_navigation_profile_to_navigation_notifications)
                //val navController = findNavController()
            }
        }

        _binding?.exitCardView?.setOnClickListener {
            activity?.let { activity ->
                super.onDestroyView()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}