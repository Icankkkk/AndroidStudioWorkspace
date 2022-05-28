package com.icang.muhamadfaisal_p10;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ProgramFragment extends Fragment {

    public ProgramFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_program, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        String[] program = {"Program Logika", "Program Luas Segitiga"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, program);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(requireActivity().getApplicationContext(), program[position], Toast.LENGTH_SHORT).show();
                String temp = (String) listView.getAdapter().getItem(position);
//                Intent intent = new Intent(listView.getContext(), Logika.class);
//                listView.getContext().startActivity(intent);
//                Intent intent1 = new Intent(listView.getContext(), LuasSegitiga.class);
//                listView.getContext().startActivity(intent1);
                Intent intent;
                if (position == 0) {
                    intent = new Intent(listView.getContext(), Logika.class);
                    listView.getContext().startActivity(intent);
                }
                if (position == 1) {
                    intent = new Intent(listView.getContext(), LuasSegitiga.class);
                    listView.getContext().startActivity(intent);
                }
            }
        });
        return rootView;
    }
}
