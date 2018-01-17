package nyc.c4q.practicalretake.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.practicalretake.ListActivity;
import nyc.c4q.practicalretake.Arithmetic_Fragment;
import nyc.c4q.practicalretake.Numbers;
import nyc.c4q.practicalretake.R;

/**
 * Created by c4q on 1/16/18.
 */

public class Numbers_ViewHolder extends RecyclerView.ViewHolder{
    private TextView numbers_textView;
    private Context context;

    public Numbers_ViewHolder(View itemView) {
        super(itemView);
        numbers_textView = itemView.findViewById(R.id.numbers_text_view);
    }

    public void onBind(final Numbers numbers) {
        context = itemView.getContext();
        numbers_textView.setText(String.valueOf(numbers.getN()));
        numbers_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMultiply();
            }
        });
    }

    public void fragmentMultiply() {
        Arithmetic_Fragment arithmeticFragment = new Arithmetic_Fragment();
        FragmentManager fragmentManager =((ListActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_number, arithmeticFragment).addToBackStack("number_rv");
        fragmentTransaction.commit();

        String numberToNewFragment = numbers_textView.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("number", numberToNewFragment);
        arithmeticFragment.setArguments(bundle);
    }
}
