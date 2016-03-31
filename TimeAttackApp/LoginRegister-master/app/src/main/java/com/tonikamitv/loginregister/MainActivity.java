package com.tonikamitv.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tonikamitv.loginregister.Constants.FIRST_COLUMN;
import static com.tonikamitv.loginregister.Constants.FOURTH_COLUMN;
import static com.tonikamitv.loginregister.Constants.SECOND_COLUMN;
import static com.tonikamitv.loginregister.Constants.THIRD_COLUMN;





public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    UserLocalStore userLocalStore;
    EditText etName, etAge, etUsername;
    Button bLogout;
    ListView lv;
    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

        ListView listView=(ListView)findViewById(R.id.listView1);

        //TODO - Custom adapter (to fetch customer data)
//        ListViewAdapter adapter=new ListViewAdapter(this, list);
//        listView.setAdapter(adapter);

        list = new ArrayList<HashMap<String,String>>();

        HashMap<String,String> temp = new HashMap<String, String>();
        temp.put(FIRST_COLUMN, "Angel Angelov");
        temp.put(SECOND_COLUMN, "Male");
        temp.put(THIRD_COLUMN, "22");
        temp.put(FOURTH_COLUMN, "1:22");
        list.add(temp);

        HashMap<String,String> temp2=new HashMap<String, String>();
        temp2.put(FIRST_COLUMN, "Boris Blagoev");
        temp2.put(SECOND_COLUMN, "Male");
        temp2.put(THIRD_COLUMN, "25");
        temp2.put(FOURTH_COLUMN, "1:25");
        list.add(temp2);

        HashMap<String,String> temp3=new HashMap<String, String>();
        temp3.put(FIRST_COLUMN, "Cristiana Craeva");
        temp3.put(SECOND_COLUMN, "Female");
        temp3.put(THIRD_COLUMN, "31");
        temp3.put(FOURTH_COLUMN, "1:45");
        list.add(temp3);

        HashMap<String,String> temp4=new HashMap<String, String>();
        temp4.put(FIRST_COLUMN, "Dimitar Dudev");
        temp4.put(SECOND_COLUMN, "Male");
        temp4.put(THIRD_COLUMN, "34");
        temp4.put(FOURTH_COLUMN, "1:47");
        list.add(temp4);

        HashMap<String,String> temp5=new HashMap<String, String>();
        temp5.put(FIRST_COLUMN, "Emiliqn Evstatiev");
        temp5.put(SECOND_COLUMN, "Male");
        temp5.put(THIRD_COLUMN, "30");
        temp5.put(FOURTH_COLUMN, "1:51");
        list.add(temp5);

        HashMap<String,String> temp6=new HashMap<String, String>();
        temp6.put(FIRST_COLUMN, "Filip F.");
        temp6.put(SECOND_COLUMN, "Male");
        temp6.put(THIRD_COLUMN, "20");
        temp6.put(FOURTH_COLUMN, "2:01");
        list.add(temp6);

        HashMap<String,String> temp7=new HashMap<String, String>();
        temp7.put(FIRST_COLUMN, "Gergana Gateva");
        temp7.put(SECOND_COLUMN, "Female");
        temp7.put(THIRD_COLUMN, "31");
        temp7.put(FOURTH_COLUMN, "2:45");
        list.add(temp7);

        HashMap<String,String> temp8=new HashMap<String, String>();
        temp8.put(FIRST_COLUMN, "Iliyana Ilieva");
        temp8.put(SECOND_COLUMN, "Female");
        temp8.put(THIRD_COLUMN, "31");
        temp8.put(FOURTH_COLUMN, "3:45");
        list.add(temp8);

        HashMap<String,String> temp9=new HashMap<String, String>();
        temp9.put(FIRST_COLUMN, "Milena Milcheva");
        temp9.put(SECOND_COLUMN, "Female");
        temp9.put(THIRD_COLUMN, "36");
        temp9.put(FOURTH_COLUMN, "3:45");
        list.add(temp9);

        ListViewAdapter adapter=new ListViewAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {
                int pos=position+1;
                Toast.makeText(MainActivity.this, Integer.toString(pos) + " Clicked", Toast.LENGTH_SHORT).show();
            }

        });
    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                Intent loginIntent = new Intent(this, Login.class);
                startActivity(loginIntent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {
//            displayUserDetails();


        }
    }

    private void displayListView() {

    }

    private boolean authenticate() {
        if (userLocalStore.getLoggedInUser() == null) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            return false;
        }
        return true;
    }

/*    private void displayUserDetails() {

        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
        etAge.setText(user.age + "");
    }*/
}
