package com.training.iqbaaaaalf.tasktutoryan001.view;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.training.iqbaaaaalf.tasktutoryan001.R;
import com.training.iqbaaaaalf.tasktutoryan001.model.DestinationModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DestinationDetailActivity extends AppCompatActivity {

    private String log = getClass().getSimpleName();

    private List<String> items = new ArrayList<>();
    private DestinationModel destinationData;

    private ImageView ivDetailed ;
    private TextView tvTitleDetailed ;
    private TextView tvDescriptionDetailed ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(log, "Success move to new activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_detail);

        ivDetailed = (ImageView)findViewById(R.id.iv_detailed);
        tvTitleDetailed = (TextView)findViewById(R.id.tv_title_detailed);
        tvDescriptionDetailed = (TextView)findViewById(R.id.tv_description_detailed);

        getData();
        displayData();

    }

    public void getData(){
        Intent intent = getIntent();
        destinationData = intent.getParcelableExtra("destinationDetail");
        Log.i(log, "Done retrieving data");
        Log.i(log, "Verifying .. ");
        Log.i(log, "Trip Name : " + destinationData.getTripName());
    }

    public void displayData(){
        Glide.with(this)
                .load(destinationData.getPhoto())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder_error)
                .centerCrop()
                .into(ivDetailed);

        tvTitleDetailed.setText(destinationData.getTripName());
        tvDescriptionDetailed.setText(destinationData.getDescription());
        Log.i(log, "Done displaying data");
    }
}
