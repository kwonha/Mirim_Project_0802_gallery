package kr.hs.emirim.xodusguckhan.mirim_project_0802_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int[] posterId = {R.drawable.post_01, R.drawable.post_02, R.drawable.post_03, R.drawable.post_04, R.drawable.post_05,
                      R.drawable.post_06, R.drawable.post_07, R.drawable.post_08, R.drawable.post_09, R.drawable.post_10
                      };
    String[] posterTitle = {"어벤져스_엔드게임", "센과 치히로의 행방불명", "부산행", "알라딘",
            "겨울왕국", "겨울왕국2", "미니언즈", "기생충", "라라랜드", "인터스텔라"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gallery gallery = findViewById(R.id.gallery);
        GalleryAdapter adapter = new GalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class GalleryAdapter extends BaseAdapter{
        Context context;
        public GalleryAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            Gallery.LayoutParams params = new Gallery.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView largeImgv = findViewById(R.id.imgv);
                    largeImgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    largeImgv.setImageResource(posterId[pos]);
                    Toast t = new Toast(context);
                    View toastView = View.inflate(context, R.layout.toast, null);
                    TextView textTitle = toastView.findViewById(R.id.text_title);
                    textTitle.setText(posterTitle[pos]);
                    t.setView(toastView);
                    t.setDuration(Toast.LENGTH_SHORT);
                    t.show();
                    return false;
                }
            });

            return imgv;
        }
    }
}