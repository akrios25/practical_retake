package nyc.c4q.practicalretake;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by c4q on 1/16/18.
 */

public class Arithmetic_Fragment extends android.support.v4.app.Fragment {
    private View rootView;
    private TextView numberTextView;

    public Arithmetic_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        numberTextView = rootView.findViewById(R.id.fragment_text_view);

        Bundle bundle = getArguments();
        String numberFromBundle = bundle.getString("number");
        int n = Integer.valueOf(numberFromBundle) * 10;
        numberTextView.setText(String.valueOf(n));
        return rootView;
    }
}
