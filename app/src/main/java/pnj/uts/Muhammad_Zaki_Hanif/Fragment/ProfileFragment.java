package pnj.uts.Muhammad_Zaki_Hanif.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pnj.uts.Muhammad_Zaki_Hanif.Login;
import pnj.uts.Muhammad_Zaki_Hanif.databinding.FragmentProfileBinding;
import pnj.uts.Muhammad_Zaki_Hanif.sharedPreference.Preferences;

public class ProfileFragment extends Fragment {
private FragmentProfileBinding binding;

public ProfileFragment(){
//Constructor
}


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        // inflate layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.edtEmail.setText(Preferences.getEmailUser(getContext()));
        binding.edtNama.setText(Preferences.getNamaUser(getContext()));
        binding.edtKelas.setText(Preferences.getKelasUser(getContext()));
        binding.edtNim.setText(String.valueOf(Preferences.getNimUser(getContext())));

        binding.btnLogout.setOnClickListener(v->{
            Preferences.clearDataUser(getContext());
            requireContext().startActivity(new Intent(getContext(),
                    Login.class));
            requireActivity().finish();
        });

    }
}