package com.morajavier.raza;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VisorImageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VisorImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VisorImageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int idImg;
    private String contDescript;

    private OnFragmentInteractionListener mListener;

    public VisorImageFragment(int idImg, String contDescrip) {
        // Required empty public constructor
        this.idImg = idImg;
        this.contDescript = contDescrip;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_visor_image, container, false);
        TextView txtDescripcion = v.findViewById(R.id.xdescripcion);
        ImageView imgRaza = v.findViewById(R.id.imageViewConte);
        txtDescripcion.setText(this.contDescript);
        imgRaza.setImageResource(this.idImg);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
