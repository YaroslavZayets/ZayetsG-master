package fcdk.zayetsgram.utils;


import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import fcdk.zayetsgram.R;

public class BindingUtils {

    @BindingAdapter({"bind:url"})
    public static void setUrl(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(android.R.drawable.ic_delete)
                .transform(new CircularTransformation(0))
                .into(view);
    }
}
