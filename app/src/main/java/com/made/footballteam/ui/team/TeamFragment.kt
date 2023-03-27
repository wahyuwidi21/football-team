package com.made.footballteam.ui.team

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.made.footballteam.R
import com.made.footballteam.databinding.FragmentTeamBinding
import com.made.footballteam.ui.adapter.TeamAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamFragment : Fragment() {

    private val teamViewModel: TeamViewModel by viewModels()
    private lateinit var binding: FragmentTeamBinding
    private lateinit var teamAdapter: TeamAdapter
    private val mainNavController by lazy { requireActivity().findNavController(R.id.nav_host_main) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamBinding.inflate(layoutInflater)
        teamAdapter = TeamAdapter {
            val bundle =
                bundleOf(
                    "id" to it
                )
            mainNavController.navigate(
                R.id.action_fragment_team_to_fragment_detail_team,
                bundle
            )
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFootballTeam.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = teamAdapter
            itemAnimator = null
        }
        binding.btnListFavorite.setOnClickListener {
            try {
                installFavoriteModule()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Module not found", Toast.LENGTH_SHORT).show()
            }
        }
        teamViewModel.footballTeam.observe(viewLifecycleOwner) {
            teamAdapter.setItem(it.data)
        }
    }

    private fun installFavoriteModule() {
        val splitInstallManager = SplitInstallManagerFactory.create(requireContext())
        val moduleFavorite = "favorite"
        if (splitInstallManager.installedModules.contains(moduleFavorite)) {
            moveToFavorite()
            Toast.makeText(requireContext(), "Open module", Toast.LENGTH_SHORT).show()
        } else {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleFavorite)
                .build()
            splitInstallManager.startInstall(request)
                .addOnSuccessListener {
                    Toast.makeText(
                        requireContext(),
                        "Success installing module",
                        Toast.LENGTH_SHORT
                    ).show()
                    moveToFavorite()
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), "Error installing module", Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }

    private fun moveToFavorite() {
        startActivity(
            Intent(
                requireContext(),
                Class.forName("com.made.footballteam.favorite.FavoriteActivity")
            )
        )
    }
}