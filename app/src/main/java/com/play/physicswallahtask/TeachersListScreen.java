package com.play.physicswallahtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeachersListScreen extends AppCompatActivity {

    RecyclerView differentTeachers;
    RequestQueue requestQueue;
    List<Teacher> teacherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_list_screen);

        //  https://my-json-server.typicode.com/easygautam/data/users

        // This will remove the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        differentTeachers = findViewById(R.id.teacherList);
        differentTeachers.setHasFixedSize(true);
        differentTeachers.setLayoutManager(new LinearLayoutManager(TeachersListScreen.this));

        requestQueue = VolleyPreview.getInstance(TeachersListScreen.this).getRequestQueue();

        teacherList = new ArrayList<>();

        // using the JSON url
        String url = "https://my-json-server.typicode.com/easygautam/data/users";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {

            for(int i = 0; i< response.length(); i++) {
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    String naming = jsonObject.getString("name").replace("[","").replace("]","");
                    String subject = jsonObject.getString("subjects").replace("[","").replace("]","");
                    String qualifi = jsonObject.getString("qualification").replace("[","").replace("]","");
                    String pic = jsonObject.getString("profileImage");

                    Teacher teacher = new Teacher(naming, subject, qualifi, pic);
                    teacherList.add(teacher);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                TeacherAdapter adapter = new TeacherAdapter(TeachersListScreen.this, teacherList);
                differentTeachers.setAdapter(adapter);

            }

        }, error -> Toast.makeText(TeachersListScreen.this, error.getMessage(), Toast.LENGTH_SHORT).show());

        requestQueue.add(jsonArrayRequest);

    }
}