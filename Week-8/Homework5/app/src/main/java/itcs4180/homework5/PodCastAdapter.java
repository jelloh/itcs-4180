package itcs4180.homework5;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Devansh on 10/27/2017.
 */

public class PodCastAdapter extends ArrayAdapter<Podcast>{


    public PodCastAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Podcast> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Podcast podcast = getItem(position);

        ViewPoopy viewPoopy;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.podcast_viewer, parent, false);

            viewPoopy = new ViewPoopy();
            viewPoopy.txtTitle = convertView.findViewById(R.id.txtTitle);
            viewPoopy.imgSmall = convertView.findViewById(R.id.imgSmall);


            convertView.setTag(viewPoopy);


        } else {
            viewPoopy = (ViewPoopy) convertView.getTag();

        }

        viewPoopy.txtTitle.setText(podcast.title);

        if(podcast.imageURlsmall.equals("") || podcast.imageURlsmall == null){
            Log.d("demo", "THIS HAS HAPPENED");
        }else
            Picasso.with(getContext()).load(podcast.imageURlsmall).into(viewPoopy.imgSmall);


        return convertView;
    }
    // View Holder to cache the views
    private static class ViewPoopy{
        TextView txtTitle;
        ImageView imgSmall;
    }


}
