package com.example.maximus.droneme;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TransportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TransportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransportFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button getButton;
    private Button pickButton;
    private Button infoButton;
    private ImageView imgView;
    private ImageView imgView2;
    private ImageView bringView;
    private ImageView pickView;
    private ImageView infoView;
    //private ImageView confirmView;
    private Button confirmButton;
   // private TextView fetchText;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TransportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TransportFragment newInstance(String param1, String param2) {
        TransportFragment fragment = new TransportFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transport, container, false);
        imgView = view.findViewById(R.id.imView);
        imgView2 = view.findViewById(R.id.imageView2);
        bringView = view.findViewById(R.id.imageView3);
        pickView = view.findViewById(R.id.imageView4);
        infoView = view.findViewById(R.id.imageView5);
        imgView2.setVisibility(View.INVISIBLE);
        bringView.setVisibility(View.INVISIBLE);
        pickView.setVisibility(View.INVISIBLE);
        infoView.setVisibility(View.INVISIBLE);

        getButton = view.findViewById(R.id.button);
        getButton.setOnClickListener(this);

        pickButton = view.findViewById(R.id.button2);
        pickButton.setOnClickListener(this);

        infoButton = view.findViewById(R.id.button3);
        infoButton.setOnClickListener(this);

        confirmButton = view.findViewById(R.id.button4);
        confirmButton.setOnClickListener(this);
        confirmButton.setVisibility(View.INVISIBLE);

        return view;
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button:
                imgView2.setVisibility(View.VISIBLE);
                confirmButton.setVisibility(View.VISIBLE);
                getButton.setVisibility(v.INVISIBLE);
                pickButton.setVisibility(v.INVISIBLE);
                infoButton.setVisibility(v.INVISIBLE);
                break;
            case R.id.button2:
                pickView.setVisibility(View.VISIBLE);
                getButton.setVisibility(v.INVISIBLE);
                pickButton.setVisibility(v.INVISIBLE);
                infoButton.setVisibility(v.INVISIBLE);
                break;
            case R.id.button3:
                infoView.setVisibility((View.VISIBLE));
                getButton.setVisibility(v.INVISIBLE);
                pickButton.setVisibility(v.INVISIBLE);
                infoButton.setVisibility(v.INVISIBLE);
                break;
            case R.id.button4:
                //imgView4.setVisibility(v.VISIBLE);
                bringView.setVisibility(View.VISIBLE);
                getButton.setVisibility(v.INVISIBLE);
                pickButton.setVisibility(v.INVISIBLE);
                infoButton.setVisibility(v.INVISIBLE);
                break;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
