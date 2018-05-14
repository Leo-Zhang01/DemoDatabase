package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> taskArrayList;
    private Context context;
    TextView tvId,tvTask,tvDate;
    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        taskArrayList = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.custom_listview, parent, false);

        tvId =  rowView.findViewById(R.id.id);
        tvTask =  rowView.findViewById(R.id.task);
        tvDate =  rowView.findViewById(R.id.date);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Task currentTask = taskArrayList.get(position);
        // Set the TextView to show the food
        String id = String.valueOf(currentTask.getId());
        tvId.setText(id);
        // Set the image to star or nostar accordingly
        tvDate.setText(currentTask.getDate());
        tvTask.setText(currentTask.getDescription());
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
